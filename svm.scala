//Se importa la libreria correspondiente
import org.apache.spark.ml.classification.LinearSVC
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.feature.{VectorAssembler, StringIndexer, VectorIndexer, OneHotEncoder}
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.Pipeline
import org.apache.spark.mllib.evaluation.MulticlassMetrics

val spark = SparkSession.builder().getOrCreate()

val t1 = System.nanoTime

val data  = spark.read.option("header","true").option("inferSchema", "true").option("delimiter", ",").format("csv").load("bank.csv")


// columns: age, job, marital, education, default, housing, loan, poutcome, all social and economic
val data_select = data.select($"age", $"job", $"marital", $"education", $"default", $"housing", $"loan", $"poutcome", $"emp_var_rate", $"cons_price_idx", $"cons_conf_idx", $"euribor3m", $"nr_employed", $"y")

val labelIndexer = new StringIndexer().setInputCol("y").setOutputCol("label")

val labelfit = labelIndexer.fit(data_select)
val df = labelfit.transform(data)


val jobIndexer = new StringIndexer().setInputCol("job").setOutputCol("jobIndex")
val maritalIndexer = new StringIndexer().setInputCol("marital").setOutputCol("maritalIndex")
val eduIndexer = new StringIndexer().setInputCol("education").setOutputCol("eduIndex")
val defaultIndexer = new StringIndexer().setInputCol("default").setOutputCol("defIndex")
val housingIndexer = new StringIndexer().setInputCol("housing").setOutputCol("housIndex")
val loanIndexer = new StringIndexer().setInputCol("loan").setOutputCol("loanIndex")
val poutIndexer = new StringIndexer().setInputCol("poutcome").setOutputCol("poutIndex")


val jobEncoder = new OneHotEncoder().setInputCol("jobIndex").setOutputCol("jobVec")
val maritalEncoder = new OneHotEncoder().setInputCol("maritalIndex").setOutputCol("marVec")
val eduEncoder = new OneHotEncoder().setInputCol("eduIndex").setOutputCol("eduVec")
val defEncoder = new OneHotEncoder().setInputCol("defIndex").setOutputCol("defVec")
val housEncoder = new OneHotEncoder().setInputCol("housIndex").setOutputCol("housVec")
val loanEncoder = new OneHotEncoder().setInputCol("loanIndex").setOutputCol("loanVec")
val poutEncoder = new OneHotEncoder().setInputCol("poutIndex").setOutputCol("poutVec")

val assembler = (new VectorAssembler().setInputCols(Array("age","jobVec", "marVec","eduVec","defVec","housVec","loanVec", "poutVec", "emp_var_rate", 
"cons_price_idx", "cons_conf_idx", "euribor3m", "nr_employed")).setOutputCol("features"))

val Array(training, test) = df.randomSplit(Array(0.7, 0.3), seed = 12345)

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)



val pipeline = new Pipeline().setStages(Array(jobIndexer,maritalIndexer,eduIndexer,defaultIndexer,housingIndexer,loanIndexer,poutIndexer,
jobEncoder,maritalEncoder,eduEncoder,defEncoder,housEncoder,loanEncoder,poutEncoder ,assembler,lsvc))

// Se construye el modelo
//val lsvcModel = lsvc.fit(training)

val model = pipeline.fit(training)
val results = model.transform(test)


val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
val metrics = new MulticlassMetrics(predictionAndLabels)

// Se imprime los coeficientes e intercepta para el compensador estatico lineal
//println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")

println("Confusion matrix:")
println(metrics.confusionMatrix)

println("Accuracy: " + metrics.accuracy) 
println(s"Test Error = ${(1.0 - metrics.accuracy)}")

// memory info
val mb = 1024*1024
val runtime = Runtime.getRuntime
println("ALL RESULTS IN MB")
println("** Used Memory:  " + (runtime.totalMemory - runtime.freeMemory) / mb)
println("** Free Memory:  " + runtime.freeMemory / mb)
println("** Total Memory: " + runtime.totalMemory / mb)
println("** Max Memory:   " + runtime.maxMemory / mb)

val duration = (System.nanoTime - t1) / 1e9d
//Importar sesion SparkSession libreria LogisticRegression
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession

//Utilizar Error reporting
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

//Crear sesion de Spark
val spark = SparkSession.builder().getOrCreate()

//Cargar archivo advertising.csv
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")

//Imprimir el esquema del archivo adverstising.csv
data.printSchema()


// Imprimir 1 renglon
data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}


////////////////////////////////////////////////////
//// Preparar el DataFrame para Machine Learning ////
//////////////////////////////////////////////////


// Renombrar Clicked on Ad a Label tomando las columnas "Daily Time Spent on Site","Age","Area Income","Daily Internet Usage","Timestamp","Male"
val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")

//Crear nueva columna Hora
val timedata = data.withColumn("Hour",hour(data("Timestamp")))


//Importar VectorAssembler y Vector
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors

// Cree un nuevo objecto VectorAssembler llamado assembler para los feature
val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))



// Utilizar randomSplit para crear datos de train y test divididos en 70/30
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)


///////////////////////////////
// Configure un Pipeline ///////
/////////////////////////////

//Importar Pipeline 
import org.apache.spark.ml.Pipeline

//Crear objeto llamado lr de Logistic Regression
val lr = new LogisticRegression()

//Crear nuevo pipeline de los elementos Assembler y lr
val pipeline = new Pipeline().setStages(Array(assembler, lr))

//Ajustar Fit Pipeline para el conjunto training
val model = pipeline.fit(training)

//Tomar resultados en el conjunto Test con transform
val results = model.transform(test)

////////////////////////////////////
//// Evaluacion del modelo /////////////
//////////////////////////////////

//Importar evaluacion y multiclassmetrics
import org.apache.spark.mllib.evaluation.MulticlassMetrics

// Convertir resultados de test en RDD utilizando .as y .rdd
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd

// Inicializar objeto MulticlassMetrics
val metrics = new MulticlassMetrics(predictionAndLabels)

//Imprimir Confusion Matrix
println("Confusion matrix:")
println(metrics.confusionMatrix)

//Sacar exactitud de metrics
metrics.accuracy


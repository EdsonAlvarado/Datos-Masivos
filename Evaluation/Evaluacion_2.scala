// (a) Se importan las librerias correspondientes
import org.apache.spark.ml.feature.{StringIndexer,VectorIndexer,IndexToString,VectorAssembler}
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Se crea sesion de Spark
import org.apache.spark.sql.SparkSession

// 1. Se carga el archivo "iris.csv" para la practica
val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")

// 2. Se sacan los nombres de las columnas
data.columns

// 3. Se saca el esquema para saber mas sobre el archivo
data.printSchema()

// 4. Imprime 5 columnas
data.select($"Sepal_Length", $"Sepal_Width", $"Petal_Length", $"Petal_Width", $"Species").show

// 5. Se usa describe para saber mas sobre el dataframe
data.describe()

// 6. Se empieza la transformacion de los datos categoricos a numericos 
val assembler = new VectorAssembler().setInputCols(Array("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features")

val features = assembler.transform(data)
features.show()

// Se incluye todo en un conjunto de datos para incluir todos los labels y se imprimen
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(features)
println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")

val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(features)

// Se separan las caracteristicas en un 70% de entranimiento y 30% de prueba
val splits = features.randomSplit(Array(0.7, 0.3))
val trainingData = splits(0)
val testData = splits(1)

// Se crean las capas de la red
val layers = Array[Int](4, 5, 5, 3)

// 7. Construya el modelos de clasificación y explique su arquitectura.
// Se crea el entrenador del modelo y se le dan parametros
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(System.currentTimeMillis).setMaxIter(200)

// Se convierten de nuevo los indices a su forma original para poder utilizarlos en la prediccion
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Se crea el pipeline para el modelo
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, trainer, labelConverter))

// se entrena el modelo
val model = pipeline.fit(trainingData)

// Se hacen las predicciones con el modelo y mostramos algunos resultados
val predictions = model.transform(testData)
predictions.show(20)


//8. Imprima los resultados del modelo
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println("Test Error = " + (1.0 - accuracy))
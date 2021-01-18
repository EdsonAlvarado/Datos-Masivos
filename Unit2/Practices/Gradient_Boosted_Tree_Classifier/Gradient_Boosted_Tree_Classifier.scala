// Se importan las librerias correspondientes para la realizacion de esta practica
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

// Se crea el valor "data" y se carga el archivo correspondiente
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Se añade el metada a la columna label
// Encaja el dataset para incluir todos los labels en el index
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)

// Automaticamente identifica categoricamente las caracteristicas y el index
// Se establece maxCategories para que las entidades con > 4 valores distintos se traten como continuas
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Separa "data" en "training" y realiza prueba (30% de prueba) 
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Modelo Gradient Boosted Tree
val gbt = new GBTClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setMaxIter(10).setFeatureSubsetStrategy("auto")

// Convertir los labels indexados a su orignal label
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Encadena los indexers y el modelo GBT en un Pipeline
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))

// Se entrena el modelo ajustando los datos de entrenamiento del pipeline
val model = pipeline.fit(trainingData)

// Se realizan las predicciones
val predictions = model.transform(testData)

// Se seleccionan las filas a mostrar
predictions.select("predictedLabel", "label", "features").show(5)

// Select (prediction, true label) and compute test error.
// Se selecciona la prediccion como tambien el label verdadero y se calcula la prueba de error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1.0 - accuracy}")

// Imprime los resultados
val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
println(s"Learned classification GBT model:\n ${gbtModel.toDebugString}")
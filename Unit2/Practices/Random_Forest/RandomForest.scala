
// Importamos las librerias de Random Forest y demas que ocupemos
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{RandomForestClassificationModel, RandomForestClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}

// Load and parse the data file, converting it to a DataFrame.
// Cargamos nuestro archivo de datos
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Index labels, adding metadata to the label column.
// Fit on whole dataset to include all labels in index.

// Se indexan las labels y se ajusta el dataset para incluir todas las labels
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)

// Automatically identify categorical features, and index them.
// Set maxCategories so features with > 4 distinct values are treated as continuous.

// Se identifican las caracteristicas categoricas y se indexan, despues se establece que maxCategories sea 4
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)

// Split the data into training and test sets (30% held out for testing).
// Se establecen los datos para entrenamiento y para testing
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))

// Train a RandomForest model.
// Aqui se entrena un modelo de Random Forest utilizando los indices de labels y features anteriormente creados
val rf = new RandomForestClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setNumTrees(10)

// Convert indexed labels back to original labels.
// Regresamos las labels indexadas a su estado original
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)

// Chain indexers and forest in a Pipeline.
// Metemos los indices y el modelo a un pipeline
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, rf, labelConverter))

// Train model. This also runs the indexers.
// Aqui entrenamos el modelo y ejecutamos los indices
val model = pipeline.fit(trainingData)

// Make predictions.
// Se realizan las predicciones utilizando los datos de prueba
val predictions = model.transform(testData)

// Select example rows to display.
// Aqui mostramos algunas filas de nuestros datos
predictions.select("predictedLabel", "label", "features").show(5)

// Select (prediction, true label) and compute test error.
// Mostramos la prediccion y calculamos el error de nuestro algoritmo
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

// por ultimo imprimimos una instancia de nuestro modelo.
val rfModel = model.stages(2).asInstanceOf[RandomForestClassificationModel]
println(s"Learned classification forest model:\n ${rfModel.toDebugString}")
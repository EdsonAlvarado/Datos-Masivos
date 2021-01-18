// Importamos las librerias del clasificador

import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Cargamos los datos de nuestro archivo
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

// Partimos los datos en una razon de 60% para entrenamiento y 40% para pruebas con una semilla
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)

// Se crean las capas de la red, tenemos una capa de entrada de 4,
// 2 capas ocultas: una de 5 y otra de 4, por ultimo nuestra capa
// de salida es de 3
val layers = Array[Int](4, 5, 4, 3)


// Creamos en entrenador del modelo y le damos parametros
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)

// Entrenamos al modelo...
val model = trainer.fit(train)

// Calculamos la precisión del modelo con el set de pruebas
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// Aqui imprimimos el valor de precisión
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
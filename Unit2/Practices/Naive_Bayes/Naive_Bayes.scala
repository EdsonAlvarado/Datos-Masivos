// Se importa las librerias correspondientes 
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Se crea un valor y se carga el archivo correspondiente para la practica 
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")

// Separa los datos en training y hace el test (30% tiende al testing)
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)

// Se entrena el modelo NaiveBayes
val model = new NaiveBayes().fit(trainingData)

// Se selecciona filas de ejemplo para mostrar
val predictions = model.transform(testData)
predictions.show()

// Selecciona (la prediccion, label verdadero) y calcula el test de error
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)

// Imprime la precision 
println(s"Test set accuracy = $accuracy")

// Importamos las librerias de clasificacion y multiclases
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

// Cargamos nuestro archivo de datos
val inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")

// Se hace el split de los datos, (80% entrenamiento, 20% de prueba)
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))

// Se crea la instancia del clasificador, con una interacion de 10 y se ajusta.
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)

// Se crea una instancia del modelo One vs Rest 
val ovr = new OneVsRest().setClassifier(classifier)

// Se entrena el modelo
val ovrModel = ovr.fit(train)

// Se crea la variable predictions y se aplica un transform a los datos de prueba
val predictions = ovrModel.transform(test)

// Se crea el evaluador del clsificador y se le asigna el nombre accuracy
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")

// Se calcula la precision del evaluador y se imprime el calculo del error
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")
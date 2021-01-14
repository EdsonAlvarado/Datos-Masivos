//Se importa la libreria correspondiente
import org.apache.spark.ml.classification.LinearSVC

// Se carga la informacion 
val training = spark.read.format("libsvm").load("sample_libsvm_data.txt")

val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)

// Se construye el modelo
val lsvcModel = lsvc.fit(training)

// Se imprime los coeficientes e intercepta para el compensador estatico lineal
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")
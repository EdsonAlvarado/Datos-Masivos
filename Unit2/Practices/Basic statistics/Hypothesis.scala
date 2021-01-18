//Hypothesis

//Se importa las librerias correspondientes para la practica
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest

//Se crea un valor llamado "data" que es igual a la secuencia de los vectores establecidos
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)

//Se crea un data frame de la columna "label" y "features"
val df = data.toDF("label", "features")

// Se declara la variable chi para la utilizacion de "Chi cuadrada" del dataframe declarado anteriormente
val chi = ChiSquareTest.test(df, "features", "label").head

// Se imprimen los resultados obtenidos
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")
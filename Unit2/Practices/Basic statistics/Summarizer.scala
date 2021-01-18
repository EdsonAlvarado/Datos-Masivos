//Summarizer

//Se importan las librerias correspondientes para las practicas
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer

//Se crea un valor llamado "data" que es igual a la secuencia de los vectores declarados
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)

//Se crea un data frame utilizando el valor declarado anteriormente llamado "data" con las columnas "features" y "weight"
val df = data.toDF("features", "weight")

/*Se declaran los valores "meanVal" y "varianceVal" para sacar lo que es la media y la varianza utilizando las columnas correspondientes e
imprime el resultado con peso*/
val (meanVal, varianceVal) = df.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")

/*Se declaran los valores "meanVal" y "varianceVal" para sacar lo que es la media y la varianza utilizando las columnas correspondientes e
imprime el resultado sin peso*/
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features")).as[(Vector, Vector)].first()
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
//Correlation

//Se importa las librerias correspondientes para la practica
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row


//Se declara un valor llamado "data" 
val data = Seq(
  Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)

// Se crea un nuevo data frame usando el valor "data" hacia "features" 
val df = data.map(Tuple1.apply).toDF("features")

//Imprime la matriz del coeficiente 1 de la correlacion de Pearson
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
println(s"Pearson correlation matrix:\n $coeff1")

//Imprime la matriz del coeficiente 2 de la correlacion de Spearman
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
println(s"Spearman correlation matrix:\n $coeff2")
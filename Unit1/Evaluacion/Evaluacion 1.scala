//1 
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()

//2
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")

//3 
df.columns

//4
df.printSchema()

//5
df.select($"Date",$"Open",$"High",$"Low",$"Close").show

//6
df.describe().show

//7
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))

//8
import spark.implicits._
val daydf = df.withColumn("Dayofmonth",dayofmonth(df("Date")))
val daymax = daydf.select($"Dayofmonth",$"Close").orderBy("Dayofmonth")
daymax.sort(desc("Close")).show

//9
/*The column Close references when the shares of stock Close*/

//10
df.select(max("Volume")).show
df.select(min("Volume")).show

//11

// a.
df.filter($"Close" < 600).count()

// b.
(df.filter($"High" > 500).count()*100)/df.count().toDouble

// c.
df.select(corr("High", "Volume")).show()

// d.

val dfy = df.withColumn("Year", year(df("Date")))
val ymax = dfy.select($"Year", $"High").groupBy("Year").max().show()

// e.

val dfm = df.withColumn("Month", month(df("Date")))
val mavg = dfm.select($"Month", $"Close").groupBy("Month").mean().show()
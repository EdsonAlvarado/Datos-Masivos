import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

//1 Returns the first n rows in the dataset
df.take(n)

//2 Computes statistics for columns, example df.summary().show()
df.summary()

//3 Returns rows as list
df.takeAsList(n)

//4 Returns an array of the dataset columns
df.columns

//5 Returns an array of the column names an their data types
df.dtypes

//6 Returns true if the dataset is empty
df.isEmpty

//7 Returns the unique rows of the dataset
df.distinct.show()

//8 Returns a new dataset with the first n rows, example: val df2 = df.limit(10) 
df.limit(n)

//9 Prints the plans (logical and physical) to the console for debugging purposes.
df.explain()

//10 Order by the column selected.
df.orderBy("Close").show

//11 Get the variance of the column.
df.select(variance("Low")).show()

//12 Get the min value of the column High.
df.select(min("High")).show

//13 Get the standard deviation.
df.select(stddev("High")).show()

//14 Prints the schema to the console in a nice tree format.
df.printSchema()

//15 Get the kurtosis of the column.
df.select(kurtosis("High")).show()
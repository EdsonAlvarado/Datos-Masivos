import org.apache.spark.sql.SparkSession

val spark = SparkSession.builder().getOrCreate()

val df = spark.read.option("header", "true").option("inferSchema","true")csv("CitiGroup2006_2008")

//Returns the first n rows in the dataset
df.take(n)

//Computes statistics for columns, example df.summary().show()
df.summary()

//Returns rows as list
df.takeAsList(n)

//returns an array of the dataset columns
df.columns

//returns an array of the column names an their data types
df.dtypes

//Returns true if the dataset is empty
df.isEmpty

//returns the unique rows of the dataset
df.distinct.show()

//returns a new dataset with the first n rows, example: val df2 = df.limit(10) 
df.limit(n)
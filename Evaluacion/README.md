# Evaluation 1

### Exercise 1
> Create a session
//1 
```
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
```

### Exercise 2
> Load the Netflix csv
```
//2
val df = spark.read.option("header", "true").option("inferSchema","true")csv("Netflix_2011_2016.csv")
```

### Exercise 3
> Take the names of the columns
//3 
df.columns

### Exercise 4
> Print the Schema
```
//4
df.printSchema()
```

### Exercise 5
> Print the first five columns
```
//5
df.select($"Date",$"Open",$"High",$"Low",$"Close").show
```

### Exercise 6
> Use describe to learn of DataFrame
```
//6
df.describe().show
```

### Exercise 7
> Create a new DataFrame with new column and divide 2 columns for the new column
```
//7
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))
```

### Exercise 8
> The day of Close with max value
```
//8
import spark.implicits._
val daydf = df.withColumn("Dayofmonth",dayofmonth(df("Date")))
val daymax = daydf.select($"Dayofmonth",$"Close").orderBy("Dayofmonth")
daymax.sort(desc("Close")).show
```

### Exercise 9 
> The meaning of the column "Close"
```
//9
/*The column Close references when the shares of stock Close*/
```

### Exercise 10
> The min and max of the column "Volume"
```
//10
df.select(max("Volume")).show
df.select(min("Volume")).show
```

### Exercise 11
> This Exercise consists in several points...

### a. 
> How many days the column "Close" is less than $600?
```
df.filter($"Close" < 600).count()
```

### b. 
> What percentage of the time the column "High" was greater than $500?
```
(df.filter($"High" > 500).count()*100)/df.count().toDouble
```

### c. 
> What is the pearson correlation between the columns "High" and "Volume"?
```
df.select(corr("High", "Volume")).show()
```

### d. 
> What is the max value of the column "High" by year?
```
val dfy = df.withColumn("Year", year(df("Date")))
val ymax = dfy.select($"Year", $"High").groupBy("Year").max().show()
```

### e. 
> What is the average of the column "Close" for each month?
```
val dfm = df.withColumn("Month", month(df("Date")))
val mavg = dfm.select($"Month", $"Close").groupBy("Month").mean().show()
```
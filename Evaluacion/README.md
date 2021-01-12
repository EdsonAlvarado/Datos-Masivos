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

> Here we only need to call the function .columns

```
//3 
df.columns
```

### Exercise 4
> Print the Schema

> Here we only need to use the printSchema function 

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

> Here we use the withColumn function and give as parameters the name of the new column and an operation between the columns
```
//7
val df2 = df.withColumn("HV Ratio", df("High")/df("Volume"))
```

### Exercise 8
> The day of Close with max value

> We create a new dataframe with the day of the date, then we select our columns and order them and finally make a descendant sort of the data of the column close

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

> Here we only use the max and min functions using a select
```
//10
df.select(max("Volume")).show
df.select(min("Volume")).show
```

### Exercise 11
> This Exercise consists in several points...

### a. 
> How many days the column "Close" is less than $600?

> Here we use the filter function where we specify a column and request the data where the value is less than 600 and then count all the matching results
```
df.filter($"Close" < 600).count()
```

### b. 
> What percentage of the time the column "High" was greater than $500?

> Here we filter the results where high is greater than 500, count the results and make some operations to determine the percentage
```
(df.filter($"High" > 500).count()*100)/df.count().toDouble
```

### c. 
> What is the pearson correlation between the columns "High" and "Volume"?

> This is easy we only need a select, the function corr (pearson correlation) and give as arguments the columns High and Volume
```
df.select(corr("High", "Volume")).show()
```

### d. 
> What is the max value of the column "High" by year?

> Here we need to create a new dataframe adding the year of the date as a new column, then we select the columns Year and High, group by Year and use the max function
```
val dfy = df.withColumn("Year", year(df("Date")))
val ymax = dfy.select($"Year", $"High").groupBy("Year").max().show()
```

### e. 
> What is the average of the column "Close" for each month?

> This is resolved the same way as the prior exercise, the only diferent thing is that we take the month of the date as a new column for the dataframe
```
val dfm = df.withColumn("Month", month(df("Date")))
val mavg = dfm.select($"Month", $"Close").groupBy("Month").mean().show()
```

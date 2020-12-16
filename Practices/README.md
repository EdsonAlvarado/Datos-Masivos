## Practice 1

First we import the Linear Regression library

```
import org.apache.spark.ml.regression.LinearRegression
```

This code is used to allow us to configure errors
```
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR
```

Here we star a new spark session
```
import org.apache.spark.sql.SparkSession
val spark = SparkSession.builder().getOrCreate()
```

Then we read the data file
```
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("Clean-Ecommerce.csv")
```

The next step is print the schema of the dataset
```
data.printSchema
```

And here we can print 1 row of our dataframe
```
data.head(1)
```

Here we need to transform the dataframe to the form of (label, features)

To do this we are gonna need the next 2 libraries

```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```

Then we rename the Yearly Amount Spent column as label.
Only the numeric data is needed here, and we rename all this as df

```
val df = data.select(data("Yearly Amount Spent").as("label"), $"Avg Session Length", $"Time on App", $"Time on Website", $"Length of Membership")
```

The next step is tranforms the input values to a vector for this we re gonna use 
the VectorAssembler to transform the input columns to a single column named features
we are naming this as assembler

```

val assembler = new VectorAssembler().setInputCols(Array("Avg Session Length", "Time on App", "Time on Website", "Length of Membership")).setOutputCol("features")
```

Here we transform our dataframe using assembler to 2 columns: labels and features
```
val output = assembler.transform(df).select($"label", $"features")
```


Here we're creating an object of Linear Regression
```
val lr = new LinearRegression()
```

Here we are fitting the model to our data and naming it lrModelo
```
val lrModelo = lr.fit(output)
```


Then we print th coefficients and intercept for Linear Regression


We need to use the training set to print some metrics

we create and object named trainingSummary to use the summary method

```
val trainingSummary = lrModelo.summary
```

Finally we print the results of residuals, RMSE, MSE, and R^2 .
```
trainingSummary.residuals.show()
trainingSummary.predictions.show()
trainingSummary.r2
trainingSummary.rootMeanSquaredError
trainingSummary.meanSquaredError
```

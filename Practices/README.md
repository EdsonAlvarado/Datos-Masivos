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


## Practice 2

First we import some libraries
```
Importar sesion SparkSession libreria LogisticRegression
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.sql.SparkSession
```

This code is used to allow us to configure errors
```
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

Here we star a new spark session
```
val spark = SparkSession.builder().getOrCreate()
```

We load the file advertising.csv
```
val data  = spark.read.option("header","true").option("inferSchema", "true").format("csv").load("advertising.csv")
```

We print the schema of adverstising.csv
```
data.printSchema()
```


Here we are printing 1 row using head and other code using the columns and data of the file
```
data.head(1)

val colnames = data.columns
val firstrow = data.head(1)(0)
println("\n")
println("Example data row")
for(ind <- Range(1, colnames.length)){
    println(colnames(ind))
    println(firstrow(ind))
    println("\n")
}
```

Configuring the dataframe for Machine Learning


Rename Clicked on Ad to Label using the columns "Daily Time Spent on Site","Age","Area Income","Daily Internet Usage","Timestamp","Male"
```
val logregdata = timedata.select(data("Clicked on Ad").as("label"), $"Daily Time Spent on Site", $"Age", $"Area Income", $"Daily Internet Usage", $"Hour", $"Male")
```


Here we create a new hour column
```
val timedata = data.withColumn("Hour",hour(data("Timestamp")))
```


Here we import VectorAssembler and Vectors
```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```

Here we create a new VectorAssembler object named assembler to use the features
```
val assembler = (new VectorAssembler()
                  .setInputCols(Array("Daily Time Spent on Site", "Age","Area Income","Daily Internet Usage","Hour","Male"))
                  .setOutputCol("features"))
```



Here we use randomSplit to create 2 sets of data: training and test
```
val Array(training, test) = logregdata.randomSplit(Array(0.7, 0.3), seed = 12345)
```


Configure a Pipeline 


We import the pipeline
```
import org.apache.spark.ml.Pipeline
```

We create and object named lr of Logistic Regression
```
val lr = new LogisticRegression()
```

Here we create a new pipeline using assembler and lr
```
val pipeline = new Pipeline().setStages(Array(assembler, lr))
```

Here we are fitting the pipeline for the training set
```
val model = pipeline.fit(training)
```

We take some results using transform on the test set
```
val results = model.transform(test)
```

Model evaluation 


Here we import the next library
```
import org.apache.spark.mllib.evaluation.MulticlassMetrics
```

And convert the test results to RDD using .as and .rdd
```
val predictionAndLabels = results.select($"prediction",$"label").as[(Double, Double)].rdd
```


Here we initialize the MulticlassMetrics
```
val metrics = new MulticlassMetrics(predictionAndLabels)
```

Then print the Confusion Matrix
```
println("Confusion matrix:")
println(metrics.confusionMatrix)
```
And we meassure the accuracy
```
metrics.accuracy
```

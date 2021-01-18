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


## Practice Basic Statistics
### Correlation

We import the necesary libraries 

```
import org.apache.spark.ml.linalg.{Matrix, Vectors}
import org.apache.spark.ml.stat.Correlation
import org.apache.spark.sql.Row
```


We create a new value name data that contains some vectors

```
val data = Seq(
  Vectors.sparse(4, Seq((0, 1.0), (3, -2.0))),
  Vectors.dense(4.0, 5.0, 0.0, 3.0),
  Vectors.dense(6.0, 7.0, 0.0, 8.0),
  Vectors.sparse(4, Seq((0, 9.0), (3, 1.0)))
)
```

Then we create a new dataframe using the data column to features
```
val df = data.map(Tuple1.apply).toDF("features")
```

Here we print the matrix of the first coeficient of Person correlation
```
val Row(coeff1: Matrix) = Correlation.corr(df, "features").head
println(s"Pearson correlation matrix:\n $coeff1")
```

And here we print the matrix of the second coeficient of Person correlation
```
val Row(coeff2: Matrix) = Correlation.corr(df, "features", "spearman").head
println(s"Spearman correlation matrix:\n $coeff2")
```

### Hypothesis

As usual the first thing is the libraries 
```
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.ChiSquareTest
```

We create a data value that holds all the following vectors
```
val data = Seq(
  (0.0, Vectors.dense(0.5, 10.0)),
  (0.0, Vectors.dense(1.5, 20.0)),
  (1.0, Vectors.dense(1.5, 30.0)),
  (0.0, Vectors.dense(3.5, 30.0)),
  (0.0, Vectors.dense(3.5, 40.0)),
  (1.0, Vectors.dense(3.5, 40.0))
)
```

We create a new dataframe using label and features
```
val df = data.toDF("label", "features")
```

We declare a variable named chi to user the ChiSquareTest
```
val chi = ChiSquareTest.test(df, "features", "label").head
```

And we print the results
```
println(s"pValues = ${chi.getAs[Vector](0)}")
println(s"degreesOfFreedom ${chi.getSeq[Int](1).mkString("[", ",", "]")}")
println(s"statistics ${chi.getAs[Vector](2)}")
```

### Summarizer

We import our libraries
```
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.ml.stat.Summarizer
```

We create a data value holding 2 vectors
```
val data = Seq(
  (Vectors.dense(2.0, 3.0, 5.0), 1.0),
  (Vectors.dense(4.0, 6.0, 7.0), 2.0)
)
```

We create a new dataframe using features and weight
```
val df = data.toDF("features", "weight")
```


We declare the values "meanVal" and "varianceVal" to calculate the mean and the variance using the corresponding columns and printing the result using weight
```
val (meanVal, varianceVal) = df.select(metrics("mean", "variance").summary($"features", $"weight").as("summary")).select("summary.mean", "summary.variance").as[(Vector, Vector)].first()
println(s"with weight: mean = ${meanVal}, variance = ${varianceVal}")
```


We declare the values "meanVal" and "varianceVal" to calculate the mean and the variance using the corresponding columns and printing the result without weight
```
val (meanVal2, varianceVal2) = df.select(mean($"features"), variance($"features")).as[(Vector, Vector)].first()
println(s"without weight: mean = ${meanVal2}, sum = ${varianceVal2}")
```

## Practice Decision Tree

First we import the following libraries
```
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassificationModel
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
```

We create a spark session
```
import org.apache.spark.sql.SparkSession
```

We create the object of our program
```
object DecisionTree {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder
      .appName("dtree")
      .getOrCreate()
 ```

Load the data stored in LIBSVM format as a DataFrame.
```
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```

Index labels, adding metadata to the label column.
Fit on whole dataset to include all labels in index.
```
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
```
Automatically identify categorical features, and index them.
```
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```

Split the data into training and test sets (30% held out for testing).
```
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```

Train a DecisionTree model.
```
val dt = new DecisionTreeClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures")
```

Convert indexed labels back to original labels.
```
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
```

Chain indexers and tree in a Pipeline.
```
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, dt, labelConverter))
```

Train model. This also runs the indexers.
```
val model = pipeline.fit(trainingData)
```

Make predictions.
```
val predictions = model.transform(testData)
```

Select example rows to display.
```
predictions.select("predictedLabel", "label", "features").show(10)
```

Select (prediction, true label) and compute test error.
```
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${(1.0 - accuracy)}")

val treeModel = model.stages(2).asInstanceOf[DecisionTreeClassificationModel]
println(s"Learned classification tree model:\n ${treeModel.toDebugString}")

  }
}
```

## Practice Gradient Boosted Tree Classifier

We import our libraries
```
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.{GBTClassificationModel, GBTClassifier}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{IndexToString, StringIndexer, VectorIndexer}
```

Here we load our data file
```
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
```

Here we add metadata to the label column and fit the values in indexedLabel
```
val labelIndexer = new StringIndexer().setInputCol("label").setOutputCol("indexedLabel").fit(data)
```

Here the categories are identified and are seted to 4 categories
```
val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(data)
```

We split the data in training and test (70%, 30%)
```
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3))
```
Here we create our GBt model
```
val gbt = new GBTClassifier().setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setMaxIter(10).setFeatureSubsetStrategy("auto")
```

And here we convert the indexes to its original values
```
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
```

We chain the indexers and the model to a pipeline
```
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, gbt, labelConverter))
```

The model is trained using the training data
```
val model = pipeline.fit(trainingData)
```

we make de predictions
```
val predictions = model.transform(testData)
```

Here we select our columns and the number of rows to show
```
predictions.select("predictedLabel", "label", "features").show(5)
```

Select (prediction, true label) and compute test error.

```
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1.0 - accuracy}")
```

Finally we print the results
```
val gbtModel = model.stages(2).asInstanceOf[GBTClassificationModel]
println(s"Learned classification GBT model:\n ${gbtModel.toDebugString}")
```

## Practice Multilayer Perceptron Classifier

Import the libraries 
```
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```

Load the file
```
val data = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
```

Split the data, 60% of training and 40% of test with seed
```
val splits = data.randomSplit(Array(0.6, 0.4), seed = 1234L)
val train = splits(0)
val test = splits(1)
```

Make the grid layers, input layer of 4, 2 hidden layers: one of 5 and the other of 4, the final layer of 3
```
val layers = Array[Int](4, 5, 4, 3)
```

Create the model of trainer and give parameters
```
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setBlockSize(128).setSeed(1234L).setMaxIter(100)
```

Train the model
```
val model = trainer.fit(train)
```

Calculate the accuracy of the model
```
val result = model.transform(test)
val predictionAndLabels = result.select("prediction", "label")
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
```

Print the result of accuracy
```
println(s"Test set accuracy = ${evaluator.evaluate(predictionAndLabels)}")
```

## Practice Linear Support Vector Machine

Import the libraries
```
import org.apache.spark.ml.classification.LinearSVC
```

Load the file
```
val training = spark.read.format("libsvm").load("sample_libsvm_data.txt")
val lsvc = new LinearSVC().setMaxIter(10).setRegParam(0.1)
```

Create the model
```
val lsvcModel = lsvc.fit(training)
```

Print the coefficients and intercepts for linear static compensator
```
println(s"Coefficients: ${lsvcModel.coefficients} Intercept: ${lsvcModel.intercept}")
```

## Practice One vs Rest

Import the libraries
```
import org.apache.spark.ml.classification.{LogisticRegression, OneVsRest}
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```

Load the file
```
val inputData = spark.read.format("libsvm").load("sample_multiclass_classification_data.txt")
```

Split the data, 80% of training and 20% of test
```
val Array(train, test) = inputData.randomSplit(Array(0.8, 0.2))
```

Create the instance of the classificator with the interaction of 10 and adjust
```
val classifier = new LogisticRegression().setMaxIter(10).setTol(1E-6).setFitIntercept(true)
```

Create the instance of the model One vs Rest
```
// Se crea una instancia del modelo One vs Rest 
val ovr = new OneVsRest().setClassifier(classifier)
```

Train the model
```
val ovrModel = ovr.fit(train)
```

Create the variable predictions and a transform applied the data of test
```
val predictions = ovrModel.transform(test)
```

Create the evaluator of classificator and asign the name accuracy
```
val evaluator = new MulticlassClassificationEvaluator().setMetricName("accuracy")
```

Calculate the accuracy of evaluator and print the test error
```
val accuracy = evaluator.evaluate(predictions)
println(s"Test Error = ${1 - accuracy}")
````

## Practice Naive Bayes

Import the libraries
```
import org.apache.spark.ml.classification.NaiveBayes
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
```

Create the value data to load the file
```
val data = spark.read.format("libsvm").load("sample_libsvm_data.txt")
````

Split the data 70% of training and 30% of test
```
val Array(trainingData, testData) = data.randomSplit(Array(0.7, 0.3), seed = 1234L)
```

Train the model 
```
val model = new NaiveBayes().fit(trainingData)
```

Select example files to show
```
val predictions = model.transform(testData)
predictions.show()
```

Select (the prediction and label) and calculate the test error
```
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
```

Print the accuracy
```
println(s"Test set accuracy = $accuracy")
```

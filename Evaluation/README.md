# Evaluation 1

### Clause (a)

> Import the libraries corresponding 
```
import org.apache.spark.ml.feature.{StringIndexer,VectorIndexer,IndexToString,VectorAssembler}
import org.apache.spark.ml.classification.MultilayerPerceptronClassifier
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.classification.MultilayerPerceptronClassificationModel
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)

// Se crea sesion de Spark
import org.apache.spark.sql.SparkSession
```
### Point 1

> Load the file "iris.csv" 
```
val data = spark.read.option("header", "true").option("inferSchema","true")csv("iris.csv")
```

### Point 2

> Take the names of the columns
```
data.columns
```

### Point 3

> Print the Schema to know more about the file
```
data.printSchema()
```

### Point 4

> Print five columns

```
data.select($"Sepal_Length", $"Sepal_Width", $"Petal_Length", $"Petal_Width", $"Species").show
```

### Point 5

> Use describe to know more about dataframe

```
data.describe()
```

### Point 6

> Start the transformation of the categoric data to numerical data

```
val assembler = new VectorAssembler().setInputCols(Array("sepal_length", "sepal_width", "petal_length", "petal_width")).setOutputCol("features")


val features = assembler.transform(data)
features.show()
```

> Everything is included in a data set to include all labels and they are printed

```
val labelIndexer = new StringIndexer().setInputCol("species").setOutputCol("indexedLabel").fit(features)
println(s"Found labels: ${labelIndexer.labels.mkString("[", ", ", "]")}")

val featureIndexer = new VectorIndexer().setInputCol("features").setOutputCol("indexedFeatures").setMaxCategories(4).fit(features)
```

> Split the features in 70% of training and 30% of test

```
val splits = features.randomSplit(Array(0.7, 0.3))
val trainingData = splits(0)
val testData = splits(1)
```

> Create grid layers

```
// Se crean las capas de la red
val layers = Array[Int](4, 5, 5, 3)

```

### Point 7

> Create the model trainer and given paramaters

```
val trainer = new MultilayerPerceptronClassifier().setLayers(layers).setLabelCol("indexedLabel").setFeaturesCol("indexedFeatures").setBlockSize(128).setSeed(System.currentTimeMillis).setMaxIter(200)
``` 

> Convert the index to the original form for use in prediction

```
val labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel").setLabels(labelIndexer.labels)
```

> Create the pipeline for the model

```
val pipeline = new Pipeline().setStages(Array(labelIndexer, featureIndexer, trainer, labelConverter))
```

> Train the model

```
val model = pipeline.fit(trainingData)
```

> Made the predictions with the model and show the results

```
val predictions = model.transform(testData)
predictions.show(20)
```

### Point 8

> Print the results of model

```
val evaluator = new MulticlassClassificationEvaluator().setLabelCol("indexedLabel").setPredictionCol("prediction").setMetricName("accuracy")
val accuracy = evaluator.evaluate(predictions)
println("Test Error = " + (1.0 - accuracy))
```
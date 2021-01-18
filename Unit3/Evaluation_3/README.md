# Evaluation 3

### Point 1

> Import the libraries

```
import org.apache.spark.sql.SparkSession
```

### Point 2

> Use lines of code to minimize errors

```
import org.apache.log4j._
Logger.getLogger("org").setLevel(Level.ERROR)
```

### Point 3

> Create a Spark Session

```
val spark = SparkSession.builder().getOrCreate()
```

### Point 4

> Import the librarie Kmeans for group algorithm

```
import org.apache.spark.ml.clustering.KMeans
```

### Point 5

> Load the file to use in the dataset

```
val dataset = spark.read.option("header","true").option("inferSchema","true").csv("wholesale_customers_data.csv")
```

### Point 6

> Select the columns: Fresh, Milk, Grocey, Frozen, Detergents_Paper, Delicassen and call this whole feature_data

```
val feature_data = dataset.select("Fresh","Milk","Grocery","Frozen","Detergents_Paper","Delicassen")
```

### Point 7

> Import vector assambler and vector libraries

```
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.linalg.Vectors
```

### Point 8

> Create new object Vector Assembler for the columns of features as an input whole, remembering there are no labels

```
val assembler = new VectorAssembler().setInputCols(Array("Fresh", "Milk", "Grocery", "Frozen","Detergents_Paper","Delicassen")).setOutputCol("features")
```

### Point 9

> Use the object assembler for transform feature_data

```
val features = assembler.transform(feature_data)
features.show()
```

### Point 10

> Create the model Kmeans with K=3

```
val kmeans = new KMeans().setK(3).setSeed(1L)
val model = kmeans.fit(features)
```

### Point 11

> Evaluate the groups using WSSSE and print the centroids

```
val WSSSE = model.computeCost(features)
println(s"Within Set Sum of Squared Errors = $WSSSE")
```

> Show the results

```
println("Cluster Centers: ")
model.clusterCenters.foreach(println)
```
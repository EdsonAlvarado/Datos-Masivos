# Big Data
Final Project

## Index 

1. [Introduction](#introduction)
2. [Theoretical framework](#framework)

## 1. Introduction <a name="introduction"></a>

Machine learning is a discipline in which the systems developed learn complex patterns automatically to predict future behaviors
based on a data collection. These systems are developed using algorithms that help us to classify and analyze the data, in this 
project we are going to see and compare some of these algorithms. 

## 2. Theoretical framework <a name="framework"></a>
### 2.1 Decision Tree
Decision tree is the most powerful and popular tool for classification and prediction. A Decision tree is a flowchart like tree structure, where each internal node denotes a test on an attribute, each branch represents an outcome of the test, and each leaf node (terminal node) holds a class label.

A decision tree can be used to visually and explicitly represent decisions and decision making. As the name goes, it uses a tree-like model of decisions. Though a commonly used tool in data mining for deriving a strategy to reach a particular goal, its also widely used in machine learning.

A decision tree is drawn upside down with its root at the top. In the image below, the purple squares represents a condition/internal node, based on which the tree splits into branches/ edges. The end of the branch that doesn’t split anymore is the decision/leaf.

![alt text](https://cdn.analyticsvidhya.com/wp-content/uploads/2020/05/rfc_vs_dt11.png)

Decision trees can be used for classification and regression and each one has its costs funtions for the spliting of the branches:

Classification -->  G = sum(pk * (1 — pk))

Here, pk is proportion of same class inputs present in a particular group. A perfect class purity occurs when a group contains all inputs from the same class, in which case pk is either 1 or 0 and G = 0, where as a node having a 50–50 split of classes in a group has the worst purity, so for a binary classification it will have pk = 0.5 and G = 0.5.

Regression --> sum(y — prediction)²

The decision tree will start splitting by considering each feature in training data. The mean of responses of the training data inputs of particular group is considered as prediction for that group. The above function is applied to all data points and cost is calculated for all candidate splits. Again the split with lowest cost is chosen. 

Advantages

* Simple to understand, interpret, visualize.
* Decision trees implicitly perform variable screening or feature selection.
* Can handle both numerical and categorical data. Can also handle multi-output problems.
* Decision trees require relatively little effort from users for data preparation.
* Nonlinear relationships between parameters do not affect tree performance.

Disadvantages

* Decision-tree learners can create over-complex trees that do not generalize the data well. This is called overfitting.
* Decision trees can be unstable because small variations in the data might result in a completely different tree being generated. This is called variance, which needs to be lowered   by methods like bagging and boosting.
* Greedy algorithms cannot guarantee to return the globally optimal decision tree. This can be mitigated by training multiple trees, where the features and samples are randomly sampled with replacement.
 * Decision tree learners create biased trees if some classes dominate. It is therefore recommended to balance the data set prior to fitting with the decision tree.


### 2.2 Support Vector Machine

The objective of the support vector machine algorithm is to find a hyperplane in an N-dimensional space(N — the number of features) that distinctly classifies the data points.
Image for post.
To separate the two classes of data points, there are many possible hyperplanes that could be chosen. Our objective is to find a plane that has the maximum margin, i.e the maximum distance between data points of both classes. Maximizing the margin distance provides some reinforcement so that future data points can be classified with more confidence.


![alt text](https://miro.medium.com/max/700/1*ZpkLQf2FNfzfH4HXeMw4MQ.png)

Support vectors are data points that are closer to the hyperplane and influence the position and orientation of the hyperplane. Using these support vectors, we maximize the margin of the classifier. 

The mathematic definition of the hyperplane can be described by an equation:

β0+β1x1+β2x2=0

Given the parameters β0, β1 y β2, and all the paired values x=(x1,x2) for which the equality is fulfilled are points in the hyperplane. This equation can be generalized for n-dimensions

β0+β1x1+β2x2+...+βnxn=0
and for all the points defined by the vector (x=x1,x2,...,xn) which fulfill the equation belongs to the hyperplane


When x
do not fulfill the equation:
β0+β1x1+β2x2+...+βnxn<0

or

β0+β1x1+β2x2+...+βnxn>0
x falls to one side of the hyperplane. An hyperplane divides an space of n-dimensions in two. If we need to know at what wise a point x falls we just need to calculate the sign of the equation.

Advantages

* SVM works relatively well when there is a clear margin of separation between classes.
* SVM is more effective in high dimensional spaces.
* SVM is effective in cases where the number of dimensions is greater than the number of samples.
* SVM is relatively memory efficient

Disadvantages

* SVM algorithm is not suitable for large data sets.
* SVM does not perform very well when the data set has more noise i.e. target classes are overlapping.
* In cases where the number of features for each data point exceeds the number of training data samples, the SVM will underperform.
* As the support vector classifier works by putting data points, above and below the classifying hyperplane there is no probabilistic explanation for the classification.

### 2.3 Logistic Regression
Logistic regression models the probabilities for classification problems with two possible outcomes. It's an extension of the linear regression model for classification problems.

We can call a Logistic Regression a Linear Regression model but the Logistic Regression uses a more complex cost function, this cost function can be defined as the ‘Sigmoid function’ or also known as the ‘logistic function’ instead of a linear function.

The hypothesis of logistic regression tends it to limit the cost function between 0 and 1. Therefore linear functions fail to represent it as it can have a value greater than 1 or less than 0 which is not possible as per the hypothesis of logistic regression.

![alt text](https://miro.medium.com/max/223/1*GnceHPIeThNShGSmYzE4eA.png)

### 2.4 Multilayer perceptron
A multilayer perceptron (MLP) is a class of feedforward artificial neural network (ANN). The term MLP is used ambiguously, sometimes loosely to any feedforward ANN, sometimes strictly to refer to networks composed of multiple layers of perceptrons (with threshold activation); see § Terminology. Multilayer perceptrons are sometimes colloquially referred to as "vanilla" neural networks, especially when they have a single hidden layer.

An MLP consists of at least three layers of nodes: an input layer, a hidden layer and an output layer. Except for the input nodes, each node is a neuron that uses a nonlinear activation function. MLP utilizes a supervised learning technique called backpropagation for training. Its multiple layers and non-linear activation distinguish MLP from a linear perceptron. It can distinguish data that is not linearly separable.

![alt text](https://miro.medium.com/max/3446/1*-IPQlOd46dlsutIbUq1Zcw.png)

Till date, there is no implementation of the incremental version of the neural network in
Spark. However, the Multilayer perceptron classifier (MLPC) is a classifier based on the feedforward artificial neural network in the current implementation of Spark ML API.

The MLPC employs backpropagation for learning the model. Technically, Spark used the logistic loss function for optimization and L-BFGS as an optimization routine. The number of nodes (say) N in the output layer corresponds to the number of classes.

MLPC also performs backpropagation for learning the model. On the other hand, Spark uses the logistic loss function for optimization and Limited-memory Broyden-Fletcher-Goldfarb-Shanno (LBFGS) as an optimization routine. Note that the L-BFGS is an optimization algorithm in the family of Quasi-Newton Method (QNM) that approximates the Broyden-Fletcher-Goldfarb-Shanno algorithm using a limited main memory.

To train a Spark ML based multilayer perceptron classifier, the following parameters need to be set:

Layer, Tolerance of iteration, Block size of the learning, Seed size, Max iteration number

## 3. Implementation

For this project we're going to use the following tools:

Apache Spark

Apache Spark is a data processing framework that can quickly perform processing tasks on very large data sets, and can also distribute data processing tasks across multiple computers, either on its own or in tandem with other distributed computing tools. These two qualities are key to the worlds of big data and machine learning, which require the marshalling of massive computing power to crunch through large data stores. Spark also takes some of the programming burdens of these tasks off the shoulders of developers with an easy-to-use API that abstracts away much of the grunt work of distributed computing and big data processing.

Scala

Scala is a high level language that combines functional and object oriented programming with high performance runtimes. 
Scala is a powerful language that can leverage many of the same functions as Python, such as building machine learning models.


## 4. Results tables
### 4.1 Decision Tree
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 | 0.898 | 0.101 | 370 | 392 | 777 | 910 | 21.202 |
| 2 | 0.898 | 0.101 | 328 | 430 | 773 | 910 | 10.895 |
| 3 | 0.903 | 0.096 | 291 | 471 | 781 | 910 | 10.712 |
| 4 | 0.893 | 0.106 | 376 | 387 | 783 | 910 | 10.182 |
| 5 | 0.895 | 0.104 | 363 | 404 | 789 | 910 | 12.119 |
| 6 | 0.898 | 0.101 | 346 | 419 | 789 | 910 | 10.432 |
| 7 | 0.899 | 0.100 | 379 | 384 | 789 | 910 | 10.830 |
| 8 | 0.900 | 0.099 | 327 | 439 | 795 | 910 | 11.301 |
| 9 | 0.896 | 0.103 | 429 | 324 | 783 | 910 | 11.554 |
| 10 | 0.895 | 0.104 | 545 | 202 | 780 | 910 | 12.521 |
| Average | 0.897 | 0.101 | 375  | 385  | 783  | 910  | 12.174 |

### 4.2 Support Vector Machine
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 | 0.884 | 0.115 | 622 | 148 | 807 | 910 | 43.909 |
| 2 | 0.889 | 0.110 | 693 | 76 | 809 | 910 | 42.054 |
| 3 | 0.888 | 0.111 | 414 | 554 | 1010 | 1010 | 43.366 |
| 4 | 0.888 | 0.111 | 585 | 387 | 1017 | 1017 | 42.792 |
| 5 | 0.885 | 0.114 | 631 | 336 | 1017 | 1017 | 40.480 |
| 6 | 0.889 | 0.110 | 576 | 383 | 1014 | 1014 | 49.535 |
| 7 | 0.891 | 0.108 | 837 | 442 | 1016 | 1016 | 37.485 |
| 8 | 0.888 | 0.111 | 780 | 173 | 1014 | 1015 | 43.786 |
| 9 | 0.886 | 0.113 | 674 | 277 | 1016 | 1016 | 44.357 |
| 10 | 0.891 | 0.108 | 674 | 268 | 1011 | 1013 | 39.460 |
| Average | 0.887 | 0.111  | 648  | 304  | 973  | 994  | 42.722 |


### 4.3 Logistic Regression 
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1	| 0.886 | 0.113 |	400 |	295 |	709 |	910 | 25 |
| 2	| 0.886 |	0.113 |	284	| 423 |	723 |	910 | 12 |
| 3 |	0.885	| 0.114 | 213	| 500 |	731 |	910 | 12 |
| 4 |	0.889 |	0.110 |	465 |	232 |	726 |	910 | 12 |
| 5	| 0.887	| 0.112	| 334 |	370 |	726 |	910 | 11 |
| 6	| 0.882	| 0.117	| 494	|	484 |	725 |	910 | 12 |
| 7	| 0.886 |	0.113 |	520 |	470 |	729 |	910 | 12 |
| 8	| 0.888 |	0.111 |	433 |	238 |	700 |	910 | 13 |
| 9	| 0.883 |	0.116 |	340 |	350 |	722 |	910 | 13 |
| 10 | 0.887 | 0.112 | 583 | 388 | 722 | 910 | 13 |
| Average | 0.883 | 0.113 | 406  | 375 | 676  | 910  | 13.5 |

### 4.4 Multilayer perceptron 

| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 |	0.885	| 0.114 |	490 |	194 |	722 |	910 | 13 |
| 2 |	0.888 |	0.111 |	565 |	114 |	726 |	910 | 14 |
| 3 |	0.884 |	0.115	| 580 |	108 |	731 |	910 | 14 |
| 4 |	0.888 |	0.111 |	376 |	308 |	731 |	910 | 15 |
| 5 |	0.887	| 0.112	| 608 |	75 |	732 |	910 | 15 |
| 6	| 0.889	| 0.110	| 710 |	259 |	734 |	910 | 16 |
| 7	| 0.882	| 0.117	| 620 |	321 |	996 |	996 | 18 |
| 8 |	0.885	| 0.114	| 638 |	292 |	992 |	992 | 18 |
| 9	| 0.890 |	0.109 |	527 |	404 |	993 |	993 | 20 |
| 10 | 0.884 | 0.115 | 607 | 319 | 994 | 981 | 19 |
| Average |	0.883 |	0.112	| 572	|	239	| 835 | 942	 | 16.2 |

### 4.5 Comparison (Averages)
| Algorithm | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| Decision Tree | 0.897 | 0.101 | 375  | 385  | 783  | 910  | 12.174 |
| Support Vector Machine |0.887 | 0.111  | 648  | 304  | 973  | 994  | 42.722 |
| Logistic Regression | 0.883 | 0.1131 | 406  | 375 | 676  | 910  | 13.5 |
| Multilayer perceptron |	0.883 |	0.112	| 572	|	239	| 835 | 942	 | 16.2 |

## 5. Conclusion

We can see that the Decision Tree Classsifier method obtained the highest precision, while Logistic Regression and Multilayer Perceptron obtained the lowest precision compared to the 4 methods. In the Error Test Decision Tree Classifier is again better compared to the other methods, obtaining a lower error test, instead Logistic Regression obtains the highest Error Test which makes it the worst of the 4 methods.

## 6. References

Pant, A. (2019, 22 enero). Introduction to Logistic Regression - Towards Data Science. medium. https://towardsdatascience.com/introduction-to-logistic-regression-66248243c148

Molnar, C. (2021, 11 enero). Interpretable Machine Learning. Github. https://christophm.github.io/interpretable-ml-book/logistic.html


Karim, M. R. (2018, 3 enero). Deep Learning via Multilayer Perceptron Classifier. dzone.com. https://dzone.com/articles/deep-learning-via-multilayer-perceptron-classifier

Gupta, P. (2018, 20 junio). Decision Trees in Machine Learning - Towards Data Science. Medium. https://towardsdatascience.com/decision-trees-in-machine-learning-641b9c4e8052

Apache. (s. f.). Classification and regression - Spark 2.4.7 Documentation. Spark.apache.org. Recuperado 13 de enero de 2021, de https://spark.apache.org/docs/2.4.7/ml-classification-regression.html

Gandhi, R. (2018, 5 julio). Support Vector Machine — Introduction to Machine Learning Algorithms. Medium. https://towardsdatascience.com/support-vector-machine-introduction-to-machine-learning-algorithms-934a444fca47

Rodrigo, J. A. (s. f.). Máquinas de Vector Soporte (Support Vector Machines, SVMs). cienciadedatos. Recuperado 13 de enero de 2021, de https://www.cienciadedatos.net/documentos/34_maquinas_de_vector_soporte_support_vector_machines

The Scala Programming Language. (s. f.). scala-lang.org. Recuperado 13 de enero de 2021, de https://www.scala-lang.org/

Apache SparkTM - Unified Analytics Engine for Big Data. (s. f.). spark.apache.org. Recuperado 13 de enero de 2021, de https://spark.apache.org/


# Big Data
Final Project


## 1. Introduction

Machine learning is a discipline in which the systems developed learn complex patterns automatically to predict future behaviors
based on a data collection. These systems are developed using algorithms that help us to classify and analyze the data, in this 
project we are going to see and compare some of these algorithms. 

## 2. Algorithms
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

### 2.2 Support Vector Machine


### 2.3 Logistic Regression
Logistic regression models the probabilities for classification problems with two possible outcomes. It's an extension of the linear regression model for classification problems.

We can call a Logistic Regression a Linear Regression model but the Logistic Regression uses a more complex cost function, this cost function can be defined as the ‘Sigmoid function’ or also known as the ‘logistic function’ instead of a linear function.

The hypothesis of logistic regression tends it to limit the cost function between 0 and 1. Therefore linear functions fail to represent it as it can have a value greater than 1 or less than 0 which is not possible as per the hypothesis of logistic regression.

![alt text](https://miro.medium.com/max/223/1*GnceHPIeThNShGSmYzE4eA.png)

### 2.4 Multilayer perceptron
A multilayer perceptron (MLP) is a class of feedforward artificial neural network (ANN). The term MLP is used ambiguously, sometimes loosely to any feedforward ANN, sometimes strictly to refer to networks composed of multiple layers of perceptrons (with threshold activation); see § Terminology. Multilayer perceptrons are sometimes colloquially referred to as "vanilla" neural networks, especially when they have a single hidden layer.

An MLP consists of at least three layers of nodes: an input layer, a hidden layer and an output layer. Except for the input nodes, each node is a neuron that uses a nonlinear activation function. MLP utilizes a supervised learning technique called backpropagation for training. Its multiple layers and non-linear activation distinguish MLP from a linear perceptron. It can distinguish data that is not linearly separable.

![alt text](https://dzone.com/storage/temp/3627042-mlp-network.png)

Till date, there is no implementation of the incremental version of the neural network in
Spark. However, the Multilayer perceptron classifier (MLPC) is a classifier based on the feedforward artificial neural network in the current implementation of Spark ML API.

The MLPC employs backpropagation for learning the model. Technically, Spark used the logistic loss function for optimization and L-BFGS as an optimization routine. The number of nodes (say) N in the output layer corresponds to the number of classes.

MLPC also performs backpropagation for learning the model. On the other hand, Spark uses the logistic loss function for optimization and Limited-memory Broyden-Fletcher-Goldfarb-Shanno (LBFGS) as an optimization routine. Note that the L-BFGS is an optimization algorithm in the family of Quasi-Newton Method (QNM) that approximates the Broyden-Fletcher-Goldfarb-Shanno algorithm using a limited main memory [2].

To train a Spark ML based multilayer perceptron classifier, the following parameters need to be set:

Layer
Tolerance of iteration
Block size of the learning
Seed size
Max iteration number

## 3. Results tables
### 3.1 Decision Tree
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

### 3.2 Support Vector Machine
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


### 3.3 Logistic Regression 
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

### 3.4 Multilayer perceptron 

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

### Comparison (Averages)
| Algorithm | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| Decision Tree | 0.897 | 0.101 | 375  | 385  | 783  | 910  | 12.174 |
| Support Vector Machine |0.887 | 0.111  | 648  | 304  | 973  | 994  | 42.722 |
| Logistic Regression | 0.883 | 0.1131 | 406  | 375 | 676  | 910  | 13.5 |
| Multilayer perceptron |	0.883 |	0.112	| 572	|	239	| 835 | 942	 | 16.2 |

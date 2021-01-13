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

Given the parameters β0, β1 y β2, and all the paired values x=(x1,x2) para los que se cumple la igualdad son puntos del hiperplano. Esta ecuación puede generalizarse para n-dimensiones: for which the equality is fulfilled are points in the hyperplane. This equation can be generalized for n-dimensions

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



### 2.4 Multilayer perceptron



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
| 1	| 0 | 0 |	0 |	0 |	0 |	0 | 0 |
| 2	| 0 |	0 |	0	| 0 |	0 |	0 | 0 |
| 3 |	0	| 0 | 0	| 0 |	0 |	0 | 0 |
| 4 |	0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 5	| 0	| 0	| 0 |	0 |	0 |	0 | 0 |
| 6	| 0	| 0	| 0	|	0 |	0 |	0 | 0 |
| 7	| 0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 8	| 0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 9	| 0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| Average | 0 | 0 | 0  | 0 | 0 | 0  | 0 |

### 3.4 Multilayer perceptron 

| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 |	0	| 0 |	0 |	0 |	0 |	0 | 0 |
| 2 |	0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 3 |	0 |	0	| 0 |	0 |	0 |	0 | 0 |
| 4 |	0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 5 |	0	| 0	| 0 |	0 |	0 |	0 | 0 |
| 6	| 0	| 0	| 0 |	0 |	0 |	0 | 0 |
| 7	| 0	| 0	| 0 |	0 |	0 |	0 | 0 |
| 8 |	0	| 0	| 0 |	0 |	0 |	0 | 0 |
| 9	| 0 |	0 |	0 |	0 |	0 |	0 | 0 |
| 10 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| Average |	0 |	0	| 0	|	0	| 0	| 0 | 0 |

### Comparison (Averages)
| Algorithm | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| Decision Tree | 0.897 | 0.101 | 375  | 385  | 783  | 910  | 12.174 |
| Support Vector Machine |0.887 | 0.111  | 648  | 304  | 973  | 994  | 42.722 |
| Logistic Regression |	0 | 0 | 0 |	0 | 0 |	0 | 0 |
| Multilayer perceptron |	0 |	0 |	0 | 0 | 0 |	0 | 0 |

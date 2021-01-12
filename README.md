# Big Data
Final Project


## 1. Introduction

Machine learning is a discipline in which the systems developed learn complex patterns automatically to predict future behaviors
based on a data collection. These systems are developed using algorithms that help us to classify and analyze the data, in this 
project we are going to see and compare some of these algorithms. 

## 2. Algorithms
### 2.1 Decision Tree
Decision tree is the most powerful and popular tool for classification and prediction. A Decision tree is a flowchart like tree structure, where each internal node denotes a test on an attribute, each branch represents an outcome of the test, and each leaf node (terminal node) holds a class label.

![alt text](https://cdn.analyticsvidhya.com/wp-content/uploads/2020/05/rfc_vs_dt11.png)

### 2.2 Random Forest
Random forest, like its name implies, consists of a large number of individual decision trees that operate as an ensemble. Each individual tree in the random forest spits out a class prediction and the class with the most votes becomes our model’s prediction.

Each tree is grown as follows:

1. If the number of cases in the training set is N, sample N cases at random - but with replacement, from the original data. This sample will be the training set for growing the tree.
2. If there are M input variables, a number m<<M is specified such that at each node, m variables are selected at random out of the M and the best split on these m is used to split the node. The value of m is held constant during the forest growing.
3. Each tree is grown to the largest extent possible. There is no pruning.

In the original paper on random forests, it was shown that the forest error rate depends on two things:

1. The correlation between any two trees in the forest. Increasing the correlation increases the forest error rate.
2. The strength of each individual tree in the forest. A tree with a low error rate is a strong classifier. Increasing the strength of the individual trees decreases the forest error rate.

![alt text](https://cdn.analyticsvidhya.com/wp-content/uploads/2020/02/rfc_vs_dt1.png)

### 2.3 Gradient Boosted Tree

![alt text](https://www.researchgate.net/profile/Yoonseok_Shin2/publication/281513259/figure/fig4/AS:317672093962245@1452750337241/Gradient-boosted-decision-tree-ensemble.png)

### 2.4 Naive Bayes

![alt text](https://images.deepai.org/glossary-terms/0f7ab6cd59a845a1a3e4225ebe718171/naive_bayes.png)

## 3. Results tables
### 3.1 Decision Tree
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 | 0.931 | 0.068 | 245 | 391 | 650 | 910 | 11.951 |
| 2 | 1.0 | 0.0 | 418 | 477 | 667 | 910 | 4.126 |
| 3 | 0.911 | 0.088 | 195 | 466 | 676 | 910 | 3.606 |
| 4 | 0.967 | 0.032 | 454 | 212 | 682 | 910 | 3.422 |
| 5 | 1.0 | 0.0 | 226 | 441 | 683 | 910 | 3.535 |
| 6 | 0.911 | 0.088 | 261 | 409 | 686 | 910 | 3.326 |
| 7 | 1.0 | 0.0 | 317 | 354 | 687 | 910 | 3.242 |
| 8 | 1.0 | 0.0 | 401 | 267 | 685 | 910 | 3.445 |
| 9 | 0.945 | 0.054 | 468 | 197 | 687 | 910 | 3.314 |
| 10 | 0.962 | 0.037 | 327 | 330 | 682 | 910 | 3.743 |
| Average | 0.9627 | 0.0367  | 331  | 354  | 678  | 910  | 4.371 |

### 3.2 Random Forest
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 | 0.947 | 0.052 | 351 | 408 | 773 | 910 | 12.944 |
| 2 | 0.965 | 0.034 | 377 | 392 | 784 | 910 | 4.018 |
| 3 | 1.0 | 0.0 | 278 | 508 | 800 | 910 | 3.632 |
| 4 | 1.0 | 0.0 | 384 | 400 | 801 | 910 | 3.991 |
| 5 | 1.0 | 0.0 | 238 | 550 | 803 | 910 | 3.718 |
| 6 | 0.923 | 0.076 | 328 | 461 | 807 | 910 | 3.575 |
| 7 | 0.962 | 0.037 | 437 | 359 | 812 | 910 | 3.582 |
| 8 | 1.0 | 0.0 | 264 | 533 | 817 | 910 | 3.832 |
| 9 | 1.0 | 0.0 | 371 | 427 | 818 | 910 | 3.703 |
| 10 | 0.945 | 0.054 | 501 | 297 | 819 | 910 | 3.597 |
| Average | 0.9742 | 0.0253  | 353  | 433  | 803  | 910  | 4.659 |


### 3.3 Gradient Boosted Tree 
| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1	| 0.966 | 0.033 |	227 |	578 |	823 |	954 | 9 |
| 2	| 0.962 |	0.037 |	243	| 563 |	819 |	954 | 7 |
| 3 |	1	| 0 | 315	| 487 |	819 |	954 | 7 |
| 4 |	0.911 |	0,088 |	431 |	373 |	821 |	954 | 6 |
| 5	| 1	| 0	| 446 |	353 |	819 |	954 | 7 |
| 6	| 1	| 0	| 298	|	500 |	820 |	954 | 7 |
| 7	| 0.857 |	0.142 |	279 |	522 |	821 |	954 | 7 |
| 8	| 0.964 |	0.035 |	312 |	487 |	822 |	954 | 9 |
| 9	| 0.875 |	0.125 |	396 |	397 |	816 |	954 | 7 |
| 10 | 0.937 | 0.062 | 325 | 468 | 818 | 954 | 7 |
| Average | 0.947 | 0.052 | 327  | 472.8 | 819.8 | 954  | 7.3 |

### 3.4 Naive Bayes 

| Iteration | Accuracy | Error | Used memory | Free Memory | Total Memory | Max Memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- | ----------- |
| 1 |	1	| 1 |	290 |	461 |	763 |	955 | 13 |
| 2 |	1 |	1 |	289 |	480 |	765 |	955 | 2 |
| 3 |	1 |	1	| 271 |	481 |	765 |	955 | 2 |
| 4 |	1 |	1 |	394 |	358 |	768 |	954 | 3 |
| 5 |	1	| 1	| 347 |	394 |	756 |	954 | 2 |
| 6	| 1	| 1	| 309 |	447 |	772 |	954 | 2 |
| 7	| 1	| 1	| 246 |	513 |	779 |	954 | 2 |
| 8 |	1	| 1	| 443 |	323 |	787 |	954 | 2 |
| 9	| 1 |	1 |	363 |	415 |	796 |	954 | 2 |
| 10 | 1 | 1 | 259 | 525 | 803 | 954 | 2 |
| Average |	1 |	1	| 321	|	440	| 775	| 954 | 3.2 |

### Comparison (Averages)
| Algorithm | Accuracy | Error | Used memory | Time (seconds)
| ----------- | ----------- | ----------- | ----------- | ----------- |
| Decision Tree |	0.9627	| 0.0367 |	331 | 4.371 |
| Random Forest |	0.9742 | 0.0253  | 353 | 4.659 |
| Gradient Boosted Tree |	0.947 | 0.052 | 327 |	7.3 |
| Naive Bayes |	1 |	1 |	321 | 3.2 |

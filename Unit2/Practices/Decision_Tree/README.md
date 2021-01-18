# Arboles de decisión (Decision Tree Classifier)

## Concepto

Un árbol de decisión es una forma gráfica y analítica de   representar   todos   los   eventos   (sucesos)   que   pueden  surgir  a  partir  de  una  decisión  asumida  en  cierto momento. 

Dado un conjunto de datos se fabrican diagramas de construcciones lógicas, muy similares a los sistemas de predicción basados en reglas, que sirven para representar y categorizar una serie de condiciones que ocurren de forma sucesiva, para la resolución de un problema.

Los árboles de decisión son una familia popular de métodos de clasificación y regresión.
El aprendizaje del árbol de decisiones es uno de los enfoques de modelado predictivo utilizados en estadística, minería de datos y aprendizaje automático. Utiliza un árbol de decisiones (como modelo predictivo) para pasar de las observaciones sobre un elemento (representado en las ramas) a las conclusiones sobre el valor objetivo del elemento (representado en las hojas). Los árboles de decisión en los que la variable de destino puede tomar valores continuos (normalmente números reales) se denominan árboles de regresión. Los árboles de decisión se encuentran entre los algoritmos de aprendizaje automático más populares dada su inteligibilidad y simplicidad.



![alt text](https://runestone.academy/runestone/static/pythoned/_images/booktree.png)

## Elementos del arbol

- Nodos: Es una decisión de entre varias posibles, a medida que aumenta el número de nodos aumente el número de posibles finales a los que puede llegar.
- Vectores: Es el conjunto de decisiones para llegar a un determinado final.
- Ramas: Son las uniones entre los nodos.

## Caracteristicas del arbol

1. El inicio del arbol esta dado por un solo nodo que no es apuntado por nada y debe de ser el único nodo con esta caracteristica.
2. Los demas nodos deben de estar conectados a una rama.
3. Existe un único camino para llegar desde el nodo inicial hacia un determinado final dentro del arbol.

El uso de un proceso de toma de decisiones paso a paso puede ayudarlo a tomar decisiones más deliberadas y reflexivas al organizar la información relevante y definir alternativas. Este enfoque aumenta las posibilidades de que elija la alternativa más satisfactoria posible.

###### Paso 1: identificar la decisión
Te das cuenta de que necesitas tomar una decisión. Intente definir claramente la naturaleza de la decisión que debe tomar. Este primer paso es muy importante.

###### Paso 2: recopile información relevante
Recopile información pertinente antes de tomar una decisión: qué información se necesita, las mejores fuentes de información y cómo obtenerla. Este paso implica un "trabajo" tanto interno como externo. Alguna información es interna: la buscará a través de un proceso de autoevaluación. Otra información es externa: la encontrará en línea, en libros, de otras personas y de otras fuentes.

###### Paso 3: identificar las alternativas
A medida que recopile información, probablemente identificará varias posibles vías de acción o alternativas. También puede usar su imaginación e información adicional para construir nuevas alternativas. En este paso, enumerará todas las alternativas posibles y deseables.

###### Paso 4: sopesa la evidencia
Aprovecha tu información y emociones para imaginar cómo sería si llevaras a cabo cada una de las alternativas hasta el final. Evalúe si la necesidad identificada en el Paso 1 se satisfaría o se resolvería mediante el uso de cada alternativa. A medida que atraviesa este difícil proceso interno, comenzará a favorecer ciertas alternativas: aquellas que parecen tener un mayor potencial para alcanzar su objetivo. Finalmente, coloque las alternativas en orden de prioridad, según su propio sistema de valores.

###### Paso 5: elige entre alternativas
Una vez que haya sopesado todas las pruebas, estará listo para seleccionar la alternativa que le parezca mejor. Incluso puede elegir una combinación de alternativas. Es muy probable que su elección en el Paso 5 sea la misma o similar a la alternativa que colocó en la parte superior de su lista al final del Paso 4.

###### Paso 6: Actúa
Ahora está listo para tomar alguna acción positiva al comenzar a implementar la alternativa que eligió en el Paso 5.

###### Paso 7: revise su decisión y sus consecuencias
En este paso final, considere los resultados de su decisión y evalúe si ha resuelto o no la necesidad que identificó en el Paso 1. Si la decisión no ha satisfecho la necesidad identificada, es posible que desee repetir ciertos pasos del proceso para hacer una nueva decisión. Por ejemplo, es posible que desee recopilar información más detallada o algo diferente o explorar alternativas adicionales.

## Terminología importante relacionada con los árboles de decisión
- **Nodo raíz:** representa toda la población o muestra y esta se divide en dos o más conjuntos homogéneos.

- **División:** es un proceso de división de un nodo en dos o más subnodos.

- **Nodo de decisión:** cuando un subnodo se divide en otros subnodos, se denomina nodo de decisión.

- **Nodo Hoja / Terminal:** Los nodos que no se dividen se denominan nodo Hoja o Terminal.

- **Poda:** cuando eliminamos subnodos de un nodo de decisión, este proceso se denomina poda. Se puede decir el proceso opuesto a la división.

- **Rama / Subárbol:** una subsección de todo el árbol se denomina rama o subárbol.

- **Nodo padre e hijo:** un nodo, que se divide en subnodos, se denomina nodo padre de subnodos, mientras que los subnodos son hijos de un nodo padre.

## Medidas de selección de atributos 
Si el conjunto de datos consta de N atributos, entonces decidir qué atributo colocar en la raíz o en diferentes niveles del árbol como nodos internos es un paso complicado. Con solo seleccionar al azar cualquier nodo para que sea la raíz, no se puede resolver el problema. Si seguimos un enfoque aleatorio, puede darnos malos resultados con poca precisión.

Para resolver este problema de selección de atributos, los investigadores trabajaron e idearon algunas soluciones. Sugirieron usar algunos criterios como:
- [x] **Entropía**
- [x] **Ganancia de información**
- [x] **Índice de Gini**
- [x] **Ratio de ganancia**
- [x] **Reducción de la varianza**
- [x] **Chi-cuadrado**

## ¿Cuál es mejor?, ¿Los Modelos Lineales or de Arboles?
 
***Bueno, depende del tipo de problema que estés resolviendo.***
- Si la relación entre las variables dependientes e independientes está bien aproximada por un modelo lineal, la regresión lineal superará al modelo basado en árboles.
- Si hay una alta no linealidad y una relación compleja entre las variables dependientes e independientes, un modelo de árbol superará a un método de regresión clásico.
- Si necesita construir un modelo que sea fácil de explicar a las personas, un modelo de árbol de decisiones siempre funcionará mejor que un modelo lineal. Los modelos de árboles de decisión son incluso más sencillos de interpretar que la regresión lineal.

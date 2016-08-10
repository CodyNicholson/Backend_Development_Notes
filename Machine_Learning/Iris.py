import numpy as np
from sklearn.datasets import load_iris
from sklearn import tree

# load_iris() will load all 150 rows of data from the
# iris wikipedia table
iris = load_iris()

# These are the indices of the test data we will be using
test_idx = [0, 1, 2, 50, 51, 52, 100, 101, 102]

print("The features are: " + str(iris.feature_names))
print("The target names are: " + str(iris.target_names))
print("This is the data from the iris wikipedia page table: ")
print("Labels: 0 = setosa, 1 = versicolor, 2 = virginica")
for i in range(len(iris.target)):
    print("Example %d: label %s, features %s" % (i, iris.target[i], iris.data[i]))

print("The indices of the 150 rows of data we will be using are: " + str(test_idx))

# Training data
train_target = np.delete(iris.target, test_idx)
train_data = np.delete(iris.data, test_idx, axis=0)

# Testing data
test_target = iris.target[test_idx]
test_data = iris.data[test_idx]

clf = tree.DecisionTreeClassifier()
clf.fit(train_data, train_target)

print("This is what we predict the result will be: " + str(test_target))
print("This is the result: " + str(clf.predict(test_data)))
print("0 = setosa, 1 = versicolor, 2 = virginica")

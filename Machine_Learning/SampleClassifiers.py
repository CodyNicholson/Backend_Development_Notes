from scipy.spatial import distance
# Find the distance between two points of data so we can find
# the nearest neighbors of a point
def euc(a,b):
    return distance.euclidean(a,b)

# Predicts the label of a data point based on which data points are nearest to it
# Pros: It is simple relative to other classifiers
# Cons: It is computationally intense since it iterates over every training point,
# It is hard to represent relationship between features in this classifier
class CustomNearestNeighborClassifier():
    # fit trains the classifier to handle the data
    def fit(self, X_train, Y_train):
        self.X_train = X_train
        self.Y_train = Y_train

    # predict receives the test data and outputs the prediction
    def predict(self, X_test):
        # Create a list of predictions to return
        predictions = []
        for row in X_test:
            # Randomly choose a row from the data
            label = self.closest(row)
            # Add this prediction to our list
            predictions.append(label)
        return predictions

    def closest(self, row):
        # Calculate the distance from the test point to the first training point
        # and will keep track of the shortest distance in best_dist
        best_dist = euc(row, self.X_train[0])
        # Keep track of the index of the best_dist
        best_index = 0
        # Iterate over all other training points
        for i in range(1, len(self.X_train)):
            dist = euc(row, self.X_train[i])
            # When we find a closer point, update best_dist
            if dist < best_dist:
                best_dist = dist
                best_index = i
        return self.Y_train[best_index]

from sklearn import datasets

# Load dataset
iris = datasets.load_iris()

X = iris.data  #features
Y = iris.target #labels

# Patition the data
from sklearn.cross_validation import train_test_split

# Create a testing and training set for both features and labels
# "test_size = 0.5" means that we will use half the data for testing, and half for training
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.5)

# Create Classifier
from sklearn import tree
DTree_classifier = tree.DecisionTreeClassifier()
# Create Classifier a different classifier from a different library
from sklearn.neighbors import KNeighborsClassifier
KN_classifier = KNeighborsClassifier()
# Create my own classifier from my class
my_classifier = CustomNearestNeighborClassifier()

# Train data
DTree_classifier.fit(X_train, Y_train)
KN_classifier.fit(X_train, Y_train)
my_classifier.fit(X_train, Y_train)

# Have the classifier make predictions
DTree_predictions = DTree_classifier.predict(X_test)
KN_predictions = KN_classifier.predict(X_test)
my_predictions = my_classifier.predict(X_test)

# Compare predicted labels to true labels and print the percentage of correct predictions
from sklearn.metrics import accuracy_score
print("This is the percentage of correct predictions from the Decision Tree classifier:\n"
      "" + str(accuracy_score(Y_test, DTree_predictions)))
print("This is the percentage of correct predictions from the Nearest Neighbors classifier:\n"
      "" + str(accuracy_score(Y_test, KN_predictions)))
print("This is the percentage of correct predictions from the my Custom classifier:\n"
      "" + str(accuracy_score(Y_test, my_predictions)))
print("Different classifiers work in different ways. There is no perfect classifier!")
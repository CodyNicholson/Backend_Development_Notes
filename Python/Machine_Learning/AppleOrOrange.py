from sklearn import tree

features = [[140, 1], [130, 1], [150, 0], [170, 0]]
# bumpy = 0
# smooth = 1

labels = [0, 0, 1, 1]
# apple = 0
# orange = 1

clf = tree.DecisionTreeClassifier()
# this is the classifier, an empty box of rules
# we will train it using a learning algorithm

clf = clf.fit(features, labels)
# .fit = Find patterns in Data
# this is our training algorithm

weight = input("What is the weight of the fruit in grams?: ")
texture = input("What is the texture of the fruit? For bumpy type '0', for smooth type '1': ")

if clf.predict([[weight, texture]]) == [1]:
    print("This is probably an Orange")
# .predict will use the entered data to make a decision

if clf.predict([[weight, texture]]) == [0]:
    print("This is probably an Apple")
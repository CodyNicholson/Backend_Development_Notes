import numpy as np
import matplotlib.pyplot as plt

greyhounds = 500
labs = 500

grey_height = 28 + 4 * np.random.randn(greyhounds)
lab_height = 24 + 4 * np.random.randn(labs)

plt.hist([grey_height, lab_height], stacked=True, color=['r','b'])
plt.show()

print("Since these two breeds of dogs are so close in height,\n"
      "the height feature would not be a good feature to give our classifier.\n"
      "Ideal features should be informative, independant, and simple.")
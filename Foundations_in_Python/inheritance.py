class Parent():

    def __init__(self, last_name, eye_color):
        print("Parent Constructor Called")
        self.last_name = last_name
        self.eye_color = eye_color

    def show_info(self):
        print("Last Name - " + self.last_name)
        print("Eye Color - " + self.eye_color)

class Child(Parent):

    def __init__(self, last_name, eye_color, num_toys):
        print("Child Constructor Called")
        Parent.__init__(self, last_name, eye_color)
        self.num_toys = num_toys

    def show_info(self):  #Overrides the Parent show_info method
        print("Last Name - " + self.last_name)
        print("Eye Color - " + self.eye_color)
        print("Number of Toys - " + str(self.num_toys))

cody_nicholson = Parent("Nicholson", "blue")
cody_nicholson.show_info()
#print(billy_cyrus.last_name)

john_smith = Child("Smith", "Blue", 5)
john_smith.show_info() #Notice this instance is of Child, but it can use Parent's show_info method because of inheritance

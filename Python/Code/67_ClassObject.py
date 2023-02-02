class Student:
    def __init__(self):
        self.name = "Raju"
        self.age = 20
        self.mark = 88

    def talk(self):
        print("Hi, I am ", self.name)
        print("Hi, I am ", self.age, " years old")
        print("My marks are ", self.mark)


s1 = Student()
s1.talk()

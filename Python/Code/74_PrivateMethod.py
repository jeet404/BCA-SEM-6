class Car:
    def __init__(self):
        self.__updateSoftware()

    def drive(self):
        print("Driving")

    def __updateSoftware(self):
        print("updating software")


redcar = Car()
redcar.drive()
# redcar.__updateSoftware() not accessible from object.

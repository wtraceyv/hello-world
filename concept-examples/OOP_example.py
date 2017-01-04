# example of a python class:
class Student:
    human = True # 'class-wide' var; true for all Students!
    def __init__ (self, name, coolness_rating, programmer):
        self.name = name
        self.coolness_rating = coolness_rating # let's act like it's a percentage
        self.programmer = programmer
    def say_name(self): # I guess you need a self no matter what for that self.name reference below...
        print "Hi, I'm " + self.name + "!"
    def state_attributes(self):
        programmer_string = "not a programmer :("
        if (self.programmer):
            programmer_string = "totally a programmer! :D"
        print "Hey, bruh. I'm "+self.name+", with a coolness rating of " + str(self.coolness_rating) + ". I am " + programmer_string

walter = Student("Walter", 100, True) # walter = var name, name ATTRIBUTE = "Walter"
noah = Student("Noah", 92, False)

print noah.state_attributes() # okay, yeah, he's a programmer and as cool as me, but we need variety here 
print walter.state_attributes() 


#I'm back...one more local push, just to test alias 

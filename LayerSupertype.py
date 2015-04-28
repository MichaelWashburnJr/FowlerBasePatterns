"""
Layer Supertype
A type that acts as the super type for ALL items in its layer.

This example shows a Layer Supertype in the Domain layer.
"""

class Person():
	"""
	A typical person class. Containing state relavent to all people.
	"""
	__slots__ = ('first_name', 'last_name', 'age')

	def __init__(self, first_name, last_name, age):
		self.first_name = first_name
		self.last_name = last_name
		self.age = age

	def __str__(self):
		return "%s %s, Age %d" % (self.first_name, self.last_name, self.age)

class Student(Person):
	"""
	A Student is a person usually, but also has professors, a gpa, etc.
	"""
	__slots__ = ('professors', 'gpa')

	def __init__(self, first_name, last_name, age, gpa, professors=[]):
		Person.__init__(self, first_name, last_name, age)
		self.gpa = gpa
		self.professors = professors

	def add_prof(self, Professor p):
		"""Add a professor to the students list of profs"""
		self.professors.append(p)


class Professor(Person):
	"""
	A professor is a person.  Professors also have students and an office number.
	"""
	__slots__ = ('students')

	def __init__(self, first_name, last_name, age, students=[]):
		Person.__init__(self, first_name, last_name, age)
		self.students = students

def main():
	#create a student and professor
	student = Student("Bobby", "Tables", 19, 4)
	prof = Professor("Stan", "Krutz", 27)
	#Print the info for student and professor using the
	#abstracted out str method
	print(student)
	print(prof)

main()

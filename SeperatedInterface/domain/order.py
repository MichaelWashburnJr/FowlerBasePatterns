"""
Order Interface
Order's are defined as such but not implemented here because
they are mapped directly into the database.
"""

class Order():
	__slots__ = ('customer_name', 'customer_weight', 'food')

	def __init__(self, food, name, weight):
		pass

	def save(self):
		pass
		
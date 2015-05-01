"""
The Customer can place an order.
"""
from order import Order

class Customer():
	__slots__ = ('name', 'weight')

	def __init__(self, name, weight):
		self.name = name
		self.weight = wieght

	def order(self, food):
		order = Order(food, self.name, self.weight)
		order.save()
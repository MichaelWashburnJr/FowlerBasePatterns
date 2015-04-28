Separated Interface Pattern
============================

##Definition:
Defines an interface in a separate package from its implementation.

##Reason:
It's good practice to reduce coupling by grouping classes into packages and
controling dependencies between them. However, sometimes you may need to invoke
methods that contridict the general flow of interaction between the packages.
If so, you should use a Separated Inteface to define an interface in one
package, and implement it in another.

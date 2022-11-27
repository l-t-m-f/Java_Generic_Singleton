# Multiton
 Simple Multiton in Java

This is a simple Multiton class. Basically, a Singleton factory. You can create new subclasses of Multiton and instanciate them with Mutltiton.GetInstance("NAME_YOUR_SINGLETON"). Each Singleton is contained within the HashMap of the Multiton class and each member of the HashMap can only be created once. Like a usual Singleton, the Multiton also has a private constructor.

# Generic Singleton

This is a generic Singleton. Basically, a Singleton factory which can create subclasses.
(This is a learning project. Feel free to point out any flaws.)

You can create new subclasses of Singleton and instanciate them with Singleton.GetInstance(Class<T>, Object[]) or alternatively Singleton.GetInstance(Class<T>, Class<?>[], Object[]) to request a specific constructor (parameter 2). 

The GetInstance is generic and safe to an extent (it can return anything that is a subclass of Singleton) because:

1. If the method's generic type is not matching its first argument's type, then the desirable "Type mismatch: cannot convert from X to Y" error prevents compilation. 

2. If the GetInstance() method's first argument is not a child of Singleton, then the desirable "The method GetInstance(Class<T>, String) in the type Singleton is not applicable for the arguments (Class<NOT_A_Singleton_CHILD>, String)" error message prevents compilation again.

Each Singleton is contained within the HashMap of the Singleton class and each member of the HashMap can only be created once.

 Programmed by
 Émile Fréchette

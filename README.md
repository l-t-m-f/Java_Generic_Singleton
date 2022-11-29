# Generic Multiton

This is a generic multiton. Basically, a Singleton factory which can create subclasses.
(This is a learning project. Feel free to point out any flaws.)

You can create new subclasses of Multiton and instanciate them with Mutltiton.GetInstance(Class<T>, Object[]) or alternatively Mutltiton.GetInstance(Class<T>, Class<?>[], Object[]) to request a specific constructor (parameter 2). See Demo.java for usage.

The GetInstance is generic and safe to an extent (it can return anything that is a subclass of Multiton) because:

1. If the method's generic type is not matching its first argument's type, then the desirable "Type mismatch: cannot convert from X to Y" error prevents compilation. 

2. If the GetInstance() method's first argument is not a child of Multiton, then the desirable "The method GetInstance(Class<T>, String) in the type Multiton is not applicable for the arguments (Class<NOT_A_MULTITON_CHILD>, String)" error message prevents compilation again.

Each Singleton is contained within the HashMap of the Multiton class and each member of the HashMap can only be created once.
This is what is divergent from a traditional Multiton. Instead of returning muliple instance of the same class, I return one instance of any of the multiple subclasses. Each is unique.
 
 Programmed by
 Émile Fréchette

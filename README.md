# Generic Multiton
 Pseudo-Generic Multiton in Java

This is a  Multiton class. Basically, a Singleton factory. 

You can create new subclasses of Multiton and instanciate them with Mutltiton.GetInstance("NAME_YOUR_SINGLETON".class, "Other_string_to_remove_or_change_in_your_implementation"). 

The GetInstance is generic and safe to an extent (it can return anything that is a subclass of Multiton) because:

1. If the generic type is not matching the first argument's type ("NAME_YOUR_SINGLETON".class) there is a "Type mismatch: cannot convert from X to Y" error to prevent compilation. 

2. If the first argument's is simply not a child of Multiton "The method GetInstance(Class<T>, String) in the type Multiton is not applicable for the arguments (Class<RandomObj>, String)" error prevent compilation again.

Each Singleton is contained within the HashMap of the Multiton class and each member of the HashMap can only be created once.

TO-DO: Improve line 45 to derive the parameterTypes from Multiton rather than leaving up to be hardcoded like that.

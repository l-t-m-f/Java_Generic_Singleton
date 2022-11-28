# Generic Multiton
 Pseudo-Generic Multiton in Java

This is a  Multiton class. Basically, a Singleton factory. It's safe and generic (at least its supposed to be).
(This is a learning project. Feel free to point out any flaws.)

You can create new subclasses of Multiton and instanciate them with Mutltiton.GetInstance("NAME_YOUR_SINGLETON".class, "Other_string_to_remove_or_change_in_your_implementation"). 

The GetInstance is generic and safe to an extent (it can return anything that is a subclass of Multiton) because:

1. If the method's generic type is not matching its first argument's type, then the desirable "Type mismatch: cannot convert from X to Y" error prevents compilation. 

2. If the GetInstance() method's first argument is not a child of Multiton, then the desirable "The method GetInstance(Class<T>, String) in the type Multiton is not applicable for the arguments (Class<NOT_A_MULTITON_CHILD>, String)" error message prevents compilation again.

Each Singleton is contained within the HashMap of the Multiton class and each member of the HashMap can only be created once.

Btw if that was not clear, the second argument of the method can be stripped out and changed for whatever you want. I just used to it demonstrate that the Multiton was working (see the main method).

TO-DO: Improve line 45 to derive the parameterTypes from Multiton rather than leaving up to be hardcoded like that.

 
 
 Programmed by
 Émile Fréchette

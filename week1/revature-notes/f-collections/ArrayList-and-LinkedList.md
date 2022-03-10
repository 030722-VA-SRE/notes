### ArrayList
An `ArrayList` is a concrete class which implements `List`. It is a data structure which contains an array within it, but can resize dynamically. Once it reaches maximum capacity, an `ArrayList` will increase its size by 50% by copying its elements to a new (internal) array. Traversal is fast (constant time) because elements can be randomly accessed via index, just like an array. Insertion or removal of elements is slow, however (linear time, since there is a risk of having to resize the underlying array).

### LinkedList
A `LinkedList` implements both the `List` and `Queue` interfaces, so it has all methods in both interfaces. The data structure is composed of nodes internally, each with a reference to the previous node and the next node - i.e. a doubly-linked list. Because of this structure, insertion or removal of elements is fast (no risk to resize, just change the nearest references), but traversal is slow for an arbitrary index.


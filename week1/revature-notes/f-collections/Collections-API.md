## Collections Framework
The Collections framework in Java is a set of classes and interfaces that implement commonly used data structures. A collection is a single object which acts as a container for other objects. The Collections API is organized in a class hierarchy shown in simplified version below:

![Collection API class hierarchy](https://javaconceptoftheday.com/wp-content/uploads/2014/11/CollectionHierarchy.png)

The important interfaces in the Collections API are:
* `Iterable` - guarantees the collection can be iterated over
* `List` - an ordered collection
* `Set` - a collection does not contain duplicates
* `Queue` - a collection that operates on a first-in-first-out (FIFO) basis
* `Map` - contains key/value pairs. Does not extend `Iterable`.

## Collections Class
The [Collections](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html) class - not to be confused with the Collection interface - defines many `static` helper methods which operate on any given collection. Use this class for help with sorting, searching, reversing, or performing other operations on collections.
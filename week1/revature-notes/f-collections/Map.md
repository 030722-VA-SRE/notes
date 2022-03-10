## Map Interface
Map does not implement the Collection interface, however it is considered to be part of the Collections framework. It is used to identify a value by a key, and each entry in a map is a key-value pair. Because it does not implement `Iterable`, Maps cannot be iterated over directly. Instead, one must either:
* use the `entrySet()` method to iterate over the set of `Map.Entry`
* use the `keySet()` method to iterate over the set of keys
* use the `values()` method to return a `Collection` of values which can then be iterated over

### HashMap
`HashMap` is a Map which:
* Stores elements in key-value pairs
* Insertion/Retrieval of element by key is fast
* Tradeoff is that it does not maintain the order of insertion
* Permits one null key and null values

### TreeMap
`TreeMap` is a Map whose:
* Keys are stored in a Sorted Tree structure
* Main benefit is that keys are always in a sorted order
* Insertion/Retrieval are slow
* Cannot contain null keys as null cannot be compared for sorting

### HashTable
`HashTable` is an older, thread-safe implementation of a `HashMap`. It does not allow null keys or null values.

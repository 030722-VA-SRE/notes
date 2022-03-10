### HashSet
A `HashSet` implements `Set` and is backed by a `HashMap`. It:
* Guarantees no ordering when iterating
* Allows one `null` value
* Allows fast insertion and traversal
* Does not maintain order in which you insert elements

### TreeSet
A `TreeSet` is a `Set` whose elements maintain sorted order when inserted. Internally, it is backed by a Sorted Tree. Insertion and removal of elements is slow, because the elements must maintain sorted order. It cannot contain any `null` values, since `null` cannot be compared to any object.

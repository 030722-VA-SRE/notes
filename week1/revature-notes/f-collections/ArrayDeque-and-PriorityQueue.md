## ArrayDeque

Pronounced as 'array-deck', this concrete class can be implemented for either the queue or stack data structure. It is an implementation of a pure double-ended queue (elements can be added or removed from either end of the queue). An `ArrayDeque` stores elements in a resizable array internally, and it has a few extra useful methods defined:
* `pop()`
* `push()`
* `peekFirst()`
* `peekLast()`
* `pollFirst()`
* `pollLast()`
* `offerFirst()`
* `offerLast()`

| Operation | Throws Exception | Returns null |
| --------- | ---------------- | ------------ |
| Insert    | `boolean add(E e)`|`boolean offer(E e)`|
| Remove    | `E remove()` | `E poll()` |
| Examine   | `E element()`| `E peek()`|


## PriorityQueue

We know that `Queue` serves the requests based on FIFO(First in First out) but sometimes the elements of the queue are needed to be processed according to the priority, that’s when the `PriorityQueue` comes into a picture.
 
A `PriorityQueue` serves the requests based on the priority heap. The elements of the priority queue are ordered according to their natural ordering, or by a `Comparator` provided at queue construction time, depending on which constructor is used. A priority queue does not permit `null` elements. A priority queue relying on natural ordering also does not permit insertion of non-comparable objects (doing so may result in `ClassCastException`).

### Methods of PriorityQueue Class

* `boolean	add(E e)` - Inserts the specified element into this priority queue.
* `void	clear()`- Removes all of the elements from this priority queue.
* `Comparator<? super E>	comparator()` - Returns the comparator used to order the elements in this queue, or null if this queue is sorted according to the natural ordering of its elements.
* `boolean	contains(Object o)` -Returns true if this queue contains the specified element.
* `Iterator<E>	iterator()` -Returns an iterator over the elements in this queue.
* `boolean	offer(E e)` -Inserts the specified element into this priority queue.
* `E	peek()` -Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
* `E	poll()` -Retrieves and removes the head of this queue, or returns null if this queue is empty.
* `boolean	remove(Object o)` -Removes a single instance of the specified element from this queue, if it is present.
* `int	size()` -Returns the number of elements in this collection.
* `Object[]	toArray()` -Returns an array containing all of the elements in this queue.
* `<T> T[]	toArray(T[] a)` -Returns an array containing all of the elements in this queue; the runtime type of the returned array is that of the specified array.


## Serialization
Serialization is the process of writing the state of an object to a byte stream; the reverse is called deserialization. In order for an object to be serialized, it must implement the `Serializable` interface.

### Marker Interfaces
`Serializable` is a **marker interface**, which is an interface with no methods. The point of such an interface is to *provide metadata* to the compiler - in this case, it tells the compiler that this class can be serialized.

### Serializing an object
To serialize an Object, you need a `FileOutputStream` instance inside the constructor of an `ObjectOutputStream`, passing in the file path of where you want the Object to be serialized
* Call the `ObjectOutputStream.writeObject(yourObject)` method

### Deserializing an object
To deserialize an Object, you need a `FileInputStream` instance inside the constructor of an `ObjectInputStream`, passing in the file path of where the serialized object is
* Call the `ObjectInputStream.readObject()` method, casting it to a bean of your type

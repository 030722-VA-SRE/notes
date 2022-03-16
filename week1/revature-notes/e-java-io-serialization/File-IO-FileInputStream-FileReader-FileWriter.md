## File I/O
"I/O" refers to the nature of how data is accessed, either by reading it from a resource (input) or writing it to a resource (output). In Java, File I/O objects fall into one of two categories:
* `Streams` are for reading or writing **bytes**
* `Reader/Writer` are for reading or writing **characters**

Some Common File I/O classes are
* `FileInputStream` - reads raw bytes from a file
* `FileOutputStream` - writes raw bytes to a file
* `FileReader` - reads characters from a file
* `FileWriter` - writes characters to a file
* `BufferedReader` - reads a file line by line, needs an instance of a `FileReader` with a path to the resource to be read in the constructor
* `BufferedWriter` - writes to a file line by line, needs an instance of a `FileWriter` with a path to the destination file in the constructor
* `Scanner` - can read from an `InputStream`, useful methods for character reading

Character files are read line by line, either until a carriage return (`\r`) or a newline (`\n`), depending on your operating system. When using I/O classes to read and write, you should **always close your resources** with the `.close()` method. This prevents exceptions from being thrown later, memory leaks, and system overutilization of unused resources.
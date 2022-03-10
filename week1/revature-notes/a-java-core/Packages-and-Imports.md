### Packages
```
package com.revature.mypackage;
```
This line declares the **package** in which the class will reside. This must always be the first (non-commented) line in a `.java` file. Packages are a way of organizing classes, interfaces, and enums in a hierarchical manner. Packages follow a naming convention of lowercase characters separated by periods in the reverse way you would specify a web domain - thus, `com.revature.mypackage` instead of `mypackage.revature.com`.

Also, classes can be referenced anywhere in a program by their "fully qualified class name" - which is the package declaration followed by the class, in order to uniquely identify the class. In our example, the fully qualified class name is `com.revature.mypackage.HelloWorld`.

But typically we do not want to write out a verbose package and class name together. Instead, we can use an `import` statement after our package declaration to pull in other classes. We can then just use the class name without the package. By default, everything in the `java.lang` package is imported (which gives us the `System` class we used in the example). Other packages and classes must be imported by the programmer explicitly.
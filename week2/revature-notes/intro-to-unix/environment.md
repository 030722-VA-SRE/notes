# Environment Variables

Environment variables are values that are accessible in an entire working environment. In Unix, these values are set in the shell when it is started. For example, your home directory is an environment variable called `$HOME`. If you wish to see the value of a particular environment variable, you can use the `echo` command like so: `echo $HOME`.

To set your own environment variables, you can use the `export` command. For example, if you wanted to create an environment variable to store the password to your server, you could issue the following:
```
export SERVER_PASS=password
echo $SERVER_PASS
```

However, if you issue the above command into your console, when you close the shell and open it again, your environment will no longer be present. To keep these environment variables, you will have to place the command in one of your startup files, usually 
```
~/.bashrc
```

You can also remove environment variables with the `unset` command: 
```
unset SERVER_PASS
echo $SERVER_PASS
```

## Practical Uses

So, what's the point of having environment variables? They have several different uses that we can discuss.

### PATH

The PATH variable is one of the most commonly used environment variables, and it typically already exists on your computer. The reason for this is that it is used to reference the locations of software installations on your machine, especially software that requires certain commands that can be used in the terminal. For example, when you install Git, your machine needs to know where it is installed so that when you try to run a `git` command, it knows what code it's supposed to run. Usually this variable is set automatically when you install these kinds of software, but occasionally you need to update or change it yourself, in which case it's important to be aware that it exists and how to do so.

### Server Secrets

Environment variables are a common place to store things like database connection info, credentials, and tokens. When running code on a server, that code may need this information to run, and having the code reference environment variables rather than storing this information directly in the code or in a file makes it easier to modify the variables easily as needed and prevent situations like accidentally pushing credentials to a public Git repository. This makes them *slightly* safer because that information doesn't risk leaving the computer that the environment variables are on - however, they are still relatively easy to access, so you should be careful not to store sensitive, unencrypted data this way in a production environment.

## On Windows

If you need to work with environment variables on Windows, you can either do so using PowerShell or editing them via settings.

- [Using PowerShell to work with environment variables](https://docs.microsoft.com/en-us/powershell/module/microsoft.powershell.core/about/about_environment_variables?view=powershell-7.2)
- [Working with environment variables in Windows 10 via settings](https://www.minitool.com/news/environment-variables-windows-10-005.html)
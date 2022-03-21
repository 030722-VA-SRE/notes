# HTML Forms

An  **HTML form**  is  _a section of a document_ that contains controls such as text fields, password fields, checkboxes, radio buttons, submit button, menus, etc. Using these elements the page can collect information from a user which is typically submitted to a web server.
To create a form, you would use the `<form>` tag.

 *Why use an HTML Form?*
* We use forms to collect some information/data form the user.
    * For example: If a user wants to purchase some items on the internet, he or she must fill out the form which will collect information such as the shipping address and payment details so that the item can be sent to the given address.
    
# Attributes Used in HTML Forms

There are several attributes that you can use on the `<form>` tag and on `<input>` elements. 
We will cover:

* action
* target
* name
* method
* value
* placeholder
* required

Take a look at the following example and find the different attributes:

```
<!DOCTYPE html> 
<html> 
<body> 
  
<form action="/test.php" target="_blank" method="GET"> 
  Username:<br /> 
  <input type ="text" name="username" placeholder="Username" required/> 
  <br /> 
  Password:<br /> 
  <input type ="password" name="password" /> 
  <br /><br /> 
  <input type ="submit" value ="Submit" /> 
</form>  
  
</body> 
</html> 
```

### The Action Attribute

The action attribute indicates where the form data will be processed. Typically the value is a URL of a server. 
Generally, the form data is sent to a webpage on the webserver after the user clicks on the submit button.

>In the above code, after clicking on the *submit* button, the form data would be sent to a page called *test.php*.


### The Target Attribute

The Target attribute is used to specify whether the submitted result will open in the current window, a new tab or on a new frame. 
The default value used is "self" which results in the form submission in the same window. 
To make the result display in a new browser tab, the value should be set to "blank".

> In the above code, after clicking on the *submit* button, the result will open in a new browser tab. Most often this attribute is not present and the default value of "self" is used.

### Name Attribute 

The name attribute should be provided for each input element. It is not required, but the value provides a label for the data once the form is submitted. 
If the name attribute is not specified in an input field then the data of that field will not be sent.

> In the above code, after clicking the *submit* button, the form data will be sent to a page called */test.php*. 
> The data sent will include the *username* and *password* fields.

### The Method Attribute

The method attribute is used to specify the HTTP method used to send data while submitting the form.
There are only two options available: GET and POST.

**GET** - When using the GET method, after the submission of the form, the form values will be visible in the address bar of the browser.

**POST** – When using the POST method, after the submission of the form, the form values will NOT be visible in the address bar of the browser.

### The value Attribute

The value attribute specifies an initial value for an input field. It also serves as the attribute to use when providing a button label for submit and reset input elements. 

> In the above example, there are no default values. 

### The placeholder Attribute

The placeholder attribute specifies a hint that describes the expected value of the input field (a sample value or a short description of the expected format).
The short hint is displayed in the input field before the user enters a value.
The placeholder attribute works with the following input types: text, search, url, tel, email, and password.

> In the above example, the text field has a placeholder of "Username".

### The required Attribute

The required attribute indicates an input field that must be filled out before submitting the form. In most modern browsers, it will prevent the user from submitting the form until an acceptable value is entered.
The required attribute works with the following input types: text, search, url, tel, email, password, date pickers, number, checkbox, radio, and file.

> In the above example, only the text field is required.  
> **NOTE**: The required attribute doesn't have a value portion. You only need to specify the word 'required'. 

### The min and max Attributes

The min and max attributes specify the minimum and maximum values for an input field.
The min and max attributes work with the following input types: number, range, date, datetime-local, month, time and week.

> **Tip**: Use the max and min attributes together to create a range of legal values. (For example: Set a maximum date or a minimum date)

*Example*
```
<form>
  <label for="datemax">Enter a date before 1980-01-01:</label>
  <input type="date" id="datemax" name="datemax" max="1979-12-31"><br><br>

  <label for="datemin">Enter a date after 2000-01-01:</label>
  <input type="date" id="datemin" name="datemin" min="2000-01-02"><br><br>

  <label for="quantity">Quantity (between 1 and 5):</label>
  <input type="number" id="quantity" name="quantity" min="1" max="5">
</form>>
```

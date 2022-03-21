# Types of CSS

There are three types of CSS which are given below: 
* Inline CSS
* Internal or Embedded CSS
* External CSS

### Inline CSS

Inline CSS contains the CSS property in the body section attached with element is known as inline CSS. This kind of style is specified within an **HTML tag using style attribute**. 

**Example:**

    <!DOCTYPE html> 
    <html> 
    <head> 
        <title>Inline CSS</title> 
    </head> 
    <body> 
        <p style = "color:#009900; 
		   font-size:50px; 
           font-style:italic; 
           text-align:center;">
			            Hello World
	       </p> 
    </body> 
    </html>  
     
### Internal or Embedded CSS

This can be used when a single HTML document must be styled  **uniquely**. The CSS rule set should be within the HTML file in the *head section* i.e the CSS is embedded within the HTML file.

**Example:**
 ```  
    <!DOCTYPE html> 
    <html> 
    <head> 
        <title>Internal CSS</title> 
        <style> 
            .main { 
                text-align:center;  
            } 
            .hi{ 
                color:#009900; 
                font-size:50px; 
                font-weight:bold; 
            } 
            .greeting { 
                font-style:bold; 
                font-size:20px; 
            } 
        </style> 
    </head> 
    <body> 
        <div class = "main"> 
            <div class ="hi"> Hi, Everyone!!</div>   
            <div class ="greeting"> 
                Hello World!! 
            </div> 
        </div> 
    </body> 
    </html>  
 ```           

### External CSS

External CSS contains separate CSS file which contains only style property with the help of tag attributes (For example class, id, heading, … etc). CSS property written in a separate file with .css extension and should be linked to the HTML document using **link** tag. This means that for each element, style can be set only once and  that will be applied across web pages.
 
**Example:** The file given below contains CSS property. This file should be saved with an .css extension. For Ex: **style.css**

```
    body {
	    background-color:powderblue;
	    }
	.main {
	    text-align:center;
	    }
	.hi {
		color:#009900;
	    font-size:50px;
	    font-weight:bold;
	    }
	#greeting {
	    font-style:bold;
	    font-size:20px; 
	    }
```

Below, we have HTML file that makes use of the above created external style sheet (style.css). This can be achieved by using `<link>` tag. The `<link>` element has *rel* and *href* attributes. The *rel* specifices the relationship between the current document and the linked document. In this case, *rel* attribute value will be *stylesheet* because we going to add the external style sheet to the HTML document. The *href*  attribute is used to specify the location of the external style sheet file.

```
    <html>
        <head> 
            <link rel="stylesheet" href="style.css"/> 
        </head> 
        <body> 
            <div class = "main"> 
                <div class ="hi"> Hi, Everyone !</div> 
                <div id = "greeting "> 
                    Hello world !!
                </div> 
            </div> 
        </body> 
    </html> 
```
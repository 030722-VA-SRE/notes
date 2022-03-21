## Starting HTML Documents

Every HTML document (ending with `.html` extension) should begin with a special tag known as the DOCTYPE declaration - this lets browsers know what kind of document it is using (HTML, in our case) as well as which version of the markup language is being used. For HTML5, the newest version and the one which we'll be using, the DOCTYPE syntax is:

```html
<!DOCTYPE html>
```

The doctype declaration tag does not have a closing tag and it is not self-closing either.

Next, the tag which begins the root of our HTML document is the `<html>` tag. Everything about our webpage will be nested within this tag.

Within the `html` element we have two important tags - the `<head>` and the `<body>` tags. The `head` element will contain all the metadata associated with this page, including the title, character encodingg, and references to external stylesheets. The `body` element contains the actual content of our page that will be rendered on the screen by the browser.

### Hello World Example

Let's write a simple webpage that will show off our knowledge of HTML thus far. Open up a new file in a simple text editor and save the file as `hello-world.html`. Then write the following HTML markup and save it:

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Hello World!</title>
    <meta charset="utf-8">
  </head>
  <body>
    <div>
      <!-- THIS IS A COMMENT! -->
      <p>This is my first paragraph written in HTML</p>
    </div>
  </body>
</html>
```

The only tag you may be unfamiliar with is the `meta` tag above - this defines the character encoding that the file will be using. Also, the `<!-- ... -->` syntax denotes a comment.

If you now open your `hello-world.html` file in your browser of choice, you'll see your webpage rendered. It may look ugly now, but we'll address that when we talk about CSS.

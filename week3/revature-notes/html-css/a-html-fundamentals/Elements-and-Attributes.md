## Elements

HTML is composed of many different **elements** - these provide the structure of the document. Elements are defined within HTML files using **tags** - for example, one very common tag is the `<div>` tag. The tag is enclosed within angle brackets. Most elements have a closing tag which define the end of the element, using the backslack notation - for example, a closing "div" tag would be `</div>`. HTML elements may be *nested* within other elements, like so:

```html
<div> text inside the div but outside the paragraph
  <p> this text is inside the paragraph </p>
</div>
```

In order for HTML to be **valid**, tags must be properly nested - an outer tag cannot be closed before an inner one. For example, the following markup would not be considered valid:

```html
<div> invalid!
  <p> cannot close the div here => </div>
</p>
```

Not all elements have closing tags, some are self-closing. For example, the `<img />` tag, which defines an image.

## Attributes

HTML elements can also have **attributes** defined within the tag - these are key/value pairs that give metadata about the tag that are important for the browser to know. For example, image elements must have a URL which the browser can call to retrieve the image file to display on the page - we use the `src` attribute to do this: `<img src="/URL/to/get/cat.png" alt="cool cat!" />`. As you may have guessed, the `alt` attribute specifies an alternative text to show when the image cannot be displayed.

### Global Attributes

**Global** attributes are those that can be applied to any element on the page. Some important global attributes are:

* class
* id
* hidden
* lang
* style
* tabindex
* title

There are also many attributes that should be applied to only certain elements, including the `src` and `alt` attributes shown above. We'll discuss more about these when relevant.

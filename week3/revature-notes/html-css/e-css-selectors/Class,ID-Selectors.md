## Class Selector

In the CSS, the class selector is a name preceded by a period (“.”).  It uses the class attribute of an HTML element to match the specific HTML element. We can have a Class selector specific to an HTML element *like we have `p.class` in the below example*.

In the below example, we have two class selectors inside the `<style>` element. The class selector `.intro` is applied to the element which has an attribute called `class`, whose value is `intro` and the `p.intro`  class selector is applied to the `<p>` element which has an attribute called `class`, whose value is `intro`. Also, the `<p>` element without the `class` attribute doesn't get affected.

```
<!DOCTYPE html>
<html>
<head>
<style>
.intro {
  text-align: center;
  color: red;
}

p.intro {
  text-align: center;
  color: blue;
}
</style>
</head>
<body>

<h1 class="intro">Red and center-aligned heading</h1>
<p class="intro">blue and center-aligned paragraph.</p> 
<p> this will not be affected </p>
</body>
</html>
```

## ID Selector

In the CSS, the ID selector is a name preceded by a hash character (“#”).  It uses the id attribute of an HTML element to match the specific HTML element. The **id** of an element should be unique within a page, so the id selector is used to select one unique element. 

*Example:* Here, we use `#para1` as an ID selector. Inside the body, we have two `<p>` elements. The CSS style rule applied to the element which has an attribute called `id`, whose value is `para1`. Therefore, `Hello World!` will be center-aligned also blue color.

```
<!DOCTYPE html>
<html>
<head>
<style>
#para1 {
  text-align: center;
  color: blue;
}
</style>
</head>
<body>

<p id="para1">Hello World!</p>
<p>This paragraph is not affected by the style.</p>

</body>
</html>
```

> *NOTE:* The id name should start with the alphabet, not with numbers. Also, the HTML element without the 'id' attribute doesn't get affected.
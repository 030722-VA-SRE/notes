## Basics of UI Design

Creating good user interfaces can be a difficult task. It is important that users of software be able to easily accomplish the tasks they would like without the design of the 
system getting in their way. Incoporating a few basic design principles can go a long way to making solid UIs.

We will cover the following UI design principles:
* Color
* Contrast
* Alignment
* Whitespace
* Scale
* Typography

## Color

Color is an important psychological component of user interfaces. It can induce a mood or emotion in the user, and different colors 
can have different meanings associated with them. Below are some colors and their common interpretations. Keep in mind these can be subjective.

* Black - luxury, wealth, elegance
* White - cleanliness, neatness
* Grey - emotionless
* Green - nature
* Blue - stability, reliability
* Yellow - joy
* Red - passion, love, danger

Choosing a color scheme with colors that work well together is essential to good UI design. A bad color scheme may feel disjointed or distracting to users. There 
are many online tools that can help you choose a well-integrated color scheme.

In CSS we can change the **text** color of an element via the `color` property, while `background-color` will change
the **fill** color of the element. Additionally, we can fade the background color (make it more transparent) with the
`opacity` property.

```
div.bluebox {
  color: blue;
  background-color: lightblue;
  opacity: 0.5; // half transparent
}
div.blackbox {
  color: white;
  background-color: black;
  opacity: 1
}
```

<div style="color: blue; background-color: lightblue; opacity: 0.5; height: 100px; width: 100px; display:inline-block; font-weight:bold">.bluebox</div>
<div style="color: white; background-color: black; opacity: 1; height: 100px; width: 100px; display:inline-block">.blackbox</div>

## Contrast

Contrast refers to the user's ability to distinguish between different areas of the UI. We can adjust contrast by manipulating the following with CSS:
* Text size and color
* Background color and transparency
* Font family and font weight

Foreground text and background colors should always be suffiently contrasted with each other. [Web accessibility standards](https://webaim.org/articles/contrast/) define a "contrast ratio" which
measures contrast on a scale of 1:1 (white text on white background) to 21:1 (black text on white background). The "minimum contrast ratio" recommended is **4.5:1**
which is a good benchmark to meet.

## Alignment

Aligning text, boxes, images, and other elements on a web page is a crucial - and often excruciating - part of web design. Luckily there are some tools in CSS we can use
to make alignment easier:
* CSS grid (or using a library like Bootstrap)
* Flexbox layouts
* `text-align` property
* `display` and `position` properties

Always remember that consistency is key when aligning HTML elements. Be aware of overflow issues as well, which can be mitigated with the `overflow` property.

## Whitespace

Whitespace is vital to good UI design, and don't hesitate to use it. Too little whitespace can make a design feel cluttered, and too much can feel empty or impede usability.

The primary CSS tools for managing whitespace revolve around the box model and its related properties:
* `border`
* `margin`
* `padding`
* `height` and `min-height`
* `width` and `min-width`
* `box-sizing`

Often times setting a suffient padding to key elements helps to improve design dramatically.

## Scale

Scale refers to the appropriate sizing of text and other elements on the page. Larger text and elements grab attention, while smaller sizes imply less important information.
Headings should be used and nested in order and never use a lower heading before a higher one (e.g. don't use an `<h4>` if you haven't used `<h3>` yet).

## Typography

Choosing an appropriate font is important and easy thanks to CSS and many open source fonts. Browsers have many built-in fonts to choose from, including Arial, Times 
New Roman, Helvetica, Verdana, and others. It is important to know the difference between serif and sans-serif fonts. Serif fonts are more decorative and have strokes
that finish off the end of letters, while sans-serif fonts do not (they have straight edges at end of letters). Sans-serif fonts are more widely used and accepted 
because they are considered easier to read. [Google has many extra fonts](https://fonts.google.com) you can download and use if you are not satisfied with default browser fonts.

Finally, it's important to note you can specify fallback fonts in CSS, in case one in particular is not supported by a browser:

```
div {
  font-family: Roboto, Verdana, Times New Roman, sans-serif
}
```

The sans-serif at the end of the list above just means that if no other fonts are available, the browser should choose its default sans-serif font to use.

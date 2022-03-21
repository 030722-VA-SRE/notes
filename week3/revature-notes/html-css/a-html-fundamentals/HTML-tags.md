# HTML Tags

## Common HTML Tags

There are a vast number of HTML tags you could use on your webpage, but below are listed the most common:

* `<div>` - defines a "division of the page"
* `<p>` - defines a paragraph
* `<span>` - an inline tag for grouping text or elements
* `<b>` - bold text
* `<i>` - italicized text
* `<h1>`, `<h2>`, ... `<h6>` - these are headings, h1 is largest and h6 is smallest
* `<br>` - line break
* `<table>` - defines a table
* `<img src="URL">`
* `<ol>` - an ordered list
* `<ul>` - an unordered list
* `<a href="">` - makes a hyperlink

### Hyperlinks

To make a hyperlink in a webpage, use the `<a>` tag:

```html
<p> Here is a <a href="www.google.com">link to Google!</a></p>
```

### Tables

To create a table, use the following markup. `<tr>` defines a table row, `<td>` defines a table cell, and `<th>` is used for table headers.

```html
<table>
  <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>1</td>
      <td>Alice</td>
    </tr>
    <tr>
      <td>2</td>
      <td>Bob</td>
    </tr>
    <tr>
      <td>3</td>
      <td>Charlie</td>
    </tr>
  </tbody>
</table>
```

### Lists

There are two options for making lists in HTML - ordered or unordered lists. Ordered lists are defined with `<ol>`, unordered lists are defined with `<ul>`, and the list items within either are denoted with `<li>`:

```html
<ol> <!-- ordered lists render as 1, 2, 3, etc.. -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ol>
<ul> <!-- list items in here will just be bullet points -->
  <li>First item</li>
  <li>Second item</li>
  <li>Third item</li>
</ul>
```
# HTML5 Semantic Elements

Semantic Elements defines the meaning for the web page rather than just presentation.


* The HTML elements like `<div>` and `<span>` are not releated to the content on the web page. This kind of elements are called as non semantic elements.
* The HTML elements like `<form>`, `<table>`, and `<article>` are used to define the content and  on the webpage. This kind of elements are called as semantic elements.

We will disscus about the following semantic elements that helps to define the element's purpose on the webpage:

```
<section>
<article>
<header>
<footer>
<nav>
<aside>
<figure>
<figcaption>
<details>
<mark>
<summary>
<time>
```

### Section

The HTML5 `<section>` tag defines a thematic grouping of content. In a document, we have sections like chapters, headers, footers, introduction, content, contact information, etc. 

*Example*
```
<section>
  <h1>Protocol</h1>
  <p>A protocol is a standard set of rules that allow electronic devices to communicate with each other.</p>
</section>
```

### Article

 The `<article>` element represents a section of content that forms an independent part of a document or site such as  Forum post, Blog post, Newspaper article, etc.,

*Example*
```
<article>
  <h1>What WHO do?</h1>
  <p>WHO works worldwide to promote health, keep the world safe, and serve the vulnerable. Our goal is to ensure that a billion more people have universal health coverage, to protect a billion more people from health emergencies, and provide a further billion people with better health and well-being..</p>
</article>
```

### Header

 The `<header>` element specifies a header for a document or section.

*Example*
```
<!-- example defines a header for an article -->
<article>
  <header>
    <h1>World Health Organisation</h1>
    <p>What we do?</p>
  </header>
  <p>WHO works worldwide to promote health, keep the world safe, and serve the vulnerable. Our goal is to ensure that a billion more people have universal health coverage, to protect a billion more people from health emergencies, and provide a further billion people with better health and well-being..</p>
</article>
```

### Footer

The `<footer>` element used to define the footer for a document or section. It contains information about the author of the document, copyright information, links to terms of use, contact information, etc.

*Example*
```
<footer>
  <p>Posted by: someone </p>
  <p>Contact information: <a href="mailto:someone@example.com">
  someone@example.com</a>.</p>
</footer>
```

### Navigation

The `<nav>` element is for major navigation blocks that specify a set of navigation links. 

*Example*
```
<nav>
  <a href="/html/">HTML</a> |
  <a href="/css/">CSS</a> |
  <a href="/js/">JavaScript</a> |
  <a href="/jquery/">jQuery</a>
</nav>
```

### Aside

The `<aside>` element is used to identify content that is related to the primary content of the web page. The content inside the `<aside>` element does not constitute the primary content of the page. For example, we can have author information, related links, related content, and advertisements.

*Example*
```
<p>I went TajMahal for this summer</p>

<aside>
  <h4>Taj Mahal</h4>
  <p>The Taj Mahal is an ivory-white marble mausoleum on the south bank of the Yamuna river in the Indian city of Agra.</p>
</aside>
```

### HTML figure and figcaption Elements

The `<figure>` element describes some flow content, optionally with a caption, that is self-contained and referenced as a single unit from the main flow of the document. The `<img>` and `<figcaption>` elements are grouped in a `<figure>` element. We use the `<img>` element to insert an image on the web page. To add the visual explanation of the image, we need a caption for that image. This can be achieved in the HTML5 by using `<figcaption>` element.

*Example*
```
<figure>
  <img src="WorldMap.jpg" alt="WorldMap">
  <figcaption>Fig1. - World Map </figcaption>
</figure>
```

### Other HTML Elements

* `<details>` - Used to add details that user can view or hide
* `<mark>` - Used to highlight or mark the text.
* `<summary>` - Defines a obvious heading for a `<details>` element
* `<time>` - Used to add a date/time. 


# HTML5 Audio tag

The HTML5 `<audio>` element used to embed audio in a web page.

**Example**
```
<body>

<h1>The audio element</h1>
<p>Click the Play button:</p>
<audio controls>
  <source src="River.ogg" type="audio/ogg">
  Invalid audio!!! - Browser doesn't support. 
</audio>

</body>
```
In the above example, we have two tags, `<audio>` and `<source>`. 

The `<audio>` element defines sound content and it has a *controls* attribute that adds audio controls, like play, pause, and volume. Any text within the `<audio>` and` </audio>` displayed on the browser only if the audio was not supported by the browser.

The `<source>` element defines the media resources for the audio files and it has attributes such as *src* and *type*. The *src* is used to specify the file format of the audio content and *type* specifies the media types that `<audio>` element supports.

The file format supported by `<audio>` element and respective media types are tabulated below: 

|File Format| Media Type|
| ------ | ------ |
|MP3| audio/mpeg|
|OGG| audio/ogg|
|WAV| audio/wav|


# HTML5 Video tag

The `<video>` element used to embed a video on a web page, such as a movie clip or other video streams.

**Example**
```
<body>

<h1>The video element</h1>
<video width="320" height="240" controls>
  <source src="movie.mp4" type="video/mp4">
    Invalid audio!!! - Browser doesn't support. 
</video>

</body>
```
HTML5 Video Attributes used in the above example are described below:

|Attribute| Value|  Description|
|-----|----|----|
|src  |URL| Specifies the URL of the video file|
|controls|  controls| Specifies the video controls such as a play/pause button, etc|
|height |pixels |Sets the height of the video player|
|width| pixels| Sets the width of the video player|

> Note: Any text between the `<video>` and `</video>` tags will be displayed in browsers that do not support the `<video>` element. 

The MIME Types  supported by the `<video>` element is tabulated below: 

|Format|  MIME-type|
|-----|----|
|MP4  |video/mp4|
|WebM |video/webm|
|Ogg  |video/ogg|

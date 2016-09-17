# How to create a Markdown file
<br>
Markdown is a writing tool that allows you to write plain text whilst tagging your formattings quickly
<br>
***
<br>
### Adding Code and syntax highlighting
<br>
By wrapping text in between three backquotes -- '`', not single quotations -- and a next line, you can make text appear in a box like most of my syntax examples are seen below.
<br>
If you add a language, like python, or java, or javascript, etc immediately following the first set of three backquotes, not only will the text go into its own box but it will also get highlighted according to the language you chose, as seen below
<br>
Real Example using python:
<br>
```python
def addOne(x):
    x+1
    return x
```
<br>
***
<br>
###Headings
<br>
To create headings you can put between one and six "#" before your title:
<br>
Syntax examples:
<br>
```
# My largest heading

###### My smallest heading
```
<br>
Real examples:
<br>
# Heading with one "#"
<br>
## Heading with two "#"
<br>
### Heading with three "#"
<br>
#### Heading with four "#"
<br>
##### Heading with five "#"
<br>
###### Heading with six "#"
<br>
***
<br>
###Horizontal Rule
<br>
You can add a small Horizontal Rule by having one line consist of only one minus sign or equal sign
<br>
Syntax example:
<br>
```
-

or

=
```
<br>
Real example:
<br>
-
<br>
You can add a wider Horizontal Rule by putting three underscores, asterisks, or minus signs together one line alone
<br>
Syntax Example:
<br>
```
___

or

---

or

***
```
<br>
Real Example:
<br>
***
<br>
***
<br>
###Phrase emphasis
<br>
You can make text italic by putting an asterisk or undescore before and after your statement
<br>
Syntax example:
<br>
```
*This would be italic if it wasn't in a code block*

_This would also be Italic because of the underscores_
```
<br>
Real Example:
<br>
Look, *this is Italic*, isn't that cool?
<br>
You can also make text bold by putting two asterisks or underscores around it
<br>
Syntax Example:
<br>
```
**This would be BOLD because this statement has two asterisks wrapped around it**

__This would be BOLD too__
```
<br>
Real example:
<br>
**BOLD TEXT**
<br>
Using a combination of underscores and asterisks you can make text bold and italic
<br>
Syntax example:
<br>
```
**Only Bold, _Bold and Italic,** Only Italic_
```
<br>
Real Example:
<br>
**Only Bold,** **_Bold and Italic,_** _Only Italic_
<br>
To put a line through text you can wrap it with two tildes
<br>
Syntax example:
<br>
```
~~This is wrong~~
```
<br>
Real Example:
<br>
~~This is wrong~~
<br>
***
<br>
###Listing items
<br>
To list items in an unordered list you can put a minus sign in front each item you want to list
<br>
Syntax example:
<br>
```
-Item One

-Item Two

-Item Three
```
<br>
Real example:
<br>
-Item One
<br>
-Item Two
<br>
-Item Three
<br>
For an ordered list you can just put them numbers with a period after in front of each item and it will automatically format the list for you
<br>
Syntax Example:
<br>
```
1. Item
2. Item
3. Item
```
<br>
Real Example:
<br>
1. Item
2. Item
3. Item
<br>
***
<br>
###Adding links to your Markdown File
<br>
Often times you will want to put links in your notes to other content.
<br>
To do this, you put the text you want to add a link to in square braces "[Click me to go to google.com]" followed by the URL in parentheses "(www.google.com)". After the URL in the parentheses you can add text to your link that will appear when a user hovers over the link by adding that message in quotations after your link like this: (google.com "This is a link to google")
<br>
Syntax example:
<br>
```
Why don't you [Click me to go to google.com](google.com "This link will take you to google")
```
<br>
Real example:
<br>
Why don't you [Click me to go to google.com](https://www.google.com/ "This link will take you to google")
<br>
***
<br>
###Tables
<br>
You can add tables to your Markdown by using hyphens and straight lines as seen below. By using colons too you can change how the text formats in the columns also seen below with the centered and right-alighed text
<br>
Syntax Example:
<br>
```
| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |
```
<br>
Real Example:
<br>

| Tables        | Are           | Cool  |
| ------------- |:-------------:| -----:|
| col 3 is      | right-aligned | $1600 |
| col 2 is      | centered      |   $12 |
| zebra stripes | are neat      |    $1 |

<br>
***
<br>
###Block Quotes
<br>
You can put test in a Block Quote by putting a '>' at the begining of the line, this will make that line stand out more. Using block quotes is good because it wraps text, unlike code and sysntax highlighting
<br>
Syntax example:
<br>
```
> This text will appear in a block quote
```

<br>
Real Example:
<br>
> This text will appear in a block quote

<br>
***
<br>
Adding a Youtube Video:
<br>
To add a youtube video it is best to use HTML because then you can add a border and image sizing that you would not have if you tried to add a video in pure Markdown
<br>
Syntax Example:
<br>
```
<a href="https://www.youtube.com/watch?v=6A5EpqqDOdk" target="_blank"><img src="http://img.youtube.com/vi/6A5EpqqDOdk/0.jpg" alt="A like to the Markdown Tutorial Video" width="240" height="180" border="10" /></a>"
```
<br>
Real Example:
<br>
<a href="https://www.youtube.com/watch?v=6A5EpqqDOdk" target="_blank"><img src="http://img.youtube.com/vi/6A5EpqqDOdk/0.jpg" alt="A like to the Markdown Tutorial Video" width="240" height="180" border="10" /></a>
<br>
***
<br>
###Inline HTML
<br>
You can also add raw HTML into your Markdown and it will work most of the time, as seen above with the Youtube video
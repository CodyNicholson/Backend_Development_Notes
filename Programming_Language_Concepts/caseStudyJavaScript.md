# Case Study: JavaScript

Explain JavaScript in relation to prior topics

- (scope and functions)

-

### CASE STUDY: JAVASCRIPT

Summary

- dynamically-typed
- object-oriented
- functional

Runs in browsers and elsewhere with Node.js

Inspired by

- Self: delegation-based object-oriented PL
- Scheme: dynamically-typed functional PL

JavaScript is not based on Java at all

As with Scala, JavaScript functions are objects

***

### JAVASCRIPT EVOLUTION

JavaScript standardized as ECMAScript, ECMA-262

ECMAScript 6th edition (ES6) most recent

- AKA ECMAScript 2015

Support

- ECMAScript 6 support in Mozilla (Firefox)
- ECMAScript Compatibility

***

### GETTING STARTED

Enter JS expression at browser console (dev. tools)

```
1 + 2
```

Print result as side-effect; undefined result

```
console.log (1 + 2);
```

Function declarations need return statements

```
function f (x) {
  console.log ("Called with " + x);
  return x + 1;
}

f (5);
```

(JS has statements and expressions)

***

### JS DEVELOPMENT OPTIONS

##### Use JS browser console

JS Bin online HTML/JS editing and execution

Add library jQuery 1.x

Add between body start/end tags in HTML

```
<input id="input-elt" type="text" value="empty"/>
```

Add in Javascript

```
$(document).ready (function () {
  // can add code here
  $('#input-elt').val (1 + 2); // and change expression
});
```

-

JS Bin online HTML/JS editing and execution

Add library jQuery 1.x

Add between body start/end tags in HTML

```
<div id="div-elt">empty</div>
```

Add in Javascript

```
$(document).ready (function () {
  $('#div-elt').text (1 + 2);
});
```

-

Webpage with output to DOM element

Download to same directory

- skeleton.html
- skeleton.js

Edit skeleton.js; (re)load skeleton.html in browser

***

### SCOPE

var declares new variable for function/global

Function scanned to find var declarations

Read of a before local var gives undefined

```
var a = 1;
function f () {
  console.log ("f1: a = " + a);
  var a = 2;
  console.log ("f2: a = " + a);
}
console.log ("1: a = " + a);
f ();
console.log ("2: a = " + a);
```

-

Scope in C-inspired PLs usually block oriented

Scope in JS is function oriented

ES6 introduces block-oriented scope with let

```
var a;
a = 1;
function f (b) {
  a = 2;
  console.log ("f1: a = " + a);
  if (b) {
    var a;
    a = a + 1;
    console.log ("f2: a = " + a);
  }
  console.log ("f3: a = " + a);
}
console.log ("1: a = " + a);
f (false);
console.log ("2: a = " + a);
f (true);
console.log ("3: a = " + a);
```

***

### LEXICAL SCOPE IN JS

Functions and objects are first-class citizens

- create at runtime
- pass as args, return, store in data structures

Nesting of functions (and objects) is allowed

- ...and commonplace

JS uses static (lexical) scoping

Applications of nested functions (JavaScript)

- GUI callbacks (DOM, JQuery, etc.)
- Async I/O tasks (AJAX, Node.js, etc.)
- Collections processing (Underscore, etc.)

***

### COLLECTIONS PROCESSING

JS libraries for functional collections processing

- Underscore
- Lodash

Use add library with JS Bin

```
$(document).ready (function () {
  var names1 = [ "alice", "bob", "charlie" ];
  var names2 = _.map (names1, function (name) { 
    return ("hi " + name); 
  });
  $('#input-elt').val (names2);   
});
```

ES6 adds arrow notation for anonymous functions

But read caveats in You Don't Know JS 

```
$(document).ready (function () {
  var names1 = [ "alice", "bob", "charlie" ];
  var names2 = _.map (names1, name => "hi " + name);
  $('#input-elt').val (names2);   
});
```

***

### COMMON SCOPE PROBLEM

Recall javac requires final i from enclosing scope

```
for (int i = 0; i < 5; i++) { // javac rejects because i mutates
  new Thread (new Runnable () {
      public void run () {
        while (true) { System.out.print (Integer.toString (i)); }
      }
    }).start ();
}
```

```
So a copy is made
for (int i = 0; i < 5; i++) { // 
  int x = i; // javac accepts "effectively final" copy of i
  new Thread (new Runnable () {
      public void run () {
        while (true) { System.out.print (Integer.toString (x)); }
      }
    }).start ();
}
```

-

JS allows shared i; rarely what you want

```
var funcs = [];
for (var i = 0; i < 5; i++) {
  funcs.push (function () { return i; });
}
console.log (funcs[0] ()); // prints 5 not 0
```

But how to copy i?

```
var funcs = [];
var x;
for (var i = 0; i < 5; i++) {
  x = i; // x is shared too!
  funcs.push (function () { return x; });
}
console.log (funcs[0] ()); // prints 4 not 0
```

var is not block scope

```
var funcs = [];
for (var i = 0; i < 5; i++) {
  var x = i; // x is still shared!
  funcs.push (function () { return x; });
}
console.log (funcs[0] ()); // prints 4 not 0
```

Genuinely copy i in ES6

```
var funcs = [];
for (var i = 0; i < 5; i++) {
  let x = i; // block scope
  funcs.push (function () { return x; });
}
console.log (funcs[0] ()); // prints 0
```

Before ES6, get function scope sneakily

```
var funcs = [];
for (var i = 0; i < 5; i++) {
  (function () { 
    var x = i;
    funcs.push (function () { return x; });
  }) ();
}
console.log (funcs[0] ()); // prints 0
```

***

### OBJECT LITERALS

JS is not class-based: no class definitions

Object literals have properties (name, age, addr)

```
// Object literal with no contents
var empty = {};

// Object literal with three properties
var person = {
  name: "Alice",
  age: 50,
  addr: "243 S Wabash Ave"
};
```

Updates can add properties

```
person.age = person.age + 1;
person.occupation = "Developer";
```

***

### DYNAMICALLY TYPED

```
function f (x) {
  try {
    console.log (x.data.length);
  } catch (e) {
    console.log ("Caught exception: " + e.name);
  }
}

f (5);
f ({ data: [1,2,3] });
```

***

### ENUMERATE PROPERTIES

Enumerate properties

Lookup by property name in string variable

```
var person = {
  name: "Alice",
  age: 50,
  addr: "243 S Wabash Ave"
};

for (p in person) {
  console.log (p + ": " + person[p]);
}
```

***

### FUNCTION PROPERTIES

Object properties can be functions

- functions are still called properties
- field/method terminology not used
- this is required

Evaluate

- counter.n
- counter.get
- counter.get ()

```
var counter = {
  n: 0,
  get: function () { return this.n++; }
};
```

***

### ENCAPSULATION FOR OBJECTS

Encapsulation via private fields/methods for PLs

JS properties cannot be declared private

- no classes
- which code could access "private" properties?

The counter state can be updated externally

```
var counter = {
  n: 0,
  get: function () { return this.n++; }
};

counter.n = 10;
```

-

Instead rely on scope

Object literal nested in function with local variable

n only in scope inside createCounter

```
function createCounter () {
  var n = 0;
  return {
    get: function () { return n++; } // n++ NOT this.n++
  };
};

var counter = createCounter ();
counter.get ();
```

-

Object with one function property is like a function

Scala version is similar; especially with ES6 arrow

```
function createCounter () {
  var n = 0;
  return function () { return n++; }; // n++ NOT this.n++
}

var counter = createCounter ();
counter ();
def createCounter () : () => Int = {
  var n = 0
  () => { val retVal = n; n = n + 1; retVal }
}

val counter = createCounter ()
counter ()
```

***

### DOCUMENT OBJECT MODEL

DOM tree model of HTML document

Browser displays runtime changes to DOM tree

JS introduced for manipulating DOM tree

Callback functions for event handling

```
<div id="some-id">
  ...
</div>
```

```
var elt = document.getElementById ("some-id");
elt.onclick = function () { alert ("foo"); };
elt.innerHTML = "<b>foo</b>";
elt.outerHTML = "<b>foo</b>";
```

***

### JQUERY

Several problems with direct DOM usage:

- browser implementations inconsistent
- DOM is cumbersome to use; too low-level

jQuery framework addresses both

Uses first-class functions, FP collections processing

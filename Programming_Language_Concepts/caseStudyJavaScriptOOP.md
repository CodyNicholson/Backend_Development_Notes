#Case Study: JavaScript OOP

Previously seen: JS object literals

No class declarations

Instead delegation/prototype based inheritance

- like Self
- runtime structures resemble vtables
- unusual setup in JS

***

###VIEW PROPERTIES

Iterate over properties on object (maybe more)

```
function getProps (obj) {
  var props = [];
  for (var f in obj) { 
    props.push (f); 
  }
  return props;
}

var o1 = { x: 5, y:10 };
var o2 = { x: 5, f: function () {} };

getProps (o1);  // Array [ "x", "y" ]
getProps (o2);  // Array [ "x", "f" ]
```

***

###MISSING PROPERTIES

Missing properties return special value undefined

undefined is not a function; error when invoked

```
var obj = { 
  n: 0,
  next: function () { return this.n++; }
};

obj.next ();    // OK

obj.reset;      // OK but returns 'undefined' value
obj.reset ();   // TypeError, 'undefined' not a function
```

***

###FUNCTION CONTEXT

Create an object with a function

Call with function context

Function builds and returns object literal

```
function makeCounter () {
  return {
    n: 0,
    next:  function () { return this.n++; },
    reset: function () { this.n = 0;      }
  };
}

var c = makeCounter (); // Function context 

c.next ();   // Returns 0
c.next ();   // Returns 1

getProps (c) // Returns Array [ "n", "next", "reset" ]
```

***

###CONSTRUCTOR CONTEXT

Call with constructor context

Object created with new

New object implicitly passed to function as this

```
function Counter () {
  this.n = 0;
  this.next = function () { return this.n++; },
  this.reset = function () { this.n = 0; }
}

var c = new Counter (); // Constructor context

c.next ();   // Returns 0
c.next ();   // Returns 1

getProps (c) // Returns Array [ "n", "next", "reset" ]
```

***

###DELEGATION TO PROTOTYPE

JS inheritance via delegation to another object

[[Prototype]] internal property of object

- points to another object

If property does not exist, search [[Prototype]]

- recursively search chain of [[Prototype]] links

Terminology

- textbook: delegation-based inheritance
- ECMAScript: prototype-based inheritance

***

CAUTION: these two are not the same

- [[Prototype]] internal property
- prototype property

Most objects do not have a prototype property, but do have a [[Prototype]] internal property

***

###SET PROTOTYPE PROPERTY

JS functions are objects, so can have properties

Define properties on prototype object of function

```
function Counter () {
  this.n = 0;
}

Counter.prototype.next  = function () { return this.n++; }
Counter.prototype.reset = function () { this.n = 0;      }
```

-

In constructor context, [[Prototype]] internal property of new object is set to prototype property of Counter function

```
function Counter () {
  this.n = 0;
}

Counter.prototype.next  = function () { return this.n++; }
Counter.prototype.reset = function () { this.n = 0;      }

var c1 = new Counter ();
var c2 = new Counter ();

c1.next ();    // Returns 0
c1.next ();    // Returns 1
c2.next ();    // Returns 0

getProps (c1); // Returns Array [ "n", "next", "reset" ]
getProps (c2); // Returns Array [ "n", "next", "reset" ]
```

-

c1 and c2 share Counter.prototype

Counter.prototype resembles vtable for a class

```
function Counter () {
  this.n = 0;
}

Counter.prototype.next  = function () { return this.n++; }
Counter.prototype.reset = function () { this.n = 0;      }

var c1 = new Counter ();
var c2 = new Counter ();
```

Distinguish properties from [[Prototype]]

```
function getProps2 (obj) {
  var props = [];
  for (var f in obj) { 
    if (obj.hasOwnProperty (f)) { props.push (f); }
  }
  return props;
}

function Counter () { this.n = 0; }

Counter.prototype.next  = function () { return this.n++; }
Counter.prototype.reset = function () { this.n = 0;      }

var c = new Counter ();
getProps (c);     // Returns Array [ "n", "next", "reset" ]
getProps2 (c);    // Returns Array [ "n" ]
```

***

###VERY DYNAMIC

Update or add methods at runtime!

```
function Counter () {
  this.n = 0;
}

Counter.prototype.next  = function () { return this.n++; }
var c = new Counter ();
c.next ();   // Returns 0

Counter.prototype.reset = function () { this.n = 0;      }
Counter.prototype.next  = function () { 
  var r = this.n; 
  this.n += 2; 
  return r; 
}
c.reset ();
c.next ();   // Returns 0
c.next ();   // Returns 2
```

***

###IMPLEMENTATION

Talk by Lars Bak 

V8: an open source JavaScript engine

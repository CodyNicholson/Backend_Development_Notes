String str = "Some String";

str.length();
Will equal an int, 11, because that is the length of the string

str.replace("o","X");
Will return "SXme String" by replacing o with X

str.trim();
Will delete all spaces and return "SomeString"

str.toUpperCase();
Will equal "SOME STRING"

str.toLowerCase();
will equal "some string"

river.toUpperCase().toLowerCase();
Will equal "some string" because toLowerCase() will execute after toUpperCase() executes

str.indexOf("o");
Will equal 1 because 1 is the index of the first "o" in str

str.substring(3,7);
will equal "e Str"

"Hello" + name;
will equal "HelloSome String"

Note: There are no methods that can mutate a string, only access
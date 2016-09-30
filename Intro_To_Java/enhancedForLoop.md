The Enhanced For loop is a shorthand method of coding:

for (int i = 0; i < someArrayList.size(); i++)


It is written:

for (ArrayType i : someArrayList)



Ex:

ArrayList<String> stringList = new ArrayList<String>();

stringList.add("Hello");
stringList.add("There");

for (String s : stringList)
{
    System.out.println(s);
}

// This will print:
// Hello
// There
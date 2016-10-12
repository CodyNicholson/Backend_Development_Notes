#Composite Pattern

An object that’s made up of multiple objects, which may in turn be made up of multiple objects. Think about a Tree structure

Clients interact with a single object and a composition of objects the same way

-

Example:

In Windows, a Folder can contain a list of files and/or Folders (recursive)

When searching, you don’t manually go into each folder and search

You search some root folder, and it will propagate search results from its files and subfolders

-

![alt tag](compositeUML.jpg)

-

###Composite Demo

You have a File class, a Folder class, and an interface IFileSystemItem

Set up the following folder structure:

```
Root
| - Folder 1
|           | - Folder 2
|   |   | - File 1
|   | - File 2
|- File 3
```

Calculate the total size of the folder structure

***

###Object Diagram

[alt tag](compositeObjDiagram.jpg)
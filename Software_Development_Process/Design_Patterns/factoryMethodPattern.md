# Factory Method Design Pattern

The Factory Method Pattern is a design pattern with the following properties:

***

### Intent:

Allows for creating objects without specifying their class, by invoking a factory method (a method whose main goal is to create class instances)

***

### Applicability:

This is useful in classes that cannot anticipate the type of objects it must create, that is, the type of an object is not known at compile time, this is common in frameworks

Also useful when a class wants its subclasses to specify the type of objects it creates

Lastly, it is useful when a class needs control over the creation of its objects

***

### Structure:

The structure of this pattern includes three classes: the Creator, the Concrete Creator, and the Product

***

### Participants:

The Creator provides the interface for the factory method, which when invoked will return an object of type Product

The Concrete Creator provides the actual factory method for creating the Product, that actual factory method in the Concrete Creator is the concrete implementation for the Creator's factory method interface

The Product is the object created by the factory method

-

Example:

```java
public class ImageReaderFactory
{
    public static ImageReader createImageReader(inputStream is)
    {
        int imageType = getImageType(is);
        switch(imageType)
        {
            case ImageReaderFactory.GIF
                return new GifReader(is);
            case ImageReaderFactory.JPEG
                return new JpegReader(is);
        }
    }
}

// This method takes an input stream as input and returns an ImageReader
// object and it is static so we can invoke it even if we don't have an instance of the ImageReaderFactory

// The method first gets the image type in the form of an integer,
// and then does one of several things based on that integer

// For example, if the input was a Gif, it would invoke the GifReader
// constructor, create a corresponding object, and return

// This is a situation where it is approperiate to use the Factory Method Pattern because
// this is a case where we don't know the type of the object we need to create until we run the
// code because it depends on the content of the input stream

// The key concept is that we want to delegate to the GifReader/JpegReader/etc the creation
// of the object once we know what type of object needs to be created
```

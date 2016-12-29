#Composition

**Composition** is another component of Object Oriented Programming

In inheritance - if a Car class inherits from a Vehicle class, then a Car is a Vehicle

In **Composition** - if a Car class *has* an Engine class, then the Car class is *composed* of an Engine class

The relationship is what makes the difference here - In inheritance we say a class *is* another class if it inherits from tht class. In composition we say a class (Class 1) *has* another class (Class 2) if that class (Class 2) is created inside Class 1

-

As a general rule in OOP, try using **composition** *before* you try using **inheritance** in your programs

-

```java
public static void main(String[] args)
{
	Dimensions dimensions = new Dimensions(20, 20, 5);
	Case theCase = new Case("220B", "Dell", "240", dimensions);
	Monitor monitor = new Monitor("27 inch Beast", "Acer", 27, new Resolution(2540, 1440));
	MotherBoard motherBoard = new MotherBoard("BJ-200", "Asus", 4, 6, "v2.44");

	PC pc = new PC(theCase, monitor, motherBoard);
	pc.getMonitor().drawPixelAt(1500, 1200, "red");
	pc.getMotherBoard().loadProgram("Window 1.0");
	pc.getCase().pressPowerButton();
}
/*
Output:

Drawing pixel at 1500, 1200 in color red
Program Window 1.0 is now loading
Power button pressed
*/
```

```java
public class MotherBoard
{
	private String model;
	private String manufacturer;
	private int ramSlots;
	private int cardSlots;
	private String bios;

	public MotherBoard(String model, String manufacturer, int ramSlot, int cardSlots, String bios)
	{
		this.model = model;
		this.manufacturer = manufacturer;
		this.ramSlots = ramSlots;
		this.cardSlots = cardSlots;
		this.bios = bios;
	}

	public void loadProgram(String programName)
	{
		System.out.println("Program " + programName + " is now loading");
	}

	public String getModel()
	{
		return model;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public int getRamSlots()
	{
		return ramSlots;
	}

	public int getCardSlots()
	{
		return cardSlots;
	}

	public String getBios()
	{
		return bios;
	}
}
```

```java
public class Monitor
{
	private String model;
	private String manufacturer;
	private int size;
	private Resolution nativeResolution;
	// Resolution is part of the Monitor class
	// This is composition

	public Monitor(String model, String manufacturer, int size, Resolution nativeResolution)
	{
		this.model = model;
		this.manufacturer = manufacturer;
		this.size = size;
		this.nativeResolution = nativeResolution;
	}

	public void drawPixelAt(int x, int y, String color)
	{
		System.out.println("Drawing pixel at " + x + ", " + y + " in color " + color);
	}

	public String getModel()
	{
		return model;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public int getSize()
	{
		return size;
	}

	public Resolution getNativeResolution()
	{
		return nativeResolution;
	}
}
```

```java
public class Resolution
{
	private int width;
	private int height;

	public Resolution(int width, int height)
	{
		this.width = width;
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
}
```

```java
public class Case
{
	private String model;
	private String manufacturer;
	private String powerSupply;
	private Dimensions dimensions;

	public Case(String model, String manufacturer, String powerSupply, Dimensions dimensions)
	{
		this.model = model;
		this.manufacturer = manufacturer;
		this.powerSupply = powerSupply;
		this.dimensions = dimensions;
	}

	public void pressPowerButton()
	{
		System.out.println("Power button pressed");
	}

	public String getModel()
	{
		return model;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public String getPowerSupply()
	{
		return powerSupply;
	}

	public Dimensions getDimensions()
	{
		return dimensions;
	}
}
```

```java
public class Dimensions
{
	private int width;
	private int height;
	private int depth;

	public Dimensions(int width, int height, int depth)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}

	public int getDepth()
	{
		return depth;
	}
}
```

```java
public class PC
{
	private Case theCase;
	private Monitor monitor;
	private MotherBoard motherBoard;

	public PC(Case theCase, Monitor monitor, MotherBoard motherBoard)
	{
		this.theCase = theCase;
		this.monitor = monitor;
		this.motherBoard = motherBoard;
	}

	public void powerUp()
	{
		theCase.pressPowerButton();
		drawLogo();
	}

	private void drawLogo()
	{
		// Draw fancy graphics
		monitor.drawPixelAt(1200, 50, "yellow");
	}

	Case getCase()
	{
		return theCase;
	}

	Monitor getMonitor()
	{
		return monitor;
	}

	MotherBoard getMotherBoard()
	{
		return motherBoard;
	}
}
```
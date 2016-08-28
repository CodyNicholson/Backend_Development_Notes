package patterns.visitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//class ObjectStructure extends Element {
class ObjectStructure {
    private HashSet<Element> elements;

    public void setElements(HashSet<Element> elements) {
        this.elements = elements;
    }

    // public void accept(Visitor v) {
    public void visit(Visitor v) {
        Iterator<Element> it = elements.iterator();
        while (it.hasNext()) {
            it.next().accept(v);
        }
    }
}

abstract class Visitor {
    private int total = 0;

    protected void addToTotal(int value) {
        // System.out.print("Total: before=" + total);
        total += value;
        // System.out.println(", after=" + total);
    }

    public int getResult() {
        return total;
    }

    public void visit(ElementA a) {
    }

    public void visit(ElementB b) {
    }

    public void visit(ElementC c) {
    }
    // and so on for other concrete elements
}

class ConcreteVisitor1 extends Visitor {
    @Override
    public void visit(ElementA a) {
        addToTotal(-a.getValueA());
    }

    @Override
    public void visit(ElementB b) {
        addToTotal(b.getValueB());
    }
}

class ConcreteVisitor2 extends Visitor {
    @Override
    public void visit(ElementC c) {
        addToTotal(c.getValueC());
    }

    @Override
    public void visit(ElementB b) {
        addToTotal(-b.getValueB());
    }
}

abstract class Element {
    public abstract void accept(Visitor v);
}

class ElementA extends Element {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getValueA() {
        return 1;
    }
}

class ElementB extends Element {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getValueB() {
        return 10;
    }
}

class ElementC extends Element {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public int getValueC() {
        return 100;
    }
}

public class VistorPattern {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        HashSet<Element> elements = new HashSet<Element>();
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        // Populate object structure
        for (int i = 0; i < 100; i++) {
            switch (rand.nextInt(3)) {
            case 0:
                elements.add(new ElementA());
                break;
            case 1:
                elements.add(new ElementB());
                break;
            case 2:
                elements.add(new ElementC());
                break;
            default:
                System.err.println("Shouldn't get here!");
                System.exit(1);
            }
        }
        os.setElements(elements);

        // perform visit
        ConcreteVisitor1 v1 = new ConcreteVisitor1();
        ConcreteVisitor2 v2 = new ConcreteVisitor2();

        os.visit(v1);
        os.visit(v2);

        System.out.println("Visitor 1 result: " + v1.getResult());
        System.out.println("Visitor 2 result: " + v2.getResult());
    }
}

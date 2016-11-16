#Final Review

###Which are valid statements?

```java
public interface IInterface{}

public class A
    implements IInterface{ }

public class B
    implements IInterface{ }

IInterface a = new A();
IInterface b = new B();

public static void main(String[] args)
{
    A a1 = (A) b; //Runtime error
    A a2 = a; //Compiler error
    B b1 = (B) new A(); //Compiler error
    A a3 = (A) a; //Compiles and runs
}
```

***

###Which of the following are true?

```java
public class C
{
    public int _i;
    public boolean _j;
    public C(int i, boolean j)
    {
        _i = i;
        _j = j;
    }
    public boolean equals(Object that)
    {
        if(that == null || !(that instanceof C))
            return false;
        C thatC = (C) that;
        return this._i == thatC._i && this._j == thatC._j;
    }
}
```

```java
C c1 = new C(22, false);
C c2 = c1;
C c3 = new C(22, false);

1. c1 == c2      //
2. c1.equals(c2) //
3. c1 == c3      //False because c1 and c3 point to different objects
4. c1.equals(c3) //True because you are passing through the same values
```

***

###What is output by the following code?

```java
class A {
    A() { System.out.println("A()"); }
}
class B extends A {
    B() { System.out.println("B()"); }
}
class C extends B { }
class Main {
    public static void main(String[] args){
        A obj = new C();
    }
}
```

This will return "A()" and then "B()"

First it will

***

###What is the output of this code?

```java
class A { void m() { System.out.println("A.m()"); } }
class B extends A {
    void m() { System.out.println("B.m()"); }
    void f() {
    this.m();
    super.m();
    A a = (A) this;
    a.m();
    }
}
class C extends B { void m() { System.out.println("C.m()"); } }
class Main {
    public static void main(String[] args){
        A obj = new C();
        ((B)obj).f();
    }
}
//This will output: "C.m()", "A.m()", "C.m()"
//
```

###Add a static factory to this code:

```java
public interface IPasswordHasher {
    public String hash();
}
class SHA256 implements IPasswordHasher {
    private String _password;
    SHA256(String password) { _password = password; }
    public String hash() {
        String salt = // create salt
        return getHashedPassword(_password, salt);
     }
    public String getHashedPassword(String password, String salt){ // SHA-256 Hashing Algorithm }
}
class MD5 implements IPasswordHasher {
    private String _password;
    MD5(String password) { _password = password; }
    public String hash() {
        String salt = // create salt
        return getHashedPassword(_password, salt);
    }
    public String getHashedPassword(String password, String salt){ // SHA-256 Hashing Algorithm }
}

//Add this:

public class PasswordHasherFactory
{
    public IPasswordHasher createMD5(String password)
    {
       return new MD5(password);
    }
    public IPasswordHasher createSHA256(String password)
    {
       return new SHA256(password);
    }
}
```

-

###Refactor to use Strategy pattern:

```java
Find on d2l
```

***

###Refactor to use Template Pattern

```java
find on d2l
```
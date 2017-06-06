# C# Tutorial

```cs
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace C_Sharp_Tutorial
{
    class Program
    {
        // Delegates are used to pass methods as arguments to other methods
        // A delegate can represent a method with a similar return type and attribute list
        delegate double GetSum(double num1, double num2);

        // ---------- ENUMS ----------
        // Enums are unique types with symbolic names and associated values

        public enum Temperature
        {
            Freeze,
            Low,
            Warm,
            Boil
        }

        // ---------- STRUCT ----------
        // A struct is a custom type that holds data made up from different data types
        struct Customers
        {
            private string name;
            private double balance;
            private int id;

            public void createCust(string n, double b, int i)
            {
                name = n;
                balance = b;
                id = i;
            }

            public void showCust()
            {
                Console.WriteLine("Name : " + name);
                Console.WriteLine("Balance : " + balance);
                Console.WriteLine("ID : " + id);
            }
        }
    }
}
```

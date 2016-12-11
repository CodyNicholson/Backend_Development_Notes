using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarbageCollectionDemo
{
    class Program
    {
        static void Main(string[] args)
        {
            using (Calculator calculator = new Calculator())
            {
                Console.WriteLine("{0} / {1} = {2}", 120, 0, calculator.Divide(120, 0)); 
            }
 
            Console.WriteLine("Program finishing");
        }
    }
}

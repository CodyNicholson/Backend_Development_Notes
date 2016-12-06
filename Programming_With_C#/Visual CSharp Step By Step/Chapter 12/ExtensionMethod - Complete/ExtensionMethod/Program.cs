using System;
using Extensions;

namespace ExtensionMethod
{
    class Program
    {
        static void doWork()
        {
            int x = 591;
            for (int i = 2; i <= 10; i++)
            {
                Console.WriteLine("{0} in base {1} is {2}", 
                    x, i, x.ConvertToBase(i)); 
            }		
        }

        static void Main()
        {
            try
            {
                doWork();
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception: {0}", ex.Message);
            }
        }
    }
}

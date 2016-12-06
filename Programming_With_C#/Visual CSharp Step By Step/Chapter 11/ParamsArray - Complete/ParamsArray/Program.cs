#region Using directives

using System;
using System.Collections.Generic;
using System.Text;

#endregion

namespace ParamsArray
{
    class Program
    {
        static void doWork()
        {
            // Console.WriteLine(Util.Sum(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));		
            Console.WriteLine(Util.Sum(2, 4, 6, 8, 10));
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

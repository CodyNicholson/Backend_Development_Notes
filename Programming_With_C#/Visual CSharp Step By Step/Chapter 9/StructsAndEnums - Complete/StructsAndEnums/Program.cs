#region Using directives

using System;
using System.Collections.Generic;
using System.Text;

#endregion

namespace StructsAndEnums
{
    class Program
    {
        static void doWork()
        {
            // Month first = Month.December; 
            // Console.WriteLine(first);
            // first++; 
            // Console.WriteLine(first);
            // Date defaultDate = new Date();
            // Console.WriteLine(defaultDate);
            Date weddingAnniversary = new Date(2013, Month.July, 4); 
            Console.WriteLine(weddingAnniversary);
            Date weddingAnniversaryCopy = weddingAnniversary; 
            Console.WriteLine("Value of copy is {0}", weddingAnniversaryCopy);
            weddingAnniversary.AdvanceMonth(); 
            Console.WriteLine("New value of weddingAnniversary is {0}", weddingAnniversary);
            Console.WriteLine("Value of copy is still {0}", weddingAnniversaryCopy); 
        }

        static void Main()
        {
            try
            {
                doWork();
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}

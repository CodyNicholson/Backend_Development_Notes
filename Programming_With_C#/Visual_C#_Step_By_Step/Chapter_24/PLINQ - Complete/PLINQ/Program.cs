using System;
using System.Collections.Generic;
using System.Linq;
using System.Diagnostics;
using System.Threading;
using System.Globalization;

namespace PLINQ
{
    class Program
    {
        public const int NUM = int.MaxValue / 1000;

        static void Main(string[] args)
        {
            // Test1();
            Test2();
        }

        public static void Test1()
        {
            Console.WriteLine("\nTest 1");

            int[] numbers = new int[NUM];
            Random random = new Random(999);

            for (int i = 0; i < NUM; i++)
            {
                numbers[i] = random.Next(200);
            }

            // TO DO: Create a LINQ query that retrieves all numbers that are greater than 100
            var over100 = from n in numbers.AsParallel() 
                          where TestIfTrue(n > 100) 
                          select n;

            Stopwatch timer = new Stopwatch();
            timer.Start();

            // TO DO: Run the LINQ query and save the results in a List<int> object
            List<int> numbersOver100 = new List<int>(over100);

            long milliseconds = timer.ElapsedMilliseconds;
            timer.Stop();

            // TO DO: Display the results
            Console.WriteLine("There are {0} numbers over 100.", numbersOver100.Count);

            Console.WriteLine("Time taken was {0} ms", milliseconds);
        }

        public static bool TestIfTrue(bool expr)
        {
            Thread.SpinWait(1000);
            return expr;
        }

        public static void Test2()
        {
            Console.WriteLine("\nTest 2");

            try
            {
                // TO DO: Create a LINQ query that retrieves customers and orders from arrays
                // Store each row returned in an OrderInfo object
                var orderInfoQuery = from c in CustomersInMemory.Customers.AsParallel() 
                                     join o in OrdersInMemory.Orders.AsParallel() 
                                     on c.Split(',')[0] equals o.Split(',')[1] 
                                     select new OrderInfo 
                                     { 
                                         CustomerID = c.Split(',')[0], 
                                         CompanyName = c.Split(',')[1], 
                                         OrderID = Convert.ToInt32(o.Split(',')[0]), 
                                         OrderDate = Convert.ToDateTime(o.Split(',')[2], new CultureInfo("en-US")) 
                                     };

                Stopwatch timer = new Stopwatch();
                timer.Start();

                // TO DO: Run the LINQ query and save the results in a List<OrderInfo> object
                List<OrderInfo> orderInfo = new List<OrderInfo>(orderInfoQuery);

                long milliseconds = timer.ElapsedMilliseconds;
                timer.Stop();

                // TO DO: Display the results
                Console.WriteLine("There are {0} orders", orderInfo.Count);

                Console.WriteLine("Time taken for joining two arrays in memory: {0} ms", milliseconds);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: {0}", ex.Message);
            }
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using BinaryTree;

namespace BuildTree
{
    class Program
    {
        static void Main(string[] args)
        {
            Tree<char> charTree = null; 
            InsertIntoTree<char>(ref charTree, 'M', 'X', 'A', 'M', 'Z', 'Z', 'N'); 
            string sortedData = charTree.WalkTree(); 
            Console.WriteLine("Sorted data is: {0}", sortedData);
        }

        static void InsertIntoTree<TItem>(ref Tree<TItem> tree, 
            params TItem[] data) where TItem :IComparable<TItem>
        {
            foreach (TItem datum in data)
            {
                if (tree == null)
                { 
                    tree = new Tree<TItem>(datum); 
                }
                else 
                { 
                    tree.Insert(datum); 
                } 
            }
        }
    }
}

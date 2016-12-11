using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BinaryTree
{
    class TreeEnumerator<TItem> : IEnumerator<TItem> where TItem : IComparable<TItem>
    {
        private Tree<TItem> currentData = null; 
        private TItem currentItem = default(TItem); 
        private Queue<TItem> enumData = null;

        public TreeEnumerator(Tree<TItem> data) 
        {
            this.currentData = data;
        }

        private void populate(Queue<TItem> enumQueue, Tree<TItem> tree) 
        {
            if (tree.LeftTree != null) 
            { 
                populate(enumQueue, tree.LeftTree); 
            }
            
            enumQueue.Enqueue(tree.NodeData); 
            
            if (tree.RightTree != null)
            {
                populate(enumQueue, tree.RightTree); 
            } 
        }

        TItem IEnumerator<TItem>.Current
        {
            get
            {
                if (this.enumData == null)
                {
                    throw new InvalidOperationException("Use MoveNext before calling Current");
                }

                return this.currentItem;
            }
        }

        void IDisposable.Dispose()
        {
            // throw new NotImplementedException();
        }

        object System.Collections.IEnumerator.Current
        {
            get { throw new NotImplementedException(); }
        }

        bool System.Collections.IEnumerator.MoveNext()
        {
            if (this.enumData == null) 
            {
                this.enumData = new Queue<TItem>(); 
                populate(this.enumData, this.currentData); 
            }
            
            if (this.enumData.Count > 0) 
            {
                this.currentItem = this.enumData.Dequeue(); 
                return true; 
            }
            
            return false;
        }

        void System.Collections.IEnumerator.Reset()
        {
            throw new NotImplementedException();
        }
    }
}

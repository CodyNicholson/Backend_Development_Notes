using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;

namespace Customers
{
    public class ViewModel : INotifyPropertyChanged 
    {
        private List<Customer> customers;
        private int currentCustomer;
        public Command NextCustomer { get; private set; }
        public Command PreviousCustomer { get; private set; }
        public Command FirstCustomer { get; private set; }
        public Command LastCustomer { get; private set; }
        
        public ViewModel() 
        {
            this.currentCustomer = 0;
            this.IsAtStart = true;
            this.IsAtEnd = false;
            this.NextCustomer = new Command(this.Next, () => 
                { return this.customers.Count > 0 && !this.IsAtEnd; }); 
            this.PreviousCustomer = new Command(this.Previous, () => 
                { return this.customers.Count > 0 && !this.IsAtStart; });
            this.FirstCustomer = new Command(this.First, () => 
                { return this.customers.Count > 0 && !this.IsAtStart; });
            this.LastCustomer = new Command(this.Last, () => 
                { return this.customers.Count > 0 && !this.IsAtEnd; });

            this.customers = DataSource.Customers;
        }

        private bool _isAtStart; 
        public bool IsAtStart 
        { 
            get { return this._isAtStart; } 
            set 
            { 
                this._isAtStart = value; 
                this.OnPropertyChanged("IsAtStart"); 
            }
        }
        
        private bool _isAtEnd; 
        public bool IsAtEnd 
        { 
            get { return this._isAtEnd; } 
            set 
            { 
                this._isAtEnd = value; this.OnPropertyChanged("IsAtEnd"); 
            } 
        }

        public Customer Current 
        { 
            get { return this.customers[currentCustomer]; } 
        }

        private void Next() 
        { 
            if (this.customers.Count - 1 > this.currentCustomer) 
            { 
                this.currentCustomer++; 
                this.OnPropertyChanged("Current"); 
                this.IsAtStart = false; 
                this.IsAtEnd = (this.customers.Count - 1 == this.currentCustomer); 
            } 
        }
        
        private void Previous() 
        { 
            if (this.currentCustomer > 0) 
            {
                this.currentCustomer--; 
                this.OnPropertyChanged("Current"); 
                this.IsAtEnd = false; 
                this.IsAtStart = (this.currentCustomer == 0); 
            } 
        }

        private void First()
        {
            this.currentCustomer = 0;
            this.OnPropertyChanged("Current");
            this.IsAtStart = true;
            this.IsAtEnd = (this.customers.Count == 0);
        }

        private void Last()
        {
            this.currentCustomer = this.customers.Count - 1;
            this.OnPropertyChanged("Current");
            this.IsAtEnd = true;
            this.IsAtStart = (this.customers.Count == 0);
        }

        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void OnPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this,new PropertyChangedEventArgs(propertyName));
            }
        }
    }
}

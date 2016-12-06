using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ComponentModel;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Text.RegularExpressions;

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
        private const string ServerUrl = "http://localhost:50000/";
        private HttpClient client = null;
        
        public ViewModel() 
        {
            this.currentCustomer = 0;
            this.IsAtStart = true;
            this.IsAtEnd = false;
            this.NextCustomer = new Command(this.Next, () => 
                { return this.CanBrowse && this.customers != null && this.customers.Count > 0 && !this.IsAtEnd; }); 
            this.PreviousCustomer = new Command(this.Previous, () =>
                { return this.CanBrowse && this.customers != null && this.customers.Count > 0 && !this.IsAtStart; });
            this.FirstCustomer = new Command(this.First, () =>
                { return this.CanBrowse && this.customers != null && this.customers.Count > 0 && !this.IsAtStart; });
            this.LastCustomer = new Command(this.Last, () =>
                { return this.CanBrowse && this.customers != null && this.customers.Count > 0 && !this.IsAtEnd; });

            this.customers = null;
            this.client = new HttpClient();
            client.BaseAddress = new Uri(ServerUrl);
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
        }

        #region Methods for fetching and updating data

        // Helper method to validate customer details
        private bool ValidateCustomer(Customer customer)
        {
            string validationErrors = string.Empty;
            bool hasErrors = false;

            if (string.IsNullOrWhiteSpace(customer.FirstName))
            {
                hasErrors = true;
                validationErrors = "First Name must not be empty\n";
            }

            if (string.IsNullOrWhiteSpace(customer.LastName))
            {
                hasErrors = true;
                validationErrors += "Last Name must not be empty\n";
            }

            // Email address is a series of characters that do not include a space or @
            // followed by @
            // followed by a series of characters that do not include a space or @
            // followed by .
            // followed by a series of characters that do not include a space or @
            Regex emailRegex = new Regex(@"^[^@ ]+@[^@ ]+\.[^@ ]+$");
            if (string.IsNullOrWhiteSpace(customer.EmailAddress) ||
                !emailRegex.IsMatch(customer.EmailAddress))
            {
                hasErrors = true;
                validationErrors += "Invalid Email Address\n";
            }

            // Phone number is a series of digits, brackets, spaces, +, and - characters
            Regex phoneRegex = new Regex(@"^[0-9\(\)\/+ \-]+$");
            if (string.IsNullOrWhiteSpace(customer.Phone) ||
                !phoneRegex.IsMatch(customer.Phone))
            {
                hasErrors = true;
                validationErrors += "Invalid Phone Number\n";
            }

            return !hasErrors;
        }

        // Utility method for copying the details of a customer
        private void CopyCustomer(Customer source, Customer destination)
        {
            destination.CustomerID = source.CustomerID;
            destination.EmailAddress = source.EmailAddress;
            destination.FirstName = source.FirstName;
            destination.LastName = source.LastName;
            destination.Phone = source.Phone;
            destination.Title = source.Title;
            destination.rowguid = source.rowguid;
            destination.ModifiedDate = source.ModifiedDate;
        }

        public async Task GetDataAsync()
        {
            try
            {
                this.IsBusy = true;
                //await Task.Delay(5000);
                var response = await this.client.GetAsync("api/customers");
                if (response.IsSuccessStatusCode)
                {
                    var customerData = await response.Content.ReadAsAsync<IEnumerable<Customer>>();
                    this.customers = customerData as List<Customer>;
                    this.currentCustomer = 0;
                    this.OnPropertyChanged("Current");
                    this.IsAtStart = true;
                    this.IsAtEnd = (this.customers.Count == 0);
                }
                else
                {
                    // TODO: Handle GET failure
                }
            }
            catch (Exception e)
            {
                // TODO: Handle Errors
            }
            finally
            {
                this.IsBusy = false;
            }
        }

        #endregion

        #region Properties for "busy" and error message handling

        private bool _isBusy;
        public bool IsBusy
        {
            get { return this._isBusy; }
            set
            {
                this._isBusy = value;
                this.OnPropertyChanged("IsBusy");
            }
        }

        #endregion

        #region Properties for managing the edit mode

        // Manage the edit mode of the form - is the user browsing, adding a customer, or editing a customer
        private enum EditMode { Browsing, Adding, Editing };
        private EditMode editMode;
        public bool IsBrowsing
        {
            get { return this.editMode == EditMode.Browsing; }
            private set
            {
                if (value)
                {
                    this.editMode = EditMode.Browsing;
                }
                this.OnPropertyChanged("IsBrowsing");
                this.OnPropertyChanged("IsAdding");
                this.OnPropertyChanged("IsEditing");
                this.OnPropertyChanged("IsAddingOrEditing");
            }
        }

        public bool IsAdding
        {
            get { return this.editMode == EditMode.Adding; }
            private set
            {
                if (value)
                {
                    this.editMode = EditMode.Adding;
                }
                this.OnPropertyChanged("IsBrowsing");
                this.OnPropertyChanged("IsAdding");
                this.OnPropertyChanged("IsEditing");
                this.OnPropertyChanged("IsAddingOrEditing");
            }
        }

        public bool IsEditing
        {
            get { return this.editMode == EditMode.Editing; }
            private set
            {
                if (value)
                {
                    this.editMode = EditMode.Editing;
                }
                this.OnPropertyChanged("IsBrowsing");
                this.OnPropertyChanged("IsAdding");
                this.OnPropertyChanged("IsEditing");
                this.OnPropertyChanged("IsAddingOrEditing");
            }
        }

        public bool IsAddingOrEditing
        {
            get { return this.IsAdding || this.IsEditing; }
        }

        private bool CanBrowse
        {
            get
            {
                return this.IsBrowsing &&
                   this.client != null;
            }
        }

        private bool CanSaveOrDiscardChanges
        {
            get
            {
                return this.IsAddingOrEditing &&
                       this.client != null;
            }
        }

        #endregion

        #region Methods and properties for navigation commands

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
            get
            {
                if (this.customers != null)
                {
                    return this.customers[currentCustomer];
                }
                else
                {
                    return null;
                }
            }
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

        #endregion

        #region INotifyPropertyChanged interface

        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void OnPropertyChanged(string propertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this,new PropertyChangedEventArgs(propertyName));
            }
        }

        #endregion
    }
}

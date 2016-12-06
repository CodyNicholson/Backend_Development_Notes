using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234238

namespace Customers
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();
            Window.Current.SizeChanged += WindowSizeChanged;

            List<string> titles = new List<string> { "Mr", "Mrs", "Ms", "Miss" }; 
            this.title.ItemsSource = titles; 
            this.cTitle.ItemsSource = titles;

            ViewModel viewModel = new ViewModel();
            (Application.Current as App).MainViewModel = viewModel;
            this.DataContext = viewModel;
        }

        void WindowSizeChanged(object sender, Windows.UI.Core.WindowSizeChangedEventArgs e)
        {
            if (e != null && e.Size.Width <= 750)
            {
                VisualStateManager.GoToState(this, "ColumnarLayout", false);
            }
            else
            {
                VisualStateManager.GoToState(this, "TabularLayout", false);
            }
        }

        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            Customer selectedCustomer = e.Parameter as Customer;
            
            // If the Customer passed in as the parameter is not null
            // then go to that customer
            if (selectedCustomer != null)
            {
                ViewModel viewModel =(Application.Current as App).MainViewModel;
                this.DataContext = viewModel;
                viewModel.GoTo(selectedCustomer);
            }
            this.WindowSizeChanged(this, null);
        }
    }
}

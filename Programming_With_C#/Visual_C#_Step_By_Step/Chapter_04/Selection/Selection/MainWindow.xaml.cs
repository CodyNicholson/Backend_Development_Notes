using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234238

namespace Selection
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainWindow : Page
    {
        public MainWindow()
        {
            this.InitializeComponent();
        }

        private void compareClick(object sender, RoutedEventArgs e)
        {
            int diff = dateCompare(first, second);
            info.Text = "";
            show("firstDate == secondDate", diff == 0);
            show("firstDate != secondDate", diff != 0);
            show("firstDate <  secondDate", diff < 0);
            show("firstDate <= secondDate", diff <= 0);
            show("firstDate >  secondDate", diff > 0);
            show("firstDate >= secondDate", diff >= 0);
        }

        private void show(string exp, bool result)
        {
            info.Text += exp;
            info.Text += " : " + result.ToString();
            info.Text += "\n";
        }

        private int dateCompare(DateTime leftHandSide, DateTime rightHandSide)
        {
            // TO DO
            return 42;
        }


        #region Conversion properties to cater for the differences between the DatePicker control in Windows 7 and Windows 8.1
        private DateTime first
        {
            get { return this.firstDate.Date.LocalDateTime; }
        }

        private DateTime second
        {
            get { return this.secondDate.Date.LocalDateTime; }
        }
        #endregion
    }
}

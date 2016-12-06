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

namespace MathsOperators
{
    public sealed partial class MainWindow : Page
    {
        public MainWindow()
        {
            this.InitializeComponent();
        }

        private void calculateClick(object sender, RoutedEventArgs e)
        {
            try
            {
                if ((bool)addition.IsChecked)
                {
                    addValues();
                }
                else if ((bool)subtraction.IsChecked)
                {
                    subtractValues();
                }
                else if ((bool)multiplication.IsChecked)
                {
                    multiplyValues();
                }
                else if ((bool)division.IsChecked)
                {
                    divideValues();
                }
                else if ((bool)remainder.IsChecked)
                {
                    remainderValues();
                }
                else
                {
                    throw new InvalidOperationException("No operator selected");
                }
            }
            catch (FormatException fEx)
            {
                result.Text = fEx.Message;
            }
            catch (OverflowException oEx)
            {
                result.Text = oEx.Message;
            }
            catch (InvalidOperationException ioEx)
            {
                result.Text = ioEx.Message;
            }
            catch (Exception ex) 
            {
                result.Text = ex.Message; 
            }
        }

        private void addValues()
        {
            int lhs = int.Parse(lhsOperand.Text);
            int rhs = int.Parse(rhsOperand.Text);
            int outcome = 0;

            outcome = lhs + rhs;
            expression.Text = lhsOperand.Text + " + " + rhsOperand.Text;
            result.Text = outcome.ToString();
        }

        private void subtractValues()
        {
            int lhs = int.Parse(lhsOperand.Text);
            int rhs = int.Parse(rhsOperand.Text);
            int outcome = 0;
            
            outcome = lhs - rhs;
            expression.Text = lhsOperand.Text + " - " + rhsOperand.Text;
            result.Text = outcome.ToString();
        }

        private void multiplyValues()
        {
            int lhs = int.Parse(lhsOperand.Text);
            int rhs = int.Parse(rhsOperand.Text);
            int outcome = 0;
            
            outcome = checked(lhs * rhs);
            expression.Text = lhsOperand.Text + " * " + rhsOperand.Text;
            result.Text = outcome.ToString();
        }

        private void divideValues()
        {
            int lhs = int.Parse(lhsOperand.Text);
            int rhs = int.Parse(rhsOperand.Text);
            int outcome = 0;
            
            outcome = lhs / rhs;
            expression.Text = lhsOperand.Text + " / " + rhsOperand.Text;
            result.Text = outcome.ToString();
        }

        private void remainderValues()
        {
            int lhs = int.Parse(lhsOperand.Text);
            int rhs = int.Parse(rhsOperand.Text);
            int outcome = 0;
            
            outcome = lhs % rhs;
            expression.Text = lhsOperand.Text + " % " + rhsOperand.Text;
            result.Text = outcome.ToString();
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Windows.Foundation;
using Windows.Foundation.Collections;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

// The Blank Page item template is documented at http://go.microsoft.com/fwlink/?LinkId=234238

namespace Cards
{
    /// <summary>
    /// An empty page that can be used on its own or navigated to within a Frame.
    /// </summary>
    public sealed partial class MainWindow : Page
    {
        public const int NumHands = 4;
        private Pack pack = null;
        private Hand[] hands = new Hand[NumHands];

        public MainWindow()
        {
            this.InitializeComponent();
        }

        private void dealClick(object sender, RoutedEventArgs e)
        {
            try
            {
                pack = new Pack();

                for (int handNum = 0; handNum < NumHands; handNum++)
                {
                    hands[handNum] = new Hand();
                    for (int numCards = 0; numCards < Hand.HandSize; numCards++)
                    {
                        PlayingCard cardDealt = pack.DealCardFromPack();
                        hands[handNum].AddCardToHand(cardDealt);
                    }
                }
                north.Text = hands[0].ToString();
                south.Text = hands[1].ToString();
                east.Text = hands[2].ToString();
                west.Text = hands[3].ToString();
            }
            catch (Exception ex)
            {
                MessageDialog msg = new MessageDialog(ex.Message, "Error");
                msg.ShowAsync();
            }
        }
    }
}

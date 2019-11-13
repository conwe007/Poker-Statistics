public class Deck
{
  private Card[] deck;
  private String[] lut = {"High Card","Pair","Two Pair","Three of a Kind","Straight","Flush","Full House","Four of a Kind","Straight Flush"};

  public Deck()
  {
    deck = new Card[52];
    int index = 0;
    char suit = ' ';
    for(int s=0;s<4;s++){
      for(int value=2;value<15;value++){
        switch(s){
          case 0:
            suit = 's';
            break;
          case 1:
            suit = 'c';
            break;
          case 2:
            suit = 'd';
            break;
          case 3:
            suit = 'h';
            break;
        }
        deck[index] = new Card(value,suit);
        index++;
      }
    }
  }

  public Card getCard(int i)
  {
    return deck[i];
  }

  public void shuffle()
  {
    Card temp = new Card();
    int r = 0;
    for(int i=0;i<52;i++){
      r = (int)(Math.random()*52);
      temp = deck[i];
      deck[i] = deck[r];
      deck[r] = temp;
    }
  }

  public Card[] deal5()
  {
    shuffle();
    Card[] output = new Card[5];
    for(int i=0;i<5;i++){
      output[i] = deck[i];
    }
    return output;
  }

  public Card[] deal7()
  {
    shuffle();
    Card[] output = new Card[7];
    for(int i=0;i<7;i++){
      output[i] = deck[i];
    }
    return output;
  }

  public static Card[] sortHand(Card[] hand)
  {
    Card temp = new Card();
    for(int i=0;i<hand.length-1;i++){
      for(int j=i;j<hand.length;j++){
        if(hand[i].getValue()>hand[j].getValue()){
          temp = hand[i];
          hand[i] = hand[j];
          hand[j] = temp;
        }
      }
    }
    return hand;
  }

  public static Card[] best5of7(Card[] hand)
  {
    int best = 0, check = 0;
    Card[] output = new Card[5];

    Card[] temp0 = {hand[0],hand[1],hand[2],hand[3],hand[4]};
    check = handRank(temp0);
    if(check>=best){
      best = check;
      output = temp0;
    }

    Card[] temp1 = {hand[0],hand[1],hand[2],hand[3],hand[5]};
    check = handRank(temp1);
    if(check>=best){
      best = check;
      output = temp1;
    }

    Card[] temp2 = {hand[0],hand[1],hand[2],hand[3],hand[6]};
    check = handRank(temp2);
    if(check>=best){
      best = check;
      output = temp2;
    }

    Card[] temp3 = {hand[0],hand[1],hand[2],hand[4],hand[5]};
    check = handRank(temp3);
    if(check>=best){
      best = check;
      output = temp3;
    }

    Card[] temp4 = {hand[0],hand[1],hand[2],hand[4],hand[6]};
    check = handRank(temp4);
    if(check>=best){
      best = check;
      output = temp4;
    }

    Card[] temp5 = {hand[0],hand[1],hand[2],hand[5],hand[6]};
    check = handRank(temp5);
    if(check>=best){
      best = check;
      output = temp5;
    }

    Card[] temp6 = {hand[0],hand[1],hand[3],hand[4],hand[5]};
    check = handRank(temp6);
    if(check>=best){
      best = check;
      output = temp6;
    }

    Card[] temp7 = {hand[0],hand[1],hand[3],hand[4],hand[6]};
    check = handRank(temp7);
    if(check>=best){
      best = check;
      output = temp7;
    }

    Card[] temp8 = {hand[0],hand[1],hand[3],hand[5],hand[6]};
    check = handRank(temp8);
    if(check>=best){
      best = check;
      output = temp8;
    }

    Card[] temp9 = {hand[0],hand[1],hand[4],hand[5],hand[6]};
    check = handRank(temp9);
    if(check>=best){
      best = check;
      output = temp9;
    }

    Card[] temp10 = {hand[0],hand[2],hand[3],hand[4],hand[5]};
    check = handRank(temp10);
    if(check>=best){
      best = check;
      output = temp10;
    }

    Card[] temp11 = {hand[0],hand[2],hand[3],hand[4],hand[6]};
    check = handRank(temp11);
    if(check>=best){
      best = check;
      output = temp11;
    }

    Card[] temp12 = {hand[0],hand[2],hand[3],hand[5],hand[6]};
    check = handRank(temp12);
    if(check>=best){
      best = check;
      output = temp12;
    }

    Card[] temp13 = {hand[0],hand[2],hand[4],hand[5],hand[6]};
    check = handRank(temp13);
    if(check>=best){
      best = check;
      output = temp13;
    }

    Card[] temp14 = {hand[0],hand[3],hand[4],hand[5],hand[6]};
    check = handRank(temp14);
    if(check>=best){
      best = check;
      output = temp14;
    }

    Card[] temp15 = {hand[1],hand[2],hand[3],hand[4],hand[5]};
    check = handRank(temp15);
    if(check>=best){
      best = check;
      output = temp15;
    }

    Card[] temp16 = {hand[1],hand[2],hand[3],hand[4],hand[6]};
    check = handRank(temp16);
    if(check>=best){
      best = check;
      output = temp16;
    }

    Card[] temp17 = {hand[1],hand[2],hand[3],hand[5],hand[6]};
    check = handRank(temp17);
    if(check>=best){
      best = check;
      output = temp17;
    }

    Card[] temp18 = {hand[1],hand[2],hand[4],hand[5],hand[6]};
    check = handRank(temp18);
    if(check>=best){
      best = check;
      output = temp18;
    }

    Card[] temp19 = {hand[1],hand[3],hand[4],hand[5],hand[6]};
    check = handRank(temp19);
    if(check>=best){
      best = check;
      output = temp19;
    }

    Card[] temp20 = {hand[2],hand[3],hand[4],hand[5],hand[6]};
    check = handRank(temp20);
    if(check>=best){
      best = check;
      output = temp20;
    }

    return output;
  }

  public static int handRank(Card[] hand)
  {
    int[] counter = new int[15];
    int pairs = 0;
    int trips = 0;
    for(int i=0;i<15;i++){
      counter[i] = 0;
    }

    if((hand[0].getSuit() == hand[1].getSuit()) && (hand[0].getSuit() == hand[2].getSuit()) && (hand[0].getSuit() == hand[3].getSuit()) && (hand[0].getSuit() == hand[4].getSuit())){
      if((hand[0].getValue()==2) && (hand[1].getValue()==3) && (hand[2].getValue()==4) && (hand[3].getValue()==5) && (hand[4].getValue()==14)){
        return 8;
      }
      for(int i=1;i<5;i++){
        if(hand[i].getValue()-1 != hand[i-1].getValue()){
          return 5;
        }
      }
      return 8;
    } else{
      for(int i=0;i<5;i++){
        counter[hand[i].getValue()]++;
      }
      for(int i=2;i<15;i++){
        if(counter[i] == 4){
          return 7;
        }
      }
      for(int i=2;i<15;i++){
        if(counter[i] == 3){
          trips++;
        } else if(counter[i] == 2){
          pairs++;
        }
      }
      if((trips==1) && (pairs==1)){
        return 6;
      }
      if((trips==1) && (pairs==0)){
        return 3;
      }
      if((trips==0) && (pairs==2)){
        return 2;
      }
      if((trips==0) && (pairs==1)){
        return 1;
      }
      for(int i=1;i<5;i++){
        if((hand[0].getValue()==2) && (hand[1].getValue()==3) && (hand[2].getValue()==4) && (hand[3].getValue()==5) && (hand[4].getValue()==14)){
          return 4;
        }
        if(hand[i].getValue()-1 != hand[i-1].getValue()){
          return 0;
        }
      }
      return 4;
    }
  }

  public static String handValue(Card[] hand)
  {
    int[] counter = new int[15];
    int pairs = 0;
    int trips = 0;
    for(int i=0;i<15;i++){
      counter[i] = 0;
    }

    if((hand[0].getSuit() == hand[1].getSuit()) && (hand[0].getSuit() == hand[2].getSuit()) && (hand[0].getSuit() == hand[3].getSuit()) && (hand[0].getSuit() == hand[4].getSuit())){
      if((hand[0].getValue()==2) && (hand[1].getValue()==3) && (hand[2].getValue()==4) && (hand[3].getValue()==5) && (hand[4].getValue()==14)){
        return "Straight Flush";
      }
      for(int i=1;i<5;i++){
        if(hand[i].getValue()-1 != hand[i-1].getValue()){
          return "Flush";
        }
      }
      return "Straight Flush";
    } else{
      for(int i=0;i<5;i++){
        counter[hand[i].getValue()]++;
      }
      for(int i=2;i<15;i++){
        if(counter[i] == 4){
          return "Four of a Kind";
        }
      }
      for(int i=2;i<15;i++){
        if(counter[i] == 3){
          trips++;
        } else if(counter[i] == 2){
          pairs++;
        }
      }
      if((trips==1) && (pairs==1)){
        return "Full House";
      }
      if((trips==1) && (pairs==0)){
        return "Three of a Kind";
      }
      if((trips==0) && (pairs==2)){
        return "Two Pair";
      }
      if((trips==0) && (pairs==1)){
        return "Pair";
      }
      for(int i=1;i<5;i++){
        if((hand[0].getValue()==2) && (hand[1].getValue()==3) && (hand[2].getValue()==4) && (hand[3].getValue()==5) && (hand[4].getValue()==14)){
          return "Straight";
        }
        if(hand[i].getValue()-1 != hand[i-1].getValue()){
          return "High Card";
        }
      }
      return "Straight";
    }
  }

  public String toString()
  {
    String output = "";
    int index = 0;
    for(int i=0;i<4;i++){
      for(int j=0;j<13;j++){
        output += String.valueOf(deck[index].getDisplay()) + String.valueOf(deck[index].getSuit()) + " ";
        index++;
      }
      output += "\n";
    }
    return output;
  }

  public static String handToString(Card[] hand)
  {
    String output = "";
    for(int i=0;i<hand.length;i++){
      output += hand[i].toString() + " ";
    }
    return output;
  }

  public static void main(String[] args)
  {
    Deck deck = new Deck();
    deck.shuffle();
    Card[] hand;
    double odds = 0.0;
    int attempts = 1000000;
    int[] count = new int[9];

    for(int i=0;i<9;i++){
      count[i] = 0;
    }

    for(int i=0;i<attempts;i++){
      hand = deck.deal7();
      hand = sortHand(hand);
      hand = best5of7(hand);
      count[handRank(hand)]++;
    }

    System.out.println("Seven Card");
    odds = 100.0*(double)count[0]/attempts;
    System.out.println("High Card: " + odds + "%");
    odds = 100.0*(double)count[1]/attempts;
    System.out.println("Pair: " + odds + "%");
    odds = 100.0*(double)count[2]/attempts;
    System.out.println("Two Pair: " + odds + "%");
    odds = 100.0*(double)count[3]/attempts;
    System.out.println("Three of a kind: " + odds + "%");
    odds = 100.0*(double)count[4]/attempts;
    System.out.println("Straight: " + odds + "%");
    odds = 100.0*(double)count[5]/attempts;
    System.out.println("Flush: " + odds + "%");
    odds = 100.0*(double)count[6]/attempts;
    System.out.println("Full House: " + odds + "%");
    odds = 100.0*(double)count[7]/attempts;
    System.out.println("Four of a Kind: " + odds + "%");
    odds = 100.0*(double)count[8]/attempts;
    System.out.println("Straight Flush: " + odds + "%");

    System.out.println("");

    for(int i=0;i<9;i++){
      count[i] = 0;
    }

    for(int i=0;i<attempts;i++){
      hand = deck.deal5();
      hand = sortHand(hand);
      count[handRank(hand)]++;
    }

    System.out.println("Five Card");
    odds = 100.0*(double)count[0]/attempts;
    System.out.println("High Card: " + odds + "%");
    odds = 100.0*(double)count[1]/attempts;
    System.out.println("Pair: " + odds + "%");
    odds = 100.0*(double)count[2]/attempts;
    System.out.println("Two Pair: " + odds + "%");
    odds = 100.0*(double)count[3]/attempts;
    System.out.println("Three of a kind: " + odds + "%");
    odds = 100.0*(double)count[4]/attempts;
    System.out.println("Straight: " + odds + "%");
    odds = 100.0*(double)count[5]/attempts;
    System.out.println("Flush: " + odds + "%");
    odds = 100.0*(double)count[6]/attempts;
    System.out.println("Full House: " + odds + "%");
    odds = 100.0*(double)count[7]/attempts;
    System.out.println("Four of a Kind: " + odds + "%");
    odds = 100.0*(double)count[8]/attempts;
    System.out.println("Straight Flush: " + odds + "%");
  }
}

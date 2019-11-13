public class Card
{
  private int value;
  private char suit;
  private String display;

  public Card()
  {
    value = -1;
    suit = 'e';
    display = "e";
  }

  public Card(int v, char s)
  {
    value = v;
    suit = s;
    setDisplay();
  }

  public int getValue()
  {
    return value;
  }

  public char getSuit()
  {
    return suit;
  }

  public String getDisplay()
  {
    return display;
  }

  public void setValue(int v)
  {
    value = v;
  }

  public void setSuit(char s)
  {
    suit = s;
  }

  public void setDisplay()
  {
    switch(value){
      case 11:
        display = "J";
        break;
      case 12:
        display = "Q";
        break;
      case 13:
        display = "K";
        break;
      case 14:
        display = "A";
        break;
      default:
        display = String.valueOf(value);
        break;
    }
  }

  public String toString()
  {
    return display + String.valueOf(suit);
  }
}

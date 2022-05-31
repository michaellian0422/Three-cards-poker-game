import javax.swing.ImageIcon;


/** 
 * This is the class of the card of the card game
 */
public class Card 
{
	int value;
	ImageIcon img;
	
	/**
	 * The constructor to setup the properties accordingly of the card.
	 * @param value The value of the card (J,Q,K values is 100 point in this game)
	 * @param img The img path of the card 
	 */
	public Card (int value, String img) 
	{
		this.value = value;
		this.img= new ImageIcon(img);
	}
}
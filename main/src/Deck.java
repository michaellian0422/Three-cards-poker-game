import java.util.ArrayList;

/** 
 * This is the class of the deck of the card game
 * 
 */


public class Deck {
	public Card d_c1, d_c2, d_c3, p_c1, p_c2, p_c3;
	//Assign number to the deck 
	public ArrayList<Card> shuffle_deck;
	
	/**
	 * The constructor to setup the properties of the deck.
	 */
	public Deck() 
	{
		shuffle_deck = new ArrayList<Card>();
		this.shuffle();
		this.d_c1 = shuffle_deck.remove(0);
		this.d_c2 = shuffle_deck.remove(0);
		this.d_c3 = shuffle_deck.remove(0);
		this.p_c1 = shuffle_deck.remove(0);
		this.p_c2 = shuffle_deck.remove(0);
		this.p_c3 = shuffle_deck.remove(0);
	}
	
	/**
	 * Method used to shuffle the cards of the deck
	 */
	public void shuffle() 
	{
		
		ArrayList<Integer> unshuffled_deck = new ArrayList<Integer> ();
		
		for (int i=0; i<52; i++) 
		{
			unshuffled_deck.add(i);
		}
		
		while (unshuffled_deck.size() >0) 
		{
			int random_index = (int) (Math.random() * unshuffled_deck.size());
			// Card start from 1-52 refer from "images" file 
			int card_no = unshuffled_deck.remove(random_index)+1;
			int card_value;
			//Card Value
			
			if ((card_no)/4.0 > 10) 
			{
				card_value = 100;
			}
			else 
			{ 
				if ((card_no)%4 ==0)
				{
					card_value =  card_no/4;
				}
				else 
				{
					card_value = ((int) ((card_no)/4))+1;
				}
			}
			
			//Image_name
			String image_name = "card_" + card_no + ".gif";
			Card c = new Card(card_value, image_name);
			this.shuffle_deck.add(c);
		}
	}
	
	/**
	 * Method used to replace player's card on hand
	 * @param The index of the card to be replaced
	 */
	public void replace(int card_index) 
	{
		if (card_index==1) 
		{
			this.p_c1 = shuffle_deck.remove(0);
		}
		else if (card_index==2) 
		{
			this.p_c2 = shuffle_deck.remove(0);
		}
		else 
		{
			this.p_c3 = shuffle_deck.remove(0);
		}
	}
	
}

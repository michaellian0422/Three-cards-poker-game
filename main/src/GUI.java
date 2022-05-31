import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** 
 * This is the class of the GUI of the card game
 * @author Lian Ho Yeung
 * UID: 3035714260
 * 
 */

public class GUI {
	
	int money_amount = 100;
	int replace_counter = 0; 
	int bet;
	Deck deck;
	
	/**
	 * The method is used to start the GUI of the game.
	 */
	
	public void goGUI() 
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu menu_control = new JMenu("Control");
		JMenuItem menuitem_exit = new JMenuItem("Exit");
		menu_control.add(menuitem_exit);
		menuBar.add(menu_control);
		
		menuitem_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel MainPanel = new JPanel();
		JPanel DealerPanel = new JPanel();
		JPanel PlayerPanel = new JPanel();
		JPanel RpCardBtnPanel = new JPanel();
		JPanel ButtonPanel = new JPanel();
		JPanel InfoPanel = new JPanel();
		
		JLabel d1 = new JLabel();
		JLabel d2 = new JLabel();
		JLabel d3 = new JLabel();
		JLabel p1 = new JLabel();
		JLabel p2 = new JLabel();
		JLabel p3 = new JLabel();
		
		ImageIcon card_back = new ImageIcon("card_back.gif");
		d1.setIcon(card_back);
		d2.setIcon(card_back);
		d3.setIcon(card_back);
		p1.setIcon(card_back);
		p2.setIcon(card_back);
		p3.setIcon(card_back);
		
		DealerPanel.add(d1);
		DealerPanel.add(d2);
		DealerPanel.add(d3);
		PlayerPanel.add(p1);
		PlayerPanel.add(p2);
		PlayerPanel.add(p3);
		
		MainPanel.setLayout(new GridLayout(5,1)); //rows, cols
		MainPanel.add(DealerPanel);
		MainPanel.add(PlayerPanel);
		MainPanel.add(RpCardBtnPanel);
		MainPanel.add(ButtonPanel);
		MainPanel.add(InfoPanel);
		
		JButton btn_r1 = new JButton("Replace Card1");
		JButton btn_r2 = new JButton("Replace Card2");
		JButton btn_r3 = new JButton("Replace Card3");
		btn_r1.setEnabled(false);
		btn_r2.setEnabled(false);
		btn_r3.setEnabled(false);
		
		RpCardBtnPanel.add(btn_r1);
		RpCardBtnPanel.add(btn_r2);
		RpCardBtnPanel.add(btn_r3);
		
		JLabel label_BetInfo = new JLabel("Bet: $");
		JTextField TField_BetAmount = new JTextField(10);
		JButton btn_start = new JButton("Start");
		JButton btn_result = new JButton("Result");
		btn_result.setEnabled(false);
		ButtonPanel.add(label_BetInfo);
		ButtonPanel.add(TField_BetAmount);
		ButtonPanel.add(btn_start);
		ButtonPanel.add(btn_result);
		
		JLabel label_info = new JLabel("Please place your bet! Amount of money you have: $"+ money_amount);
		InfoPanel.add(label_info);
		
		DealerPanel.setBackground(Color.green);
		PlayerPanel.setBackground(Color.green);
		RpCardBtnPanel.setBackground(Color.green);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(MainPanel);
		frame.setJMenuBar(menuBar);
		frame.setTitle("A Simple Card Game");
		frame.setSize(400, 700);
		frame.setVisible(true);
		
		btn_start.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				deck = new Deck();
				d1.setIcon(card_back);
				d2.setIcon(card_back);
				d3.setIcon(card_back);
				
				bet = Integer.parseInt(TField_BetAmount.getText());
				p1.setIcon(deck.p_c1.img);
				p2.setIcon(deck.p_c2.img);
				p3.setIcon(deck.p_c3.img);
				btn_start.setEnabled(false);
				btn_result.setEnabled(true);
				btn_r1.setEnabled(true);
				btn_r2.setEnabled(true);
				btn_r3.setEnabled(true);
				label_info.setText(String.format("Your current bet is: $%d Amount of money you have: $%d", bet, money_amount));
			}
		});
		
		btn_r1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				deck.replace(1);
				p1.setIcon(deck.p_c1.img);
				btn_r1.setEnabled(false);
				replace_counter++;
				if (replace_counter==2) 
				{
					btn_r1.setEnabled(false);
					btn_r2.setEnabled(false);
					btn_r3.setEnabled(false);
				}
				
			}
		});
		
		btn_r2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				deck.replace(2);
				p2.setIcon(deck.p_c2.img);
				btn_r2.setEnabled(false);
				replace_counter++;
				if (replace_counter==2) 
				{
					btn_r1.setEnabled(false);
					btn_r2.setEnabled(false);
					btn_r3.setEnabled(false);
				}
			}
		});
		
		btn_r3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				deck.replace(3);
				p3.setIcon(deck.p_c3.img);
				btn_r3.setEnabled(false);
				replace_counter++;
				if (replace_counter==2) 
				{
					btn_r1.setEnabled(false);
					btn_r2.setEnabled(false);
					btn_r3.setEnabled(false);
				}
			}
		});
		
		btn_result.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.out.println("Value:" + deck.p_c1.value +" "+ deck.p_c2.value +" "+ deck.p_c3.value);
				btn_result.setEnabled(false);
				btn_start.setEnabled(true);
				replace_counter = 0;
				btn_r1.setEnabled(false);
				btn_r2.setEnabled(false);
				btn_r3.setEnabled(false);
				d1.setIcon(deck.d_c1.img);
				d2.setIcon(deck.d_c2.img);
				d3.setIcon(deck.d_c3.img);
				
				int dealer_amount = deck.d_c1.value + deck.d_c2.value + deck.d_c3.value;
				int player_amount = deck.p_c1.value + deck.p_c2.value + deck.p_c3.value;
				
				//Compare no. of special cards (1 Special card values 100 in deck class as defined)
				
				String win_message = "Congruations! You win this round!";
				String Gameover_message = "<html>Game over!<br>You have no more money!<br>Please start a new game!</html>";
				String lose_message = "Sorry! The Dealer wins this round!";
				
				if(dealer_amount/100 > player_amount /100) 
				{
					money_amount -= bet;
					if (money_amount ==0)
					{
						JOptionPane.showMessageDialog(null,Gameover_message,"Message",JOptionPane.INFORMATION_MESSAGE);
						label_info.setText("You have no more money! Please start a new game!");
						btn_start.setEnabled(false);
					}
					else 
					{
						JOptionPane.showMessageDialog(null,lose_message,"Message",JOptionPane.INFORMATION_MESSAGE);
						label_info.setText(String.format("Please place your bet! Amount of money you have: $%d", money_amount));
					}
				}
				
				else if (dealer_amount/100 < player_amount /100)
				{
					money_amount += bet;
					JOptionPane.showMessageDialog(null,win_message,"Message",JOptionPane.INFORMATION_MESSAGE);
					label_info.setText(String.format("Please place your bet! Amount of money you have: $%d", money_amount));
				}
				else 
				{
					if  ( (dealer_amount %100 %10) >= (player_amount %100 %10) ) {
						money_amount -= bet;
						if (money_amount ==0)
						{
							JOptionPane.showMessageDialog(null,Gameover_message,"Message",JOptionPane.INFORMATION_MESSAGE);
							label_info.setText("You have no more money! Please start a new game!");
							btn_start.setEnabled(false);
						}
						else 
						{
							JOptionPane.showMessageDialog(null,lose_message,"Message",JOptionPane.INFORMATION_MESSAGE);
							label_info.setText(String.format("Please place your bet! Amount of money you have: $%d", money_amount));
						}
					}
					else 
					{
						money_amount += bet;
						JOptionPane.showMessageDialog(null,win_message,"Message",JOptionPane.INFORMATION_MESSAGE);
						label_info.setText(String.format("Please place your bet! Amount of money you have: $%d", money_amount));
					}
				}
				
				
				
			}
		});
		
		
	}
	
	/**
	 * This is the main method that to call the game GUI to launch the game
	 * @param Arguements of the main method
	 */
	
	public static void main(String[] args) 
	{
		GUI game = new GUI();
		game.goGUI();
	}
	
	
}

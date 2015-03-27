import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SimpleClient {

	private Socket clientsocket;

	public static char[][] game = { { '1', '2', '3' }, { '4', '5', '6' },
		{ '7', '8', '9' } };
	private static JFrame mainFrame;
	private JLabel statusLabel;
	int count = 0;
	int wins = 100;
	int row = 100;
	int col = 100;
	Player Player1;
	Player Player2;
	Boolean Turn=false;

	SimpleClient() {
		Player1 = new Player();
		Player2 = new Player();
		mainFrame = new JFrame("Client");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 3));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.setVisible(true);

	}

	JButton B1 = new JButton("");
	JButton B2 = new JButton("");
	JButton B3 = new JButton("");
	JButton B4 = new JButton("");
	JButton B5 = new JButton("");
	JButton B6 = new JButton("");
	JButton B7 = new JButton("");
	JButton B8 = new JButton("");
	JButton B9 = new JButton("");

	public void showbutton() {

		mainFrame.add(B1);
		mainFrame.add(B2);
		mainFrame.add(B3);
		mainFrame.add(B4);
		mainFrame.add(B5);
		mainFrame.add(B6);
		mainFrame.add(B7);
		mainFrame.add(B8);
		mainFrame.add(B9);
		mainFrame.setVisible(true);
		B1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{		if (wins == 3 ) {
					if (game[0][0] == '1') {
						B1.setText("x");
						game[0][0] = 'x';
						row = 0;
						col = 0;
						Turn=false;
						count++;
						sendMessage();

					}
				}
				}
			}
		});

		B2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[0][1] == '2') {

							B2.setText("x");
							game[0][1] = 'x';
							row = 0;
							col = 1;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{	
					if (wins == 3) {
						if (game[0][2] == '3') {
							B3.setText("x");
							game[0][2] = 'x';
							count++;
							row = 0;
							col = 2;
							Turn=false;
							sendMessage();

						}
					}
				}
			}
		});
		B4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3 ) {
						if (game[1][0] == '4') {
							B4.setText("x");
							game[1][0] = 'x';
							row = 1;
							col = 0;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {
						if (game[1][1] == '5') {
							B5.setText("x");
							game[1][1] = 'x';
							row = 1;
							col = 1;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {
						if (game[1][2] == '6') {
							B6.setText("x");
							game[1][2] = 'x';
							row = 1;
							col = 2;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[2][0] == '7') {
							B7.setText("x");
							game[2][0] = 'x';
							row = 2;
							col = 0;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[2][1] == '8') {
							B8.setText("x");
							game[2][1] = 'x';
							row = 2;
							col = 1;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});
		B9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3 ) {

						if (game[2][2] == '9') {
							B9.setText("x");
							game[2][2] = 'x';
							row = 2;
							col = 2;
							Turn=false;
							count++;
							sendMessage();
						}
					}
				}
			}
		});

	}

	public int won() {
		int winner = 3;
		if ((((game[0][0]) == 'x' && (game[0][1]) == 'x' && (game[0][2]) == 'x')
				|| ((game[1][0]) == 'x' && (game[1][1]) == 'x' && (game[1][2]) == 'x')
				|| ((game[2][0]) == 'x' && (game[2][1]) == 'x' && (game[2][2]) == 'x')
				||

				((game[0][0]) == 'x' && (game[1][0]) == 'x' && (game[2][0]) == 'x')
				|| ((game[0][1]) == 'x' && (game[1][1]) == 'x' && (game[2][1]) == 'x')
				|| ((game[0][2]) == 'x' && (game[1][2]) == 'x' && (game[2][2]) == 'x')
				||

				((game[0][0]) == 'x' && (game[1][1]) == 'x' && (game[2][2]) == 'x') || ((game[0][2]) == 'x'
				&& (game[1][1]) == 'x' && (game[2][0]) == 'x')

				)

				) {
			winner = 1;

			JOptionPane.showMessageDialog(null,
					"Congrats client side..... crosses 'x' wins");
		}
		if (

				(((game[0][0]) == '0' && (game[0][1]) == '0' && (game[0][2]) == '0')
						|| ((game[1][0]) == '0' && (game[1][1]) == '0' && (game[1][2]) == '0')
						|| ((game[2][0]) == '0' && (game[2][1]) == '0' && (game[2][2]) == '0')
						||

						((game[0][0]) == '0' && (game[1][0]) == '0' && (game[2][0]) == '0')
						|| ((game[0][1]) == '0' && (game[1][1]) == '0' && (game[2][1]) == '0')
						|| ((game[0][2]) == '0' && (game[1][2]) == '0' && (game[2][2]) == '0')
						||

						((game[0][0]) == '0' && (game[1][1]) == '0' && (game[2][2]) == '0') || ((game[0][2]) == '0'
						&& (game[1][1]) == '0' && (game[2][0]) == '0')

						)

				) {
			winner = 0;
			JOptionPane.showMessageDialog(null,
					"Congrats server side...... zeros '0' wins");
		}
		if(count==9&&winner==3)
		{
			JOptionPane.showMessageDialog(null,"Game is draw");
		}
		return winner;
	}



	public static void main(String args[]) throws IOException,
	ClassNotFoundException {
		SimpleClient Client = new SimpleClient();
		Client.play();

	}

	public void play() throws IOException, ClassNotFoundException {
		showbutton();
		clientsocket = new Socket("127.0.0.1", 1847);
		OutputStream s1out = clientsocket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(s1out);
		dos.writeUTF("Client joined server");

		for(int i=1;i<=5;i++)
			recieveMessage();


	}

	public void recieveMessage() {
		ObjectInputStream clientInputStream;
		try {
			clientInputStream = new 
					ObjectInputStream(clientsocket.getInputStream());
			Player1= (Player)clientInputStream.readObject();
			setButtonText(Player1.getRow(),Player1.getCol());
			Turn=true;
			//loop here over clientInputStream and read line every time
			// for example "response = in.readLine();" every time in loop

			//	clientInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void sendMessage() {
		Player2.setCol(col);
		Player2.setRow(row);

		ObjectOutputStream clientOutputStream;
		try {
			clientOutputStream = new
					ObjectOutputStream(clientsocket.getOutputStream());
			clientOutputStream.writeObject(Player2);
			//clientOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void setButtonText(int row, int col)
	{
		wins = won();
		if(wins==3)
		{

			if(row==0&&col==0)
			{	
				B1.setText("0");
				game[0][0]='0';
			}
			else
				if(row==0&&col==1)
				{
					B2.setText("0");
					game[0][1]='0';
				}
				else
					if(row==0&&col==2)
					{
						B3.setText("0");
						game[0][2]='0';
					}
					else
						if(row==1&&col==0)
						{
							B4.setText("0");
							game[1][0]='0';
						}
						else
							if(row==1&&col==1)
							{
								B5.setText("0");
								game[1][1]='0';
							}
							else
								if(row==1&&col==2)
								{
									B6.setText("0");
									game[1][2]='0';
								}
								else
									if(row==2&&col==0)
									{
										B7.setText("0");
										game[2][0]='0';
									}
									else
										if(row==2&&col==1)
										{
											B8.setText("0");
											game[2][1]='0';
										}
										else
											if(row==2&&col==2)
											{
												B9.setText("0");
												game[2][2]='0';
											}
		}
	}

}


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

public class SimpleServer {

	private Socket serversocket;
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

	SimpleServer() {
		Player1 = new Player();
		Player2 = new Player();
		mainFrame = new JFrame("Server");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 3));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mainFrame.setVisible(true);

	}

	JButton Button1 = new JButton("");
	JButton Button2 = new JButton("");
	JButton Button3 = new JButton("");
	JButton Button4 = new JButton("");
	JButton Button5 = new JButton("");
	JButton Button6 = new JButton("");
	JButton Button7 = new JButton("");
	JButton Button8 = new JButton("");
	JButton Button9 = new JButton("");

	public void showbutton() {

		mainFrame.add(Button1);
		mainFrame.add(Button2);
		mainFrame.add(Button3);
		mainFrame.add(Button4);
		mainFrame.add(Button5);
		mainFrame.add(Button6);
		mainFrame.add(Button7);
		mainFrame.add(Button8);
		mainFrame.add(Button9);
		mainFrame.setVisible(true);
		Button1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{	
					if (wins == 3 ) {
						if (game[0][0] == '1') {
							Button1.setText("0");
							game[0][0] = '0';
							row = 0;
							col = 0;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)
	
							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});

		Button2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[0][1] == '2') {

							Button2.setText("0");
							game[0][1] = '0';
							row = 0;
							col = 1;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{	
					if (wins == 3) {
						if (game[0][2] == '3') {
							Button3.setText("0");
							game[0][2] = '0';
							row = 0;
							col = 2;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3 ) {
						if (game[1][0] == '4') {
							Button4.setText("0");
							game[1][0] = '0';
							row = 1;
							col = 0;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {
						if (game[1][1] == '5') {
							Button5.setText("0");
							game[1][1] = '0';
							row = 1;
							col = 1;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {
						if (game[1][2] == '6') {
							Button6.setText("0");
							game[1][2] = '0';
							row = 1;
							col = 2;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats client side...... crosses 'x' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button7.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[2][0] == '7') {
							Button7.setText("0");
							game[2][0] = '0';
							row = 2;
							col = 0;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3) {

						if (game[2][1] == '8') {
							Button8.setText("0");
							game[2][1] = '0';
							row = 2;
							col = 1;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
							sendMessage();
						}
					}
				}
			}
		});
		Button9.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				wins = won();
				if(Turn==true)
				{
					if (wins == 3 ) {

						if (game[2][2] == '9') {
							Button9.setText("0");
							game[2][2] = '0';
							row = 2;
							col = 2;
							Turn=false;
							count++;
							wins=won();
							if(wins==0)
							{JOptionPane.showMessageDialog(null,
									"Congrats server side...... zeros '0' wins");}
							else if(count==9&&wins==3)

							{
								JOptionPane.showMessageDialog(null,"game is draw");	
							}
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
			
		}
		if(count==9&&winner==3)
		{
			//JOptionPane.showMessageDialog(null,"Game is draw");
		}
		return winner;
	}



	public static void main(String args[]) throws IOException,
	ClassNotFoundException {
		SimpleServer Server = new SimpleServer();
		Server.play();
	}

	public void play() throws IOException, ClassNotFoundException {


		showbutton();

		ServerSocket s = new ServerSocket(1847);
		serversocket = s.accept(); 
		InputStream serverInput = serversocket.getInputStream();

		DataInputStream dis = new DataInputStream(serverInput);
		String message = new String(dis.readUTF());

		JOptionPane.showMessageDialog(null,message);
		System.out.println(message);
		Turn=true;
		for(int i=1;i<=4;i++)
			recieveMessage();


	}
	public void recieveMessage() {
		ObjectInputStream serverInputStream;
		try {
			serverInputStream = new    
					ObjectInputStream(serversocket.getInputStream());
			Player2 = (Player )serverInputStream.readObject();
			setButtonText(Player2.getRow(),Player2.getCol());
			count++;
			wins=won();
			if(wins==1)
			{JOptionPane.showMessageDialog(null,
					"Congrats client side...... crosses 'x' wins");}
			else if(count==9&&wins==3)

			{
				JOptionPane.showMessageDialog(null,"game is draw");	
			}
			Turn=true;
			//serverInputStream.close();
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	public void sendMessage() {
		Player1.setCol(col);
		Player1.setRow(row);
		ObjectOutputStream serverOutputStream;
		try {
			serverOutputStream = new 
					ObjectOutputStream(serversocket.getOutputStream());
			serverOutputStream.writeObject(Player1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}public void setButtonText(int row, int col)
	{
		wins = won();
		if(wins==3)
		{

			if(row==0&&col==0)
			{	
				Button1.setText("x");
				game[0][0]='x';
			}
			else
				if(row==0&&col==1)
				{
					Button2.setText("x");
					game[0][1]='x';
				}
				else
					if(row==0&&col==2)
					{
						Button3.setText("x");
						game[0][2]='x';
					}
					else
						if(row==1&&col==0)
						{
							Button4.setText("x");
							game[1][0]='x';
						}
						else
							if(row==1&&col==1)
							{
								Button5.setText("x");
								game[1][1]='x';
							}
							else
								if(row==1&&col==2)
								{
									Button6.setText("x");
									game[1][2]='x';
								}
								else
									if(row==2&&col==0)
									{
										Button7.setText("x");
										game[2][0]='x';
									}
									else
										if(row==2&&col==1)
										{
											Button8.setText("x");
											game[2][1]='x';
										}
										else
											if(row==2&&col==2)
											{
												Button9.setText("x");
												game[2][2]='x';
											}
		}
	}


}

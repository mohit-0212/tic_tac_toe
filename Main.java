/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class test{
	private static JFrame frame;
	private static JButton button;
	private static JPanel panel;
	public static void main(String[] args){
		frame = new JFrame("TEst");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
		panel = new JPanel();
		button = new JButton("Click");
		button.setSize(200,200);
		panel.add(button);
		frame.add(panel);
		button.addActionListener(new Action());
	}

	static class Action implements ActionListener{
		public void actionPerformed (ActionEvent e){
			button.setEnabled(false);
			button.setText("Clicked");
		}
	}
}*/

import java.awt.GridLayout;
import javax.swing.*;


public class Main extends JFrame
{
    private JPanel panel;
    private JButton[][]buttons;
    private final int SIZE = ;
    private GridLayout experimentLayout;
    public Main()
    {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);

        experimentLayout =  new GridLayout(SIZE,SIZE);

        panel = new JPanel();
        panel.setLayout(experimentLayout);


        buttons = new JButton[SIZE][SIZE];
        addButtons();


        add(panel);
        setVisible(true);
    }
    public void addButtons() {
   for (int k = 0; k < SIZE; k++) {
      for (int j = 0; j < SIZE; j++) {
         buttons[k][j] = new JButton(k + 1 + ", " + (j + 1));
         panel.add(buttons[k][j]);
      }
   }
}



    public static void main(String[] args) 
    {
        new Main();

    }
}
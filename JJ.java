import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class mm
{
JFrame frame;
JLabel l1, l2;
Timer timer;
JPanel panel;
JButton button;
mm()
{
panel=new JPanel(new BorderLayout());
frame=new JFrame("pol");
l1=new JLabel("mohit");
l2=new JLabel("sans");
button = new JButton("mohit");
panel.add(l1);
panel.add(l2);
//panel.add(button);
frame.setContentPane(panel);
frame.setSize(1000,1000);

frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);


}

void go()
{
timer=new Timer(1000, new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
l1.setText("sans");
}

});
timer.start();
//Timer timer;
timer=new Timer(2000, new ActionListener()
{
public void actionPerformed(ActionEvent e)
{
l2.setText("mohit");
}

});
timer.start();


//l1.setText("lll");


// button.setEnabled(false);
// String s = button.getText();
// System.out.print(s);
}
}

class JJ
{
public static void main(String ar[])
{
mm j=new mm();
j.go();
}
}
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.*;
import java.util.Random;


public class gui_tictactoe{
	
	public static class grid{

		private JFrame frame;

		private JLabel heading;
		private JPanel start_panel;
		private JButton start_game;
		private JButton exit;

		private JButton exit2;
		private JButton users;
		private JButton user_cpu;
		private JButton cpu_ai;
		private JButton user_ai;

		private JButton[][]buttons;
		private JPanel button_grid;
		private JLabel output;
		private JPanel out;
		private GridLayout layout;
		
		private String user1;
		private String user2;

		private JPanel mainpanel;

		Timer timer;
		Timer timer2;
		Timer timer3;
		Timer timer4;
		Timer timer5;
		Timer timer6;

		int timer_check = 0;

		String[] random = {"X","O"};
		//String[] game_type = {0,1,2,3};
		int gametype;
		int button_en = -1;
		int main_butt_en = 1;
		//random[0] = "X";
		//random[1] = "O";
		int val_output = 0 ;


		public grid(){
			frame = new JFrame("TIC TAC TOE");
			frame.setSize(500,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);
			load();

		}

		public void load(){
			heading = new JLabel("TIC-TAC-TOE");
			start_game = new JButton("Start Game");
			start_game.setPreferredSize(new Dimension(200,50));
			exit = new JButton("Exit");
			exit.setPreferredSize(new Dimension(200,50));
			start_panel = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.gridx = 0;
			c.gridy = 0;
			c.insets = new Insets(25,25,25,25);
			start_panel.add(heading,c);
			c.gridx = 0;
			c.gridy = 1;
			start_panel.add(start_game,c);
			c.gridx = 0;
			c.gridy = 2;
			start_panel.add(exit,c);
			start_game.addActionListener(new Action());
			exit.addActionListener(new Action());
			frame.add(start_panel);
		}

		public void main_game(){

			mainpanel = new JPanel(new GridBagLayout());
			GridBagConstraints c2 = new GridBagConstraints();
			c2.gridx = 0;
			c2.gridy = 0;

			JPanel left = new JPanel(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.insets = new Insets(10,10,10,10);

			users = new JButton("User1 vs User2");
			users.setPreferredSize(new Dimension(150,50));
			c.gridx = 0;
			c.gridy = 0;
			left.add(users,c);
			users.addActionListener(new Action());

			user_cpu = new JButton("User vs CPU");
			user_cpu.setPreferredSize(new Dimension(150,50));
			c.gridx = 0;
			c.gridy = 1;
			left.add(user_cpu,c);
			user_cpu.addActionListener(new Action());

			cpu_ai = new JButton("CPU vs AI Bot");
			cpu_ai.setPreferredSize(new Dimension(150,50));
			c.gridx = 0;
			c.gridy = 2;
			left.add(cpu_ai,c);
			cpu_ai.addActionListener(new Action());

			user_ai = new JButton("User vs AI Bot");
			user_ai.setPreferredSize(new Dimension(150,50));
			c.gridx = 0;
			c.gridy = 3;
			left.add(user_ai,c);
			user_ai.addActionListener(new Action());

			exit2 = new JButton("Exit");
			exit2.setPreferredSize(new Dimension(150,50));
			c.gridx = 0;
			c.gridy = 4;
			exit2.addActionListener(new Action());
			left.add(exit2,c);

			mainpanel.add(left,c2);
			
			c2.gridx = 1;

			JPanel right = new JPanel(new GridBagLayout());
			

			c.gridx = 0;
			c.gridy = 0;
			layout = new GridLayout(3,3);
			button_grid = new JPanel();
			button_grid.setLayout(layout);

			buttons = new JButton[3][3];
			addButtons();
			right.add(button_grid,c);

			//out = new JPanel();
			output = new JLabel("");
			
			//out.add(output);

			c.gridy = 1;
			right.add(output,c);

			mainpanel.add(right,c2);
			frame.add(mainpanel);

			
		}
		public void addButtons(){
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					buttons[i][j] = new JButton("");
					buttons[i][j].setPreferredSize(new Dimension(100,100));
					//buttons[i][j].setEnabled(false);
					button_grid.add(buttons[i][j]);
					buttons[i][j].addActionListener(new Action());
				}
			}
			//buttons[0][0].addActionListener(new Action());
		
		}

		public int get(){
			int i,j;
			int remaining=0;
			for(i=0;i<3;i++){
				for(j=0;j<3;j++){
					if(buttons[i][j].getText().equals("")){
						remaining=1;
						break;
					}
				}
				if(remaining==1){
					break;
				}

			}
			return remaining;
		}


		public int win(String val){
			int check=0;
			int i;
			for(i=0;i<3;i++){
				
				if(!(buttons[i][0].getText().equals(""))&& (buttons[i][0].getText().equals(val))&&(buttons[i][0].getText().equals(buttons[i][1].getText()))){
					if(buttons[i][2].getText().equals("")){
						//System.out.println("here");
						buttons[i][2].setText(val);
						buttons[i][2].setEnabled(false);
						check=1;
						return check;
					}
				}
				
				else if(!(buttons[i][0].getText().equals(""))&& (buttons[i][0].getText().equals(val))&&(buttons[i][0].getText().equals(buttons[i][2].getText()))){
					if(buttons[i][1].getText().equals("")){
						buttons[i][1].setText(val);
						//System.out.println("here");
						buttons[i][1].setEnabled(false);
						check=1;
						return check;
					}
				}
				
				else if(!(buttons[i][1].getText().equals(""))&& (buttons[i][1].getText().equals(val))&&(buttons[i][1].getText().equals(buttons[i][2].getText()))){
					if(buttons[i][0].getText().equals("")){
						buttons[i][0].setText(val);
						//System.out.println("here");
						buttons[i][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				

				if(!(buttons[0][i].getText().equals(""))&& (buttons[0][i].getText().equals(val))&&(buttons[0][i].getText().equals(buttons[1][i].getText()))){
					if(buttons[2][i].getText().equals("")){
						buttons[2][i].setText(val);
						//System.out.println("here");
						buttons[2][i].setEnabled(false);
						check=1;						
						return check;
					}
				}
				else if(!(buttons[0][i].getText().equals(""))&& (buttons[0][i].getText().equals(val))&&(buttons[0][i].getText().equals(buttons[2][i].getText()))){
					if(buttons[1][i].getText().equals("")){
						buttons[1][i].setText(val);
						//System.out.println("here");
						buttons[1][i].setEnabled(false);
						check=1;						
						return check;
					}
				} 
				else if(!(buttons[1][i].getText().equals(""))&& (buttons[1][i].getText().equals(val))&&(buttons[1][i].getText().equals(buttons[2][i].getText()))){
					if(buttons[0][i].getText().equals("")){
						buttons[0][i].setText(val);
						//System.out.println("here");
						buttons[0][i].setEnabled(false);
						check=1;
						return check;
					}
				}
			}

			if(check==0){
				if(!(buttons[0][0].getText().equals(""))&& (buttons[0][0].getText().equals(val))&&(buttons[0][0].getText().equals(buttons[1][1].getText()))){
					if(buttons[2][2].getText().equals("")){
						buttons[2][2].setText(val);
						//System.out.println("here");
						buttons[2][2].setEnabled(false);
						check=1;
						return check;

					}
				}
				else if(!(buttons[1][1].getText().equals(""))&& (buttons[1][1].getText().equals(val))&&(buttons[1][1].getText().equals(buttons[2][2].getText()))){
					if(buttons[0][0].getText().equals("")){
						buttons[0][0].setText(val);
						//System.out.println("here");
						buttons[0][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				else if(!(buttons[0][0].getText().equals(""))&& (buttons[0][0].getText().equals(val))&&(buttons[0][0].getText().equals(buttons[2][2].getText()))){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(val);
						//System.out.println("here");
						buttons[1][1].setEnabled(false);
						check=1;
						return check;
					}
				}

			}

			if (check==0){
				if(!(buttons[0][2].getText().equals(""))&& (buttons[0][2].getText().equals(val))&&(buttons[0][2].getText().equals(buttons[1][1].getText()))){
					if(buttons[2][0].getText().equals("")){
						buttons[2][0].setText(val);
						//System.out.println("here");
						buttons[2][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				else if(!(buttons[0][2].getText().equals(""))&& (buttons[0][2].getText().equals(val))&&(buttons[0][2].getText().equals(buttons[2][0].getText()))){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(val);
						//System.out.println("here");
						buttons[1][1].setEnabled(false);
						check=1;
						return check;
					}
				}

				else if(!(buttons[1][1].getText().equals(""))&& (buttons[1][1].getText().equals(val))&&(buttons[2][0].getText().equals(buttons[1][1].getText()))){
					if(buttons[0][2].getText().equals("")){
						buttons[0][2].setText(val);
						//System.out.println("here");
						buttons[0][2].setEnabled(false);
						check=1;
						return check;
					}
				}

			}
			return check;

		}



		public int block(String val){
			int check=0;
			int i;
			for(i=0;i<3;i++){
				
				if(!(buttons[i][0].getText().equals(""))&& !(buttons[i][0].getText().equals(val))&&(buttons[i][0].getText().equals(buttons[i][1].getText()))){
					if(buttons[i][2].getText().equals("")){
						buttons[i][2].setText(val);
						buttons[i][2].setEnabled(false);
						check=1;
						return check;
					}
				}
				
				else if(!(buttons[i][0].getText().equals(""))&& !(buttons[i][0].getText().equals(val))&&(buttons[i][0].getText().equals(buttons[i][2].getText()))){
					if(buttons[i][1].getText().equals("")){
						buttons[i][1].setText(val);
						buttons[i][1].setEnabled(false);
						check=1;
						return check;
					}
				}
				
				else if(!(buttons[i][1].getText().equals(""))&& !(buttons[i][1].getText().equals(val))&&(buttons[i][1].getText().equals(buttons[i][2].getText()))){
					if(buttons[i][0].getText().equals("")){
						buttons[i][0].setText(val);
						buttons[i][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				

				if(!(buttons[0][i].getText().equals(""))&& !(buttons[0][i].getText().equals(val))&&(buttons[0][i].getText().equals(buttons[1][i].getText()))){
					if(buttons[2][i].getText().equals("")){
						buttons[2][i].setText(val);
						buttons[2][i].setEnabled(false);
						check=1;						
						return check;
					}
				}
				else if(!(buttons[0][i].getText().equals(""))&& !(buttons[0][i].getText().equals(val))&&(buttons[0][i].getText().equals(buttons[2][i].getText()))){
					if(buttons[1][i].getText().equals("")){
						buttons[1][i].setText(val);
						buttons[1][i].setEnabled(false);
						check=1;						
						return check;
					}
				} 
				else if(!(buttons[1][i].getText().equals(""))&& !(buttons[1][i].getText().equals(val))&&(buttons[1][i].getText().equals(buttons[2][i].getText()))){
					if(buttons[0][i].getText().equals("")){
						buttons[0][i].setText(val);
						buttons[0][i].setEnabled(false);
						check=1;
						return check;
					}
				}
			}

			if(check==0){
				if(!(buttons[0][0].getText().equals(""))&& !(buttons[0][0].getText().equals(val))&&(buttons[0][0].getText().equals(buttons[1][1].getText()))){
					if(buttons[2][2].getText().equals("")){
						buttons[2][2].setText(val);
						buttons[2][2].setEnabled(false);
						check=1;
						return check;

					}
				}
				else if(!(buttons[1][1].getText().equals(""))&& !(buttons[1][1].getText().equals(val))&&(buttons[1][1].getText().equals(buttons[2][2].getText()))){
					if(buttons[0][0].getText().equals("")){
						buttons[0][0].setText(val);
						buttons[0][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				else if(!(buttons[0][0].getText().equals(""))&& !(buttons[0][0].getText().equals(val))&&(buttons[0][0].getText().equals(buttons[2][2].getText()))){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(val);
						buttons[1][1].setEnabled(false);
						check=1;
						return check;
					}
				}

			}

			if (check==0){
				if(!(buttons[0][2].getText().equals(""))&& !(buttons[0][2].getText().equals(val))&&(buttons[0][2].getText().equals(buttons[1][1].getText()))){
					if(buttons[2][0].getText().equals("")){
						buttons[2][0].setText(val);
						buttons[2][0].setEnabled(false);
						check=1;
						return check;
					}
				}
				else if(!(buttons[0][2].getText().equals(""))&& !(buttons[0][2].getText().equals(val))&&(buttons[0][2].getText().equals(buttons[2][0].getText()))){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(val);
						buttons[1][1].setEnabled(false);
						check=1;
						return check;
					}
				}

				else if(!(buttons[1][1].getText().equals(""))&& !(buttons[1][1].getText().equals(val))&&(buttons[2][0].getText().equals(buttons[1][1].getText()))){
					if(buttons[0][2].getText().equals("")){
						buttons[0][2].setText(val);
						buttons[0][2].setEnabled(false);
						check=1;
						return check;
					}
				}

			}
			return check;

		}

		public void ai_turn(String val){
			int count = 0;
			int i,j;
			for(i=0;i<3;i++){                     
				for(j=0;j<3;j++){
					if (buttons[i][j].getText().equals("")){
						count+=1;
					}
				}
			}
			if(count == 9){
				buttons[1][1].setText(val);
				buttons[1][1].setEnabled(false);
			}
			else{
				int played= win(val);
				if (played ==0){
					int blocked = block(val);
					if(blocked == 0){
						generate(val);
					}
				}
			}

			output.setText(""+user1+ " turn");



		}
	
	
/*
		public void ai(char val, char opp, int turn){
		
			int x=-1;
			int y=-1;
			Random a=new Random();
			if(turn==1){
				
				x = 2*a.nextInt(2);
				y = 2*a.nextInt(2);
				buttons[x][y]=val;
			}
			else if(turn==2){
				if((buttons[0][0]==opp)||(buttons[0][2]==opp)||(buttons[2][0]==opp)||(buttons[2][2]==opp)){
					buttons[1][1]=val;
				}
				else if(buttons[1][1]==opp){
					x = 2*a.nextInt(2);
					y = 2*a.nextInt(2);
					buttons[x][y]=val;
				}
				else {
					int i,j;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							if(buttons[i][j]==opp){
								x=i;
								y=j;
								break;
							}
						}
					}
					if(x==0&&y==1){
						y=2*a.nextInt(2);
						buttons[x][y]=val;
					}
					else if(y==0&&x==1){
						x=2*a.nextInt(2);
						buttons[x][y]=val;
					}
					else if(y==2&&x==1){
						x=2*a.nextInt(2);
						buttons[x][y]=val;
					}
					else if(x==2&&y==1){
						y=2*a.nextInt(2);
						buttons[x][y]=val;
					}
					
				}
			}
			else if(turn==3){
				int i,j;
				for(i=0;i<3;i++){
					for(j=0;j<3;j++){
						if(buttons[i][j]==val){
							x=i;
							y=j;
							break;
						}
					}
				}
				if(buttons[1][1]==opp){
					if(x==y){
						buttons[2][2]=val;
						buttons[0][0]=val;
					}
					else{
						buttons[0][2]=val;
						buttons[2][0]=val;
					}
				}
				else if((buttons[0][1]==opp)||(buttons[1][0]==opp)||(buttons[1][2]==opp)||(buttons[2][1]==opp)){
					buttons[1][1]=val;
				}

				else{
					if(x==y){
						if(buttons[0][2]==opp){
							buttons[2][0]=val;
						}
						else if(buttons[2][0]==opp){
							buttons[0][2]=val;
						}
						else{
							int pos=a.nextInt(2);
							if(pos==0){
								buttons[0][2]=val;
							}
							else{
								buttons[2][0]=val;
							}

						}
					}
					else{
						if(buttons[0][0]==opp){
							buttons[2][2]=val;
						}
						else if(buttons[2][2]==opp){
							buttons[0][0]=val;
						}
						else{
							int pos=a.nextInt(2);
							if(pos==0){
								buttons[0][0]=val;
							}
							else{
								buttons[2][2]=val;
							}

						}
					}
				}
			}
			else if(turn==4){
				int blocked=block(val);

				if(blocked==0){
					if((buttons[1][1]==val)&&(((buttons[1][0]==opp)&&(buttons[1][2]==opp))||((buttons[0][1]==opp)&&(buttons[2][1]==opp)))){
						x = 2*a.nextInt(2);
						y = 2*a.nextInt(2);
						buttons[x][y]=val;
					}
					else if((buttons[1][1]==opp)&&(((buttons[0][0]==val)&&(buttons[2][2]==opp))||((buttons[0][2]==val)&&(buttons[2][0]==opp))||((buttons[2][2]==val)&&(buttons[0][0]==opp))||((buttons[2][0]==val)&&(buttons[0][2]==opp)))){
						if((buttons[0][0]==opp)||(buttons[0][0]==val)){
							int no=a.nextInt(2);  // 0- 02, 1- 20
							if(no==0){
								buttons[0][2]=val;
							}
							else{
								buttons[2][0]=val;
							}
						}
						else if((buttons[0][2]==opp)||(buttons[0][2]==val)){
							int no=a.nextInt(2);  // 0- 00, 1- 22
							if(no==0){
								buttons[0][0]=val;
							}
							else{
								buttons[2][2]=val;
							}
						}
					}
					else if((buttons[1][1]==val)&&(((buttons[0][0]==opp)&&(buttons[2][2]==opp))||((buttons[0][2]==opp)&&(buttons[2][0]==opp)))){
						int posi=a.nextInt(4); //0- 01, 1- 10, 2- 12, 3- 21, if occuppied plus 1
						if(posi==0){
							if(buttons[0][1]==opp){
								buttons[1][0]=val;
							}
							else{
								buttons[0][1]=val;
							}
						}
						else if(posi==1){
							if(buttons[1][0]==opp){
								buttons[1][2]=val;
							}
							else{
								buttons[1][0]=val;
							}
						}
						else if(posi==2){
							if(buttons[1][2]==opp){
								buttons[2][1]=val;
							}
							else{
								buttons[1][2]=val;
							}
						}
						else if(posi==3){
							if(buttons[2][1]==opp){
								buttons[0][1]=val;
							}
							else{
								buttons[2][1]=val;
							}
						}
					}
					else if((buttons[1][1]==val)&&((buttons[0][0]==opp)||(buttons[0][2]==opp)||(buttons[2][0]==opp)||(buttons[2][2]==opp))&&((buttons[0][1]==opp)||(buttons[1][0]==opp)||(buttons[1][2]==opp)||(buttons[2][1]==opp))){
						if((buttons[0][0]==opp)&&(buttons[1][2]==opp)){
							buttons[0][2]=val;
						}
						else if((buttons[0][0]==opp)&&(buttons[2][1]==opp)){
							buttons[2][0]=val;
						}
						else if((buttons[0][2]==opp)&&(buttons[1][0]==opp)){
							buttons[0][0]=val;
						}
						else if((buttons[0][2]==opp)&&(buttons[2][1]==opp)){
							buttons[2][2]=val;
						}
						else if((buttons[2][0]==opp)&&(buttons[1][2]==opp)){
							buttons[2][2]=val;
						}
						else if((buttons[2][0]==opp)&&(buttons[0][1]==opp)){
							buttons[0][0]=val;
						}
						else if((buttons[2][2]==opp)&&(buttons[0][1]==opp)){
							buttons[0][2]=val;
						}
						else if((buttons[2][2]==opp)&&(buttons[1][0]==opp)){
							buttons[2][0]=val;
						}
					}
					else{
						buttons[1][1]=val;
					}

				}
			}
			else if(turn==5){
				int played=win(val);
				if(played==0){
					int blocked=block(val);
				}
			}
			else if(turn==6){
				int played=win(val);
				if(played==0){
					int blocked=block(val);
					if(blocked==0){
						int[][] ran=new int[4][2];
						int i,j;
						int count=0;
						for(i=0;i<3;i++){                     
							for(j=0;j<3;j++){
								if (buttons[i][j]=='-'){
									ran[count][0]=i;     
									ran[count][1]=j;      
									count+=1;
								}
							}
						}
			
						if(count!=0){
							int pos=a.nextInt(count);      
				 
			
							buttons[ran[pos][0]][ran[pos][1]]=val;
			
						}
					}
					
				}
			}
			else if(turn==7){
				int played=win(val);
				if(played==0){
					int blocked=block(val);
				}
			}
			else if(turn==8){
				int played=win(val);
				if(played==0){
					int blocked=block(val);
					if(blocked==0){
						int[][] ran=new int[2][2];
						int i,j;
						int count=0;
						for(i=0;i<3;i++){                     
							for(j=0;j<3;j++){
								if (buttons[i][j]=='-'){
									ran[count][0]=i;     
									ran[count][1]=j;      
									count+=1;
								}
							}
						}
			
						if(count!=0){
							int pos=a.nextInt(count);      
				 
			
							buttons[ran[pos][0]][ran[pos][1]].setText(val);
			
						}
					}
				}
			}
			else if(turn==9){
				int played=win(val);
				
				if(played==0){
					int blocked=block(val);
					
				}
			}
		}

			*/
		public int checkstate(){
			int i,j;
			int win=3; 
			for(i=0;i<3;i++){
				if(!(buttons[i][0].getText().equals(""))&&(buttons[i][0].getText().equals(buttons[i][1].getText()))&&(buttons[i][1].getText().equals(buttons[i][2].getText()))){
					if(buttons[i][0].getText().equals("X")){
						win=1;
					}
					else{
						win=2;
					}
				}

			}
			for(i=0;i<3;i++){
				if(!(buttons[0][i].getText().equals(""))&&(buttons[0][i].getText().equals(buttons[1][i].getText()))&&(buttons[1][i].getText().equals(buttons[2][i].getText()))){
					if(buttons[0][i].getText().equals("X")){
						win=1;
					}
					else{
						win=2;
					}
				}
				
			}

			if(!(buttons[0][0].getText().equals(""))&&(buttons[0][0].getText().equals(buttons[1][1].getText()))&&(buttons[1][1].getText().equals(buttons[2][2].getText()))){
					if(buttons[0][0].getText().equals("X")){
						win=1;
					}
					else{
						win=2;
					}
			}
			if(!(buttons[0][2].getText().equals(""))&&(buttons[0][2].getText().equals(buttons[1][1].getText()))&&(buttons[1][1].getText().equals(buttons[2][0].getText()))){
					if(buttons[0][2].getText().equals("X")){
						win=1;
					}
					else{
						win=2;
					}
			}
			if((win!=1)&&(win!=2)){
				int check=get();
				if(check==0){
					win=0;
				}
			}
		return win;
		}
		public void generate(String val){
		
			int[][] ran=new int[9][2];
			int i,j;
			int count=0;
			for(i=0;i<3;i++){                     
				for(j=0;j<3;j++){
					if (buttons[i][j].getText().equals("")){
						ran[count][0]=i;     
						ran[count][1]=j;      
						count+=1;
					}
				}
			}
			Random a=new Random();
			if(count!=0){
				int pos=a.nextInt(count);      // gives the position in ran array where there is a 0, as the next tile should be generated
				 
				//delay(1000);
				buttons[ran[pos][0]][ran[pos][1]].setText(val);
				buttons[ran[pos][0]][ran[pos][1]].setEnabled(false);
			}
			output.setText(""+user1+ " turn");
		
		
		}
		public void user1_user2(){
			gametype = 0;
			if(val_output%2 != 0){
				output.setText("User 1: "+user1+ " turn");
			}
			else if(val_output%2 == 0){
				output.setText("User 2: "+user2+ " turn");
			}
			
			if(get()==1){
				////System.out.println("hey");
				val_output++;
				/*if(val_output%2==0){
					x= s.nextInt();
					y= s.nextInt();
					game.put(x,y,'X');
					i++;
				}
				else{
					x= s.nextInt();
					y= s.nextInt();
					game.put(x,y,'O');
					i++;
				}
				System.out.print("\n");
				game.print();
				System.out.print("\n");*/
				int win=checkstate();
				if(win==1){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					val_output = 0;
					
				}
				else if(win==2){
					output.setText("Computer "+user2+ " wins.");
					color_button();
					main_butt_en = 1;
					val_output = 0;
					
				}
				

			}
			else{
				int win=checkstate();
				if(win==0){
					output.setText("Tie");
					main_butt_en = 1;
					val_output = 0;
				}
				else if(win==1){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					val_output = 0;
					
				}
				else if(win==2){
					output.setText("Computer "+user2+ " wins.");
					color_button();
					main_butt_en = 1;
					val_output = 0;
					
				}
			}



		}
		public void cpuai(){

			if(timer_check == 0){
			timer_check = 1;
			output.setText("AI Turn");
			timer=new Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("Computer Turn");
						buttons[1][1].setText("X");
						buttons[1][1].setEnabled(false);

						timer.stop();
					}

			});
			timer.start();
			////timer.stop();
			
			timer2=new Timer(2000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Turn");
						buttons[2][1].setText("O");
						buttons[2][1].setEnabled(false);
						timer2.stop();
					}

			});
			timer2.start();

			
			timer3=new Timer(3000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("Computer Turn");
						buttons[0][0].setText("X");
						buttons[0][0].setEnabled(false);
						timer3.stop();
					}

			});
			timer3.start();

			
			timer4=new Timer(4000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Turn");
						buttons[0][1].setText("O");
						buttons[0][1].setEnabled(false);
						timer4.stop();

					}

			});
			timer4.start();

			

			timer5=new Timer(5000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Wins");
						buttons[2][2].setText("X");
						buttons[2][2].setEnabled(false);
						main_butt_en = 1;
						color_button();
						timer5.stop();
					}

			});
			timer5.start();

		}
		

		else if(timer_check==1){
			timer_check = 0;
		
			output.setText("Computer Turn");
			timer=new Timer(1000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Turn");
						buttons[0][2].setText("X");
						buttons[0][2].setEnabled(false);

						timer.stop();
					}

			});
			timer.start();
			////timer.stop();
			
			timer2=new Timer(2000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("Computer Turn");
						buttons[1][2].setText("O");
						buttons[1][2].setEnabled(false);
						timer2.stop();
					}

			});
			timer2.start();

			
			timer3=new Timer(3000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Turn");
						buttons[2][0].setText("X");
						buttons[2][0].setEnabled(false);
						timer3.stop();
					}

			});
			timer3.start();

			
			timer4=new Timer(4000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("Computer Turn");
						buttons[1][1].setText("O");
						buttons[1][1].setEnabled(false);
						timer4.stop();

					}

			});
			timer4.start();

			

			timer5=new Timer(5000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Turn");
						buttons[2][1].setText("X");
						buttons[2][1].setEnabled(false);
						//main_butt_en = 1;
						//color_button();
						timer5.stop();
					}

			});
			timer5.start();


			timer6=new Timer(6000, new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
					{
						output.setText("AI Wins");
						buttons[1][0].setText("O");
						buttons[1][0].setEnabled(false);
						main_butt_en = 1;
						color_button();
						timer6.stop();
					}

			});
			timer6.start();

		}
			// timer=new Timer(6000, new ActionListener()
			// {
			// 	public void actionPerformed(ActionEvent e)
			// 		{
			// 			output.setText("AI Wins");
						
			// 			//timer.stop();
			// 		}

			// });
			// timer.start();

			// timer=new Timer(7000, new ActionListener()
			// {
			// 	public void actionPerformed(ActionEvent e)
			// 		{
			// 			output.setText("AI Wins");
						
			// 			//timer.stop();
			// 		}

			// });
			// timer.start();
			// timer.stop();
			
			////timer.stop();
			/*main_butt_en = 1;
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					buttons[i][j].setEnabled(true);
				}
			}
			buttons[0][0].setBackground(Color.GREEN);
			buttons[1][1].setBackground(Color.GREEN);
			buttons[2][2].setBackground(Color.GREEN);*/
			//color_button();
			//buttons[1][1].setText("X");
			//buttons[2][0].setText("X");
			

			
			
			//buttons[1][2].setText("O");
			//buttons[2][1].setText("O");
			//output.setText("Tie");
		}

	
		public void cpu_turn(String val){
			//if(get()==1){
			//	generate(val);
			int win=checkstate();
			if(win == 0 || win ==1|| win==2){
				if(win==1 && val_output==0){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==1 && val_output==1){
					output.setText("Computer wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==2 && val_output==0){
					output.setText("Computer wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==2 && val_output==1){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				if(win==0){
					output.setText("Tie");
					main_butt_en = 1;
					//al_output = 0;
				}
			}
			else{

				if (get()==1){
					generate(val);
					win=checkstate();
					if(win == 0 || win ==1|| win==2){
						if(win==1 && val_output==0){
							output.setText("Player "+user1+ " wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==1 && val_output==1){
							output.setText("Computer wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==2 && val_output==0){
							output.setText("Computer wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==2 && val_output==1){
							output.setText("Player "+user1+ " wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						if(win==0){
							output.setText("Tie");
							main_butt_en = 1;
							//al_output = 0;
						}
					}
				}
			}
		}

		public void ai_user(String val){
			//if(get()==1){
			//	generate(val);
			int win=checkstate();
			if(win == 0 || win ==1|| win==2){
				if(win==1 && val_output==0){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==1 && val_output==1){
					output.setText("AI wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==2 && val_output==0){
					output.setText("AI wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				else if(win==2 && val_output==1){
					output.setText("Player "+user1+ " wins.");
					color_button();
					main_butt_en = 1;
					//val_output = 0;
					
				}
				if(win==0){
					output.setText("Tie");
					main_butt_en = 1;
					//al_output = 0;
				}
			}
			else{

				if (get()==1){
					ai_turn(val);
					win=checkstate();
					if(win == 0 || win ==1|| win==2){
						if(win==1 && val_output==0){
							output.setText("Player "+user1+ " wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==1 && val_output==1){
							output.setText("AI wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==2 && val_output==0){
							output.setText("AI wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						else if(win==2 && val_output==1){
							output.setText("Player "+user1+ " wins.");
							color_button();
							main_butt_en = 1;
							//val_output = 0;
							
						}
						if(win==0){
							output.setText("Tie");
							main_butt_en = 1;
							//al_output = 0;
						}
					}
				}
			}
		}

		public void color_button(){
			int i;
			for(i=0;i<3;i++){
				for(int j=0;j<3;j++){
					buttons[i][j].setEnabled(true);
				}
			}
			
			for(i=0;i<3;i++){
				if(!(buttons[i][0].getText().equals(""))&&buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][1].getText().equals(buttons[i][2].getText())){
					buttons[i][0].setBackground(Color.GREEN);
					buttons[i][1].setBackground(Color.GREEN);
					buttons[i][2].setBackground(Color.GREEN);
					button_en = -1;
				}
			}
			for(i=0;i<3;i++){
				if(!(buttons[0][i].getText().equals(""))&&buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[1][i].getText().equals(buttons[2][i].getText())){
					buttons[0][i].setBackground(Color.GREEN);
					buttons[1][i].setBackground(Color.GREEN);
					buttons[2][i].setBackground(Color.GREEN);
					button_en = -1;

				}
			}

			if(!(buttons[0][0].getText().equals(""))&&buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][2].getText())){
				buttons[0][0].setBackground(Color.GREEN);
				buttons[1][1].setBackground(Color.GREEN);
				buttons[2][2].setBackground(Color.GREEN);
				button_en = -1;
			}

			if(!(buttons[0][2].getText().equals(""))&&buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[1][1].getText().equals(buttons[2][0].getText())){
				buttons[0][2].setBackground(Color.GREEN);
				buttons[1][1].setBackground(Color.GREEN);
				buttons[2][0].setBackground(Color.GREEN);
				button_en = -1;
			}
			/*for(i=0;i<3;i++){
				for(int j=0;j<3;j++){
					buttons[i][j].setEnabled(false);
				}
			}*/
		}
		class Action implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if (e.getSource() == exit){
					System.exit(0);
				}
				if (e.getSource() == exit2){
					System.exit(0);
				}

				if (e.getSource() == start_game){
					
					//frame.revalidate();
 					//frame.repaint();
					heading.setVisible(false);
					start_game.setVisible(false);
					start_game.setEnabled(false);
					exit.setVisible(false);
					exit.setEnabled(false);
 					main_game();
					
				}

				//for users

				if(e.getSource() == buttons[0][0] && gametype == 0 &&button_en ==1){
					if(buttons[0][0].getText().equals("")){
						buttons[0][0].setText(random[val_output%2]);
						buttons[0][0].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[0][1] && gametype == 0&&button_en ==1){
					if(buttons[0][1].getText().equals("")){
						buttons[0][1].setText(random[val_output%2]);
						buttons[0][1].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[0][2]&& gametype == 0&&button_en ==1){
					if(buttons[0][2].getText().equals("")){
						buttons[0][2].setText(random[val_output%2]);
						buttons[0][2].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[1][0]&& gametype == 0&&button_en ==1){
					if(buttons[1][0].getText().equals("")){
						buttons[1][0].setText(random[val_output%2]);
						buttons[1][0].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[1][1]&& gametype == 0&&button_en ==1){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(random[val_output%2]);
						buttons[1][1].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[1][2]&& gametype == 0&&button_en ==1){
					if(buttons[1][2].getText().equals("")){
						buttons[1][2].setText(random[val_output%2]);
						buttons[1][2].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[2][0]&& gametype == 0&&button_en ==1){
					if(buttons[2][0].getText().equals("")){
						buttons[2][0].setText(random[val_output%2]);
						buttons[2][0].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[2][1]&& gametype == 0&&button_en ==1){
					if(buttons[2][1].getText().equals("")){
						buttons[2][1].setText(random[val_output%2]);
						buttons[2][1].setEnabled(false);
						user1_user2();
					}
				}
				if(e.getSource() == buttons[2][2]&& gametype == 0&&button_en ==1){
					if(buttons[2][2].getText().equals("")){
						buttons[2][2].setText(random[val_output%2]);
						buttons[2][2].setEnabled(false);
						user1_user2();
					}
				}

				// for cpu vs user


				if(e.getSource() == buttons[0][0] && gametype == 1 &&button_en ==1){
					if(buttons[0][0].getText().equals("")){
						buttons[0][0].setText(random[val_output%2]);
						buttons[0][0].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[0][1] && gametype == 1&&button_en ==1){
					if(buttons[0][1].getText().equals("")){
						buttons[0][1].setText(random[val_output%2]);
						buttons[0][1].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[0][2]&& gametype == 1&&button_en ==1){
					if(buttons[0][2].getText().equals("")){
						buttons[0][2].setText(random[val_output%2]);
						buttons[0][2].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[1][0]&& gametype == 1&&button_en ==1){
					if(buttons[1][0].getText().equals("")){
						buttons[1][0].setText(random[val_output%2]);
						buttons[1][0].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[1][1]&& gametype == 1&&button_en ==1){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(random[val_output%2]);
						buttons[1][1].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[1][2]&& gametype == 1&&button_en ==1){
					if(buttons[1][2].getText().equals("")){
						buttons[1][2].setText(random[val_output%2]);
						buttons[1][2].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[2][0]&& gametype == 1&&button_en ==1){
					if(buttons[2][0].getText().equals("")){
						buttons[2][0].setText(random[val_output%2]);
						buttons[2][0].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[2][1]&& gametype == 1&&button_en ==1){
					if(buttons[2][1].getText().equals("")){
						buttons[2][1].setText(random[val_output%2]);
						buttons[2][1].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}
				if(e.getSource() == buttons[2][2]&& gametype == 1&&button_en ==1){
					if(buttons[2][2].getText().equals("")){
						buttons[2][2].setText(random[val_output%2]);
						buttons[2][2].setEnabled(false);
						output.setText("Computer's Turn");
						if(val_output==0){
							cpu_turn("O");
						}
						else if(val_output==1){
							cpu_turn("X");
						}
					}
				}


				//for user vs ai

				if(e.getSource() == buttons[0][0] && gametype == 3 &&button_en ==1){
					if(buttons[0][0].getText().equals("")){
						buttons[0][0].setText(random[val_output%2]);
						buttons[0][0].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[0][1] && gametype == 3&&button_en ==1){
					if(buttons[0][1].getText().equals("")){
						buttons[0][1].setText(random[val_output%2]);
						buttons[0][1].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[0][2]&& gametype == 3&&button_en ==1){
					if(buttons[0][2].getText().equals("")){
						buttons[0][2].setText(random[val_output%2]);
						buttons[0][2].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[1][0]&& gametype == 3&&button_en ==1){
					if(buttons[1][0].getText().equals("")){
						buttons[1][0].setText(random[val_output%2]);
						buttons[1][0].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[1][1]&& gametype == 3&&button_en ==1){
					if(buttons[1][1].getText().equals("")){
						buttons[1][1].setText(random[val_output%2]);
						buttons[1][1].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[1][2]&& gametype == 3&&button_en ==1){
					if(buttons[1][2].getText().equals("")){
						buttons[1][2].setText(random[val_output%2]);
						buttons[1][2].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[2][0]&& gametype == 3&&button_en ==1){
					if(buttons[2][0].getText().equals("")){
						buttons[2][0].setText(random[val_output%2]);
						buttons[2][0].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[2][1]&& gametype == 3&&button_en ==1){
					if(buttons[2][1].getText().equals("")){
						buttons[2][1].setText(random[val_output%2]);
						buttons[2][1].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}
				if(e.getSource() == buttons[2][2]&& gametype == 3&&button_en ==1){
					if(buttons[2][2].getText().equals("")){
						buttons[2][2].setText(random[val_output%2]);
						buttons[2][2].setEnabled(false);
						output.setText("AI's Turn");
						if(val_output==0){
							ai_user("O");
						}
						else if(val_output==1){
							ai_user("X");
						}
					}
				}




				//main buttons functions

				if(e.getSource()==cpu_ai){
					gametype = 2;
					users.setForeground(Color.BLACK);
					user_cpu.setForeground(Color.BLACK);
					user_ai.setForeground(Color.BLACK);
					cpu_ai.setForeground(Color.BLUE);
					main_butt_en = -1;
					int i,j;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							buttons[i][j].setText("");
							buttons[i][j].setEnabled(true);
							buttons[i][j].setBackground(null);
						}
					}
					cpuai();
				}


				if (e.getSource() == users && main_butt_en == 1){
					val_output = 0;
					gametype = 0;
					main_butt_en = -1;
					button_en = 1;
					int i,j;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							buttons[i][j].setText("");
							buttons[i][j].setEnabled(true);
							buttons[i][j].setBackground(null);
						}
					}
					users.setForeground(Color.BLUE);
					user_cpu.setForeground(Color.BLACK);
					user_ai.setForeground(Color.BLACK);
					cpu_ai.setForeground(Color.BLACK);
					JTextField name1 = new JTextField(15);
					JTextField name2 = new JTextField(15);

					JPanel names = new JPanel(new GridBagLayout());
					GridBagConstraints c3 = new GridBagConstraints();
					c3.gridx = 0;
					c3.gridy = 0;
					names.add(new JLabel("User 1 "),c3);
					c3.gridx = 2;
					names.add(name1, c3);
					//names.add(Box.createHorizontalStrut(25));
					c3.gridx = 0;
					c3.gridy = 2;
					names.add(new JLabel("User 2 "),c3);
					c3.gridx = 2;
					names.add(name2,c3);

					//Object[] options = {"OK"};
    				//int n = JOptionPane.showConfirmDialog(names, "Enter Names.", "Names", JOptionPane.OK_CANCEL_OPTION);
    				//int n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.DEFAULT_OPTION, 0, null, options, options[0]);
					int n = JOptionPane.showConfirmDialog(null,names,"Names",JOptionPane.OK_CANCEL_OPTION);
					//if(result == JOptionPane.OK_OPTION){
					//if(n == JOptionPane.CANCEL_OPTION){
					//		JOptionPane.showMessageDialog(names,"Thanks for your time.");
					//}
					//if(n == JOptionPane.OK_OPTION) {
					while(name1.getText().equals("") || name2.getText().equals("")){
						if(n == JOptionPane.OK_OPTION){
							JOptionPane.showMessageDialog(names,"Enter Correctly.");
							n = JOptionPane.showConfirmDialog(null,names,"Names",JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showConfirmDialog(names, "Enter Names.", "Names", JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.DEFAULT_OPTION,0, null, options, options[0]);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						}
						else if(n == JOptionPane.CANCEL_OPTION){
							break;
						}

						
					}
					if (n == JOptionPane.OK_OPTION){
						user1 = name1.getText();
						user2 = name2.getText();
						//System.out.println("hey2");
						//user1_user2();
						//System.out.println(user1);
						//System.out.println(user2);
					}
					output.setText("User 1: "+user1+ " turn");
					//System.out.println("hey1");
					
				}

				if((e.getSource()==user_cpu)&& main_butt_en ==1){
					val_output = 0;
					gametype = 1;
					main_butt_en = -1;
					button_en = 1;
					int i,j;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							buttons[i][j].setText("");
							buttons[i][j].setEnabled(true);
							buttons[i][j].setBackground(null);
						}
					}
					users.setForeground(Color.BLACK);
					user_cpu.setForeground(Color.BLUE);
					user_ai.setForeground(Color.BLACK);
					cpu_ai.setForeground(Color.BLACK);
					JTextField name1 = new JTextField(15);
					JPanel names = new JPanel();
					names.add(new JLabel("Enter Name "));
					names.add(name1);
					int n = JOptionPane.showConfirmDialog(null,names,"Name",JOptionPane.OK_CANCEL_OPTION);

					while(name1.getText().equals("")){
						if(n == JOptionPane.OK_OPTION){
							JOptionPane.showMessageDialog(names,"Enter Correctly.");
							n = JOptionPane.showConfirmDialog(null,names,"Names",JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showConfirmDialog(names, "Enter Names.", "Names", JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.DEFAULT_OPTION,0, null, options, options[0]);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						}
						else if(n == JOptionPane.CANCEL_OPTION){
							break;
						}

						
					}
					if (n == JOptionPane.OK_OPTION){
						user1 = name1.getText();


						
						//System.out.println("hey2");
						//user1_user2();
						//System.out.println(user1);
						//System.out.println(user2);
					}
					Random a=new Random();
					//int chance = 1;
					int chance = a.nextInt(2);  //0 for user, 1 for computer
					if(chance == 0){
						output.setText(""+user1+ " turn");
					}
					else if(chance == 1){
						output.setText("Computer's Turn");
						cpu_turn("X");
						val_output=1;
					}



				}



				if((e.getSource()==user_ai)&& main_butt_en ==1){
					val_output = 0;
					gametype = 3;
					main_butt_en = -1;
					button_en = 1;
					int i,j;
					for(i=0;i<3;i++){
						for(j=0;j<3;j++){
							buttons[i][j].setText("");
							buttons[i][j].setEnabled(true);
							buttons[i][j].setBackground(null);
						}
					}
					users.setForeground(Color.BLACK);
					user_cpu.setForeground(Color.BLACK);
					user_ai.setForeground(Color.BLUE);
					cpu_ai.setForeground(Color.BLACK);
					JTextField name1 = new JTextField(15);
					JPanel names = new JPanel();
					names.add(new JLabel("Enter Name "));
					names.add(name1);
					int n = JOptionPane.showConfirmDialog(null,names,"Name",JOptionPane.OK_CANCEL_OPTION);

					while(name1.getText().equals("")){
						if(n == JOptionPane.OK_OPTION){
							JOptionPane.showMessageDialog(names,"Enter Correctly.");
							n = JOptionPane.showConfirmDialog(null,names,"Names",JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showConfirmDialog(names, "Enter Names.", "Names", JOptionPane.OK_CANCEL_OPTION);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.DEFAULT_OPTION,0, null, options, options[0]);
							//n = JOptionPane.showOptionDialog(names,"Enter your Names ","Names", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
						}
						else if(n == JOptionPane.CANCEL_OPTION){
							break;
						}

						
					}
					if (n == JOptionPane.OK_OPTION){
						user1 = name1.getText();


						
						//System.out.println("hey2");
						//user1_user2();
						//System.out.println(user1);
						//System.out.println(user2);
					}
					Random a=new Random();
					//int chance = 1;
					int chance = a.nextInt(2);  //0 for user, 1 for computer
					if(chance == 0){
						output.setText(""+user1+ " turn");
					}
					else if(chance == 1){
						output.setText("AI's Turn");
						ai_user("X");
						val_output=1;
					}



				}

			}

		}

		/*public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
    }
        }*/

	}
	

	public static void main(String[] args){
		grid load = new grid();
	}

}
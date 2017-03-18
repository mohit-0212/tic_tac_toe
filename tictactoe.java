import java.util.*;

class board{
	private char[][] grid= new char[3][3];
	public board(){
		int i,j;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				grid[i][j]='-';
			}

		}
	}
	public int get(){
		int i,j;
		int remaining=0;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				if(grid[i][j]=='-'){
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
	public void put(int x, int y, char val){
		if(x>2 || x<0 || y>2 || y<0){
			System.out.print("Invalid Coordinates Enter Again\n");
			int i,j;
			Scanner a= new Scanner(System.in);
			i=a.nextInt();
			j=a.nextInt();
			put(i,j,val);
		}
		else if(grid[x][y]!='-'){
			System.out.print("Invalid Coordinates Enter Again\n");
			int i,j;
			Scanner a= new Scanner(System.in);
			i=a.nextInt();
			j=a.nextInt();
			put(i,j,val);
		}
		else{
			grid[x][y]= val;
		}
	}
	

	public int win(char val){
		int check=0;
		int i;
		for(i=0;i<3;i++){
			if((grid[i][0]!='-')&&(grid[i][0]==val)&&(grid[i][0]==grid[i][1])){
				if(grid[i][2]=='-'){
					grid[i][2]=val;
					check=1;
					return check;
				}
			}
			else if((grid[i][0]!='-')&&(grid[i][0]==val)&&(grid[i][0]==grid[i][2])){
				if(grid[i][1]=='-'){
					grid[i][1]=val;
					check=1;
					return check;
				}
			}
			else if((grid[i][1]!='-')&&(grid[i][1]==val)&&(grid[i][1]==grid[i][2])){
				if(grid[i][0]=='-'){
					grid[i][0]=val;
					check=1;
					return check;
				}
			}
			if((grid[0][i]!='-')&&(grid[0][i]==val)&&(grid[0][i]==grid[1][i])){
				if(grid[2][i]=='-'){
					grid[2][i]=val;
					check=1;

					return check;
				}
			}
			else if((grid[0][i]!='-')&&(grid[0][i]==val)&&(grid[0][i]==grid[2][i])){
				if(grid[1][i]=='-'){
					grid[1][i]=val;
					check=1;
					return check;
				}
			}
			else if((grid[1][i]!='-')&&(grid[1][i]==val)&&(grid[1][i]==grid[2][i])){
				if(grid[0][i]=='-'){
					grid[0][i]=val;
					check=1;
					return check;
				}
			}
		}

		if(check==0){
			if((grid[0][0]!='-')&&(grid[0][0]==val)&&(grid[0][0]==grid[1][1])){
				if(grid[2][2]=='-'){
					grid[2][2]=val;
					check=1;
					return check;

				}
			}
			else if((grid[1][1]!='-')&&(grid[1][1]==val)&&(grid[1][1]==grid[2][2])){
				if(grid[0][0]=='-'){
					grid[0][0]=val;
					check=1;
					return check;
				}
			}
			else if((grid[0][0]!='-')&&(grid[0][0]==val)&&(grid[0][0]==grid[2][2])){
				if(grid[1][1]=='-'){
					grid[1][1]=val;
					check=1;
					return check;
				}
			}

		}

		if (check==0){
			if((grid[0][2]!='-')&&(grid[0][2]==val)&&(grid[0][2]==grid[1][1])){
				if(grid[2][0]=='-'){
					grid[2][0]=val;
					check=1;
					return check;
				}
			}
			else if((grid[0][2]!='-')&&(grid[0][2]==val)&&(grid[0][2]==grid[2][0])){
				if(grid[1][1]=='-'){
					grid[1][1]=val;
					check=1;
					return check;
				}
			}

			else if((grid[1][1]!='-')&&(grid[1][1]==val)&&(grid[2][0]==grid[1][1])){
				if(grid[0][2]=='-'){
					grid[0][2]=val;
					check=1;
					return check;
				}
			}

		}
		return check;

	}

	public int block(char val){
		int check=0;
		int i;
		for(i=0;i<3;i++){
			
			if((grid[i][0]!='-')&&(grid[i][0]!=val)&&(grid[i][0]==grid[i][1])){
				if(grid[i][2]=='-'){
					grid[i][2]=val;
					check=1;
					return check;
				}
			}
			
			else if((grid[i][0]!='-')&&(grid[i][0]!=val)&&(grid[i][0]==grid[i][2])){
				if(grid[i][1]=='-'){
					grid[i][1]=val;
					check=1;
					return check;
				}
			}
			
			else if((grid[i][1]!='-')&&(grid[i][1]!=val)&&(grid[i][1]==grid[i][2])){
				if(grid[i][0]=='-'){
					grid[i][0]=val;
					check=1;
					return check;
				}
			}
			

			if((grid[0][i]!='-')&&(grid[0][i]!=val)&&(grid[0][i]==grid[1][i])){
				
				if(grid[2][i]=='-'){
					grid[2][i]=val;
					check=1;
					
					return check;
				}
			}
			else if((grid[0][i]!='-')&&(grid[0][i]!=val)&&(grid[0][i]==grid[2][i])){
				if(grid[1][i]=='-'){
					grid[1][i]=val;
					check=1;
					
					return check;
				}
			} 
			else if((grid[1][i]!='-')&&(grid[1][i]!=val)&&(grid[1][i]==grid[2][i])){
				
				if(grid[0][i]=='-'){
					grid[0][i]=val;
					check=1;
					
					return check;
				}
			}
		}

		if(check==0){
			if((grid[0][0]!='-')&&(grid[0][0]!=val)&&(grid[0][0]==grid[1][1])){
				if(grid[2][2]=='-'){
					grid[2][2]=val;
					check=1;
					return check;

				}
			}
			else if((grid[1][1]!='-')&&(grid[1][1]!=val)&&(grid[1][1]==grid[2][2])){
				if(grid[0][0]=='-'){
					grid[0][0]=val;
					check=1;
					return check;
				}
			}
			else if((grid[0][0]!='-')&&(grid[0][0]!=val)&&(grid[0][0]==grid[2][2])){
				if(grid[1][1]=='-'){
					grid[1][1]=val;
					check=1;
					return check;
				}
			}

		}

		if (check==0){
			if((grid[0][2]!='-')&&(grid[0][2]!=val)&&(grid[0][2]==grid[1][1])){
				if(grid[2][0]=='-'){
					grid[2][0]=val;
					check=1;
					return check;
				}
			}
			else if((grid[0][2]!='-')&&(grid[0][2]!=val)&&(grid[0][2]==grid[2][0])){
				if(grid[1][1]=='-'){
					grid[1][1]=val;
					check=1;
					return check;
				}
			}

			else if((grid[1][1]!='-')&&(grid[1][1]!=val)&&(grid[2][0]==grid[1][1])){
				if(grid[0][2]=='-'){
					grid[0][2]=val;
					check=1;
					return check;
				}
			}

		}
		return check;

	}
	
	public void ai(char val, char opp, int turn){
		
		int x=-1;
		int y=-1;
		Random a=new Random();
		if(turn==1){
			
			x = 2*a.nextInt(2);
			y = 2*a.nextInt(2);
			grid[x][y]=val;
		}
		else if(turn==2){
			if((grid[0][0]==opp)||(grid[0][2]==opp)||(grid[2][0]==opp)||(grid[2][2]==opp)){
				grid[1][1]=val;
			}
			else if(grid[1][1]==opp){
				x = 2*a.nextInt(2);
				y = 2*a.nextInt(2);
				grid[x][y]=val;
			}
			else {
				int i,j;
				for(i=0;i<3;i++){
					for(j=0;j<3;j++){
						if(grid[i][j]==opp){
							x=i;
							y=j;
							break;
						}
					}
				}
				if(x==0&&y==1){
					y=2*a.nextInt(2);
					grid[x][y]=val;
				}
				else if(y==0&&x==1){
					x=2*a.nextInt(2);
					grid[x][y]=val;
				}
				else if(y==2&&x==1){
					x=2*a.nextInt(2);
					grid[x][y]=val;
				}
				else if(x==2&&y==1){
					y=2*a.nextInt(2);
					grid[x][y]=val;
				}
				
			}
		}
		else if(turn==3){
			int i,j;
			for(i=0;i<3;i++){
				for(j=0;j<3;j++){
					if(grid[i][j]==val){
						x=i;
						y=j;
						break;
					}
				}
			}
			if(grid[1][1]==opp){
				if(x==y){
					grid[2][2]=val;
					grid[0][0]=val;
				}
				else{
					grid[0][2]=val;
					grid[2][0]=val;
				}
			}
			else if((grid[0][1]==opp)||(grid[1][0]==opp)||(grid[1][2]==opp)||(grid[2][1]==opp)){
				grid[1][1]=val;
			}

			else{
				if(x==y){
					if(grid[0][2]==opp){
						grid[2][0]=val;
					}
					else if(grid[2][0]==opp){
						grid[0][2]=val;
					}
					else{
						int pos=a.nextInt(2);
						if(pos==0){
							grid[0][2]=val;
						}
						else{
							grid[2][0]=val;
						}

					}
				}
				else{
					if(grid[0][0]==opp){
						grid[2][2]=val;
					}
					else if(grid[2][2]==opp){
						grid[0][0]=val;
					}
					else{
						int pos=a.nextInt(2);
						if(pos==0){
							grid[0][0]=val;
						}
						else{
							grid[2][2]=val;
						}

					}
				}
			}
		}
		else if(turn==4){
			int blocked=block(val);

			if(blocked==0){
				if((grid[1][1]==val)&&(((grid[1][0]==opp)&&(grid[1][2]==opp))||((grid[0][1]==opp)&&(grid[2][1]==opp)))){
					x = 2*a.nextInt(2);
					y = 2*a.nextInt(2);
					grid[x][y]=val;
				}
				else if((grid[1][1]==opp)&&(((grid[0][0]==val)&&(grid[2][2]==opp))||((grid[0][2]==val)&&(grid[2][0]==opp))||((grid[2][2]==val)&&(grid[0][0]==opp))||((grid[2][0]==val)&&(grid[0][2]==opp)))){
					if((grid[0][0]==opp)||(grid[0][0]==val)){
						int no=a.nextInt(2);  // 0- 02, 1- 20
						if(no==0){
							grid[0][2]=val;
						}
						else{
							grid[2][0]=val;
						}
					}
					else if((grid[0][2]==opp)||(grid[0][2]==val)){
						int no=a.nextInt(2);  // 0- 00, 1- 22
						if(no==0){
							grid[0][0]=val;
						}
						else{
							grid[2][2]=val;
						}
					}
				}
				else if((grid[1][1]==val)&&(((grid[0][0]==opp)&&(grid[2][2]==opp))||((grid[0][2]==opp)&&(grid[2][0]==opp)))){
					int posi=a.nextInt(4); //0- 01, 1- 10, 2- 12, 3- 21, if occuppied plus 1
					if(posi==0){
						if(grid[0][1]==opp){
							grid[1][0]=val;
						}
						else{
							grid[0][1]=val;
						}
					}
					else if(posi==1){
						if(grid[1][0]==opp){
							grid[1][2]=val;
						}
						else{
							grid[1][0]=val;
						}
					}
					else if(posi==2){
						if(grid[1][2]==opp){
							grid[2][1]=val;
						}
						else{
							grid[1][2]=val;
						}
					}
					else if(posi==3){
						if(grid[2][1]==opp){
							grid[0][1]=val;
						}
						else{
							grid[2][1]=val;
						}
					}
				}
				else if((grid[1][1]==val)&&((grid[0][0]==opp)||(grid[0][2]==opp)||(grid[2][0]==opp)||(grid[2][2]==opp))&&((grid[0][1]==opp)||(grid[1][0]==opp)||(grid[1][2]==opp)||(grid[2][1]==opp))){
					if((grid[0][0]==opp)&&(grid[1][2]==opp)){
						grid[0][2]=val;
					}
					else if((grid[0][0]==opp)&&(grid[2][1]==opp)){
						grid[2][0]=val;
					}
					else if((grid[0][2]==opp)&&(grid[1][0]==opp)){
						grid[0][0]=val;
					}
					else if((grid[0][2]==opp)&&(grid[2][1]==opp)){
						grid[2][2]=val;
					}
					else if((grid[2][0]==opp)&&(grid[1][2]==opp)){
						grid[2][2]=val;
					}
					else if((grid[2][0]==opp)&&(grid[0][1]==opp)){
						grid[0][0]=val;
					}
					else if((grid[2][2]==opp)&&(grid[0][1]==opp)){
						grid[0][2]=val;
					}
					else if((grid[2][2]==opp)&&(grid[1][0]==opp)){
						grid[2][0]=val;
					}
				}
				else{
					grid[1][1]=val;
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
							if (grid[i][j]=='-'){
								ran[count][0]=i;     
								ran[count][1]=j;      
								count+=1;
							}
						}
					}
		
					if(count!=0){
						int pos=a.nextInt(count);      
			 
		
						grid[ran[pos][0]][ran[pos][1]]=val;
		
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
							if (grid[i][j]=='-'){
								ran[count][0]=i;     
								ran[count][1]=j;      
								count+=1;
							}
						}
					}
		
					if(count!=0){
						int pos=a.nextInt(count);      
			 
		
						grid[ran[pos][0]][ran[pos][1]]=val;
		
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
	public void generate(char val){
		
		int[][] ran=new int[9][2];
		int i,j;
		int count=0;
		for(i=0;i<3;i++){                     
			for(j=0;j<3;j++){
				if (grid[i][j]=='-'){
					ran[count][0]=i;     
					ran[count][1]=j;      
					count+=1;
				}
			}
		}
		Random a=new Random();
		if(count!=0){
			int pos=a.nextInt(count);      // gives the position in ran array where there is a 0, as the next tile should be generated
			 
		
			grid[ran[pos][0]][ran[pos][1]]=val;
		
		}
	
	
	}
	public void print(){
		int i,j;
		for(i=0;i<3;i++){
			for(j=0;j<3;j++){
				System.out.print(grid[i][j]+ "\t");
			}
			System.out.print("\n");
		}
	}
	public int checkstate(){
		int i,j;
		int win=3; 
		for(i=0;i<3;i++){
			if((grid[i][0]!='-')&&(grid[i][0]==grid[i][1])&&(grid[i][1]==grid[i][2])){
				if(grid[i][0]=='X'){
					win=1;
				}
				else{
					win=2;
				}
			}

		}
		for(i=0;i<3;i++){
			if((grid[0][i]!='-')&&(grid[0][i]==grid[1][i])&&(grid[1][i]==grid[2][i])){
				if(grid[0][i]=='X'){
					win=1;
				}
				else{
					win=2;
				}
			}
			
		}
		if((grid[0][0]!='-')&&(grid[0][0]==grid[1][1])&&(grid[1][1]==grid[2][2])){
			if(grid[0][0]=='X'){
					win=1;
				}
				else{
					win=2;
				}
		}
		if((grid[0][2]!='-')&&(grid[0][2]==grid[1][1])&&(grid[1][1]==grid[2][0])){
			if(grid[0][2]=='X'){
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

}

class labone{
	public static void main(String[] args){
		System.out.print("\n");
		System.out.println("1 - Player1(X) vs Player2(O)");
		System.out.println("2 - You(X) vs Computer(O)");
		System.out.println("3 - Computer(X) vs AI(O)");
		System.out.println("4 - You(X) vs AI(O)");
		System.out.println("5 - AI 1(X) vs AI 2(O)");
		System.out.print("\n");
		
		board game= new board();
		Scanner s= new Scanner(System.in);

		int choice= s.nextInt();
		if(choice==1){
			System.out.print("\n");
			game.print();
			System.out.print("\n");
			int i=0;
			int x,y;
			while(game.get()==1){
				if(i%2==0){
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
				System.out.print("\n");
				int win=game.checkstate();
				if(win==1){
					System.out.print("Player 1 Wins\n");
					break;
				}
				else if(win==2){
					System.out.print("Player 2 Wins\n");
					break;
				}
				else if(win==0){
					System.out.print("Tie\n");
					break;
				}

			}
		}
		else if(choice==2){
			System.out.print("\n");
			game.print();
			System.out.print("\nStart First ? Y/N \n\n");
			char input = s.next().charAt(0);
			int turn=0;
			if(Character.toLowerCase(input)=='y'){
				turn=0;
			}
			else if(Character.toLowerCase(input)=='n'){
				turn=1;
			}
			int i=0+turn;
			int x,y;
			while(game.get()==1){
				if(i%2==0){
					x= s.nextInt();
					y= s.nextInt();
					game.put(x,y,'X');
					i++;
				}
				else{
					game.generate('O');
					i++;
				}
				System.out.print("\n");
				game.print();
				System.out.print("\n");
				int win=game.checkstate();
				if(win==1){
					System.out.print("You Win\n");
					break;
				}
				else if(win==2){
					System.out.print("Computer Wins\n");
					break;
				}
				else if(win==0){
					System.out.print("Tie\n");
					break;
				}

			}

		}
		else if(choice==3){
			System.out.print("\n");
			game.print();
			System.out.print("\n\nComputer First ? Y/N \n\n");
			char input = s.next().charAt(0);
			int turn=0;
			if(Character.toLowerCase(input)=='y'){
				turn=0;
			}
			else if(Character.toLowerCase(input)=='n'){
				turn=1;
			}
			int i=0+turn;
			turn=1;
			int x,y;
			while(game.get()==1){
				if(i%2==0){
					
					game.generate('X');
					turn++;
					i++;

				}
				else{
					game.ai('O','X',turn);
					turn++;
					i++;
				}
				System.out.print("\n");
				game.print();
				System.out.print("\n");
				int win=game.checkstate();
				if(win==1){
					System.out.print("Computer Wins\n");
					break;
				}
				else if(win==2){
					System.out.print("AI Wins\n");
					break;
				}
				else if(win==0){
					System.out.print("Tie\n");
					break;
				}

			}

		}
		else if(choice==4){
			System.out.print("\n");
			game.print();
			System.out.print("\n\nStart First ? Y/N \n\n");
			char input = s.next().charAt(0);
			int turn=0;
			if(Character.toLowerCase(input)=='y'){
				turn=0;
			}
			else if(Character.toLowerCase(input)=='n'){
				turn=1;
			}
			int i=0+turn;
			turn=1;
			int x,y;
			while(game.get()==1){
				if(i%2==0){
					x= s.nextInt();
					y= s.nextInt();
					game.put(x,y,'X');
					turn++;
					i++;

				}
				else{
					game.ai('O','X',turn);
					turn++;
					i++;
				}
				System.out.print("\n");
				game.print();
				System.out.print("\n");
				int win=game.checkstate();
				if(win==1){
					System.out.print("You Win\n");
					break;
				}
				else if(win==2){
					System.out.print("AI Wins\n");
					break;
				}
				else if(win==0){
					System.out.print("Tie\n");
					break;
				}

			}

		}
		else if(choice==5){
			System.out.print("\n");
			game.print();
			System.out.print("\n\nAI 1 start first ? Y/N \n\n");
			char input = s.next().charAt(0);
			int turn=0;
			if(Character.toLowerCase(input)=='y'){
				turn=0;
			}
			else if(Character.toLowerCase(input)=='n'){
				turn=1;
			}
			int i=0+turn;
			turn=1;
			int x,y;
			while(game.get()==1){
				if(i%2==0){
					game.ai('X','O',turn);
					turn++;
					i++;

				}
				else{
					game.ai('O','X',turn);
					turn++;
					i++;
				}
				System.out.print("\n");
				game.print();
				System.out.print("\n");
				int win=game.checkstate();
				if(win==1){
					System.out.print("AI 1 Wins\n");
					break;
				}
				else if(win==2){
					System.out.print("AI 2 Wins\n");
					break;
				}
				else if(win==0){
					System.out.print("Tie\n");
					break;
				}

			}

		}

		
	}
}
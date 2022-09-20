
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		
		System.out.println("Welcome to TicTacToe"); 
		System.out.println("     "); 
		System.out.println("One Player Game or Two Player Game?"); 
		if (acceptintegerfromConsole(1,2) == 2) 
			twoplayerGame();
		else
			oneplayerGame();
		
			
	}//end of main
			
	

	public static void printGameBoard(String[] movesNew) {
		System.out.println("             ");
		System.out.println("  " + movesNew[0] + " | " + movesNew[1] + " | " + movesNew[2] + " ");
		System.out.println(" ---+---+---");
		System.out.println("  " + movesNew[3] + " | " + movesNew[4] + " | " + movesNew[5] + " ");
		System.out.println(" ---+---+---");
		System.out.println("  " + movesNew[6] + " | " + movesNew[7] + " | " + movesNew[8] + " ");
		System.out.println("             ");
	}

	public static String evaluateSuccess(String[] movesNew) {

		String winner  = new String(" ");

		if (movesNew[0].equals(new String("A")) && movesNew[1].equals(new String("A"))
				&& movesNew[2].equals(new String("A")))
			winner = "A";
		else if (movesNew[0].equals(new String("B")) && movesNew[1].equals(new String("B"))
				&& movesNew[2].equals(new String("B")))
			winner = "B";
		else if (movesNew[3].equals(new String("A")) && movesNew[4].equals(new String("A"))
				&& movesNew[5].equals(new String("A")))
			winner = "A";
		else if (movesNew[3].equals(new String("B")) && movesNew[4].equals(new String("B"))
				&& movesNew[5].equals(new String("B")))
			winner = "B";
		else if (movesNew[6].equals(new String("A")) && movesNew[7].equals(new String("A"))
				&& movesNew[8].equals(new String("A")))
			winner = "A";
		else if (movesNew[6].equals(new String("B")) && movesNew[7].equals(new String("B"))
				&& movesNew[8].equals(new String("B")))
			winner = "B";
		else if (movesNew[0].equals(new String("A")) && movesNew[3].equals(new String("A"))
				&& movesNew[6].equals(new String("A")))
			winner = "A";
		else if (movesNew[0].equals(new String("B")) && movesNew[3].equals(new String("B"))
				&& movesNew[6].equals(new String("B")))
			winner = "B";
		else if (movesNew[1].equals(new String("A")) && movesNew[4].equals(new String("A"))
				&& movesNew[7].equals(new String("A")))
			winner = "A";
		else if (movesNew[1].equals(new String("B")) && movesNew[4].equals(new String("B"))
				&& movesNew[7].equals(new String("B")))
			winner = "B";
		else if (movesNew[2].equals(new String("A")) && movesNew[5].equals(new String("A"))
				&& movesNew[8].equals(new String("A")))
			winner = "A";
		else if (movesNew[2].equals(new String("B")) && movesNew[5].equals(new String("B"))
				&& movesNew[8].equals(new String("B")))
			winner = "B";
		else if (movesNew[0].equals(new String("A")) && movesNew[4].equals(new String("A"))
				&& movesNew[8].equals(new String("A")))
			winner = "A";
		else if (movesNew[0].equals(new String("B")) && movesNew[4].equals(new String("B"))
				&& movesNew[8].equals(new String("B")))
			winner = "B";
		else if (movesNew[2].equals(new String("A")) && movesNew[4].equals(new String("A"))
				&& movesNew[6].equals(new String("A")))
			winner = "A";
		else if (movesNew[2].equals(new String("B")) && movesNew[4].equals(new String("B"))
				&& movesNew[6].equals(new String("B")))
			winner = "B";

		//if (winner.equals(new String("A")) || winner.equals(new String("B")))
			return winner ;
		//else
		//	return winner;

	}
	
	public static boolean validateNumber(int startInt, int endInt, String b) {
		boolean ret;
		ret = false;
		for(int i =startInt; i <=endInt; i++) {
			//System.out.println(i);
			if(b.equals(String.valueOf(i))) {
				ret = true;
				return ret;
			}
		}
		
		return ret;
	}
	
	
	public static int acceptintegerfromConsole(int startNum, int endNum) {

		boolean e = true;
		String s = new String();
		
		while(e) {
			System.out.println("please enter a number between " +startNum+ " and " +endNum );
			Scanner scan= new Scanner(System.in);
			s= scan.nextLine();
			boolean k;
			k=validateNumber(startNum, endNum,s);
				if (k==false) {
				System.out.println(" it is a wrong number");
			}
				else 
					e=false ; 
		}
		int ret;
		ret= Integer.parseInt(s);
		return ret;
	}
	public static void fillmovearraywithNumbers(String newMove[]) {

		for(int j=1;j<=9;j++) {
			newMove[j-1]= String.valueOf(j);
		}
		
	}
	public static void twoplayerGame() {
		String [] move = new String[9];
		int inputInt;
		String player = new String() ;
		boolean win = false;
		
		fillmovearraywithNumbers(move);
		
		
		printGameBoard(move); 
		for(int i=1; i<=9 ;i++){
					
					if(i%2==0) {
			            player="B";
					}
					else
						player="A";
					
					System.out.println("Player-" + player + ", please play move-" +i );
					
					
					boolean loopFlag = true;
					
					while(loopFlag) {	
						
						inputInt = acceptintegerfromConsole(1, 9);
			
						if ( move[inputInt-1 ].equalsIgnoreCase(new String("A")) || move[inputInt-1 ].equalsIgnoreCase(new String("B")) ) {
						
							System.out.println("entered position already occupied, please enter again");
						}
						else {
							loopFlag=false;
							move[inputInt-1] = player;
							
							printGameBoard(move);
							
							String winner1  = new String("");
							
							winner1 = evaluateSuccess(move);
							
							if (winner1.equals("A") || winner1.equals("B")) {
									System.out.println("Congratgulations, " + winner1 + "is the winner");
									i =100;  //breaking from for
									win=true;
								}		
							}
			
					} //loop for while
							
					
				}//loop for 9 moves
		
		if(win==false)
			System.out.println("match drawn");
	
	}
	
	public static void oneplayerGame() {
		int inputInt = 0;
		String [] move = new String[9];
		String computerPlayer = new String();
		String currentPlayer = new String();
		boolean win = false;
				
		System.out.println("do yu want to play first or second");
		int p= acceptintegerfromConsole(1,2);
		if (  p== 1) 
			computerPlayer="B";
		else
			computerPlayer="A";
		
		System.out.println("computer is playing as player " +computerPlayer);
		
		fillmovearraywithNumbers(move);	
		printGameBoard(move);
		
		for(int i=1;i<9;i++) {
			
			currentPlayer= findoddevenPlayer(i);
			
			boolean loopFlag = true;
			
			while(loopFlag) {	
				if(currentPlayer==computerPlayer) 
					inputInt= generaterandomNumber(move);
				else
					inputInt = acceptintegerfromConsole(1, 9);
				
				if ( move[inputInt-1 ].equalsIgnoreCase(new String("A")) || move[inputInt-1 ].equalsIgnoreCase(new String("B")) ) 
					
					System.out.println("entered position already occupied, please enter again");
				else
					loopFlag = false;
			}
				
			move[inputInt-1] = currentPlayer;
			
			printGameBoard(move);
			
			String winner1  = new String("");
			
			winner1 = evaluateSuccess(move);
			
			if (winner1.equals("A") || winner1.equals("B")) {
					System.out.println("Congratgulations, " + winner1 + " is the winner");
					i =100;  //breaking from for
					win=true;
				}			
			
		}
		if(win==false)
			System.out.println("match drawn");
		
	}
	
	public static String findoddevenPlayer(int moveNumber) {
		String player= new String();
		if(moveNumber%2==0) 
            player="B";
		
		else
			player="A";
		
		System.out.println("Player-" + player + ", please play move-" +moveNumber );
		return player;
		
	}
	
	public static int generaterandomNumber(String[] movesNew1) {
		Random rand= new Random();
		String currentPlayer = new String();
		
		
		int d=0;
		
		d=artificialIntelligence(movesNew1);
		if(d<100){
			//movesNew1[d-1] = currentPlayer;
			return d;
			}
		else if(d==100) {
			int cpuPos = rand.nextInt(9)+1;
			return cpuPos;
			
		}
		return d;
		
		
		
		
	}
	public static int artificialIntelligence(String[] movesNew){
		
		int smartmove=100;

	  	      if (movesNew[0].equals(new String("A")) && movesNew[1].equals(new String("A")) && movesNew[2].equals(new String("3")))
			         smartmove=3;
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[1].equals(new String("B"))&&  movesNew[2].equals(new String("3")))
				  smartmove=3;
	  	      
			else if(movesNew[3].equals(new String("A")) && movesNew[4].equals(new String("A")) && movesNew[5].equals(new String("6")))
				  smartmove=6;
	  	      
			else if ( movesNew[3].equals(new String("B")) && movesNew[4].equals(new String("B"))&& movesNew[5].equals(new String("6")))
				  smartmove=6;	
	  	      
			else if ( movesNew[6].equals(new String("A")) && movesNew[7].equals(new String("A"))&& movesNew[8].equals(new String("9")))
				  smartmove=9;	
	  	      
			else if ( movesNew[6].equals(new String("B")) && movesNew[7].equals(new String("B"))&& movesNew[8].equals(new String("9")))
				  smartmove=9;
	  	      
			else if ( movesNew[1].equals(new String("A")) && movesNew[2].equals(new String("A"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[1].equals(new String("B")) && movesNew[2].equals(new String("B"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[4].equals(new String("A")) && movesNew[5].equals(new String("A"))&& movesNew[3].equals(new String("4")))
				  smartmove=4;
	  	      
			else if ( movesNew[4].equals(new String("B")) && movesNew[5].equals(new String("B"))&& movesNew[3].equals(new String("4")))
				  smartmove=4;	
	  	      
			else if ( movesNew[7].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;	
	  	      
			else if ( movesNew[7].equals(new String("B")) && movesNew[8].equals(new String("B"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;
	  	      
			else if ( movesNew[0].equals(new String("A")) && movesNew[2].equals(new String("A"))&& movesNew[1].equals(new String("2")))
				  smartmove=2;	
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[2].equals(new String("B"))&& movesNew[1].equals(new String("2")))
				  smartmove=2;	
	  	      
			else if ( movesNew[3].equals(new String("A")) && movesNew[5].equals(new String("A"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;	
	  	      
			else if ( movesNew[3].equals(new String("B")) && movesNew[5].equals(new String("B")) &&movesNew[4].equals(new String("5")))
				  smartmove=5;
	  	      
			else if ( movesNew[6].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[7].equals(new String("8")))
				  smartmove=8;
	  	      
			else if ( movesNew[6].equals(new String("B")) && movesNew[8].equals(new String("B"))&& movesNew[7].equals(new String("8")))
				  smartmove=8;
	  	      
			else if ( movesNew[0].equals(new String("A")) && movesNew[3].equals(new String("A"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[3].equals(new String("B"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;	
	  	      
			else if ( movesNew[1].equals(new String("A")) && movesNew[4].equals(new String("A"))&& movesNew[7].equals(new String("8")))
				  smartmove=8;	
	  	      
			else if ( movesNew[1].equals(new String("B")) && movesNew[4].equals(new String("B"))&& movesNew[7].equals(new String("8")))
				  smartmove=8;	
	  	      
			else if ( movesNew[2].equals(new String("A")) && movesNew[5].equals(new String("A"))&& movesNew[8].equals(new String("9")))
				  smartmove=9;	
	  	      
			else if ( movesNew[2].equals(new String("B")) && movesNew[5].equals(new String("B")) &&movesNew[8].equals(new String("9")))
				  smartmove=9;	
	  	      
			else if ( movesNew[3].equals(new String("A")) && movesNew[6].equals(new String("A"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[3].equals(new String("B")) && movesNew[6].equals(new String("B"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[4].equals(new String("A")) && movesNew[7].equals(new String("A"))&& movesNew[1].equals(new String("2")))
				  smartmove=2;	
	  	      
			else if ( movesNew[4].equals(new String("B")) && movesNew[7].equals(new String("B"))&&movesNew[1].equals(new String("2")))
				  smartmove=2;	
	  	      
			else if ( movesNew[5].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[2].equals(new String("3")))
				  smartmove=3;	
	  	      
			else if ( movesNew[5].equals(new String("B")) && movesNew[8].equals(new String("B"))&& movesNew[2].equals(new String("3")))
				  smartmove=3;
	  	      
			else if ( movesNew[0].equals(new String("A")) && movesNew[6].equals(new String("A"))&& movesNew[3].equals(new String("4")))
				  smartmove=4;
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[6].equals(new String("B"))&& movesNew[3].equals(new String("4")))
				  smartmove=4;	
	  	      
			else if ( movesNew[1].equals(new String("A")) && movesNew[7].equals(new String("A"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;	 
	  	      
			else if ( movesNew[1].equals(new String("B")) && movesNew[7].equals(new String("B"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;	
	  	      
			else if ( movesNew[2].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[5].equals(new String("6")))
				  smartmove=6;	 
	  	      
			else if ( movesNew[2].equals(new String("B")) && movesNew[8].equals(new String("B")) &&movesNew[5].equals(new String("6")))
				  smartmove=6;	
	  	      
			else if ( movesNew[2].equals(new String("A")) && movesNew[4].equals(new String("A"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;	
	  	      
			else if ( movesNew[2].equals(new String("B")) && movesNew[4].equals(new String("B"))&& movesNew[6].equals(new String("7")))
				  smartmove=7;
	  	      
			else if ( movesNew[0].equals(new String("A")) && movesNew[4].equals(new String("A"))&& movesNew[8].equals(new String("9")))
				  smartmove=9;
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[4].equals(new String("B"))&& movesNew[8].equals(new String("9")))
				  smartmove=9;
	  	      
			else if ( movesNew[4].equals(new String("A")) && movesNew[6].equals(new String("A")) &&movesNew[2].equals(new String("3")))
				  smartmove=3;	
	  	      
			else if ( movesNew[4].equals(new String("B")) && movesNew[6].equals(new String("B"))&& movesNew[2].equals(new String("3")))
				  smartmove=3;	
	  	      
			else if ( movesNew[4].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[4].equals(new String("B")) && movesNew[8].equals(new String("B"))&& movesNew[0].equals(new String("1")))
				  smartmove=1;	
	  	      
			else if ( movesNew[2].equals(new String("A")) && movesNew[6].equals(new String("A"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;	
	  	      
			else if ( movesNew[2].equals(new String("B")) && movesNew[6].equals(new String("B"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;
	  	      
			else if ( movesNew[0].equals(new String("A")) && movesNew[8].equals(new String("A"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;
	  	      
			else if ( movesNew[0].equals(new String("B")) && movesNew[8].equals(new String("B"))&& movesNew[4].equals(new String("5")))
				  smartmove=5;		
	  	      
	  	      
	  	      return smartmove;
			
			
			
			
			
				
		
	}
	

	

	
	
}// class
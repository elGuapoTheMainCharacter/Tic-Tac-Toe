import java.util.Scanner;
public class Tic {
/*TASKS
 * if a user chooses x,make sure they stick with x
 * 
*/
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("------WELCOME TO GAME LAND---------");
		System.out.println("LET'S PLAY TIK-TAC-TOE!!!!");
		String board[][] = {{"-","-","-"},{"-","-","-"},{"-","-","-"}};
		String guide[][] = {{"A","B","C"},{"D","E","F"},{"G","H","I"}};
		System.out.print("PLayer 1 name: ");
		String firstPLayer = scan.next();
		System.out.print("PLayer 2 name: ");
		String secPLayer = scan.next();
		System.out.println("Here's the guide");
		show(guide);
		System.out.println("///////////////////// \n");
		show(board);
		String place;
		String play;
		String firstUser,secUser;
		int counter = 0;
		String condition = "n";
		System.out.println("Choose,X or O");
		while(condition.equals("n")) {
			System.out.print("------>");
			play = scan.next();
			//tracking user choice
			/*if((counter == 0)&&(play.equals("x"))) {
				firstUser = "x";
				secUser = "o";
			}else if((counter == 0)&&(play.equals("o"))) {
				firstUser = "o";
				secUser = "x";
			}
			if((counter %2 != 0)&&(firstUser !=)) {
				
			}*/
			
			
			System.out.println("Where do you want to play");
			place = scan.next();
			preventChange(board,place);
			if(preventChange(board,place)!="You already played there,remember?") {
				processInput(board,place,play);
			}
			show(board);
			
			//is it solved
			if(horizontal(board)== 1) {
				condition="c";
			}
			else if(vertical(board) == 1) {
				condition = "c";
			}
			else if(diagonal(board)==1) {
				condition = "c";
			}
			else if(draw(board) == 0) {
				condition = "d";
			}
			counter++;
		}
		
		//who won
		if(condition.equals("c") && (counter %2 ==0)&&(counter > 0)) {
			System.out.print(secPLayer +" won!!");
		}
		else if(condition.equals("c") && (counter %2 !=0)&&(counter > 0)){
			System.out.print(firstPLayer +" won!!");
		}
		else if(condition.equals("d")) {
			System.out.print("It's a draw!!!");
		}
		
		

	}
	//LOGIC FUNCTIONS
	static int horizontal(String grid[][]) {
		if((!grid[0][0].equals("-"))&&(grid[0][0].equals(grid[0][1]))&& (grid[0][0].equals(grid[0][2]))) {
			return 1;
		}
		else if((!grid[1][0].equals("-"))&&(grid[1][0].equals(grid[1][1])) && (grid[1][0].equals(grid[1][2])) ) {
			return 1;
		}
		else if((!grid[2][0].equals("-"))&&(grid[2][0].equals(grid[2][1])) && (grid[2][0].equals(grid[2][2])) ) {
			return 1;
		}
		return 0;
	}
	
	static int vertical(String grid[][]) {
		if((!grid[0][0].equals("-"))&&(grid[0][0].equals(grid[1][0]))&& (grid[0][0].equals(grid[2][0])) ) {
			return 1;
		}
		else if((!grid[0][1].equals("-"))&&(grid[0][1].equals(grid[1][1])) && (grid[0][1].equals(grid[2][1])) ) {
			return 1;
		}
		else if((!grid[0][2].equals("-"))&&(grid[0][2].equals(grid[1][2])) && (grid[0][2].equals(grid[2][2]))) {
			return 1;
		}
		return 0;
	}
	static int diagonal(String grid[][]) {
		if((!grid[0][0].equals("-"))&&(grid[0][0].equals(grid[1][1]))&& (grid[0][0].equals(grid[2][2])) ) {
			return 1;
		}
		else if((!grid[0][2].equals("-"))&&(grid[0][2].equals(grid[1][1])) && (grid[0][2].equals(grid[2][0])) ) {
			return 1;
		}
		return 0;
	}
	static int draw(String grid[][]) {
		int cond = 0;
		for(int x = 0;x<3;x++) {
			for(int y = 0;y<3;y++) {
				if(grid[x][y].equals("-")) {
					cond++;
			}
		}	
	}
	if(cond > 0) {
		return 1;
	}
	return 0;
}
	//VIEW
	static void show(String grid[][]) {
		for(int x = 0;x<3;x++) {
			System.out.print("|");
			for(int y = 0;y<3;y++) {
				System.out.print("_"+grid[x][y]+"_|");
			}
			System.out.print("\n");
		}
	}
	static void processInput(String grid[][],String place,String input) {
		if((place.equals("A"))||(place.equals("a"))){
			grid[0][0]=input;
		}
		else if((place.equals("B"))||(place.equals("b"))){
			grid[0][1]=input;
		}
		else if((place.equals("C"))||(place.equals("c"))){
			grid[0][2]=input;
		}
		else if((place.equals("D"))||(place.equals("d"))){
			grid[1][0]=input;
		}
		else if((place.equals("E"))||(place.equals("e"))){
			grid[1][1]=input;
		}
		else if((place.equals("F"))||(place.equals("f"))){
			grid[1][2]=input;
		}
		else if((place.equals("G"))||(place.equals("g"))){
			grid[2][0]=input;
		}
		else if((place.equals("H"))||(place.equals("h"))){
			grid[2][1]=input;
		}
		else if((place.equals("i"))||(place.equals("I"))){
			grid[2][2]=input;
		}
	}
	static String preventChange(String grid[][],String place){
		if((place.equals("A"))||(place.equals("a")) && (!grid[0][0].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("B"))||(place.equals("b"))&& (!grid[0][1].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("C"))||(place.equals("c"))&& (!grid[0][2].equals("-"))){
			System.out.println("You already played there,remember?");
		}
		else if((place.equals("D"))||(place.equals("d"))&& (!grid[1][0].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("E"))||(place.equals("e"))&& (!grid[1][1].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("F"))||(place.equals("f"))&& (!grid[1][2].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("G"))||(place.equals("g"))&& (!grid[2][0].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("H"))||(place.equals("h"))&& (!grid[2][1].equals("-"))){
			System.out.println("You already played there,remember?");
			return "You already played there,remember?";
		}
		else if((place.equals("i"))||(place.equals("I"))&& (!grid[2][2].equals("-"))){
			return "You already played there,remember?";
		}
		return"";
	}
}
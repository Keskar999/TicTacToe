package TicTacToe;

import java.util.Scanner;

class TicTacToe
{
	static char[][]Board;

	public TicTacToe() 
	{
		Board =new char[3][3];
		initBoard();
		
	}
	void initBoard()
	{
		for(int i=0;i<Board.length;i++)
		{
			for(int j=0;j<Board[i].length;j++)
			{
				Board[i][j]=' ';
			}
		}
	}
	static void dispBoard()
	{    
		//Display rows and column
		System.out.println("--------------");
		for(int i=0;i<Board.length;i++)
		{
			System.out.print(" | ");
			for(int j=0;j<Board[i].length;j++)
			{
				System.out.print(Board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("--------------");
		}
	}
	
	static void placeMark(int row,int col,char mark)
	{
		if(row>=0 && row<=2 && col>=0 && col <=2 )
		{
			Board[row][col]= mark;
		}
		else
		{
			System.out.println("invalid position");
		}
	}
	
	static boolean checkcolwin()
	{
		for(int j=0;j<=2;j++)
		{
		if(Board[0][j] != ' ' && Board[0][j]==Board[1][j] && Board[1][j]==Board[2][j])
		  {
			return true;
		  }
	    }
		return false;
	}
	static boolean checkRowWin()
	{
		for(int i=0;i<=2;i++) 
		{
			if( Board[i][0] != ' ' && Board[i][0]==Board[i][1] && Board[i][1]==Board[i][2])
			{
				return true;
			}
		}
		return false;
	}
	static boolean checkDiagWin()
	{
		if(Board[0][0] != ' ' && Board[0][0]==Board[1][1] && Board[1][1]==Board[2][2] || Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0] )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
	  class HumanPlayer
	{
		String name;
		char mark;
		public HumanPlayer(String name, char mark) 
		{
			
			this.name = name;
			this.mark = mark;
		}
		
	
	  void makemove()
	{
		Scanner sc=new Scanner(System.in);
		int row;
		int col;
		
		do 
		{
			System.out.println("Enter the row and col");
			 row=sc.nextInt();
			 col=sc.nextInt();
			
		} while (! isValiodMove( row, col));
		
		TicTacToe.placeMark(row, col, mark);
	}
	
	boolean isValiodMove(int row,int col)
	{
		if(row >=0 && row <=2 && col >=0 && col <=2)
		{
			if(TicTacToe.Board[row][col] == ' ')
			{
				return true;
			}
		}
		return false;
	}
	}
	

public class LaunchGame {
	

	public static void main(String[] args) {
		
		TicTacToe t=new TicTacToe();
		
		//t.dispBoard();
//		t.placeMark(0, 0, 'x');
//		t.placeMark(1, 0, 'x');
//		t.placeMark(2, 0, 'x');
		
		HumanPlayer p1	=new HumanPlayer("bob",'x');
		HumanPlayer p2=new HumanPlayer("abhi",'o');
		
		HumanPlayer cp;
		cp=p1;
		
		
		while(true)
		{
			System.out.println(cp.name + "turn");
			cp.makemove();
			TicTacToe.dispBoard();
			if(TicTacToe.checkcolwin() || TicTacToe.checkRowWin() || TicTacToe.checkDiagWin())
			{
				System.out.println(cp.name + " has won ");
				break;
			}
			else
			{
				if(cp == p1)
				{
					cp = p2;
				}
				else
				{
					cp=p1;
				}
			}
		}
		
		
//		t.dispBoard();
//		System.out.println(t.checkcolwin());
//		System.out.println(t.checkRowWin());
//		System.out.println(t.checkDiagWin());
        
	}

}

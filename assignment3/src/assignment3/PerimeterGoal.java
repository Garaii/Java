package assignment3;

import java.awt.Color;

public class PerimeterGoal extends Goal{

	public PerimeterGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		Color[][] flattenedBoard = board.flatten();
		if(flattenedBoard.length == 1 && flattenedBoard[0].length == 1){
			return 2;
		}
		int score = 0;
		for (int i=0; i < flattenedBoard.length; i++){
			for (int j=0; j < flattenedBoard.length; j++){
				if(flattenedBoard[i][j]==targetGoal){
					if((i == 0 && j == 0) || (i==0 && j== flattenedBoard.length-1) || (i== flattenedBoard.length-1 && j==0)||(i == flattenedBoard.length-1 && j == flattenedBoard.length-1)){
					score += 1;
				}
				if (i == 0 || j == 0 || i == flattenedBoard.length-1 || j == flattenedBoard.length-1){
					score++;
				}
				}
			}

		}

		return score;
	}

	@Override
	public String description() {
		return "Place the highest number of " + GameColors.colorToString(targetGoal) 
		+ " unit cells along the outer perimeter of the board. Corner cell count twice toward the final score!";
	}

}

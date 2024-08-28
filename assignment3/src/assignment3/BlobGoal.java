package assignment3;

import java.awt.Color;

public class BlobGoal extends Goal{

	public BlobGoal(Color c) {
		super(c);
	}

	@Override
	public int score(Block board) {
		Color[][] boarD = board.flatten();
		boolean[][] brd = new boolean[boarD.length][boarD.length];


		int blobScore = undiscoveredBlobSize(0,0,boarD, brd);

		for (int i = 0; i <boarD.length; i++){
			for (int j = 0; j< boarD.length; j++){
				int score = undiscoveredBlobSize(i,j,boarD, brd);
				if (blobScore < score ){
					blobScore= score;

				}
			}
		}

		return blobScore;
	}

	@Override
	public String description() {
		return "Create the largest connected blob of " + GameColors.colorToString(targetGoal) 
		+ " blocks, anywhere within the block";
	}


	public int undiscoveredBlobSize(int i, int j, Color[][] unitCells, boolean[][] visited) {
		/*
		 * ADD YOUR CODE HERE
		 */
		int targetSize = 0;
		if(visited[i][j] || !unitCells[i][j].equals(targetGoal)) {
			return 0;
		}
		if (unitCells[i][j] == targetGoal){
			targetSize++;
		}
		visited[i][j] = true;
		if ( i != 0){
			targetSize += undiscoveredBlobSize(i-1, j, unitCells,visited);
		}
		if(j != 0){targetSize += undiscoveredBlobSize(i, j-1, unitCells,visited);}

		if(i!=  unitCells.length-1){targetSize += undiscoveredBlobSize(i+1, j, unitCells,visited);}

		if(j != unitCells.length-1){targetSize += undiscoveredBlobSize(i, j+1, unitCells,visited);}
		return targetSize;

	}

}

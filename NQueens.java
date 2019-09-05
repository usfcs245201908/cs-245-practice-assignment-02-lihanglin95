
public class NQueens {
	int size;
	private int[][] boards;
	
	public NQueens(int size2) {
		this.size=size2;
		boards = new int[size][size];
	}

	public boolean placeNQueens() throws Exception {
		if(size<=0) 
			 throw new Exception();
		if(!placeNQueens(0,boards)) {
		System.out.printf("There is no solution for placing %d Queens on %d*%d chessboard.\n",size,size,size);
		return false;
		}
		return true;
	}

	boolean placeNQueens(int col,int[][] board) {
		if(col==size) {
			printToConsole(board);
			return true;
		}
		for(int row = 0; row<size;row++) {
			if(!isAttacked(row,col,board)) {
				board[row][col]=1;
			if(placeNQueens(col+1,board))
				return true;
			board[row][col]=0;
			}
		}
		return false;
	}

	boolean isAttacked(int row, int col, int[][] board) {
		int i, j; 
        for (i = 0; i < col; i++) 
            if (board[row][i] == 1) 
                return true; 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (board[i][j] == 1) 
                return true; 
        for (i = row, j = col; j >= 0 && i < size; i++, j--) 
            if (board[i][j] == 1) 
                return true; 
		return false;
	}
	
	void printToConsole(int[][] board) {
		for (int i = 0; i < size; i++) { 
            for (int j = 0; j < size; j++) 
                System.out.print(" " + board[i][j] + " "); 
            System.out.println(); 
		}
	}


}

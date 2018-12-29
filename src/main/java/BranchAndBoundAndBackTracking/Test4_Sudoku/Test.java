package BranchAndBoundAndBackTracking.Test4_Sudoku;

public class Test {
    public static void main(String[] args) {
        int[][] a = new int[9][9];
        a[0]= new int[]{0,1,2,8,0,0,0,0,5};
        a[1]= new int[]{0,0,9,0,0,0,0,1,0};
        a[2]= new int[]{0,7,4,0,0,0,0,0,0};
        a[3]= new int[]{0,4,0,0,2,0,0,0,0};
        a[4]= new int[]{0,0,6,0,0,0,0,7,0};
        a[5]= new int[]{0,3,0,0,0,0,0,0,0};
        a[6]= new int[]{0,2,0,0,3,0,7,0,0};
        a[7]= new int[]{0,0,0,0,9,0,0,4,0};
        a[8]= new int[]{7,0,0,0,4,0,0,0,8};



        SudokuDiagram sudokuDiagram = new SudokuDiagram(a,-1,0);
        Sudoku sudoku = new Sudoku();
        sudoku.originNode = sudokuDiagram;

        sudoku.createTree(sudoku.originNode);
        sudoku.speak();


    }
}

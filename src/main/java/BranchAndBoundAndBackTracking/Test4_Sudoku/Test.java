package BranchAndBoundAndBackTracking.Test4_Sudoku;

public class Test {
    public static void main(String[] args) {
        int[][] a = new int[9][9];
        a[0]= new int[]{1,7,0,0,9,0,0,0,0};
        a[1]= new int[]{8,0,0,0,1,0,0,0,6};
        a[2]= new int[]{0,0,3,0,0,0,0,9,0};
        a[3]= new int[]{6,0,0,0,0,2,9,0,8};
        a[4]= new int[]{7,0,0,3,0,8,0,0,2};
        a[5]= new int[]{4,0,8,7,0,0,0,0,3};
        a[6]= new int[]{0,4,0,0,3,0,8,0,0};
        a[7]= new int[]{5,0,0,0,2,0,0,0,9};
        a[8]= new int[]{0,0,0,0,8,0,0,1,4};



        SudokuDiagram sudokuDiagram = new SudokuDiagram(a);
        Sudoku sudoku = new Sudoku();
        sudoku.originNode = sudokuDiagram;

        sudoku.createTree(sudoku.originNode);
        sudoku.speak();


    }
}

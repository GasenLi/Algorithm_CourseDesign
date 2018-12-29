package BranchAndBoundAndBackTracking.Test4_Sudoku;

import java.util.LinkedList;

import static BranchAndBoundAndBackTracking.Test4_Sudoku.SudokuDiagram.judgeIsRepeat;

public class Sudoku {
    SudokuDiagram originNode = new SudokuDiagram();
    LinkedList<SudokuDiagram> results = new LinkedList<>();


    public void createTree(SudokuDiagram sudokuDiagram){
        int[][] diagram = sudokuDiagram.sudokuDiagram;

        int[][] sonDiagram;
        int line = sudokuDiagram.line;
        SudokuDiagram sonsudokuDiagram;
        for(int i=line; i<diagram.length; i++){
            boolean iJudge = true;
            for(int j=0; j<diagram[i].length; j++){
                if(diagram[i][j] == 0){
                    for(int n=1; n<=9; n++){
                        sonDiagram = copyArray(diagram);
                        sonDiagram[i][j] = n;

                        if(judgeIsRepeat(sonDiagram , i , j)){
                            sonsudokuDiagram = new SudokuDiagram(sonDiagram, sudokuDiagram.generation, line);
                            if(judgeIsFull(sonDiagram, i)){
                                sonsudokuDiagram.line++;
                            }

                            if(sonsudokuDiagram.generation == 81){
                                results.add(sonsudokuDiagram);
                            }

                            sudokuDiagram.addSudokuDiagram(sonsudokuDiagram);
                            createTree(sonsudokuDiagram);
                        }
                    }

                    iJudge = false;
                    break;
                }
            }

            if(!iJudge){
                break;
            }
        }
    }



    public boolean judgeIsFull(int[][] nums, int line){
        for(int j=0; j<nums.length; j++){
            if(nums[line][j] == 0){
                return false;
            }
        }

        return true;
    }

    public int[][] copyArray(int[][] previous){
        int[][] targetArray = new int[previous.length][previous[0].length];

        for(int i=0; i<previous.length; i++){
            targetArray[i] = previous[i].clone();
        }

        return targetArray;
    }

    public void speakOriginNode(){
        System.out.println("-------原数独-------");
        int[][] diagram = this.originNode.sudokuDiagram;
        for(int i=0; i<diagram.length; i++){
            for(int j=0; j<diagram[i].length; j++){
                System.out.print(diagram[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");

    }

    public void speak(){
        speakOriginNode();

        int[][] diagram;

        if(results.size() == 0){
            System.out.println("无解！");
        }else {
            for(SudokuDiagram sudokuDiagram : results){
                diagram = sudokuDiagram.sudokuDiagram;

                for(int i=0; i<diagram.length; i++){
                    for(int j=0; j<diagram[i].length; j++){
                        System.out.print(diagram[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("-------------------");
            }
        }


    }


}

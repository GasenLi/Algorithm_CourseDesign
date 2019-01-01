package BranchAndBoundAndBackTracking.Test4_Sudoku;

import java.util.LinkedList;

public class SudokuDiagram {
     int[][] sudokuDiagram;
     LinkedList<SudokuDiagram> nexts = new LinkedList<>();
     int generation;
     int line;

    public SudokuDiagram(int[][] sudokuDiagram, int generation, int line){
        this.sudokuDiagram = sudokuDiagram;
        this.generation = ++generation;
        this.line = line;
    }

    public SudokuDiagram(int[][] sudokuDiagram){
        this.sudokuDiagram = sudokuDiagram;

        generation = getOriginGeneration(this.sudokuDiagram);
        line = 0;
    }

    //初始化数独图
    public void initialDiagram(int[][] sudokuDiagram){
        for(int i=0; i<sudokuDiagram.length; i++){
            for(int j=0; j<sudokuDiagram[i].length; j++){
                if(Math.random()<=0.6){
                    boolean judge = false;

                    int count = 0;
                    while (!judge){
                        for(int n=1; n<9; n++){
                            sudokuDiagram[i][j] = n;
                            judge = judgeIsRepeat(sudokuDiagram, i ,j);

                            if (judge){
                                break;
                            }
                        }

                        if(!judge){
                            sudokuDiagram[i][j] = 0;
                        }

                        count ++;
                        if(count == 2){
                            break;
                        }
//

                    }

                }else {
                    sudokuDiagram[i][j] = 0;
                }
            }
        }
    }


    public static boolean judgeIsRepeat(int[][] sudokuDiagram, int x, int y){
        for(int i=0; i<sudokuDiagram.length; i++){
            if(i == x){
                continue;
            }

            if(sudokuDiagram[i][y] == sudokuDiagram[x][y]){
                return false;
            }
        }

        for(int j=0; j<sudokuDiagram.length; j++){
            if(j == y){
                continue;
            }

            if(sudokuDiagram[x][j] == sudokuDiagram[x][y]){
                return false;
            }
        }



        int a = (x/3)*3, b =(y/3)*3;
        for(int startx = a;startx<a+3; startx++){
            for( int starty = b;starty<b+3; starty++){
                if(startx == x && starty == y){
                    continue;
                }

                if(sudokuDiagram[startx][starty] == sudokuDiagram[x][y]){
                    return false;
                }
            }
        }


        return true;
    }


    //加节点
    public void addSudokuDiagram(SudokuDiagram diagram){
        this.nexts.add(diagram);
    }


    public int getOriginGeneration(int[][] sudokuDiagram){
        int generation = 0;

        for(int i=0; i<sudokuDiagram.length; i++){
            for(int j=0; j<sudokuDiagram[i].length; j++){
                if(sudokuDiagram[i][j] !=0 ){
                    generation++;
                }
            }
        }

        return generation;
    }

}

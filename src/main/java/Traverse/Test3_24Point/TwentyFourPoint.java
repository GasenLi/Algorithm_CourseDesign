package Traverse.Test3_24Point;

import java.util.Stack;

import static Traverse.Test3_24Point.EvaluateExpression.evaluateExpression;

public class TwentyFourPoint {

    public static void twentyFourPoint(int a, int b, int c, int d) {

        arrangeNumbers(a, b, c, d);
    }



    //排列数字 每个位置四种情况 一共64种
    public static void arrangeNumbers(int a, int b, int c, int d) {

        createSymbol(new int[]{a,b,c,d});
        createSymbol(new int[]{a,c,d,b});
        createSymbol(new int[]{a,d,b,c});
        createSymbol(new int[]{b,a,d,c});
        createSymbol(new int[]{b,c,a,d});
        createSymbol(new int[]{b,d,c,a});
        createSymbol(new int[]{c,a,b,d});
        createSymbol(new int[]{c,b,d,a});
        createSymbol(new int[]{c,d,a,b});
        createSymbol(new int[]{d,a,c,b});
        createSymbol(new int[]{d,b,a,c});
        createSymbol(new int[]{d,c,b,a});

    }

    public static void createSymbol(int[] nums) {
        Stack<Character> symbols = new Stack<>();
        symbols.push('+');
        symbols.push('-');
        symbols.push('*');
        symbols.push('/');

        Stack<Character> stack1 = (Stack<Character>) symbols.clone();
        Stack<Character> stack2 = (Stack<Character>) symbols.clone();
        Stack<Character> stack3 = (Stack<Character>) symbols.clone();

        while (!stack1.empty()) {
            while (!stack2.empty()) {
                while (!stack3.empty()) {
                    addBrackets(nums, new char[]{stack1.peek(), stack2.peek(), stack3.pop()});
                }

                stack2.pop();
                stack3 = (Stack<Character>) symbols.clone();
            }

            stack1.pop();
            stack2 = (Stack<Character>) symbols.clone();
        }
    }

    public static void addBrackets(int[] nums, char[] symbols) {
        calculate("(" + nums[0] + symbols[0] + nums[1] +  ")" + symbols[1] +  "(" + nums[2]  + symbols[2] + nums[3] + ")");
        calculate("((" + nums[0] + symbols[0] + nums[1] + ")" + symbols[1] +   nums[2] + ")" + symbols[2] + nums[3] );
        calculate("(" + nums[0] + symbols[0] + "(" + nums[1]  + symbols[1] + nums[2] + "))"  + symbols[2] + nums[3] );
    }


    public static void calculate(String formula){
        if(evaluateExpression(formula) == 24){
            System.out.println(formula);
        }
    }



}

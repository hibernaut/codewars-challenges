package com.hibernaut.katas;

/**
 * A bookseller has lots of books classified in 26categories labeled A,B,...Z.
 * Each book has a code c of 3,4,5or more characters.
 * The 1st character of a code is a capital letter which defines the book category.
 * <p>
 * In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0)
 * which indicates the quantity of books of this code in stock.
 * <p>
 * For example an extract of a stocklist could be:
 * <p>
 * L={"ABART 20","CDXEF 50","BKWRK 25","BTSQZ 89","DRTYM 60"}.
 * <p>
 * You will be given a stocklist(e.g.:L)and a list of categories in capital letters e.g:
 * <p>
 * M={"A","B","C","W"}
 * <p>
 * and your task is to find all the books of L with codes belonging to each category of M and to sum
 * their quantity according to each category.
 * <p>
 * For the lists L and M of example you have to return the string(in Haskell/Clojure/Racket a list of pairs):
 * <p>
 * (A:20)-(B:114)-(C:50)-(W:0)
 * <p>
 * where A,B,C,W are the categories,20is the sum of the unique book of category A,
 * 114the sum corresponding to"BKWRK"and"BTSQZ",50corresponding to"CDXEF"and 0to category'W'
 * since there are no code beginning with W.
 * <p>
 * If L or M are empty return string is""(Clojure and Racket should return an empty array/list instead).
 * Note:
 * <p>
 * In the result codes and their values are in the same order as in M.
 */

public class StockList {
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        //Creating output variable and a counter;
        String outputResult = "";
        int count = 0;
        int len = lstOf1stLetter.length;
        String[] splitArray = new String[2];

        //If some of arrays are empty, returning empty string
        if(lstOf1stLetter.length == 0 || lstOfArt.length == 0) {
            return outputResult;
        }

        //Counting books by category
        for (int i = 0; i < len; i++) {
            for (String a:lstOfArt) {
                if(a.startsWith(lstOf1stLetter[i])) {
                    splitArray = a.split(" ");
                    count += Integer.parseInt(splitArray[1]);
                }
            }
            lstOf1stLetter[i] = "(" + lstOf1stLetter[i] + " : " + count + ")";
            count = 0;
        }

        //Creating output value
        for (int i = 0; i < len; i++) {
            if (i != len - 1) {
                outputResult += (lstOf1stLetter[i] + " - ");
            } else {
                outputResult += (lstOf1stLetter[i]);
            }
        }

        return outputResult;
    }
}

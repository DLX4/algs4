package algs4.db;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Db {

    public static void main(String[] args) {
        while (true) {
            printPrompt();

            String input = StdIn.readLine();
            if (input.equals(".exit")) {
                return;
            } else {
                StdOut.println("Unrecognized command \'"  + input + "\'.");
            }
        }
    }

    public static void printPrompt() {
        StdOut.print("db > ");
    }
}

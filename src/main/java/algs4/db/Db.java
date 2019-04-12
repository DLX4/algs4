package algs4.db;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Db {

    public static void main(String[] args) {
        while (true) {
            printPrompt();

            String input = StdIn.readLine();
            if (input.charAt(0) == '.') {
                switch (doMetaCommand(input)) {
                    case (MetaCommandResult.META_COMMAND_SUCCESS):
                        continue;
                    case (MetaCommandResult.META_COMMAND_UNRECOGNIZED_COMMAND):
                        StdOut.println("Unrecognized command \'"  + input + "\'.");
                        continue;
                }
            }

            // 解析
            PrepareResult prepareResult = prepareStatement(input);
            switch (prepareResult.status) {
                case (PrepareResultStatus.PREPARE_SUCCESS):
                    break;
                case (PrepareResultStatus.PREPARE_UNRECOGNIZED_STATEMENT):
                    StdOut.println("Unrecognized keyword at start of \'"  + input + "\'.");
                    continue;
            }

            // 执行
            executeStatement(prepareResult.statement);
            StdOut.println("Executed.");

        }
    }

    public static void printPrompt() {
        StdOut.print("db > ");
    }

    public interface MetaCommandResult {
        String META_COMMAND_SUCCESS = "META_COMMAND_SUCCESS";
        String META_COMMAND_UNRECOGNIZED_COMMAND = "META_COMMAND_UNRECOGNIZED_COMMAND";
    }

    public interface Statement {
        String STATEMENT_INSERT = "STATEMENT_INSERT";
        String STATEMENT_SELECT = "STATEMENT_SELECT";
    }

    public interface PrepareResultStatus {
        String PREPARE_SUCCESS = "PREPARE_SUCCESS";
        String PREPARE_UNRECOGNIZED_STATEMENT = "PREPARE_UNRECOGNIZED_STATEMENT";
    }

    public static String doMetaCommand(String input) {
        if (".exit".equalsIgnoreCase(input)) {
            System.exit(0);
            return "";
        } else {
            return MetaCommandResult.META_COMMAND_UNRECOGNIZED_COMMAND;
        }
    }

    private static class PrepareResult {
        String status = PrepareResultStatus.PREPARE_UNRECOGNIZED_STATEMENT;
        String statement = "";
    }

    public static PrepareResult prepareStatement(String input) {
        String prefix = input.substring(0, 6);

        PrepareResult result = new PrepareResult();
        if ("insert".equalsIgnoreCase(prefix)) {
            result.status = PrepareResultStatus.PREPARE_SUCCESS;
            result.statement = Statement.STATEMENT_INSERT;
        }

        if ("select".equalsIgnoreCase(prefix)) {
            result.status = PrepareResultStatus.PREPARE_SUCCESS;
            result.statement = Statement.STATEMENT_SELECT;
        }

        return result;
    }

    public static void executeStatement(String statement) {
        switch (statement) {
            case (Statement.STATEMENT_INSERT):
                StdOut.println("This is where we would do an insert.");
                break;
            case (Statement.STATEMENT_SELECT):
                StdOut.println("This is where we would do an select.");
                break;
        }
    }

}

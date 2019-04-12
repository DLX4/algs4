package algs4.db;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Scanner;

import static algs4.db.ExecuteResult.EXECUTE_SUCCESS;
import static algs4.db.StatementType.*;

public class Db {

    public static void main(String[] args) {

        Table table = new Table();

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
            executeStatement(prepareResult.statement, table);
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



    public static PrepareResult prepareStatement(String input) {
        String prefix = input.substring(0, 6);

        PrepareResult result = new PrepareResult();
        if ("insert".equalsIgnoreCase(prefix)) {
            In in = new In(new Scanner(input.substring(6)));
            String[] args = in.readAllStrings();
            if (args.length < 3) {
                result.status = PrepareResultStatus.PREPARE_SUCCESS;
            } else {
                Statement statement = new Statement();
                Row rowToInsert = new Row();
                rowToInsert.id = Integer.parseInt(args[0]);
                rowToInsert.username = args[1];
                rowToInsert.email = args[2];
                statement.rowToInsert = rowToInsert;
                statement.type = INSERT;

                result.status = PrepareResultStatus.PREPARE_SUCCESS;
                result.statement = statement;
            }
        }

        if ("select".equalsIgnoreCase(prefix)) {
            Statement statement = new Statement();
            statement.type = SELECT;
            result.status = PrepareResultStatus.PREPARE_SUCCESS;
            result.statement = statement;
        }

        return result;
    }

    public static ExecuteResult executeStatement(Statement statement, Table table) {
        switch (statement.type) {
            case INSERT:
                return executeInsert(statement, table);
            case SELECT:
                return executeSelect(statement, table);
        }
        return null;
    }

    private static ExecuteResult executeInsert(Statement statement, Table table) {
        table.insertRow(statement.rowToInsert);

        return EXECUTE_SUCCESS;
    }

    private static ExecuteResult executeSelect(Statement statement, Table table) {

        return EXECUTE_SUCCESS;
    }

}

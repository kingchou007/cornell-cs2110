package a3;
import java.io.*;
import java.util.Scanner;

public class Main {
    /**
     * Replace "-1" by the time you spent on A3 in hours.
     * Example: for 3 hours 15 minutes, use 3.25
     * Example: for 4 hours 30 minutes, use 4.50
     * Example: for 5 hours, use 5 or 5.0
     */
    public static double timeSpent = 10.0;

    /* TODO 6
     * Write a function that takes in a csv file name as a string and returns a Linked List
     * representation of the CSV table.
     */
    public static LList<LList<String>> csvToList(String filepath) {

        // create a list of lists
        LList<LList<String>> list = new SLinkedList<>();
        LList<String> itemList = new SLinkedList<>();

        try {
            Reader in = new FileReader(filepath);
            BufferedReader br = new BufferedReader(in);
            String line;
            // read csv file
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                for(int i = 0; i < record.length; i++){
                    itemList.append(record[i]);

                }
                list.append(itemList);
                itemList = new SLinkedList<>();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         return list;
    }


    /* TODO 7
     * Write a function that takes in two lists representing tables and
     * computes their left join.
     */
    public static LList<LList<String>> join(LList<LList<String>> table1,
                                            LList<LList<String>> table2) {
        //TODO
        for (int i = 0; i < table1.size(); i++){
            for (int j = 0; j < table2.size(); j++){
                if (table1.get(i).get(0).equals(table2.get(j).get(0))){
                    String[] temp = new String[table2.get(j).size()];
                    for (int x = 1; x < table2.get(j).size(); x++){
                        temp[x] = table2.get(j).get(x);
                        table1.get(i).append(temp[x]);
                    }
                }
            }
        }

        for (LList<String> t : table1) {
            System.out.println(t);
        }

        return table1;
    }

    /** Effect: Print a usage message to standard error. */
    public static void usage() {
        System.err.println("Usage: a3.Main <file1.csv> <file2.csv>");
    }

    /* TODO 8
     * Write the main method, which parses the command line arguments, reads CSV files
     * into tables, and prints out the resulting table resulting from a left join of the
     * input tables. Hint: use helper methods.
     */

    public static void main(String[] args) throws FileNotFoundException{
        // join(csvToList("car1.csv"), csvToList("car2.csv"));
        System.out.println(csvToList("states1.csv"));
    }


}

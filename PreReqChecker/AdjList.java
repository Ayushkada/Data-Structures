package prereqchecker;

import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

        StdIn.setFile(args[0]);
        
        HashMap<String, ArrayList<String>> adjMap = new HashMap<String, ArrayList<String>>();
        
        int numCourses = StdIn.readInt();
        for (int i=0; i<numCourses; i++) adjMap.put(StdIn.readString(), new ArrayList<String>());
        
        int numprereqs = StdIn.readInt();
        for (int i=0; i<numprereqs; i++) adjMap.get(StdIn.readString()).add(StdIn.readString());
        
        StdOut.setFile(args[1]);
        for (String ite: adjMap.keySet()){
            StdOut.print(ite);
            for (String pre:adjMap.get(ite)) StdOut.print(" " + pre);
            StdOut.println();
        }
    }
}

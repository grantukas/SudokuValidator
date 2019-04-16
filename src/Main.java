import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) {
		//List of lists to contain puzzle organized by rows
		ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
		
		try {			
			//Open puzzle file, can change text file below to open different files
			File sudoku = new File("test1.txt");			
			
			BufferedReader puzzleReader = new BufferedReader(new FileReader(sudoku));
			
			String readLine = null;
			while((readLine = puzzleReader.readLine()) != null) {
				//Remove trailing commas
				readLine = readLine.replaceAll(",$", "");
				//Split on commas
				String[] elems = readLine.split(",");				
				//Convert to list
				List<String> listConvert = Arrays.asList(elems);
				//Convert to ArrayList
				ArrayList<String> readLineConvert = new ArrayList<String>(listConvert);
				puzzle.add(readLineConvert);
			}	
			puzzleReader.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		RowCheck rowCheck = new RowCheck(puzzle);
		Thread rowCheckThread = new Thread(rowCheck);
		rowCheckThread.start();
		
		ColumnCheck columnCheck = new ColumnCheck(puzzle);
		Thread columnCheckThread = new Thread(columnCheck);
		columnCheckThread.start();
		
		SquareCheck squareCheck = new SquareCheck(puzzle);
		Thread squareCheckThread = new Thread(squareCheck);
		squareCheckThread.start();
		
		ArrayList<ArrayList<String>> rowResults = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> columnResults = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> squareResults = new ArrayList<ArrayList<String>>();
		
		try {
            rowCheckThread.join();
            columnCheckThread.join();
            squareCheckThread.join();
            
            rowResults = rowCheck.getResults();
    		columnResults = columnCheck.getResults();
    		squareResults = squareCheck.getResults();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
		//Process results
		if(rowResults.isEmpty() && columnResults.isEmpty() && squareResults.isEmpty()) {
			System.out.println("No errors in puzzle!");
		}
		else {
			for(int i = 0; i < rowResults.size(); i++) {
				if(rowResults.get(i).get(1).equals(columnResults.get(i).get(1)) && rowResults.get(i).get(1).equals(squareResults.get(i).get(1))) {
					String row = rowResults.get(i).get(0);
					String column = columnResults.get(i).get(0);
					String square = squareResults.get(i).get(0);
					System.out.println("Row " + row + ", column " + column + ", square " + square);
					System.out.println("Replace value with " + rowResults.get(i).get(1) + "\n");
				}
			}
		}
	}
}

import java.util.ArrayList;

public class ColumnCheck implements Runnable {
	private ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> columns = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	
	public ColumnCheck(ArrayList<ArrayList<String>> puzzle) {
		this.puzzle = puzzle;
	}
	
	public ArrayList<ArrayList<String>> getResults() {
		return results;
	}
	
	public void run() {		
		//Convert rows to columns to work with
		for(int i = 0; i < 9; i++) {
			ArrayList<String> columnTemp = new ArrayList<String>();
			for(int j = 0; j < 9; j++) {
				columnTemp.add(puzzle.get(j).get(i));
			}
			columns.add(columnTemp);
		}
		
		for(int i = 0; i < 9; i++) {
			ArrayList<String> column = new ArrayList<String>();
			column = columns.get(i);
			
			//Search through column to find missing value
			for(int j = 0; j < 9; j++) {
				int num = j+1;
				String numToCheck = Integer.toString(num);
				
				if(!column.contains(numToCheck)) {
					ArrayList<String> error = new ArrayList<String>();
					error.add(Integer.toString(i+1));
					error.add(numToCheck);
					results.add(error);
				}
			}
		}
	}
}

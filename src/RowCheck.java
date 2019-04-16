import java.util.ArrayList;

public class RowCheck implements Runnable{
	private ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	
	public RowCheck(ArrayList<ArrayList<String>> puzzle) {
		this.puzzle = puzzle;
	}
	
	public ArrayList<ArrayList<String>> getResults() {
		return results;
	}
	
	public void run() {
		for(int i = 0; i < 9; i++) {
			ArrayList<String> row = new ArrayList<String>();
			row = puzzle.get(i);
			
			//Search through row to find missing value
			for(int j = 0; j < 9; j++) {				
				int num = j+1;
				String numToCheck = Integer.toString(num);
				
				if(!row.contains(numToCheck)) {
					ArrayList<String> error = new ArrayList<String>();
					error.add(Integer.toString(i+1));
					error.add(numToCheck);
					results.add(error);
				}
			}
		}
	}
}

import java.util.ArrayList;

public class SquareCheck implements Runnable{
	private ArrayList<ArrayList<String>> puzzle = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> squares = new ArrayList<ArrayList<String>>();
	private ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	
	public SquareCheck(ArrayList<ArrayList<String>> puzzle) {
		this.puzzle = puzzle;
	}
	
	public ArrayList<ArrayList<String>> getResults() {
		return results;
	}
	
	public void run() {
		//Convert rows to squares to work with
		ArrayList<String> square1 = new ArrayList<String>();
		ArrayList<String> square2 = new ArrayList<String>();
		ArrayList<String> square3 = new ArrayList<String>();
		ArrayList<String> square4 = new ArrayList<String>();
		ArrayList<String> square5 = new ArrayList<String>();
		ArrayList<String> square6 = new ArrayList<String>();
		ArrayList<String> square7 = new ArrayList<String>();
		ArrayList<String> square8 = new ArrayList<String>();
		ArrayList<String> square9 = new ArrayList<String>();
		
		for(int i = 0; i < 3; i++) {		
			for(int j = 0; j < 3; j++) {
				square1.add(puzzle.get(i).get(j));
			}
			for(int k = 3; k < 6; k++) {
				square2.add(puzzle.get(i).get(k));
			}
			for(int q = 6; q < 9; q++) {
				square3.add(puzzle.get(i).get(q));
			}
		}
		for(int j = 3; j < 6; j++) {
			for(int k = 0; k < 3; k++) {
				square4.add(puzzle.get(j).get(k));
			}
			for(int q = 3; q < 6; q++) {
				square5.add(puzzle.get(j).get(q));
			}
			for(int t = 6; t < 9; t++) {
				square6.add(puzzle.get(j).get(t));
			}
		}
		for(int i = 6; i < 9; i++) {		
			for(int j = 0; j < 3; j++) {
				square7.add(puzzle.get(i).get(j));
			}
			for(int k = 3; k < 6; k++) {
				square8.add(puzzle.get(i).get(k));
			}
			for(int q = 6; q < 9; q++) {
				square9.add(puzzle.get(i).get(q));
			}
		}
		squares.add(square1);
		squares.add(square2);
		squares.add(square3);
		squares.add(square4);
		squares.add(square5);
		squares.add(square6);
		squares.add(square7);
		squares.add(square8);
		squares.add(square9);
			
		for(int i = 0; i < 9; i++) {
			ArrayList<String> square = new ArrayList<String>();
			square = squares.get(i);
			
			//Search through square to find missing value
			for(int j = 0; j < 9; j++) {
				int num = j+1;
				String numToCheck = Integer.toString(num);
				
				if(!square.contains(numToCheck)) {
					ArrayList<String> error = new ArrayList<String>();
					error.add(Integer.toString(i+1));
					error.add(numToCheck);
					results.add(error);
				}
			}
		}
	}
}

package wordsearch;

public class Main {

    static int rows = 100;
    static int columns = 100;
	
	public static void main(String[] args) {
	    WordFind ws = new WordFind("some file name", rows, columns);
	    ws.printGrid();
	}

}

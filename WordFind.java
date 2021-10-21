package wordsearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class WordFind {
  
  String word;
  char[][] grid;
  int successCount;
  int size = -1;
  int log10 = 0;
  Random rn;
  //private BufferedReader puzzleStream;
  //private BufferedReader wordStream;
  //private BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
  
  
  public WordFind(String filename) /*throws IOException*/ {
    //rn = new Random();
	  try { 
		  readFile(filename);
	  } catch (IOException e) {
		  e.printStackTrace();
	  }
    
    while (successCount == 0) {
    	//puzzleStream = openFile( "cashiers.txt");
    	//wordStream = openFile ("cashwords.txt");
    	//System.out.println( "Reading Files...");
      generations++;
      solvePuzzle();
    }
    
    

  }
  /*---------------------------------------------------------------------------------*/
  //Fills grid with characters from cashiers.txt  
  public void readFile(String filename) throws IOException {
	  InputStream stream = ClassLoader.getSystemResourceAsStream(filename);
	  BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
	  
	  String line;
	  int row = 0;
	  
	  while ((line = buffer.readLine()) != null) {
		  String[] vals = line.trim().split("-" + "|");
		  
		  if (char == null) {
			  size = vals.length;
			  char = new int[size][size];
			  log10 = (int) Math.floor(Math.log10(size*size)) + 1;
			  word = String.format("%%%dd", log10);
		  }
	  }
  }
  /*---------------------------------------------------------------------------------*/
  //Checks puzzle for word
  void solvePuzzle() {
    successCount = 0;
    
  //Horizontal check left to right   
    for (int yCord=0; yCord<y; yCord++) {
      String word = "";
      for (int xCord=0; xCord<x; xCord++) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            //System.out.println("Success LR - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }    
  //Horizontal check right to left   
    for (int yCord=0; yCord<y; yCord++) {
      String word = "";
      for (int xCord=x-1; xCord>=0; xCord--) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            //System.out.println("Success RL - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }   
  //Vertical check top to bottom    
    for (int xCord=0; xCord<x; xCord++) {
      String word = "";
      for (int yCord=0; yCord<y; yCord++) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            //System.out.println("Success TB - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }    
  //Vertical check bottom to top    
    for (int xCord=0; xCord<x; xCord++) {
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        word += grid[yCord][xCord];
        if (charMatch(word)) {
          if (word.length() == keyword.length()) {
            successCount++;
            //System.out.println("Success BT - (" + xCord + ", " + yCord + ")");
            word = "";
          }
        } else {
          word = "";
        } 
      }
    }    
  //Diagonal Check top/left & bottom/right   
    for (int yCord=0; yCord<y; yCord++) {
      int tempY = yCord;
      String word = "";
      for (int xCord=0; xCord<x; xCord++) {
        if(tempY != y){
          word += grid[tempY][xCord];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              //System.out.println("Success TL BR - (" + xCord + ", " + tempY + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempY++;
        } 
      }
    }    
  //Diagonal Check top/right & bottom/left    
    for (int yCord=0; yCord<y; yCord++) {
      int tempY = yCord;
      String word = "";
      for (int xCord=x-1; xCord>=0; xCord--) {
        if(tempY != y){
          word += grid[tempY][xCord];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              //System.out.println("Success TR BL - (" + xCord + ", " + tempY + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempY++;
        } 
      }
    }    
  //Diagonal Check bottom/left & top/right    
    for (int xCord=0; xCord<x; xCord++) {
      int tempX = xCord;
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        if(tempX != x){
          word += grid[yCord][tempX];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              //System.out.println("Success BL TR - (" + tempX + ", " + yCord + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempX++;
        } 
      }
    }  
  //Diagonal Check bottom/right & top/left   
    for (int xCord=x-1; xCord>=0; xCord--) {
      int tempX = xCord;
      String word = "";
      for (int yCord=y-1; yCord>=0; yCord--) {
        if(tempX != 0){
          word += grid[yCord][tempX];
          if (charMatch(word)) {
            if (word.length() == keyword.length()) {
              successCount++;
              //System.out.println("Success BR TL - (" + tempX + ", " + yCord + ")");
              word = "";
            }
          } else {
            word = "";
          } 
          tempX--;
        } 
      }
    }

    
  }
  /*---------------------------------------------------------------------------------*/
  //Checks if a match has been found  
  boolean charMatch(String word) {
    for (int i=0; i<word.length(); i++) {
      if (word.charAt(i) != keyword.charAt(i)) {
        return false;
      }  
    } return true;
  }
  /*---------------------------------------------------------------------------------*/
  //Prints puzzle for TESTING small grids
  void printGrid() {
    System.out.println("===================");
    for (int yCord=0; yCord<y; yCord++) {
      for (int xCord=0; xCord<x; xCord++) {
        System.out.print(grid[yCord][xCord] + "  ");
      }
      System.out.println("\n      ");
    }
  }
  /*---------------------------------------------------------------------------------*/
  //Generates random letters for the TEST puzzle
  char randomLetter() {
    int number = rn.nextInt(keyword.length());
    return keyword.charAt(number);
  }
}


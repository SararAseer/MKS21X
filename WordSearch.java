import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


public class WordSearch{
    private char[][]data;
    private int height;
    private int width;
    private ArrayList<String> wordsToAdd = new ArrayList<String>();
    private ArrayList<String> wordsAdded = new ArrayList<String>();
    private Random randgen;

    public static void main(String[]args){
	int count=args.length;
	boolean key=false;
	int a=0;
	int b=0;
	int d=0;



	if (count <3){
	    System.out.println("Please input more parameters, in the following order:number of rows; number of columbs; name of file;. Two more optional Paramters can be added following the previous ones: puzzle number(for a specific puzzle)  and/or key(for ansers). Ex:(4 4 text.txt 6 key)"  );
	}


	if (count==3){
	    a=Integer.parseInt(args[0]);
	    b=Integer.parseInt(args[1]);
	    String c=args[2];

	    WordSearch current= new WordSearch(a,b,c);
	   
	    System.out.println(current.toString());
	}
	
	if (count==4){
	    a=Integer.parseInt(args[0]);
	    b=Integer.parseInt(args[1]);
	    String c=args[2];
	    d=Integer.parseInt(args[3]);
	  
	    WordSearch current2 = new WordSearch(a,b,c,d);
	    System.out.println(current2.toString());
	}
	if (count==5){
	    a=Integer.parseInt(args[0]);
	    b=Integer.parseInt(args[1]);
	    String c=args[2];
	    d=Integer.parseInt(args[3]);
	    if (args[4].equals("key"))key=true;
	    WordSearch current3 = new WordSearch(a,b,c,d);
	    if (key==true)System.out.println(current3.toStringKey());
	    System.out.println(current3.toString());
	}
	if (count>3)System.out.println("This puzzle is seeded by "+args[3]);

    }

    public void list(){
	for (int i = 0 ; i < data.length ; i++){
	    for (int x = 0 ; x < data[i].length ; x++){
		data[i][x]='-';

	    }
	}
    }

    public WordSearch(int rows, int cols){
	height=rows;
	width=cols;
	data= new char[rows][cols];
	list();

    }  

    public  String check(){
	String x="";
	for (int i = 0 ; i < wordsToAdd.size() ; i++){
	    x=x+" "+wordsToAdd.get(i);
	   
	}
	return x;
    }

    public WordSearch( int rows, int cols, String fileName){
	height=rows;
	width=cols;
	data=new char[rows][cols];
	String x = fileName;
	randgen = new Random();
	try{
	    File f = new File(x);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String word = in.next();
		//do something with word
		wordsToAdd.add(word.toUpperCase());
		
	    }
	    //NOW read the file here...	    
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    //e.printStackTrace();
	    System.exit(1);
	}
	list();
	System.out.println("About to add words");
	addAllWords();
	System.out.println("Done"); 
       
	
	
    }

    public WordSearch( int rows, int cols, String fileName, int randSeed){
	height=rows;
	width=cols;
	data=new char[rows][cols];
	String x = fileName;
	try{
	    File f = new File(x);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String word = in.next();
		//do something with word
		wordsToAdd.add(word.toUpperCase());
	    }
	    //NOW read the file here...	    
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    //e.printStackTrace();
	    System.exit(1);
	}
	randgen = new Random(randSeed);
	list();
	addAllWords();
		

    }

    public WordSearch( int rows, int cols, String fileName, int randSeed, String key ){
	height=rows;
	width=cols;
	data=new char[rows][cols];
	String x = fileName;
	try{
	    File f = new File(x);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String word = in.next();
		//do something with word
	        wordsToAdd.add(word.toUpperCase());
	    }
	    //NOW read the file here...	    
	}catch(FileNotFoundException e){
	    System.out.println("File not found: " + fileName);
	    //e.printStackTrace();
	    System.exit(1);
	}
	randgen = new Random(randSeed);
	list();
	addAllWords();


    }
    
   
    
    private void clear(){
	data= new char[height][width];
	
    }
    
    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String x="";
	

	for (int i = 0; i < data.length ; i++){
	    for (int a = 0; a < data.length ; a++){
		String q="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random r = new Random();
		char k=q.charAt(randgen.nextInt(q.length()));
		if (data[i][a]=='-')data[i][a]=k;
	    
	    }
	    
	}
	for (int i = 0; i < height ; i++){
	    if (i>0)x=x+"\n";
	    for( int a= 0; a < width ; a++){
		x+=data[i][a]+" ";
	    }
	}
	return x;
    }

    public String toStringKey(){
	String x="";
	


	for (int i = 0; i < height ; i++){
	    if (i>0)x=x+"\n";
	    for( int a= 0; a < width ; a++){
		x+=data[i][a]+" ";
	    }
	}
	return x;
    }


    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     */
    public boolean addWordHorizontal(String word,int row, int col){
	if (width-col>=word.length()){
	    for (int i= 0 ; i < word.length() ; i++){
		if (data[row][col+i]=='\u0000' || data[row][col+i]==word.charAt(i)) data[row][col+i]=word.charAt(i);
		if (data[row][col+i]!='\u0000' &&  data[row][col+i]!=word.charAt(i))return false;
	    }
	}

	return true;
    }
    

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     */
    public boolean addWordVertical(String word,int row, int col){
	if (height-row>=word.length()){
	    for (int i= 0 ; i < word.length() ; i++){
		if (data[row+i][col]=='\u0000' || data[row+i][col]==word.charAt(i)) data[row+i][col]=word.charAt(i);
		if (data[row+i][col]!='\u0000' &&  data[row+i][col]!=word.charAt(i))return false;
	    }
	}

	return true;
    }

    public boolean addWordDiagonal(String word,int row, int col){
	if (height-row>=word.length()&& width-col>=word.length()){
	    for (int i= 0 ; i < word.length() ; i++){
		if (data[row+i][col+i]=='\u0000' || data[row+i][col+i]==word.charAt(i)) data[row+i][col+i]=word.charAt(i);
		if (data[row+i][col+i]!='\u0000' &&  data[row+i][col+i]!=word.charAt(i))return false;
	    }
	}
	
	return true;
	
	
    }

    private boolean addWord( int r, int c, String word, int ri, int ci){
	
	if (ci==0 && ri==0)return false;
	if (Test(r,c,word,ri,ci)){
	   
	   
	    for (int i= 0 ; i < word.length() ; i++){
		
		
		data[r+(ri*i)][c+(ci*i)]=word.charAt(i);
		
		
	    }
	    
	    return true;
	}
	System.out.println("Test Failed");
	return false;
    }

    
    private boolean addAllWords(){
       
	int maxTries=wordsToAdd.size()*200;
	while(wordsToAdd.size()!= 0 && maxTries>0){
	    
	    int r=randgen.nextInt(height);
	    int c=randgen.nextInt(width);
	    int ri=randgen.nextInt(3)-1;
	    int ci=randgen.nextInt(3)-1;
	    int num=randgen.nextInt(wordsToAdd.size());
	    
	    String word=wordsToAdd.get(num);
	    System.out.println(r+" " + c+ " "+ ri+ " " +ci+ " "+ word);
	    if (addWord(r,c,word,ri,ci)){
		wordsAdded.add(word);
		wordsToAdd.remove(word);
		System.out.println("Success");
		
	    }
	    else System.out.println("Failure,"+ word);
	    maxTries-=1;
	}
	return true;
    }

    public  boolean Test( int r, int c, String word, int rowIncrement, int colIncrement){
	if (Math.abs(colIncrement)>1 ||Math.abs(rowIncrement)>1)return false;
	if (colIncrement==0 && rowIncrement==0)return false;
	int ci=colIncrement;
	int ri=rowIncrement;
	
	for (int i= 0 ; i < word.length(); i++){
	    try{
	    if (data[r+(ri*i)][c+(ci*i)]!='-'
		&&  data[r+(ri*i)][c+(ci*i)]!=word.charAt(i))
		return false;}
	    catch(IndexOutOfBoundsException e){
		return false;

	    }
	}
	return true;
    }	
	
	
}

    


abstract Class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, int ISBN, String callNumber){
	super(author, title, ISBN);
	this.callNumber=callNumber;

    }

    public String getcallNumber(){
	return callNumber;
    }

    public void setcallNumber(String input){
	callNumber=input;
    }


}

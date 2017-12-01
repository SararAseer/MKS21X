public class Book{
    private String author;
    private String title;
    private int ISBN;

    public Book(){
	author=null;
	title=null;
	ISBN=null;

    }
    
    public Book(String Author, String Title, Int num){
	author=Author;
	title=Title;
	ISBN=num;

    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public int getISBN(){
	return ISBN;
    }

    public void setAuthor(String input){
	author=input;
    }

	
    public void setTitle(String input){
	title=input;
    }

    public void setISBN(int input){
	ISBN=input;
    }

    public String toString(){
	return ""+author+","+title+","+ISBN;
    }
    

}

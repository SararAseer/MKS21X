import java.util.ArrayList;
import java.util.Collections;

public class Library {
    ArrayList<LibraryBook> bookList;
    public Library () {
	bookList = new ArrayList<LibraryBook> ();
    }

    
    public void addBook (LibraryBook book) {
	bookList.add(book);
    }

   
    public void printLibrary () {
	System.out.println ("\nListing of books in the library\n");
	for (LibraryBook book: bookList)
	    System.out.println (book);
	System.out.println ("End of book listing\n");
    }

   
    public LibraryBook findBook (LibraryBook book) {
	int index = Collections.binarySearch(bookList, book);
	if (index >= 0)
	    return bookList.get(index);
	else
	    return null;
    }

    public void sortLibrary () {
	Collections.sort(bookList);
    }

   
    public void checkout (String patron, String dueDate, String callNum) {
	LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
	LibraryBook book = findBook(searchItem);
	if (book == null)
	    System.out.println ("Book " + callNum + " not found -- checkout impossible\n");
	else
	    book.checkout (patron, dueDate);
    }

    public void returned (String callNum) {
	LibraryBook searchItem = new CirculatingBook ("", "", "", callNum);
	LibraryBook book = findBook(searchItem);
	if (book == null)
	    System.out.println ("Book " + callNum + " not found -- return impossible\n");
	else
	    book.returned ();
    }
}

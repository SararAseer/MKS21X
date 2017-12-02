import java.util.Iterator;
import java.util.*;


public class SuperArrayIterator implements Iterator<String>{
    private String[] sa;
    private int index;
    private int size;
    

    public SuperArrayIterator (String [] input){
	sa=input;
	index=0;
	size=input.length;
	
    }
    

    public boolean hasNext(){
	if (index < size-1){
	    return true;
	}
	return false;
    }
    
    public String next(){
	if (hasNext()==true){
	index++;
	    }
	else{
	    System.exit(0);
	}
	return sa[index-1];
    }

    public void remove(){
	throw new UnsupportedOperationException("not gonna work");	       
    }
    



}

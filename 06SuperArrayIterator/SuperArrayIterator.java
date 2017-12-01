import java.util.Iterator;


public class SuperArrayIterator extends SuperArray implements Iterator<String>{
    private SuperArray sa;
    private int index;

    public boolean hasNext(){
	return false;
    }
    
    public String next(){
	return null;
    }

    public void remove(){
	throw new UnsupportedOperationException("not gonna work");	       
    }
    



}

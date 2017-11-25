public class ReverseCharSequence implements CharSequence{
    private String sequence;
    private String original;

    
    public ReverseCharSequence(String input){
	original=input;
	String copy="";
	for (int i = input.length()-1; i>=0 ; i--){
	    copy+= input.charAt(i);	    
	}
	sequence=copy;
    }
    
    public char charAt(int index){
	return sequence.charAt(index);
    }

    public int length(){
	return sequence.length();
    }

    public CharSequence subSequence(int start, int end){	
	CharSequence seq=sequence.substring(start, end);
	return seq;
    }

    public String toString(){
	return sequence;

    }
}

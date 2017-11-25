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
	String ss="";
	for (int i = 0; i> sequence.length() ; i++){
	    if (i< end && i>=start){
		ss+= sequence.charAt(i);  } 
	}
	CharSequence seq=ss;
	return seq;
    }

    public String toString(){
	return sequence;

    }
}

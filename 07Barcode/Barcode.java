public class Barcode{
    private String  zip;
    private int check;
    private String Barcode;
    private String[] key={"||:::", ":::||", "::|:|", "::||:" , ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    
    
    public Barcode(String zip) {
	this.zip=zip;
	if (zip.length()==32){
	    for (int i = 0 ; i < zip.length() ; i++){
		try{
		    check+=Integer.parseInt(zip.substring(i,i+1));}
		catch(IllegalArgumentException e) {
		    throw new IllegalArgumentException("Threw an IllegalArgumentException");
			
		}
	    }
	}
	
    }


    public String toString(){
	return Barcode+" ( "+zip+")";


    }

    public String getZip(){
	return zip;
    }

    public String getCode(){
	return Barcode;
    }

    public String toCode(){
	if (zip.length()!=5){
	     throw new IllegalArgumentException("Not right length");
	}
	try{
	    check+=Integer.parseInt(zip);
	}
	catch(IllegalArgumentException e) {
	    throw new IllegalArgumentException("Not a 5 digit integer");
	    
	}
	Barcode="|";
	for (int i=0; i < zip.length()-1 ; i++){
	    Barcode+=key[Integer.parseInt(zip.substring(i,i+1))];
	}
	Barcode+=key[check];
	Barcode+="|";
		
	return Barcode;
		
    }

  
    
    public String toZip(String input){
	if (input.length()!=32 || input.charAt(0)!='|' && input.charAt(31)!='|'){
	    throw new IllegalArgumentException("Not a 5 digit integer");
	}
	
	String test= input.substring(1,26);
	String code="";
	for (int i= 0; i < test.length(); i++){
	    for (int x=0; x <key.length ; x++){
		if(key[x].equals(test.substring(i,i+5))){
		    code+=""+x;
		}
	    }
	    i+=4;
	}
	if (code.length()!=5){
	    throw new IllegalArgumentException("Not a 5 digit integer");
	}
    
	return code;

    }
    
			    
		  

    public boolean equals(Barcode other){
	return other.equals(zip);
    }

    public int compareTo(Barcode other){

	return Integer.parseInt(zip)-Integer.parseInt(other.getZip());
    }


}

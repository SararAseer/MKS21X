

public class Barcode{
    private String  zip;
    private String Barcode;
    private String[] key={"||:::", ":::||", "::|:|", "::||:" , ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};


    public Barcode(String zip) {
	this.zip=zip;

    }


    public String toString(){
	return Barcode+" "+zip;


    }

    public String getzip(){
	return zip;
    }

    public String getcode(){
	Barcode+="|";
	for (int i=0; i < zip.length()-1 ; i++){
	    Barcode+=key[Integer.parseInt(zip.substring(i,i+1))];
	}
	Barcode+="|";
		
	return Barcode;
		
    }

    public boolean equals(Barcode other){
	return other.equals(zip);
    }

    public int compareTo(Barcode other){

	return Integer.parseInt(zip)-Integer.parseInt(other.getzip());
    }


}

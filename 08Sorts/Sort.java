import java.util.*;
public class Sort{
    
    public static String name(){
	return "09.Aseer.Sarar";	
    }

    public static String arrayOut(int[] input){
	String output="[";
	for (int i=0; i < input.length-1 ; i++){
	    output+=""+input[i]+",";

	}
	output+=""+input[input.length-1]+"]";
	
	return output;
    }
    
    public static void selectionSort(int[] data){
	int min=0;
	int sub=0;
	boolean change=false;
	for (int i=0; i <data.length ; i++){
	    min=data[i];
	    for (int x=i; x<data.length ; x++){
        
		if (data[x]<min){
		    min=data[x];
		    sub=x;
		    change=true;
		}
		

	    }
	    if (change==true){
	    data[sub]=data[i];
	    }
	    data[i]=min;
	    change=false;
	}
    }

     public static void main(String[] args) {
	 int [] x={1,2,51,53,246,146,63,12,41};
	 System.out.println(name());
	 selectionSort(x);
	 System.out.println(arrayOut(x));
	 

     }

}
    
    

   


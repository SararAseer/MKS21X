import java.util.*;
public class Sorts{
    
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

    public int calculateMin(int[] x){
	int min =x[0];
	for (int i=0; i <x.length ; i++){
	    if (x[i]<min){
		min=x[i];
	    }

	}
	return min;

    }

    public static void insertionSort(int[] data){
        for (int i=1; i<data.length; ++i){
	    int sub = data[i];
	    int place = i-1;
	    while (place>=0 && data[place] > sub){
		data[place+1] = data[place];
		place = place-1;
	    }
	    data[place+1] = sub;
	}
	
    }
    
    

}
    
    

   


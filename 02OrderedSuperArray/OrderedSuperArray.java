public class OrderedSuperArray extends SuperArray{
    
    private String [] data;
    private int size;

    

    public int size(){
	size=0;
	for (int i= 0 ; i < data.length ; i++ ){
	    if (data[i]!=null) size+=1;}
	return size;
    }
    
    public OrderedSuperArray(){
        data=new String[10];

    }

    public String set(int index, String element){
	throw new UnsupportedOperationException("no");
    }
    
    public OrderedSuperArray(int capacity){
	data=new String[capacity];
    }
    public  OrderedSuperArray(String [] input){
	size=input.length;
	data= new String[size];
	for (int i = 0 ; i < data.length ; i++){
	    data[i]=input[i];
	}
    }
    
    /*call the proper add.*/
    public void add(int index, String element){
	add(element);
    }
    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String element){
	int index=place(element);
	if (index==-1)return false;
	size=size+1;
	String [] replacement= new String [size];
	int place=0;
	for (int x = 0 ; x < replacement.length ; x++){
	    if (x==index)x=x+1;
	    if (x!=index && place <data.length)replacement[x]=data[place];
	    place+=1;
	}
	replacement[index]=element;

	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}
	return true;
    }

    
    public int indexOf(String element){
	for (int i = 0 ; i < size ; i++){
	    if (data[i]!=null&&data[i].equals(element))return i;
	}
	return -1;
    }
    

    public int place(String word){
	String element=word;
	size();
	if (size==0) return 0;
	if (size()==1){
	    if (element.compareTo(get(0)) < 0){
		return 0;
	    }
	    else{
		return 1;
	    }

	}
	int start=0;
	int end=size-1;
	int mid=0;
	for (int i = 0 ; i < size+1 ; i++){
	    mid=(start+end)/2;
	    int v=word.compareTo(word);
	    if (v>0)start=mid;
	    if (v<0)end=mid;
	    if (v==0)return mid;
	    if (start+1==end){
		int v2=word.compareTo(data[start]);
		int v3=word.compareTo(data[end]);
		if (v2<0)return start;
		if (v2>=0)return end;
	       
	    
	    }
	}
	return -1;
    }
    public String toString(){
	String transformation="[";
	if (size==1)return "["+ data[0]+"]";
	if (size>1){
	    for (int i = 0 ; i < data.length-1 ; i++){
	    if (data[i]!=null)transformation+=data[i]+",";
	    }
	}
	transformation+= data[size-1]+"]";
	return transformation;
	
    }
       
}


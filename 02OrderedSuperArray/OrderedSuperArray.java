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
        String [] replacement= new String [size()+1];
	int place=0;
	for (int x = 0 ; x < size() ; x++){
	    if (x==index){replacement[x]=element;
		x=x+1;}
	    if (x!=index)replacement[x]=data[place];
	    place+=1;
	}
	this.size=size+1;
	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}

    }
    
    /*Write this method and any
      appropriate helper methods.*/
    public boolean add(String element){
	int index=place(element);
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
	size();
	int start=0;
	int end=size-1;
	int mid=0;
	while (start!=end){
	    mid=(start+end)/2;
	    int v1=Math.abs(data[start].compareTo(word));
	    int v2=Math.abs(data[end].compareTo(word));
	    if (v1>v2)start=mid;
	    if (v2>v1)end=mid;
	    if (v1==v2)start=mid;
	    if (Math.abs(start-end)==1){
		int v3=data[start].compareTo(word);
		int v4=data[end].compareTo(word);
		if (v1>v2&& v4<0)return end+1;
		if (v1>v2&& v4>0)return end;
		if (v2>v1 && v3>0)return start+1;
	       
	    
	    }
	}
	return start+1;
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


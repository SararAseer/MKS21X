public class SuperArray{
    
    private String[] data;
    
    private int size;
    
    public  int size(){
	size=0;
	for (int i= 0 ; i < data.length ; i++ ){
	    if (data[i]!=null) size+=1;}
	return size;
    }

    public boolean isEmpty(){
	if (size==0) return true;
	for (int i = 0 ; i < data.length ; i++){
	    if (data[i]!=null)return false;
	}
	return true;
    }
    
    public  SuperArray(){
	data= new String[size];
    }
    
    public  SuperArray(String [] input){
	size=input.length;
	data= new String[size];
	for (int i = 0 ; i < data.length ; i++){
	    data[i]=input[i];
	}
    }

    public  SuperArray(int  input){
	data=new String[size];
	
    }
    
   
    public String getIndex(int index){
	if (index < 0 || index >= size())return null;
	return data[index];
    }
    
    public void clear(){
	data=new String[size];
    }

    private void resize(){
	String [] replacement= new String [size()+1];
	for (int i = 0 ; i < data.length ; i++){
	    replacement[i]=data[i];
	}
	size=size+1;
	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}
	    
    }

    public boolean add(String element){
	for (int i = 0 ; i < data.length ; i++){
	    if (data[i]==null)
		{data[i]=element;
		    return true;
		}
	}
	String [] replacement= new String [size()+1];
	for (int i = 0 ; i < data.length ; i++){
	    replacement[i]=data[i];
	}
	replacement[data.length]=element;
	size=size+1;
	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}

	return true;
	
    }
    
    public String set(int index, String element){
	if (index < 0 || index >= size()) return null;
	String old=data[index];
	data[index]=element;
	return old;
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
    
    public boolean contains(String element){
	for (int i = 0 ; i < data.length ; i++){
	    if (data[i]!=null&&data[i].equals(element))return true;
	}
	return false;
    }

    public void add(int index, String element){
	
	String [] replacement= new String [size()+1];
	int place=0;
	for (int x = 0 ; x < replacement.length ; x++){
	    if (x==index)x=x+1;
	    if (x!=index)replacement[x]=data[place];
	    place+=1;
	}
	replacement[index]=element;
	this.size=size+1;
	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}

    }
    
    public int indexOf(String element){
	for (int i = 0 ; i < data.length ; i++){
	    if (data[i]!=null&&data[i].equals(element))return i;
	}
	return -1;
    }
    
    public int lastIndexOf(String element){
	for (int i = size-1 ; i>=0; i--){
	    if (data[i]!=null&&data[i].equals(element))return i;
	}
	return -1;
    }

    public String remove(int index){
	if (index < 0 || index >=  size()) return null;
	String element=data[index];
	String [] replacement= new String [size()-1];
	int place=0;
	for (int x = 0 ; x < data.length ; x++){
	    if (x==index)x=x+1;
	    if (x!=index && place<replacement.length)replacement[place]=data[x];
	    place+=1;
	}
	this.size=size-1;
	data= new String[size];
	for (int i = 0 ; i < replacement.length ; i++){
	    data[i]=replacement[i];
	}
	return element;
	
    }
    public boolean remove(String element){
	if (indexOf(element)!=-1){
	    remove(indexOf(element));
	    return true;
	}
	size=size-1;
	return false;
    }
}

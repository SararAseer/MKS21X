public class ReferenceBook extends LibraryBook {
    private String collection;

    public ReferenceBook(String auth, String tit, String ISB, String call, String coll) {
        super(auth,tit,ISB,call);
        collection = coll;
    }
    public String getCollection() {
	return collection;
    }
    public void setCollection(String s) {
	collection = s;
    }
    public void checkout(String dad, String date) {
        System.out.print("cannot check out a reference book");
    }
    public void returned() {
        System.out.print("reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus() {
        return "non-circulating reference book";
    }
    public String toString() {
        return super.toString() + ", Collection: " + getCollection();
    }
}

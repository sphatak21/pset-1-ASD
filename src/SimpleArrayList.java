import java.util.List;
public class SimpleArrayList {
    int lastIndex=-1;
    String[] mainArray;
    public SimpleArrayList() {
        mainArray=new String[0];
    }
    public SimpleArrayList(int initialCapacity){
        if (initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity: -1");
        }
        mainArray = new String[initialCapacity];
    }
    public SimpleArrayList(List<String> list){
        mainArray = new String[list.size()];
        mainArray = list.toArray(mainArray);
        lastIndex= mainArray.length-1;
    }
    public void add(int index, String s){
        if(index<0 || index>lastIndex+1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+String.valueOf(lastIndex+1));
        }
        String[] tempArray;
        tempArray=populateTempArray(mainArray);
        //TODO: optimize lastIndex
        String replacingTemp = tempArray[index];

        for(int i=index; i<=lastIndex; i++){
            String replacedTemp = tempArray[i+1];
            tempArray[i+1]=replacingTemp;
            replacingTemp=replacedTemp;
        }
        tempArray[index]=s;
        mainArray=tempArray;
        lastIndex++;
    }
    public void add(String s){
        String[] tempArray;
        tempArray=populateTempArray(mainArray);
        tempArray[lastIndex+1]=s;
        mainArray=tempArray;
        lastIndex++;
    }
    public void clear() {
        mainArray=new String[0];
        lastIndex=-1;
    }
    public boolean contains(String s){
        int x = indexOf(s);
        if (x == -1){
            return false;
        }
        return true;
    }
    public String get(int index){
        if(index>lastIndex+1 || index<0) {
            throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length " + String.valueOf(lastIndex+1));
        }
        else {
            return mainArray[index];
        }
    }
    public int indexOf(String s){
        for(int i=0; i< lastIndex+1; i++){
            if(mainArray[i]==s){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        if(lastIndex<0){
            return true;
        }
        else {
            return false;
        }
    }
    public String remove(int index){
        if(index>lastIndex+1 || index<0) {
            throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length " + String.valueOf(lastIndex+1));
        }
        String returnString=mainArray[index];
        for(int i=index+1; i < lastIndex+1; i++){
            mainArray[i-1] = mainArray[i];
        }
        lastIndex--;
        return returnString;
    }
    public boolean remove(String s){
        if(indexOf(s)==-1){
            return false;
        }
        int index = indexOf(s);
        for(int j=index+1; j < lastIndex+1; j++) {
            mainArray[j-1] = mainArray[j];
        }
        lastIndex--;
        return true;
    }
    public String set(int index, String s){
        if(index>lastIndex+1 || index<0) {
            throw new IndexOutOfBoundsException("Index "+index+" out of bounds for length " + String.valueOf(lastIndex+1));
        }
        String previousValue=mainArray[index];
        mainArray[index]=s;
        return previousValue;
    }
    public int size(){
       return lastIndex+1;
    }
    public void trimToSize(){
        String [] tempArray;
        tempArray=populateTempArray(mainArray);
        mainArray=tempArray;
    }
    public String toString(){
        String mainString = "[";
        for(int i=0; i<=lastIndex; i++){
            String addString = "";
            addString=mainArray[i];
            if(i==lastIndex){
                mainString=mainString + addString;
            }
            else {
                mainString = mainString + addString + ", ";
            }
        }
        return mainString + "]";
    }
    private String[] populateTempArray(String [] mainArr){
        String [] tempArray;
        if(lastIndex==-1){
            tempArray=new String[1];
        }
        else {
            tempArray=new String[lastIndex+2];
        }
        for(int i=0; i<=lastIndex;i++){
            tempArray[i]=mainArr[i];
        }
        return tempArray;
    }
}


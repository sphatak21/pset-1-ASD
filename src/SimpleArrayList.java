import java.util.List;
public class SimpleArrayList {
    //lastIndex is the logical end of the Array
    int lastIndex=-1;
    //mainArray is the array located within the SimpleArrayList object
    String[] mainArray;
    public SimpleArrayList() {
        //Default Constructor
        mainArray=new String[0];
    }
    public SimpleArrayList(int initialCapacity){
        //Initial Capacity Constructor
        if (initialCapacity<0){
            throw new IllegalArgumentException("Illegal Capacity: -1");
        }
        mainArray = new String[initialCapacity];
    }
    public SimpleArrayList(List<String> list){
        //List -> Array Constructor
        mainArray = new String[list.size()];
        mainArray = list.toArray(mainArray);
        lastIndex= mainArray.length-1;
    }
    public void add(int index, String s){

        if(index<0 || index>lastIndex+1){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+String.valueOf(lastIndex+1));
        }
        //initialize tempArray
        String[] tempArray;
        //populate tempArray
        tempArray=populateTempArray(mainArray);
        //Add essentially increases the index of every single value starting from the given index, then inserts the String at the given index
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
        //adds String to end of array
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
        //if string is not found, returns -1
        return -1;
    }
    public boolean isEmpty(){
        //lastIndex being less than zero means that the length of the array is zero
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
        //Starting from Index + 1, for loop reduces the index of each element by one
        //lastIndex is reduced by one because the logical length of the array is reduced by one
        for(int i=index+1; i < lastIndex+1; i++){
            mainArray[i-1] = mainArray[i];
        }
        lastIndex--;
        return returnString;
    }
    public boolean remove(String s){
        //checks first to see whether the string is in the array or not
        if(indexOf(s)==-1){
            return false;
        }
        int index = indexOf(s);
        //starting from the index found from indexOf, for loop does the same as for loop in remove(int index)
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
        //param is mainArray
        String [] tempArray;
        //tempArray is an array that has an array length that is oe greater than the length of mainArray
        tempArray=new String[lastIndex+2];
        //for loop populates tempArray with mainArray
        for(int i=0; i<=lastIndex;i++){
            tempArray[i]=mainArr[i];
        }
        return tempArray;
    }
}


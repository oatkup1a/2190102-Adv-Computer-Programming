public class BetterList implements PythonListOfInt {
    private int[] array;
    public BetterList(int[] a) {
        array = a;
        for(int lastIndex=array.length-1;lastIndex >= 1;lastIndex--) {
            for(int i=0;i<lastIndex;i++) {
                if(array[i] > array[i+1]) {
                    //swap them
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }

    public int findMin() {
        return array[0];
    }
    
    public int findMax() {
        return array[array.length-1];
    }

    public int findSum() {
        int sum = 0;
        for(int a:array) sum += a;
        return sum;
    }

    public boolean contains(int v) {
        for(int a:array) if (v == a) return true;
        return false;
    }

    public void append(int v) {
        // [1,2,4,6,,8,9]; v=5
        int[] a = new int[array.length+1];
        int i=0;
        while(array[i] < v) {
            a[i] = array[i];
            i++;
        }
        a[i++] = v;
        for(int j=i-1; j<=array.length; j++) {
            a[i++] = array[j];
        }
        array = a;
    }

 public String toString() {
        String out = "[";
        for(int a:array) {
            out += a+",";
        }
        out = out.substring(0,out.length()-1)+"]";
        return out;
    }

}

public class SimpleList implements PythonListOfInt {
    private int[] array;
    public SimpleList(int[] a) {
        array = a;
    }
    public int findMax() {
        int max = Integer.MAX_VALUE;
        for(int a : array) {
        if(a > max) max = a;
        }
    return max;
    }

    // another for loop
    // int max = array[0];
    // for(int i=1; i<array.length; i++) {
    //      if(array[i] > max) max = array[i];
    //}
    // return max;

    public int findMin() {
        int min = Integer.MIN_VALUE;
        for(int a : array) {
            if (a < min) min = a;
        }
        return min;
    }
    public int findSum() {
        int sum = 0;
        for(int a : array) sum += a;
        return sum;

    }

    public boolean contains(int v) {
        for(int a : array) {
            if (a==v) return true;
        }
        return false;
    }

    public void append(int v) {
        int[] a = new int[array.length+1];
        for(int i=0; i<array.length; i++) {
            a[i] = array[i];
        }
        a[array.length]=v;
        array=a;
    }

    public String toString() {
        if(array.length==0) return "]";
        String out = "[";
        for(int a:array) {
            out += a+",";
        }
        out = out.substring(0,
                out.length()-1)+"]";
        return out;
    }

    // public int max_of_two(int a, int b) {
    //     if (a < b) {
    //         return a;
    //     }
    //     return b;
    // }
}

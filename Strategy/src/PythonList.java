public class PythonList {
    protected FindMinMaxStrategy strategy;
    protected int[] array;

    public PythonList(int[] array) {
        setArray(array);
    }
    public void setStrategy(FindMinMaxStrategy strategy) {
        this.strategy = strategy;
    }

    public void setArray(int[] a) {
        // Create a copy of the input array to prevent modification
        array = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }
    }

    public int findMin() {
        return strategy.findMin(array);
    }

    public int findMax() {
        return strategy.findMax(array);
    }

    public void append(int value) {
        array=strategy.append(value, array);
    }

    public boolean contains(int v) {
        for(int a: array) {
            if(a==v) return true;
        }
        return false;
    }
}

class UnsortedList extends PythonList {
    public UnsortedList(int[] array) {
        // Set the strategy to use the unsorted algorithm
        super(array);
        this.strategy = new UnsortedFindMinMaxStrategy();
        this.strategy.sortArray(array);
    }
    public void append(int v) {
    int[] a = new int[array.length+1];
    for(int i=0;i<array.length;i++) {
        a[i] = array[i];
    }
    a[array.length]=v;
    array=a;
    }

    public String toString() {
    if(array.length == 0) return "[]";
    String out = "[";
    for(int a:array) {
        out += a+", ";
    }
    out = out.substring(0,out.length()-2)+"]";
    return out;
    }
}

class SortedList extends PythonList {
    public SortedList(int[] array) {
        // Set the strategy to use the sorted algorithm
        super(array);
        this.strategy = new SortedFindMinMaxStrategy();
        this.array = this.strategy.sortArray(array);
    }
    public void append(int v) {
    int[] a = new int[array.length+1];
    int i = 0;
    while(v > array[i]) {
        a[i] = array[i];
        i++;
    }
    a[i++] = v;
    for(int j=i-1;j<array.length;j++) {
        a[i++] = array[j];
    }
    array=a;
}   

    // Other methods and properties specific to SortedList
    public boolean contains(int v) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;

        // If the middle element is equal to v, return true
        if (array[mid] == v) {
            return true;
        }

        // If v is less than the middle element, search in the left half
        if (array[mid] > v) {
            right = mid - 1;
        }
        // If v is greater than the middle element, search in the right half
        else {
            left = mid + 1;
        }
    }

    // If the loop finishes without finding v, return false
    return false;
    }
    public String toString() {
    if(array.length == 0) return "[]";
    String out = "[";
    for(int a:array) {
        out += a+", ";
    }
    out = out.substring(0,out.length()-2)+"]";
    return out;
}
}


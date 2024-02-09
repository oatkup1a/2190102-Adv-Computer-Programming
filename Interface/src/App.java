public class App {
    public static void testInferface(PythonListOfInt x) {
        System.out.println(x);
        System.out.println(x.findMax());
        System.out.println(x.findMin());
        System.out.println(x.findSum());
        System.out.println(x.contains(11));
        System.out.println(x.contains(10));
        x.append(20);
        System.out.println(x);
    }
    public static void main(String[] args) throws Exception {
        int[] d = {10,2,3,4,5};
        PythonListOfInt x = new SimpleList(d);
        testInferface(x);
        PythonListOfInt y = new BetterList(d);
        testInferface(y);
        int[] d1 = {};
        PythonListOfInt x1 = new SimpleList(d1);
        testInferface(x1);
    }
}
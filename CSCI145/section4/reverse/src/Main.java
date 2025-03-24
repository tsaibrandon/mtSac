public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};

        printArray(array);

        reverseArray(array);

        printArray(array);
    }

    private static void printArray(int[] array) {
        System.out.print(" [ ");

        for(int i : array) {
            System.out.print(i + " ");
        }

        System.out.println("] ");
    }

    private static void reverseArray(int[] array) {
        int i = 0;
        int j = array.length - 1;
        
        for (; i < j; ++i, --j) {
            extracted(array, i, j);
        }
    }

    private static void extracted(int[] array, int i, int j) {
        int tmp;
        tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
        
}

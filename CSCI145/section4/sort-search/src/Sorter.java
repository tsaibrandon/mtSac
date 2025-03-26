public class Sorter {

    public static void bubbleSort(int[] array) {
        boolean sorted = false;
        for (int j = array.length - 1; !sorted && j > 0; j--) {
            sorted = true;
            for (int i = 0; i < j; i++) {
                if(array[i] > array[i + 1]) {
                    sorted = false;
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void swap(int[] array, int sub1, int sub2) {
        int tmp = array[sub1];
        array[sub1] = array[sub2];
        array[sub2] = tmp;
    }
}

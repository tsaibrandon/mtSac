public class Searcher {

    /**
     * Sequential Search of an array integer array
     * @param array: array of zero or more ints (not null)
     * @param term: integer searched for
     * @return: subscript if found or -1 otherwise
     */

    public static int seqSearch(int[] array, int term) {
        
        if (array == null) return -1;

        for (int i = 0; i < array.length; i++) {
            if(array[i] == term) return i;
        }

        return -1;
    }

    /**
     * Binary Search of an array integer array
     * @param array: array of zero or more ints (not null)
     *               MUST BE SORTED IN ASC ORDER
     * @param term: integer searched for
     * @return: subscript if found or -1 otherwise
     */

    public static int binarySearch(int[] array, int term) {

        if (array == null) return -1;

        return binarySearch(array, i:0, array.length - 1, term);
    }

    private static int binarySearch(int[] array, int i, int j, int term) {
        int mid;

        if(i > j) return -1;

        mid = (i + j) >>> 1;

        if(array[mid] == term) return mid;
        if(array[mid] > term) 
            return binarySearch(array, i, mid - 1, term);
        
        return binarySearch(array, mid + 1, j, term);
    }
}

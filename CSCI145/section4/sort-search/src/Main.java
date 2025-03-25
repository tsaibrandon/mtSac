public class Main {
    public static void main(String[] args) {
        int[] array = {10, 27, 34, 46, 104, 127, 206, 225};
        int[] array2 = {10, 27, 34, 46, 104, 127, 206};

        System.out.println(Searcher.seqSearch(array, 10));
        System.out.println(Searcher.seqSearch(array, 225));
        System.out.println(Searcher.seqSearch(array, 46));
        System.out.println(Searcher.seqSearch(array, 47));
        
        System.out.println(Searcher.seqSearch(array2, 46));
        
        System.out.println(Searcher.seqSearch(null, 47));
        
        System.out.println(Searcher.seqSearch(new int[]{}, 47));
    }
}


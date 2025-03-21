public class Main {
    public static void main(String[] args) {
        
        {
            for(int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }

        {
            int i = 0;
            for(; i < 10; i++) {
                System.out.println(i);
            }
        }

        {
            int i = 0;
            for(; ; i++) {
                if(i >= 10) break;
                System.out.println(i);
            }
        }
        
        {
            int i = 0;
            for(; ;) {
                if(i >= 10) break;
                System.out.println(i);
                i++;
            }
        }
        
        {
            int i = 0;
            while(i < 10) {
                System.out.println(i++);
            }
        }
    }
}

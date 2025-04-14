import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;

public class FileUtil {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        if(args.length < 1) {
            printUsage();
            System.exit(0);
        }

        switch (args[0]) {
            case "write": write(args); break;
            case "read": read(args); break;
            case "copy": copy(args); break;
            default:
                printUsage();
        }
    }

    private static void copy(String[] args) {
        


        if(args.length != 3) {
            printCopyUsage();
            return;
        }
        String srcFilepath = args[1];
        String dstFilepath = args[2];
        
        copyFile(srcFilepath, dstFilepath);
    }
        
    private static void copyFile(String srcFilepath, String dstFilepath) {
        InputStream in;
        OutputStream out;

        try {
            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;

            in = new FileInputStream(srcFilepath);
            out = new FileOutputStream(dstFilepath);

            while((bytesRead = in.read(buffer)) != -1)
                out.write(buffer, 0, bytesRead);

            in.close();
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found!\n");
        } catch (IOException e) {
            System.out.println("Problem reading/writing the files");
        }
           
    }
        
    private static void printCopyUsage() {

    }

    private static void read(String[] args) {
        
        String filepath;

        if(args.length != 2) {
            printReadUsage();

            return;
        }

        filepath = args[1];
    
        readFile(filepath);

            
    }

    private static void readFile(String filepath) {
        try {
            Scanner in;

            in = new Scanner(new FileReader(filepath));

            while(in.hasNextLine()) System.out.println(in.nextLine());

            in.close();    
        } catch (FileNotFoundException e) {
            System.out.println("File not found!\n");
        }
    }

    public static void printReadUsage() {
        System.out.println(
        "Usage for write:\n" +
        "   write filepath qty_random_ints "
        );
    }

    private static void write(String[] args) {
        
        
        String filepath;
        int numberQty;

        if(args.length != 3) {
            printWriteUsage();

            return;
        }


        filepath = args[1];
        numberQty = Integer.parseInt(args[2]);

        writeFile(filepath, numberQty);
        
    }

    private static void writeFile(String filepath, int numberQty) {
        Random rnd = new Random();
        PrintWriter pw;
        try {
            pw = new PrintWriter(new File(filepath));

            for (int i = 0; i < numberQty; i++)
                pw.println(rnd.nextInt());

            pw.close();
        }catch(FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static void printWriteUsage() {
        System.out.println(
        "Usage for write:\n" +
        "   write filepath qty_random_ints "
        );
    }

    private static void printUsage() {
        System.out.println(
            "File usage:\n" +
            " java FileUtil <Operation> filepath [operand...] \n" + 
            " Operations: write: writes n random values\n" + 
            "             print: prints a text file to stdout\n" +
            "             copy: duplicates any file."
        );
    }
}

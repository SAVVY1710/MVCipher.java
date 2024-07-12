import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.crypto.Cipher;
public class MVCipher
{
    PrintWriter pw;
    Scanner input;
    String filenametoread;
    public static void main(String[] args) {
        MVCipher mvc = new MVCipher();
        mvc.run();
    }
    public void run()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println( "Welcome to the MV Cipher machine!");
        System.out.println();
        System.out.print("Please input a word to use as key (letters only): ");
        String word = scan.next();
        while(word.trim().length()< 3)
        {
            System.out.print("ERROR: Key must be all letters and at least 3 characters long\n");
            System.out.print("Please input a word to use as key (letters only): ");
            word = scan.next();
            System.out.println();
        }
        System.out.print("Encrypt or Dectrypt? (1, 2): ");
        int choice = scan.nextInt();

        if(choice == 1)
        {
            encrypt();
        }
        else if(choice == 2)
        {
            decrypt();
        }
    }
    public void encrypt()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name of file to encrypt -> ");
        String filenametoread = scan.next().trim();
        System.out.print("Name of output file -> ");
        String filenametowrite = scan.next().trim();
        System.out.println("\n");
        String filecontents;
        tryCatchIt();
        while(input.hasNextLine())
        {
            System.out.println(input.nextLine());
        }
        input.close();
    }
    public void decrypt()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name of file to encrypt -> ");
        filenametoread = scan.next().trim();
        System.out.print("Name of output file -> ");
        String filenametowrite = scan.next().trim();
        System.out.println("\n");
    }
    public void tryCatchIt()
    {
        File inFile = new File (filenametoread);
        String inFileName = "dictionary.txt";
        //value = "";
        input = null;
        try
        {
            input = new Scanner ( inFile );
        }
        catch ( FileNotFoundException e )
        {
            System.err.println("Cannot find " + inFileName + " file.");
            System.exit(1);
        }
    }
    public void append(String wd)
    {
        pw = null;
        File outFile = new File("dictionary.txt");
        try
        {
            pw = new PrintWriter( new FileWriter(outFile, true) );
        }
        catch (IOException e)
        {
            System.err.println("Cannot append to " +  " dictionary.txt");
            System.exit(1);
        }
        pw.println(wd);
        pw.close();
    }
}
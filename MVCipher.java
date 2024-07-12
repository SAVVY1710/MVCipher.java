import java.util.Scanner;

import javax.crypto.Cipher;
public class MVCipher
{
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
    }
    public void decrypt()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name of file to encrypt -> ");
        String filenametoread = scan.next().trim();
        System.out.print("Name of output file -> ");
        String filenametowrite = scan.next().trim();
        System.out.println("\n");
    }
}
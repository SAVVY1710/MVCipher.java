//imports for file/IO
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//Class where everything happens
public class MVCipher 
{
    // field variables
    PrintWriter pw;
    Scanner input;
    String filenametoread;
    String fileText;
    String word;
    String checker;
    char newlet;
    String encryptedString;
    String filenametowrite;

    // Constructor where i initialize field variables
    public MVCipher() 
    {
        pw = null;
        input = null;
        filenametoread = "";
        fileText = "";
        word = "";
        checker = "";
        encryptedString = "";
        filenametowrite = "";
    }

    // in the main I create an instance of the class and run the run() method
    public static void main(String[] args)
    {
        MVCipher mvc = new MVCipher();
        mvc.run();
    }

    // method that was called by main and where everything happens
    public void run() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n");
        System.out.println("Welcome to the MV Cipher machine!");
        System.out.println();
        System.out.print("Please input a word to use as key (letters only): ");
        word = scan.next();
        while (word.trim().length() < 3) {
            System.out.print("ERROR: Key must be all letters and at least 3 characters long\n");
            System.out.print("Please input a word to use as key (letters only): ");
            word = scan.next();
            System.out.println();
        }
        System.out.print("Encrypt or Dectrypt? (1, 2): ");
        int choice = scan.nextInt();

        if (choice == 1) {
            encrypt();
        } else if (choice == 2) {
            decrypt();
        }
    }

    // Method that is called if you choose to encrypt a file
    public void encrypt() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name of file to encrypt -> ");
        filenametoread = scan.next().trim();
        System.out.print("Name of output file -> ");
        filenametowrite = scan.next().trim();
        System.out.println("\n");

        tryCatchIt();
        while (input.hasNextLine()) 
        {
            fileText += input.nextLine();
        }
        input.close();
        for (int i = 0; i <= fileText.length() / word.length(); i++) 
        {
            checker += word;
        }
        for (int i = 0; i < fileText.length(); i++) 
        {
            if (fileText.charAt(i) != ' ' && fileText.charAt(i) != '1' && fileText.charAt(i) != '2'
                    && fileText.charAt(i) != '3' && fileText.charAt(i) != '4' && fileText.charAt(i) != '5'
                    && fileText.charAt(i) != '6' && fileText.charAt(i) != '7' && fileText.charAt(i) != '8'
                    && fileText.charAt(i) != '9' && fileText.charAt(i) != '0') 
                {
                    char file = fileText.charAt(i);
                    char other = checker.toLowerCase().charAt(0);

                    //statement for uppercase letters
                    if ((int) file >= 65 && (int) file <= 90)
                    {
                        other = checker.toUpperCase().charAt(0);
                        if ((int) file + (int) other - 64 > 90) 
                        {
                            if(file > other)
                            {
                                newlet = (char) (64 + ((int)file - 64)-(90-(int)other));
                            }
                            else if(other > file)
                            {
                                newlet = (char) (64 + ((int)other - 64)-(90-(int)file));
                            }
                            else if(other == file)
                            {
                                newlet = (char) (64 + ((int)other - 64)-(90-(int)file));
                            }
                            
                            encryptedString += newlet + "";
                        } 
                        else 
                        {
                            newlet = (char) ((int) file + (int) other - 64);
                            encryptedString += newlet + "";
                        }
                        checker = checker.substring(1, checker.length());
                    }
                    //statement for uppercase letters
                    else if ((int) file >= 97 && (int) file <= 122) 
                    {
                        if ((int) file + (int) other - 96 > 122) 
                        {
                            if(file > other)
                            {
                                newlet = (char) (96 + ((int)file - 96)-(122-(int)other));
                            }
                            else if(other > file)
                            {
                                newlet = (char) (96 + ((int)other - 96)-(122-(int)file));
                            }
                            else if(other == file)
                            {
                                newlet = (char) (96 + ((int)other - 96)-(122-(int)file));
                            }
                            
                            encryptedString += newlet + "";
                        } 
                        else 
                        {
                            newlet = (char) ((int) file + (int) other - 96);
                            encryptedString += newlet + "";
                        }
                        checker = checker.substring(1, checker.length());
                    }
                }
            else 
            {
                encryptedString += fileText.charAt(i);
            }

        }
        System.out.println(encryptedString);
        append(encryptedString);

    }
    // method that is run if you choose to decrypt a file
    public void decrypt() 
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Name of file to encrypt -> ");
        filenametoread = scan.next().trim();
        System.out.print("Name of output file -> ");
        String filenametowrite = scan.next().trim();
        System.out.println("\n");
        tryCatchIt();
        while (input.hasNextLine()) 
        {
            fileText += input.nextLine();
            System.out.println(input.nextLine());
        }
        input.close();
        for (int i = 0; i <= fileText.length() / word.length(); i++) 
        {
            checker += word;
        }
        for (int i = 0; i < fileText.length(); i++) 
        {
            if (fileText.charAt(i) != ' ' && fileText.charAt(i) != '1' && fileText.charAt(i) != '2'
                && fileText.charAt(i) != '3' && fileText.charAt(i) != '4' && fileText.charAt(i) != '5'
                && fileText.charAt(i) != '6' && fileText.charAt(i) != '7' && fileText.charAt(i) != '8'
                && fileText.charAt(i) != '9' && fileText.charAt(i) != '0') 
            {
                char file = fileText.charAt(i);
                char other = checker.toLowerCase().charAt(0);

                if ((int) file >= 65 && (int) file <= 90)
                {
                    other = checker.toUpperCase().charAt(0);
                    if ((int) file - (int) other - 64 < 65) 
                    {
                        if(file > other)
                        {
                            newlet = (char)(90 - (file - 64 - (other-64)));
                        }
                        else if(other > file)
                        {
                            newlet = (char)(90 - (other - 64-(file-64)));
                        }
                        else if(other == file)
                        {
                            newlet = (char)(90 - (file - 64-(other-64)));
                        }
                            
                        encryptedString += newlet + "";
                    }
                    else 
                    {
                        newlet = (char)((int) file - (int) other);
                        encryptedString += newlet + "";
                    }

                }

            }

        }
            

    System.out.println(encryptedString); 
    }

    // Method used to read a file
    public void tryCatchIt() {
        File inFile = new File(filenametoread);
        String inFileName = "dictionary.txt";
        // value = "";
        input = null;
        try 
        {
            input = new Scanner(inFile);
        } 
        catch (FileNotFoundException e) 
        {
            System.err.println("Cannot find " + inFileName + " file.");
            System.exit(1);
        }
    }

    // Method used to write in a file
    public void append(String wd) {
        pw = null;
        File outFile = new File(filenametowrite);
        try 
        {
            pw = new PrintWriter(new FileWriter(outFile, false));
        } 
        catch (IOException e) 
        {
            System.err.println("Cannot append to " + " dictionary.txt");
            System.exit(1);
        }
        pw.println(wd);
        pw.close();
    }
    
}
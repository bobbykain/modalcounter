import java.io.*;
import java.util.Scanner;

class Writer
{
  public Writer()
  {

  }

  //method for user to enter notes they want to play
  public char[] writeString()
  {
    System.out.println("Please input a string of notes (A-G)");
    Scanner keyboard = new Scanner(System.in);
    String notes = keyboard.nextLine();
    char[] pitch = notes.toCharArray();
    return pitch;

  }
}

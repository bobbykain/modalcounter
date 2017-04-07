import java.io.*;
import java.util.Scanner;

class Writer
{
  public Writer()
  {

  }
  public char[] writeString()
  {
    System.out.println("Please input a string of notes (A-G)");
    Scanner keyboard = new Scanner(System.in);
    String notes = keyboard.nextLine();
    char[] pitch = notes.toCharArray();
    return pitch;

  }
}

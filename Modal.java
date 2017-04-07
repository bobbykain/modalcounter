import java.io.*;


class Modal
{
  public static void main(String[] args)
  {
    Writer w = new Writer();
    Reader r = new Reader();

    char[] line1 = w.writeString();

    r.playNotes(line1);

    char[] line2 = w.writeString();

    r.playNotes(line2);

    r.playNotes(line1,line2);



  }
}

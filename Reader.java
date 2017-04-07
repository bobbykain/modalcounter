import java.io.*;
import java.util.Scanner.*;

class Reader
{
  public Reader()
  {

  }
  //play notes for user
  public void playNotes(char[] notes)
  {
    Player playit = new Player();
    int n = notes.length;
    for(int k = 0; k < n; k++)
    {
      playit.play(notes[k] + ".wav");
    }
  }
  // play chords for user
  public void playNotes(char[] notes, char[] notes1)
  {
    Player playit = new Player();
    int n = notes.length;
    for(int k = 0; k < n; k++)
    {
      playit.play(notes[k] + ".wav",notes1[k] + ".wav");
    }
  }
}

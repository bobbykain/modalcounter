import java.io.*;


class Reader
{
  public Reader()
  {

  }
  public void playNotes(String[] notes)
  {
    Player playit = new Player();
    int n = notes.length;
    for(int k = 0; k < n; k++)
    {
      playit.play("PianoSounds/" + notes[k] + ".wav");
    }
    System.out.println("Melody Complete");
  }

  public void playNotes(String[] notes, String[] notes1)
  {
    Player playit = new Player();
    int n = notes.length;
    for(int k = 0; k < n; k++)
    {
      playit.play("PianoSounds/" + notes[k] + ".wav","PianoSounds/" + notes1[k] + ".wav");
    }
    System.out.println("Melodies Complete");
  }
}

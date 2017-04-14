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
  }

  public void playNotes(String[] notes, String[] notes1)
  {
    Player playit = new Player();
    int n = notes.length;
    for(int k = 0; k < n; k++)
    {
      playit.play("PianoSounds/" + notes[k] + ".wav","PianoSounds/" + notes1[k] + ".wav");
    }
  }
}


import java.io.*;
import javax.sound.sampled.*;

public class AudioController
{
  boolean clipComplete;

  void play(String audioFilePath)
  {
    File audioFile = new File(audioFile);

    try
    {
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
      AudioFormant format = audioStream.getFormat();
      DataLine.Info info = new DataLine.Info(Clip.class, format);
      Clip audioClip = (Clip) AudioSystem.getLine(info);

      audioClip.addLineListener(this);
      audioClip.open(audioStream);
      audioClip.start();

      while (!playCompleted)
      {
        // wait for the playback completes
        try {
          Thread.sleep(1000);
        } catch (InterruptedException ex){
          ex.printStackTrace();
        }
      }

      audioClip.close();

      } catch (UnsupportedAudioFileException ex) {
          System.out.println("The specified audio file is not supported.");
          ex.printStackTrace();
      } catch (LineUnavailableException ex) {
          System.out.println("Audio line for playing back is unavailable.");
          ex.printStackTrace();
      } catch (IOException ex) {
          System.out.println("Error playing the audio file.");
          ex.printStackTrace();
      }
    }

    @Override
    public void update(LineEvent event)
    {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.START)
        {
          System.out.println("Playback started.");
        }
        else if (type == LineEvent.Type.STOP)
        {
          playCompleted = true;
          System.out.println("Playback completed.");
        }
    }
  }
}

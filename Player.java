import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Player implements LineListener {

    boolean playCompleted;

    //play a single audio file
    void play(String audioFilePath) {
        File audioFile = new File(audioFilePath);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);

            audioClip.open(audioStream);

            audioClip.start();

            int n = 1;

            while(n == 1)
            {
              audioClip.start();

              try {
                  Thread.sleep(720);
              } catch (InterruptedException ex) {
                  ex.printStackTrace();
              }

              audioClip.stop();

              n--;
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

    //overridden play method to play a chord
    void play(String audioFilePath, String audioFilePath1) {
        File audioFile = new File(audioFilePath);
        File audioFile1 = new File(audioFilePath1);

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioInputStream audioStream1 = AudioSystem.getAudioInputStream(audioFile1);

            AudioFormat format = audioStream.getFormat();

            AudioFormat format1 = audioStream1.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            Clip audioClip1 = (Clip) AudioSystem.getLine(info);

            audioClip.addLineListener(this);

            audioClip1.addLineListener(this);

            audioClip.open(audioStream);

            audioClip1.open(audioStream1);
            int n = 1;
            while(n == 1)
            {
              audioClip.start();

              audioClip1.start();

              try {
                  Thread.sleep(720);
              } catch (InterruptedException ex) {
                  ex.printStackTrace();
              }

              audioClip.stop();

              n--;
            }

            audioClip.close();

            audioClip1.close();

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
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();

        if (type == LineEvent.Type.START) {
            System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
            System.out.println("Playback completed.");
        }

    }

}

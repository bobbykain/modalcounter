import java.io.*;
import java.lang.Math.*;

public class Analysis
{
  int[] numarr;
  int score = 0;

  public Analysis()
  {

  }
  public void printScore()
  {
    System.out.println("You got a score of " + score);
    score = 0;
  }
  public int[] convert(String[] notes)
  {
    numarr = new int[notes.length];
    int num;
    for(int i = 0; i < notes.length; i++)
    {
      num = converttonum(notes[i].charAt(0));
      if(notes[i].charAt(1) == '#')
      {
        num++;
        int octave = (int)notes[i].charAt(2);
        octave--;
        num = num + (octave * 12);
        numarr[i] = num;
      }
      if(notes[i].charAt(1) != '#')
      {
        int octave = Character.getNumericValue(notes[i].charAt(1));
        octave--;
        num = num + (octave * 12);
        numarr[i] = num;
      }
    }
    return numarr;

  }
  public int checkintervals(int[] a, int[] b)
  {
    for(int i = 0; i < a.length; i++)
    {
      int interval = Math.abs(a[i] - b[i]);
      if(interval == 1)
      {
        System.out.println("There is a minor second at position " + i);
        score--;
      }
      else if(interval == 2)
      {
        System.out.println("There is a major second at position " + i);
        score--;
      }
      else if(interval == 5)
      {
        System.out.println("There is a perect fourth at position " + i);
        score--;
      }
      else if(interval == 6)
      {
        System.out.println("There is a tritone at position " + i);
        score = score - 2;
      }
      else if(interval == 10)
      {
        System.out.println("There is a minor seventh at position " + i);
        score--;
      }
      else if(interval == 11)
      {
        System.out.println("There is a major seventh at position " + i);
        score--;
      }
      else if(interval > 16)
      {
        System.out.println("There is an interval that is greater than a 10th at position" + i);
        score--;
      }
      else
      {
        score++;
      }
    }
    return score;
  }
  public void checkleaps(int[] a)
  {
    int leaps = 0;
    int steps = 0;
    for(int i = 0; i < a.length - 1; i++)
    {
      if(Math.abs(a[i] - a[i+1]) > 2)
      {
        leaps++;
      }
      else
      {
        steps++;
      }
    }
    System.out.println("You had " + leaps + " leaps");
    System.out.println("You had " + steps + " steps");
    if(leaps > steps)
    {
      System.out.println("You should use more stepwise motion in your harmonizing, you had too many leaps in your melody.");
      score = score - 5;
    }
    else if(leaps == 0)
    {
      System.out.println("Unfortunately your melody is rather boring since it only contains stepwise motion.");
    }
    else
    {
      System.out.println("You had a good ratio of leaps to steps.");
      score = score + 5;
    }
  }
  public void checkpar(int[] a, int[] b)
  {
    for(int i = 0; i < a.length - 1; i++)
    {
      if((a[i] - a[i+1]) == (b[i] - b[i+1]))
      {
        if(Math.abs(a[i] - b[i]) == 0)
        {
          System.out.println("There is a parrallel unison starting at note " + i);
          score--;
        }
        if(Math.abs(a[i] - b[i]) == 7)
        {
          System.out.println("There is a parrallel fifth starting at note " + i);
          score--;
        }
        if(Math.abs(a[i] - b[i]) == 12)
        {
          System.out.println("There is a parrallel octave starting at note " + i);
          score--;
        }
      }
    }
  }
  public int converttonum(char x)
  {
    switch(x)
    {
      case 'A':
        return 1;
      case 'B':
        return 3;
      case 'C':
        return 4;
      case 'D':
        return 6;
      case 'E':
        return 8;
      case 'F':
        return 9;
      case 'G':
        return 11;
    }
    return 0;

  }
}

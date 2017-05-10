import java.io.*;
import java.lang.Math.*;

public class Analysis
{
  int[] numarr;
  int score = 0;

  public Analysis()
  {

  }
  /* the purpose of this method is to make calls to everysingle other method and make a huge sting of comments
  which will be shown within the Gui*/
  public String printScore(String[] a, String[] b)
  {
    String comscore = "";
    int[] num1 = convert(a);
    int[] num2 = convert(b);
    comscore += checkintervals(num1,num2);
    comscore += checkpar(num1, num2);
    comscore += checkleaps(num1) + "\n";
    comscore += "You got a score of " + score;
    score = 0;
    return comscore;
  }
  //converts the String[] into int[] making the math that must be done quite a lot easier to write code for.
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
  //checks the amount of distance between the intervals to ensure that the composer is not breaking the rules of
  //first species modal conterpoint.
  public String checkintervals(int[] a, int[] b)
  {
    String comments = "";
    for(int i = 0; i < a.length; i++)
    {
      int interval = Math.abs(a[i] - b[i]);
      if(interval == 1)
      {
        score--;
        comments += ("There is a minor second at position " + i + "\n");
      }
      else if(interval == 2)
      {
        comments += ("There is a major second at position " + i + "\n");
        score--;
      }
      else if(interval == 5)
      {
        comments += ("There is a perect fourth at position " + i + "\n");
        score--;
      }
      else if(interval == 6)
      {
        comments += ("There is a tritone at position " + i + "\n");
        score = score - 2;
      }
      else if(interval == 10)
      {
        comments += ("There is a minor seventh at position " + i + "\n");
        score--;
      }
      else if(interval == 11)
      {
        comments += ("There is a major seventh at position " + i + "\n");
        score--;
      }
      else if(interval > 16)
      {
        comments += ("There is an interval that is greater than a 10th at position " + i + "\n");
        score--;
      }
      else
      {
        score++;
      }

    }
    return comments;
  }
  //checks the ratio of leaps to steps
  public String checkleaps(int[] a)
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
      score = score - 5;
      return "You should use more stepwise motion in your harmonizing, you had too many leaps in your melody. + ";
    }
    else if(leaps == 0)
    {
      return "Unfortunately your melody is rather boring since it only contains stepwise motion.";
    }
    else
    {
      score = score + 5;
      return "You had a good ratio of leaps to steps.";


    }
  }

  //checks for parrallel octave, fifths and unisons.
  public String checkpar(int[] a, int[] b)
  {
    String comments = "";
    for(int i = 0; i < a.length - 1; i++)
    {
      if((a[i] - a[i+1]) == (b[i] - b[i+1]))
      {
        if(Math.abs(a[i] - b[i]) == 0)
        {
          score--;
          comments += ("There is a parrallel unison starting at note " + i + "\n");

        }
        if(Math.abs(a[i] - b[i]) == 7)
        {
          score--;
          comments += ("There is a parrallel fifth starting at note " + i + "\n");

        }
        if(Math.abs(a[i] - b[i]) == 12)
        {
          score--;
          comments += ("There is a parrallel octave starting at note " + i + "\n");

        }
      }
    }
    return comments;
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

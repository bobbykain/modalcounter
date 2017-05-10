import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class javafxtest extends Application implements EventHandler<ActionEvent>
{
  Stage window;
  Button button;
  double x = 0;
  double y = 0;
  String[] previous = new String[16];
  String[] current = new String[16];
  char octave = '1';
  int index = 0;
  String messenger = "";

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    for(int i = 0; i < 16;i++)
    {
      previous[i] = "i";
      current[i] = " ";
    }
    Image image = new Image(new FileInputStream("../modalcounter/background.png"));
    ImageView imageView = new ImageView(image);

    Group root = new Group(imageView);

    Text previousText = new Text();
    previousText.setFont(Font.font("times", FontWeight.BOLD, FontPosture.REGULAR, 23));
    String previousString = String.join(" ", previous);
    previousText.setText(previousString);
    previousText.setX(190);
    previousText.setY(391);

    Text currentText = new Text();
    currentText.setFont(Font.font("times", FontWeight.BOLD, FontPosture.REGULAR, 23));
    String currentString = String.join(" ", current);
    currentText.setText(currentString);
    currentText.setX(190);
    currentText.setY(461);

    Text message = new Text();
    message.setFont(Font.font("times", FontWeight.BOLD, FontPosture.REGULAR, 20));
    message.setText(messenger);
    message.setX(30);
    message.setY(500);

    root.getChildren().add(currentText);
    root.getChildren().add(previousText);
    root.getChildren().add(message);

    window = primaryStage;
    window.setTitle("Modal Counter Point");
    button = new Button("Click me");
    button.setOnAction(this);

    StackPane layout = new StackPane();
    layout.getChildren().add(button);
    Scene scene = new Scene(root, 1000, 800);


    imageView.setOnMouseClicked(e -> {
    System.out.println("["+e.getX()+", "+e.getY()+"]");
    x = e.getX();
    y = e.getY();
    selector(x,y);
    String currentString1 = String.join("-", current);
    currentText.setText(currentString1);
    String previousString1 = String.join("-", current);
    previousText.setText(previousString1);
    message.setText(messenger);



    //notes
  });
  window.setScene(scene);
  window.show();
  }

  @Override
  public void handle(ActionEvent event)
  {

  }
  public void selector(double x, double y)
  {
    //buttons
    if ((x > 825 && x < 950) && (y > 425 && y < 550))
    {
      System.out.println("Back pressed");
      index--;
      current[index] = " ";
    }
    if ((x > 825 && x < 950) && (y > 550 && y < 700))
    {
      System.out.println("Play pressed");
      if(index != 15)
      {
        System.out.println("Melody not long enough.");
      }
      else
      {

      }
    }
    if(index > 15)
    {
      messenger = "You can't add anymore notes";
    }
    //notes
    else if ((x > 140 && x < 175) && (y > 100 && y < 200))
    {
      System.out.println("C pressed");
      current[index] = "C" + octave;
      index++;
    }
    else if ((x > 175 && x < 250) && (y > 100 && y < 200))
    {
      System.out.println("C# pressed");
      current[index] = "C#" + octave;
      index++;
    }
    else if ((x > 250 && x < 310) && (y > 100 && y < 200))
    {
      System.out.println("D pressed");
      current[index] = "D" + octave;
      index++;
    }
    else if ((x > 310 && x < 375) && (y > 100 && y < 200))
    {
      System.out.println("D# pressed");
      current[index] = "D#" + octave;
      index++;
    }
    else if ((x > 375 && x < 425) && (y > 100 && y < 200))
    {
      System.out.println("E pressed");
      current[index] = "E" + octave;
      index++;
    }
    else if ((x > 425 && x < 475) && (y > 100 && y < 200))
    {
      System.out.println("F pressed");
      current[index] = "F" + octave;
      index++;
    }
    else if ((x > 475 && x < 525) && (y > 100 && y < 200))
    {
      System.out.println("F# pressed");
      current[index] = "F#" + octave;
      index++;
    }
    else if ((x > 525 && x < 600) && (y > 100 && y < 200))
    {
      System.out.println("G pressed");
      current[index] = "G" + octave;
      index++;
    }
    else if ((x > 600 && x < 650) && (y > 100 && y < 200))
    {
      System.out.println("G# pressed");
      current[index] = "G#" + octave;
      index++;
    }
    else if ((x > 650 && x < 725) && (y > 100 && y < 200))
    {
      System.out.println("A pressed");
      current[index] = "A" + octave;
      index++;
    }
    else if ((x > 725 && x < 775) && (y > 100 && y < 200))
    {
      System.out.println("A# pressed");
      current[index] = "A#" + octave;
      index++;
    }
    else if ((x > 775 && x < 825) && (y > 100 && y < 200))
    {
      System.out.println("B pressed");
      current[index] = "B" + octave;
      index++;
    }
    else if ((x > 825 && x < 900) && (y > 100 && y < 200))
    {
      System.out.println("C pressed");
      current[index] = "C" + octave;
      index++;
    }

    //octaves
    if ((x > 300 && x < 350) && (y > 250 && y < 300))
    {
      System.out.println("1 pressed");
      octave = '1';
    }
    if ((x > 350 && x < 450) && (y > 250 && y < 300))
    {
      System.out.println("2 pressed");
      octave = '2';
    }
    if ((x > 450 && x < 525) && (y > 250 && y < 300))
    {
      System.out.println("3 pressed");
      octave = '3';
    }
    if ((x > 525 && x < 600) && (y > 250 && y < 300))
    {
      System.out.println("4 pressed");
      octave = '4';
    }
    if ((x > 600 && x < 675) && (y > 250 && y < 300))
    {
      System.out.println("5 pressed");
      octave = '5';
    }

    if ((x > 750 && x < 950) && (y > 700 && y < 775))
    {
      System.out.println("Next pressed");
    }
  }
}

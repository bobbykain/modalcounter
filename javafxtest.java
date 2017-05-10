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
  String previous = "";
  String current = "";
  int octave = 1;

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception
  {
    Image image = new Image(new FileInputStream("../modalcounter/background.png"));
    ImageView imageView = new ImageView(image);

    imageView.setOnMouseClicked(e -> {
    System.out.println("["+e.getX()+", "+e.getY()+"]");
    x = e.getX();
    y = e.getY();

    //notes
    if ((x > 150 && x < 175) && (y > 100 && y < 175))
    {
      System.out.println("C pressed");
    }
    if ((x > 175 && x < 250) && (y > 100 && y < 175))
    {
      System.out.println("C# pressed");
    }
    if ((x > 250 && x < 300) && (y > 100 && y < 175))
    {
      System.out.println("D pressed");
    }
    if ((x > 300 && x < 375) && (y > 100 && y < 175))
    {
      System.out.println("D# pressed");
    }
    if ((x > 375 && x < 425) && (y > 100 && y < 175))
    {
      System.out.println("E pressed");
    }
    if ((x > 425 && x < 475) && (y > 100 && y < 175))
    {
      System.out.println("F pressed");
    }
    if ((x > 475 && x < 525) && (y > 100 && y < 175))
    {
      System.out.println("F# pressed");
    }
    if ((x > 525 && x < 600) && (y > 100 && y < 175))
    {
      System.out.println("G pressed");
    }
    if ((x > 600 && x < 650) && (y > 100 && y < 175))
    {
      System.out.println("G# pressed");
    }
    if ((x > 650 && x < 725) && (y > 100 && y < 175))
    {
      System.out.println("A pressed");
    }
    if ((x > 725 && x < 775) && (y > 100 && y < 175))
    {
      System.out.println("A# pressed");
    }
    if ((x > 775 && x < 825) && (y > 100 && y < 175))
    {
      System.out.println("B pressed");
    }
    if ((x > 825 && x < 900) && (y > 100 && y < 175))
    {
      System.out.println("C pressed");
    }

    //octaves
    if ((x > 300 && x < 350) && (y > 250 && y < 300))
    {
      System.out.println("1 pressed");
      octave = 1;
    }
    if ((x > 350 && x < 450) && (y > 250 && y < 300))
    {
      System.out.println("2 pressed");
      octave = 2;
    }
    if ((x > 450 && x < 525) && (y > 250 && y < 300))
    {
      System.out.println("3 pressed");
      octave = 3;
    }
    if ((x > 525 && x < 600) && (y > 250 && y < 300))
    {
      System.out.println("4 pressed");
      octave = 4;
    }
    if ((x > 600 && x < 675) && (y > 250 && y < 300))
    {
      System.out.println("5 pressed");
      octave = 5;
    }

    //buttons
    if ((x > 825 && x < 950) && (y > 425 && y < 550))
    {
      System.out.println("Back pressed");
    }
    if ((x > 825 && x < 950) && (y > 550 && y < 700))
    {
      System.out.println("Play pressed");
    }
    if ((x > 750 && x < 950) && (y > 700 && y < 775))
    {
      System.out.println("Next pressed");
    }
  });

  Group root = new Group(imageView);

  Text currentText = new Text();
  currentText.setText("Hello");
  currentText.setX(50);
  currentText.setY(130);

  Text previousText = new Text();
  previousText.setText("hi");
  previousText.setX(50);
  previousText.setY(400);

  root.getChildren().add(currentText);
  root.getChildren().add(previousText);

  window = primaryStage;
  window.setTitle("Modal Counter Point");
  button = new Button("Click me");
  button.setOnAction(this);

  StackPane layout = new StackPane();
  layout.getChildren().add(button);
  Scene scene = new Scene(root, 1000, 800);



  window.setScene(scene);
  window.show();
  }

  @Override
  public void handle(ActionEvent event)
  {

  }
}

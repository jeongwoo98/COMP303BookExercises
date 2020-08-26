package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/*
* Experimenting with GUI applications.
* From the Slides
* */
public class MyApplication extends Application {
    private static final int Width = 300;
    private static final int Height = 150;
    private static final int GAP = 10;
    private static final int MARGIN = 20;

    public static void main(String[] pArgs){
        launch(pArgs);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {    //Stage, GridPane and Scene
        primaryStage.setTitle("Jeongwoo's Text Display GUI");
        GridPane root = new GridPane();     //Create GridPane

        root.setHgap(GAP);      //Padding for the GridPane
        root.setVgap(GAP);
        root.setPadding(new Insets(MARGIN));

        Scene scene = new Scene(root, Width, Height);

        //Text object. This is where we will display the input text.
        Text aText = new Text();
        aText.setFont(new Font(20));
        aText.setWrappingWidth(Width-4*GAP);
        aText.setTextAlignment(TextAlignment.JUSTIFY);
        aText.setText("Waiting for your input.");

        //This is where we will input the text.
        TextField aTextInput = new TextField();
        aTextInput.setMinWidth(200);
        aTextInput.setText("Enter text here ....");

        //EVENT HANDLER!! .getText() retrieves the text inputted.
        aTextInput.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent)
            {
                aText.setText(aTextInput.getText());
            }
        });

        //Button object
        Button btn = new Button();
        btn.setLayoutX(100);
        btn.setLayoutY(80);
        btn.setText("Enter");
        btn.setOnAction(actionEvent -> aText.setText(aTextInput.getText()));


        root.add(aTextInput, 0,0,2,1);
        root.add(btn, 6,0,1,1);
        root.add(aText,0,3,4,1);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

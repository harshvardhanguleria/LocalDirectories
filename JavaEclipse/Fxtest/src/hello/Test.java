package hello;

import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class Test extends Application {
	private static Button button;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		Stage primaryStage = arg0;
		primaryStage.setTitle("Title of the Window");
        button = new Button();
        button.setText("Click me");
        // when the button is clicked this class is operating
        // button.setOnAction(this);
        /* button.setOnAction(new EventHandler<ActionEvent> () {
            @Override // using this anonymous inner class avoids checking the source of the click
            public void handle(ActionEvent event) {
                System.out.println("Button clicked");
            }
        });*/
        // doing the same thing using lambda expressions
        button.setOnAction(e -> primaryStage.close());
        /*
        button.setOnAction(e -> {
            System.out.println("Lambda expressions");
            System.out.println("For multiple lines");
        }); */

        StackPane layout = new StackPane();   // position the button in the middle
        layout.getChildren().add(button);

        Scene scene = new Scene(layout, 300, 250); // size of the Application window/stage
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}

package timetable;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;


public class TeacherChecking {


    private static int Numb;
    public static int Display(String title) {
        Stage window = new Stage();


        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        TextField numberInput = new TextField();

       // Label label = new Label("Teacher checking");
        Button SubmitButton = new Button("Submit");
        SubmitButton.setOnAction( e -> {
                    Numb = Integer.parseInt(numberInput.getText());
                    System.out.println("Number of teachers is : " + Numb);
                    window.close();
                }
        );
        VBox layout = new VBox(20);
        layout.getChildren().addAll(numberInput,SubmitButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return Numb;


    }
   /* public int isInt (TextField input, String message){
        try{
            Numb = Integer.parseInt(input.getText());
            System.out.println("Number of teachers is : " + Numb);
            return Numb;
        }catch(NumberFormatException e){
            System.out.println("Error: " + message + " is not a number");
            return 0;
        }
    } */
}

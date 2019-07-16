package timetable;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class NameSubjectChecking extends Schedule {

    private static Teacher newTeacher;

        public static Teacher GetData (String title) {
            Stage window = new Stage();




            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window.setMinWidth(250);

            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(5);
            grid.setHgap(5);
//Defining the Name text field
            final TextField name = new TextField();
            name.setPromptText("Enter subject");
            name.setPrefColumnCount(10);
            name.getText();
            GridPane.setConstraints(name, 0, 0);
            grid.getChildren().add(name);


            final TextField SubjectName= new TextField();
            SubjectName.setPromptText("Enter teachers name");
            GridPane.setConstraints(SubjectName, 0, 1);
            grid.getChildren().add(SubjectName);



            // Label label = new Label("Teacher checking");
            Button SubmitButton = new Button("Submit");
            GridPane.setConstraints(SubmitButton, 1, 0);

            SubmitButton.setOnAction( e -> {
                        if(name.getText() != null || !name.getText().isEmpty() || SubjectName.getText() !=null || !SubjectName.getText().isEmpty() ) {
                           newTeacher = createTeachers(name.getText(),SubjectName.getText());
                        }
                        else
                        {
                            System.out.println("VSE PLOXO");
                        }

                        window.close();
                    }
            );


            grid.getChildren().add(SubmitButton);
            //grid.setAlignment(Pos.CENTER);

            Scene scene = new Scene(grid);
            window.setScene(scene);
            window.showAndWait();
            return newTeacher;
        }

    }

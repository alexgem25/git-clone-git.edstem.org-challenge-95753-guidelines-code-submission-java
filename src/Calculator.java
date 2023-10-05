import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.application.*;
import javafx.event.*;

public class Calculator extends Application {
    public static void main(String[] args) { launch(args); }
    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;


    @Override
    public void start(Stage stage) throws Exception {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First Number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second Number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField();

        // 2. create the branch node
        GridPane grid = new GridPane();
        HBox box = new HBox(10);
        box.getChildren().addAll(addBtn, subBtn, mulBtn, divBtn);
        grid.add(firstNumberLbl, 0, 0);
        grid.add(firstNumberTf, 1, 0);
        grid.add(secondNumberLbl, 0, 1);
        grid.add(secondNumberTf, 1, 1);
        grid.add(operationLbl, 0, 2);
        grid.add(box, 1, 2);
        grid.add(resultLbl, 0, 3);
        grid.add(resultTf, 1, 3);

        addBtn.setOnAction(new AddHandler());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                setResult(getFirstNumber()-getSecondNumber());
            }});
        mulBtn.setOnAction(event -> setResult(getFirstNumber()*getSecondNumber()));
        divBtn.setOnAction(event -> setResult(getFirstNumber()/getSecondNumber()));

        // 3. set the scene, show the stage
        stage.setScene(new Scene(grid));
        stage.setTitle("Calculator");
        stage.show();
    }

        public int getFirstNumber() { 
            return Integer.parseInt(firstNumberTf.getText());
         }
        public int getSecondNumber() { 
            return Integer.parseInt(secondNumberTf.getText());
         }
        public void setResult(int value) { 
            resultTf.setText(Integer.toString(value));
        }

        private class AddHandler implements EventHandler<ActionEvent>{
            @Override
            public void handle(ActionEvent event){
                setResult(getFirstNumber()+getSecondNumber());
            }
        }

}
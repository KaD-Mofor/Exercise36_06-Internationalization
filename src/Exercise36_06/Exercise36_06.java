package Exercise36_06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class Exercise36_06 extends Application {

    //Combo box for locales
    private ComboBox<String> comboBox = new ComboBox<>();

    //Text fields for exchange rates and converted amount
    private TextField tfCanadianDollar = new TextField();
    private TextField tfEuro = new TextField();
    private TextField tfBritishPounds = new TextField();
    private TextField tfRateCD = new TextField("1.22");
    private TextField tfRateEuro = new TextField("0.84");
    private TextField tfRateBP = new TextField("0.74");

    //Text field for US Dollar
    private TextField tfUSDollar = new TextField();

    //Convert Button
    Button btnConvert = new Button("Convert");

    //Current locale
    private Locale localeCanada = Locale.CANADA;
    private Locale localeEuro = Locale.FRANCE;
    private Locale localeBritain = Locale.UK;
    @Override
    public void start(Stage primaryStage) throws Exception{

        //Grid pane for combo box
        GridPane pane1 = new GridPane();
        pane1.add(new Label("US Dollars: "),0,0);
        pane1.add(tfUSDollar,1,0);
        pane1.add(btnConvert,2,0);

        tfUSDollar.setPrefColumnCount(30);  //Set the length of the text field

        //Pane to hold the various fields
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(new Label("Enter Dollar Amount"), pane1 );

        //Grid pane for the exchange
        GridPane pane2 = new GridPane();
        pane2.add(new Label("Exchange Rate"),1,0);
        pane2.add(new Label("Converted Amount"),2,0);
        pane2.add(new Label("Canadian Dollars"),0,1);
        pane2.add(tfRateCD,1,1);
        pane2.add(tfCanadianDollar,2,1);
        pane2.add(new Label("Euro"),0,2);
        pane2.add(tfRateEuro,1,2);
        pane2.add(tfEuro,2,2);
        pane2.add(new Label("British Pounds"),0,3);
        pane2.add(tfRateBP,1,3);
        pane2.add(tfBritishPounds,2,3);

        //Setting field alignment
        tfUSDollar.setAlignment(Pos.CENTER_RIGHT);
        tfRateCD.setAlignment(Pos.CENTER_RIGHT);
        tfCanadianDollar.setAlignment(Pos.CENTER_RIGHT);
        tfRateEuro.setAlignment(Pos.CENTER_RIGHT);
        tfEuro.setAlignment(Pos.CENTER_RIGHT);
        tfRateBP.setAlignment(Pos.CENTER_RIGHT);
        tfBritishPounds.setAlignment(Pos.CENTER_RIGHT);

        //Setting text field column count
        tfRateCD.setPrefColumnCount(10);
        tfCanadianDollar.setPrefColumnCount(20);

        //Set editable false
        tfBritishPounds.setEditable(false);
        tfCanadianDollar.setEditable(false);
        tfEuro.setEditable(false);

        VBox vBox1 = new VBox(5);
        vBox1.getChildren().addAll(vBox,new Label("Display Exchange"), pane2);

        //Set scene in stage
        Scene scene = new Scene(vBox1, 500,200);
        primaryStage.setTitle("Exercise36_06");
        primaryStage.setScene(scene);
        primaryStage.show();

        //Register listeners
        btnConvert.setOnAction(e -> convertDollar());


    }

    //A function to convert the dollar entered
    private void convertDollar(){
        //Retrieve user input
        double dollarAmt = Double.parseDouble(tfUSDollar.getText());
        double cdRate = Double.parseDouble(tfRateCD.getText());
        double eRate = Double.parseDouble(tfRateEuro.getText());
        double bpRate = Double.parseDouble(tfRateBP.getText());

        //Convert dollar to different currencies
        double cDollars = dollarAmt * cdRate;
        double euro = dollarAmt * eRate;
        double bPounds = dollarAmt * bpRate;

        //Get number formatters
        NumberFormat currencyCanada = NumberFormat.getCurrencyInstance(localeCanada);
        NumberFormat currencyEuro = NumberFormat.getCurrencyInstance(localeEuro);
        NumberFormat currencyUK = NumberFormat.getCurrencyInstance(localeBritain);

        //Display formatted output
        tfCanadianDollar.setText(currencyCanada.format(cDollars));
        tfEuro.setText(currencyEuro.format(euro));
        tfBritishPounds.setText(currencyUK.format(bPounds));

    }
    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */

    public static void main(String[] args) {
        launch(args);
    }
}

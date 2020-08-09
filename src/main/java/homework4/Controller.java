package homework4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {


    @FXML
    TextArea mainTextAreaChat;
    @FXML
    TextArea mainText;
    @FXML
    Button mainTextAreaEnter;
    @FXML
    Button btnOneClickActionC;

    public void enterPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat( "E yyyy.MM.dd ' время' hh:mm:ss a zzz" );
            mainTextAreaChat.appendText( mainText.getText() + "\n" + formatForDateNow.format( dateNow ) + "\n" );
            mainText.clear();
        }
    }

    public void btnOneClickAction(ActionEvent actionEvent) {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat( "E yyyy.MM.dd ' время' hh:mm:ss a zzz" );
        mainTextAreaChat.appendText( mainText.getText() + "\n" + formatForDateNow.format( dateNow ) + "\n" );
        mainText.clear();
        mainText.requestFocus();
    }

    public void btnOneClickActionC() {
        mainTextAreaChat.clear();
    }

}

package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField textFieldUrl;
    @FXML TextField textFieldUser;
    @FXML PasswordField passwordFieldSenha;
    @FXML TextArea textAreaSql;
    @FXML ListView<String> historico;
    @FXML Label status;

    public void executar(){
        try{
            Connection con = DriverManager.getConnection(
                    textFieldUrl.getText(), 
                    textFieldUser.getText(), 
                    passwordFieldSenha.getText()
            );

            var comando = con.prepareStatement(textAreaSql.getText());
            comando.executeQuery();

            status.setText("Comando executado: " + textAreaSql.getText());
            con.close();

        }catch(SQLException e){
            status.setText("ERRO: " + e.getMessage());
        }
    }

}

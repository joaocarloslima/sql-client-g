package br.com.fiap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML TextField textFieldUrl;
    @FXML TextField textFieldUser;
    @FXML PasswordField passwordFieldSenha;
    @FXML TextArea textAreaSql;
    @FXML ListView<String> historico;
    @FXML Label status;
    @FXML TableView<ArrayList<String>> tabela;

    public void executar(){
        try{
            Connection con = DriverManager.getConnection(
                    textFieldUrl.getText(), 
                    textFieldUser.getText(), 
                    passwordFieldSenha.getText()
            );
            String sql = sanitizar(textAreaSql.getText());

            var comando = con.prepareStatement(sql);
            comando.execute();

            //if (sql.startsWith("SELECT")) carregarDadosNaTabela(resultado);

            status.setText("Comando executado: " + sql);
            historico.getItems().add(sql);
             con.close();

        }catch(Exception e){
            status.setText("ERRO: " + e.getMessage());
        }
    }

    private String sanitizar(String sql) {
        return sql.replaceAll(";", "").replaceAll("\"", "'");
    }

    public void resgatarHistorico(){
        var comando = historico.getSelectionModel().getSelectedItem();
        textAreaSql.setText(comando);
    }

    private void carregarDadosNaTabela(ResultSet resultado){

    }

}

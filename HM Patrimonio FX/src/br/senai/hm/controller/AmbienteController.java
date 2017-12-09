package br.senai.hm.controller;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AmbienteController implements Initializable {

	private static final Effect Glow = new Glow(1.0);
	private static final Effect Glow1 = new Glow(0.0);

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	private Button btnGestor;
	@FXML
	private ImageView btnBuscarDesc;


	public void addGestor(ActionEvent event){

		try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Usuario.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			Main.getStage().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void buscarDescricao(MouseEvent event){

		/*try {
			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/Usuario.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

			Main.getStage().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		System.out.println("ok");
	}

	public void mudarGlow(MouseEvent event){
		btnBuscarDesc.setEffect(Glow);
	}

	public void normalizar(MouseEvent event){
		btnBuscarDesc.setEffect(Glow1);
	}

}

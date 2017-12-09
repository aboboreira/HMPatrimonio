package br.senai.hm.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import application.Main;
import br.senai.hm.modelo.Estados;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EmpresaController implements Initializable {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//
	}

	@FXML
	private Button btnNovo;

	@FXML
	private Button btnSair;

	@FXML
	private Button btnEscolher;

	@FXML
	private ImageView imgLogo = new ImageView();

	@FXML
	private TextField txfCnpj;
	@FXML
	private TextField txfRazao;
	@FXML
	private TextField txfNome;
	@FXML
	private TextField txfEndereco;
	@FXML
	private TextField txfCidade;
	@FXML
	private TextField txfCep;
	@FXML
	private TextField txfPais;
	@FXML
	private TextField txfTelefone;
	@FXML
	private TextField txfEmail;

	@FXML
	private ComboBox<Estados> cmbEstado =  new ComboBox<>(
            FXCollections.observableArrayList(
                    Estados.values()
            )
    );




	public void limpar(ActionEvent event) {
		txfCnpj.setText(" ");
		txfRazao.setText(" ");
		txfNome.setText(" ");
		txfEndereco.setText(" ");
		txfCidade.setText(" ");
		txfCep.setText(" ");
		txfPais.setText(" ");
		txfTelefone.setText(" ");
		txfEmail.setText(" ");
		imgLogo.setImage(null);
		cmbEstado.setItems(FXCollections.observableArrayList(Estados.values()));
	}

	public void sair(ActionEvent event) {
		Stage stage = new Stage();
		Main.getStage().close();
	}

	public void escolherImagem(ActionEvent event) {

		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg",
				"*.gif");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(Main.getStage());
		System.out.println(file);

		try {
			BufferedImage bufferedImage = ImageIO.read(file);
			Image image = SwingFXUtils.toFXImage(bufferedImage, null);
			imgLogo.setId(null);
			imgLogo.setImage(image);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}

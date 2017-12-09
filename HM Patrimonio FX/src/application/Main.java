package application;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.senai.hm.modelo.Estados;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;


public class Main extends Application {


	private static Stage stage;
	private Parent rootLayout;

	@FXML
	private ComboBox<Estados> cmbEstado ;

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.stage = primaryStage;
		this.stage.setTitle("Cadastro de Empresa");
		this.stage.getIcons().add(new Image("file:resources/imagens/hm.png"));

		initRootLayout();

		}

	public void initRootLayout() {
        try {
        	// Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/application/Empresa.fxml"));
            rootLayout = (Parent) loader.load();
            // Mostra a scene (cena) contendo oroot layout.
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
           // Main.stage = stage;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hm_patrimonio");
		EntityManager manager = factory.createEntityManager();
		launch(args);

	}
	public static Stage getStage(){
		return stage;
	}


}

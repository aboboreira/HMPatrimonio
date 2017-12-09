package br.senai.hm.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import application.Main;
import br.senai.hm.dao.AgendamentoDAO;
import br.senai.hm.dao.CategoriaDAO;
import br.senai.hm.dao.ModeloDAO;
import br.senai.hm.dao.MovimentacaoDAO;
import br.senai.hm.dao.PatrimonioDAO;
import br.senai.hm.dao.TransferenciaDAO;
import br.senai.hm.modelo.Agendamento;
import br.senai.hm.modelo.Categoria;
import br.senai.hm.modelo.Modelo;
import br.senai.hm.modelo.Movimentacao;
import br.senai.hm.modelo.Patrimonio;
import br.senai.hm.modelo.Transferencia;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class MenuPrincipalController implements Initializable {

	@FXML
	private TreeView<String> tree;
	private PatrimonioDAO daop;
	private CategoriaDAO daoc;
	private ModeloDAO daom;
	private MovimentacaoDAO daomv;
	private static Stage stagePrincipal;
	private TransferenciaDAO daot;
	private AgendamentoDAO daoag;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		createTree();
		daoc = new CategoriaDAO();
		daop = new PatrimonioDAO();
		daom = new ModeloDAO();
		daomv = new MovimentacaoDAO();
		daot = new TransferenciaDAO();
		daoag = new AgendamentoDAO();
	}

	public MenuPrincipalController() {
		stagePrincipal = Main.getStage();
	}

	public void createTree(String... rootItems) {
		// create root
		TreeItem<String> root, empresa, patrimonio, conferencia, transferencia, relatorio;
		root = new TreeItem<String>();
		root.setExpanded(true);

		empresa = makeBranch("Empresa", root);
		makeBranch("Cadastrar Empresa", empresa);
		makeBranch("Manter Usu�rio", empresa);
		makeBranch("Manter Ambiente", empresa);

		patrimonio = makeBranch("Patrim�nio", root);
		makeBranch("Manter Categoria", patrimonio);
		makeBranch("Manter Fornecedor", patrimonio);
		makeBranch("Manter Modelo", patrimonio);
		makeBranch("Manter Patrim�nio", patrimonio);
		makeBranch("Listar Patrim�nio", patrimonio);

		conferencia = makeBranch("Confer�ncia", root);
		makeBranch("Agendar Confer�ncia", conferencia);
		makeBranch("Consultar Confer�ncia", conferencia);

		transferencia = makeBranch("Transfer�ncia", root);
		makeBranch("Realizar Transfer�ncia", transferencia);
		makeBranch("Consultar Transfer�ncia", transferencia);

		relatorio = makeBranch("Relat�rio", root);
		makeBranch("Etiquetas", relatorio);
		makeBranch("Patrim�nio da Empresa", relatorio);
		makeBranch("Patrim�nio do Ambiente", relatorio);
		makeBranch("Categoria", relatorio);
		makeBranch("Modelo", relatorio);
		makeBranch("Movimenta��es", relatorio);
		makeBranch("Transfer�ncias", relatorio);

		tree.setShowRoot(false);
		tree.setRoot(root);
	}

	public TreeItem<String> makeBranch(String titulo, TreeItem<String> raiz) {
		TreeItem<String> item = new TreeItem<>(titulo);
		item.setExpanded(true);
		raiz.getChildren().add(item);
		return item;
	}

	public void selectItem(MouseEvent event) throws IOException {
		if (tree.getFocusModel().getFocusedItem() != null) {
			TreeItem<String> item = tree.getFocusModel().getFocusedItem();
			System.out.println(item.getValue());
			String titulo = null;
			if (item.getValue().equals("Manter Modelo")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Modelo.fxml"));
				titulo = "Cadastro de Modelo";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Manter Categoria")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Categoria.fxml"));
				titulo = "Cadastro de  Categoria";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Manter Fornecedor")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Fornecedor.fxml"));
				titulo = "Cadastro de Fornecedor";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Manter Patrim�nio")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Patrimonio.fxml"));
				titulo = "Cadastro de  Patrim�nio";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Listar Patrim�nio")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Listar_Patrimonio.fxml"));
				titulo = "Lista de Patrim�nio";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Manter Ambiente")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Ambiente.fxml"));
				titulo = "Cadastro de  Ambiente";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Manter Usu�rio")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Usuario.fxml"));
				titulo = "Cadastro de  Usu�rio";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Cadastrar Empresa")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Empresa.fxml"));
				titulo = "Cadastro de  Empresa";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Agendar Confer�ncia")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Agendamento.fxml"));
				titulo = "Agendar Confer�ncia";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Consultar Confer�ncia")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Conferencia.fxml"));
				titulo = "Consultar Confer�ncia";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Realizar Transfer�ncia")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Realizar_Transferencia.fxml"));
				titulo = "Realizar Transfer�ncia";
				abrirPainel(parent, titulo);

			} else if (item.getValue().equals("Consultar Transfer�ncia")) {
				Parent parent = FXMLLoader.load(getClass().getResource("/views/Registro_Transferencia.fxml"));
				titulo = "Consultar Transfer�ncia";
				abrirPainel(parent, titulo);
			} else if (item.getValue().equals("Etiquetas")) {
				relatorioEtiquetas();
			} else if (item.getValue().equals("Patrim�nio da Empresa")) {
				relatorioEmpresa();
			} else if (item.getValue().equals("Patrim�nio do Ambiente")) {
				relatorioAmbiente();
			} else if (item.getValue().equals("Categoria")) {
				relatorioCategoria();
			} else if (item.getValue().equals("Modelo")) {
				relatorioModelo();
			} else if (item.getValue().equals("Movimenta��es")) {
				relatorioMovimentacoes();
			} else if (item.getValue().equals("Transfer�ncias")) {
				relatorioTransferencia();
			} else if (item.getValue().equals("Agendamentos de Conferencias")) {
				relatorioAgendatamento();
			}
		}
	}

	public void abrirPainel(Parent root, String titulo) {
		try {
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle(titulo);
			stage.setResizable(false);
			stage.getIcons().add(new Image("resource/imagens/hm.png"));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void relatorioEmpresa() {
		List<Patrimonio> lista = daop.buscarTodosOrdenado();
		System.out.println(lista.get(0).getComponente());
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioEmpresa.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioEtiquetas() {
		List<Patrimonio> lista = daop.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/etiquetas.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioAmbiente() {
		Stage stage = new Stage();
		Parent parent;
		try {
			parent = FXMLLoader.load(getClass().getResource("/views/RelatorioAmbiente.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void relatorioCategoria() {
		List<Categoria> lista = daoc.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioCategoria.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioModelo() {
		List<Modelo> lista = daom.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioModelo.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioMovimentacoes() {
		List<Movimentacao> lista = daomv.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioMovimentacoes.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioTransferencia() {
		List<Transferencia> lista = daot.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioTransferencia.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public void relatorioAgendatamento() {
		List<Agendamento> lista = daoag.buscarTodos();
		try {
			JasperReport pathjrxml = JasperCompileManager.compileReport(getClass().getResourceAsStream("/rels/relatorioAgendamento.jrxml"));
			JasperPrint jpPrint = JasperFillManager.fillReport(pathjrxml, null,
					new JRBeanCollectionDataSource(lista, false));
			JasperViewer jv = new JasperViewer(jpPrint, false);
			jv.setVisible(true);
			jv.setTitle("Relat�rio");
		} catch (JRException e1) {
			e1.printStackTrace();
		}
	}

	public static Stage getStage() {
		return stagePrincipal;
	}
}

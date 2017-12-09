package br.senai.hm.util;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Mensagens {

	public Mensagens() {
		super();
	}

	public static void mostrarMsg0() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("Senha e Confirma��o de Senha n�o conferem.");
		alert.showAndWait();
	}

	public static void mostrarMsg1() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Sucesso");
		alert.setHeaderText(null);
		alert.setContentText("Registro salvo com sucesso.");
		alert.showAndWait();
	}

	public static void mostrarMsg2() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Verifique os dados");
		alert.setHeaderText(null);
		alert.setContentText("Email inv�lido.");
		alert.showAndWait();
	}

	public static void mostrarMsg3() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Verifique os dados");
		alert.setHeaderText(null);
		alert.setContentText("Existem campos em braco que devem ser preeenchidos.");
		alert.showAndWait();
	}

	public static void mostrarMsg4() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pesquisa");
		alert.setHeaderText(null);
		alert.setContentText("Informe dados para realizar a pesquisa.");
		alert.showAndWait();
	}

	public static boolean mostrarMsg5() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirma��o");
		alert.setHeaderText(null);
		alert.setContentText(
				"Deseja realmente inativar o registro selecionado? A altera��o realizada ser� permanente!");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}

	public static boolean mostrarMsg5a() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirma��o");
		alert.setHeaderText(null);
		alert.setContentText(
				"Deseja realmente inativar o registro selecionado?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}
	public static void mostrarMsg6() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Selecione registro");
		alert.setHeaderText(null);
		alert.setContentText("Nenhum registro selecionado, por favor, selecione um registro e tente novamente.");
		alert.showAndWait();
	}

	public static void mostrarMsg7() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Registro inv�lido");
		alert.setHeaderText(null);
		alert.setContentText("O registro selecionado n�o pode ser alterado.");
		alert.showAndWait();
	}

	public static void mostrarMsg8() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("N�o existe registro na lista");
		alert.setHeaderText(null);
		alert.setContentText("N�o existe patri�nio nesse ambiente");
		alert.showAndWait();
	}

	public static void mostrarMsg9() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("N�o foi poss�vel realizar opera��o, verique todas as informa��es e tente novamente.");
		alert.showAndWait();
	}

	public static void mostrarMsg10() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("N�o foi selecionado nenhum patrim�nio.");
		alert.showAndWait();
	}

	public static boolean mostrarMsg11() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirma��o");
		alert.setHeaderText(null);
		alert.setContentText(
				"S� � poss�vel inativar um patrim�nio em situa��o de transfer�ncia. Deseja transferir um patrim�nio?");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}

	public static boolean mostrarMsg12() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Aten��o");
		alert.setHeaderText(null);
		alert.setContentText(
				"Se este patrim�nio est� sendo ativado, significa que ele retornou de uma transfer�ncia, para proseguir clique em"+" OK"+".");

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			return true;
		}
		return false;
	}

	public static void mostrarMsg13() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("N�o foi poss�vel registrar este usu�rio, o login desejado j� est� atribuido, por favor tente outro!");
		alert.showAndWait();
	}

	public static void mostrarMsg14() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText("N�o foi poss�vel agendar a confer�ncia");
		alert.setContentText("A data de agendamento n�o pode ser anterior � data atual!");
		alert.showAndWait();
	}

	public static void mostrarMsg14a() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText("N�o foi poss�vel cadastrar o patrim�nio");
		alert.setContentText("A data de cadastro n�o pode ser posterior � data atual!");
		alert.showAndWait();
	}

	public static void mostrarMsg15() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText("N�o foi poss�vel agendar a confer�ncia");
		alert.setContentText("Esse ambiente possui uma confer�ncia pendente.");
		alert.showAndWait();
	}

	public static void mostrarMsg16() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Lembre enviado");
		alert.setHeaderText(null);
		alert.setContentText("O lembrete de senha enviado, verifique seu email.");
		alert.showAndWait();
}


	public static void mostrarMsg16a() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("Falha ao enviar E-mail, por favor entre em contato com o admnistrador do banco de dados e solicite sua senha.");
		alert.showAndWait();
	}

	public static void mostrarMsg17() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("N�o foi pos�vel registrar");
		alert.setHeaderText(null);
		alert.setContentText("O gestor desejado j� gerencia outro ambiente, sendo assim, escolha outro.");
		alert.showAndWait();
	}

	public static void mostrarMsg18() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("N�o foi poss�vel exibir");
		alert.setHeaderText(null);
		alert.setContentText("A confer�ncia selelionada ainda n�o foi realizada.");
		alert.showAndWait();
	}
	public static void mostrarMsg19() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("Falha ao cadastrar os patrim�nios, por favor verifique se h� N.I. vagos.");
		alert.showAndWait();
	}
	public static void mostrarMsg20() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Erro em opera��o");
		alert.setHeaderText(null);
		alert.setContentText("Falha ao cadastrar os patrim�nios, Quantidade n�o pode ser 0.");
		alert.showAndWait();
	}

}

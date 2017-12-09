package br.senai.hm.modelo;

public enum Estados{
	ACRE("Acre"), ALAGOAS("Alagoas"), AMAPA("Amp�"), AMAZONAS("Amazonas"), BAHIA("Bahia"),
	CEARA("Cear�"), DISTRITO("Distrito Federal"),
	ESPITIROSANTO("Esp�tiro Santo"), GOIAS("Goi�s"), MATOGROSSO("Mato Grosso"),
	MATOGROSSOSUL("Mato Grosso do Sul"), MINASGERAIS("Mina Gerais"),
	PARA("Par�"), PARAIBA("Para�ba"), PARANA("Paran�"), PERNAMBUCO("Pernambuco"),
	PIAUI("Piau�"), RIOJANEIRO("Rio de Janeiro"), RGNORTE("Rio Grande do Norte"),
	RGSUL("Rio Grande do Sul"), RONDONIA("Rondonia"), RORAIMA("Roraima"),
	SANTACATARINA("Santa Catarina"), SAOPAULO("S�o Paulo"), SERGIPE("Sergipe"),
	TOCANTINS("Tocantins");

	private String descricao;

	private Estados(String descricao){
		this.descricao = descricao;
	}

	@Override
	public String toString() {

		return this.descricao;
	}

}


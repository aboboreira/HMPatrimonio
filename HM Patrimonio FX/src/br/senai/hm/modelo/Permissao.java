package br.senai.hm.modelo;

public enum Permissao {

	ND(""), NOVO("Administrador"), SEMINOVO("Gestor");

	private String descricao;

	private Permissao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return this.descricao;
	}

}

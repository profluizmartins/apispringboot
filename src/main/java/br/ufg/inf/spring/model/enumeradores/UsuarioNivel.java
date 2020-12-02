package br.ufg.inf.spring.model.enumeradores;

public enum UsuarioNivel {
	ADMIN(1, "Administrador"),
	GESTOR(2, "Gestor"),
	COMUM(3, "Comum");

	private int id;
	private String desc;
	
	
	UsuarioNivel(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}

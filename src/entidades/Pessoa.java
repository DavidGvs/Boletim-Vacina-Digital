package entidades;

public class Pessoa {

	private String nome, sexo;
	private Integer idade;
	private boolean engravidou;
	
	public Pessoa() {
	}
	
	public Pessoa(String nome, Integer idade) {
	}

	public Pessoa(String nome, String sexo, Integer idade, boolean engravidou) {
		this.nome = nome;
		this.sexo = sexo;
		this.idade = idade;
		this.engravidou = engravidou;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public boolean isEngravidou() {
		return engravidou;
	}

	public void setEngravidou(boolean engravidou) {
		this.engravidou = engravidou;
	}
	
	
}

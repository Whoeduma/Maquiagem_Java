package crud;

public class Maquiagem {
	private int id; //n de identificacao da maquiagem
	private String marca, tipo, cor ; // nome (ex: Elf), tipo (ex: Base), Cor da maquiagem (ex: Faire)
	
	//adiciona o construtor
	public Maquiagem(int id, String marca, String tipo, String cor) {
		this.id = id; // atributo da classe 
		this.marca = marca;
		this.tipo = tipo;
		this.cor = cor;
	}
	// get - acessar os valores dos atributos
	public int getId() { return id; }
	public String getMarca() {return marca;}
	public String getTipo() {return tipo;}
	public String getCor() {return cor;}
	
	//set - altera os valores
	public void setMarca(String marca) {this.marca = marca;}
	public void setTipo(String tipo) {this.tipo = tipo;}
	public void setCor(String cor) {this.cor = cor;}
	
	//toString - transforma a maquiagem em uma linha de texto com separador ";"
	@Override
	public String toString() {
		return id + ";" + marca + ";" + tipo + ";" + cor;
	}
	
	//fromString - recebe uma linha de texto e cria uma maquiagem a partir dela
	public static Maquiagem fromString(String linha) {
		//Divide a linha em partes, usando o ";" como separador
		String[] partes = linha.split(";");
		
		 // Cria e retorna uma nova maquiagem usando os valores extraídos da linha
		return new Maquiagem(
				Integer.parseInt(partes[0]),//converte o ID de texto para numero
				partes[1], //marca
				partes[2], //tipo
				partes[3] //cor 
				);
	}
	
}

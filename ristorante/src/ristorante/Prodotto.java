package ristorante;

public class Prodotto {
	
	private String nome;
	private double prezzo;
	private EnumProdotto tipoProdotto;
	
	public Prodotto(String nome, double prezzo, EnumProdotto tipoProdotto) {
		this.nome = nome;
		this.prezzo = prezzo;
		this.tipoProdotto = tipoProdotto;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public EnumProdotto getTipoProdotto() {
		return this.tipoProdotto;
	}

	public void setTipoProdotto(EnumProdotto tipoProdotto) {
		this.tipoProdotto = tipoProdotto;
	}
	
	@Override
	public String toString() {
		return "Ordine: " + nome+ "\t"+ prezzo +"";
	}
	

}

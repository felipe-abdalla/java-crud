class Produto {
	private int id;
	private String descricao;
	private float preco;

	public Produto(String descricao, float preco) {
		this.descricao = descricao;
		this.preco = preco;
	}

	public Produto(int id, String descricao, float preco) {
		this(descricao, preco);
		this.id = id;
	}

	public String getDescricao() {
		return (descricao);
	}

	public float getPreco() {
		return (preco);
	}

	public String listar() {
		return ("Id: " + id + "\nDescricao: " + descricao + "\nPreco: " + preco);
	}
}
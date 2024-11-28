import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.io.UnsupportedEncodingException;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JOptionPane;

class Principal {
	public static void main(String[] args) throws UnsupportedEncodingException {
		int action;
		action = Integer.parseInt(JOptionPane.showInputDialog("1. Inserir dados.\n2. Alterar dados.\n3. Remover dados.\n4. Exibir dados\nDigite o numero da acao que deseja realizar: ", JOptionPane.QUESTION_MESSAGE));
		inserirDados("Feijão", 22.49f);
		List<Produto> produtos = listarDados();

		String todosProdutos = "";
		for (Produto produto : produtos)
			todosProdutos += produto.listar() + "\n\n";
		JOptionPane.showMessageDialog(null, todosProdutos);
	}

	private static List<Produto> listarDados() {
		List<Produto> produtos = new ArrayList<>();
		Connection conexao = null;
		Statement statement = null;
		ResultSet conjuntoDados = null;

		try {
		    conexao = DriverManager.getConnection("jdbc:mysql://localhost/MERCADO?" + "user=mercado&password=123456");
		    statement = conexao.createStatement();
    		conjuntoDados = statement.executeQuery("SELECT PROD_ID_PRODUTO, PROD_TX_DESCRICAO, PROD_VL_PRECO FROM PRODUTO");

    		if (conjuntoDados != null)
    			while (conjuntoDados.next())
    				produtos.add(new Produto(conjuntoDados.getInt("PROD_ID_PRODUTO"), conjuntoDados.getString("PROD_TX_DESCRICAO"), conjuntoDados.getFloat("PROD_VL_PRECO")));
		} 
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}

		return (produtos);
	}

	private static void inserirDados(String nomeProduto, float valorProduto) throws UnsupportedEncodingException {
		Connection conexao = null;
		Statement statement = null;

		List<Produto> produtos = new ArrayList<>();
		produtos.add(new Produto("Arroz", 22.90f));
		produtos.add(new Produto("Frango", 20.0f));

		try {
		    conexao = DriverManager.getConnection("jdbc:mysql://localhost/MERCADO?" + "user=mercado&password=123456&characterEncoding=UTF-8");
		    statement = conexao.createStatement();
		    for (Produto produto : produtos)
		    	statement.execute("INSERT INTO PRODUTO (PROD_TX_DESCRICAO, PROD_VL_PRECO) VALUES ('" + new String(produto.getDescricao().getBytes("ISO-8859-1"), "UTF-8") + "', " + produto.getPreco() + ")");
		} 
		catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}
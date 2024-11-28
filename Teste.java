import javax.swing.JOptionPane;

class Teste {
	public static void main(String[] args) {
		int idade;
		try {
			idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a sua idade: "));
			JOptionPane.showMessageDialog(null, "A sua idade e: " + idade + ".", "Excecao", JOptionPane.PLAIN_MESSAGE);
		}
		catch (NumberFormatException excecao) {
			JOptionPane.showMessageDialog(null, "Erro de tipo de dado.", "Excecao", JOptionPane.ERROR_MESSAGE);
		}
	}
}
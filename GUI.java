import javax.swing.JOptionPane;

class GUI {
    int action;
    public GUI (int action) {
        this.action = action;
    }

    public void insertAction(int action) {
        try {
            
            
        }
        catch (NumberFormatException excecao) {
            JOptionPane.showMessageDialog(null, "Erro de tipo de dado.", "Excecao", JOptionPane.ERROR_MESSAGE);
        }
    }
}
    
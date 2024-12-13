package Controller.Helper;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Multa;
import view.TelaGestaoMulta;

public class TelaGestaoMultaHelper {

    private final TelaGestaoMulta view;

    public TelaGestaoMultaHelper(TelaGestaoMulta view) {
        this.view = view;
    }

        public void preencherTabela(List<Multa> multas) {
           DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
           model.setRowCount(0); // Limpar a tabela antes de preencher com os novos dados

           // Percorrer a lista de multas e preencher a tabela
           for (Multa multa : multas) {
               model.addRow(new Object[]{
                   multa.getId(),
                   multa.getUsuarioId(),
                   multa.getValor(),
                   // Formatar a data para o formato dd/MM/yyyy para exibição
                   new SimpleDateFormat("dd/MM/yyyy").format(multa.getDataMulta()), // Formato adequado para exibição
                   multa.getStatus()
               });
           }
        }
        public Multa obterMultaSelecionada() {
            int linhaSelecionada = view.getjTable1().getSelectedRow(); // Obtém a linha selecionada
            if (linhaSelecionada != -1) {
                // Obtém os dados da linha selecionada e cria um objeto Multa com esses dados
                DefaultTableModel model = (DefaultTableModel) view.getjTable1().getModel();
                int id = (int) model.getValueAt(linhaSelecionada, 0);
                int idUsuario = (int) model.getValueAt(linhaSelecionada, 1);
                double valor = (double) model.getValueAt(linhaSelecionada, 2);
                // Convertendo a data da tabela para o formato Date
                String dataMultaStr = (String) model.getValueAt(linhaSelecionada, 3);
                String status = (String) model.getValueAt(linhaSelecionada, 4);

                // Converter a data no formato dd/MM/yyyy para Date
                java.util.Date dataMulta = null;
                try {
                    dataMulta = new SimpleDateFormat("dd/MM/yyyy").parse(dataMultaStr); // Usando dd/MM/yyyy
                } catch (Exception e) {
                    e.printStackTrace();  // Em caso de erro na conversão
                }

                // Retorna a multa selecionada com os dados da tabela
                return new Multa(id, idUsuario, valor, dataMulta, status);
            }
            return null; // Nenhuma linha selecionada
        }

}

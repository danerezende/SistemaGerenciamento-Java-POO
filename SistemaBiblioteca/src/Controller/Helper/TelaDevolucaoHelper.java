package Controller.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import model.Emprestimo;
import model.Multa;
import view.TelaDevolucao;

public class TelaDevolucaoHelper {

    private final TelaDevolucao view;

    public TelaDevolucaoHelper(TelaDevolucao view) {
        this.view = view;
    }

    // Obter dados do modelo Emprestimo a partir da View
    public Emprestimo obterModeloEmprestimo() throws ParseException {
        int livroId = Integer.parseInt(view.getTextLivroId().getText().trim());
        int usuarioId = Integer.parseInt(view.getTextUsuarioId().getText().trim());

        // Formatar datas
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataEmprestimo = sdf.parse(view.getTextDataEmprestimo().getText().trim());
        Date dataDevolucao = sdf.parse(view.getTextDataDevolucao().getText().trim());

        return new Emprestimo(0, livroId, usuarioId, dataEmprestimo, dataDevolucao, true);
    }

    // Obter dados do modelo Multa
    public Multa obterModeloMulta(double valor) throws ParseException {
        int usuarioId = Integer.parseInt(view.getTextUsuarioId().getText().trim());
        Date dataMulta = new SimpleDateFormat("dd/MM/yyyy").parse(view.getTextDataDevolucao().getText().trim());

        return new Multa(usuarioId, valor, dataMulta);
    }

    // Configurar valores na View a partir de um modelo Emprestimo
    public void setarModeloEmprestimo(Emprestimo modelo) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        view.getTextLivroId().setText(String.valueOf(modelo.getLivroId()));
        view.getTextUsuarioId().setText(String.valueOf(modelo.getUsuarioId()));
        view.getTextDataEmprestimo().setText(sdf.format(modelo.getDataEmprestimo()));
        view.getTextDataDevolucao().setText(sdf.format(modelo.getDataDevolucao()));
    }

    // Limpar os campos da tela
    public void limparTela() {
        view.getTextLivroId().setText("");
        view.getTextUsuarioId().setText("");
        view.getTextDataEmprestimo().setText("");
        view.getTextDataDevolucao().setText("");
        view.getTextMulta().setText("");
    }

    // Calcular multa com base no atraso
    public double calcularMulta(Date dataEmprestimo, Date dataDevolucao) {
        final int PRAZO_DIAS = 7; // Prazo padrão para devolução
        final double MULTA_DIARIA = 2.0; // Multa diária por atraso

        try {
            // Converter Date para LocalDate
            LocalDate dataEmprestimoLocal = dataEmprestimo.toInstant()
                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();
            LocalDate dataDevolucaoLocal = dataDevolucao.toInstant()
                .atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            // Dias entre a data de devolução e a data de empréstimo
            long diasEntreDatas = ChronoUnit.DAYS.between(dataEmprestimoLocal, dataDevolucaoLocal);

            // Verificar atraso em relação ao prazo
            long diasAtraso = diasEntreDatas - PRAZO_DIAS;

            // Calcular multa se houver atraso
            return diasAtraso > 0 ? diasAtraso * MULTA_DIARIA : 0.0;
        } catch (Exception e) {
            System.err.println("Erro ao calcular multa: " + e.getMessage());
            return 0.0;
        }
    }
}

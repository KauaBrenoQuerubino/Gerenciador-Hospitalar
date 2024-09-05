package dominio.GerencaimentoPacientes;

import SQLconnection.SQL;

import java.sql.SQLException;

public class HistoricoMedico {
    //Cadastro de informações pessoais

    //Histórico Médico
    SQL sql = new SQL();
    private String historicoDeDoencas;
    private String cirurgias;
    private String tratamentosAnteriores;

    public HistoricoMedico(String cpf, String historicoDeDoencas, String cirurgias, String tratamentosAnteriores) {
        this.historicoDeDoencas = historicoDeDoencas;
        this.cirurgias = cirurgias;
        this.tratamentosAnteriores = tratamentosAnteriores;
        sql.conexaoComDB();
        try {
            sql.historicoMedico(sql.verificarCPF(cpf, "históricomédico"), historicoDeDoencas , cirurgias, tratamentosAnteriores);
        } catch (SQLException e) {
            System.err.println("Error ao adicionar ao banco" + e.getMessage());
        }
    }

    public String getHistoricoDeDoencas() {
        return historicoDeDoencas;
    }

    public void setHistoricoDeDoencas(String historicoDeDoencas) {
        this.historicoDeDoencas = historicoDeDoencas;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getTratamentosAnteriores() {
        return tratamentosAnteriores;
    }

    public void setTratamentosAnteriores(String tratamentosAnteriores) {
        this.tratamentosAnteriores = tratamentosAnteriores;
    }
}

package dominio.GestãoInternações;

import SQLconnection.SQL;

import java.sql.SQLException;

public class ControleAdmissões {
    //Registro de Admissão

    SQL sql = new SQL();
    private String CPFpaciente;
    private String Nome;
    private String dataHoraEntrada;
    private String motivoInternação;
    private String médicoResponsável;
    private String Contagioso;
    private String Unidade;

    public ControleAdmissões(String CPFpaciente, String nome, String dataHoraEntrada, String motivoInternação, String Contagioso, String médicoResponsável, String unidade) {
        this.CPFpaciente = CPFpaciente;
        this.Nome = nome;
        this.dataHoraEntrada = dataHoraEntrada;
        this.motivoInternação = motivoInternação;
        this.Contagioso = Contagioso;
        this.médicoResponsável = médicoResponsável;
        this.Unidade = unidade;

        try {
            sql.adicionarAoLeito(CPFpaciente, nome, dataHoraEntrada, motivoInternação, Contagioso, médicoResponsável, unidade);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

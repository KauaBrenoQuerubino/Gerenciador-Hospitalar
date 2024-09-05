package dominio.GerencaimentoPacientes;

import SQLconnection.SQL;

import java.sql.SQLException;

public class Alergias1 {
    //Cadastro de informações pessoais


    //Alergias e Condições Médicas
    SQL sql = new SQL();

    private String alergiasConhecidas;
    private String condicoesCronicas;
    private String restricoesMedicas;

    public Alergias1(String cpf, String alergiasConhecidas, String condicoesCronicas, String restricoesMedicas) {
        this.alergiasConhecidas = alergiasConhecidas;

        this.condicoesCronicas = condicoesCronicas;
        this.restricoesMedicas = restricoesMedicas;
        sql.conexaoComDB();
        try {
            sql.Alergiascondicõesmédicas(sql.verificarCPF(cpf, "`alergiascondicõesmédicas`"), alergiasConhecidas, condicoesCronicas, restricoesMedicas  );
        } catch (SQLException e) {
            System.err.println("Error ao adicionar ao banco" + e.getMessage());
        }
    }

    public String getAlergiasConhecidas() {
        return alergiasConhecidas;
    }

    public void setAlergiasConhecidas(String alergiasConhecidas) {
        this.alergiasConhecidas = alergiasConhecidas;
    }

    public String getCondicoesCronicas() {
        return condicoesCronicas;
    }

    public void setCondicoesCronicas(String condicoesCronicas) {
        this.condicoesCronicas = condicoesCronicas;
    }

    public String getRestricoesMedicas() {
        return restricoesMedicas;
    }

    public void setRestricoesMedicas(String restricoesMedicas) {
        this.restricoesMedicas = restricoesMedicas;
    }
}


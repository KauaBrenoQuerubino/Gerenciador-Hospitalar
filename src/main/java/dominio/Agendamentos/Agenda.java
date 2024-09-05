package dominio.Agendamentos;

import SQLconnection.SQL;

import java.sql.SQLException;

public class Agenda {

    SQL sql = new SQL();
    private String Data = "00/00/00000";
    private String Horas = "00:00";
    private String Consulta;


    public Agenda(String cpf, String data, String horas, String consulta) {
        Data = data;
        Horas = horas;
        Consulta = consulta;
        try {
            sql.AgendamentoConsultas(sql.verificarCPF(cpf, "agendamentodeconsultas"), Data, Horas, Consulta);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ApagarConsulta(String cpf){
        try {
            sql.CancelamentoConsultas(cpf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Reeagendar(String cpf, String NovaData, String NovoHorario){
        try {
            sql.ReescalonamentoConsultas(cpf, NovaData, NovoHorario);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getHoras() {
        return Horas;
    }

    public void setHoras(String horas) {
        Horas = horas;
    }

    public String getConsulta() {
        return Consulta;
    }

    public void setConsulta(String consulta) {
        Consulta = consulta;
    }
}

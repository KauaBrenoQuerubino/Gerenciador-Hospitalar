package teste;

import SQLconnection.SQL;
import dominio.Agendamentos.Agenda;
import dominio.GerencaimentoPacientes.Alergias1;
import dominio.GerencaimentoPacientes.HistoricoMedico;
import dominio.GerencaimentoPacientes.informacoesPacientes;

import java.sql.SQLException;


public class teste {
    public static void main(String[] args) {
        String cpf = "120.123.123-91";
        SQL sql = new SQL();
        informacoesPacientes rdp = new informacoesPacientes("Kaua", cpf, "24/02/2002", "M", "23330-90", "090102982", "10293310");
        HistoricoMedico his = new HistoricoMedico(cpf, "Dengue", "amidalas, remocao do apendice", "fonodiologos");
        Alergias1 tst = new Alergias1(cpf, "tumor", "tumor", "David");
        Agenda agenda = new Agenda(cpf, "25/02/2005", "24:00", "Hemoroida");

        agenda.Reeagendar(cpf, "27/12/34", "19:00");


    }
}

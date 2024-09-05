package SQLconnection;

import java.sql.*;

public class SQL {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/gerenciamentohospitalar";
    private final String username = "root";
    private final String password = "";
    private Connection conexao = null;

    public void conexaoComDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(jdbcURL, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco de dados não localizado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Ocorreu um erro ao acessar o banco de dados: " + e.getMessage());
        }
    }

    public void registropaciente(String cpf, String nome, String dataDenascimento, String sexo, String cep, String numero, String numeroDeEmargencia) throws SQLException {
        String sql = "INSERT INTO registrodepacientes (cpf, nome, dataN, sexo, cep, numero, numeroEmer) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {


                statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                statement.setString(2, nome);
                statement.setString(3, dataDenascimento);
                statement.setString(4, sexo);
                statement.setString(5, cep);
                statement.setString(6, numero);
                statement.setString(7, numeroDeEmargencia);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Um novo registro foi inserido com sucesso!");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void historicoMedico(String cpf, String histoDoencs, String cirurgias, String trataAnteriores) throws SQLException {
        String sql = "INSERT INTO históricomédico (cpf, historicoDeDoencas, cirurgias, tratamentosAnteriores) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }

        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {


                statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                statement.setString(2, histoDoencs);
                statement.setString(3, cirurgias);
                statement.setString(4, trataAnteriores);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Um novo registro foi inserido com sucesso!");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //por que esse metodo nao esta funcionando?
    public void Alergiascondicõesmédicas(String cpf, String alergiasConhecidas, String condicoesCronicas, String restricoesMedicas) throws SQLException {
        String sql = "INSERT INTO alergiascondicõesmédicas(cpf, alergiasConhecidas, condicoesCronicas, restricoesMedicas) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }

        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {

                statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                statement.setString(2, alergiasConhecidas);
                statement.setString(3, condicoesCronicas);
                statement.setString(4, restricoesMedicas);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Um novo registro foi inserido com sucesso!");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String verificarCPF(String cpf, String DB) throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        if (cpf.length() >= 11 && cpf.length() < 15) {
            ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM " + DB);
            while (resultado.next()) {
                if (cpf.equals(resultado.getString("cpf"))) {
                    cpf = "ERROR";
                }
            }
        } else {
            System.out.println("Tamanho muito pequeno");
            cpf = "ERROR";
        }
        return cpf;

    }

    public void AgendamentoConsultas(String cpf, String data, String horas, String consulta) throws SQLException {
        String sql = "INSERT INTO `agendamentodeconsultas`(cpf, Datas, Hora, consulta) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {

                statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                statement.setString(2, data);
                statement.setString(3, horas);
                statement.setString(4, consulta);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Um novo registro foi inserido com sucesso!");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void CancelamentoConsultas(String cpf) throws SQLException {
        String sql = "DELETE FROM `gerenciamentohospitalar`.`agendamentodeconsultas` WHERE (`cpf` = ?)";
        PreparedStatement statement = null;
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {

                statement = conexao.prepareStatement(sql);
                statement.setString(1, cpf);
                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Apagado com Sucesso");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void ReescalonamentoConsultas(String cpf, String NovaData, String NovoHorario) throws SQLException {
        String sql = "UPDATE `gerenciamentohospitalar`.`agendamentodeconsultas` SET `Datas` = ?, `Hora` = ? WHERE (`cpf` = ?); ";
        PreparedStatement statement = null;
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        try {
            if (cpf == "ERROR") {
                System.out.println("cpf ja registrado!");
            } else {

                statement = conexao.prepareStatement(sql);
                statement.setString(1, NovaData);
                statement.setString(2, NovoHorario);
                statement.setString(3, cpf);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Horario Atualizado");
                }
                statement.close();
                conexao.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionarAoLeito(String cpf, String nome, String DataInternacao, String Motivo, String Contagioso, String medico, String unidade) throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }
        String sql = "UPDATE `gerenciamentohospitalar`.`leitos` SET `Disponivel` = ?, `cpfPaciente` = ?, `nome` = ?, `DataDeEntrada` = ?, Motivo = ?, Contagioso = ?, MedicoResponsavel = ?, Unidade = ? WHERE (`Cod_Leito` = ?);";
        PreparedStatement statement = null;
        ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM gerenciamentohospitalar.leitos;");
        while (resultado.next()) {
            if (resultado.getString("Disponivel").equals("SIM")) {
                int recebeId = resultado.getInt("Cod_Leito");

                statement = conexao.prepareStatement(sql);
                statement.setString(1, "NAO");
                statement.setString(2, cpf);
                statement.setString(3, nome);
                statement.setString(4, DataInternacao);
                statement.setString(5, Motivo);
                statement.setString(6, Contagioso);
                statement.setString(7, medico);
                statement.setString(8, unidade);
                statement.setInt(9, recebeId);

                int rows = statement.executeUpdate();

                System.out.println("executei");

                statement.close();
                conexao.close();

                break;
            }
        }
    }

    public void darAlta(String cpf) throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            try {
                conexao = DriverManager.getConnection(jdbcURL, username, password);
            } catch (SQLException e) {
                System.out.println("Error ao iniciar o banco de dados " + e.getMessage());
            }
        }

        String sql = "UPDATE `gerenciamentohospitalar`.`leitos` SET `Disponivel` = ?, `cpfPaciente` = ?, `nome` = ?, `DataDeEntrada` = ?, Motivo = ?, Contagioso = ?, MedicoResponsavel = ?, Unidade = ? WHERE (`Cod_Leito` = ?);";
        PreparedStatement statement = null;
        ResultSet resultado = conexao.createStatement().executeQuery("SELECT * FROM gerenciamentohospitalar.leitos;");
        while (resultado.next()) {
            if (resultado.getString("cpfPaciente").equals(cpf)) {
                int recebeId = resultado.getInt("Cod_Leito");

                statement = conexao.prepareStatement(sql);
                statement.setString(1, "SIM");
                statement.setString(2, "");
                statement.setString(3, "");
                statement.setString(4, "");
                statement.setString(5, "");
                statement.setString(6, "");
                statement.setString(7, "");
                statement.setString(8, "");
                statement.setInt(9, recebeId);


                int rows = statement.executeUpdate();

                System.out.println("Alta");

                statement.close();
                conexao.close();

                break;
            }
        }


    }

}


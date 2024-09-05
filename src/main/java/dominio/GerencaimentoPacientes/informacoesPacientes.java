package dominio.GerencaimentoPacientes;

import SQLconnection.SQL;

import java.sql.SQLException;

public class informacoesPacientes {

    //Cadastro de informações pessoais

    SQL sql = new SQL();
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String sexo;
    private String cep;
    private String numero;
    private String numeroDeEmargencia;



    public informacoesPacientes(String nome, String cpf, String dataDeNascimento, String sexo, String cep, String numero, String numeroDeEmargencia) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.sexo = sexo;
        this.cep = cep;
        this.numero = numero;
        this.numeroDeEmargencia = numeroDeEmargencia;
        sql.conexaoComDB();
        try {
            sql.registropaciente(sql.verificarCPF(cpf, "registrodepacientes"), nome, dataDeNascimento, sexo, cep, numero, numeroDeEmargencia);
        } catch (SQLException e) {
            System.err.println("Error ao adicionar ao banco" + e.getMessage());
        }
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumeroDeEmargencia() {
        return numeroDeEmargencia;
    }

    public void setNumeroDeEmargencia(String numeroDeEmargencia) {
        this.numeroDeEmargencia = numeroDeEmargencia;
    }



    }
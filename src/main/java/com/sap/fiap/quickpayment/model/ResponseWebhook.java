/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sap.fiap.quickpayment.model;

/**
 *
 * @author Gabriel Duarte, Eduardo Amorim
 */
public class ResponseWebhook {
    
    private String idAutenticacao;
    private String cnpj;
    private String codBanco;
    private String agencia;
    private String conta;
    private String empresa;
    private String dataPagamento;
    private String horaPagamento;
    private String dataVencimento;
    private String valor;

    public ResponseWebhook(String idAutenticacao, String cnpj, String codBanco, String agencia, String conta, String empresa, String dataPagamento, String horaPagamento, String dataVencimento, String valor) {
        this.idAutenticacao = idAutenticacao;
        this.cnpj = cnpj;
        this.codBanco = codBanco;
        this.agencia = agencia;
        this.conta = conta;
        this.empresa = empresa;
        this.dataPagamento = dataPagamento;
        this.horaPagamento = horaPagamento;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public String getIdAutenticacao() {
        return idAutenticacao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public String getHoraPagamento() {
        return horaPagamento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public String getValor() {
        return valor;
    }
    
}

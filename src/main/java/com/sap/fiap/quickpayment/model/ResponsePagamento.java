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
public class ResponsePagamento {
    private String idAutenticacao;
    private String dataEnvio;

    public ResponsePagamento(String idAutenticacao, String dataEnvio) {
        this.idAutenticacao = idAutenticacao;
        this.dataEnvio = dataEnvio;
    }

    public String getIdAutenticacao() {
        return idAutenticacao;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }
    
}

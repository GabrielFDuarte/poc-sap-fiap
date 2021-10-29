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
public class RequestConsultaComprovante {
    
    private String idAutenticacao;
    
    public RequestConsultaComprovante() {
        
    }

    public RequestConsultaComprovante(String idAutenticacao) {
        this.idAutenticacao = idAutenticacao;
    }

    public String getIdAutenticacao() {
        return idAutenticacao;
    }

    public void setIdAutenticacao(String idAutenticacao) {
        this.idAutenticacao = idAutenticacao;
    }
    
}

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
public class RequestExtratoPagamentos {
    
    private String cnpj;
    private String dataInicio;
    private String dataLimite;
    private String teste;
    
    public RequestExtratoPagamentos() {
        
    }

    public RequestExtratoPagamentos(String cnpj, String dataInicio, String dataLimite, String teste) {
        this.cnpj = cnpj;
        this.dataInicio = dataInicio;
        this.dataLimite = dataLimite;
        this.teste = teste;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

}

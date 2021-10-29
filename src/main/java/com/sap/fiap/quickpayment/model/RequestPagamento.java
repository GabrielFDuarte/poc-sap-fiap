/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sap.fiap.quickpayment.model;

import java.math.BigDecimal;

/**
 *
 * @author Gabriel Duarte, Eduardo Amorim
 */
public class RequestPagamento {
    
    private String cnpjOrigem;
    private String cnpjDestino;
    private String codBanco;
    private String agencia;
    private String conta;
    private String empresa;
    private String tipoPagamento;
    private String dataVencimento;
    private String moeda;
    private BigDecimal valor;
    
    public RequestPagamento() {
        
    }

    public RequestPagamento(String cnpjOrigem, String cnpjDestino, String codBanco, String agencia, String conta, String empresa, String tipoPagamento, String dataVencimento, String moeda, BigDecimal valor) {
        this.cnpjOrigem = cnpjOrigem;
        this.cnpjDestino = cnpjDestino;
        this.codBanco = codBanco;
        this.agencia = agencia;
        this.conta = conta;
        this.empresa = empresa;
        this.tipoPagamento = tipoPagamento;
        this.dataVencimento = dataVencimento;
        this.moeda = moeda;
        this.valor = valor;
    }

    public String getCnpjOrigem() {
        return cnpjOrigem;
    }

    public void setCnpjOrigem(String cnpjOrigem) {
        this.cnpjOrigem = cnpjOrigem;
    }

    public String getCnpjDestino() {
        return cnpjDestino;
    }

    public void setCnpjDestino(String cnpjDestino) {
        this.cnpjDestino = cnpjDestino;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}

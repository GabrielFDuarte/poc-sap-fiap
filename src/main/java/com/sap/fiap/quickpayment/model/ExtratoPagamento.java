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
public class ExtratoPagamento {
    
    private String CNPJ_DEB;
    private String CNPJ_FAV;
    private Long COD_BANCO;
    private Long AGENCIA;
    private Long CONTA;
    private String EMPRESA;
    private Long TIPO_PAGAMENTO;
    private String DATA_VENC;
    private String MOEDA;
    private Double VALOR;
    
    public ExtratoPagamento() {
        
    }

    public ExtratoPagamento(String CNPJ_DEB, String CNPJ_FAV, Long COD_BANCO, Long AGENCIA, Long CONTA, String EMPRESA, Long TIPO_PAGAMENTO, String DATA_VENC, String MOEDA, Double VALOR) {
        this.CNPJ_DEB = CNPJ_DEB;
        this.CNPJ_FAV = CNPJ_FAV;
        this.COD_BANCO = COD_BANCO;
        this.AGENCIA = AGENCIA;
        this.CONTA = CONTA;
        this.EMPRESA = EMPRESA;
        this.TIPO_PAGAMENTO = TIPO_PAGAMENTO;
        this.DATA_VENC = DATA_VENC;
        this.MOEDA = MOEDA;
        this.VALOR = VALOR;
    }

    public String getCNPJ_DEB() {
        return CNPJ_DEB;
    }

    public void setCNPJ_DEB(String CNPJ_DEB) {
        this.CNPJ_DEB = CNPJ_DEB;
    }

    public String getCNPJ_FAV() {
        return CNPJ_FAV;
    }

    public void setCNPJ_FAV(String CNPJ_FAV) {
        this.CNPJ_FAV = CNPJ_FAV;
    }

    public Long getCOD_BANCO() {
        return COD_BANCO;
    }

    public void setCOD_BANCO(Long COD_BANCO) {
        this.COD_BANCO = COD_BANCO;
    }

    public Long getAGENCIA() {
        return AGENCIA;
    }

    public void setAGENCIA(Long AGENCIA) {
        this.AGENCIA = AGENCIA;
    }

    public Long getCONTA() {
        return CONTA;
    }

    public void setCONTA(Long CONTA) {
        this.CONTA = CONTA;
    }

    public String getEMPRESA() {
        return EMPRESA;
    }

    public void setEMPRESA(String EMPRESA) {
        this.EMPRESA = EMPRESA;
    }

    public Long getTIPO_PAGAMENTO() {
        return TIPO_PAGAMENTO;
    }

    public void setTIPO_PAGAMENTO(Long TIPO_PAGAMENTO) {
        this.TIPO_PAGAMENTO = TIPO_PAGAMENTO;
    }

    public String getDATA_VENC() {
        return DATA_VENC;
    }

    public void setDATA_VENC(String DATA_VENC) {
        this.DATA_VENC = DATA_VENC;
    }

    public String getMOEDA() {
        return MOEDA;
    }

    public void setMOEDA(String MOEDA) {
        this.MOEDA = MOEDA;
    }

    public Double getVALOR() {
        return VALOR;
    }

    public void setVALOR(Double VALOR) {
        this.VALOR = VALOR;
    }
    
}

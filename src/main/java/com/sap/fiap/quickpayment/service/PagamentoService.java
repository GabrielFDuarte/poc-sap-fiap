/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sap.fiap.quickpayment.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author Gabriel Duarte, Eduardo Amorim
 */
@Service
public class PagamentoService {

    public String idAutenticacaoGenerator() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 50;

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(10);

            sb.append(Integer.toString(index));
        }
        String randomString = sb.toString();
        return randomString;
    }

    public String dataEnvio() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        String strDate = formatter.format(date);
        return strDate;
    }
    
    public String getHora() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss");
        String strTime = formatter.format(date);
        return strTime;
    }
}

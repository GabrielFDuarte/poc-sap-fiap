/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sap.fiap.quickpayment.controller;

import com.sap.fiap.quickpayment.model.ExtratoPagamento;
import com.sap.fiap.quickpayment.model.RequestConsultaComprovante;
import com.sap.fiap.quickpayment.model.RequestExtratoPagamentos;
import com.sap.fiap.quickpayment.model.RequestPagamento;
import com.sap.fiap.quickpayment.model.ResponsePagamento;
import com.sap.fiap.quickpayment.model.ResponseWebhook;
import com.sap.fiap.quickpayment.service.PagamentoService;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Gabriel Duarte, Eduardo Amorim
 */
@Controller
public class HomeController {

    @Autowired
    private PagamentoService pagamentoService;

    @RequestMapping("/")
    public String pagamento() {
        return "pagamento";
    }

    @RequestMapping("/aprovacao")
    public String aprovacao() {
        return "aprovacao";
    }

    @RequestMapping("/acompanhamento")
    public String acompanhamento() {
        return "acompanhamento";
    }

    @RequestMapping("/relatorios")
    public String relatorios() {
        return "relatorios";
    }

//    Envio de Pagamento
    @ResponseBody
    @PostMapping(path = "/envioPagamento", produces = {"application/json"})
    public ResponseEntity<Object> envioPagamento(@RequestBody RequestPagamento jsonRequestPagamento) {
        String idAutenticacao = pagamentoService.idAutenticacaoGenerator();
        String dataEnvio = pagamentoService.dataEnvio();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponsePagamento(idAutenticacao, dataEnvio));
    }

//    Comprovante Pagamento
    @ResponseBody
    @PostMapping(path = "/webhookDevolucao", produces = {"application/json"})
    public ResponseEntity<Object> webhookDevolucao() {
        String dataEnvio = pagamentoService.dataEnvio();
        String horaPagamento = pagamentoService.getHora();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWebhook("28598344241431735058255681955291474153510178413434", "15.703.306/4386-90", "101", "1", "70445", "Innotype", dataEnvio, horaPagamento, "31/05/2021", "5110.4"));
    }

//    Consulta Comprovante de Pagamento
    @ResponseBody
    @PostMapping(path = "/consultaComprovante", produces = {"application/json"})
    public ResponseEntity<Object> consultaComprovante(@RequestBody RequestConsultaComprovante jsonRequestConsultaComprovante) {
        if (!jsonRequestConsultaComprovante.getIdAutenticacao().equals("11248361276882915492205735513884001859286865258817")) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Identificador de Comprovante de Pagamento não encontrado!");
        }
        String dataEnvio = pagamentoService.dataEnvio();
        String horaPagamento = pagamentoService.getHora();

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWebhook("28598344241431735058255681955291474153510178413434", "15.703.306/4386-90", "101", "1", "70445", "Innotype", dataEnvio, horaPagamento, "31/05/2021", "5110.4"));
    }

//    Extrato Pagamentos
    @ResponseBody
    @PostMapping(path = "/extratoPagamentos", produces = {"application/json"})
    public ArrayList<ExtratoPagamento> extratoPagamentos(@RequestBody RequestExtratoPagamentos jsonRequestExtratoPagamentos) throws org.json.simple.parser.ParseException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(ResourceUtils.getFile("classpath:static/pagamentos.json"))) {
            Object obj = jsonParser.parse(reader);

            JSONArray pagamentosList = (JSONArray) obj;

            ArrayList<ExtratoPagamento> extratoPagamentosList = new ArrayList<ExtratoPagamento>();

            for (Object pagamento : pagamentosList) {
                ExtratoPagamento extratoPagamentoTemp = parseExtratoPagamento((JSONObject) pagamento, jsonRequestExtratoPagamentos.getDataInicio(), jsonRequestExtratoPagamentos.getDataLimite(), jsonRequestExtratoPagamentos.getCnpj());
                if (extratoPagamentoTemp != null) {
                    extratoPagamentosList.add(extratoPagamentoTemp);
                }
            }

            return extratoPagamentosList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static ExtratoPagamento parseExtratoPagamento(JSONObject pagamento, String dataInicio, String dataFim, String cnpjOrigem) throws ParseException {
        String CNPJ_DEB = (String) pagamento.get("CNPJ_DEB");
        String CNPJ_FAV = (String) pagamento.get("CNPJ_FAV");
        Long COD_BANCO = (Long) pagamento.get("COD_BANCO");
        Long AGENCIA = (Long) pagamento.get("AGENCIA");
        Long CONTA = (Long) pagamento.get("CONTA");
        String EMPRESA = (String) pagamento.get("EMPRESA");
        Long TIPO_PAGAMENTO = (Long) pagamento.get("TIPO_PAGAMENTO");
        String DATA_VENC = (String) pagamento.get("DATA_VENC");
        String MOEDA = (String) pagamento.get("MOEDA");
        Double VALOR = (Double) pagamento.get("VALOR");

        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date dataVenc = fmt.parse(DATA_VENC);
        
        SimpleDateFormat fmtInicio = new SimpleDateFormat("dd/MM/yy");
        Date dataIni = fmtInicio.parse(dataInicio);
        SimpleDateFormat fmtLimite = new SimpleDateFormat("dd/MM/yy");
        Date dataLimite = fmtLimite.parse(dataFim);
        
        if ((dataVenc.after(dataIni) && dataVenc.before(dataLimite)) && cnpjOrigem.equals(CNPJ_DEB)) {
            return new ExtratoPagamento(CNPJ_DEB, CNPJ_FAV, COD_BANCO, AGENCIA, CONTA, EMPRESA, TIPO_PAGAMENTO, DATA_VENC, MOEDA, VALOR);
        } else {
            return null;
        }

    }

}

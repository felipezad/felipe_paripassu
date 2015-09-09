/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.felipe.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.edu.utfpr.felipe.dados.DB;
import br.edu.utfpr.felipe.model.Senha;
import br.edu.utfpr.felipe.websocket.SenhasEndpoit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
@Controller
public class GerenteController {

    private final Result result;
    ArrayList<Senha> mTodasSenhas;
    private SenhasEndpoit senhasEp;

    public GerenteController() {
        this(null, null);
    }

    @Inject
    public GerenteController(Result result, SenhasEndpoit ep) {
        this.result = result;
        this.senhasEp = ep;
        mTodasSenhas = new ArrayList<>();

    }

    @Get("/gerente")
    public void index() {
        result.include("msg", "Bem-Vindo Gerente!");
        try {
            mTodasSenhas.addAll(DB.senhasNormais);
            mTodasSenhas.addAll(DB.senhasPreferenciais);
            Collections.sort(mTodasSenhas);
            result.include("senhas", mTodasSenhas);
        } catch (Exception e) {
            //throw e;
        }

    }

    @Get("/gerente/gerarSenhas")
    public void gerarSenhas() {
        if (DB.senhasNormais == null && DB.senhasPreferenciais == null) {
            DB.senhasNormais = new ArrayList<>();
            DB.senhasPreferenciais = new ArrayList<>();
            DB.senhasNormaisPegas = new ArrayList<>();
            DB.senhasPreferenciaisPegas = new ArrayList<>();
            gerarSenhas();
        } else {
            if (DB.senhasNormais.isEmpty() && DB.senhasPreferenciais.isEmpty()) {
                Random rand = new Random();
                for (int i = 0; i < 5; i++) {
                    DB.senhasNormais.add(new Senha("N", rand.nextInt(10000)));
                    DB.senhasPreferenciais.add(new Senha("P", rand.nextInt(10000)));
                }
            }else{
                DB.senhasNormais.clear();
                DB.senhasPreferenciais.clear();
            }
            result.redirectTo(this).index();
        }

    }

    public void chamarSenha() throws IOException {
        if (DB.senhasPreferenciaisPegas != null && !DB.senhasPreferenciaisPegas.isEmpty()) {
            DB.atual = DB.senhasPreferenciaisPegas.get(0);
            DB.senhasPreferenciaisPegas.remove(0);
        } else if (DB.senhasNormaisPegas != null && !DB.senhasNormaisPegas.isEmpty()) {
            DB.atual = DB.senhasNormaisPegas.get(0);
            DB.senhasNormaisPegas.remove(0);
        }
        try {
            senhasEp.onMessage(DB.atual.toString());
        } catch (Exception e) {

        }
        result.include("senhaChamada", DB.atual).redirectTo(this).index();
    }

}

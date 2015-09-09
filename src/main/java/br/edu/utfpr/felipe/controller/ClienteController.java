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
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
@Controller
public class ClienteController {

    private final Result result;

    public ClienteController() {
        this(null);
    }

    @Inject
    public ClienteController(Result result) {
        this.result = result;

    }

    @Get("/cliente")
    public void index() {
        result.include("msg", "Bem-vindo Cliente!");
        senhaChamada();
    }

    public void pegarSenhaNormal() {
        if (DB.senhasNormais != null) {
            if (!DB.senhasNormais.isEmpty()) {
                result.include("senha", DB.senhasNormais.get(0));                
                DB.senhasNormaisPegas.add(DB.senhasNormais.get(0));
                DB.senhasNormais.remove(DB.senhasNormais.get(0));
            } else {
                result.include("msgSenha", "Não há senhas normais disponiveis no momento! aguarde...");
            }
        }
        result.redirectTo(this).index();
    }

    public void pegarSenhaPreferencial() {
        if (DB.senhasPreferenciais != null) {
            if (!DB.senhasPreferenciais.isEmpty()) {
                result.include("senha", DB.senhasPreferenciais.get(0));
                DB.senhasPreferenciaisPegas.add(DB.senhasPreferenciais.get(0));
                DB.senhasPreferenciais.remove(DB.senhasPreferenciais.get(0));
            } else {
                result.include("msgSenha", "Não há senhas preferenciais disponiveis no momento! aguarde...");
            }
        }
        result.redirectTo(this).index();
    }

    public void senhaChamada() {
        if (DB.atual != null) {
            result.include("senhaAtual", DB.atual);
        }
    }
}

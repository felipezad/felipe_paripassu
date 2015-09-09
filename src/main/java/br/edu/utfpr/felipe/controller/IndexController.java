/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.felipe.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

/**
 *
 * @author Felipe
 */
@Controller
public class IndexController {

    private final Result result;

    public IndexController() {
        this(null);
    }

    @Inject
    public IndexController(Result result) {
        this.result = result;
    }

    @Get("/")
    public void index() {
        result.include("msg", "Bem-vindo!");
    }

    @Get("index/gerente")
    public void gerente() {
        result.redirectTo(GerenteController.class).index();
    }

    @Get("index/cliente")
    public void cliente() {
        result.redirectTo(ClienteController.class).index();
    }

}

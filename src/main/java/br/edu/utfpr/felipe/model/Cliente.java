/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.felipe.model;

/**
 *
 * @author Felipe
 */
public class Cliente {
    private Senha mSenha;

    public Cliente() {
    }

    public Cliente(Senha mSenha) {
        this.mSenha = mSenha;
    }

    public Senha getmSenha() {
        return mSenha;
    }

    public void setmSenha(Senha mSenha) {
        this.mSenha = mSenha;
    }
    
}

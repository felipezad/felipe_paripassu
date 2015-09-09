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
public class Senha implements Comparable<Senha>{

    private String tipo;
    private int id;

    public Senha() {
    }

    public Senha(String tipo, int id) {
        this.tipo = tipo;
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int length() {
        return (int) (Math.log10(id) + 1);
    }

    private String formattedString() {
        if (length() < 4 ) {
            return String.format("%04d", id);       
        } else {
            return String.valueOf(id);
        }

    }

    @Override
    public String toString() {
        return "Senha{ " + tipo + formattedString() + " }" ;
    }

    @Override
    public int compareTo(Senha o) {
       return o.tipo.compareTo(this.tipo);
    }
    
    
}

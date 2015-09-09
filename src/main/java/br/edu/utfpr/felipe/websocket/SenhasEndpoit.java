/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.felipe.websocket;

import br.edu.utfpr.felipe.dados.DB;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author marcio
 */
@ApplicationScoped
@ServerEndpoint("/wspass")
public class SenhasEndpoit {
    
 
    private static Set<Session> peers = Collections.synchronizedSet(new HashSet<Session>());

    @OnMessage
    public String onMessage(String message) throws IOException{
        String st = DB.atual.toString();
        for(Session s : peers){
            s.getBasicRemote().sendText(st);
        }
        return st;
    }
    
    @OnOpen
    public void onOpen(Session peer){
        peers.add(peer);
    }
    
    @OnClose
    public void onClose(Session peer){
        peers.remove(peer);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author gilvonaldo
 */
public class ChatMenssage implements Serializable {
    
    private String name;
    private String text;
    private String nameReserved;
    private Set<String> setOlines = new HashSet<String>();
    private Action action;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNameReserved() {
        return nameReserved;
    }

    public void setNameReserved(String nameReserved) {
        this.nameReserved = nameReserved;
    }

    public Set<String> getSetOlines() {
        return setOlines;
    }

    public void setSetOlines(Set<String> setOlines) {
        this.setOlines = setOlines;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
    
    /**
     * Enum que vai dizer qual ação o servidor deve realizar
     */
    public enum Action {
        
        CONNECT, DESCONNECT, SEND_ONE, SEND_ALL, USERS_ONLINE
        
    }
    
    
}

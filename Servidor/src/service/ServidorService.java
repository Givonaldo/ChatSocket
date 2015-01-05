/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.ChatMenssage;
import bean.ChatMenssage.Action;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gilvonaldo
 */
public class ServidorService {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnline = new HashMap<String, ObjectOutputStream>();
    
    public ServidorService(){
        try{
            serverSocket = new ServerSocket(5555);
            while (true){
                socket = serverSocket.accept();
                new Thread(new ListenerSocket(socket)).start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        
    }
    
    private class ListenerSocket implements Runnable {
        
        private ObjectOutputStream output;
        private ObjectInputStream input;
        
        public ListenerSocket(Socket socket){
            try {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        @Override
        public void run(){
            try {
                ChatMenssage message = null;
                
                while ((message = (ChatMenssage)input.readObject()) != null){
                    ChatMenssage.Action action = message.getAction();
                    
                    
                    if (action.equals(Action.CONNECT)){
                        connect(message, output);
                    }else if (action.equals(Action.DESCONNECT)){
                        sendOne(message, output);
                    }else if (action.equals(Action.SEND_ONE)){
                        
                    }else if (action.equals(Action.SEND_ALL)){
                        
                    }else if (action.equals(Action.USERS_ONLINE)){
                        
                    }
                    
                }
            } catch (IOException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ServidorService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
        
    
    private void connect(ChatMenssage message, ObjectOutputStream output){
        
        sendOne(message, output);
        
    }
    
    private void sendOne(ChatMenssage message, ObjectOutputStream output){
        
        try{
            output.writeObject(message);
        }catch(IOException ex){
            
        }
        
    }
}

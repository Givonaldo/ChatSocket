/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Bean.ChatMenssage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author gilvonaldo
 */
public class ClienteService {
    
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect(){
        try{
            
            this.socket = new Socket("localhost", 5555);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        
        return socket;
    }
    
    public void send(ChatMenssage message){
        try{
            output.writeObject(message);
        }catch (IOException iox){
            iox.printStackTrace();
        }
    }
    
}

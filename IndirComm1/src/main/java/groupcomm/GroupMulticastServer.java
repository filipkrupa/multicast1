package groupcomm;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.net.*;

public class GroupMulticastServer {

    //group multicast IP is in the range 224.0.0.0 to 239.255.255.255
    //244.0.0.0 is reserved
    final static  String  INET_ADDR = "228.5.6.7";
    final static int PORT = 6789;

    public static void main(String[] args) throws UnknownHostException {

        String[] means = {"Tesla", "Lada", "Camaro", "El-Scooter", "skate-bard"};
        InetAddress address = InetAddress.getByName(INET_ADDR);

        //open a new DatagramSocket for sending data

        try(DatagramSocket serverSocket = new DatagramSocket()){

                    for ( String mm : means){
                    String message = "Y class is cool with " + mm;
                    //create a packet with a data

                        DatagramPacket messagePacket = new DatagramPacket(message.getBytes(), message.getBytes().length,address, PORT);
                        //send packet

                        serverSocket.send(messagePacket);
                        System.out.println("Server has sent a packet with message: " + message);

                        }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }



    }
}

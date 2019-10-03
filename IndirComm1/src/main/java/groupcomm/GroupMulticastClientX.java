package groupcomm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class GroupMulticastClientX {
    final static  String  INET_ADDR = "228.5.6.7";
    final static int PORT = 6789;

    public static void main(String[] args) {

        //get address to connect to
        try {
            InetAddress address = InetAddress.getByName(INET_ADDR);
            //create buffer for incomming messages bytes from server
            byte[] buf = new byte[512];

            //create new Multicast socket
            try (MulticastSocket clientSocket = new MulticastSocket(PORT)){
                //join the group
                clientSocket.joinGroup(address);
                //receive message
                while (true){
                    //create a packet with data

                    DatagramPacket msgPacket = new DatagramPacket(buf,buf.length);

                    // receive the pacet
                    clientSocket.receive(msgPacket);

                    String msgReceived = new String(buf, 0, buf.length);
                    System.out.println("X class received: " + msgReceived);

                }

            } catch (IOException ioe){
                ioe.printStackTrace();
            }


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }



}

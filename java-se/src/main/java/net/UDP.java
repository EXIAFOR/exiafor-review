package net;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDP {
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的导弹";

        byte[] data = str.getBytes();

        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 10000);

        socket.send(packet);

        socket.close();
    }

    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(10000);

        byte[] buffer = new byte[100];

        DatagramPacket packet = new DatagramPacket(buffer, 0,buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}

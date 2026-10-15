///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */ Data
//package UDP;
//
//import java.util.*;
//import java.nio.*;
//import java.net.*;
//import java.io.*;
//
//public class test {
//    public static void main(String[] args) throws SocketException, UnknownHostException {
//        String host = "36.50.135.242";
//        int port = 2207;
//        String stuCode = "B23DCCN086";
//        String qCode = "GjqxODKc";
//        
//        DatagramSocket socket = new DatagramSocket();
//        
//        InetAddress address =  InetAddress.getByName(host);
//        try{
//            // gui du lieu
//            String request = ";" + stuCode + ";" + qCode;
//            
//            byte[] sendData = request.getBytes();
//            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,address, port);
//            socket.send(sendPacket);
//           
//            // nhan du lieu
//            byte[] buffer = new byte[4096];
//            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
//            socket.receive(receivePacket);
//            String response = new String(receivePacket.getData(),0,receivePacket.getLength());
//            String[] parts = response.split(";",3);
//            String requestId = parts[0];
//            
//            int n = Integer.parseInt(parts[1]);
//            String[] number = parts[2].trim().split(",");
//            ArrayList arr = new ArrayList<>();
//            
//            Set<Integer> se = new HashSet<>();
//            for(int i=0;i < number.length; i++){
//                se.add(Integer.valueOf(number[i]));
//            }
//            for(int i=0;i<=n;i++){
//                if(!se.contains(i)){
//                    arr.add(i);
//                }
//            }
//            requestId+=";";
//            for(int i=1;i<arr.size();i++){
//                requestId += String.valueOf(arr.get(i));
//                if(i<arr.size()-1){
//                    requestId += ",";
//                }
//            }
//            byte[] guiData = requestId.getBytes();
//            DatagramPacket sendPackets = new DatagramPacket(guiData,guiData.length,receivePacket.getAddress(),receivePacket.getPort());
//            socket.send(sendPackets);
//            socket.close();
//            
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        
//        
//    }
//}
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */String
//package UDP;
//import java.io.*;
//import java.util.*;
//import java.nio.*;
//import java.net.*;
//
//public class bai_2_str {
//    public static String chuanHoa(String s){
//        String kq = "";
//        String[] c = s.trim().split("\\s+");
//        for(String i : c){
//            kq += Character.toUpperCase(i.charAt(0));
//            for(int j=1;j< i.length();j++){
//                kq += Character.toLowerCase(i.charAt(j));
//            }
//            kq += " ";
//        }
//        return kq.trim();
//    }
//    public static void main(String[] args) throws SocketException {
//        String host = "36.50.135.242";
//        int port = 2208;
//        String stuCode = "B23DCCN086";
//        String qCode = "QwV4OpNH";
//        DatagramSocket socket = new DatagramSocket();
//        try{
//            InetAddress address = InetAddress.getByName(host);
//            
//            String request = ";" + stuCode + ";" + qCode;
//            byte[] sendData = request.getBytes();
//            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,address, port);
//            socket.send(sendPacket);
//            
//            byte[] receiveData = new byte[4096];
//            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
//            socket.receive(receivePacket);            
//            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
//            
//            String[] s = response.trim().split(";");
//            String requestId = s[0];
//            String dataString = chuanHoa(s[1]);
//            String requests = requestId + ";" + dataString;
//            
//            byte[] sendDatas = requests.getBytes();
//            DatagramPacket sendPackets = new DatagramPacket(sendDatas, sendDatas.length, receivePacket.getAddress(),receivePacket.getPort());
//            socket.send(sendPackets);
//            socket.close();          
//                    
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//    
//}
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package UDP;
//Object
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
//import java.net.InetAddress;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//import java.util.Arrays;
//
///**
// *
// * @author phant
// */
//public class bai_2_object {
//    public static String chuanHoaTen(String s){
//        String[] c = s.trim().split("\\s+");
//        String kq = "";
//        kq += c[c.length-1].toUpperCase() + ", ";
//        for(int i=0;i<c.length-1;i++){
//            kq += Character.toUpperCase(c[i].charAt(0));
//            for(int j = 1;j<c[i].length();j++){
//                kq += Character.toLowerCase(c[i].charAt(j));
//            }
//            kq += " ";
//        }
//        return kq.trim();
//    }
//    public static String chuanHoaDay(String s){
//        String[] c  = s.trim().split("-");
//        String kq = "";
//        kq += c[1] + "/" + c[0] + "/" + c[2];
//        return kq;
//        
//    }
//    public static String user(String s){
//        String[] c = s.trim().split("\\s+");
//        String kq = "";
//        for(int i=0;i<c.length-1;i++){
//            kq += Character.toLowerCase(c[i].charAt(0));
//        }
//        kq += c[c.length-1].toLowerCase();
//        return kq;
//    }
//    public static void main(String[] args) throws SocketException, UnknownHostException {
//        String host = "36.50.135.242";
//        int port = 2209;
//        String stuCode = "B23DCCN086";
//        String qCode = "YJOhhzUD";
//        
//        DatagramSocket socket = new DatagramSocket();
//        
//        try{
//            InetAddress address = InetAddress.getByName(host);
//            String request = ";" + stuCode + ";" + qCode;
//            byte[] sendData = request.getBytes();
//            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
//            socket.send(sendPacket);
//            
//            byte[] buffer = new byte[4096];
//            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
//            socket.receive(receivePacket);
//            byte[] receiveData = Arrays.copyOfRange(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
//            byte[] idByte = Arrays.copyOfRange(receiveData, 0, 8);
//            String requestId = new String (idByte);
//            
//            ByteArrayInputStream byteIn = new ByteArrayInputStream(receiveData, 8, receiveData.length-8);
//            // chuyen byte thanh object
//            ObjectInputStream objectIn = new ObjectInputStream(byteIn);
//            Customer customer =(Customer) objectIn.readObject();
//            customer.userName = user(customer.name);
//            customer.dayOfBirth = chuanHoaDay(customer.dayOfBirth);
//            customer.name = chuanHoaTen(customer.name);
//            
//            ByteArrayOutputStream objectByte = new ByteArrayOutputStream();
//            ObjectOutputStream objectOut = new ObjectOutputStream(objectByte);
//            objectOut.writeObject(customer);
//            objectOut.flush();
//            
//            byte[] customerData = objectByte.toByteArray();
//            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
//            byteOut.write(idByte);
//            byteOut.write(customerData);
//            byte[] guiData = byteOut.toByteArray();
//            
//            DatagramPacket sendPackets = new DatagramPacket(guiData,guiData.length, receivePacket.getAddress(),receivePacket.getPort());
//            socket.send(sendPackets);
//            socket.close();
//        }   
//        catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//}
//

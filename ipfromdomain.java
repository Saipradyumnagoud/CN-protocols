import java.io.*;
import java.util.*;
import java.net.*;
class ipfromdomain{
    public static void main(String[] args) 
    throws UnknownHostException
    {
        String s="https://www.google.com/";
        try
        {
            InetAddress ip = InetAddress.getByName(new URL(s).getHost());
            System.out.println("public IP Address :" +ip);
        }
        catch(MalformedURLException e)
        {
            System.out.println("invalid URL");
        }
    }
}
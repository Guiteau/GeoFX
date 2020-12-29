package dad.javafx.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Ipify_service {

private Ipify_service() {}
    
    /**
     * Gets the public ip address through ipify's api. By default, uses 
     * an http connection (which is about twice as fast as an https connection).
     * @return The public ip address.
     * @throws IOException If there is an IO error.
     */
    public static String getPublicIp() throws IOException {
        return getPublicIp(false);
    }
        
    /**
     * Gets the public ip address through ipify's api.
     * @param useHttps If true, will use an https connection. If false, will use http.
     * @return The public ip address.
     * @throws IOException If there is an IO error.
     */
    public static String getPublicIp(boolean useHttps) throws IOException {
        URL ipify = useHttps ? new URL("https://api.ipify.org") : new URL("http://api.ipify.org");
        URLConnection conn = ipify.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String ip = null;
        ip = in.readLine();
        in.close();
        return ip;
    }
	
}

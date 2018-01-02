import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

//bee
import tw.edu.au.csie.ucan.bee.BeeJNI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//this is Publisher
@SuppressWarnings("deprecation")
public class MQTT_Publisher {

    public static void main(String[] args) throws Exception {
    	String topic        = "aletheia/mqtt/1";
        //String topic        = "MQTT Examples";
        String content		= "";
        int qos             = 2;
        String broker   = "tcp://iot.eclipse.org:1883"       ;
        String clientId    = "Javasample2";
        MemoryPersistence persistence = new MemoryPersistence();
        Scanner sc = new Scanner(System.in);
        String userName ="test";
        String password ="000";
        int security = 6;
        boolean test = false;
        boolean bee = true;
        String policy = "jackie and s > 100";	//policy content
	String publickey_path = "/home/project_bee/Desktop/cpabe_publickey";	//publickey path
        
        
        try {
            
        	MqttClient sample = new MqttClient(broker, clientId, persistence);
        	
        	//SSLContext sslContext = SSLContext.getInstance("SSL");
        	
        	//TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        	//KeyStore keyStore = readKeyStore();
        	
        	//trustManagerFactory.init(keyStore);
        	//sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
        	 
        	
        	MqttConnectOptions options = new MqttConnectOptions();
        	//options.setSocketFactory(sslContext.getSocketFactory());
        	//System.out.println(options);
        
        	sample.connect(options);
        	
            
        	options.setUserName(userName);
        	options.setPassword(password.toCharArray());
           	options.setPolicy(policy);
	    	options.setPublickey(publickey_path);

            if(userName.equals("test")){
           
            System.out.println("Connecting to broker: "+broker);
            
            System.out.println("Connected");
            //content = sc.next();
             while(test == false){
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    try{
		content = br.readLine();
	    }catch(IOException e){
	    	System.out.println(e.toString());
	    }
 
            System.out.println("Publishing message: "+content);
            
            options.setCleanSession(true);
           
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sample.publish(topic,message,security,bee);
            //System.out.println("Message published");
            //sample.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
            }
}
            else{
            	System.out.println("userName no Authority");
            }
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }  //catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} //catch (KeyStoreException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//} //catch (KeyManagementException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
    }

	

	private static KeyStore readKeyStore() {
		// TODO Auto-generated method stub
		return null;
	}
}

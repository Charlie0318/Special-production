import java.util.Scanner;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//this is Publisher
public class JAVA_Publisher {

    public static void main(String[] args) throws Exception {
    	String topic        = "aletheia/mqtt/1";
        //String topic        = "MQTT Examples";
        String content      ;
        int qos             = 2;
        String broker       = "tcp://iot.eclipse.org:1883";
        String clientId     = "JavaSample1";
         String userName ;
         String password ;
        
        MemoryPersistence persistence = new MemoryPersistence();
        Scanner sc =new Scanner(System.in);
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
           
            System.out.println("Input userName: ");
            userName =sc.next();
           
            sampleClient.connect(connOpts);
            connOpts.setUserName(userName);
            
            if(userName.equals("123")){
            System.out.println("Connecting to broker: "+broker);
            
            System.out.println("Input userName password: ");
            password =sc.next();
            connOpts.setPassword(password.toCharArray());
            if(password.equals("0000")){
            
            System.out.println("Connected");
            
           
            content = sc.next();
            
            connOpts.setCleanSession(true,content);
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
           
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
            }
            else{
              	 System.out.println("password error!! ");
              
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
        }
    }
}
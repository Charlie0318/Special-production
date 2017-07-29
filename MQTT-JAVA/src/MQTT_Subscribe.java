import java.util.Arrays;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//this is MQTT_Subscribe
public class MQTT_Subscribe{
    public static void main(String[] args) {
    	String topic        = "aletheia/mqtt/1";
        //String topic        = "MQTT Examples";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "ssl://iot.eclipse.org:8883";
        String clientId     = "JavaSample";
        String userName ="test";
        String password = "000";
        MemoryPersistence persistence = new MemoryPersistence();

        
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            sampleClient.setCallback(new MqttCallback() {
				 
	            @Override
	            public void connectionLost(Throwable cause) { //Called when the client lost the connection to the broker 
	            }
	 
	            @Override
	            public void messageArrived(String topic, MqttMessage message) throws Exception {
	                System.out.println(topic + ": " + message.toString());
	            }
	 
	            @Override
	            public void deliveryComplete(IMqttDeliveryToken token) {//Called when a outgoing publish is complete 
	            }
	        });
            connOpts.setUserName(userName);
            connOpts.setPassword(password.toCharArray());
            
            //connOpts.setCleanSession(false);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
			sampleClient.subscribe("aletheia/mqtt/1", 0);
            System.out.println("Connected");
            //System.out.println("Publishing message: "+content);
            //MqttMessage message = new MqttMessage(content.getBytes());
            //message.setQos(qos);
            //sampleClient.subscribe(topic);
            System.out.println("Connecting to topic: "+topic);
			//sampleClient.publish(topic, message);
            //System.out.println("Message published");
            //sampleClient.disconnect();
            //System.out.println("Disconnected");
            //System.exit(0);
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
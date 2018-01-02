package tw.edu.au.csie.ucan.bee;

import java.util.*;
import tw.edu.au.csie.ucan.bee.BeeJNI;
import org.eclipse.paho.client.mqttv3.internal.wire.*;
import org.eclipse.paho.client.mqttv3.internal.*;
import org.eclipse.paho.client.mqttv3.*;

public class Beebit {
	public void Encode(MqttAsyncClient aClient , MqttMessage message , int security)
	{
		String me = message.toString();//turn String
		BeeJNI JNI = new BeeJNI();
		byte[] enc_msg = null;
		byte security_byte = (byte)security;
		int enc_length = 0;
		int rc = 0;
		byte[] bee_len_bef =new byte [4];
		switch (security){
			case 6:
				enc_msg = JNI.enc(aClient.getConnectOptions().getPublickey(),me,aClient.getConnectOptions().getPolicy());
				if(enc_msg == null){
					System.out.println("ENC ERROR");
				}
				break;
			default:
				break;
		}
		enc_length=enc_msg.length;
		int bee_i = 0;
		do
		{
			byte d = (byte)(enc_length % 128);
			enc_length /= 128;
			if(enc_length > 0)
			{
		       		d |= 0x80;
			}
			bee_len_bef[bee_i++] = d;
		}while(enc_length > 0);
		byte[] send = new byte [1 +bee_i+ enc_msg.length];
		send[0] = security_byte;
		System.arraycopy(bee_len_bef,0,send,1,bee_i);
		System.arraycopy(enc_msg,0,send,1+bee_i,enc_msg.length);
		message.setPayload(send);
	}
	public void Decode(MqttConnectOptions opt, byte[] bee_len_bef,MqttPublish sendMessage)
	{
		
		int value =0;
		int multiplier = 1;
		int number = 1;
		BeeJNI JNI =new BeeJNI();
		do
		{
			value += (bee_len_bef[number]&127)*multiplier;
			multiplier *= 128;
		}while((bee_len_bef[number++]&128)!=0);
		byte[] bee_msg =new byte [value];
		System.arraycopy(bee_len_bef,number,bee_msg,0,value);
		byte[] bee = JNI.dec(opt.getPublickey(),opt.getSecretkey(),bee_msg);
		if(bee == null){
			sendMessage.getMessage().setPayload("Dec fail".getBytes());
		}else{
			sendMessage.getMessage().setPayload(bee);
		}	
	}
}

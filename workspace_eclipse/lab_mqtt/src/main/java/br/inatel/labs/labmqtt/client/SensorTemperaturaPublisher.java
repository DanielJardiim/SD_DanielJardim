package br.inatel.labs.labmqtt.client;

import java.util.Random;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SensorTemperaturaPublisher {
	
	public static void main(String[] args) throws MqttException {
		
		// Criando o publisher
		String publisherId = UUID.randomUUID().toString();
		IMqttClient publisher = new MqttClient(MyConstants.URI_BROKER, publisherId);
		
		// Criando a mensagem
		MqttMessage msg = getTemperatureMessage();
		msg.setQos(0);
		msg.setRetained(true);
		
		// Conectando
		MqttConnectOptions options = new MqttConnectOptions();
		options.setAutomaticReconnect(true);
		options.setCleanSession(true);
		options.setConnectionTimeout(10);
		publisher.connect(options);
		
		// Publicando
		publisher.publish(MyConstants.TOPIC_1, msg);
		
		// Desconectando
		publisher.disconnect();
		
	}

	private static MqttMessage getTemperatureMessage() {
		
		Random r = new Random();
		
		double temperatura = 80 + r.nextDouble() * 20.0;
		
		byte[] payload = String.format("T:%04.2f", temperatura).getBytes();
		
		return new MqttMessage(payload);
		
	}
	
}

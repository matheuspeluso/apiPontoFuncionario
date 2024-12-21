package br.com.cotiinformatica.infrastructure.componnets;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class GeradorDeCoordenadas {
	private static final Random random = new Random();
	
	public String gerarCoordenada() {
        double latitude = -90 + (90 - (-90)) * random.nextDouble();
        double longitude = -180 + (180 - (-180)) * random.nextDouble();
        return String.format("%.4f, %.4f", latitude, longitude);
    }
}

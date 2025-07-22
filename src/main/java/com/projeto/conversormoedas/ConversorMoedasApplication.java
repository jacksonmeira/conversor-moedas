package com.projeto.conversormoedas;

import com.google.gson.JsonObject;
import com.projeto.conversormoedas.model.Conversor;
import com.projeto.conversormoedas.service.ApiClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ConversorMoedasApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConversorMoedasApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner(ApiClient apiClient) {
		return args -> {
			// Buscar taxas para USD
			JsonObject rates = apiClient.fetchRates("USD");
			Conversor conversor = new Conversor(rates);
			List<String> moedas = List.of("ARS", "BOB", "BRL", "CLP", "COP", "USD");

			Scanner sc = new Scanner(System.in);
			while (true) {
				System.out.println("\n--- Conversor de Moedas ---");
				for (int i = 0; i < moedas.size(); i++) {
					System.out.printf("%d) %s\n", i+1, moedas.get(i));
				}
				System.out.println("7) Sair");
				System.out.print("Escolha a moeda de origem: ");
				int fromIdx = sc.nextInt();
				if (fromIdx == 7) break;
				System.out.print("Escolha a moeda de destino: ");
				int toIdx = sc.nextInt();
				System.out.print("Valor a converter: ");
				double valor = sc.nextDouble();

				String from = moedas.get(fromIdx - 1);
				String to   = moedas.get(toIdx - 1);
				double result = conversor.converter(valor, from, to);
				System.out.printf("%.2f %s = %.2f %s%n", valor, from, result, to);
			}
			System.out.println("Obrigado por usar o Conversor!");
			sc.close();
			System.exit(0);
		};
	}
}

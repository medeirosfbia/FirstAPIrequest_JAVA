package br.com.bia;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class viaCep {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite seu CEP: ");
		String cep = sc.nextLine();
		cep = cep.replaceAll("[\\s-]", "");
		System.out.println(cep);
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		HttpClient client = HttpClient.newBuilder().build();
		HttpRequest req = HttpRequest.newBuilder(new URI(url)).build();
		HttpResponse<String> res = client.send(req, BodyHandlers.ofString());
		
		System.out.println(res.body());
		
		sc.close();
	}

}

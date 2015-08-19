package br.com.trocafavores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class TesteWebServiceTrocaFavores {

	public static void main(String[] args) {
		TesteWebServiceTrocaFavores favores = new TesteWebServiceTrocaFavores();
		// favores.leituraTodosUsuarios();
		favores.leituraUsuario("Kleiton");
	}

	public void leituraTodosUsuarios() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost/workspace-eclipse-php/troca-favores-webservice/usuario_resource.php");
		System.out.println("Executing request " + httpGet.getRequestLine());
		HttpResponse response;

		try {
			response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity());
				System.out.println(json);
				JSONObject objUsuario = new JSONObject(json);
				JSONArray array = objUsuario.getJSONArray("usuarios");

				List<Usuario> usuarios = new ArrayList<Usuario>();

				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = (JSONObject) array.get(i);
					Usuario usuario = new Usuario();
					usuario.setId((long) Integer.parseInt(obj.getString("id")));
					usuario.setNome(obj.getString("nome"));
					usuario.setUsuario(obj.getString("usuario"));
					usuarios.add(usuario);
				}
				usuarios.forEach(u -> System.out.println(u));

			} else {
				System.err.println("Tempo expirou");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void leituraUsuario(String user) {

		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost/workspace-eclipse-php/troca-favores-webservice/usuario_resource.php"
						+ "/?usuario=" + user);
		System.out.println("Executing request " + httpGet.getRequestLine());
		HttpResponse response;

		try {
			response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity());
				if (json.equals("NULL")) {
					JSONObject objUsuario = new JSONObject(json);
					JSONArray array = objUsuario.getJSONArray("usuarios");

					List<Usuario> usuarios = new ArrayList<Usuario>();

					for (int i = 0; i < array.length(); i++) {
						JSONObject obj = (JSONObject) array.get(i);
						Usuario usuario = new Usuario();
						usuario.setId((long) Integer.parseInt(obj
								.getString("id")));
						usuario.setNome(obj.getString("nome"));
						usuario.setUsuario(obj.getString("usuario"));
						usuarios.add(usuario);
					}
					usuarios.forEach(u -> System.out.println(u));
				} else {
					System.out.println("Usuário não encontrado");
				}
			} else {
				System.err.println("Tempo expirou");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cadastrarUsuario(String nome, String user) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://localhost/workspace-eclipse-php/troca-favores-webservice/usuario_resource.php"
						+ "/?usuario=" + user + "&nome=" + nome);
		System.out.println("Executing request " + httpGet.getRequestLine());
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity());
				System.out.println(json);
			} else {
				System.err.println("Tempo expirou");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

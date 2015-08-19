package br.com.exemplo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApacheHttpClientGet {

	public void leitura() {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(
				"http://olamundokr.url.ph/pessoa_resource.php");
		System.out.println("Executing request " + httpGet.getRequestLine());
		HttpResponse response;
		try {
			response = httpClient.execute(httpGet);
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				String json = EntityUtils.toString(response.getEntity());
				JSONObject objPessoas = new JSONObject(json);
				JSONArray array = objPessoas.getJSONArray("pessoas");
				List<Pessoa> pessoas = new ArrayList<Pessoa>();
				for (int i = 0; i < array.length(); i++) {
					JSONObject obj = (JSONObject) array.get(i);
					Pessoa p = new Pessoa();
					p.id = Integer.parseInt(obj.getString("id"));
					p.nome = obj.getString("nome");
					pessoas.add(p);
				}

				pessoas.forEach(p -> System.out.println(p));
			} else {
				System.err.println("Tempo expirou");
			}
			// Type listType = new TypeToken<List<Pessoa>>() {}.getType();
			// Gson gson =new Gson();
			// List<Pessoa> pessoas = gson.fromJson(json, listType);
			// pessoas.forEach(p -> System.out.println(p.nome));
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void escrita() {
		String url = "http://olamundokr.url.ph/pessoa_resource.php/?nome=Kleiton";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		HttpResponse httpResponse;
		try {
			httpResponse = httpClient.execute(httpGet);
			StatusLine statusLine = httpResponse.getStatusLine();
			if (statusLine.getStatusCode() == 200) {
				if (httpResponse != null) {
					System.out.println(EntityUtils.toString(httpResponse
							.getEntity()));
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void escritaAux() {
		String url = "http://olamundokr.url.ph/pessoa_resource.php/?nome=Kleiton";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		try {
			HttpGet httpGet = new HttpGet(url);
			System.out.println("Executing request " + httpGet.getRequestLine());

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

				public String handleResponse(final HttpResponse response)
						throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity)
								: null;
					} else {
						throw new ClientProtocolException(
								"Unexpected response status: " + status);
					}
				}

			};
			String responseBody = null;
			try {
				responseBody = httpClient.execute(httpGet, responseHandler);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("----------------------------------------");
			System.out.println(responseBody);
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void modeloConexao() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpGet httpget = new HttpGet("http://localhost/");

			System.out.println("Executing request " + httpget.getRequestLine());
			try {
				CloseableHttpResponse response = httpclient.execute(httpget);
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());

				// Get hold of the response entity
				HttpEntity entity = response.getEntity();

				// If the response does not enclose an entity, there is no need
				// to bother about connection release
				if (entity != null) {
					InputStream instream = entity.getContent();
					try {
						instream.read();
						// do something useful with the response
					} catch (IOException ex) {
						// In case of an IOException the connection will be
						// released
						// back to the connection manager automatically
						throw ex;
					} finally {
						// Closing the input stream will trigger connection
						// release
						instream.close();
					}
				}

			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	public static void main(String[] args) {
		ApacheHttpClientGet apacheHttpClientGet = new ApacheHttpClientGet();
		apacheHttpClientGet.leitura();
	}
}

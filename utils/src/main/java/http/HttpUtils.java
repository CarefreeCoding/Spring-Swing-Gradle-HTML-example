package http;

import objects.WebResponse;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class HttpUtils
{
	public static WebResponse getText(String link)
	{
		return getText(link, null);
	}

	public static WebResponse getText(String link, List<NameValuePair> params)
	{
		WebResponse response = new WebResponse();
		try
		{
			if (params != null && !params.isEmpty())
			{
				String paramString = URLEncodedUtils.format(params, "utf-8");
				link += "?" + paramString;
			}
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			response.setCode(connection.getResponseCode());

			if (response.getCode() >= 400)
			{
				String encoding = connection.getContentEncoding();
				encoding = encoding == null ? "UTF-8" : encoding;
				InputStream in;
				in = connection.getErrorStream();
				response.setContent(IOUtils.toString(in, encoding));
			}
			else
			{
				String encoding = connection.getContentEncoding();
				encoding = encoding == null ? "UTF-8" : encoding;
				InputStream in;
				in = connection.getInputStream();
				response.setContent(IOUtils.toString(in, encoding));
			}
			response.setMessage(connection.getResponseMessage());

			connection.disconnect();
		}
		catch (ConnectException e)
		{
			response.setContent(e.getMessage());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return response;
	}

	public static WebResponse postText(String link, List<NameValuePair> params)
	{
		WebResponse response = new WebResponse();
		try
		{
			HttpClient client = HttpClients.createDefault();
			HttpPost post = new HttpPost(link);
			post.setEntity(new UrlEncodedFormEntity(params));

			HttpResponse reply = client.execute(post);

			response.setCode(reply.getStatusLine().getStatusCode());
			response.setMessage(reply.getStatusLine().getReasonPhrase());

			HttpEntity entity = reply.getEntity();

			if (entity != null)
			{
				String encoding = "UTF-8";
				InputStream in;
				in = entity.getContent();
				response.setContent(IOUtils.toString(in, encoding));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return response;
	}
}

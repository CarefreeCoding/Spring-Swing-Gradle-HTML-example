package objects;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebRequest
{
	private String                  link;
	private HashMap<String, String> params;

	public WebRequest()
	{
		params = new HashMap<>();
	}

	public String getLink()
	{
		return link;
	}

	public void setLink(String link)
	{
		this.link = link;
	}

	public void addParam(String key, String value)
	{
		params.put(key, value);
	}

	public List<NameValuePair> getParams()
	{
		List<NameValuePair> params = new ArrayList<>();
		for (Map.Entry<String, String> entry : this.params.entrySet())
		{
			params.add(
					new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return params;
	}
}

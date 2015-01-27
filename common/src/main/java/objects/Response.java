package objects;

import java.io.Serializable;

public class Response implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String firstAddressArg;
	private String secondAddressArg;
	private String firstParamArg;
	private String secondParamArg;

	public Response()
	{
	}

	public String getFirstAddressArg()
	{
		return firstAddressArg;
	}

	public void setFirstAddressArg(String firstAddressArg)
	{
		this.firstAddressArg = firstAddressArg;
	}

	public String getSecondAddressArg()
	{
		return secondAddressArg;
	}

	public void setSecondAddressArg(String secondAddressArg)
	{
		this.secondAddressArg = secondAddressArg;
	}

	public String getFirstParamArg()
	{
		return firstParamArg;
	}

	public void setFirstParamArg(String firstParamArg)
	{
		this.firstParamArg = firstParamArg;
	}

	public String getSecondParamArg()
	{
		return secondParamArg;
	}

	public void setSecondParamArg(String secondParamArg)
	{
		this.secondParamArg = secondParamArg;
	}

	@Override
	public String toString()
	{
		String response = "{";
		response += "\"firstAddressArg\":\"" + getFirstAddressArg() + "\",";
		response += "\"secondAddressArg\":\"" + getSecondAddressArg() + "\",";
		response += "\"firstParamArg\":\"" + getFirstParamArg() + "\",";
		response += "\"secondParamArg\":\"" + getSecondParamArg() + "\"}";
		return response;
	}
}

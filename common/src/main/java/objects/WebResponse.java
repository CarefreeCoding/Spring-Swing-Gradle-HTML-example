package objects;

public class WebResponse
{
	private int    code;
	private String message;
	private String content;

	public WebResponse()
	{
		setCode(0);
		setMessage("");
		setContent("");
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}
}

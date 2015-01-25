package main;

import objects.WebRequest;
import objects.WebResponse;
import swing.controller.Controller;
import swing.messages.Message;
import swing.messages.MessageBus;
import swing.model.Model;

public class MainController extends
							Controller<Model, MainView, MainController>
{
	public MainController(MessageBus messageBus)
	{
		super(messageBus);
	}

	@Override
	protected void init()
	{
		controller = this;
		view = new MainView(controller);
	}

	public void get(WebRequest request)
	{
		Message message = new Message(Message.Type.Get);
		message.setData(request);
		send(message);
	}

	public void post(WebRequest request)
	{
		Message message = new Message(Message.Type.Post);
		message.setData(request);
		send(message);
	}

	@Override
	protected void receive(Message message)
	{
		if (message.getType().equals(Message.Type.Response))
		{
			view.readResponse((WebResponse) message.getData());
		}
	}

	public void close()
	{
		controller.send(new Message(Message.Type.Shutdown));
	}
}

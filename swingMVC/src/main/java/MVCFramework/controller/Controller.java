package MVCFramework.controller;

import MVCFramework.messages.Message;
import MVCFramework.messages.MessageBus;
import MVCFramework.model.Model;
import MVCFramework.view.View;

public abstract class Controller
		<M extends Model, V extends View, C extends Controller>
{
	protected V view;
	protected M model;
	protected C controller;

	protected MessageBus messageBus;
	private   boolean    isAlive;

	public Controller(MessageBus messageBus)
	{
		this.messageBus = messageBus;
		isAlive = true;
		init();
	}

	protected abstract void init();

	protected abstract void receive(Message message);

	protected void send(Message message)
	{
		messageBus.broadcast(message);
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	private void die()
	{
		isAlive = false;
	}

	public void broadcast(Message message)
	{
		receive(message);
		if (message.getType().equals(Message.Type.Shutdown))
		{
			if (view != null)
			{
				view.close();
			}
			if (model != null)
			{
				model.close();
			}
			die();
		}
	}
}
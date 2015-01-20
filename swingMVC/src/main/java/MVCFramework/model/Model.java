package MVCFramework.model;

import MVCFramework.controller.Controller;

public abstract class Model<C extends Controller>
{
	protected C controller;

	public Model(C controller)
	{
		this.controller = controller;
	}

	public abstract void close();
}
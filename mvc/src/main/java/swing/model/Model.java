package swing.model;

import swing.controller.Controller;

public abstract class Model<C extends Controller>
{
	protected C controller;

	public Model(C controller)
	{
		this.controller = controller;
	}

	public abstract void close();
}
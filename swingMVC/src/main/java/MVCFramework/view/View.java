package MVCFramework.view;

import MVCFramework.controller.Controller;
import MVCFramework.model.Model;

public abstract class View<M extends Model, C extends Controller>
{
	protected C controller;

	public View(M model, C controller)
	{
		this.controller = controller;

		loadComponents();
		assignListeners();
		registerModel(model);
	}

	protected abstract void loadComponents();

	protected abstract void assignListeners();

	protected abstract void registerModel(M model);

	public abstract void refresh();

	public abstract void close();
}

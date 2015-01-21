package painters;

public class Colors extends Theme
{
	private static Colors instance_;

	public Colors()
	{
		super(Themes.main);
	}

	public synchronized static void apply(Theme theme)
	{
		if (instance_ == null)
		{
			instance_ = new Colors();
		}
		instance_.applyTheme(theme);
	}

	public synchronized static java.awt.Color get(Color color)
	{
		if (instance_ == null)
		{
			instance_ = new Colors();
		}
		return instance_.getColor(color);
	}
}

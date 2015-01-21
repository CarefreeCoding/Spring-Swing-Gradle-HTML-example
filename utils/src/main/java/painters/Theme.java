package painters;

import java.util.Arrays;
import java.util.List;

public abstract class Theme
{
	public enum Themes
	{
		main,
		normal
	}

	public enum Color
	{
		NONE,

		// Generic
		BACKGROUND,
		FOREGROUND,

		// Buttons
		BUTTON_BACKGROUND,
		BUTTON_FOREGROUND,

		// Text field
		TEXT_FIELD_IDLE,
		TEXT_FIELD_FOCUS,
		TEXT_FIELD_FOREGROUND,

		// Separator
		SEPARATOR;

		public java.awt.Color color_;

		private Color()
		{
			this(0, 0, 0);
		}

		private Color(int r, int g, int b)
		{
			this(new java.awt.Color(r, g, b));
		}

		private Color(java.awt.Color color)
		{
			color_ = color;
		}

		public void setColor(int r, int g, int b)
		{
			setColor(new java.awt.Color(r, g, b));
		}

		public void setColor(java.awt.Color color)
		{
			color_ = color;
		}

		public Color getColor(Color color)
		{
			for (Color clr : values())
			{
				if (clr == color)
				{
					return clr;
				}
			}
			return NONE;
		}
	}

	private Themes name_;

	private List<Color> colors_;

	public Theme(Themes name)
	{
		name_ = name;
		colors_ = Arrays.asList(Color.values());
	}

	public Themes getName()
	{
		return name_;
	}

	public void setColor(Color color, int r, int g, int b)
	{
		setColor(color, new java.awt.Color(r, g, b));
	}

	public void setColor(Color clr, java.awt.Color color)
	{
		for (Color cl : colors_)
		{
			if (cl == clr)
			{
				cl.setColor(color);
			}
		}
	}

	public java.awt.Color getColor(Color clr)
	{
		for (Color cl : colors_)
		{
			if (cl == clr)
			{
				return cl.color_;
			}
		}
		return new java.awt.Color(0, 0, 0);
	}

	public void applyTheme(Theme themeToApply)
	{
		for (Color color : colors_)
		{
			setColor(color, themeToApply.getColor(color));
		}
	}
}

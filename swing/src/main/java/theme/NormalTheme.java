package theme;

import painters.Theme;

public class NormalTheme extends Theme
{
	public NormalTheme()
	{
		super(Themes.normal);

		// Generic
		setColor(Color.BACKGROUND, new java.awt.Color(48, 52, 67));
		setColor(Color.FOREGROUND, new java.awt.Color(240, 240, 240));

		// Buttons
		setColor(Color.BUTTON_BACKGROUND,
				 new java.awt.Color(5, 108, 161));
		setColor(Color.BUTTON_FOREGROUND,
				 new java.awt.Color(240, 240, 240));

		// Text field
		setColor(Color.TEXT_FIELD_IDLE, new java.awt.Color(240, 240, 219));
		setColor(Color.TEXT_FIELD_FOCUS, new java.awt.Color(250, 236, 157));
		setColor(Color.TEXT_FIELD_FOREGROUND, new java.awt.Color(5, 19, 98));

		// Separator
		setColor(Theme.Color.SEPARATOR, new java.awt.Color(34, 255, 26));
	}
}

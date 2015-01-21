package builders;

import painters.Colors;
import painters.Theme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class SwingBuilder
{
	private static final int    FONT_SIZE         = 15;
	private static final String FONT_NAME         = "Helvetica";
	private static final int    DEFAULT_FONT_SIZE = 0;

	public static JButton makeButton(String text)
	{
		return makeButton(text, DEFAULT_FONT_SIZE);
	}

	public static JButton makeButton(String text, int size)
	{
		return makeButton(text, size,
						  Colors.get(Theme.Color.BUTTON_BACKGROUND),
						  Colors.get(Theme.Color.BUTTON_FOREGROUND));
	}

	public static JButton makeButton(String text, int size, Color background,
									 Color foreground)
	{
		Font font = new Font(FONT_NAME, Font.PLAIN,
							 FONT_SIZE + size);
		JButton button = new JButton(text);
		button.setVisible(true);
		button.setOpaque(true);
		button.setFont(font);
		button.setBackground(background);
		button.setForeground(foreground);
		button.setFocusPainted(false);
		return button;
	}

	public static JLabel makeLabel(String text)
	{
		return makeLabel(text, DEFAULT_FONT_SIZE);
	}

	public static JLabel makeLabel(String text, int size)
	{
		return makeLabel(text, size, Font.PLAIN);
	}

	public static JLabel makeLabel(String text, int size, int type)
	{
		return makeLabel(text, size, type, Colors.get(Theme.Color.FOREGROUND));
	}

	public static JLabel makeLabel(String text, int size, int type,
								   Color foreground)
	{
		return makeLabel(text, size, type, foreground, null);
	}

	public static JLabel makeLabel(String text, int size, int type,
								   Color foreground, Color background)
	{
		Font font = new Font(FONT_NAME, type,
							 FONT_SIZE + size);
		JLabel label = new JLabel(text);
		label.setForeground(foreground);
		label.setFont(font);
		if (background != null)
		{
			label.setBackground(background);
			label.setOpaque(true);
		}
		return label;
	}

	public static JTextField makeTextField(int size, int length)
	{
		final JTextField field = new JTextField(length);
		field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_IDLE));
		field.setForeground(Colors.get(Theme.Color.TEXT_FIELD_FOREGROUND));

		field.setFont(new Font(FONT_NAME, Font.PLAIN,
							   FONT_SIZE + size));

		field.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_FOCUS));
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_IDLE));
			}
		});

		field.setOpaque(true);
		field.setVisible(true);
		field.setEnabled(true);
		return field;
	}

	public static JTextArea makeTextArea(int size, int width, int height)
	{
		final JTextArea field = new JTextArea("");

		field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_IDLE));
		field.setForeground(Colors.get(Theme.Color.TEXT_FIELD_FOREGROUND));

		field.setFont(new Font(FONT_NAME, Font.PLAIN,
							   FONT_SIZE + size));

		if (width > 0 && height > 0)
		{
			field.setSize(new Dimension(width, height));
			field.setMinimumSize(new Dimension(width, height));
			field.setMaximumSize(new Dimension(width, height));
			field.setPreferredSize(new Dimension(width, height));
		}
		field.addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e)
			{
				field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_FOCUS));
			}

			@Override
			public void focusLost(FocusEvent e)
			{
				field.setBackground(Colors.get(Theme.Color.TEXT_FIELD_IDLE));
			}
		});
		field.setVisible(true);
		field.setEnabled(true);
		return field;
	}

	public static JSeparator makeSeparator(int orientation)
	{
		Object oldBackground = UIManager.get("Separator.foreground");
		UIManager
				.put("Separator.foreground", Colors.get(Theme.Color.SEPARATOR));
		JSeparator separator = new JSeparator(orientation);
		separator.setBackground(Colors.get(Theme.Color.SEPARATOR));
		separator.setForeground(Colors.get(Theme.Color.SEPARATOR));
		UIManager.put("Separator.foreground", oldBackground);
		return separator;
	}
}

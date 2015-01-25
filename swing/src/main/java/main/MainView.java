package main;

import builders.SwingBuilder;
import net.miginfocom.swing.MigLayout;
import objects.WebRequest;
import objects.WebResponse;
import painters.Colors;
import painters.Theme;
import swing.model.Model;
import swing.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MainView extends View<Model, MainController>
{
	private JFrame frame;

	private JTextField link;

	private List<JTextField>  params;
	private List<JTextField>  key;
	private List<JTextArea>   value;
	private List<JScrollPane> area;

	private JButton get;
	private JButton post;

	private JTextField responseCode;
	private JTextField responseMessage;
	private JTextArea  responseContent;

	public MainView(MainController controller)
	{
		super(null, controller);
	}

	@Override
	protected void loadComponents()
	{
		frame = new JFrame();
		frame.getContentPane()
			 .setBackground(Colors.get(Theme.Color.BACKGROUND));

		frame.setLayout(new MigLayout("wrap 2, fill"));

		params = new ArrayList<>();
		key = new ArrayList<>();
		value = new ArrayList<>();
		area = new ArrayList<>();

		link = SwingBuilder.makeTextField(0, 32);

		for (int i = 0; i < 2; i++)
		{
			params.add(SwingBuilder.makeTextField(0, 27));
			key.add(SwingBuilder.makeTextField(0, 27));
			value.add(SwingBuilder.makeTextArea(0, 420, 100));
			area.add(new JScrollPane(value.get(i)));
		}

		get = SwingBuilder.makeButton("Get");
		post = SwingBuilder.makeButton("Post");

		responseCode = SwingBuilder.makeTextField(0, 32);
		responseMessage = SwingBuilder.makeTextField(0, 32);
		responseContent = SwingBuilder.makeTextArea(0, 420, 120);

		frame.add(SwingBuilder.makeLabel("Link"), "span 2");
		frame.add(link, "span 2");
		frame.add(SwingBuilder.makeSeparator(SwingConstants.HORIZONTAL),
				  "span 2, grow");
		for (int i = 0; i < params.size(); i++)
		{
			frame.add(SwingBuilder.makeLabel("Param " + (i + 1)));
			frame.add(params.get(i));
		}
		frame.add(SwingBuilder.makeSeparator(SwingConstants.HORIZONTAL),
				  "span 2, grow");
		for (int i = 0; i < key.size(); i++)
		{
			frame.add(SwingBuilder.makeLabel("Key " + (i + 1)));
			frame.add(key.get(i));
			frame.add(SwingBuilder.makeLabel("Value " + (i + 1)), "span 2");
			frame.add(area.get(i), "span 2");
			frame.add(SwingBuilder.makeSeparator(SwingConstants.HORIZONTAL),
					  "span 2, grow");
		}
		frame.add(get);
		frame.add(post);
		frame.add(SwingBuilder.makeSeparator(SwingConstants.HORIZONTAL),
				  "span 2, grow");
		frame.add(SwingBuilder.makeLabel("Code"), "span 2");
		frame.add(responseCode, "span 2");
		frame.add(SwingBuilder.makeLabel("Message"), "span 2");
		frame.add(responseMessage, "span 2");
		frame.add(SwingBuilder.makeLabel("Content"), "span 2");
		frame.add(responseContent, "span 2");

		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setLocation((int) frame.getLocation().getX(), 0);
		refresh();
	}

	@Override
	protected void assignListeners()
	{
		frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				controller.close();
			}
		});

		get.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				WebRequest request = createRequest();
				if (request.getLink().isEmpty())
				{
					return;
				}
				controller.get(request);
			}
		});

		post.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				WebRequest request = createRequest();
				if (request.getLink().isEmpty())
				{
					return;
				}
				controller.post(request);
			}
		});
	}

	private WebRequest createRequest()
	{
		WebRequest request = new WebRequest();
		request.setLink(link.getText());
		for (JTextField param : params)
		{
			request.addParam(param.getText());
		}
		String k;
		String v;
		for (int i = 0; i < key.size(); i++)
		{
			k = key.get(i).getText();
			v = value.get(i).getText();
			if (!k.isEmpty() && !v.isEmpty())
			{
				request.addParam(k, v);
			}
		}
		return request;
	}

	public void readResponse(WebResponse response)
	{
		responseCode.setText(String.valueOf(response.getCode()));
		responseMessage.setText(response.getMessage());
		responseContent.setText(response.getContent());
	}

	@Override
	protected void registerModel(Model model)
	{
	}

	@Override
	public void refresh()
	{
		frame.pack();
	}

	@Override
	public void close()
	{
		frame.dispose();
	}
}

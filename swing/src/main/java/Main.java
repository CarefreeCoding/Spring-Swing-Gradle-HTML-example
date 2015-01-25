import main.MainController;
import painters.Colors;
import swing.messages.MessageBus;
import theme.NormalTheme;

public class Main
{
	public static void main(String[] args)
	{
		Colors.apply(new NormalTheme());
		MessageBus messageBus = new MessageBus();
		messageBus.register(new MainController(messageBus));
	}
}

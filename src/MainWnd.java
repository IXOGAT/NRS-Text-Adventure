import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class MainWnd
{
	private static Label label2;
	private static Shell shell;
	private static String textInput;
	public static void main(String[] args)
	{
		Runner runner = new Runner();
		Display display = new Display();
		shell = new Shell(display);
		Splash splash = new Splash();
		//shell.setLayout(new FillLayout());
		
		label2 = new Label(shell, SWT.NONE);
		Font font = new Font(label2.getDisplay(), new FontData("Mono", 10, SWT.ITALIC));
		label2.setFont(font);
		label2.setText("here's some text with a font applied");
		label2.setBounds(0, 0, 800, 50);
		label2.setToolTipText("Random label expressing mouse listener event");
		label2.setBackground(display.getSystemColor(SWT.COLOR_DARK_GRAY));
		
		Label label = new Label(shell, SWT.BORDER);
		label.setText("Welcome to my text adventure!\nAre you ready to play?!?!");
		label.setToolTipText("All responses to your commands will appear here");
		label.setBackground(display.getSystemColor(SWT.COLOR_GRAY));
		//user can type in the text widget
		label.setBounds(0, 50, 800, 70);
		Text text = new Text(shell, SWT.NONE);
		text.setText("ENTER COMMANDS HERE!");
		text.setToolTipText("Enter all of your commands here");
		text.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		text.setForeground(display.getSystemColor(SWT.COLOR_CYAN));
		text.setBounds(0, 120, 800, 100);
		
		Button button = new Button(shell, SWT.PUSH);
		button.setText("A button");
		button.setToolTipText("what does it do?");
		button.setBounds(50, 220, 80, 60);
		//listening for button depression
		button.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				System.out.println(text.getText());
				text.setText("");
			}
		});
		//listening for enter key depression
		text.addListener(SWT.Traverse, new Listener()
		{
			@Override
			public void handleEvent(Event event)
			{
				if(event.detail == SWT.TRAVERSE_RETURN)
				{
					System.out.println("ENTER PRESSED!");
					System.out.println("Text recieved: " + text.getText());
					textInput = text.getText();
					String result = runner.logic(text.getText());
					if(result != "uh-oh!") 
					{
						label.setText(result);
					}
					
					text.setText("");
				}
			}
		});
		shell.setBounds(100, 100, 800, 315);
		shell.setText("Alex's Text Adventure!");
		shell.open();
		shell.addMouseMoveListener(e -> showSize(e));
		label2.addMouseMoveListener(e -> showSize(e));
		while (!shell.isDisposed())
		{
			if(!display.readAndDispatch())
			{
				display.sleep();
			}
		}
		display.dispose();
	}
	public static void showSize(MouseEvent e)
	{
		int x = e.x;
		int y = e.y;
		String s = "bounds for label: " + label2.getBounds() + "\n";
		s+= "bounds for shell: " + shell.getBounds() + "\n";
		s+= "mouse pointer: " + x + " " + y;
		label2.setText(s);
	}
	public static String getTextInput() 
	{
		return textInput;
	}
	public static void setTextInput(String textInput) 
	{
		MainWnd.textInput = textInput;
	}
}
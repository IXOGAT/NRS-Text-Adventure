/*
 * 
 * this class runs the program.
 * 
 */

public class Runner 
{
	/*
	public static void main(String[] args)
	{
		//call splash object
		Splash splash = new Splash();
		//Call splashscreen
		splash.splashScreen();
		splash.fightSplash();
		Menu menu = new Menu();
		menu.Display();
		Knife knife = new Knife();
		
	}
	*/
public String logic(String input)
{
	if (input.contains("y"))
	{
		return "Let's have some fun!:)";
	}
	else
	{
		return "uh-oh!";
	}
}
}

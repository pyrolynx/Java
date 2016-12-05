import java.io.FileNotFoundException;

public class Program {

	public static void main(String[] args) {
		
		String[] arguments = args;
		if (arguments.length != 3)
		{
//			arguments = new String[]{"100", "file.txt", ".\\Copies"};
			System.out.println("Invalid number of arguments!");
			System.exit(2);
		}
		try
		{
			MultiCopier copier = new MultiCopier(Integer.parseInt(arguments[0]), arguments[1], arguments[2]);
			copier.start();
		}
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
		
	}

}

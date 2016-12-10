import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MultiCopier {
	
	private ArrayList<Thread> copierThreads = new ArrayList<Thread>();
	
	public MultiCopier(int threadCount, String sourcePath, String destinationPath) throws FileNotFoundException
	{
		String[] names = getUniqueNames(new File(sourcePath), new File(destinationPath), threadCount);
		for (int i=0;i<threadCount;i++)
			copierThreads.add(new Thread(new Copier(sourcePath, destinationPath, names[i])));
	}
	
	public String[] getUniqueNames(File file, File path, int number)
	{
		int index = 1;
		ArrayList<String> names = new ArrayList<String>();
		String name = path.getAbsolutePath()+ "\\" + file.getName().replaceAll("\\.", " (%d).");
		File newFile = new File(String.format(name, index));
		while (newFile.exists() | number > names.size())
		{
			if (names.size() == number)
				break;
			if (!newFile.exists())
				names.add(newFile.getName());
			index++;
			newFile = new File(String.format(name, index));
		}
		return names.toArray(new String[0]);
	}
	
	public void start()
	{
		for (Thread t: copierThreads)
			t.start();
	}
}

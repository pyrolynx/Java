import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Copier implements Runnable{
	
	private InputStream source;
	private OutputStream destination;
	
	public Copier(String sourcePath, String destinationPath) throws FileNotFoundException
	{
			this.source = new FileInputStream(sourcePath);
			File sourceFile = new File(sourcePath).getAbsoluteFile();
			File path = new File(destinationPath).getAbsoluteFile();
			if (path.exists())
				if (path.isDirectory())
					this.destination = new FileOutputStream(
							destinationPath + "\\" + Copier.getUniqueName(sourceFile, path));
				else
					path.mkdir();
			else
				path.mkdir();
	}
	
	public Copier(String sourcePath, String destinationPath, String uniqueName) throws FileNotFoundException
	{
		this.source = new FileInputStream(sourcePath);
		File path = new File(destinationPath).getAbsoluteFile();
		if (path.exists())
			if (!path.isDirectory())
				path.mkdir();
			else
			{}
		else
			path.mkdir();

		this.destination = new FileOutputStream(
				path.getAbsolutePath() + "\\" + uniqueName);
	}
	
	public static String getUniqueName(File file, File path)
	{
		int index = 1;
		String name = file.getName().replaceAll("\\.", " (%d).");
		File newFile = new File(String.format(name, index));
		while (newFile.exists())
		{
			index++;
			newFile = new File(String.format(name, index));
		}
		return newFile.getName();
	}
	
	public void copy() throws IOException
	{
		int buffer = source.read();
		while (buffer != -1)
		{
			destination.write(buffer);
			buffer = source.read();
		}
	}

	@Override
	public void run() {
		try
		{
			this.copy();
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
}

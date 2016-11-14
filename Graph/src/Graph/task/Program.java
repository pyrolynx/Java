package Graph.task;

import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import Graph.entities.*;

public class Program {
	
	public static Graph<User> socialNetwork;
	
	public static void parseLink(String link)
	{
		Item<User> firstUserItem = null;
		String[] users = link.split("-");
		User firstUser = new User(users[0].trim());
		if (socialNetwork.find(firstUser) == null)
			firstUserItem = new Item<User>(socialNetwork, firstUser);
		else
			firstUserItem = socialNetwork.find(firstUser);
		socialNetwork.add(firstUserItem);
		
		if (users.length > 1)
		{
			Item<User> secondUserItem = null;
			User secondUser = new User(users[1].trim());
			if (socialNetwork.find(secondUser) == null)
				secondUserItem = new Item<User>(socialNetwork, secondUser);
			else
				secondUserItem = socialNetwork.find(firstUser);
			socialNetwork.add(secondUserItem);
			socialNetwork.addEdge(firstUserItem, secondUserItem);
		}
		
	}
	
	public static void parseLinks(String filename)
	{
		socialNetwork = new Graph<User>();
		try (Stream<String> stream = Files.lines(Paths.get(filename), Charset.forName("UTF-8"))) {
			for (Object line: stream.toArray())
				parseLink((String) line);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printFriends()
	{
		for (Item<User> user: socialNetwork)
		{
			System.out.println(user.value);
			for (Item<User> friend: socialNetwork.getAdjacent(user))
				System.out.println("\t"+friend.value);
		}
	}
	
	
	public static void main(String[] args)
	{
		
		String file = null;
		if (args.length == 0)
		{
			file = "links.txt";
		}
		else
		{
			file = args[0];
		}
		parseLinks(file);
		printFriends();
		
	}
}

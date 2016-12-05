package Graph.task;

import java.io.IOException;
import java.nio.charset.Charset;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
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
				secondUserItem = socialNetwork.find(secondUser);
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
	
	public static void printPossibleFriends(User user)
	{
		ArrayList<User> possibleFriends = new ArrayList<User>();
		ArrayList<Item<User>> friends = 
				socialNetwork.getAdjacent(new Item<User>(null, user));
		for (Item<User> friend: friends)
			for (Item<User> mate: socialNetwork.getAdjacent(friend))
				if (!possibleFriends.contains(mate.value)
						&& !friends.contains(mate)
						&& !user.equals(mate.value))
					possibleFriends.add(mate.value);
		ListIterator<User> it = possibleFriends.iterator();
		while (it.hasNext())
		{
			User friend = it.next();
			for (Item<User> mate: socialNetwork.getAdjacent(new Item<User>(null ,friend)))
				if (!possibleFriends.contains(mate.value)
						&& !friends.contains(mate)
						&& !user.equals(mate.value))
					possibleFriends.add(mate.value);
		}
		System.out.println("Maybe they can be friends of %1$s".format(user.surname));
		System.out.println(possibleFriends);
	}
	
	
	public static void main(String[] args)
	{
		
		String file = null;
		User user = null;
		if (args.length != 2)
		{
			file = "links.txt";
			user = new User("Plaxin");
//			System.out.println("Empty args! Exit..");
//			System.exit(0);
		}
		else
		{
			file = args[0];
			user = new User(args[1]);
		}
		parseLinks(file);
		printPossibleFriends(user);
		
	}
}

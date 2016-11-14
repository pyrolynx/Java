package Graph.task;

public class User {
	public final String surname;
	
	public User(String surname)
	{
		this.surname = surname;
	}
		
	@Override
	public boolean equals(Object other)
	{
		return ((User)other).surname.equals(this.surname);
	}
	
	@Override
	public String toString()
	{
		return surname;
	}
	
}

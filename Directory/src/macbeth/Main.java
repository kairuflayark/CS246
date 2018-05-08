package macbeth;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    //Collection<String> directory = new ArrayList<String>();
		//Collection<String> directory = new LinkedList<String>();
		//Collection<String> directory = new HashSet<String>();
		Collection<String> directory = new TreeSet<String>();

	    directory.add("Bob");
	    directory.add("Susan");
	    directory.add("Henry");
	    directory.add("Clara");

	    for (String entry : directory) {
	        //System.out.println(entry);
        }

		Collection<User> directory2 = new ArrayList<User>();
		//Collection<User> directory2 = new LinkedList<User>();
		//Collection<User> directory2 = new HashSet<User>();
		//Collection<User> directory2 = new TreeSet<User>();

		directory2.add(new User("bob", "555-1234", "bob@gmail.com"));
		directory2.add(new User("susan", "555-1234", "susan@gmail.com"));
		directory2.add(new User("mary", "555-1234", "mary@gmail.com"));

		for (User entry : directory2) {
			//System.out.println(entry.toString());
		}

		//Map<String, User> directory3 = new HashMap<String,User>();
		Map<String, User> directory3 = new TreeMap<String,User>();

		directory3.put("bob",new User("bob", "555-1234", "bob@gmail.com"));
		directory3.put("susan",new User("susan", "555-1234", "susan@gmail.com"));
		directory3.put("mary",new User("mary", "555-1234", "mary@gmail.com"));

		System.out.println(directory3.get("susan").toString());

		for (String key : directory3.keySet()) {
			System.out.println(key);
		}

		for (User value : directory3.values()) {
			System.out.println(value.toString());
		}




	}
}

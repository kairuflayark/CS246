package macbeth;

import com.google.gson.Gson;

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

		//Collection<User> directory2 = new ArrayList<User>();
		//Collection<User> directory2 = new LinkedList<User>();
		//Collection<User> directory2 = new HashSet<User>();
		Collection<User> directory2 = new TreeSet<User>();

		directory2.add(new User("bob", "555-1234", "bob@gmail.com", 34));
		directory2.add(new User("susan", "555-1234", "susan@gmail.com", 62));
		directory2.add(new User("mary", "555-1234", "mary@gmail.com", 17));

		for (User entry : directory2) {
			//System.out.println(entry.toString());
		}

		//Map<String, User> directory3 = new HashMap<String,User>();
		Map<String, User> directory3 = new TreeMap<String,User>();

		directory3.put("bob",new User("bob", "555-1234", "bob@gmail.com", 34));
		directory3.put("susan",new User("susan", "555-1234", "susan@gmail.com", 62));
		directory3.put("mary",new User("mary", "555-1234", "mary@gmail.com", 17));

		//System.out.println(directory3.get("susan").toString());

		for (String key : directory3.keySet()) {
			//System.out.println(key);
		}

		for (User value : directory3.values()) {
			//System.out.println(value.toString());
		}

		User user1 = new User("bob","555-1234","bob@gmail.com", 34);
		//System.out.println(user1.toString());

		Gson gson = new Gson();
		String text = gson.toJson(user1);
		//System.out.println(text);

		User user2;
		user2 = gson.fromJson(text, User.class);
		//System.out.println(user2.toString());


		// Store the values in the TreeMap into an Array List
		// Sort the ArrrayList according to the Comparable interface defined in the User class
		List<User> sortedList = new ArrayList<User>(directory3.values());
		Collections.sort(sortedList);
		for (User entry : sortedList) {
			//System.out.println(entry.toString());
		}

		// Resort the ArrayList
		// This time define a new Comparator object
		// Defining the behavior of the new Comparator object this way
		// is called an "inner class".
		Collections.sort(sortedList, new Comparator<User>() {
			@Override
			public int compare(User o1, User o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});

		for (User entry : sortedList) {
			//System.out.println(entry.toString());
		}

		// Resort the ArrayList
		// This time use a lambda.  Lambda's are functions without names or types.
		// Format: (param1, param2, ...) -> function
		// Compare this to the code in the Comparator above
		Collections.sort(sortedList, (o1, o2) -> o1.getEmail().compareTo(o2.getEmail()));
		for (User entry : sortedList) {
			System.out.println(entry.toString());
		}
	}
}

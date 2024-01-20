


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapUse {

	public static void main(String[] args) {
		HashMap m = new HashMap();
		m.put(1,"A");
		m.put(2,"B");
		m.put(3,"C");
		m.put(4,"A");
		m.put(5, "D");
		m.put(null,"E");
		m.put(null, "F");
		m.put(5, "P");
		System.out.println("==========================");
		System.out.println("Print HashMap");
		System.out.println(m);
		System.out.println("==========================");
		System.out.println("To Retrive object");
		System.out.println(m.get(1));
		System.out.println("==========================");
		System.out.println("To remove object");
		System.out.println(m.remove(5));
		System.out.println("==========================");
		System.out.println("After removing key 5 ");
		System.out.println(m);
		System.out.println("==========================");
		System.out.println("Check Contains Key");
		System.out.println(m.containsKey(3));
		System.out.println("==========================");
		System.out.println("Check Contain Value F");
		System.out.println(m.containsValue("F"));
		System.out.println("==========================");
		System.out.println("Check Contain Value G");
		System.out.println(m.containsValue("G"));
		System.out.println("==========================");
		System.out.println("Check HashMap is Empty");
		System.out.println(m.isEmpty());
		System.out.println("==========================");
		System.out.println("Calculate size of HashMap");
		System.out.println(m.size());
		System.out.println("==========================");
//		System.out.println("To Clear");
//		m.clear();
//		System.out.println("==========================");
//		System.out.println("After clear");
//		System.out.println(m);
//		System.out.println("==========================");
		System.out.println("To print KeySet");
		System.out.println(m.keySet());
		System.out.println("==========================");
		System.out.println("To print Key Value");
		System.out.println(m.values());
		System.out.println("==========================");
		System.out.println("To print Entry");
		System.out.println(m.entrySet());
		System.out.println("To print all entry individual");
		for(Object e:m.keySet())
		{
			System.out.println(e);
		}
		System.out.println("==========================");
		for(Object i:m.values())
		{
			System.out.println(i);
		}
		System.out.println("==========================");
		for(Object j : m.keySet())
		{
			System.out.println(j+"  "+m.get(j));
		}
		

	}
}

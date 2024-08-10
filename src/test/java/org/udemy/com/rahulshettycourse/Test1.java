package org.udemy.com.rahulshettycourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

// Count number of names starting with alphabet A in the list.
public class Test1 {

//	@Test
	public void regular() {
		ArrayList<String> names = new ArrayList<>();
		names.add("Tapas");
		names.add("Abhijeet");
		names.add("Don");
		names.add("Akashi");
		names.add("Panda");

		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).charAt(0) == 'A') {
				count++;
			}
		}

		System.out.println("names starting with alphabet A :" + count);
	}

//	@Test
	public void streamFilter() {

//		Initialize arrayList.
		ArrayList<String> names = new ArrayList<>();
		names.add("Tapas");
		names.add("Abhijeet");
		names.add("Don");
		names.add("Akashi");
		names.add("Panda");
		names.add("Astriks");

//		using streams.
		long count = names.stream().filter(name -> name.charAt(0) == 'A').count();
		System.out.println("names starting with alphabet A :" + count);

//		creating a stream.
		long count1 = Stream.of("Tapas", "Abhijeet", "Don", "Akashi", "Panda", "Astriks").filter(s -> {
			return s.charAt(0) == 'A';
		}).count();
		System.out.println("names starting with alphabet A :" + count1);

//		iterator example.
		names.stream().iterator().forEachRemaining(s -> System.out.println(s));
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
//		limit example.
		names.stream().filter(s -> s.length() > 4).limit(2L).forEach(s -> System.out.println(s));

	}

//	@Test
	public void streamMap() {
		Stream.of("Tapas", "Abhijeet", "Don", "Akashi", "Panda", "Astriks").filter(s -> {
			return s.charAt(s.length() - 1) == 'a';
		}).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

//		sorted example.
		String[] arr = { "Tapas", "Abhijeet", "Don", "Akashi", "Panda", "Astriks" };
//		Arrays.stream(arr).filter(s -> s.charAt(0) == 'A').sorted().forEach(s -> System.out.println(s.toUpperCase()));

//		merging lists with streams.
		List<String> list1 = new ArrayList<>();
		list1.add("A");
		list1.add("B");
		list1.add("C");

		List<String> list2 = new ArrayList<>();
		list2.add("D");
		list2.add("E");
		list2.add("F");

//		list1.addAll(list2);
		Stream.concat(list1.stream(), list2.stream()).forEach(s -> System.out.println(s));

//		anyMatch()
		boolean flag = Arrays.stream(arr).anyMatch(s -> s.equalsIgnoreCase("Tapas"));
		Assert.assertTrue(flag);

	}

	@Test
	public void streamTest() {
//		collector.
		List<String> ls = Stream.of("Tapas", "Abhijeet", "Don", "Akashi", "Panda", "Astriks")
				.filter(s -> s.startsWith("A")).limit(1).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls);

//		sort and print unique numbers only.
		int[] arr = { 3, 2, 2, 7, 5, 1, 9, 7 };
		Set<Integer> mySet = Arrays.stream(arr).boxed().collect(Collectors.toSet());
		System.out.println(mySet);

		List<Integer> ls2 = Arrays.stream(arr).boxed().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls2);
	}

}

import java.util.*;

public class ListTest
{
    public static void main(String[] args)
    {
        MyLinkedList<String> list0 = new MyLinkedList<String>();
        MyLinkedList<String> list1 = new MyLinkedList<String>();
        MyLinkedList<String> list2 = new MyLinkedList<String>();

        list1.addFirst("node1");
        System.out.println("1-element list: " + list1);
        list2.addFirst("node2"); list2.addFirst("node1");
        System.out.println("2-element list: " + list2);
        
        System.out.println("\nTesting getFirst...");
        System.out.println(list0.getFirst());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getFirst().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getFirst().equals("node1")?"PASSED":"**FAILED**");
        
        System.out.println("\nTesting getLast...");
        System.out.println(list0.getLast());
        System.out.println(list1.size() + " " + list1);
        System.out.println(list1.getLast().equals("node1")?"PASSED":"**FAILED**");
        System.out.println(list1.size() + " " + list1);
        System.out.println(list2.size() + " " + list2);
        System.out.println(list2.getLast().equals("node2")?"PASSED":"**FAILED**");
        System.out.println(list2.size() + " " + list2);

        System.out.println("\nTesting add...");
        MyLinkedList<String> list3 = new MyLinkedList<String>();
        MyLinkedList<String> list4 = new MyLinkedList<String>();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        System.out.println("3-element list: " + list3);
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        System.out.println("4-element list: " + list4);

        System.out.println("\nTesting set...");
        MyLinkedList<String> test = new MyLinkedList<String>();
        System.out.println("  empty list test = " + ((test.set(2,"bad") == null)?"PASSED":"**FAILED**"));
        test.addFirst("Mark");
        test.addFirst("Sohaib");
        test.addFirst("Salman");
        System.out.println("  return value test = " + ((test.set(1,"Nora")).equals("Sohaib")?"PASSED":"**FAILED**"));
        System.out.println("  non-empty test = " + ((test.get(0).equals("Salman") && test.get(1).equals("Nora") &&
                           test.get(2).equals("Mark"))?"PASSED":"**FAILED**"));

        System.out.println("\nTesting addAfter...");
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("one");
        other.add("two");
        other.add("three");
        other.add("four");
        System.out.println(other.size() + " " + other);
        other.addAfter(2,"three.5");
        System.out.println((other.get(3).equals("three.5")?"PASSED":"**FAILED**"));
        System.out.println(other.size() + " " + other);
        
        System.out.println("\nTesting lastIndex...");
        System.out.println((test.lastIndex("Salman")==0)?"PASSED":"**FAILED**");
        test.addFirst("Mark");
        System.out.println((test.lastIndex("Mark")==3)?"PASSED":"**FAILED**");

        System.out.println("\nTesting clone...");
        MyLinkedList<String> empty = new MyLinkedList<String>();
        list1 = empty.clone();
        System.out.println("  empty list test = " + (list1.isEmpty()?"PASSED":"**FAILED**"));
        MyLinkedList<String> another = other.clone();
        System.out.println(another.size() + " " + another);
        System.out.println("  making sure nodes not shared...");
        other.remove("two");
        System.out.println(other.size() + " " + other);
        System.out.println(another.size() + " " + another);

        //custom removeAll test. Add nodes and remove all 3's
        System.out.println("\nTesting removeAll...");
        MyLinkedList<String> testRemoveAll = new MyLinkedList<String>();
        testRemoveAll.addFirst("3");
        testRemoveAll.addFirst("2");
        testRemoveAll.addFirst("3");
        testRemoveAll.addFirst("1");
        testRemoveAll.removeAll("3");
        System.out.println(testRemoveAll.contains("3")?"**FAILED**":"PASSED");
        System.out.println(testRemoveAll);
        
        System.out.println("\nTesting equals...");
        System.out.println("  reflexive test = " + (list2.equals(list2)?"PASSED":"**FAILED**"));
        MyLinkedList<String> emptyList = new MyLinkedList<String>();
        list0.clear();
        list1.clear();
        list1.add("node1");
        System.out.println("  empty list test/true = " + (emptyList.equals(list0)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test1/false = " + (!emptyList.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  empty list test2/false = " + (!list1.equals(emptyList)?"PASSED":"**FAILED**"));
        list0.add("node1");
        System.out.println("  singleton test = " + (list0.equals(list1)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 1/false = " + (!list1.equals(list2)?"PASSED":"**FAILED**"));
        System.out.println("  subset inclusion 2/false = " + (!list2.equals(list1)?"PASSED":"**FAILED**"));
        list0.add("node2"); list0.add("node3"); list0.add("node4");
        list0.add("node5"); list0.add("node6"); list0.add("node7");
        list4.add("node5"); list4.add("node6"); list4.add("node7");
        System.out.println("  7-element test/true = " + (list0.equals(list4)?"PASSED":"**FAILED**"));
        list0.remove("node4");
        list0.add("node5");
        System.out.println("  7-element test/false = " + (!list0.equals(list4)?"PASSED":"**FAILED**"));
        System.out.println("  7-element test/false = " + (!list4.equals(list0)?"PASSED":"**FAILED**"));
	
        System.out.println("\nTesting split...");
        MyLinkedList<String> result;
        list0.clear();
        list1.clear();
        list1.add("node1");
        list2.clear();
        list2.add("node1");
        list2.add("node2");
        list3.clear();
        list3.add("node1"); list3.add("node2"); list3.add("node3");
        list4.clear();
        list4.add("node1"); list4.add("node2"); list4.add("node3"); list4.add("node4");
        MyLinkedList<String> list5 = new MyLinkedList<String>();
        list5.add("node1"); list5.add("node2"); list5.add("node3"); list5.add("node4");
        list5.add("node5");
        MyLinkedList<String> list6 = new MyLinkedList<String>();
        list6.add("node1"); list6.add("node2"); list6.add("node3"); list6.add("node4");
        list6.add("node5"); list6.add("node6");
        System.out.print("SPLIT ");
        System.out.println(list0.size() + " " + list0);
        result = list0.split();
        System.out.println("  list " + list0.size() + " " + list0);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list1.size() + " " + list1);
        result = list1.split();
        System.out.println("  list " + list1.size() + " " + list1);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list2.size() + " " + list2);
        result = list2.split();
        System.out.println("  list " + list2.size() + " " + list2);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list3.size() + " " + list3);
        result = list3.split();
        System.out.println("  list " + list3.size() + " " + list3);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list4.size() + " " + list4);
        result = list4.split();
        System.out.println("  list " + list4.size() + " " + list4);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list5.size() + " " + list5);
        result = list5.split();
        System.out.println("  list " + list5.size() + " " + list5);
        System.out.println("  result " + result.size() + " " + result);
        System.out.print("SPLIT ");
        System.out.println(list6.size() + " " + list6);
        result = list6.split();
        System.out.println("  list " + list6.size() + " " + list6);
        System.out.println("  result " + result.size() + " " + result);
		
        //test doubler. Added an established set then
        //checked if it equals the expected outcome
        System.out.println("\nTesting doubler...");
        MyLinkedList<String> testDoubler = new MyLinkedList<String>();
        testDoubler.addFirst("4");
        testDoubler.addFirst("4");
        testDoubler.addFirst("3");
        testDoubler.addFirst("2");
        testDoubler.addFirst("1");
        System.out.println(testDoubler);
        testDoubler.doubler();
        System.out.println(testDoubler);
        System.out.println(testDoubler.get(0).equals("1") && 
        		testDoubler.get(1).equals("1") && 
        		testDoubler.get(2).equals("2") &&
        		testDoubler.get(3).equals("2") &&
        		testDoubler.get(4).equals("3") &&
        		testDoubler.get(5).equals("3") &&
        		testDoubler.get(6).equals("4") &&
        		testDoubler.get(7).equals("4") &&
        		testDoubler.get(8).equals("4") &&
        		testDoubler.get(9).equals("4")?"PASSED":"**FAILED**");
      
        //test for sublist, using a list of 7 objects matching index
        System.out.println("\nTesting sublist...");
        MyLinkedList<String> testSublist = new MyLinkedList<String>();
        testSublist.addFirst("6");
        testSublist.addFirst("5");
        testSublist.addFirst("4");
        testSublist.addFirst("3");
        testSublist.addFirst("2");
        testSublist.addFirst("1");
        testSublist.addFirst("0");
        
        //create clones to show different sublist examples
        MyLinkedList<String> testSub = testSublist.sublist(1, 5);
        MyLinkedList<String> testSub2 = testSublist.sublist(2, 4);

        //original list
        System.out.println(testSublist);
        //successful sublist
        System.out.println(testSub);
        System.out.println(testSub2);
        
        //error when ints are same
        MyLinkedList<String> testSub3 = testSublist.sublist(3, 3);
        System.out.println(testSub3);
        
        //error when j is greater than size
        MyLinkedList<String> testSub4 = testSublist.sublist(4, 8);
        System.out.println(testSub4);
        
        //error when i is less than 0
        MyLinkedList<String> testSub5 = testSublist.sublist(-5, 4);
        System.out.println(testSub5);
    }
}

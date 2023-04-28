
/**
 * IMPORTANT: Do not change the method headers. Your tests will be run against
 * good and bad implementations of MyLinkedList. You will only receive points
 * if your test passes when run on a good implementation and fails for the
 * corresponding bad implementation.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class MyLinkedListCustomTester {

	// Optional: add test variables here
	private MyLinkedList<Integer> emptyIntegerList;
    private MyLinkedList<String> threeStringList;
    private String[] strData = {"CSE 12", "Paul Cao", "Christine Alvarado"};
	private String addElement="Anthony";
	private int midNode=2;
	/**
	 * This sets up the test fixture. JUnit invokes this method before
	 * every testXXX method. The @Before tag tells JUnit to run this method
	 * before each test.
	 */
	@Before
	public void setUp() throws Exception {
		// Optional: add setup here
        emptyIntegerList = new MyLinkedList<Integer>();
        threeStringList = new MyLinkedList<>();

		MyLinkedList<String>.Node node0 =  
            this.threeStringList.new Node(this.strData[0]);
        MyLinkedList<String>.Node node1 =  
            this.threeStringList.new Node(this.strData[1]);
        MyLinkedList<String>.Node node2 =  
            this.threeStringList.new Node(this.strData[2]);

        this.threeStringList.head.next = node0;
        node0.prev = this.threeStringList.head;
        node0.next = node1;
        node1.prev = node0;
        node1.next = node2;
        node2.prev = node1;
        node2.next = this.threeStringList.tail;
        this.threeStringList.tail.prev = node2;
        this.threeStringList.size = 3;
	}
	/**
	 * Aims to test the add(E data) method with a valid argument.
	 */
	@Test
	public void testCustomAdd() {
		// TODO: add your test here
		MyLinkedList<String>.Node oldLastNode = this.threeStringList.tail.prev;
        this.threeStringList.add(addElement);
        assertEquals("Tail node should point back to the new node", 
            "Anthony", this.threeStringList.tail.prev.data);
        assertEquals("Previous last node should point to the new added node",
			"Anthony", oldLastNode.next.data);
        assertEquals("Check size is updated", 4, this.threeStringList.size);
        assertSame("Added node previous should be previous last node",
            oldLastNode, this.threeStringList.tail.prev.prev);
        assertSame("New added node next should point to tail",
            this.threeStringList.tail.prev.next, this.threeStringList.tail);
	}

	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the beginning of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToStart() {
		// TODO: add your test here
		threeStringList.add(0,addElement);

		assertEquals("New node should be accessible from head", 
		"Anthony", this.threeStringList.head.next.data);
        assertEquals("New node should be accessible from tail", 
            "Anthony", this.threeStringList.tail.prev.prev.prev.prev.data);
        assertEquals("Size of the LinkedList should be updated", 
            4, this.threeStringList.size);
        assertSame("Make sure the referece from head and tail are the same", 
            this.threeStringList.head.next, this.threeStringList.tail.prev.prev.prev.prev);
        assertSame("Added node should have correct previous pointer",
            this.threeStringList.head.next.prev, this.threeStringList.head);
        assertSame("Added node should have the correct next pointer",
            this.threeStringList.head.next.next, this.threeStringList.tail.prev.prev.prev);
	}
	/**
	 * Aims to test the add(int index, E data) method.
	 * Add a valid argument to the middle of MyLinkedList.
	 */
	@Test
	public void testCustomAddIdxToMiddle() {
		// TODO: add your test here
		threeStringList.add(midNode,addElement);

		assertEquals("New node should be accessible from head", 
		"Anthony", this.threeStringList.head.next.next.next.data);
        assertEquals("New node should be accessible from tail", 
            "Anthony", this.threeStringList.tail.prev.prev.data);
        assertEquals("Size of the LinkedList should be updated", 
            4, this.threeStringList.size);
        assertSame("Make sure the referece from head and tail are the same", 
            this.threeStringList.head.next.next.next, this.threeStringList.tail.prev.prev);
        assertSame("Added node should have correct previous pointer",
            this.threeStringList.head.next.next.next.prev, this.threeStringList.head.next.next);
        assertSame("Added node should have the correct next pointer",
            this.threeStringList.head.next.next.next.next, this.threeStringList.tail.prev);
	
	}

	/**
	 * Aims to test the remove(int index) method. Remove from an empty list.
	 */
	@Test
	public void testCustomRemoveFromEmpty() {
		// TODO: add your test here
		assertThrows(IndexOutOfBoundsException.class, () -> {
			emptyIntegerList.remove(0);
		});
	}

	/**
	 * Aims to test the remove(int index) method.
	 * Remove a valid argument from the middle of MyLinkedList.
	 */
	@Test
	public void testCustomRemoveFromMiddle() {
		// TODO: add your test here
		
	}

	/**
	 * Aims to test the set(int index, E data) method.
	 * Set an out-of-bounds index with a valid data argument.
	 */
	@Test
	public void testCustomSetIdxOutOfBounds() {
		// TODO: add your test here
	}
}

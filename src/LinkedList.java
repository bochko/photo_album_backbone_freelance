public class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = null;
		current = null;
	}

	// determines if list is empty
	public boolean empty() {
		return head == null;
	}

	public boolean full() {
		return false;
	}

	// set current node to head
	public void findFirst() {
		current = head;
	}

	// set current node to next node, relative to the current one
	public void findNext() {
		current = current.next;
	}

	// determines if the next node exists, if it doesn't returns true
	public boolean last() {
		return current.next == null;
	}

	// retrieve data of current node
	public T retrieve() {
		return current.data;
	}

	// set data of current node
	public void update(T val) {
		current.data = val;
	}

	// remove current node
	public void remove() {
		if (head == null)
			return;
		if (head == current) {
			head = head.next;
			current = head;
			return;
		}
		Node<T> prev = head;
		while (prev.next != current)
			prev = prev.next;
		prev.next = current.next;
		if (current == null)
			current = head;
		else
			current = current.next;
	}

	// insert new node and set current node to it
	public void insert(T val) {
		Node<T> newNode = new Node<T>(val);
		if (head == null) {
			head = newNode;
			current = newNode;
		} else {
			newNode.next = current.next;
			current.next = newNode;
			current = newNode;
		}
	}
}

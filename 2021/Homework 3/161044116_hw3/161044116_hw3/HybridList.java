/**
 *
 * @param <E> singlelinklist node
 */
public class HybridList<E> {
    private HybridList.Node<E> head = null;
    private int size = 0;

    /** Add an item to the front of the list.
     @param color of furniture
     @param model of furniture
     */
    public void addFirst(E color,E model) {
        head = new HybridList.Node<>(color,model,head);
        size++;
    }
    /** Append item to the end of the list
     @param color color of furniture
     @param model model of furniture
     @return true (as specified by the Collection interface)
     */
    public boolean add(E color,E model) {
        add(size, color,model);
        return true;
    }
    /** Insert the specified item at index
     @param index The position where item is to be inserted
     @param color color of furniture
     @param model model of furniture
     @throws IndexOutOfBoundsException if index is out of range
     */
    public void add(int index, E color,E model) {
        if (index < 0 || index > size) {   //index checking
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(color,model);
        } else {
            HybridList.Node<E> node = getNode(index-1);
            addAfter(node,color,model);
        }
    }
    /** Add a node after a given node
     @param node The node preceding the new item
     @param color color of furniture
     @param model model of furniture
     */
    public void addAfter(HybridList.Node<E> node, E color,E model) {
        node.next = new HybridList.Node<>(color,model, node.next);
        size++;
    }
    public HybridList.Node<E> getNode(int index) {
        HybridList.Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }
    /** Get the current size of the array
     @return The current size of the array
     */
    public int getSize() {
        return size;
    }
    /** Get the data at index
     @param index The position of the data to return
     @return The data at index
     @throws IndexOutOfBoundsException if index is out of range
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        HybridList.Node<E> node = getNode(index);
        return (E) node.furnitures;
    }
    /** Get the data at index
     @param index The position of the data to return
     @return color of furniture
     @throws IndexOutOfBoundsException if index is out of range
     */
    public E getcolor(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        return getNode(index).furnitures.get(0);
    }
    /** Get the data at index
     @param index The position of the data to return
     @return model of furniture
     @throws IndexOutOfBoundsException if index is out of range
     */
    public E getmodel(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        HybridList.Node<E> node = getNode(index);
        E model = node.furnitures.get(1);
        return model;
    }
    /** Remove the node  a given index
     @param position The position of the data
     */
    void remove(int position)
    {
        if (head == null)
            return;
        // Store head node
        HybridList.Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }
        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        HybridList.Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
        size--;
    }

    private static class Node<E> {
        /**
         * @ param furnitures The reference to the data.
         */
        KWArrayList<E> furnitures = new KWArrayList<>();
        /** The reference to the next node. */
        private HybridList.Node<E> next;
        /** Creates a new node that references another node.
         @param color of furniture
         @param model of furniture
         */
        private Node(E color, E model) {
            furnitures.add(color);
            furnitures.add(model);
            next = null;
        }
        /** Creates a new node that references another node.
         @param color of furniture
         @param model of furniture
         @param nodeRef The node referenced by new node
         */
        private Node(E color, E model, Node<E> nodeRef) {
            furnitures.add(color);
            furnitures.add(model);
            next = nodeRef;
        }
    }
}
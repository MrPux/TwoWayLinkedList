//Create Main class for testing the DoubleNode
public class Main
{
    public static void main(String[] args)
    {
        //Initializes the node
        DoubleNode head = new DoubleNode(10);

        //Add nodes after
        head.addNodeAfter(20);
        head.next.addNodeAfter(30);
        head.next.next.addNodeAfter(40);

        //Print the list of hodes
        System.out.println("List: " + head);
        
        //Tests the Getters and Setters
        System.out.println("Double Node two data: " + head.next.getData());
        head.next.setData(25);
        System.out.println("Updated list: " + head);

        //Tests the removeNodeAfter
        System.out.println("Removed data: " + head.next.removeNodeAfter());
        System.out.println("Removed afterwards: " + head);

        //Tests the listLength
        System.out.println("Length: " + DoubleNode.listLength(head));

        //Test the rewind
        DoubleNode rewindedNode = DoubleNode.rewind(head.next, 1);
        System.out.println("Rewinded: " + rewindedNode.getData());

    }
}
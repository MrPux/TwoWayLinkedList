//Creates Class for DoubleNode 
public class DoubleNode {
    //Declare instance variables
        //Stores the element data
        private double data;

        //Reference to the next double node in the list
        private DoubleNode next;
        
        //Reference to the previus double node in the list 
        private DoubleNode prev;


    //Creates class constructor
    public DoubleNode(double initialData)
        //Pre-conditon(s): one, and type double as initial data.
        //Post-condition(s): Initialize the element data with the given inital data, and the other two instance variables as null.
    { 
        this.data = initialData;
        this.next = null;
        this.prev = null;
    }

    //Creates getter method
    public double getData()
        //Pre-condition(s): none. 
        //Post-condition(s): returns the element data of the double node.
    { 
        return this.data;
    }

    //Creates setter method
    public void setData(double newData)
        //Pre-conditon(s): double 
        //Post-condition(s): update the node element data to the new give one
    {
        this.data = newData;
    }

    //Overrides the toString() method and returns Current node object state
    @Override
    public String toString()
    {
        return "(" + this.data + ")";
    }

    //Creates a new node object after the current one
    public void addNodeAfter(double node)
        //Pre-condition(s): double 
        //Post-condition(s): none (update Linked List with the added node given double node )
    {
        //I crate a temporary reference to next double node after this current one
        DoubleNode nextSideNode = next;
        //I initialize the new given double node
        DoubleNode newNode = new DoubleNode(node);

        //I set the knew double-node.next value to this double-node.next node.
        newNode.next = nextSideNode;
        // shift the current double node to left
        newNode.prev = this;

        //My knew next would be the given new double node
        this.next = newNode;

        if(nextSideNode != null)
        {
            nextSideNode.prev = newNode;
        }
    }    

    //Removes the node after the current one
    public double removeNodeAfter()
        //Same as addNodeAfter but does the opposite
        //Pre-conditon(s): none
        //Post-conditon(s): double (nextData)(updated Linked List without the given double node)
    {
        if(next != null)
        {
            double nextData = next.data;
            DoubleNode nextSideNode = next.next;

            this.next = nextSideNode;
            if(nextSideNode != null)
            {
                nextSideNode.prev = this;
            }
            return nextData;
        }
        return 0.0;
    }

    //Returns an int that represents the length of the LinkedList
    public static int listLength(DoubleNode startingNode)
        //Pre-conditon(s): DoubleNode
        //Post-conditon(s): int (returns an in that represents the length of the linkedList)
    {
        int counter = 0;
        DoubleNode currentNode = startingNode;
        while(currentNode != null)
        {
            counter++;
            currentNode = currentNode.next;
        }
        return counter;
    }
    
    //(Static) Shifts to the left of the list by a given number of shifts
    public static DoubleNode rewind(DoubleNode startingNode, int shifts)
        //Pre-condition(s): DoubleNode, int
        //Post-conditon(s): int (returns the double node found at given int)
        {
            DoubleNode currentNode = startingNode;
            for(int i = 0; i < shifts; i++)
            {
                if(currentNode.prev == null)
                {
                    return currentNode;
                }
                currentNode = currentNode.prev;
            }
            return currentNode;
        }
    
}

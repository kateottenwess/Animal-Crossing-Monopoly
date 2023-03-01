public class Properties extends PropertyType {
    class Node {
        Properties property;
        int spaceIdentifier;
        Node next;

        public Node(int space, Properties propertyVillager) {
            spaceIdentifier = space;
            property = propertyVillager;
            next = null;
        }
    }
    private Node root;
    public Properties () {
        root = null;
    }

    //brown properties - shitty ones
        //rodney
        //rocket
    //blue properties - normal
        //marina
        //mitzi
        //melbaS

    //pink properties - peppy
        //rosie
        //chrissy
        //flora

    //organe properties - lazy
        //bones
        //cephalobot
        //hopkins

    //red properties - cranky
        //octavin
        //kabuki
        //fang

    //yellow properties - i actually hate sisterly so these are random
        //shino
        //stitches
        //bob
    //green properties - snooty
        //francine
        //judy
        //diana

    //dark blue properties - populat ones for some reason
        //raymond
        //marshall
        
        public Properties getProperties(int spaceIdentifier) {
            Node curr = root;
            Properties p = root.property;
            if (curr.next != null) {
                if (curr.spaceIdentifier == spaceIdentifier) {
                    p = curr.property;
                }
                else {
                    curr = curr.next;
                }
            }

            return p;
        }
}

public class Main {

    public static void main(String[] args) {
        BST<String> bst = new BST<>();

        bst.add("M");
        bst.add("L");
        bst.add("R");
        bst.add("F");
        bst.add("O");
        bst.add("T");
        bst.add("B");
        bst.add("J");
        bst.add("P");
        bst.add("S");
        bst.add("X");
        bst.add("H");
        bst.add("K");

        System.out.println(bst); //see bst structure

        System.out.println("Size = " +  bst.size() ); //expected: 13
        System.out.println("Height = " + bst.height()); //expected: 4

        System.out.println("Contains P? = " + bst.contains("P")); //expected: true
        System.out.println("Contains Z? = " + bst.contains("Z")); //expected: false

        System.out.println("Elements (in-order traversal) = " + bst.elements()); //expected (this order): {B,F,H,J,K,L,M,O,P,R,S,T,X}

        System.out.println("External elements = " + bst.externalElements()); //expected (any order): {B,H,K,P,S,X}
        System.out.println("Internal elements = " + bst.internalElements()); //expected (any order): {L,R,F,J,O,T}

        System.out.println("------------------- AFTER REMOVING L and M -----------------------");

        System.out.println(bst); //see bst structure

        System.out.println("Size = " +  bst.size() ); //expected: ?
        System.out.println("Height = " + bst.height()); //expected: ?

        System.out.println("Contains P? = " + bst.contains("P")); //expected: ?
        System.out.println("Contains Z? = " + bst.contains("Z")); //expected: ?

        System.out.println("Elements (in-order traversal) = " + bst.elements()); //expected (this order): {??}

        System.out.println("External elements = " + bst.externalElements()); //expected (any order): {??}
        System.out.println("Internal elements = " + bst.internalElements()); //expected (any order): {??}

        System.out.println("------------------- AFTER CLEAR  -----------------------");

        System.out.println(bst); //see bst structure

        System.out.println("Size = " +  bst.size() ); //expected: 0
        System.out.println("Height = " + bst.height()); //expected: -1

        System.out.println("Contains P? = " + bst.contains("P")); //expected: false
        System.out.println("Contains Z? = " + bst.contains("Z")); //expected: false

        System.out.println("Elements (in-order traversal) = " + bst.elements()); //expected (this order): { empty }

        System.out.println("External elements = " + bst.externalElements()); //expected (any order): { empty }
        System.out.println("Internal elements = " + bst.internalElements()); //expected (any order): { empty }

    }
}

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] a = new int[]{1,2,3,'#','#',4,'#','#',5,6,'#','#','#' };
        tree.root = tree.createTree(a);
        tree.show(tree.root);
    }
}

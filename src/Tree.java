import java.util.Stack;

public class Tree {
    public Node root;
    private static int index;

    /**
     * 节点类
     */
    static class Node{
        private int data;
        private Node left;  //左孩子
        private Node right;     //右孩子

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        Node(int data){
            this.data = data;
        }
    }

    public static int getTreeDepth(Node root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }


    private static void writeArray(Node currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.getData());

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }



    public  void show(Node root) {
        if (root == null) {
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i ++) {
            for (int j = 0; j < arrayWidth; j ++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth/ 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line: res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i ++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2: line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }



    /**
     * 创建树
     * @param nums 树的节点
     */
    Node createTree(int []nums){
        Node root = null;
        System.out.println(index);
        if (nums[index] != '#'){
            root = new Node(nums[index]);
            index++;
            root.setLeft(createTree(nums));
            index++;
            root.setRight(createTree(nums));
        }
        return root;
    }

    /**
     * 添加节点
     * @param data 要添加的节点
     */
    void add(int data){

    }

    /**
     * 删除节点
     * @param data 要删除的节点
     */
    void delete(int data){

    }

    /**
     * 前序遍历
     */
    void preorderTraversal(){

    }

    /**
     * 中序遍历
     */
    void inorderTraversal(){

    }

    /**
     * 后序遍历
     */
    void postorderTraversal(){

    }

    /**
     * 层序遍历
     */
    void sequenceTraversal(){

    }

    /**
     * 获取一个节点左孩子节点
     * @param data  要获取的孩子节点的父节点
     * @return  该节点的左孩子节点
     */
//    int getLeftChild(int data){
//
//    }
//
//    /**
//     * 获取一个节点的右孩子节点
//     * @param data  要获取的孩子节点的父节点
//     * @return
//     */
//
//    int getRightChild(int data){
//
//    }
//
//    /**
//     * 判断一个元素是不是在树内
//     * @param data  要判断的元素
//     * @return  是不是在树内
//     */
//    boolean isContains(int data){
//
//    }
//
//    /**
//     * 获取一个节点的双亲节点
//     * @param data  要获取双亲节点的子节点
//     * @return  双亲节点
//     */
//    int getParent(int data){
//
//    }
//
//    /**
//     * 获取树的节点个数
//     * @return 树的节点个数
//     */
//
//    int size(){
//
//    }
//
//    /**
//     * 获取第K层节点的个数
//     * @param K 要获取的层数
//     * @return  该层节点的个数
//     */
//    int getNodeNumber(int K){
//
//    }
//
//    /**
//     * 求树的高度
//     * @return 树的高度
//     */
//    int height(){
//
//    }
//
//    /**
//     * 获取叶子节点的个数
//     * @return  叶子节点的个数
//     */
//    int getLeafNodeNumber(){
//
//    }
//
//    /**
//     * 判断是不是完全二叉树
//     * @return  true为完全二叉树，false不是完全二叉树
//     */
//    boolean iscompleteBinaryTree(){
//
//    }
}

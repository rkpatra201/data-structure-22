package v1.binary.trees;


import commons.TreeNode;

import java.util.*;

// Question 21 - 30 both inclusive
public class App03 {

    int maxDiameter = 0;
    int max_value = 0;
    int index = 0;
    TreeNode prev = null;
    TreeNode head = null;
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    int preIndex = 0;
    Vector<Integer> ver = new Vector<>();
    int sum = 0;

    void _01_levelOrderTraversal(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    void _02_reverselevelOrderTraversal(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode top = queue.poll();
            stack.push(top);
            if (top.right != null) queue.add(top.right);
            if (top.left != null) queue.add(top.left);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }
    }

    int _03_height(TreeNode root) {
        if (root == null) return 0;
        else {
            int lheight = _03_height(root.left);
            int rheight = _03_height(root.right);
            return Math.max(lheight, rheight) + 1;
        }
    }

    int _03_height_1(TreeNode root) {
        int h = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) h++;
            if (temp != null) {
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            } else if (!q.isEmpty()) q.add(null);
        }
        return h;
    }

    int _04_diameterOfTree(TreeNode root) {

        int height = diameter(root);
        System.out.println("height " + height);
        return maxDiameter;
    }

    int diameter(TreeNode root) {
        if (root == null) return 0;
        int left = diameter(root.left);
        int right = diameter(root.right);
        maxDiameter = Math.max(maxDiameter, left + right + 1);
        System.out.println(maxDiameter);
        return Math.max(left, right) + 1;
    }

    TreeNode _05_mirrorTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = _05_mirrorTree(root.left);
        TreeNode right = _05_mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    void _06_inorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        _06_inorderTraversalWithRecurtion(root.left);
        System.out.print(root.data + " ");
        _06_inorderTraversalWithRecurtion(root.right);
    }

    void _06_inorderTraversalWithoutRecurtion(TreeNode root) { // until null push whenever there is null pop and moved to its right
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || s.size() > 0) {
            if (curr != null) {
                s.push(curr);
                curr = curr.left;
            } else {
                curr = s.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }

    }

    void _07_preorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        _07_preorderTraversalWithRecurtion(root.left);
        _07_preorderTraversalWithRecurtion(root.right);
    }

    void _07_preorderTraversalWithoutRecurtion(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) s.push(temp.right);
            if (temp.left != null) s.push(temp.left);
        }

    }

    void _08_postorderTraversalWithRecurtion(TreeNode root) {
        if (root == null) return;
        _08_postorderTraversalWithRecurtion(root.left);
        _08_postorderTraversalWithRecurtion(root.right);
        System.out.print(root.data + " ");
    }

    void _08_postorderTraversalWithoutRecurtion(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null) return;
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode temp = s1.pop();
            s2.push(temp);
            if (temp.left != null) s1.push(temp.left);
            if (temp.right != null) s1.push(temp.right);
        }
        while (!s2.isEmpty()) System.out.print(s2.pop().data + " ");
    }

    void _09_leftView(TreeNode root) {
        leftView(root, 1);
        max_value = 0;
    }

    private void leftView(TreeNode root, int level) {
        if (root == null) return;
        if (max_value < level) {
            System.out.print(root.data + " ");
            max_value = level;
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    void _09_leftView_1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.print(q.peek().data + " ");     // O(n) or O(n^2)
            while (size-- > 0) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
        }
    }

    void _10_rightView(TreeNode root) {
        rightView(root, 1);
    }

    private void rightView(TreeNode root, int level) {
        if (root == null) return;
        if (max_value < level) {
            System.out.print(root.data + " ");
            max_value = level;
        }
        rightView(root.right, level + 1);
        rightView(root.left, level + 1);
    }

    void _10_rightView_1(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.print(q.peek().data + " ");     // O(n) or O(n^2)
            while (size-- > 0) {
                TreeNode temp = q.poll();
                if (temp.right != null) q.add(temp.right);
                if (temp.left != null) q.add(temp.left);
            }
        }
    }

    //    void _11_topView(TreeNode root) {
//          left(root.left);
//          right(root);
//           Collections.reverse(left);
//        for (int x : left) System.out.print(x + " ");
//        for (int x : right) System.out.print(x + " ");
//    }
//
//    private void  left(TreeNode root) {
//        if (root==null) return;
//        left.add(root.data);
//        left(root.left);
//    }
//
//    private void right(TreeNode root) {
//        if(root== null) return ;
//        right.add(root.data);
//        right(root.right);
//    }
    void _11_topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return;
        else q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (!map.containsKey(temp.hd)) map.put(temp.hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    void _12_bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return;
        else q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            map.put(temp.hd, temp.data);
            if (temp.left != null) {
                temp.left.hd = temp.hd - 1;
                q.add(temp.left);
            }
            if (temp.right != null) {
                temp.right.hd = temp.hd + 1;
                q.add(temp.right);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    void _13_zigzagView(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.push(root);
        boolean flag = false;
        while (!currLevel.isEmpty()) {
            TreeNode temp = currLevel.pop();
            System.out.println(temp.data);
            if (flag) {
                if (temp.left != null) nextLevel.push(temp.left);
                if (temp.right != null) nextLevel.push(temp.right);
            } else {
                if (temp.right != null) nextLevel.push(temp.right);
                if (temp.left != null) nextLevel.push(temp.left);
            }
            if (currLevel.isEmpty()) {
                flag = !flag;
                Stack<TreeNode> swap = currLevel;
                currLevel = nextLevel;
                nextLevel = swap;
            }
        }
    }

    boolean _14_isBalance(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = checkBalance(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkBalance(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        else return Math.max(leftHeight, rightHeight) + 1;
    }

    void _15_printDiagonal(TreeNode root) {
        Map<Integer, Vector<Integer>> map = new TreeMap<>();
        printDiagonal(root, map);
        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet())
            System.out.println(entry.getValue());
    }

    private void printDiagonal(TreeNode root, Map<Integer, Vector<Integer>> map) {
        if (root == null) return;
        Vector<Integer> values = map.get(root.hd);
        if (values == null) {
            values = new Vector<>();
            values.add(root.data);
        } else values.add(root.data);
        map.put(root.hd, values);
        if (root.left != null) root.left.hd = root.hd + 1;
        printDiagonal(root.left, map);
        if (root.right != null) root.right.hd = root.hd;
        printDiagonal(root.right, map);
    }

    void _16_printBoundary(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        printLeftBoudary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);

    }

    private void printRightBoundary(TreeNode node) {
        if (node == null) return;
        if (node.right != null) {
            System.out.print(node.data + " ");
            printRightBoundary(node.right);
        } else if (node.left != null) {
            System.out.print(node.data + " ");
            printRightBoundary(node.left);
        }
    }

    private void printLeaves(TreeNode root) {
        if (root == null) return;
        printLeaves(root.left);
        if (root.left == null && root.right == null) System.out.print(root.data + " ");
        printLeaves(root.right);
    }

    private void printLeftBoudary(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            System.out.print(node.data + " ");
            printLeftBoudary(node.left);
        } else if (node.right != null) {
            System.out.print(node.data + " ");
            printLeftBoudary(node.right);
        }
    }

    public TreeNode _17_constructTree(String s) {
        int num = 0;
        if (s == null || s.length() == 0) return null;
        if (index >= s.length()) return null;
        boolean neg = false;
        if (s.charAt(index) == '-') {
            neg = true;
            index++;
        }
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = Character.getNumericValue(s.charAt(index));
            num = num * 10 + digit;
            index++;
        }
        if (neg) num = -num;
        TreeNode node = new TreeNode(num);
        if (index >= s.length()) return node;
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            node.left = _17_constructTree(s);
        }
        if (index < s.length() && s.charAt(index) == ')') {
            index++;
            return node;
        }
        if (index < s.length() && s.charAt(index) == '(') {
            index++;
            node.right = _17_constructTree(s);
        }
        if (index < s.length() && s.charAt(index) == ')') {
            index++;
            return node;
        }
        return node;
    }

    void printTree(TreeNode node) {
        if (node == null) return;

        System.out.println(node.data + " ");
        printTree(node.left);
        printTree(node.right);
    }

    void convertTreeToDll(TreeNode root) {
        if (root == null) return;
        convertTreeToDll(root.left);
        if (prev == null) head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertTreeToDll(root.right);
    }

    void _18_convertTreeToDll(TreeNode root) {
        convertTreeToDll(root);
        printDllOfTree(head);
    }

    void printDllOfTree(TreeNode head) {
        while (head != null) {
            System.out.println(head.data);
            head = head.right;
        }
    }

    int _19_convertingBSTtoSumTree(TreeNode root) {
        if (root == null) return 0;
        int prev = root.data;
        root.data = _19_convertingBSTtoSumTree(root.left) + _19_convertingBSTtoSumTree(root.right);
        return prev + root.data;
    }

    TreeNode _20_mapping(String pre, String in, HashMap<Character, Integer> map) {
        for (int i = 0; i < in.length(); i++) {
            map.put(in.charAt(i), i);
        }
        return buildTreeUsingPreAndIn(pre, in, map, 0, in.length() - 1);
    }

    private TreeNode buildTreeUsingPreAndIn(String pre, String in, HashMap<Character, Integer> map, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        char curr = pre.charAt(preIndex++);
        TreeNode node = new TreeNode(curr);
        if (inStart == inEnd) return node;
        int inIndex = map.get(curr);
        node.left = buildTreeUsingPreAndIn(pre, in, map, inStart, inIndex - 1);
        node.right = buildTreeUsingPreAndIn(pre, in, map, inIndex + 1, inEnd);
        return node;
    }

    List<Integer> treeAp(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int sum = 0, prev = 0, value = 0, diff = 0;
        if (root == null) {
            return list;
        }
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        currLevel.push(root);
        boolean flag = false;
        while (!currLevel.isEmpty()) {
            TreeNode temp = currLevel.pop();
            sum = sum + temp.data;
            System.out.println(temp.data);
            if (flag) {
                if (temp.left != null) nextLevel.push(temp.left);
                if (temp.right != null) nextLevel.push(temp.right);
            } else {
                if (temp.right != null) nextLevel.push(temp.right);
                if (temp.left != null) nextLevel.push(temp.left);
            }
            if (currLevel.isEmpty()) {
                flag = !flag;
                Stack<TreeNode> swap = currLevel;
                currLevel = nextLevel;
                nextLevel = swap;
                value = sum - prev;
                if (list.isEmpty()) {
                    list.add(0);
                    diff = sum;
                } else {
                    list.add(diff - value);
                }
                prev = sum;
                sum = 0;
            }
        }
        return list;
    }

    List<Integer> treeAp_1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int sum = 0, prev = 0, value = 0, diff = 0;
        if (root == null) {
            return list;
        }
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp == null) {
                value = sum - prev;
                if (list.isEmpty()) {
                    list.add(0);
                    diff = sum;
                } else {
                    list.add(diff - value);
                }
                prev = sum;
                sum = 0;
                if (queue.size() == 0) break;
                queue.add(null);
                temp = queue.poll();
            }
            sum = sum + temp.data;
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return list;
    }

    void inorederTraversal(TreeNode root) {
        if (root == null) return;
        inorederTraversal(root.left);
        ver.add(root.data);
        inorederTraversal(root.right);
    }

    int _20_minSwaps() {
        int swap = 0;
        int n = ver.size();
        ArrayList<Pair> arr = new ArrayList<Pair>();
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(ver.get(i), i));
        }
        //System.out.println(arr);
        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).second == i) continue;
            else {
                ++swap;
                Pair temp = arr.get(i);
                arr.add(i, arr.get(arr.get(i).second));
                arr.add(arr.get(i).second, temp);
                --i;
            }
        }
        System.out.println(swap);
        return swap;
    }

    boolean _21_isSumTree(TreeNode root) {
        inorderTraversal(root);
       // System.out.println(sum);
        if (2 * root.data == sum) return true;
        else return false;
    }

    void inorderTraversal(TreeNode root) {
        if (root == null) return;
        inorderTraversal(root.left);
        sum = sum + root.data;
        inorderTraversal(root.right);
    }

    static class Pair {
        int first, second;

        Pair(int a, int b) {
            first = a;
            second = b;
        }
    }
    int Ilevel =0;
    boolean _22_checkLeafLevel(TreeNode root , int level){
        if (root == null) {
            return true;
        }
        if(root.left==null && root.right==null){
            if (Ilevel==0){
                Ilevel=level;
                return true;
            }
            return (level==Ilevel);
        }
        return _22_checkLeafLevel(root.left,level+1) && _22_checkLeafLevel(root.right,level+1);

    }

}


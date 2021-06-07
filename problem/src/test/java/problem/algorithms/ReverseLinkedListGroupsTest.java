package problem.algorithms;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ReverseLinkedListGroupsTest {
    private LLNode createList(int[] arr) {
        LLNode node = null;
        LLNode prevNode = null;
        for(int i = 0; i < arr.length; ++i) {
            LLNode currNode = new LLNode(arr[i], null);
            if (prevNode == null) {
                prevNode = currNode;
            } else {
                prevNode.next = currNode;
                prevNode = currNode;
            }

            if (node == null) {
                node = currNode;
            }
        }

        return node;
    }

    private void verifyResult(LLNode val, int[] expected) {
        LLNode currNode = val;
        for (int i = 0; i < expected.length; ++i){
            assertEquals(currNode.val, expected[i]);
            currNode = currNode.next;
        }
    }
    @Test
    public void test0123_with_k2() {
        int arr[] = {0,1,2,3};
        LLNode node = createList(arr);

        var res = ReverseLinkedListGroups.solve(node, 2);
        int expected[] = {1,0,3,2};

        verifyResult(res, expected);
    }

    @Test
    public void test0123_with_k3() {
        int arr[] = {0,1,2,3};
        LLNode node = createList(arr);

        var res = ReverseLinkedListGroups.solve(node, 3);
        int expected[] = {2,1,0,3};

        verifyResult(res, expected);
    }

    @Test
    public void test0123_with_k4() {
        int arr[] = {0,1,2,3};
        LLNode node = createList(arr);

        var res = ReverseLinkedListGroups.solve(node, 4);
        int expected[] = {3,2,1,0};

        verifyResult(res,expected);
    }
}

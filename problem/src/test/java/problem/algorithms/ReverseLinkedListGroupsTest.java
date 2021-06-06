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

    @Test
    public void test() {
        int arr[] = {0,1,2,3};
        LLNode node = createList(arr);

        var res = ReverseLinkedListGroups.solve(node, 2);

        int expected[] = {1,0,3,2};

        LLNode currNode = res;
        for (int i = 0; i < expected.length; ++i){
            assertEquals(currNode.val, expected[i]);
            currNode = currNode.next;
        }
    }
}

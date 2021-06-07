package problem.algorithms;


class LLNode {
    int val;
    LLNode next;

    LLNode(int val, LLNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Given a linked list node, and an integer k,
 * reverse every k contiguous group of nodes.
 *
 * node = 0 -> 1 -> 2 -> 3
 * k = 2
 * output = 1 -> 0 -> 3 -> 2
 *
 * node = 0 -> 1 -> 2 -> 3
 * k = 3
 * output = 2 -> 1 -> 0 -> 3
 */
class ReverseLinkedListGroups {
    private static class NodePair {
        final LLNode reversedHeadNode;
        final LLNode originalListNext;

        NodePair(LLNode reversedHeadNode, LLNode originalListNext) {
            this.reversedHeadNode = reversedHeadNode;
            this.originalListNext = originalListNext;
        }
    }

    private static NodePair reverseKNodes(LLNode node, int k) {
        if (node.next == null || k == 1) {
            LLNode next = node.next;
            node.next = null;
            return new NodePair(node, next);
        }

        LLNode nextNode = node.next;
        node.next = null;
        NodePair res = reverseKNodes(nextNode, k - 1);
        nextNode.next = node;

        return res;
    }

    static LLNode solve(LLNode node, int k) {
        LLNode prevGroupEnd = null;
        LLNode currGroup = node;
        LLNode newHeadNode = null;

        while(currGroup != null) {
            NodePair res = reverseKNodes(currGroup,k);

            if (newHeadNode == null) {
                newHeadNode = res.reversedHeadNode;
            }

            if (prevGroupEnd != null) {
                prevGroupEnd.next = res.reversedHeadNode;
            }
            prevGroupEnd = currGroup;
            currGroup = res.originalListNext;
        }

        return newHeadNode;
    }
}

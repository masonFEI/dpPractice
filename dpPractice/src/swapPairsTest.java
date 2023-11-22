import java.util.HashMap;
import java.util.Map;

public class swapPairsTest {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next= new ListNode(3);
        head.next.next.next= new ListNode(4);
        ListNode res = swapPairs(head);

        System.out.println(res);

    }


    public static ListNode swapPairs(ListNode head) {


        if (head == null) {
            return head;
        }

        ListNode headMap = head;

        int count=0;
        Map<Integer,ListNode> listNodeMap = new HashMap<>();

        while (headMap!=null){
            listNodeMap.put(count,headMap);
            headMap = headMap.next;
            count++;
        }

        ListNode headChange = head;

        for (int i=0;i <count;i++){
            ListNode target = new ListNode();
            if ( i % 2 ==0) {
                if (listNodeMap.containsKey(i+1)) {
                     target = listNodeMap.get(i+1);
                } else {
                     target = listNodeMap.get(i);
                }
            } else {
                if (listNodeMap.containsKey(i-1)) {
                     target = listNodeMap.get(i-1);
                }
            }

            headChange.next = new ListNode(target.val);
            headChange = headChange.next;

        }

        return head.next;


    }


   public static class ListNode {
        int val;
         ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



}

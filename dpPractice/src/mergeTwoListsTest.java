public class mergeTwoListsTest {


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next =new ListNode(2);
        l1.next.next =new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next =new ListNode(3);
        l2.next.next =new ListNode(4);



        ListNode res = mergeTwoLists(l1,l2);
        System.out.println(res);
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(1);
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode pointerRes =  res;

        while (head1 !=null || head2!=null) {
            int value =0;
            if (head1 ==null || (head1 !=null && head2 !=null && head2.val <= head1.val) ) {
                value = head2.val;
                head2 = head2.next;

            } else if (head2 ==null || (head1 !=null && head2 !=null && head1.val < head2.val)){
                value = head1.val;
                head1 = head1.next;
            }

            ListNode cur = new ListNode(value);
            pointerRes.next = cur;
            pointerRes = pointerRes.next;

        }

        return res.next;

    }





    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}

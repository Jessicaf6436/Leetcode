class Solution:
    def partition(self, head, x):
        less = ListNode(0)
        greater = ListNode(0)

        l = less
        g = greater

        while head:
            if head.val < x:
                l.next = head
                l = l.next
            else:
                g.next = head
                g = g.next

            head = head.next

        g.next = None
        l.next = greater.next

        return less.next
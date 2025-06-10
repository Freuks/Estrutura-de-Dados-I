public class ListaDupla {
    private No head;
    private No tail;

    public ListaDupla() {
        this.head = null;
        this.tail = null;
    }

    public void insertInOrder(int data) {
        No newNo = new No(data);

        if (head == null) {
            head = newNo;
            tail = newNo;
            return;
        }

        if (data <= head.data) {
            newNo.next = head;
            head.prev = newNo;
            head = newNo;
            return;
        }

        if (data >= tail.data) {
            tail.next = newNo;
            newNo.prev = tail;
            tail = newNo;
            return;
        }

        No current = head.next;
        while (current != null) {
            if (data <= current.data) {
                No previousNo = current.prev;
                
                previousNo.next = newNo;
                newNo.prev = previousNo;
                
                newNo.next = current;
                current.prev = newNo;
                return;
            }
            current = current.next;
        }
    }
    
    public void removePrimes() {
        No current = head;
        while (current != null) {
            No nextNo = current.next;
            
            if (isPrime(current.data)) {
                removeNo(current);
            }
            current = nextNo;
        }
    }
    
    private void removeNo(No NoToRemove) {
        if (NoToRemove == null) return;

        if (NoToRemove == head) {
            head = head.next;
        }
        if (NoToRemove == tail) {
            tail = tail.prev;
        }
        if (NoToRemove.prev != null) {
            NoToRemove.prev.next = NoToRemove.next;
        }
        if (NoToRemove.next != null) {
            NoToRemove.next.prev = NoToRemove.prev;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public void printAscending() {
        if (head == null) {
            System.out.println("A lista esta vazia.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    
    public void printDescending() {
        if (tail == null) {
            System.out.println("A lista esta vazia.");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        No current = tail;
        while (current != null) {
            sb.append(current.data);
            if (current.prev != null) {
                sb.append(", ");
            }
            current = current.prev;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
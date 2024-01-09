public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size]
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0))%this.hashTable.length;
    }
}

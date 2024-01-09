public class MyHash {
    public Slot[] hashTable;

    public MyHash(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        Slot(String value) {
            this.value = value;
        }
    }

    // Division 기법을 사용하여 hashFunction을 만든다. 
    // 많은 기법이 있겠지만, key값의 맨 처음 글자를 가져와 hashtable의 총 갯수로 나눈 나머지를
    // 반환하게하여 index값을 만드는 hashFuction을 만든다.
    public Integer hashFunc(String key) {
        return (int)(key.charAt(0))%this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if(this.hashTable[address]!=null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
    }
}

package mio68.lab.tryit.comparable;

import lombok.Data;

public class ObjectComparable {

    @Data
    static class RowKey {
        Comparable<?> token;
        Comparable<?>[] fields;
    }

    @SuppressWarnings("unchecked")
    static int compare(RowKey rowKey1, RowKey rowKey2) {
        int res = ((Comparable<Object>)rowKey1.token).compareTo(rowKey2.token);
        if (res == 0) {
            for (int i = 0; i < rowKey1.fields.length; i++) {
                res = ((Comparable<Object>) rowKey1.fields[i]).compareTo(rowKey2.fields[i]);
                if (res != 0) {
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        try {
            RowKey key1 = new RowKey();
            key1.token = 1L;
            key1.fields = new String[]{"John", "Reed"};

            RowKey key2 = new RowKey();
            key2.token = 1L;
            key2.fields = new String[]{"John", "Doe"};

            int res = compare(key1, key2);
            System.out.println(res);
        } catch (ClassCastException e) {
            throw new RuntimeException(e);
        }
    }

}

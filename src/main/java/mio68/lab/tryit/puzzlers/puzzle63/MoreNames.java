package mio68.lab.tryit.puzzlers.puzzle63;

import java.util.HashMap;
import java.util.Map;

public class MoreNames {
    private Map<String, String> m  = new HashMap<String, String>();

    // It's not a constructor)
    public void MoreNames() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }

    public static void main(String[] args) {
        MoreNames moreNames = new MoreNames();
        System.out.println(moreNames.size()); // prints 0
    }
}

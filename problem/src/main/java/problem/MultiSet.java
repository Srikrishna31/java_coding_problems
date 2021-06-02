package problem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class MultiSet<T> {
    private Map<Integer, List<T>> container;

    MultiSet() {
        container = new HashMap<>();
    }

    void add(T t) {
        List<T> list = null;
        if (container.containsKey(t.hashCode())) {
            list = container.get(t.hashCode());
        } else {
            list = new LinkedList<>();
            container.put(t.hashCode(), list);
        }
        list.add(t);
    }


    void remove(T t) {
        if (container.containsKey(t.hashCode())) {
            LinkedList<T> list = (LinkedList<T>)container.get(t.hashCode());
            list.remove();
            if(list.isEmpty()) {
                container.remove(t.hashCode());
            }
        }
    }

    boolean contains(T t) {
        //container.getOrDefault(t.hashCode(), false)
        if (container.containsKey(t.hashCode())) {
            List<T> list = container.get(t.hashCode());
            //return list.stream().findFirst().isPresent();
            return list.stream().anyMatch(v -> t.equals(v));
        }

        return false;
    }

    public static void main(String... args) {
        MultiSet<String> set = new MultiSet<>();
        set.add("test");
        set.add("test");
        set.add("test");
        set.remove("test");
        System.out.println(set.contains("test")); // true
        set.remove("test");
        System.out.println(set.contains("test")); // true
        set.remove("test");
        System.out.println(set.contains("test")); // false
    }
}

package ASD;

import java.util.*;

public class GraphLogic {

    private Map<String, List<String>> graph;

    public GraphLogic() {
        graph = new HashMap<>();
    }

    // menambahkan orang
    public void addPerson(String name) {
        if (!graph.containsKey(name)) {
            graph.put(name, new ArrayList<String>());
        }
    }

    // menambahkan hubungan pertemanan
    public void addFriendship(String personA, String personB) {
        if (!graph.containsKey(personA)) {
            addPerson(personA);
        }
        if (!graph.containsKey(personB)) {
            addPerson(personB);
        }
        List<String> daftarTemanPersonA = graph.get(personA);
        List<String> daftarTemanPersonB = graph.get(personB);
        if (!daftarTemanPersonA.contains(personB)) {
            daftarTemanPersonA.add(personB);
        }
        if (!daftarTemanPersonB.contains(personA)) {
            daftarTemanPersonB.add(personA);
        }
    }

    //Remove Connections
    public boolean contains(String name) {
        return graph.containsKey(name);
    }

    public boolean areConnected(String a, String b) {
        return contains(a) && graph.get(a).contains(b);
    }

    public void removeConnection(String a, String b) {
        graph.get(a).remove(b);
        graph.get(b).remove(a);
    }

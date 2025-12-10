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

    //   BUBBLE SORT METHOD
    private void bubbleSort(List<String> list) {
        int n = list.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareToIgnoreCase(list.get(j + 1)) > 0) {
                    // swap
                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }

    // Cari orang yang mungkin dikenali + mutual
    public void displayPeopleYouMayKnow(String person) {

        if (!graph.containsKey(person)) {
            System.out.println("User \"" + person + "\" doesn't exist in the network.");
            return;
        }

        List<String> temanLangsung = graph.get(person);

        Set<String> level2 = new HashSet<>();

        Set<String> visited = new HashSet<>();
        visited.add(person);
        visited.addAll(temanLangsung);

        Queue<String> queue = new LinkedList<>();

        Map<String, Integer> level = new HashMap<>();
        for (String t : temanLangsung) {
            queue.add(t);
            level.put(t, 1);
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            int currentLevel = level.get(current);

            if (currentLevel == 2) continue;

            for (String friend : graph.get(current)) {
                if (!visited.contains(friend)) {

                    int nextLevel = currentLevel + 1;

                    if (nextLevel == 2) {
                        level2.add(friend);
                    }

                    visited.add(friend);
                    queue.add(friend);
                    level.put(friend, nextLevel);
                }
            }
        }

        // Hitung mutuals
        Map<String, List<String>> mutualMap = new HashMap<>();

        for (String calon : level2) {
            mutualMap.put(calon, new ArrayList<>());

            for (String t : temanLangsung) {
                if (graph.get(t).contains(calon)) {
                    mutualMap.get(calon).add(t);
                }
            }
        }

        // Sort dengan bubble sort
        List<String> urut = new ArrayList<>(level2);
        bubbleSort(urut);

        // Tampilkan hasil
        System.out.println("\n===== People " + person + " May Know =====");

        if (urut.isEmpty()) {
            System.out.println("- Nobody");
        } else {
            for (String calon : urut) {
                System.out.println("- " + calon);

                List<String> mutualList = mutualMap.get(calon);

                if (mutualList.isEmpty()) {
                    System.out.println("  mutual : -");
                } else {
                    System.out.print("  mutual : ");
                    for (int i = 0; i < mutualList.size(); i++) {
                        System.out.print(mutualList.get(i));
                        if (i < mutualList.size() - 1) System.out.print(", ");
                    }
                    System.out.println();
                }
            }
        }

        System.out.println("\nNumber of Potential Friends: " + urut.size());
    }

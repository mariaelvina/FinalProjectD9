package ASD;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVLoader {

    public static void loadFriendshipsFromCSV(GraphLogic graph) {

        String filePath = "ASD/input.csv";
        // baca input.csv

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean skipHeader = true;

            while ((line = br.readLine()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                // Split berdasarkan TAB
                String[] parts = line.split(",");

                if (parts.length < 2) {
                    continue; // silent
                }

                String person = parts[0].trim();
                String[] friends = parts[1].trim().split(";");

                for (String friend : friends) {
                    friend = friend.trim();
                    if (!friend.isEmpty()) {
                        graph.addFriendship(person, friend);
                    }
                }
            }

        } catch (IOException e) {
        }
    }
}


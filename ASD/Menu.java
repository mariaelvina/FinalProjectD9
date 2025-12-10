package ASD;

import java.util.Scanner;

public class Menu {

    private GraphLogic graph;
    private Scanner sc;

    public Menu() {
        graph = new GraphLogic();
        sc = new Scanner(System.in);

        System.out.println("Loading data from CSV...");
        CSVLoader.loadFriendshipsFromCSV(graph);
    }

    public void start() {
        int choice;
        do {
            printHeader();
            showMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1 -> addFriendshipMenu();
                case 2 -> peopleYouMayKnowMenu();
                case 3 -> findPathMenu();
                case 4 -> showGraphMenu();
                case 5 -> removeConnectionMenu();
                case 0 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 0);
        sc.close();
    }


    // HEADER (main menu only)
    private static void printHeader() {
        System.out.println();
        System.out.println("██████╗ ██╗   ██╗██████╗ ██████╗ ██╗   ██╗███╗   ███╗ █████╗ ██████╗ ");
        System.out.println("██╔══██╗██║   ██║██╔══██╗██╔══██╗╚██╗ ██╔╝████╗ ████║██╔══██╗██╔══██╗");
        System.out.println("██████╔╝██║   ██║██║  ██║██║  ██║ ╚████╔╝ ██╔████╔██║███████║██████╔╝");
        System.out.println("██╔══██╗██║   ██║██║  ██║██║  ██║  ╚██╔╝  ██║╚██╔╝██║██╔══██║██╔═══╝ ");
        System.out.println("██████╔╝╚██████╔╝██████╔╝██████╔╝   ██║   ██║ ╚═╝ ██║██║  ██║██║     ");
        System.out.println("╚═════╝  ╚═════╝ ╚═════╝ ╚═════╝    ╚═╝   ╚═╝     ╚═╝╚═╝  ╚═╝╚═╝     ");
        System.out.println();
        System.out.println("        (•‿•) ☀  BuddyMap — find your path, buddy!");
        System.out.println();
    }

    // MENU UTAMA
    private void showMenu() {
        System.out.println("==== MAIN MENU ====");
        System.out.println("1. Add Connection");
        System.out.println("2. People You May Know");
        System.out.println("3. Find Connection Path");
        System.out.println("4. Display All Connection");
        System.out.println("5. Remove Connection");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private int getUserChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter a valid number!");
            sc.next();
        }
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }

    // PAUSE
    private void waitEnter() {
        System.out.print("\nPress ENTER to continue...");
        sc.nextLine();
    }


    // ADD FRIENDSHIP
    private void addFriendshipMenu() {
        while (true) {
            System.out.println("\n=== ADD CONNECTION ===");
            System.out.print("Enter your name: ");
            String p1 = sc.nextLine();
            System.out.print("Enter your friend: ");
            String p2 = sc.nextLine();
            graph.addFriendship(p1, p2);
            System.out.println("Connection added!");
            waitEnter();

            System.out.println("\nSelect next action:");
            System.out.println("1. Add another");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String pilih = sc.nextLine();

            if (!pilih.equals("1")) return;
        }
    }

    // PEOPLE YOU MAY KNOW
    private void peopleYouMayKnowMenu() {
        while (true) {
            System.out.println("\n=== PEOPLE YOU MAY KNOW ===");
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            graph.displayPeopleYouMayKnow(name);

            waitEnter();

            System.out.println("\nSelect next action: ");
            System.out.println("1. Search again");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String pilih = sc.nextLine();

            if (!pilih.equals("1")) return;
        }
    }

    // FIND PATH
    private void findPathMenu() {

        while (true) {
            System.out.println("\n=== FIND CONNECTION PATH ===");

            System.out.print("From: ");
            String start = sc.nextLine();

            System.out.print("To: ");
            String target = sc.nextLine();

            graph.findPath(start, target);
            waitEnter();

            System.out.println("\nSelect next action: ");
            System.out.println("1. Search again");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String pilih = sc.nextLine();

            if (!pilih.equals("1")) return;
        }
    }

    // SHOW GRAPH
    private void showGraphMenu() {
        System.out.println("\n=== ALL CONNECTION ===");
        graph.printGraph();
        waitEnter();
    }

    // REMOVE CONNECTION
    private void removeConnectionMenu() {

        while (true) {
            System.out.println("\n=== REMOVE CONNECTION ===");

            System.out.print("Enter your name: ");
            String p1 = sc.nextLine().trim();

            System.out.print("Enter name of friend to remove: ");
            String p2 = sc.nextLine().trim();

            if (!graph.contains(p1) || !graph.contains(p2)) {
                System.out.println("\nOne or both names do not exist in the network!");
                waitEnter();
            } else if (!graph.areConnected(p1, p2)) {
                System.out.println("\nThey are not connected!");
                waitEnter();
            } else {
                graph.removeConnection(p1, p2);
                System.out.println("\nConnection removed!");
                waitEnter();
            }

            System.out.println("\nSelect next action:");
            System.out.println("1. Remove another");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");

            String pilih = sc.nextLine();

            if (!pilih.equals("1")) return;
        }
    }
}



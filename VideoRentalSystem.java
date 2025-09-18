import java.util.Scanner;

public class VideoRentalSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int maxSize = 100;

        String[] videoTitles = new String[maxSize];
        boolean[] isRented = new boolean[maxSize];
        int videoCount = 0;

        while (true) {
            System.out.println("Video Rental Store");
            System.out.println("1. Add Video");
            System.out.println("2. Rent Video");
            System.out.println("3. Return Video");
            System.out.println("4. Remove Video");
            System.out.println("5. Show Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    if (videoCount < maxSize) {
                        System.out.print("Enter video title: ");
                        String title = sc.nextLine();
                        boolean duplicate = false;

                        for (int i = 0; i < videoCount; i++) {
                            if (videoTitles[i].equalsIgnoreCase(title)) {
                                duplicate = true;
                                break;
                            }
                        }

                        if (!duplicate) {
                            videoTitles[videoCount] = title;
                            isRented[videoCount] = false;
                            videoCount++;
                            System.out.println("Video added.");
                        } else {
                            System.out.println("Video already exists.");
                        }

                    } else {
                        System.out.println("Inventory full.");
                    }
                    break;

                case 2:
                    System.out.print("Enter title to rent: ");
                    String rentTitle = sc.nextLine();
                    boolean rented = false;

                    for (int i = 0; i < videoCount; i++) {
                        if (videoTitles[i].equalsIgnoreCase(rentTitle) && !isRented[i]) {
                            isRented[i] = true;
                            rented = true;
                            System.out.println("🎥 Video rented.");
                            break;
                        }
                    }

                    if (!rented) System.out.println("Not found or already rented.");
                    break;

                case 3:
                    System.out.print("Enter title to return: ");
                    String returnTitle = sc.nextLine();
                    boolean returned = false;

                    for (int i = 0; i < videoCount; i++) {
                        if (videoTitles[i].equalsIgnoreCase(returnTitle) && isRented[i]) {
                            isRented[i] = false;
                            returned = true;
                            System.out.println("Video returned.");
                            break;
                        }
                    }

                    if (!returned) System.out.println("Not found or not rented.");
                    break;

                case 4:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = sc.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < videoCount; i++) {
                        if (videoTitles[i].equalsIgnoreCase(removeTitle)) {
                            for (int j = i; j < videoCount - 1; j++) {
                                videoTitles[j] = videoTitles[j + 1];
                                isRented[j] = isRented[j + 1];
                            }
                            videoCount--;
                            removed = true;
                            System.out.println("🗑 Video removed.");
                            break;
                        }
                    }

                    if (!removed) System.out.println("Video not found.");
                    break;

                case 5:
                    System.out.println("Inventory:");
                    if (videoCount == 0) {
                        System.out.println("No videos found.");
                    } else {
                        for (int i = 0; i < videoCount; i++) {
                            String status = isRented[i] ? "Rented" : "Available";
                            System.out.println((i + 1) + ". " + videoTitles[i] + " - " + status);
                        }
                    }
                    break;

                case 6:
                    System.out.println("Exiting..........");
                    sc.close();
                    return;

                default:
                    System.out.println("You have entered an Invalid choice.");
            }
        }
    }
}
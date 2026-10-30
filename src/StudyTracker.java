import java.util.Scanner;

public class StudyTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int weeklyGoal = 600;

        int programmingMinutes = 0;
        int mathMinutes = 0;
        int englishMinutes = 0;
        int otherMinutes = 0;

        int totalStudyTime = 0;
        int sessionCount = 0;

        int menuChoice = 0;

        while (menuChoice != 4) {
            System.out.println("===== STUDY TRACKER =====");
            System.out.println();
            System.out.println("1. Add study session");
            System.out.println("2. View statistics");
            System.out.println("3. Check weekly goal");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            menuChoice = input.nextInt();
            System.out.println();

            if (menuChoice == 1) {
                // Option 1: Add Study Session
                System.out.println("Choose subject:");
                System.out.println("1. Programming");
                System.out.println("2. Mathematics");
                System.out.println("3. English");
                System.out.println("4. Other");
                System.out.println();
                System.out.print("Choose an option: ");
                int subjectChoice = input.nextInt();
                System.out.println();

                if (subjectChoice < 1 || subjectChoice > 4) {
                    System.out.println("Invalid subject choice. Choose a number from 1 to 4.");
                } else {
                    System.out.print("Study time in minutes: ");
                    int studyTime = input.nextInt();
                    System.out.println();

                    if (studyTime <= 0) {
                        System.out.println("Invalid study time. Time must be greater than 0.");
                    } else {
                        // 1. add minutes to the selected subject total
                        if (subjectChoice == 1) {
                            programmingMinutes = programmingMinutes + studyTime;
                        } else if (subjectChoice == 2) {
                            mathMinutes = mathMinutes + studyTime;
                        } else if (subjectChoice == 3) {
                            englishMinutes = englishMinutes + studyTime;
                        } else {
                            otherMinutes = otherMinutes + studyTime;
                        }

                        // 2. add minutes to total study time
                        totalStudyTime = totalStudyTime + studyTime;

                        // 3. increase number of sessions by 1
                        sessionCount++;

                        // 4. display updated total study time
                        System.out.println("Study session added!");
                        System.out.println("Current total study time: " + totalStudyTime + " minutes");
                    }
                }
                // 5. return to main menu (loop repeats)

            } else if (menuChoice == 2) {
                // Option 2: View Statistics
                System.out.println("===== WEEKLY STATISTICS =====");
                System.out.println();
                System.out.println("Study sessions: " + sessionCount);
                System.out.println("Total study time: " + totalStudyTime + " minutes");
                System.out.println();
                System.out.println("Programming: " + programmingMinutes + " minutes");
                System.out.println("Mathematics: " + mathMinutes + " minutes");
                System.out.println("English: " + englishMinutes + " minutes");
                System.out.println("Other: " + otherMinutes + " minutes");

            } else if (menuChoice == 3) {
                // Option 3: Check Weekly Goal
                System.out.println("Weekly goal: " + weeklyGoal + " minutes");
                System.out.println("You studied: " + totalStudyTime + " minutes");

                if (totalStudyTime >= weeklyGoal) {
                    System.out.println("Weekly goal achieved!");
                } else {
                    int remaining = weeklyGoal - totalStudyTime;
                    System.out.println("Remaining: " + remaining + " minutes");
                }

            } else if (menuChoice == 4) {
                // Option 4: Exit
                System.out.println("Study tracker closed. Keep up the good work!");

            } else {
                System.out.println("Invalid option. Try again.");
            }

            System.out.println();
        }

        input.close();
    }
}
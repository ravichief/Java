import java.util.Scanner;
public class program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Assuming passwords which had already been
        // created was retrieved from a database or file here.
        String storedHashedPassword[] = { "6f60d1f47f250adcc10b8e6b4e35e6e8bf4c17b44288292da2c8ed8881b60c65","10d1b9bb93009059621609ef1099e0b6fe644cab07c6698ee612a088db5cfbf9","5d085d416c944bd95733db1b7c9ad0878783f1bdf6bfb326d39867a15373b7c1","4c2c9fe7afe724cde1bdc30abe2692be091037b6411e699c2cd2f57304fa8786","b614b05720c8e1236745588a3b0d5c5964534371e9767ab33011c477cd28c459" };
        int c = 1;
        System.out.print("Enter the password to verify: ");
        String passwordToVerify = sc.nextLine();
        for (int i = 0; i <5; i++) {
            String hashedPasswordToVerify = program2.encryptPassword(passwordToVerify);
            if (hashedPasswordToVerify.equals(storedHashedPassword[i])) {
                c = 1;
                break;
            } else {
                c = 0;
            }
        }
        if (c == 0)
        System.out.println("Password is incorrect!");
        else if (c == 1)
        System.out.println("Password is correct!");
        sc.close();
    }
}

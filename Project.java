import java.util.Scanner;
public class Project
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the objective of the project:");
        String objective = scanner.nextLine();
        System.out.println("Objective is: " +objective);
    }
}

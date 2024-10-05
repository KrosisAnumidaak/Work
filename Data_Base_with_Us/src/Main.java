import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       MyDataBase myDataBase = new MyDataBase();
       Methods methods = new Methods();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        if (choose == 1)
        {
            methods.SortedStudentsOutput();
        }
        else if (choose == 2)
        {

        }
        else if (choose == 3)
        {
            System.out.println("Введите фамилию студента:");
            methods.SearchStudents(scanner.next());
        }
        else if (choose == 4)
        {
            System.out.println("Введите номер варианта: ");
            methods.SearchStudentsVar(scanner.next());
        }
    }
}
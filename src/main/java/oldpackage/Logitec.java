//package example_project;
//
//
//import example_project.repository.PostgresUserRepository;
//import example_project.repository.UserRepository;
//
//import java.util.List;
//import java.util.Scanner;
//
//
//public class Logitec {
//    private static UserRepository userRepository;
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        UserRepository userRepository = new PostgresUserRepository();
//
//        PostgresService.createTable();
//
//        while (true) {
//            printMenu();
//            int choice = scanner.nextInt();
//
//
//            switch (choice) {
//                case 1 -> {
//                    findAllUsers(userRepository);
//                }
//                case 2 -> {
//                    addUser(scanner, userRepository);
//                }
//                case 3 -> {
//                    deleteUser(scanner, userRepository);
//                }
//                case 4 -> {
//                    updateUser(scanner, userRepository);
//                }
//                case 5 -> System.exit(0);
//
//                default -> System.err.println("Команда не распознана");
//            }
//        }
//
//    }
//
//    private static void deleteUser(Scanner scanner, UserRepository userRepository) {
//        System.out.println("Введите ID для удаления: ");
//        int userId = scanner.nextInt();
//        userRepository.delete(userId);
//    }
//
//
//
//    private static void findAllUsers(UserRepository userRepository) {
//        List<User> users = userRepository.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//    public Logitec(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public static List<User> findAllUsers() {
//        return userRepository.findAll();
//    }
//
//
//
//    private static void addUser(Scanner scanner, UserRepository userRepository) {
//        System.out.println("Введите имя: ");
//        scanner.nextLine();
//        String name = scanner.nextLine();
//
//        System.out.println("Введите возраст: ");
//        int age = scanner.nextInt();
//
//        System.out.println("Введите расу: ");
//        scanner.nextLine();
//        String race = scanner.nextLine();
//
//        User user = new User(name, age, race);
//        User savedUser = userRepository.save(user);
//        System.out.println("Пользователь сохранён: " + savedUser);
//    }
//
//
//    private static String askName() {
//        System.out.println("Введите имя: ");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextLine();
//    }
//
//    static void printMenu() {
//        System.out.println();
//        System.out.println("Выберите действие: ");
//        System.out.println("1 - Посмотреть всех пользователей ");
//        System.out.println("2 - создать пользователя ");
//        System.out.println("3 - удалить пользователя ");
//        System.out.println("4 - изменить пользователя ");
//        System.out.println("5 - выход из программы ");
//        System.out.print("Введите ваш выбор: ");
//    }
//
//    static void createUser(String name, int age, String race) {
//        User user = new User(name,age,race);
//    }
//    private static void updateUser(Scanner scanner, UserRepository userRepository) {
//        System.out.print("Введите ID пользователя для изменения: ");
//        int userId = scanner.nextInt();
//        scanner.nextLine(); // Очистка буфера после считывания int
//
//        System.out.print("Введите новое имя: ");
//        String name = scanner.nextLine();
//
//        System.out.print("Введите новый возраст: ");
//        int age = scanner.nextInt();
//        scanner.nextLine(); // Очистка буфера после считывания int
//
//        System.out.print("Введите новую расу: ");
//        String race = scanner.nextLine();
//
//        User updatedUser = new User(userId, name, age, race);
//        userRepository.update(updatedUser);
//        System.out.println("Пользователь изменен: " + updatedUser);
//    }
//}

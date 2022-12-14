package pl.Marcin.millionaire.game;

import pl.Marcin.millionaire.question.Question;
import pl.Marcin.millionaire.dao.QuestionDao;

import java.util.List;
import java.util.Scanner;

public class Admin {
    private final QuestionDao questionDao;
    private boolean userInputLoop = true;

    public Admin(){
        questionDao = new QuestionDao();
    }

    public void userInput(){
        Scanner scanner = new Scanner(System.in);
        while(userInputLoop) {
            System.out.println("\n********************");
            System.out.println("To show question's list type: list");
            System.out.println("To add a question type: add");
            System.out.println("To exit admin' section type: exit");
            String input = scanner.nextLine();

            handle(input);
        }
    }

    private void handle(String line) {
        switch (line) {
            case "list" -> {
                System.out.println("\nQuestion list");
                List<Question> questions = questionDao.getQuestions();
                questions.forEach(System.out::println);
            }
            case "add" -> addQuestion();
            case "exit" -> userInputLoop = false;
            default -> System.out.println("Wrong command");
        }
    }

    private void addQuestion(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter category level: (1, 2 or 3)");
        String category = scanner.nextLine();
        System.out.println("Enter question name:");
        String question = scanner.nextLine();
        System.out.println("Enter 1st answer:");
        String answer1 = scanner.nextLine();
        System.out.println("Enter 2nd answer:");
        String answer2 = scanner.nextLine();
        System.out.println("Enter 3rd answer:");
        String answer3 = scanner.nextLine();
        System.out.println("Enter 4th answer:");
        String answer4 = scanner.nextLine();
        System.out.println("Enter number corresponding to correct answer: (1, 2, 3 or 4)");
        String correctAnswerNr = scanner.nextLine();

        questionDao.add(new Question(category, question, answer1, answer2, answer3, answer4, correctAnswerNr));
    }

}

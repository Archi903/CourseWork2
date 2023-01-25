package datebook;

import exception.IncorrectArgumentException;
import exception.TaskNotFoundException;
import interval_task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private static final Map<Integer, Task> taskMap = new HashMap<>();

    public static void main(String[] args) throws TaskNotFoundException, IncorrectArgumentException {
        add();
        removeTask();
        getAllByDate();
        System.out.println(taskMap.get(1));
    }


    public static void add() throws IncorrectArgumentException {
        Scanner key = new Scanner(System.in);
        System.out.println("Задайте интервал (введите цифру): \n 0 - разовая задача \n 1 - задача на каждый день \n 2 - задача на каждую неделю \n 3 - задача на каждый месяц \n 4 - задача на каждый год");
        int a = key.nextInt();
        if (a == 0) {
            System.out.println("Добавьте задачу.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Укажите тип задачи (Рабочая или личная): ");
                String type2 = key.nextLine();/// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
                String type = key.nextLine();
                System.out.println("Название задачи: ");
                String title = key.nextLine();
                System.out.println("Описание задачи: ");
                LocalDateTime now = LocalDateTime.now();
                String description = key.nextLine();
                Task task = new OneTimeTask(title, description, TypeOfTask.Type.findByWrite(type), now);
                taskMap.put(task.getId(), task);
                System.out.println("Желаете добавить задачу еще ординарную задачу?");
                String s = key.nextLine();
                exit = s.equalsIgnoreCase("Нет");
                boolean exit2 = s.equalsIgnoreCase("Да");
                if (exit) {
                    System.out.println("Задачи записаны");
                } else if (exit2) {
                    System.out.println("Повторяем задачу");
                } else {
                    System.out.println("Команда не распознана");
                    break;
                }
            }
            reChoose();
        } else if (a == 1) {
            System.out.println("Добавьте задачу.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Укажите тип задачи (Рабочая или личная): ");
                String type2 = key.nextLine();/// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
                String type = key.nextLine();
                System.out.println("Название задачи: ");
                String title = key.nextLine();
                System.out.println("Описание задачи: ");
                LocalDateTime now = LocalDateTime.now();
                String description = key.nextLine();
                Task task = new DailyTask(title, description, TypeOfTask.Type.findByWrite(type), now);
                taskMap.put(task.getId(), task);
                System.out.println("Желаете добавить задачу еще каждодневную задачу?");
                String s = key.nextLine();
                exit = s.equalsIgnoreCase("Нет");
                boolean exit2 = s.equalsIgnoreCase("Да");
                if (exit) {
                    System.out.println("Задачи записаны");
                } else if (exit2) {
                    System.out.println("Повторяем задачу");
                } else {
                    System.out.println("Команда не распознана");
                    break;
                }
            }
            reChoose();
        } else if (a == 2) {
            System.out.println("Добавьте задачу.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Укажите тип задачи (Рабочая или личная): ");
                String type2 = key.nextLine();/// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
                String type = key.nextLine();
                System.out.println("Название задачи: ");
                String title = key.nextLine();
                System.out.println("Описание задачи: ");
                LocalDateTime now = LocalDateTime.now();
                String description = key.nextLine();
                Task task = new WeeklyTask(title, description, TypeOfTask.Type.findByWrite(type), now);
                taskMap.put(task.getId(), task);
                System.out.println("Желаете добавить задачу еще недельную задачу?");
                String s = key.nextLine();
                exit = s.equalsIgnoreCase("Нет");
                boolean exit2 = s.equalsIgnoreCase("Да");
                if (exit) {
                    System.out.println("Задачи записаны");
                } else if (exit2) {
                    System.out.println("Повторяем задачу");
                } else {
                    System.out.println("Команда не распознана");
                    break;
                }
            }
            reChoose();
        } else if (a == 3) {
            System.out.println("Добавьте задачу.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Укажите тип задачи (Рабочая или личная): ");
                String type2 = key.nextLine();/// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
                String type = key.nextLine();
                System.out.println("Название задачи: ");
                String title = key.nextLine();
                System.out.println("Описание задачи: ");
                LocalDateTime now = LocalDateTime.now();
                String description = key.nextLine();
                Task task = new MonthlyTask(title, description, TypeOfTask.Type.findByWrite(type), now);
                taskMap.put(task.getId(), task);
                System.out.println("Желаете добавить задачу еще ежемесячную задачу?");
                String s = key.nextLine();
                exit = s.equalsIgnoreCase("Нет");
                boolean exit2 = s.equalsIgnoreCase("Да");
                if (exit) {
                    System.out.println("Задачи записаны");
                } else if (exit2) {
                    System.out.println("Повторяем задачу");
                } else {
                    System.out.println("Команда не распознана");
                    break;
                }
            }
            reChoose();
        } else if (a == 4) {
            System.out.println("Добавьте задачу.");
            boolean exit = false;
            while (!exit) {
                System.out.println("Укажите тип задачи (Рабочая или личная): ");
                String type2 = key.nextLine(); /// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
                String type = key.nextLine();
                System.out.println("Название задачи: ");
                String title = key.nextLine();
                System.out.println("Описание задачи: ");
                LocalDateTime now = LocalDateTime.now();
                String description = key.nextLine();
                Task task = new YearTask(title, description, TypeOfTask.Type.findByWrite(type), now);
                taskMap.put(task.getId(), task);
                System.out.println("Желаете добавить задачу еще ежегодную задачу?");
                String s = key.nextLine();
                exit = s.equalsIgnoreCase("Нет");
                boolean exit2 = s.equalsIgnoreCase("Да");
                if (exit) {
                    System.out.println("Задачи записаны");
                } else if (exit2) {
                    System.out.println("Повторяем задачу");
                } else {
                    System.out.println("Команда не распознана");
                    break;
                }
            }
            reChoose();
        } else {
            System.out.println("Команда не распознана, выберите число");
            add();
        }
    }

    private static void removeTask() {
        Scanner key = new Scanner(System.in);
        System.out.println("\nЖелаете удалить задачу?");
        String a = key.nextLine();
        boolean exit = a.equalsIgnoreCase("Нет");
        while (!exit) {
            System.out.println("Введите ID задачи: ");
            int i = key.nextInt();
            taskMap.remove(i);
            System.out.println("Удалить еще задачу?");
            String xx1 = key.nextLine(); /// Неизвестный для меня БАГ, если убрать эту строчку, то он будет игнорировать следующую строчку и возвращаться в цикл.
            String xx = key.nextLine();
            exit = xx.equalsIgnoreCase("Нет");
        }
    }

    private static void reChoose() throws IncorrectArgumentException {
        Scanner key = new Scanner(System.in);
        System.out.println("Желаете добавить задачу другого типа?");
        String answerUser = key.nextLine();
        boolean exit1 = answerUser.equalsIgnoreCase("нет");
        boolean exit2 = answerUser.equalsIgnoreCase("да");
        if (exit2) {
            add();
        } else if (exit1) {
            System.out.println("Конец задачи");
        } else {
            System.out.println("Команда не распознана, введите да или нет");
            reChoose();
        }
    }

    public static void getAllByDate() throws TaskNotFoundException {
        Scanner key = new Scanner(System.in);
        System.out.println("Желаете получить задачи на день?");
        String a = key.nextLine();
        boolean exit = a.equalsIgnoreCase("Нет");
        while (!exit) {
            System.out.println("Введите дату в формате: \nгод: \nмесяц: \nдень:");
            int year = key.nextInt();
            int month = key.nextInt();
            int day = key.nextInt();
            for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
                if (taskMap.getValue().appearsln(LocalDate.of(year, month, day))) {
                    System.out.println(taskMap.getValue());
                }
            }
            System.out.println("Желаете получить задачи на другой день?");
            String answerUser = key.nextLine();
            String answerUser2 = key.nextLine();
            exit = answerUser.equalsIgnoreCase("Нет");
            boolean exit2 = answerUser.equalsIgnoreCase("Да");
            if (exit) {
                System.out.println("Конец просмотра задач");
            } else if (exit2) {
                System.out.println("Запускаем просмотр");
            } else {
                System.out.println("Команда не распознана");
                break;
            }
        }
    }
    private static void getAllList () {
            for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
                System.out.println(taskMap.getValue().appearsln(LocalDate.now()));
                String value = String.valueOf(taskMap);
                System.out.println(value);
            }
        }

}
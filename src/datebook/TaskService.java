package datebook;

import exception.TaskNotFoundException;
import interval_task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private static final Map<Integer, Task> TASK_MAP = new HashMap<>();

    public static void add() {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.println("Задайте интервал задачи (введите цифру): \n 0 - разовая задача \n 1 - задача на каждый день \n 2 - задача на каждую неделю \n 3 - задача на каждый месяц \n 4 - задача на каждый год");
        int a = key.nextInt();
        boolean exit = false;
        while (!exit) {
            System.out.println("Укажите тип задачи (Рабочая или личная): ");
            String type = key.next();
            System.out.println("Название задачи: ");
            String title = key.next();
            System.out.println("Описание задачи: ");
            LocalDateTime now = LocalDateTime.now();
            String description = key.next();
            if (a == 0) {
                Task task = new OneTimeTask(title, description, Type.findByWrite(type), now);
                TASK_MAP.put(task.getId(), task);
            } else if (a == 1) {
                Task task = new DailyTask(title, description, Type.findByWrite(type), now);
                TASK_MAP.put(task.getId(), task);
            } else if (a == 2) {
                Task task = new WeeklyTask(title, description, Type.findByWrite(type), now);
                TASK_MAP.put(task.getId(), task);
            } else if (a == 3) {
                Task task = new MonthlyTask(title, description, Type.findByWrite(type), now);
                TASK_MAP.put(task.getId(), task);
            } else if (a == 4) {
                Task task = new YearTask(title, description, Type.findByWrite(type), now);
                TASK_MAP.put(task.getId(), task);
            } else {
                System.out.println("Команда не распознана, выберите число");
                add();
            }
            System.out.println("Желаете добавить еще задачу такого же типа?");
            String s = key.next();
            key.useDelimiter("\n");
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
    }

    public static void removeTask() {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.println("Желаете удалить задачу?");
        String a = key.next();
        boolean exit = a.equalsIgnoreCase("Нет");
        while (!exit) {
            System.out.println("Введите ID задачи: ");
            int i = key.nextInt();
            try {
                if (TASK_MAP.get(i) != null) {
                    TASK_MAP.remove(i);
                    System.out.println("Удалить еще задачу?");
                    String s = key.next();
                    exit = s.equalsIgnoreCase("Нет");
                    boolean exit2 = s.equalsIgnoreCase("Да");
                    if (exit) {
                        System.out.println("Задачи удалены");
                        break;
                    } else if (exit2) {
                        System.out.println("Повторяем задачу");
                    } else {
                        System.out.println("Команда не распознана");
                        removeTask();
                    }
                } else if (TASK_MAP.get(i) == null) {
                    System.out.println("Такого ID не существует");
                    throw new TaskNotFoundException("Такого ID не существует", TASK_MAP.get(i));
                }
            } catch (TaskNotFoundException e) {
                System.out.println("Необходимо вводить существующий ID");
                break;
            }
        }
    }

    public static void reChoose() {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.println("Желаете добавить задачу другого типа?");
        String answerUser = key.next();
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
        removeTask();
    }

    public static void getAllByDate() {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.println("Желаете получить задачи на день?");
        String a = key.next();
        boolean exit = a.equalsIgnoreCase("Нет");
        while (!exit) {
            System.out.println("Введите дату в формате: \nгод: \nмесяц: \nдень:");
            int year = key.nextInt();
            int month = key.nextInt();
            int day = key.nextInt();
            for (Map.Entry<Integer, Task> taskMap : TASK_MAP.entrySet()) {
                if (taskMap.getValue().appearsln(LocalDate.of(year, month, day))) {
                    System.out.println(taskMap.getValue());
                }
            }
            System.out.println("Желаете получить задачи на другой день?");
            String answerUser = key.next();
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

    public static void getAllList() {
        for (Map.Entry<Integer, Task> taskMap : TASK_MAP.entrySet()) {
            System.out.println(taskMap.getValue().appearsln(LocalDate.now()));
            String value = String.valueOf(taskMap);
            System.out.println(value);
        }
    }


}
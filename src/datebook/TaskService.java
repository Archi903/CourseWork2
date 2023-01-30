package datebook;

import exception.IncorrectArgumentException;
import exception.TaskNotFoundException;
import interval_task.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class TaskService {
    private static final Map<Integer, Task> TASK_MAP = new HashMap<>();

    public static void add(int a) throws IncorrectArgumentException {
        boolean exit = false;
        while (!exit) {
            Scanner key = new Scanner(System.in);
            key.useDelimiter("\n");
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
                System.out.println("Команда не распознана.");
                break;
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
    }

    public static void removeTask(int a) {
            try {
                if (TASK_MAP.get(a) != null) {
                    TASK_MAP.remove(a);
                        System.out.println("Задачи удалены");
                } else if (TASK_MAP.get(a) == null) {
                    System.out.println("Такого ID не существует");
                    throw new TaskNotFoundException("Такого ID не существует", TASK_MAP.get(a));
                }
            } catch (TaskNotFoundException e) {
                System.out.println("Необходимо вводить существующий ID");
            }
        }



    public static void getAllByDate(int year, int month, int day) {
        for (Map.Entry<Integer, Task> taskMap : TASK_MAP.entrySet()) {
            if (taskMap.getValue().appearsln(LocalDate.of(year, month, day))) {
                System.out.println(taskMap.getValue());
                System.out.println("Конец просмотра задач");
            }
        }
    }
}
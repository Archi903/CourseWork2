package datebook;


import exception.IncorrectArgumentException;

import java.util.Arrays;
import java.util.Scanner;

import static datebook.TaskService.*;

public class Main {
    public static void main(String[] args) throws IncorrectArgumentException {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        start();
        System.out.println(TASK_MAP);
    }

    public static void start() throws IncorrectArgumentException {
        Scanner key = new Scanner(System.in);
        key.useDelimiter("\n");
        System.out.println("Выберите задачу или нажмите на любую кнопку чтобы завершить программу. \n 1 - добавить задачу \n 2 - удалить задачу \n 3 - получить все задачи на дату \n 4 - редактировать задачу \n 5 - посмотреть удаленные задачи \n 6 - остановить программу ");
        int q = key.nextInt();
        if (q == 1) {
            System.out.println("Задайте интервал задачи (введите цифру): \n 0 - разовая задача \n 1 - задача на каждый день \n 2 - задача на каждую неделю \n 3 - задача на каждый месяц \n 4 - задача на каждый год");
            int a = key.nextInt();
            add(a);
            start();
        } else if (q == 2) {
            System.out.println("Выберите ID задачи");
            int a = key.nextInt();
            removeTask(a);
            start();
        } else if (q == 3) {
            System.out.println("Введите дату: \nгод: ");
            int year = key.nextInt();
            System.out.println("месяц: ");
            int month = key.nextInt();
            System.out.println("день: ");
            int day = key.nextInt();
            getAllByDate(year, month, day);
            start();
        } else if (q == 4) {
            System.out.println("1 - изменить оглавление \n 2 - изменить описание");
            int enter = key.nextInt();
            System.out.println("Введите id:");
            int id = key.nextInt();
            System.out.println("Введите текст");
            String changeText = key.next();
            if (enter == 1) {
                updateTitle(id, changeText);
            } else if (enter == 2) {
                updateDescription(id, changeText);
            } else {
                System.out.println("Команда не распознана");
            }
        } else if (q == 5) {
            getRemovedTask();
        } else if (q == 6) {
            System.out.println("Программа остановлена");
        } else {
            System.out.println("Нет такой задачи");
            start();
        }
    }
}

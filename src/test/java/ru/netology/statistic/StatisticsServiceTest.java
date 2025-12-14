package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatisticsServiceTest {

    // 1. Тест из задания (Первый элемент = Максимум. Посещается только ветка 'if' = false)
    @Test
    void findMaxInitialTest() {
        StatisticsService service = new StatisticsService();
        // 12 - первый элемент и максимум. Метод вернет 12.
        long[] incomesInBillions = {12, 5, 8, 4, 5, 3, 8, 6, 11, 11, 12};
        long expected = 12;

        long actual = service.findMax(incomesInBillions);

        assertEquals(expected, actual);
    }

    // 2. Дополнительный тест (Первый элемент < Максимум. Посещается ветка 'if' = true)
    @Test
    void findMaxMustVisitMaxUpdateLine() {
        StatisticsService service = new StatisticsService();
        // 1 - первый элемент, 100 - второй. Метод, из-за бага, обновит current_max до 100
        // и вернет 100 на первой же итерации.
        long[] incomes = {1, 100, 50};
        long expected = 100; // Ожидаем 100, потому что метод обновляет и сразу возвращает это значение

        long actual = service.findMax(incomes);

        assertEquals(expected, actual);
    }
}
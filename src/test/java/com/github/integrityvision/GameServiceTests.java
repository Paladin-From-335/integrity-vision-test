package com.github.integrityvision;

import com.github.integrityvision.dto.RequestDto;
import com.github.integrityvision.services.GameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(SpringExtension.class)
public class GameServiceTests {

    @InjectMocks
    private GameService gameService;

    @Test
    void checkWords() {
        String[] correctWords = {"fish", "horse", "egg", "goose", "eagle"};
        String[] incorrectWord = {"fish", "horse", "duck", "goose", "eagle"};
        String[] emptyStringInside = {"fish", "", "egg", "goose", "eagle"};
        String[] emptyStringAtStart = {"", "horse", "egg", "goose", "eagle"};
        String[] twoIncorrectWords = {"fish", "horse", "duck", "goose", "bird"};
        String[] twoEmptyStrings = {"fish", "", "egg", "", "eagle"};
        String[] oneWord = {"fish"};

        assertAll(
                () -> assertArrayEquals(new String[]{"fish", "horse", "egg", "goose", "eagle"}, gameService.compareWords(correctWords).toArray()),
                () -> assertArrayEquals(new String[]{"fish", "horse"}, gameService.compareWords(incorrectWord).toArray()),
                () -> assertArrayEquals(new String[]{"fish"}, gameService.compareWords(emptyStringInside).toArray()),
                () -> assertArrayEquals(new String[]{}, gameService.compareWords(emptyStringAtStart).toArray()),
                () -> assertArrayEquals(new String[]{"fish", "horse"}, gameService.compareWords(twoIncorrectWords).toArray()),
                () -> assertArrayEquals(new String[]{"fish"}, gameService.compareWords(twoEmptyStrings).toArray()),
                () -> assertArrayEquals(new String[]{"fish"}, gameService.compareWords(oneWord).toArray())
        );
    }
}

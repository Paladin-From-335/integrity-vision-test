package com.github.integrityvision.controllers;

import com.github.integrityvision.dto.RequestDto;
import com.github.integrityvision.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/checkwords")
    public List<String> checkWords(@RequestBody RequestDto payload) {
        if (payload.getWordlist().length == 0) {
            return new ArrayList<>();
        }
       return this.gameService.compareWords(payload.getWordlist());
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Incorrect data")
    private String exceptionInfo() {
        return "Error. Incorrect data";
    }
}

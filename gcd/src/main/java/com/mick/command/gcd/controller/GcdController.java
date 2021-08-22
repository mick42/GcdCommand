package com.mick.command.gcd.controller;

import com.mick.command.gcd.dto.GcdDto;
import com.mick.command.gcd.service.GcdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@Slf4j
@RestController
public class GcdController {

    @GetMapping("/execute")
    public String execute(@RequestParam(value = "value")String message) {
        log.info(message);
        String[] args = message.split(",");
        Optional<GcdDto> dtoOpt = new GcdDto.Builder(args[0], args[1]).build();
        if(dtoOpt.isEmpty()) {
            return "Invalid arguments: " + message;
        }

        GcdDto dto = dtoOpt.get();
        GcdService service = new GcdService();
        service.calculate(dto);
        return "GCD OK - " + message + " Result = " + dto.getResult();
    }
}

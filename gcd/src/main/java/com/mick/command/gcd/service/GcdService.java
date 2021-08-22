package com.mick.command.gcd.service;

import com.mick.command.gcd.dto.GcdDto;

public class GcdService {

    public void calculate(GcdDto dto) {
        dto.setResult(calculate(dto.getArg1(), dto.getArg2()));
    }

    private long calculate(long arg1, long arg2) {
        long next = arg1 % arg2;
        if(next == 0) {
            return arg2;
        }
        return calculate(arg2, next);
    }
}

package com.mick.command.gcd.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Getter
@RequiredArgsConstructor (access = AccessLevel.PRIVATE)
public class GcdDto {
    private final long arg1;
    private final long arg2;

    @Setter
    private Long result;

    private String status = "OK";
    private String message;

    public static class Builder {
        private GcdDto dto;
        public Builder(String arg1, String arg2) {
            try {
                dto = new GcdDto(Long.parseLong(arg1), Long.parseLong(arg2));
            } catch (Exception e) {
                dto = new GcdDto(-1, -1);
                dto.status = "Invalid";
                dto.message = e.getMessage();
            }
        }

        public Builder(long arg1, long arg2) {
            dto = new GcdDto(arg1, arg2);
        }

        public Optional<GcdDto> build() {
            return validate();
        }

        Optional<GcdDto> validate() {
            // Add validation code here
            if(!"OK".equals(this.dto.status)){
                log.warn("OOPS Status={}. Message={}", dto.status, dto.message);
                return Optional.empty();
            }
            return Optional.of(this.dto);
        }
    }

}

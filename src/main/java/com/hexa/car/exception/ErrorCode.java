package com.hexa.car.exception;

import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorCode {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}

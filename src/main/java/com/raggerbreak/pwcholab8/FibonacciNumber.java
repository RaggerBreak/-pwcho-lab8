package com.raggerbreak.pwcholab8;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FibonacciNumber implements Serializable {

    private Integer position;
    private Integer value;
}

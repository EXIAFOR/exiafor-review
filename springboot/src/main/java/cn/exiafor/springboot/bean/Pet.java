package cn.exiafor.springboot.bean;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoAutoStart
@AllArgsConstructor
@Data
public class Pet {
    private String name;
}

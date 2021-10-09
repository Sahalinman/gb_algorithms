package lesson2.homework.teacherRealization;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Value
public class Notebook implements Comparable<Notebook> {
    BigDecimal price;
    int memory;
    Producer producer;
    UUID serialId = UUID.randomUUID();

    public enum Producer {
        LENUVO, ASOS, MACNOTE, ESER, XAMIOU
    }

    @Override
    public int compareTo(Notebook n) {
        int result = price.compareTo(n.getPrice());
        if (result == 0) {
            result =  Integer.compare(memory, n.getMemory());
            if (result == 0) {
                return producer.compareTo(n.getProducer());
            }
            return result;
        }
        return result;
    }

}

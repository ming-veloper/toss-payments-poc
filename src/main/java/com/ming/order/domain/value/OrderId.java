package com.ming.order.domain.value;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.RandomString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderId implements Serializable {

    @Column(name = "order_id")
    private String id;

    public static OrderId generate() {
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        String randomString = RandomString.make(4);
        String id = String.format("%d-%d-%d-%s", year, month, day, randomString);
        return OrderId.builder()
                .id(id)
                .build();
    }
}

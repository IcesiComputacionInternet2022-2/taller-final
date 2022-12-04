package icesi.VirtualStore.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum OrderStatus {
    CREATED("CREATED"), COMPLETED("COMPLETED"), SENT("SENT");

    private final String message;

}

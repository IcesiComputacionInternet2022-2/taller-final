package co.edu.icesi.JCStore.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TokenTime {

    ONE_MINUTE(60000l);

    private long time;
}

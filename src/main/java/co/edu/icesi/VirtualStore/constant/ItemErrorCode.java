package co.edu.icesi.VirtualStore.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ItemErrorCode {

    CODE_01("Item name already exists.");

    private final String message;
}

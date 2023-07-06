package top.miaofang.common.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author miao
 */
@AllArgsConstructor
@Getter
public enum PackageType {

    REQUEST_PACK(0),
    RESPONSE_PACK(1);

    private final int code;

}

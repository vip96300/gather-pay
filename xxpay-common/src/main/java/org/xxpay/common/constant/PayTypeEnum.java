package org.xxpay.common.constant;

import java.util.Arrays;
import java.util.Optional;

public enum PayTypeEnum {

    WX_MQ(1, "pay_type_wx_mp", "微信公众号支付"),
    WX_QR(2, "pay_type_wx_qr", "微信二维码支付"),
    WX_SC(3, "pay_type_wx_sc", "微信扫码支付"),
    WX_H5(4, "pay_type_wx_h5", "微信H5支付"),
    AL_QR(5, "pay_type_al_qr", "支付宝二维码支付"),
    AL_SC(6, "pay_type_al_sc", "支付宝扫码支付"),
    QQ(7, "pay_type_qq", "QQ钱包支付"),
    JD(8, "pay_type_jd", "JD支付"),
    YL(9, "pay_type_yl", "银联快捷支付");

    private Integer id;
    private String code;
    private String name;

    PayTypeEnum(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PayTypeEnum convert(Integer id) {
        Optional<PayTypeEnum> gameType = Arrays.stream(values()).filter(v -> v.getId().equals(id)).findFirst();
        return gameType.orElse(null);
    }
}

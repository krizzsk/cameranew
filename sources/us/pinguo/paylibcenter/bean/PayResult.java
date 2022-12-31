package us.pinguo.paylibcenter.bean;

import java.io.Serializable;
import us.pinguo.paylibcenter.PayHelp;
/* loaded from: classes5.dex */
public class PayResult implements Serializable {
    public static final int PAY_RESULT_ALIPAY_CHECK_IN = 8000;
    public static final int PAY_RESULT_CHECK_ERROR = 17;
    public static final int PAY_RESULT_CHECK_FAIL = 16;
    public static final int PAY_RESULT_CHECK_SUCCESS = 15;
    public static final int PAY_RESULT_ERROR = 6;
    public static final int PAY_RESULT_GOOGLE_BILLING_UNAVAILABLE = 3;
    public static final int PAY_RESULT_GOOGLE_DEVELOPER_ERROR = 5;
    public static final int PAY_RESULT_GOOGLE_ITEM_ALREADY_OWNED = 7;
    public static final int PAY_RESULT_GOOGLE_ITEM_NOT_OWNED = 8;
    public static final int PAY_RESULT_GOOGLE_ITEM_UNAVAILABLE = 4;
    public static final int PAY_RESULT_GOOGLE_PLAY_NOT_INSTALLED = 9;
    public static final int PAY_RESULT_GOOGLE_SERVICE_UNAVAILABLE = 2;
    public static final int PAY_RESULT_ORDER_CREATE_ERROR = 13;
    public static final int PAY_RESULT_ORDER_CREATE_FAIL = 12;
    public static final int PAY_RESULT_OTHER_ERROR = 20;
    public static final int PAY_RESULT_PARAM_NULL = 18;
    public static final int PAY_RESULT_PENDING = 21;
    public static final int PAY_RESULT_RESPONSE_NULL = 14;
    public static final int PAY_RESULT_SIGN_ERROR = 19;
    public static final int PAY_RESULT_SUCCESS = 0;
    public static final int PAY_RESULT_USER_CANCELED = 1;
    public static final int PAY_RESULT_WX_NOT_INSTALLED = 10;
    public static final int PAY_RESULT_WX_NOT_SURPPORT = 11;
    private String ext;
    private String hmsProductId;
    public int mPuchaseState;
    public long mPuchaseTime;
    public String mPuchaseToken;
    private String message;
    public String orderId;
    private PayHelp.PAYWAY payway;
    private int resultCode;
    private String sourceResult;
    private int status;
    private String subscribeId;
    private String token;

    public PayResult(int i2, String str, String str2) {
        this.status = 0;
        this.resultCode = -1;
        this.mPuchaseTime = 0L;
        this.status = i2;
        this.message = str;
        this.ext = str2;
    }

    public static PayResult obtain(String str) {
        return new PayResult(str);
    }

    public String getExt() {
        String str = this.ext;
        return str == null ? "" : str;
    }

    public String getHmsProductId() {
        return this.hmsProductId;
    }

    public String getMessage() {
        String str = this.message;
        return str == null ? "" : str;
    }

    public PayHelp.PAYWAY getPayway() {
        return this.payway;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getSourceResult() {
        return this.sourceResult;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSubscribeId() {
        return this.subscribeId;
    }

    public String getToken() {
        return this.token;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setHmsProductId(String str) {
        this.hmsProductId = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setPayway(PayHelp.PAYWAY payway) {
        this.payway = payway;
    }

    public void setResultCode(int i2) {
        this.resultCode = i2;
    }

    public void setSourceResult(String str) {
        this.sourceResult = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setSubscribeId(String str) {
        this.subscribeId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public PayResult(int i2, String str) {
        this.status = 0;
        this.resultCode = -1;
        this.mPuchaseTime = 0L;
        this.status = i2;
        this.message = str;
    }

    public PayResult(String str, String str2) {
        this.status = 0;
        this.resultCode = -1;
        this.mPuchaseTime = 0L;
        this.message = str;
        this.ext = str2;
    }

    public PayResult(String str) {
        this.status = 0;
        this.resultCode = -1;
        this.mPuchaseTime = 0L;
        this.message = str;
    }
}

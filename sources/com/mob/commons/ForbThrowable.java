package com.mob.commons;
/* loaded from: classes2.dex */
public class ForbThrowable extends Throwable {
    public static final int CODE_NO_GMS = 900;
    private int code;

    public ForbThrowable() {
        super("Service is forbidden currently");
    }

    public static ForbThrowable obtainGpThrowable() {
        return new ForbThrowable(900, "Service unavailable due to Google Play Services is unavailable!");
    }

    public int getCode() {
        return this.code;
    }

    public ForbThrowable(String str) {
        super(str);
    }

    public ForbThrowable(String str, Throwable th) {
        super(str, th);
    }

    public ForbThrowable(int i2, String str) {
        this(str);
        this.code = i2;
    }

    public ForbThrowable(int i2, String str, Throwable th) {
        this(str, th);
        this.code = i2;
    }

    public ForbThrowable(Throwable th) {
        super(th);
    }
}

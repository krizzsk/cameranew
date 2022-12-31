package com.mob.commons.dialog;
/* loaded from: classes2.dex */
public class PolicyThrowable extends Throwable {
    private int code;

    public PolicyThrowable() {
        super("Privacy policy is not accepted");
    }

    public int getCode() {
        return this.code;
    }

    public PolicyThrowable(String str) {
        super(str);
    }

    public PolicyThrowable(String str, Throwable th) {
        super(str, th);
    }

    public PolicyThrowable(int i2, String str) {
        this(str);
        this.code = i2;
    }

    public PolicyThrowable(int i2, String str, Throwable th) {
        this(str, th);
        this.code = i2;
    }

    public PolicyThrowable(Throwable th) {
        super(th);
    }
}

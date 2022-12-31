package com.tencent.stat;
/* loaded from: classes3.dex */
public class StatAppMonitor implements Cloneable {
    public static final int FAILURE_RESULT_TYPE = 1;
    public static final int LOGIC_FAILURE_RESULT_TYPE = 2;
    public static final int SUCCESS_RESULT_TYPE = 0;
    private String a;
    private long b;
    private long c;

    /* renamed from: d  reason: collision with root package name */
    private int f8225d;

    /* renamed from: e  reason: collision with root package name */
    private long f8226e;

    /* renamed from: f  reason: collision with root package name */
    private int f8227f;

    /* renamed from: g  reason: collision with root package name */
    private int f8228g;

    public StatAppMonitor(String str) {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.f8225d = 0;
        this.f8226e = 0L;
        this.f8227f = 0;
        this.f8228g = 1;
        this.a = str;
    }

    public StatAppMonitor(String str, int i2, int i3, long j2, long j3, long j4, int i4) {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.f8225d = 0;
        this.f8226e = 0L;
        this.f8227f = 0;
        this.f8228g = 1;
        this.a = str;
        this.b = j2;
        this.c = j3;
        this.f8225d = i2;
        this.f8226e = j4;
        this.f8227f = i3;
        this.f8228g = i4;
    }

    /* renamed from: clone */
    public StatAppMonitor m38clone() {
        try {
            return (StatAppMonitor) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public String getInterfaceName() {
        return this.a;
    }

    public long getMillisecondsConsume() {
        return this.f8226e;
    }

    public long getReqSize() {
        return this.b;
    }

    public long getRespSize() {
        return this.c;
    }

    public int getResultType() {
        return this.f8225d;
    }

    public int getReturnCode() {
        return this.f8227f;
    }

    public int getSampling() {
        return this.f8228g;
    }

    public void setInterfaceName(String str) {
        this.a = str;
    }

    public void setMillisecondsConsume(long j2) {
        this.f8226e = j2;
    }

    public void setReqSize(long j2) {
        this.b = j2;
    }

    public void setRespSize(long j2) {
        this.c = j2;
    }

    public void setResultType(int i2) {
        this.f8225d = i2;
    }

    public void setReturnCode(int i2) {
        this.f8227f = i2;
    }

    public void setSampling(int i2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        this.f8228g = i2;
    }
}

package com.ironsource.mediationsdk.logger;
/* loaded from: classes2.dex */
public abstract class IronSourceLogger {
    int a;
    private String b;

    /* loaded from: classes2.dex */
    public enum IronSourceTag {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IronSourceLogger(String str) {
        this.b = str;
        this.a = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String c() {
        return this.b;
    }

    public abstract void d(IronSourceTag ironSourceTag, String str, int i2);

    public abstract void e(IronSourceTag ironSourceTag, String str, Throwable th);

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IronSourceLogger)) {
            return false;
        }
        IronSourceLogger ironSourceLogger = (IronSourceLogger) obj;
        String str = this.b;
        return str != null && str.equals(ironSourceLogger.b);
    }

    public void f(int i2) {
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IronSourceLogger(String str, int i2) {
        this.b = str;
        this.a = i2;
    }
}

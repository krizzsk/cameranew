package com.ironsource.mediationsdk.k0;
/* compiled from: ConfigValidationResult.java */
/* loaded from: classes2.dex */
public class b {
    private boolean a = true;
    private com.ironsource.mediationsdk.logger.b b = null;

    public com.ironsource.mediationsdk.logger.b a() {
        return this.b;
    }

    public boolean b() {
        return this.a;
    }

    public void c(com.ironsource.mediationsdk.logger.b bVar) {
        this.a = false;
        this.b = bVar;
    }

    public String toString() {
        if (b()) {
            return "valid:" + this.a;
        }
        return "valid:" + this.a + ", IronSourceError:" + this.b;
    }
}

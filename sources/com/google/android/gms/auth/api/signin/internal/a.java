package com.google.android.gms.auth.api.signin.internal;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class a {
    private static int b = 31;
    private int a = 1;

    public a a(Object obj) {
        this.a = (b * this.a) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    public int b() {
        return this.a;
    }

    public final a c(boolean z) {
        this.a = (b * this.a) + (z ? 1 : 0);
        return this;
    }
}

package com.ironsource.mediationsdk.utils;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
/* compiled from: ApplicationGeneralSettings.kt */
/* loaded from: classes2.dex */
public final class a {
    private final boolean a;
    private final String b;

    public a() {
        this(false, null, 3, null);
    }

    public a(boolean z, String externalArmEventsUrl) {
        s.i(externalArmEventsUrl, "externalArmEventsUrl");
        this.a = z;
        this.b = externalArmEventsUrl;
    }

    public final String a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && s.c(this.b, aVar.b);
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        String str = this.b;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ApplicationGeneralSettings(isExternalArmEventsEnabled=" + this.a + ", externalArmEventsUrl=" + this.b + ")";
    }

    public /* synthetic */ a(boolean z, String str, int i2, o oVar) {
        this((i2 & 1) != 0 ? true : z, (i2 & 2) != 0 ? "http://outcome-arm-ext-med-ext.sonic-us.supersonicads.com/aemData" : str);
    }
}

package com.ironsource.mediationsdk.model;

import java.util.Map;
import kotlin.collections.m0;
/* compiled from: ApplicationExternalSettings.kt */
/* loaded from: classes2.dex */
public final class e {
    private final boolean a;
    private final Map<String, String> b;

    public e() {
        this(false, null, 3, null);
    }

    public e(boolean z, Map<String, String> mediationTypes) {
        kotlin.jvm.internal.s.i(mediationTypes, "mediationTypes");
        this.a = z;
        this.b = mediationTypes;
    }

    public final Map<String, String> a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.a == eVar.a && kotlin.jvm.internal.s.c(this.b, eVar.b);
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
        Map<String, String> map = this.b;
        return i2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "ApplicationExternalSettings(isCompressExternalToken=" + this.a + ", mediationTypes=" + this.b + ")";
    }

    public /* synthetic */ e(boolean z, Map map, int i2, kotlin.jvm.internal.o oVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? m0.f() : map);
    }
}

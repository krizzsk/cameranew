package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzept {
    public static zzept zzn(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase("Dalvik")) {
            return new zzepq(cls.getSimpleName());
        }
        return new zzeps(cls.getSimpleName());
    }

    public abstract void zzio(String str);
}

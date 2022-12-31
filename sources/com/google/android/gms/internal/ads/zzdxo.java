package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdxo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzd(Object obj, int i2) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i2);
        throw new NullPointerException(sb.toString());
    }
}

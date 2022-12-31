package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdwh {
    private static final Logger logger = Logger.getLogger(zzdwh.class.getName());
    private static final zzdwi zzhvy = new zza();

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
    /* loaded from: classes2.dex */
    private static final class zza {
        private zza() {
        }
    }

    private zzdwh() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String emptyToNull(@NullableDecl String str) {
        if (zzhl(str)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzhl(@NullableDecl String str) {
        return str == null || str.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zzhm(@NullableDecl String str) {
        return str == null ? "" : str;
    }
}

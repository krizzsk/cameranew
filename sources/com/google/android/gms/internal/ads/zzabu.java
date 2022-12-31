package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public final class zzabu {
    public static void zza(zzabs zzabsVar, @Nullable zzabt zzabtVar) {
        if (zzabtVar.getContext() != null) {
            if (!TextUtils.isEmpty(zzabtVar.zzlw())) {
                zzabsVar.zza(zzabtVar.getContext(), zzabtVar.zzlw(), zzabtVar.zzsj(), zzabtVar.zzsk());
                return;
            }
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
    }
}

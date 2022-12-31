package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzaub {
    private WeakHashMap<Context, zzaud> zzdyw = new WeakHashMap<>();

    public final Future<zzatz> zzv(Context context) {
        return zzazp.zzeic.zze(new zzaua(this, context));
    }
}

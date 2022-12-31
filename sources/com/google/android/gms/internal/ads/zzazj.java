package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzazj {
    public static <T> T zza(Context context, String str, zzazm<IBinder, T> zzazmVar) throws zzazl {
        try {
            return zzazmVar.apply(zzbu(context).d(str));
        } catch (Exception e2) {
            throw new zzazl(e2);
        }
    }

    public static Context zzbt(Context context) throws zzazl {
        return zzbu(context).b();
    }

    private static DynamiteModule zzbu(Context context) throws zzazl {
        try {
            return DynamiteModule.e(context, DynamiteModule.f3707i, ModuleDescriptor.MODULE_ID);
        } catch (Exception e2) {
            throw new zzazl(e2);
        }
    }
}

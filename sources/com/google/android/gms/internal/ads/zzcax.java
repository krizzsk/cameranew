package com.google.android.gms.internal.ads;

import com.tapjoy.TapjoyConstants;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcax implements zzeqb<String> {
    public static zzcax zzane() {
        zzcax zzcaxVar;
        zzcaxVar = zzcba.zzgce;
        return zzcaxVar;
    }

    public static String zzanf() {
        return (String) zzeqh.zza(TapjoyConstants.TJC_PLUGIN_NATIVE, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return zzanf();
    }
}

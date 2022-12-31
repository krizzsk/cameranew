package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdei implements zzeqb<zzdej> {
    private final zzeqo<String> zzgle;

    private zzdei(zzeqo<String> zzeqoVar) {
        this.zzgle = zzeqoVar;
    }

    public static zzdei zzaq(zzeqo<String> zzeqoVar) {
        return new zzdei(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzdej(this.zzgle.get());
    }
}

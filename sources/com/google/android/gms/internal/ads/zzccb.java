package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzccb implements zzeqb<zzccc> {
    private final zzeqo<zzcbs> zzged;

    private zzccb(zzeqo<zzcbs> zzeqoVar) {
        this.zzged = zzeqoVar;
    }

    public static zzccb zzz(zzeqo<zzcbs> zzeqoVar) {
        return new zzccb(zzeqoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqo
    public final /* synthetic */ Object get() {
        return new zzccc(this.zzged.get());
    }
}

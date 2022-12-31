package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class zzaxn implements zzaxs {
    static final zzaxs zzebl = new zzaxn();

    private zzaxn() {
    }

    @Override // com.google.android.gms.internal.ads.zzaxs
    public final Object zza(zzbfu zzbfuVar) {
        String currentScreenName = zzbfuVar.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbfuVar.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}

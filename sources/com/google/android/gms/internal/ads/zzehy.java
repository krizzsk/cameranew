package com.google.android.gms.internal.ads;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzehy {
    private final zzeil zzijq;
    private final zzeil zzijr;

    public zzehy(byte[] bArr, byte[] bArr2) {
        this.zzijq = zzeil.zzr(bArr);
        this.zzijr = zzeil.zzr(bArr2);
    }

    public final byte[] zzbfq() {
        zzeil zzeilVar = this.zzijq;
        if (zzeilVar == null) {
            return null;
        }
        return zzeilVar.getBytes();
    }

    public final byte[] zzbfr() {
        zzeil zzeilVar = this.zzijr;
        if (zzeilVar == null) {
            return null;
        }
        return zzeilVar.getBytes();
    }
}

package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzgb;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public abstract class zzga<MessageType extends zzgb<MessageType, BuilderType>, BuilderType extends zzga<MessageType, BuilderType>> implements zziw {
    @Override // 
    /* renamed from: zzaq */
    public abstract BuilderType clone();

    public BuilderType zzar(byte[] bArr, int i2, int i3) throws zzic {
        throw null;
    }

    public BuilderType zzas(byte[] bArr, int i2, int i3, zzhe zzheVar) throws zzic {
        throw null;
    }

    protected abstract BuilderType zzat(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* bridge */ /* synthetic */ zziw zzau(zzix zzixVar) {
        if (zzbK().getClass().isInstance(zzixVar)) {
            return zzat((zzgb) zzixVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* bridge */ /* synthetic */ zziw zzav(byte[] bArr, zzhe zzheVar) throws zzic {
        return zzas(bArr, 0, bArr.length, zzheVar);
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    public final /* bridge */ /* synthetic */ zziw zzaw(byte[] bArr) throws zzic {
        return zzar(bArr, 0, bArr.length);
    }
}

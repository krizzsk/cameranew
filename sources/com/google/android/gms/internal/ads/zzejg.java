package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejg;
import com.google.android.gms.internal.ads.zzejh;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-gass@@19.7.0 */
/* loaded from: classes2.dex */
public abstract class zzejg<MessageType extends zzejh<MessageType, BuilderType>, BuilderType extends zzejg<MessageType, BuilderType>> implements zzemn {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzekc zzekcVar, zzeko zzekoVar) throws IOException;

    public BuilderType zza(byte[] bArr, int i2, int i3, zzeko zzekoVar) throws zzelo {
        try {
            zzekc zzb = zzekc.zzb(bArr, 0, i3, false);
            zza(zzb, zzekoVar);
            zzb.zzgd(0);
            return this;
        } catch (zzelo e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    @Override // 
    /* renamed from: zzbfy */
    public abstract BuilderType clone();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzemn
    public final /* synthetic */ zzemn zzf(zzemo zzemoVar) {
        if (zzbiq().getClass().isInstance(zzemoVar)) {
            return zza((zzejh) zzemoVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}

package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.2 */
/* loaded from: classes2.dex */
public class zzho<MessageType extends zzhs<MessageType, BuilderType>, BuilderType extends zzho<MessageType, BuilderType>> extends zzga<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzho(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzl(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzjf.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    public final MessageType zzaA() {
        MessageType zzaD = zzaD();
        boolean z = true;
        byte byteValue = ((Byte) zzaD.zzl(1, null, null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z = false;
            } else {
                boolean zzj = zzjf.zza().zzb(zzaD.getClass()).zzj(zzaD);
                zzaD.zzl(2, true != zzj ? null : zzaD, null);
                z = zzj;
            }
        }
        if (z) {
            return zzaD;
        }
        throw new zzjv(zzaD);
    }

    public final BuilderType zzaB(MessageType messagetype) {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final BuilderType zzaC(byte[] bArr, int i2, int i3, zzhe zzheVar) throws zzic {
        if (this.zzb) {
            zzax();
            this.zzb = false;
        }
        try {
            zzjf.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i3, new zzge(zzheVar));
            return this;
        } catch (zzic e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            throw zzic.zza();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final /* bridge */ /* synthetic */ zzga zzar(byte[] bArr, int i2, int i3) throws zzic {
        zzaC(bArr, 0, i3, zzhe.zza());
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    public final /* bridge */ /* synthetic */ zzga zzas(byte[] bArr, int i2, int i3, zzhe zzheVar) throws zzic {
        zzaC(bArr, 0, i3, zzheVar);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzga
    protected final /* bridge */ /* synthetic */ zzga zzat(zzgb zzgbVar) {
        zzaB((zzhs) zzgbVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzax() {
        MessageType messagetype = (MessageType) this.zza.zzl(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }

    @Override // com.google.android.gms.internal.measurement.zzga
    /* renamed from: zzay */
    public final BuilderType zzaq() {
        BuilderType buildertype = (BuilderType) this.zzc.zzl(5, null, null);
        buildertype.zzaB(zzaD());
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zziw
    /* renamed from: zzaz */
    public MessageType zzaD() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzjf.zza().zzb(messagetype.getClass()).zzi(messagetype);
        this.zzb = true;
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zziy
    public final /* bridge */ /* synthetic */ zzix zzbK() {
        return this.zzc;
    }
}

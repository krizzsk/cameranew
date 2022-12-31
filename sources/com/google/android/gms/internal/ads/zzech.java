package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegd;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzech extends zzeax<zzeew> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzech() {
        super(zzeew.class, new zzecg(zzeaq.class));
    }

    private static boolean zzbbb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void zzbq(boolean z) throws GeneralSecurityException {
        if (zzbbb()) {
            zzebm.zza((zzeax) new zzech(), true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzegd.zza zzbal() {
        return zzegd.zza.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final zzeba<?, zzeew> zzbao() {
        return new zzecj(this, zzeez.class);
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ void zzc(zzeew zzeewVar) throws GeneralSecurityException {
        zzeew zzeewVar2 = zzeewVar;
        zzeiv.zzz(zzeewVar2.getVersion(), 0);
        zzeiv.zzfu(zzeewVar2.zzbbe().size());
    }

    @Override // com.google.android.gms.internal.ads.zzeax
    public final /* synthetic */ zzeew zzp(zzejr zzejrVar) throws zzelo {
        return zzeew.zzm(zzejrVar, zzeko.zzbhw());
    }
}

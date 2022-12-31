package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzda {
    private static boolean zzns = false;
    private static MessageDigest zznt;
    private static final Object zznu = new Object();
    private static final Object zznv = new Object();
    static CountDownLatch zznw = new CountDownLatch(1);

    private static Vector<byte[]> zza(byte[] bArr, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i4, bArr.length - i4 > 255 ? i4 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznu) {
            MessageDigest zzbp = zzbp();
            if (zzbp != null) {
                zzbp.reset();
                zzbp.update(bArr);
                digest = zznt.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    public static void zzbo() {
        synchronized (zznv) {
            if (!zzns) {
                zzns = true;
                new Thread(new zzdc()).start();
            }
        }
    }

    private static MessageDigest zzbp() {
        boolean z;
        MessageDigest messageDigest;
        zzbo();
        try {
            z = zznw.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = zznt) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String zzj(zzcf.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] zza;
        byte[] byteArray = zzaVar.toByteArray();
        if (!((Boolean) zzwr.zzqr().zzd(zzabp.zzcsh)).booleanValue()) {
            if (zzff.zzzp != null) {
                zza = ((zzcf.zzf) ((zzelb) zzcf.zzf.zzbl().zzi(zzejr.zzt(zzff.zzzp.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zza(zzcm.TINK_HYBRID).zzbiw())).toByteArray();
            } else {
                throw new GeneralSecurityException();
            }
        } else {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 != null && zza2.size() != 0) {
                zzcf.zzf.zza zzbl = zzcf.zzf.zzbl();
                Iterator<byte[]> it = zza2.iterator();
                while (it.hasNext()) {
                    zzbl.zzi(zzejr.zzt(zza(it.next(), str, false)));
                }
                zzbl.zzj(zzejr.zzt(zzb(byteArray)));
                zza = ((zzcf.zzf) ((zzelb) zzbl.zzbiw())).toByteArray();
            } else {
                zza = zza(zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            }
        }
        return zzcy.zza(zza, true);
    }

    private static zzcf.zza zza(zzcf.zza.zzd zzdVar) {
        zzcf.zza.zzb zzap = zzcf.zza.zzap();
        zzap.zzau(zzdVar.zzv());
        return (zzcf.zza) ((zzelb) zzap.zzbiw());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i2 = z ? 239 : 255;
        if (bArr.length > i2) {
            bArr = zza(zzcf.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i2) {
            byte[] bArr2 = new byte[i2 - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(zzb(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (zzdd zzddVar : new zzdb().zzvk) {
            zzddVar.zza(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzeje(str.getBytes("UTF-8")).zzs(bArr3);
        }
        return bArr3;
    }
}

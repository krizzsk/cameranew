package com.google.android.gms.internal.ads;

import com.growingio.android.sdk.java_websocket.drafts.Draft_75;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzehi implements zzeaq {
    private static final ThreadLocal<Cipher> zziiy = new zzehh();
    private static final ThreadLocal<Cipher> zziiz = new zzehk();
    private final SecretKeySpec zziiv;
    private final byte[] zzija;
    private final byte[] zzijb;
    private final int zzijc;

    public zzehi(byte[] bArr, int i2) throws GeneralSecurityException {
        if (i2 != 12 && i2 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzijc = i2;
        zzeiv.zzfu(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zziiv = secretKeySpec;
        Cipher cipher = zziiy.get();
        cipher.init(1, secretKeySpec);
        byte[] zzo = zzo(cipher.doFinal(new byte[16]));
        this.zzija = zzo;
        this.zzijb = zzo(zzo);
    }

    private final byte[] zza(Cipher cipher, int i2, byte[] bArr, int i3, int i4) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i2;
        if (i4 == 0) {
            return cipher.doFinal(zzd(bArr3, this.zzija));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i5 = 0;
        while (i4 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i3 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i3, i3 + i4);
        if (copyOfRange.length == 16) {
            bArr2 = zzd(copyOfRange, this.zzija);
        } else {
            byte[] copyOf = Arrays.copyOf(this.zzijb, 16);
            for (int i7 = 0; i7 < copyOfRange.length; i7++) {
                copyOf[i7] = (byte) (copyOf[i7] ^ copyOfRange[i7]);
            }
            copyOf[copyOfRange.length] = (byte) (copyOf[copyOfRange.length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(zzd(doFinal, bArr2));
    }

    private static byte[] zzd(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
        return bArr3;
    }

    private static byte[] zzo(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i2 = 0;
        while (i2 < 15) {
            int i3 = i2 + 1;
            bArr2[i2] = (byte) ((bArr[i2] << 1) ^ ((bArr[i3] & Draft_75.END_OF_FRAME) >>> 7));
            i2 = i3;
        }
        bArr2[15] = (byte) ((bArr[15] << 1) ^ ((bArr[0] & 128) != 0 ? 135 : 0));
        return bArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final byte[] zzc(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i2 = this.zzijc;
        if (length <= (Integer.MAX_VALUE - i2) - 16) {
            byte[] bArr3 = new byte[bArr.length + i2 + 16];
            byte[] zzft = zzeiu.zzft(i2);
            System.arraycopy(zzft, 0, bArr3, 0, this.zzijc);
            Cipher cipher = zziiy.get();
            cipher.init(1, this.zziiv);
            byte[] zza = zza(cipher, 0, zzft, 0, zzft.length);
            byte[] bArr4 = bArr2 == null ? new byte[0] : bArr2;
            byte[] zza2 = zza(cipher, 1, bArr4, 0, bArr4.length);
            Cipher cipher2 = zziiz.get();
            cipher2.init(1, this.zziiv, new IvParameterSpec(zza));
            cipher2.doFinal(bArr, 0, bArr.length, bArr3, this.zzijc);
            byte[] zza3 = zza(cipher, 2, bArr3, this.zzijc, bArr.length);
            int length2 = bArr.length + this.zzijc;
            for (int i3 = 0; i3 < 16; i3++) {
                bArr3[length2 + i3] = (byte) ((zza2[i3] ^ zza[i3]) ^ zza3[i3]);
            }
            return bArr3;
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}

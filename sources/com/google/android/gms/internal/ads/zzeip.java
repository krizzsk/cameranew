package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzeip implements zzedv {
    private final ThreadLocal<Mac> zzikq;
    private final String zzikr;
    private final Key zziks;
    private final int zzikt;

    public zzeip(String str, Key key) throws GeneralSecurityException {
        zzeis zzeisVar = new zzeis(this);
        this.zzikq = zzeisVar;
        this.zzikr = str;
        this.zziks = key;
        if (key.getEncoded().length >= 16) {
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1823053428:
                    if (str.equals("HMACSHA1")) {
                        c = 0;
                        break;
                    }
                    break;
                case 392315118:
                    if (str.equals("HMACSHA256")) {
                        c = 1;
                        break;
                    }
                    break;
                case 392316170:
                    if (str.equals("HMACSHA384")) {
                        c = 2;
                        break;
                    }
                    break;
                case 392317873:
                    if (str.equals("HMACSHA512")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.zzikt = 20;
                    break;
                case 1:
                    this.zzikt = 32;
                    break;
                case 2:
                    this.zzikt = 48;
                    break;
                case 3:
                    this.zzikt = 64;
                    break;
                default:
                    String valueOf = String.valueOf(str);
                    throw new NoSuchAlgorithmException(valueOf.length() != 0 ? "unknown Hmac algorithm: ".concat(valueOf) : new String("unknown Hmac algorithm: "));
            }
            zzeisVar.get();
            return;
        }
        throw new InvalidAlgorithmParameterException("key size too small, need at least 16 bytes");
    }

    @Override // com.google.android.gms.internal.ads.zzedv
    public final byte[] zzd(byte[] bArr, int i2) throws GeneralSecurityException {
        if (i2 <= this.zzikt) {
            this.zzikq.get().update(bArr);
            return Arrays.copyOf(this.zzikq.get().doFinal(), i2);
        }
        throw new InvalidAlgorithmParameterException("tag size too big");
    }
}

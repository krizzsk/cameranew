package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzek {
    private static Cipher zzya;
    private static final Object zzyb = new Object();
    private static final Object zzyc = new Object();
    private final SecureRandom zzxz = null;

    public zzek(SecureRandom secureRandom) {
    }

    private static Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (zzyc) {
            if (zzya == null) {
                zzya = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zzya;
        }
        return cipher;
    }

    public final byte[] zza(byte[] bArr, String str) throws zzej {
        byte[] doFinal;
        if (bArr.length == 16) {
            try {
                byte[] zzb = zzcy.zzb(str, false);
                if (zzb.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(zzb.length);
                    allocate.put(zzb);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[zzb.length - 16];
                    allocate.get(bArr2);
                    allocate.get(bArr3);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (zzyb) {
                        getCipher().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        doFinal = getCipher().doFinal(bArr3);
                    }
                    return doFinal;
                }
                throw new zzej(this);
            } catch (IllegalArgumentException e2) {
                throw new zzej(this, e2);
            } catch (InvalidAlgorithmParameterException e3) {
                throw new zzej(this, e3);
            } catch (InvalidKeyException e4) {
                throw new zzej(this, e4);
            } catch (NoSuchAlgorithmException e5) {
                throw new zzej(this, e5);
            } catch (BadPaddingException e6) {
                throw new zzej(this, e6);
            } catch (IllegalBlockSizeException e7) {
                throw new zzej(this, e7);
            } catch (NoSuchPaddingException e8) {
                throw new zzej(this, e8);
            }
        }
        throw new zzej(this);
    }

    public final byte[] zzao(String str) throws zzej {
        try {
            byte[] zzb = zzcy.zzb(str, false);
            if (zzb.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(zzb, 4, 16).get(bArr);
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ 68);
                }
                return bArr;
            }
            throw new zzej(this);
        } catch (IllegalArgumentException e2) {
            throw new zzej(this, e2);
        }
    }

    public final String zzb(byte[] bArr, byte[] bArr2) throws zzej {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (zzyb) {
                    getCipher().init(1, secretKeySpec, (SecureRandom) null);
                    doFinal = getCipher().doFinal(bArr2);
                    iv = getCipher().getIV();
                }
                int length = doFinal.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(doFinal);
                allocate.flip();
                byte[] bArr3 = new byte[length];
                allocate.get(bArr3);
                return zzcy.zza(bArr3, false);
            } catch (InvalidKeyException e2) {
                throw new zzej(this, e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new zzej(this, e3);
            } catch (BadPaddingException e4) {
                throw new zzej(this, e4);
            } catch (IllegalBlockSizeException e5) {
                throw new zzej(this, e5);
            } catch (NoSuchPaddingException e6) {
                throw new zzej(this, e6);
            }
        }
        throw new zzej(this);
    }
}

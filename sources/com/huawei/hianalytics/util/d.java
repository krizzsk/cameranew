package com.huawei.hianalytics.util;

import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public abstract class d {

    /* loaded from: classes2.dex */
    public static class a extends Exception {
        public a() {
            super("Fail to encrypt with RSA");
        }
    }

    public static String a() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return h.a(bArr);
    }

    public static String a(String str) {
        try {
            return h.a(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): UnsupportedEncodingException");
            throw new a();
        }
    }

    public static String a(String str, byte[] bArr, String str2) {
        if (str2 != null && !TextUtils.isEmpty(str) && bArr != null && bArr.length != 0) {
            try {
                return h.a(a(str, bArr, str2.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException unused) {
                com.huawei.hianalytics.b.b.c("Crypter", "aesEncrypt(): UnsupportedEncodingException");
            }
        }
        return "";
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null || bArr.length == 0) {
            return str;
        }
        if (str == null) {
            str = "";
        }
        return h.a(bArr).concat(str);
    }

    public static RSAPublicKey a(String str, String str2) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(str), new BigInteger(str2)));
    }

    public static byte[] a(String str, byte[] bArr, byte[] bArr2) {
        String str2;
        if (str == null || bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, new SecretKeySpec(h.a(str), "AES"), new IvParameterSpec(bArr));
            return cipher.doFinal(bArr2);
        } catch (InvalidAlgorithmParameterException unused) {
            str2 = "aesEncrypt(): InvalidAlgorithmParameterException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        } catch (InvalidKeyException unused2) {
            str2 = "aesEncrypt(): InvalidKeyException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        } catch (NoSuchAlgorithmException unused3) {
            str2 = "aesEncrypt(): NoSuchAlgorithmException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        } catch (BadPaddingException unused4) {
            str2 = "aesEncrypt(): BadPaddingException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        } catch (IllegalBlockSizeException unused5) {
            str2 = "aesEncrypt(): IllegalBlockSizeException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        } catch (NoSuchPaddingException unused6) {
            str2 = "aesEncrypt(): NoSuchPaddingException: fail to encrypt";
            com.huawei.hianalytics.b.b.c("Crypter", str2);
            return new byte[0];
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            RSAPublicKey a2 = a("24907259431961377209480304447420314675278854956424737688244507998454379688588314890162679979323703303509240796245532111474023047392580178709435281576624542294613207523485034492914828565153172773053351891188090398210811384185501117117991603774176386409127476628856566065613009756131651597266262540467980974946876675842468600552312158771248419700603327630677244315755445967726919102965015263135288381740211593751262078285738436597133664401598420056690274760726854877181978220226448211936820860496708860964018593025172845041095854180953040116559241637133730839837036910305932797451786785855051024967644159284784940216337", "65537");
            if (a2 != null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
                cipher.init(1, a2);
                return cipher.doFinal(bArr);
            }
            throw new UnsupportedEncodingException();
        } catch (UnsupportedEncodingException unused) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): UnsupportedEncodingException");
            throw new a();
        } catch (InvalidKeyException unused2) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): InvalidKeyException");
            throw new a();
        } catch (NoSuchAlgorithmException unused3) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): NoSuchAlgorithmException");
            throw new a();
        } catch (InvalidKeySpecException unused4) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): InvalidKeySpecException");
            throw new a();
        } catch (BadPaddingException unused5) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): BadPaddingException");
            throw new a();
        } catch (IllegalBlockSizeException unused6) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): IllegalBlockSizeException");
            throw new a();
        } catch (NoSuchPaddingException unused7) {
            com.huawei.hianalytics.b.b.c("Crypter", "rsaEncrypt(): NoSuchPaddingException");
            throw new a();
        }
    }

    public static Pair<byte[], String> b(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, 32);
        return new Pair<>(h.a(substring), str.substring(32));
    }

    public static String b() {
        byte[] bArr = new byte[128];
        new SecureRandom().nextBytes(bArr);
        return h.a(bArr);
    }

    public static String b(String str, byte[] bArr, String str2) {
        String str3;
        if (str != null && bArr != null && bArr.length != 0 && str2 != null) {
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, new SecretKeySpec(h.a(str), "AES"), new IvParameterSpec(bArr));
                return new String(cipher.doFinal(h.a(str2)), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                str3 = "aesDecrypt(): UnsupportedEncodingException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (InvalidAlgorithmParameterException unused2) {
                str3 = "aesDecrypt(): InvalidAlgorithmParameterException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (InvalidKeyException unused3) {
                str3 = "aesDecrypt(): InvalidKeyException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (NoSuchAlgorithmException unused4) {
                str3 = "aesDecrypt(): NoSuchAlgorithmException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (BadPaddingException unused5) {
                str3 = "aesDecrypt(): BadPaddingException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (IllegalBlockSizeException unused6) {
                str3 = "aesDecrypt(): IllegalBlockSizeException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            } catch (NoSuchPaddingException unused7) {
                str3 = "aesDecrypt(): NoSuchPaddingException: fail to decrypt";
                com.huawei.hianalytics.b.b.c("Crypter", str3);
                return "";
            }
        }
        return "";
    }

    public static String b(String str, byte[] bArr, byte[] bArr2) {
        return (bArr2 == null || TextUtils.isEmpty(str) || bArr == null || bArr.length == 0) ? "" : h.a(a(str, bArr, bArr2));
    }

    public static String c(String str) {
        try {
            return a(str);
        } catch (a unused) {
            com.huawei.hianalytics.b.b.c("Crypter", "rasEncryptKey(): RSAEncryptionException");
            return "";
        }
    }

    public static byte[] c() {
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}

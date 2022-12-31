package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import android.util.Base64;
import com.adjust.sdk.Constants;
import com.tencent.open.log.SLog;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Calendar;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;
/* compiled from: ProGuard */
/* loaded from: classes3.dex */
public class a {
    private KeyStore a;
    private SharedPreferences b;

    public a(Context context) {
        try {
            this.b = context.getSharedPreferences("KEYSTORE_SETTING", 0);
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.a = keyStore;
            keyStore.load(null);
            if (this.a.containsAlias("KEYSTORE_AES")) {
                return;
            }
            c("");
            a(context);
            a();
        } catch (Exception e2) {
            SLog.d("KEYSTORE", "Exception", e2);
        }
    }

    private void a(Context context) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Build.VERSION.SDK_INT=");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(i2);
        SLog.d("KEYSTORE", sb.toString());
        if (i2 >= 23) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder("KEYSTORE_AES", 3).setDigests(Constants.SHA256, "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
        } else if (i2 >= 18) {
            KeyPairGenerator keyPairGenerator2 = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 30);
            keyPairGenerator2.initialize(new KeyPairGeneratorSpec.Builder(context).setAlias("KEYSTORE_AES").setSubject(new X500Principal("CN=KEYSTORE_AES")).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build());
            keyPairGenerator2.generateKeyPair();
        }
    }

    private void c(String str) {
        this.b.edit().putString("PREF_KEY_IV", str).apply();
    }

    private void d(String str) {
        this.b.edit().putString("PREF_KEY_AES", str).apply();
    }

    public String b(String str) {
        try {
            byte[] decode = Base64.decode(str.getBytes(), 0);
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(2, c(), new IvParameterSpec(b()));
            return new String(cipher.doFinal(decode));
        } catch (Exception e2) {
            SLog.e("KEYSTORE", "Exception", e2);
            return "";
        }
    }

    private SecretKeySpec c() throws Exception {
        String string = this.b.getString("PREF_KEY_AES", "");
        if (Build.VERSION.SDK_INT >= 18) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(2, (PrivateKey) this.a.getKey("KEYSTORE_AES", null));
            return new SecretKeySpec(cipher.doFinal(Base64.decode(string, 0)), "AES/GCM/NoPadding");
        }
        return new SecretKeySpec(Base64.decode(string, 0), "AES/GCM/NoPadding");
    }

    private byte[] b() {
        return Base64.decode(this.b.getString("PREF_KEY_IV", ""), 0);
    }

    public String a(String str) {
        try {
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(1, c(), new IvParameterSpec(b()));
            return Base64.encodeToString(cipher.doFinal(str.getBytes()), 0);
        } catch (Exception e2) {
            SLog.e("KEYSTORE", "Exception", e2);
            return "";
        }
    }

    private void a() throws Exception {
        byte[] bArr = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bArr);
        c(Base64.encodeToString(secureRandom.generateSeed(12), 0));
        if (Build.VERSION.SDK_INT >= 18) {
            PublicKey publicKey = this.a.getCertificate("KEYSTORE_AES").getPublicKey();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKey);
            d(Base64.encodeToString(cipher.doFinal(bArr), 0));
            return;
        }
        MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
        messageDigest.update(bArr);
        d(Base64.encodeToString(messageDigest.digest(), 0));
    }
}

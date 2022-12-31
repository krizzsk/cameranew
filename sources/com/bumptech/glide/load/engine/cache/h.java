package com.bumptech.glide.load.engine.cache;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SafeKeyGenerator.java */
/* loaded from: classes.dex */
public class h {
    private final com.bumptech.glide.l.e<com.bumptech.glide.load.b, String> a = new com.bumptech.glide.l.e<>(1000);

    public String a(com.bumptech.glide.load.b bVar) {
        String g2;
        synchronized (this.a) {
            g2 = this.a.g(bVar);
        }
        if (g2 == null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA256);
                bVar.a(messageDigest);
                g2 = com.bumptech.glide.l.h.l(messageDigest.digest());
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            synchronized (this.a) {
                this.a.k(bVar, g2);
            }
        }
        return g2;
    }
}

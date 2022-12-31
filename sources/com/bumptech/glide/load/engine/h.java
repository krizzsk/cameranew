package com.bumptech.glide.load.engine;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
/* compiled from: OriginalKey.java */
/* loaded from: classes.dex */
class h implements com.bumptech.glide.load.b {
    private final String a;
    private final com.bumptech.glide.load.b b;

    public h(String str, com.bumptech.glide.load.b bVar) {
        this.a = str;
        this.b = bVar;
    }

    @Override // com.bumptech.glide.load.b
    public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        messageDigest.update(this.a.getBytes("UTF-8"));
        this.b.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a) && this.b.equals(hVar.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }
}

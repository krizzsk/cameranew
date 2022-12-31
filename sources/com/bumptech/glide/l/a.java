package com.bumptech.glide.l;

import android.util.Log;
import java.util.Queue;
/* compiled from: ByteArrayPool.java */
/* loaded from: classes.dex */
public final class a {
    private static final a b = new a();
    private final Queue<byte[]> a = h.c(0);

    private a() {
    }

    public static a a() {
        return b;
    }

    public byte[] b() {
        byte[] poll;
        synchronized (this.a) {
            poll = this.a.poll();
        }
        if (poll == null) {
            poll = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return poll;
    }

    public boolean c(byte[] bArr) {
        boolean z = false;
        if (bArr.length != 65536) {
            return false;
        }
        synchronized (this.a) {
            if (this.a.size() < 32) {
                z = true;
                this.a.offer(bArr);
            }
        }
        return z;
    }
}

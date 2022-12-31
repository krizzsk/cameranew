package com.pinguo.camera360.gallery.data;

import android.content.Context;
import com.pinguo.album.data.utils.d;
import com.pinguo.album.i.a.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import org.slf4j.Marker;
/* loaded from: classes3.dex */
public class LocalBlobCacheService {
    private com.pinguo.album.i.a.a a;

    public LocalBlobCacheService(Context context) {
        this.a = com.pinguo.album.i.a.b.a(context, "imgcache", 5000, 209715200, 4);
    }

    private static boolean b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (bArr2.length < length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static byte[] c(String str, int i2) {
        return com.pinguo.album.j.c.g(str.toString() + Marker.ANY_NON_NULL_MARKER + i2);
    }

    public boolean a(String str, int i2, d.b bVar) {
        a.C0232a c0232a;
        if (this.a == null) {
            return false;
        }
        byte[] c = c(str, i2);
        long h2 = com.pinguo.album.j.a.h(c);
        try {
            c0232a = new a.C0232a();
            c0232a.a = h2;
            c0232a.b = bVar.a;
        } catch (IOException unused) {
        }
        synchronized (this.a) {
            if (this.a.O(c0232a)) {
                if (b(c, c0232a.b)) {
                    bVar.a = c0232a.b;
                    int length = c.length;
                    bVar.b = length;
                    bVar.c = c0232a.c - length;
                    return true;
                }
                return false;
            }
            return false;
        }
    }

    public void d(String str, int i2, byte[] bArr) {
        if (this.a == null) {
            return;
        }
        byte[] c = c(str, i2);
        long h2 = com.pinguo.album.j.a.h(c);
        ByteBuffer allocate = ByteBuffer.allocate(c.length + bArr.length);
        allocate.put(c);
        allocate.put(bArr);
        synchronized (this.a) {
            try {
                this.a.z(h2, allocate.array());
            } catch (IOException unused) {
            }
        }
    }
}

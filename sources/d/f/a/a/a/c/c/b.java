package d.f.a.a.a.c.c;

import android.graphics.Bitmap;
import androidx.core.location.LocationRequestCompat;
import d.f.a.a.a.c.c.a;
import d.f.a.b.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: LruDiscCache.java */
/* loaded from: classes3.dex */
public class b implements d.f.a.a.a.b {

    /* renamed from: f  reason: collision with root package name */
    public static final Bitmap.CompressFormat f8589f = Bitmap.CompressFormat.PNG;
    protected a a;
    protected final d.f.a.a.a.d.a b;
    protected int c = 32768;

    /* renamed from: d  reason: collision with root package name */
    protected Bitmap.CompressFormat f8590d = f8589f;

    /* renamed from: e  reason: collision with root package name */
    protected int f8591e = 100;

    public b(File file, File file2, d.f.a.a.a.d.a aVar, long j2, int i2) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        int i3 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i3 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (aVar != null) {
            long j3 = i3 == 0 ? LocationRequestCompat.PASSIVE_INTERVAL : j2;
            int i4 = i2 == 0 ? Integer.MAX_VALUE : i2;
            this.b = aVar;
            d(file, file2, j3, i4);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    private String c(String str) {
        return this.b.a(str);
    }

    private void d(File file, File file2, long j2, int i2) throws IOException {
        try {
            this.a = a.T(file, 1, 1, j2, i2);
        } catch (IOException e2) {
            d.f.a.b.d.c(e2);
            if (file2 != null) {
                d(file2, null, j2, i2);
            }
            if (this.a == null) {
                throw e2;
            }
        }
    }

    @Override // d.f.a.a.a.a
    public boolean a(String str, Bitmap bitmap) throws IOException {
        a.c O = this.a.O(c(str));
        if (O == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(O.f(0), this.c);
        try {
            boolean compress = bitmap.compress(this.f8590d, this.f8591e, bufferedOutputStream);
            if (compress) {
                O.e();
            } else {
                O.a();
            }
            return compress;
        } finally {
            d.f.a.b.c.a(bufferedOutputStream);
        }
    }

    @Override // d.f.a.a.a.a
    public boolean b(String str, InputStream inputStream, c.a aVar) throws IOException {
        a.c O = this.a.O(c(str));
        if (O == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(O.f(0), this.c);
        try {
            boolean c = d.f.a.b.c.c(inputStream, bufferedOutputStream, aVar, this.c);
            d.f.a.b.c.a(bufferedOutputStream);
            if (c) {
                O.e();
            } else {
                O.a();
            }
            return c;
        } catch (Throwable th) {
            d.f.a.b.c.a(bufferedOutputStream);
            O.a();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    @Override // d.f.a.a.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            d.f.a.a.a.c.c.a r1 = r3.a     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            java.lang.String r4 = r3.c(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            d.f.a.a.a.c.c.a$e r4 = r1.R(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.a(r1)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L2b
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r1 = move-exception
            goto L22
        L1b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L2c
        L20:
            r1 = move-exception
            r4 = r0
        L22:
            d.f.a.b.d.c(r1)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L2a
            r4.close()
        L2a:
            return r0
        L2b:
            r0 = move-exception
        L2c:
            if (r4 == 0) goto L31
            r4.close()
        L31:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.f.a.a.a.c.c.b.get(java.lang.String):java.io.File");
    }

    @Override // d.f.a.a.a.a
    public boolean remove(String str) {
        try {
            return this.a.Y(c(str));
        } catch (IOException e2) {
            d.f.a.b.d.c(e2);
            return false;
        }
    }
}

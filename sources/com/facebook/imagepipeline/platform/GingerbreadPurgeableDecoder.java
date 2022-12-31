package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.common.internal.h;
import com.facebook.common.internal.m;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.g;
import com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class GingerbreadPurgeableDecoder extends DalvikPurgeableDecoder {

    /* renamed from: d  reason: collision with root package name */
    private static Method f2862d;
    @Nullable
    private final com.facebook.common.c.b c = com.facebook.common.c.c.i();

    private static MemoryFile i(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, @Nullable byte[] bArr) throws IOException {
        OutputStream outputStream;
        com.facebook.common.b.a aVar2;
        g gVar = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i2);
        memoryFile.allowPurging(false);
        try {
            g gVar2 = new g(aVar.A());
            try {
                aVar2 = new com.facebook.common.b.a(gVar2, i2);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    com.facebook.common.internal.a.a(aVar2, outputStream2);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i2, bArr.length);
                    }
                    com.facebook.common.references.a.y(aVar);
                    com.facebook.common.internal.b.b(gVar2);
                    com.facebook.common.internal.b.b(aVar2);
                    com.facebook.common.internal.b.a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    gVar = gVar2;
                    com.facebook.common.references.a.y(aVar);
                    com.facebook.common.internal.b.b(gVar);
                    com.facebook.common.internal.b.b(aVar2);
                    com.facebook.common.internal.b.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                aVar2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            aVar2 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.graphics.Bitmap j(com.facebook.common.references.a<com.facebook.common.memory.PooledByteBuffer> r2, int r3, @javax.annotation.Nullable byte[] r4, android.graphics.BitmapFactory.Options r5) {
        /*
            r1 = this;
            r0 = 0
            android.os.MemoryFile r2 = i(r2, r3, r4)     // Catch: java.lang.Throwable -> L2b java.io.IOException -> L2d
            java.io.FileDescriptor r3 = r1.l(r2)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            com.facebook.common.c.b r4 = r1.c     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            if (r4 == 0) goto L1e
            android.graphics.Bitmap r3 = r4.c(r3, r0, r5)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            java.lang.String r4 = "BitmapFactory returned null"
            com.facebook.common.internal.h.h(r3, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            android.graphics.Bitmap r3 = (android.graphics.Bitmap) r3     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            if (r2 == 0) goto L1d
            r2.close()
        L1d:
            return r3
        L1e:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            java.lang.String r4 = "WebpBitmapFactory is null"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            throw r3     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
        L26:
            r3 = move-exception
            r0 = r2
            goto L33
        L29:
            r3 = move-exception
            goto L2f
        L2b:
            r3 = move-exception
            goto L33
        L2d:
            r3 = move-exception
            r2 = r0
        L2f:
            com.facebook.common.internal.m.a(r3)     // Catch: java.lang.Throwable -> L26
            throw r0
        L33:
            if (r0 == 0) goto L38
            r0.close()
        L38:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.GingerbreadPurgeableDecoder.j(com.facebook.common.references.a, int, byte[], android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private synchronized Method k() {
        if (f2862d == null) {
            try {
                f2862d = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e2) {
                m.a(e2);
                throw null;
            }
        }
        return f2862d;
    }

    private FileDescriptor l(MemoryFile memoryFile) {
        try {
            Object invoke = k().invoke(memoryFile, new Object[0]);
            h.g(invoke);
            return (FileDescriptor) invoke;
        } catch (Exception e2) {
            m.a(e2);
            throw null;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap d(com.facebook.common.references.a<PooledByteBuffer> aVar, BitmapFactory.Options options) {
        return j(aVar, aVar.A().size(), null, options);
    }

    @Override // com.facebook.imagepipeline.nativecode.DalvikPurgeableDecoder
    protected Bitmap e(com.facebook.common.references.a<PooledByteBuffer> aVar, int i2, BitmapFactory.Options options) {
        return j(aVar, i2, DalvikPurgeableDecoder.f(aVar, i2) ? null : DalvikPurgeableDecoder.b, options);
    }
}

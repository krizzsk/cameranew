package com.facebook.imagepipeline.nativecode;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.internal.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class NativeJpegTranscoder implements com.facebook.imagepipeline.g.c {
    private boolean a;
    private int b;
    private boolean c;

    public NativeJpegTranscoder(boolean z, int i2, boolean z2, boolean z3) {
        this.a = z;
        this.b = i2;
        this.c = z2;
        if (z3) {
            d.a();
        }
    }

    @VisibleForTesting
    public static void e(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        d.a();
        boolean z = false;
        h.b(Boolean.valueOf(i3 >= 1));
        h.b(Boolean.valueOf(i3 <= 16));
        h.b(Boolean.valueOf(i4 >= 0));
        h.b(Boolean.valueOf(i4 <= 100));
        h.b(Boolean.valueOf(com.facebook.imagepipeline.g.e.j(i2)));
        h.c((i3 == 8 && i2 == 0) ? true : true, "no transformation requested");
        h.g(inputStream);
        h.g(outputStream);
        nativeTranscodeJpeg(inputStream, outputStream, i2, i3, i4);
    }

    @VisibleForTesting
    public static void f(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException {
        d.a();
        boolean z = false;
        h.b(Boolean.valueOf(i3 >= 1));
        h.b(Boolean.valueOf(i3 <= 16));
        h.b(Boolean.valueOf(i4 >= 0));
        h.b(Boolean.valueOf(i4 <= 100));
        h.b(Boolean.valueOf(com.facebook.imagepipeline.g.e.i(i2)));
        h.c((i3 == 8 && i2 == 1) ? true : true, "no transformation requested");
        h.g(inputStream);
        h.g(outputStream);
        nativeTranscodeJpegWithExifOrientation(inputStream, outputStream, i2, i3, i4);
    }

    @com.facebook.common.internal.d
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i2, int i3, int i4) throws IOException;

    @Override // com.facebook.imagepipeline.g.c
    public String a() {
        return "NativeJpegTranscoder";
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean b(com.facebook.imagepipeline.image.e eVar, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar) {
        if (eVar2 == null) {
            eVar2 = com.facebook.imagepipeline.common.e.a();
        }
        return com.facebook.imagepipeline.g.e.f(eVar2, dVar, eVar, this.a) < 8;
    }

    @Override // com.facebook.imagepipeline.g.c
    public com.facebook.imagepipeline.g.b c(com.facebook.imagepipeline.image.e eVar, OutputStream outputStream, @Nullable com.facebook.imagepipeline.common.e eVar2, @Nullable com.facebook.imagepipeline.common.d dVar, @Nullable com.facebook.imageformat.c cVar, @Nullable Integer num) throws IOException {
        if (num == null) {
            num = 85;
        }
        if (eVar2 == null) {
            eVar2 = com.facebook.imagepipeline.common.e.a();
        }
        int b = com.facebook.imagepipeline.g.a.b(eVar2, dVar, eVar, this.b);
        try {
            int f2 = com.facebook.imagepipeline.g.e.f(eVar2, dVar, eVar, this.a);
            int a = com.facebook.imagepipeline.g.e.a(b);
            if (this.c) {
                f2 = a;
            }
            InputStream N = eVar.N();
            if (com.facebook.imagepipeline.g.e.a.contains(Integer.valueOf(eVar.x()))) {
                int d2 = com.facebook.imagepipeline.g.e.d(eVar2, eVar);
                h.h(N, "Cannot transcode from null input stream!");
                f(N, outputStream, d2, f2, num.intValue());
            } else {
                int e2 = com.facebook.imagepipeline.g.e.e(eVar2, eVar);
                h.h(N, "Cannot transcode from null input stream!");
                e(N, outputStream, e2, f2, num.intValue());
            }
            com.facebook.common.internal.b.b(N);
            return new com.facebook.imagepipeline.g.b(b != 1 ? 0 : 1);
        } catch (Throwable th) {
            com.facebook.common.internal.b.b(null);
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.g.c
    public boolean d(com.facebook.imageformat.c cVar) {
        return cVar == com.facebook.imageformat.b.a;
    }
}

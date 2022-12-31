package com.facebook.imagepipeline.nativecode;

import android.os.Build;
import com.facebook.common.internal.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
@com.facebook.common.internal.d
/* loaded from: classes.dex */
public class WebpTranscoderImpl implements f {
    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToJpeg(InputStream inputStream, OutputStream outputStream, int i2) throws IOException;

    @com.facebook.common.internal.d
    private static native void nativeTranscodeWebpToPng(InputStream inputStream, OutputStream outputStream) throws IOException;

    @Override // com.facebook.imagepipeline.nativecode.f
    public void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        e.a();
        h.g(inputStream);
        h.g(outputStream);
        nativeTranscodeWebpToPng(inputStream, outputStream);
    }

    @Override // com.facebook.imagepipeline.nativecode.f
    public boolean b(com.facebook.imageformat.c cVar) {
        if (cVar == com.facebook.imageformat.b.f2653f) {
            return Build.VERSION.SDK_INT >= 14;
        } else if (cVar != com.facebook.imageformat.b.f2654g && cVar != com.facebook.imageformat.b.f2655h && cVar != com.facebook.imageformat.b.f2656i) {
            if (cVar == com.facebook.imageformat.b.f2657j) {
                return false;
            }
            throw new IllegalArgumentException("Image format is not a WebP.");
        } else {
            return com.facebook.common.c.c.b;
        }
    }

    @Override // com.facebook.imagepipeline.nativecode.f
    public void c(InputStream inputStream, OutputStream outputStream, int i2) throws IOException {
        e.a();
        h.g(inputStream);
        h.g(outputStream);
        nativeTranscodeWebpToJpeg(inputStream, outputStream, i2);
    }
}

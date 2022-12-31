package com.facebook.imageformat;

import com.facebook.common.internal.h;
import com.facebook.common.internal.m;
import com.facebook.imageformat.c;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.annotation.Nullable;
/* loaded from: classes.dex */
public class ImageFormatChecker {

    /* renamed from: d  reason: collision with root package name */
    private static ImageFormatChecker f2641d;
    private int a;
    @Nullable
    private List<c.a> b;
    private final a c = new a();

    private ImageFormatChecker() {
        e();
    }

    public static c b(InputStream inputStream) throws IOException {
        return getInstance().a(inputStream);
    }

    public static c c(InputStream inputStream) {
        try {
            return b(inputStream);
        } catch (IOException e2) {
            m.a(e2);
            throw null;
        }
    }

    private static int d(int i2, InputStream inputStream, byte[] bArr) throws IOException {
        h.g(inputStream);
        h.g(bArr);
        h.b(Boolean.valueOf(bArr.length >= i2));
        if (inputStream.markSupported()) {
            try {
                inputStream.mark(i2);
                return com.facebook.common.internal.a.b(inputStream, bArr, 0, i2);
            } finally {
                inputStream.reset();
            }
        }
        return com.facebook.common.internal.a.b(inputStream, bArr, 0, i2);
    }

    private void e() {
        this.a = this.c.b();
        List<c.a> list = this.b;
        if (list != null) {
            for (c.a aVar : list) {
                this.a = Math.max(this.a, aVar.b());
            }
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (f2641d == null) {
                f2641d = new ImageFormatChecker();
            }
            imageFormatChecker = f2641d;
        }
        return imageFormatChecker;
    }

    public c a(InputStream inputStream) throws IOException {
        h.g(inputStream);
        int i2 = this.a;
        byte[] bArr = new byte[i2];
        int d2 = d(i2, inputStream, bArr);
        c a = this.c.a(bArr, d2);
        if (a == null || a == c.b) {
            List<c.a> list = this.b;
            if (list != null) {
                for (c.a aVar : list) {
                    c a2 = aVar.a(bArr, d2);
                    if (a2 != null && a2 != c.b) {
                        return a2;
                    }
                }
            }
            return c.b;
        }
        return a;
    }
}

package com.bumptech.glide.load.h.f;

import com.bumptech.glide.load.engine.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: FileToStreamDecoder.java */
/* loaded from: classes.dex */
public class c<T> implements com.bumptech.glide.load.d<File, T> {
    private static final a c = new a();
    private com.bumptech.glide.load.d<InputStream, T> a;
    private final a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FileToStreamDecoder.java */
    /* loaded from: classes.dex */
    public static class a {
        a() {
        }

        public InputStream a(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public c(com.bumptech.glide.load.d<InputStream, T> dVar) {
        this(dVar, c);
    }

    @Override // com.bumptech.glide.load.d
    /* renamed from: b */
    public i<T> a(File file, int i2, int i3) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.b.a(file);
            i<T> a2 = this.a.a(inputStream, i2, i3);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.d
    public String getId() {
        return "";
    }

    c(com.bumptech.glide.load.d<InputStream, T> dVar, a aVar) {
        this.a = dVar;
        this.b = aVar;
    }
}

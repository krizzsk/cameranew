package com.bumptech.glide.load.h.f;

import com.bumptech.glide.load.e;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.model.n;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: StreamFileDataLoadProvider.java */
/* loaded from: classes.dex */
public class d implements com.bumptech.glide.j.b<InputStream, File> {
    private static final b c = new b();
    private final com.bumptech.glide.load.d<File, File> a = new com.bumptech.glide.load.h.f.a();
    private final com.bumptech.glide.load.a<InputStream> b = new n();

    /* compiled from: StreamFileDataLoadProvider.java */
    /* loaded from: classes.dex */
    private static class b implements com.bumptech.glide.load.d<InputStream, File> {
        private b() {
        }

        @Override // com.bumptech.glide.load.d
        public /* bridge */ /* synthetic */ i<File> a(InputStream inputStream, int i2, int i3) throws IOException {
            b(inputStream, i2, i3);
            throw null;
        }

        public i<File> b(InputStream inputStream, int i2, int i3) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        @Override // com.bumptech.glide.load.d
        public String getId() {
            return "";
        }
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.a<InputStream> b() {
        return this.b;
    }

    @Override // com.bumptech.glide.j.b
    public e<File> d() {
        return com.bumptech.glide.load.h.b.c();
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<InputStream, File> e() {
        return c;
    }

    @Override // com.bumptech.glide.j.b
    public com.bumptech.glide.load.d<File, File> f() {
        return this.a;
    }
}

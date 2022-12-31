package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
/* compiled from: ImageVideoWrapperEncoder.java */
/* loaded from: classes.dex */
public class g implements com.bumptech.glide.load.a<f> {
    private final com.bumptech.glide.load.a<InputStream> a;
    private final com.bumptech.glide.load.a<ParcelFileDescriptor> b;
    private String c;

    public g(com.bumptech.glide.load.a<InputStream> aVar, com.bumptech.glide.load.a<ParcelFileDescriptor> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.bumptech.glide.load.a
    /* renamed from: b */
    public boolean a(f fVar, OutputStream outputStream) {
        if (fVar.b() != null) {
            return this.a.a(fVar.b(), outputStream);
        }
        return this.b.a(fVar.a(), outputStream);
    }

    @Override // com.bumptech.glide.load.a
    public String getId() {
        if (this.c == null) {
            this.c = this.a.getId() + this.b.getId();
        }
        return this.c;
    }
}

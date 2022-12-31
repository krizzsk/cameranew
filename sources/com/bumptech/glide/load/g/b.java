package com.bumptech.glide.load.g;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
/* compiled from: ByteArrayFetcher.java */
/* loaded from: classes.dex */
public class b implements c<InputStream> {
    private final byte[] a;
    private final String b;

    public b(byte[] bArr, String str) {
        this.a = bArr;
        this.b = str;
    }

    @Override // com.bumptech.glide.load.g.c
    public void a() {
    }

    @Override // com.bumptech.glide.load.g.c
    /* renamed from: c */
    public InputStream b(Priority priority) {
        return new ByteArrayInputStream(this.a);
    }

    @Override // com.bumptech.glide.load.g.c
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.g.c
    public String getId() {
        return this.b;
    }
}

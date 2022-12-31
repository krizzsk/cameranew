package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
/* compiled from: ImageVideoWrapper.java */
/* loaded from: classes.dex */
public class f {
    private final InputStream a;
    private final ParcelFileDescriptor b;

    public f(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.a = inputStream;
        this.b = parcelFileDescriptor;
    }

    public ParcelFileDescriptor a() {
        return this.b;
    }

    public InputStream b() {
        return this.a;
    }
}

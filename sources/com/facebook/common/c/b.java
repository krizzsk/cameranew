package com.facebook.common.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.io.FileDescriptor;
import javax.annotation.Nullable;
/* compiled from: WebpBitmapFactory.java */
/* loaded from: classes.dex */
public interface b {

    /* compiled from: WebpBitmapFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, @Nullable String str2);
    }

    void a(com.facebook.common.c.a aVar);

    void b(a aVar);

    @Nullable
    Bitmap c(FileDescriptor fileDescriptor, @Nullable Rect rect, @Nullable BitmapFactory.Options options);
}

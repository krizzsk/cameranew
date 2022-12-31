package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public final class s extends ContentHandler {
    public static final s a = new s();

    private s() {
    }

    @Nullable
    private static Bitmap a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            return t.a.b(inputStream);
        } finally {
            inputStream.close();
        }
    }

    @Override // java.net.ContentHandler
    @Nullable
    public final /* synthetic */ Object getContent(URLConnection uRLConnection) {
        return a(uRLConnection);
    }

    @Nullable
    public static Bitmap a(InputStream inputStream) {
        try {
            return t.a.b(inputStream);
        } finally {
            inputStream.close();
        }
    }
}

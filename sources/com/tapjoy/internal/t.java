package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;
/* loaded from: classes3.dex */
public final class t implements bd {
    public static final t a = new t();

    private t() {
    }

    @Override // com.tapjoy.internal.bf
    public final /* synthetic */ void a(OutputStream outputStream, Object obj) {
        if (!((Bitmap) obj).compress(Bitmap.CompressFormat.PNG, 100, outputStream)) {
            throw new RuntimeException();
        }
    }

    @Override // com.tapjoy.internal.be
    /* renamed from: a */
    public final Bitmap b(final InputStream inputStream) {
        try {
            return (Bitmap) y.a(new bb() { // from class: com.tapjoy.internal.t.1
                @Override // com.tapjoy.internal.bb, java.util.concurrent.Callable
                public final /* synthetic */ Object call() {
                    InputStream inputStream2 = inputStream;
                    if (inputStream2 instanceof bc) {
                        return BitmapFactory.decodeStream(inputStream2);
                    }
                    return BitmapFactory.decodeStream(new bc(inputStream));
                }
            });
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}

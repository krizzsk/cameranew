package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.ic;
import javax.annotation.Nonnull;
/* loaded from: classes3.dex */
final class ih implements ic.a {
    @Override // com.tapjoy.internal.ic.a
    @Nonnull
    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @Override // com.tapjoy.internal.ic.a
    public final int[] b(int i2) {
        return new int[i2];
    }

    @Override // com.tapjoy.internal.ic.a
    public final byte[] a(int i2) {
        return new byte[i2];
    }
}

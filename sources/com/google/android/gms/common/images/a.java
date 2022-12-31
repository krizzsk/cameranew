package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.base.zak;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public abstract class a {
    protected int a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.b.c(bitmap);
        c(new BitmapDrawable(context.getResources(), bitmap), z, false, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(Context context, zak zakVar, boolean z) {
        int i2 = this.a;
        c(i2 != 0 ? context.getResources().getDrawable(i2) : null, z, false, false);
    }

    protected abstract void c(Drawable drawable, boolean z, boolean z2, boolean z3);
}

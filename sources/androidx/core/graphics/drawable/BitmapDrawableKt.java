package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.s;
/* compiled from: BitmapDrawable.kt */
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap bitmap, Resources resources) {
        s.h(bitmap, "<this>");
        s.h(resources, "resources");
        return new BitmapDrawable(resources, bitmap);
    }
}

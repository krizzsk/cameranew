package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import kotlin.jvm.internal.s;
/* compiled from: Drawable.kt */
/* loaded from: classes.dex */
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i2, @Px int i3, Bitmap.Config config) {
        s.h(drawable, "<this>");
        if ((drawable instanceof BitmapDrawable) && (config == null || ((BitmapDrawable) drawable).getBitmap().getConfig() == config)) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (i2 == bitmapDrawable.getBitmap().getWidth() && i3 == bitmapDrawable.getBitmap().getHeight()) {
                Bitmap bitmap = bitmapDrawable.getBitmap();
                s.g(bitmap, "bitmap");
                return bitmap;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i2, i3, true);
            s.g(createScaledBitmap, "createScaledBitmap(bitmap, width, height, true)");
            return createScaledBitmap;
        }
        Rect bounds = drawable.getBounds();
        s.g(bounds, "bounds");
        int i4 = bounds.left;
        int i5 = bounds.top;
        int i6 = bounds.right;
        int i7 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap2 = Bitmap.createBitmap(i2, i3, config);
        drawable.setBounds(0, 0, i2, i3);
        drawable.draw(new Canvas(bitmap2));
        drawable.setBounds(i4, i5, i6, i7);
        s.g(bitmap2, "bitmap");
        return bitmap2;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i2, int i3, Bitmap.Config config, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = drawable.getIntrinsicWidth();
        }
        if ((i4 & 2) != 0) {
            i3 = drawable.getIntrinsicHeight();
        }
        if ((i4 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i2, i3, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        s.h(drawable, "<this>");
        drawable.setBounds(i2, i3, i4, i5);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = drawable.getBounds().left;
        }
        if ((i6 & 2) != 0) {
            i3 = drawable.getBounds().top;
        }
        if ((i6 & 4) != 0) {
            i4 = drawable.getBounds().right;
        }
        if ((i6 & 8) != 0) {
            i5 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i2, i3, i4, i5);
    }
}

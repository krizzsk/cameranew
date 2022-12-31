package us.pinguo.common.filter.util;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
/* compiled from: TintUtils.kt */
/* loaded from: classes4.dex */
public final class b {
    public static final b a = new b();

    private b() {
    }

    public final void a(ImageView imageView, int i2) {
        Drawable drawable = imageView == null ? null : imageView.getDrawable();
        if (drawable == null) {
            return;
        }
        if (i2 != 0) {
            int color = imageView.getResources().getColor(i2);
            drawable.setTintList(null);
            drawable.setTint(color);
            return;
        }
        drawable.setTintList(null);
    }
}

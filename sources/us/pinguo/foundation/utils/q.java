package us.pinguo.foundation.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
/* compiled from: ImageColorUtil.kt */
/* loaded from: classes4.dex */
public final class q {
    public static final q a = new q();

    private q() {
    }

    public final void a(Context context, int i2, int i3, AppCompatImageView imageView) {
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(imageView, "imageView");
        Drawable drawable = ContextCompat.getDrawable(context, i3);
        if (drawable == null) {
            return;
        }
        Drawable mutate = DrawableCompat.wrap(drawable).mutate();
        kotlin.jvm.internal.s.g(mutate, "wrap(drawable).mutate()");
        DrawableCompat.setTint(mutate, ContextCompat.getColor(context, i2));
        imageView.setImageDrawable(mutate);
    }
}

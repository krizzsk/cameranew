package pl.droidsonroids.gif;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RawRes;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GifViewUtils.java */
/* loaded from: classes3.dex */
public final class e {
    static final List<String> a = Arrays.asList("raw", "drawable", "mipmap");

    /* compiled from: GifViewUtils.java */
    /* loaded from: classes3.dex */
    static class a {
        final int a;
        final int b;
        final boolean c;

        a(int i2, int i3, boolean z) {
            this.a = i2;
            this.b = i3;
            this.c = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float a(@NonNull Resources resources, @DrawableRes @RawRes int i2) {
        TypedValue typedValue = new TypedValue();
        resources.getValue(i2, typedValue, true);
        int i3 = typedValue.density;
        if (i3 == 0) {
            i3 = 160;
        } else if (i3 == 65535) {
            i3 = 0;
        }
        int i4 = resources.getDisplayMetrics().densityDpi;
        if (i3 <= 0 || i4 <= 0) {
            return 1.0f;
        }
        return i4 / i3;
    }

    private static int b(ImageView imageView, AttributeSet attributeSet, boolean z) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            if (a.contains(imageView.getResources().getResourceTypeName(attributeResourceValue)) && !f(imageView, z, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(ImageView imageView, AttributeSet attributeSet, int i2, int i3) {
        if (attributeSet != null && !imageView.isInEditMode()) {
            return new a(b(imageView, attributeSet, true), b(imageView, attributeSet, false), d(imageView, attributeSet, i2, i3));
        }
        return new a(0, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(View view, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.GifView, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.GifView_freezesAnimation, false);
        obtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(ImageView imageView, Uri uri) {
        if (uri != null) {
            try {
                imageView.setImageDrawable(new c(imageView.getContext().getContentResolver(), uri));
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(ImageView imageView, boolean z, int i2) {
        Resources resources = imageView.getResources();
        if (resources != null) {
            try {
                c cVar = new c(resources, i2);
                if (z) {
                    imageView.setImageDrawable(cVar);
                    return true;
                } else if (Build.VERSION.SDK_INT >= 16) {
                    imageView.setBackground(cVar);
                    return true;
                } else {
                    imageView.setBackgroundDrawable(cVar);
                    return true;
                }
            } catch (Resources.NotFoundException | IOException unused) {
                return false;
            }
        }
        return false;
    }
}

package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import androidx.core.graphics.drawable.DrawableCompat;
import com.google.android.gms.base.R;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public final class SignInButtonImpl extends Button {
    public SignInButtonImpl(Context context) {
        this(context, null);
    }

    private static int b(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    return i5;
                }
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown color scheme: ");
                sb.append(i2);
                throw new IllegalStateException(sb.toString());
            }
            return i4;
        }
        return i3;
    }

    public final void a(Resources resources, int i2, int i3) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i4 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i4);
        setMinWidth(i4);
        int i5 = R.drawable.common_google_signin_btn_icon_dark;
        int i6 = R.drawable.common_google_signin_btn_icon_light;
        int b = b(i3, i5, i6, i6);
        int i7 = R.drawable.common_google_signin_btn_text_dark;
        int i8 = R.drawable.common_google_signin_btn_text_light;
        int b2 = b(i3, i7, i8, i8);
        if (i2 == 0 || i2 == 1) {
            b = b2;
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i2);
            throw new IllegalStateException(sb.toString());
        }
        Drawable wrap = DrawableCompat.wrap(resources.getDrawable(b));
        DrawableCompat.setTintList(wrap, resources.getColorStateList(R.color.common_google_signin_btn_tint));
        DrawableCompat.setTintMode(wrap, PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(wrap);
        int i9 = R.color.common_google_signin_btn_text_dark;
        int i10 = R.color.common_google_signin_btn_text_light;
        ColorStateList colorStateList = resources.getColorStateList(b(i3, i9, i10, i10));
        q.j(colorStateList);
        setTextColor(colorStateList);
        if (i2 == 0) {
            setText(resources.getString(R.string.common_signin_button_text));
        } else if (i2 == 1) {
            setText(resources.getString(R.string.common_signin_button_text_long));
        } else if (i2 == 2) {
            setText((CharSequence) null);
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i2);
            throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod(null);
        if (com.google.android.gms.common.util.i.d(getContext())) {
            setGravity(19);
        }
    }

    public SignInButtonImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }
}

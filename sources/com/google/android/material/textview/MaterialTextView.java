package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleableRes;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R;
import com.google.android.material.f.b;
import com.google.android.material.f.c;
import com.google.android.material.theme.a.a;
/* loaded from: classes2.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(@NonNull Context context) {
        this(context, null);
    }

    private void b(@NonNull Resources.Theme theme, int i2) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
        int e2 = e(getContext(), obtainStyledAttributes, R.styleable.MaterialTextAppearance_android_lineHeight, R.styleable.MaterialTextAppearance_lineHeight);
        obtainStyledAttributes.recycle();
        if (e2 >= 0) {
            setLineHeight(e2);
        }
    }

    private static boolean c(Context context) {
        return b.b(context, R.attr.textAppearanceLineHeightEnabled, true);
    }

    private static int d(@NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialTextView_android_textAppearance, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int e(@NonNull Context context, @NonNull TypedArray typedArray, @NonNull @StyleableRes int... iArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < iArr.length && i2 < 0; i3++) {
            i2 = c.c(context, typedArray, iArr[i3], -1);
        }
        return i2;
    }

    private static boolean f(@NonNull Context context, @NonNull Resources.Theme theme, @Nullable AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.MaterialTextView, i2, i3);
        int e2 = e(context, obtainStyledAttributes, R.styleable.MaterialTextView_android_lineHeight, R.styleable.MaterialTextView_lineHeight);
        obtainStyledAttributes.recycle();
        return e2 != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(@NonNull Context context, int i2) {
        super.setTextAppearance(context, i2);
        if (c(context)) {
            b(context.getTheme(), i2);
        }
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public MaterialTextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(a.c(context, attributeSet, i2, i3), attributeSet, i2);
        int d2;
        Context context2 = getContext();
        if (c(context2)) {
            Resources.Theme theme = context2.getTheme();
            if (f(context2, theme, attributeSet, i2, i3) || (d2 = d(theme, attributeSet, i2, i3)) == -1) {
                return;
            }
            b(theme, d2);
        }
    }
}

package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.Toolbar;
/* compiled from: ToolbarUtils.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes2.dex */
public class l {
    @Nullable
    public static TextView a(@NonNull Toolbar toolbar) {
        return b(toolbar, toolbar.getSubtitle());
    }

    @Nullable
    private static TextView b(@NonNull Toolbar toolbar, CharSequence charSequence) {
        for (int i2 = 0; i2 < toolbar.getChildCount(); i2++) {
            View childAt = toolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    @Nullable
    public static TextView c(@NonNull Toolbar toolbar) {
        return b(toolbar, toolbar.getTitle());
    }
}

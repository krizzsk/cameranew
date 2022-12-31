package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
/* compiled from: BadgeUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static final boolean a;

    static {
        a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        e(badgeDrawable, view, frameLayout);
        if (badgeDrawable.g() != null) {
            badgeDrawable.g().setForeground(badgeDrawable);
        } else if (!a) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    @NonNull
    public static SparseArray<BadgeDrawable> b(Context context, @NonNull ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i2 = 0; i2 < parcelableSparseArray.size(); i2++) {
            int keyAt = parcelableSparseArray.keyAt(i2);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i2);
            if (savedState != null) {
                sparseArray.put(keyAt, BadgeDrawable.c(context, savedState));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    @NonNull
    public static ParcelableSparseArray c(@NonNull SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            BadgeDrawable valueAt = sparseArray.valueAt(i2);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.k());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static void d(@Nullable BadgeDrawable badgeDrawable, @NonNull View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (!a && badgeDrawable.g() == null) {
            view.getOverlay().remove(badgeDrawable);
        } else {
            badgeDrawable.g().setForeground(null);
        }
    }

    public static void e(@NonNull BadgeDrawable badgeDrawable, @NonNull View view, @Nullable FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.B(view, frameLayout);
    }

    public static void f(@NonNull Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int) (f2 - f4), (int) (f3 - f5), (int) (f2 + f4), (int) (f3 + f5));
    }
}

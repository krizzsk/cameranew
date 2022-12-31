package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
/* loaded from: classes2.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] z = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    @Nullable
    private final AccessibilityManager x;
    private boolean y;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.SnackbarBaseLayout {
        public SnackbarLayout(Context context) {
            super(context);
        }

        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(@Nullable Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(@Nullable Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.SnackbarBaseLayout, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    private Snackbar(@NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull View view, @NonNull a aVar) {
        super(context, viewGroup, view, aVar);
        this.x = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    @Nullable
    private static ViewGroup U(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private static boolean V(@NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(z);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    @NonNull
    public static Snackbar W(@NonNull View view, @NonNull CharSequence charSequence, int i2) {
        return X(null, view, charSequence, i2);
    }

    @NonNull
    private static Snackbar X(@Nullable Context context, @NonNull View view, @NonNull CharSequence charSequence, int i2) {
        ViewGroup U = U(view);
        if (U != null) {
            if (context == null) {
                context = U.getContext();
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(V(context) ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, U, false);
            Snackbar snackbar = new Snackbar(context, U, snackbarContentLayout, snackbarContentLayout);
            snackbar.Y(charSequence);
            snackbar.I(i2);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void M() {
        super.M();
    }

    @NonNull
    public Snackbar Y(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.c.getChildAt(0)).c().setText(charSequence);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void s() {
        super.s();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int v() {
        int v = super.v();
        if (v == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.x.getRecommendedTimeoutMillis(v, (this.y ? 4 : 0) | 1 | 2);
        } else if (this.y && this.x.isTouchExplorationEnabled()) {
            return -2;
        } else {
            return v;
        }
    }
}

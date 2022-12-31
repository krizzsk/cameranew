package us.pinguo.ui.widget.snack;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.SnackbarContentLayout;
import us.pinguo.ui.R;
import us.pinguo.ui.widget.snack.BaseTransientTopBar;
/* loaded from: classes6.dex */
public final class SnackTop extends BaseTransientTopBar<SnackTop> {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes6.dex */
    public static final class SnackbarLayout extends BaseTransientTopBar.SnackbarBaseLayout {
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

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    private SnackTop(ViewGroup viewGroup, View view, int i2, com.google.android.material.snackbar.a aVar) {
        super(viewGroup, view, i2, aVar);
    }

    private static ViewGroup o(View view) {
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

    @NonNull
    public static SnackTop p(@NonNull View view, @NonNull CharSequence charSequence, int i2, int i3) {
        ViewGroup o = o(view);
        if (o != null) {
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(o.getContext()).inflate(R.layout.snacktop_layout, o, false);
            SnackTop snackTop = new SnackTop(o, snackbarContentLayout, i3, snackbarContentLayout);
            snackTop.q(charSequence);
            snackTop.k(i2);
            return snackTop;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @NonNull
    public SnackTop q(@NonNull CharSequence charSequence) {
        ((SnackbarContentLayout) this.c.getChildAt(0)).c().setText(charSequence);
        return this;
    }
}

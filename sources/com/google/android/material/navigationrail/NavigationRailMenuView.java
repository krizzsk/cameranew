package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private final FrameLayout.LayoutParams v;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.v = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int u(int i2, int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), i3 / Math.max(1, i4)), 0);
    }

    private int v(View view, int i2, int i3) {
        if (view.getVisibility() != 8) {
            view.measure(i2, i3);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int w(int i2, int i3, int i4, View view) {
        int makeMeasureSpec;
        u(i2, i3, i4);
        if (view == null) {
            makeMeasureSpec = u(i2, i3, i4);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                i5 += v(childAt, i2, makeMeasureSpec);
            }
        }
        return i5;
    }

    private int x(int i2, int i3, int i4) {
        int i5;
        View childAt = getChildAt(l());
        if (childAt != null) {
            i5 = v(childAt, i2, u(i2, i3, i4));
            i3 -= i5;
            i4--;
        } else {
            i5 = 0;
        }
        return i5 + w(i2, i3, i4, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView e(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i6, measuredHeight);
                i7 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int w;
        int size = View.MeasureSpec.getSize(i3);
        int size2 = i().getVisibleItems().size();
        if (size2 > 1 && m(h(), size2)) {
            w = x(i2, size, size2);
        } else {
            w = w(i2, size, size2, null);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i2), i2, 0), View.resolveSizeAndState(w, i3, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return (this.v.gravity & 112) == 48;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i2) {
        FrameLayout.LayoutParams layoutParams = this.v;
        if (layoutParams.gravity != i2) {
            layoutParams.gravity = i2;
            setLayoutParams(layoutParams);
        }
    }
}

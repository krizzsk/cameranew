package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private boolean A;
    private int[] B;
    private final int v;
    private final int w;
    private final int x;
    private final int y;
    private final int z;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.v = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.w = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.x = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.y = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.z = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.B = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView e(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        MenuBuilder i4 = i();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = i4.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.z, 1073741824);
        if (m(h(), size2) && t()) {
            View childAt = getChildAt(l());
            int i5 = this.y;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.x, Integer.MIN_VALUE), makeMeasureSpec);
                i5 = Math.max(i5, childAt.getMeasuredWidth());
            }
            int i6 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.w * i6), Math.min(i5, this.x));
            int i7 = size - min;
            int min2 = Math.min(i7 / (i6 == 0 ? 1 : i6), this.v);
            int i8 = i7 - (i6 * min2);
            int i9 = 0;
            while (i9 < childCount) {
                if (getChildAt(i9).getVisibility() != 8) {
                    this.B[i9] = i9 == l() ? min : min2;
                    if (i8 > 0) {
                        int[] iArr = this.B;
                        iArr[i9] = iArr[i9] + 1;
                        i8--;
                    }
                } else {
                    this.B[i9] = 0;
                }
                i9++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.x);
            int i10 = size - (size2 * min3);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (getChildAt(i11).getVisibility() != 8) {
                    int[] iArr2 = this.B;
                    iArr2[i11] = min3;
                    if (i10 > 0) {
                        iArr2[i11] = iArr2[i11] + 1;
                        i10--;
                    }
                } else {
                    this.B[i11] = 0;
                }
            }
        }
        int i12 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = getChildAt(i13);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.B[i13], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i12 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i12, View.MeasureSpec.makeMeasureSpec(i12, 1073741824), 0), View.resolveSizeAndState(this.z, makeMeasureSpec, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.A = z;
    }

    public boolean t() {
        return this.A;
    }
}

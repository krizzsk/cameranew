package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.shape.h;
/* loaded from: classes2.dex */
public class BottomNavigationView extends NavigationBarView {

    @Deprecated
    /* loaded from: classes2.dex */
    public interface a extends NavigationBarView.c {
    }

    @Deprecated
    /* loaded from: classes2.dex */
    public interface b extends NavigationBarView.d {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, null);
    }

    private void l(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, R.color.design_bottom_navigation_shadow_color));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
        addView(view);
    }

    private boolean m() {
        return Build.VERSION.SDK_INT < 21 && !(getBackground() instanceof h);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected NavigationBarMenuView e(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int f() {
        return 5;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) h();
        if (bottomNavigationMenuView.t() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            i().updateMenuView(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable a aVar) {
        setOnItemReselectedListener(aVar);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable b bVar) {
        setOnItemSelectedListener(bVar);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomNavigationStyle);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Widget_Design_BottomNavigationView);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Context context2 = getContext();
        TintTypedArray i4 = k.i(context2, attributeSet, R.styleable.BottomNavigationView, i2, i3, new int[0]);
        setItemHorizontalTranslationEnabled(i4.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
        i4.recycle();
        if (m()) {
            l(context2);
        }
    }
}

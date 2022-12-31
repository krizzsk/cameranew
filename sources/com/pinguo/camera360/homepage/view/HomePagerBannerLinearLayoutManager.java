package com.pinguo.camera360.homepage.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.jvm.internal.s;
/* compiled from: HomePagerBannerLinearLayoutManager.kt */
/* loaded from: classes3.dex */
public final class HomePagerBannerLinearLayoutManager extends LinearLayoutManager {
    private final ViewPager2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePagerBannerLinearLayoutManager(Context context, LinearLayoutManager originalLayoutManager, ViewPager2 viewPager) {
        super(context);
        s.h(context, "context");
        s.h(originalLayoutManager, "originalLayoutManager");
        s.h(viewPager, "viewPager");
        this.a = viewPager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(RecyclerView.State state, int[] extraLayoutSpace) {
        s.h(state, "state");
        s.h(extraLayoutSpace, "extraLayoutSpace");
        int offscreenPageLimit = this.a.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.calculateExtraLayoutSpace(state, extraLayoutSpace);
            return;
        }
        Method declaredMethod = this.a.getClass().getDeclaredMethod("getPageSize", new Class[0]);
        declaredMethod.setAccessible(true);
        Object invoke = declaredMethod.invoke(this.a, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) invoke).intValue() * offscreenPageLimit;
        extraLayoutSpace[0] = intValue;
        extraLayoutSpace[1] = intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean z, boolean z2) {
        s.h(parent, "parent");
        s.h(child, "child");
        s.h(rect, "rect");
        return false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        s.h(recyclerView, "recyclerView");
        s.h(state, "state");
        Context context = recyclerView.getContext();
        s.g(context, "recyclerView.context");
        HomePageBannerLinearSmoothScroller homePageBannerLinearSmoothScroller = new HomePageBannerLinearSmoothScroller(context);
        homePageBannerLinearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(homePageBannerLinearSmoothScroller);
    }
}

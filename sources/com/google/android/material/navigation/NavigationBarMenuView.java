package com.google.android.material.navigation;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.i;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.HashSet;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] t = {16842912};
    private static final int[] u = {-16842910};
    @NonNull
    private final TransitionSet a;
    @NonNull
    private final View.OnClickListener b;
    private final Pools.Pool<NavigationBarItemView> c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f4393d;

    /* renamed from: e  reason: collision with root package name */
    private int f4394e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private NavigationBarItemView[] f4395f;

    /* renamed from: g  reason: collision with root package name */
    private int f4396g;

    /* renamed from: h  reason: collision with root package name */
    private int f4397h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f4398i;
    @Dimension

    /* renamed from: j  reason: collision with root package name */
    private int f4399j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f4400k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private final ColorStateList f4401l;
    @StyleRes
    private int m;
    @StyleRes
    private int n;
    private Drawable o;
    private int p;
    @NonNull
    private SparseArray<BadgeDrawable> q;
    private NavigationBarPresenter r;
    private MenuBuilder s;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            if (NavigationBarMenuView.this.s.performItemAction(itemData, NavigationBarMenuView.this.r, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        this.c = new Pools.SynchronizedPool(5);
        this.f4393d = new SparseArray<>(5);
        this.f4396g = 0;
        this.f4397h = 0;
        this.q = new SparseArray<>(5);
        this.f4401l = d(16842808);
        AutoTransition autoTransition = new AutoTransition();
        this.a = autoTransition;
        autoTransition.setOrdering(0);
        autoTransition.setDuration(115L);
        autoTransition.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        autoTransition.addTransition(new i());
        this.b = new a();
        ViewCompat.setImportantForAccessibility(this, 1);
    }

    private NavigationBarItemView j() {
        NavigationBarItemView acquire = this.c.acquire();
        return acquire == null ? e(getContext()) : acquire;
    }

    private boolean n(int i2) {
        return i2 != -1;
    }

    private void o() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            hashSet.add(Integer.valueOf(this.s.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            int keyAt = this.q.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.q.delete(keyAt);
            }
        }
    }

    private void q(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (n(id) && (badgeDrawable = this.q.get(id)) != null) {
            navigationBarItemView.m(badgeDrawable);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.c.release(navigationBarItemView);
                    navigationBarItemView.l();
                }
            }
        }
        if (this.s.size() == 0) {
            this.f4396g = 0;
            this.f4397h = 0;
            this.f4395f = null;
            return;
        }
        o();
        this.f4395f = new NavigationBarItemView[this.s.size()];
        boolean m = m(this.f4394e, this.s.getVisibleItems().size());
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            this.r.c(true);
            this.s.getItem(i2).setCheckable(true);
            this.r.c(false);
            NavigationBarItemView j2 = j();
            this.f4395f[i2] = j2;
            j2.setIconTintList(this.f4398i);
            j2.setIconSize(this.f4399j);
            j2.setTextColor(this.f4401l);
            j2.setTextAppearanceInactive(this.m);
            j2.setTextAppearanceActive(this.n);
            j2.setTextColor(this.f4400k);
            Drawable drawable = this.o;
            if (drawable != null) {
                j2.setItemBackground(drawable);
            } else {
                j2.setItemBackground(this.p);
            }
            j2.setShifting(m);
            j2.setLabelVisibilityMode(this.f4394e);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.s.getItem(i2);
            j2.initialize(menuItemImpl, 0);
            j2.setItemPosition(i2);
            int itemId = menuItemImpl.getItemId();
            j2.setOnTouchListener(this.f4393d.get(itemId));
            j2.setOnClickListener(this.b);
            int i3 = this.f4396g;
            if (i3 != 0 && itemId == i3) {
                this.f4397h = i2;
            }
            q(j2);
            addView(j2);
        }
        int min = Math.min(this.s.size() - 1, this.f4397h);
        this.f4397h = min;
        this.s.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList d(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                int[] iArr = u;
                return new ColorStateList(new int[][]{iArr, t, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    @NonNull
    protected abstract NavigationBarItemView e(@NonNull Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> f() {
        return this.q;
    }

    @Nullable
    public Drawable g() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null && navigationBarItemViewArr.length > 0) {
            return navigationBarItemViewArr[0].getBackground();
        }
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    public int h() {
        return this.f4394e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public MenuBuilder i() {
        return this.s;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(@NonNull MenuBuilder menuBuilder) {
        this.s = menuBuilder;
    }

    public int k() {
        return this.f4396g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l() {
        return this.f4397h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean m(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.s.getVisibleItems().size(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(SparseArray<BadgeDrawable> sparseArray) {
        this.q = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.m(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i2) {
        int size = this.s.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.s.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f4396g = i2;
                this.f4397h = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void s() {
        MenuBuilder menuBuilder = this.s;
        if (menuBuilder == null || this.f4395f == null) {
            return;
        }
        int size = menuBuilder.size();
        if (size != this.f4395f.length) {
            c();
            return;
        }
        int i2 = this.f4396g;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.s.getItem(i3);
            if (item.isChecked()) {
                this.f4396g = item.getItemId();
                this.f4397h = i3;
            }
        }
        if (i2 != this.f4396g) {
            TransitionManager.beginDelayedTransition(this, this.a);
        }
        boolean m = m(this.f4394e, this.s.getVisibleItems().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.r.c(true);
            this.f4395f[i4].setLabelVisibilityMode(this.f4394e);
            this.f4395f[i4].setShifting(m);
            this.f4395f[i4].initialize((MenuItemImpl) this.s.getItem(i4), 0);
            this.r.c(false);
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f4398i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.o = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.p = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f4399j = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i2);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void setItemOnTouchListener(int i2, @Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.f4393d.remove(i2);
        } else {
            this.f4393d.put(i2, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i2) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.n = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.f4400k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.m = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.f4400k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f4400k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f4395f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f4394e = i2;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.r = navigationBarPresenter;
    }
}

package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.internal.p;
import com.google.android.material.shape.h;
import com.google.android.material.shape.i;
/* loaded from: classes2.dex */
public abstract class NavigationBarView extends FrameLayout {
    @NonNull
    private final com.google.android.material.navigation.a a;
    @NonNull
    private final NavigationBarMenuView b;
    @NonNull
    private final NavigationBarPresenter c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f4403d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f4404e;

    /* renamed from: f  reason: collision with root package name */
    private d f4405f;

    /* renamed from: g  reason: collision with root package name */
    private c f4406g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        Bundle a;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.a);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* loaded from: classes2.dex */
    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            if (NavigationBarView.this.f4406g == null || menuItem.getItemId() != NavigationBarView.this.j()) {
                return (NavigationBarView.this.f4405f == null || NavigationBarView.this.f4405f.a(menuItem)) ? false : true;
            }
            NavigationBarView.this.f4406g.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements p.e {
        b(NavigationBarView navigationBarView) {
        }

        @Override // com.google.android.material.internal.p.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull p.f fVar) {
            fVar.f4383d += windowInsetsCompat.getSystemWindowInsetBottom();
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            fVar.a += z ? systemWindowInsetRight : systemWindowInsetLeft;
            int i2 = fVar.c;
            if (!z) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            fVar.c = i2 + systemWindowInsetLeft;
            fVar.a(view);
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(@NonNull MenuItem menuItem);
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.NavigationBarView;
        int i4 = R.styleable.NavigationBarView_itemTextAppearanceInactive;
        int i5 = R.styleable.NavigationBarView_itemTextAppearanceActive;
        TintTypedArray i6 = k.i(context2, attributeSet, iArr, i2, i3, i4, i5);
        com.google.android.material.navigation.a aVar = new com.google.android.material.navigation.a(context2, getClass(), f());
        this.a = aVar;
        NavigationBarMenuView e2 = e(context2);
        this.b = e2;
        navigationBarPresenter.b(e2);
        navigationBarPresenter.a(1);
        e2.setPresenter(navigationBarPresenter);
        aVar.addMenuPresenter(navigationBarPresenter);
        navigationBarPresenter.initForMenu(getContext(), aVar);
        int i7 = R.styleable.NavigationBarView_itemIconTint;
        if (i6.hasValue(i7)) {
            e2.setIconTintList(i6.getColorStateList(i7));
        } else {
            e2.setIconTintList(e2.d(16842808));
        }
        setItemIconSize(i6.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (i6.hasValue(i4)) {
            setItemTextAppearanceInactive(i6.getResourceId(i4, 0));
        }
        if (i6.hasValue(i5)) {
            setItemTextAppearanceActive(i6.getResourceId(i5, 0));
        }
        int i8 = R.styleable.NavigationBarView_itemTextColor;
        if (i6.hasValue(i8)) {
            setItemTextColor(i6.getColorStateList(i8));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ViewCompat.setBackground(this, d(context2));
        }
        int i9 = R.styleable.NavigationBarView_elevation;
        if (i6.hasValue(i9)) {
            setElevation(i6.getDimensionPixelSize(i9, 0));
        }
        DrawableCompat.setTintList(getBackground().mutate(), com.google.android.material.f.c.b(context2, i6, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(i6.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = i6.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            e2.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(com.google.android.material.f.c.b(context2, i6, R.styleable.NavigationBarView_itemRippleColor));
        }
        int i10 = R.styleable.NavigationBarView_menu;
        if (i6.hasValue(i10)) {
            k(i6.getResourceId(i10, 0));
        }
        i6.recycle();
        addView(e2);
        aVar.setCallback(new a());
        c();
    }

    private void c() {
        p.b(this, new b(this));
    }

    @NonNull
    private h d(Context context) {
        h hVar = new h();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            hVar.W(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        hVar.L(context);
        return hVar;
    }

    private MenuInflater g() {
        if (this.f4404e == null) {
            this.f4404e = new SupportMenuInflater(getContext());
        }
        return this.f4404e;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected abstract NavigationBarMenuView e(@NonNull Context context);

    public abstract int f();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView h() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public NavigationBarPresenter i() {
        return this.c;
    }

    @IdRes
    public int j() {
        return this.b.k();
    }

    public void k(int i2) {
        this.c.c(true);
        g().inflate(i2, this.a);
        this.c.c(false);
        this.c.updateMenuView(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.a.restorePresenterStates(savedState.a);
    }

    @Override // android.view.View
    @NonNull
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.a = bundle;
        this.a.savePresenterStates(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.b.setItemBackground(drawable);
        this.f4403d = null;
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.b.setItemBackgroundRes(i2);
        this.f4403d = null;
    }

    public void setItemIconSize(@Dimension int i2) {
        this.b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.b.setIconTintList(colorStateList);
    }

    public void setItemOnTouchListener(int i2, @Nullable View.OnTouchListener onTouchListener) {
        this.b.setItemOnTouchListener(i2, onTouchListener);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.f4403d == colorStateList) {
            if (colorStateList != null || this.b.g() == null) {
                return;
            }
            this.b.setItemBackground(null);
            return;
        }
        this.f4403d = colorStateList;
        if (colorStateList == null) {
            this.b.setItemBackground(null);
            return;
        }
        ColorStateList a2 = com.google.android.material.g.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.b.setItemBackground(new RippleDrawable(a2, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable wrap = DrawableCompat.wrap(gradientDrawable);
        DrawableCompat.setTintList(wrap, a2);
        this.b.setItemBackground(wrap);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.b.h() != i2) {
            this.b.setLabelVisibilityMode(i2);
            this.c.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable c cVar) {
        this.f4406g = cVar;
    }

    public void setOnItemSelectedListener(@Nullable d dVar) {
        this.f4405f = dVar;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem findItem = this.a.findItem(i2);
        if (findItem == null || this.a.performItemAction(findItem, this.c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}

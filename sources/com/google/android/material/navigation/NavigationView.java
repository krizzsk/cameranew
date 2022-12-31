package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.e;
import com.google.android.material.shape.h;
import com.google.android.material.shape.i;
import com.google.android.material.shape.m;
/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] m = {16842912};
    private static final int[] n = {-16842910};
    private static final int o = R.style.Widget_Design_NavigationView;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final NavigationMenu f4407f;

    /* renamed from: g  reason: collision with root package name */
    private final e f4408g;

    /* renamed from: h  reason: collision with root package name */
    c f4409h;

    /* renamed from: i  reason: collision with root package name */
    private final int f4410i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f4411j;

    /* renamed from: k  reason: collision with root package name */
    private MenuInflater f4412k;

    /* renamed from: l  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f4413l;

    /* loaded from: classes2.dex */
    class a implements MenuBuilder.Callback {
        a() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            c cVar = NavigationView.this.f4409h;
            return cVar != null && cVar.a(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            NavigationView navigationView = NavigationView.this;
            navigationView.getLocationOnScreen(navigationView.f4411j);
            boolean z = true;
            boolean z2 = NavigationView.this.f4411j[1] == 0;
            NavigationView.this.f4408g.e(z2);
            NavigationView.this.setDrawTopInsetForeground(z2);
            Activity a = com.google.android.material.internal.b.a(NavigationView.this.getContext());
            if (a == null || Build.VERSION.SDK_INT < 21) {
                return;
            }
            NavigationView.this.setDrawBottomInsetForeground(((a.findViewById(16908290).getHeight() == NavigationView.this.getHeight()) && (Color.alpha(a.getWindow().getNavigationBarColor()) != 0)) ? false : false);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        boolean a(@NonNull MenuItem menuItem);
    }

    public NavigationView(@NonNull Context context) {
        this(context, null);
    }

    @Nullable
    private ColorStateList d(int i2) {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
                int i3 = typedValue.data;
                int defaultColor = colorStateList.getDefaultColor();
                int[] iArr = n;
                return new ColorStateList(new int[][]{iArr, m, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(iArr, defaultColor), i3, defaultColor});
            }
            return null;
        }
        return null;
    }

    @NonNull
    private final Drawable e(@NonNull TintTypedArray tintTypedArray) {
        h hVar = new h(m.b(getContext(), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).m());
        hVar.W(com.google.android.material.f.c.b(getContext(), tintTypedArray, R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) hVar, tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater f() {
        if (this.f4412k == null) {
            this.f4412k = new SupportMenuInflater(getContext());
        }
        return this.f4412k;
    }

    private boolean g(@NonNull TintTypedArray tintTypedArray) {
        return tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearance) || tintTypedArray.hasValue(R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void j() {
        this.f4413l = new b();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f4413l);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected void a(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.f4408g.c(windowInsetsCompat);
    }

    public View h(@LayoutRes int i2) {
        return this.f4408g.d(i2);
    }

    public void i(int i2) {
        this.f4408g.q(true);
        f().inflate(i2, this.f4407f);
        this.f4408g.q(false);
        this.f4408g.updateMenuView(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f4413l);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f4413l);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), this.f4410i), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f4410i, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f4407f.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f4407f.savePresenterStates(bundle);
        return savedState;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem findItem = this.f4407f.findItem(i2);
        if (findItem != null) {
            this.f4408g.f((MenuItemImpl) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.d(this, f2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f4408g.h(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        this.f4408g.i(i2);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.f4408g.i(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        this.f4408g.j(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f4408g.j(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f4408g.k(i2);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f4408g.l(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.f4408g.m(i2);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.f4408g.n(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f4408g.o(colorStateList);
    }

    public void setNavigationItemSelectedListener(@Nullable c cVar) {
        this.f4409h = cVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        e eVar = this.f4408g;
        if (eVar != null) {
            eVar.p(i2);
        }
    }

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        @Nullable
        public Bundle menuState;

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

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.f4407f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f4408g.f((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}

package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.growingio.android.sdk.autoburry.VdsAgent;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] q = {16842912};

    /* renamed from: g  reason: collision with root package name */
    private int f4340g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4341h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4342i;

    /* renamed from: j  reason: collision with root package name */
    private final CheckedTextView f4343j;

    /* renamed from: k  reason: collision with root package name */
    private FrameLayout f4344k;

    /* renamed from: l  reason: collision with root package name */
    private MenuItemImpl f4345l;
    private ColorStateList m;
    private boolean n;
    private Drawable o;
    private final AccessibilityDelegateCompat p;

    /* loaded from: classes2.dex */
    class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCheckable(NavigationMenuItemView.this.f4342i);
        }
    }

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, null);
    }

    private void a() {
        if (f()) {
            this.f4343j.setVisibility(8);
            FrameLayout frameLayout = this.f4344k;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.f4344k.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.f4343j.setVisibility(0);
        FrameLayout frameLayout2 = this.f4344k;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.f4344k.setLayoutParams(layoutParams2);
        }
    }

    @Nullable
    private StateListDrawable b() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(R.attr.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(q, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private void d(@Nullable View view) {
        if (view != null) {
            if (this.f4344k == null) {
                this.f4344k = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f4344k.removeAllViews();
            this.f4344k.addView(view);
        }
    }

    private boolean f() {
        return this.f4345l.getTitle() == null && this.f4345l.getIcon() == null && this.f4345l.getActionView() != null;
    }

    public void c() {
        FrameLayout frameLayout = this.f4344k;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f4343j.setCompoundDrawables(null, null, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(ColorStateList colorStateList) {
        this.m = colorStateList;
        this.n = colorStateList != null;
        MenuItemImpl menuItemImpl = this.f4345l;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.f4345l;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.f4345l = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        int i3 = menuItemImpl.isVisible() ? 0 : 8;
        setVisibility(i3);
        VdsAgent.onSetViewVisibility(this, i3);
        if (getBackground() == null) {
            ViewCompat.setBackground(this, b());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        d(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.setTooltipText(this, menuItemImpl.getTooltipText());
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.f4345l;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f4345l.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, q);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f4342i != z) {
            this.f4342i = z;
            this.p.sendAccessibilityEvent(this.f4343j, 2048);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f4343j.setChecked(z);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.n) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.wrap(drawable).mutate();
                DrawableCompat.setTintList(drawable, this.m);
            }
            int i2 = this.f4340g;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f4341h) {
            if (this.o == null) {
                Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), com.google.android.material.R.drawable.navigation_empty_icon, getContext().getTheme());
                this.o = drawable2;
                if (drawable2 != null) {
                    int i3 = this.f4340g;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.o;
        }
        TextViewCompat.setCompoundDrawablesRelative(this.f4343j, drawable, null, null, null);
    }

    public void setIconPadding(int i2) {
        this.f4343j.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(@Dimension int i2) {
        this.f4340g = i2;
    }

    public void setMaxLines(int i2) {
        this.f4343j.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f4341h = z;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i2) {
        TextViewCompat.setTextAppearance(this.f4343j, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f4343j.setTextColor(colorStateList);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.f4343j.setText(charSequence);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a aVar = new a();
        this.p = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.design_menu_item_text);
        this.f4343j = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(checkedTextView, aVar);
    }
}

package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.growingio.android.sdk.autoburry.VdsAgent;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int[] p = {16842912};
    private final int a;
    private float b;
    private float c;

    /* renamed from: d  reason: collision with root package name */
    private float f4384d;

    /* renamed from: e  reason: collision with root package name */
    private int f4385e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4386f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f4387g;

    /* renamed from: h  reason: collision with root package name */
    private final ViewGroup f4388h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f4389i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f4390j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private MenuItemImpl f4391k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f4392l;
    @Nullable
    private Drawable m;
    @Nullable
    private Drawable n;
    @Nullable
    private BadgeDrawable o;

    /* loaded from: classes2.dex */
    class a implements View.OnLayoutChangeListener {
        a() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            if (NavigationBarItemView.this.f4387g.getVisibility() == 0) {
                NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                navigationBarItemView.r(navigationBarItemView.f4387g);
            }
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(g(), (ViewGroup) this, true);
        this.f4387g = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f4388h = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f4389i = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f4390j = textView2;
        setBackgroundResource(e());
        this.a = getResources().getDimensionPixelSize(f());
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ViewCompat.setImportantForAccessibility(textView, 2);
        ViewCompat.setImportantForAccessibility(textView2, 2);
        setFocusable(true);
        c(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f4387g;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new a());
        }
    }

    private void c(float f2, float f3) {
        this.b = f2 - f3;
        this.c = (f3 * 1.0f) / f2;
        this.f4384d = (f2 * 1.0f) / f3;
    }

    @Nullable
    private FrameLayout d(View view) {
        ImageView imageView = this.f4387g;
        if (view == imageView && com.google.android.material.badge.a.a) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private int h() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < indexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int i() {
        BadgeDrawable badgeDrawable = this.o;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.f4387g.getLayoutParams()).topMargin) + this.f4387g.getMeasuredWidth() + minimumHeight;
    }

    private int j() {
        BadgeDrawable badgeDrawable = this.o;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.o.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4387g.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f4387g.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean k() {
        return this.o != null;
    }

    private static void n(@NonNull View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private static void o(@NonNull View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
        VdsAgent.onSetViewVisibility(view, i2);
    }

    private void p(@Nullable View view) {
        if (k() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            com.google.android.material.badge.a.a(this.o, view, d(view));
        }
    }

    private void q(@Nullable View view) {
        if (k()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                com.google.android.material.badge.a.d(this.o, view);
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        if (k()) {
            com.google.android.material.badge.a.e(this.o, view, d(view));
        }
    }

    private static void s(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    @DrawableRes
    protected int e() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    @DimenRes
    protected int f() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    protected abstract int g();

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.f4391k;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4388h.getLayoutParams();
        return i() + layoutParams.topMargin + this.f4388h.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4388h.getLayoutParams();
        return Math.max(j(), layoutParams.leftMargin + this.f4388h.getMeasuredWidth() + layoutParams.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(@NonNull MenuItemImpl menuItemImpl, int i2) {
        CharSequence title;
        this.f4391k = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        if (!TextUtils.isEmpty(menuItemImpl.getTooltipText())) {
            title = menuItemImpl.getTooltipText();
        } else {
            title = menuItemImpl.getTitle();
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 21 || i3 > 23) {
            TooltipCompat.setTooltipText(this, title);
        }
        int i4 = menuItemImpl.isVisible() ? 0 : 8;
        setVisibility(i4);
        VdsAgent.onSetViewVisibility(this, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        q(this.f4387g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(@NonNull BadgeDrawable badgeDrawable) {
        this.o = badgeDrawable;
        ImageView imageView = this.f4387g;
        if (imageView != null) {
            p(imageView);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @NonNull
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.f4391k;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.f4391k.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, p);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.o;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f4391k.getTitle();
            if (!TextUtils.isEmpty(this.f4391k.getContentDescription())) {
                title = this.f4391k.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.o.f()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, h(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(R.string.item_view_role_description));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        TextView textView = this.f4390j;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.f4390j;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.f4389i;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.f4389i;
        textView4.setPivotY(textView4.getBaseline());
        int i2 = this.f4385e;
        if (i2 != -1) {
            if (i2 == 0) {
                if (z) {
                    n(this.f4387g, this.a, 49);
                    ViewGroup viewGroup = this.f4388h;
                    s(viewGroup, ((Integer) viewGroup.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                    TextView textView5 = this.f4390j;
                    textView5.setVisibility(0);
                    VdsAgent.onSetViewVisibility(textView5, 0);
                } else {
                    n(this.f4387g, this.a, 17);
                    s(this.f4388h, 0);
                    TextView textView6 = this.f4390j;
                    textView6.setVisibility(4);
                    VdsAgent.onSetViewVisibility(textView6, 4);
                }
                TextView textView7 = this.f4389i;
                textView7.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView7, 4);
            } else if (i2 == 1) {
                ViewGroup viewGroup2 = this.f4388h;
                s(viewGroup2, ((Integer) viewGroup2.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    n(this.f4387g, (int) (this.a + this.b), 49);
                    o(this.f4390j, 1.0f, 1.0f, 0);
                    TextView textView8 = this.f4389i;
                    float f2 = this.c;
                    o(textView8, f2, f2, 4);
                } else {
                    n(this.f4387g, this.a, 49);
                    TextView textView9 = this.f4390j;
                    float f3 = this.f4384d;
                    o(textView9, f3, f3, 4);
                    o(this.f4389i, 1.0f, 1.0f, 0);
                }
            } else if (i2 == 2) {
                n(this.f4387g, this.a, 17);
                TextView textView10 = this.f4390j;
                textView10.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView10, 8);
                TextView textView11 = this.f4389i;
                textView11.setVisibility(8);
                VdsAgent.onSetViewVisibility(textView11, 8);
            }
        } else if (this.f4386f) {
            if (z) {
                n(this.f4387g, this.a, 49);
                ViewGroup viewGroup3 = this.f4388h;
                s(viewGroup3, ((Integer) viewGroup3.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
                TextView textView12 = this.f4390j;
                textView12.setVisibility(0);
                VdsAgent.onSetViewVisibility(textView12, 0);
            } else {
                n(this.f4387g, this.a, 17);
                s(this.f4388h, 0);
                TextView textView13 = this.f4390j;
                textView13.setVisibility(4);
                VdsAgent.onSetViewVisibility(textView13, 4);
            }
            TextView textView14 = this.f4389i;
            textView14.setVisibility(4);
            VdsAgent.onSetViewVisibility(textView14, 4);
        } else {
            ViewGroup viewGroup4 = this.f4388h;
            s(viewGroup4, ((Integer) viewGroup4.getTag(R.id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                n(this.f4387g, (int) (this.a + this.b), 49);
                o(this.f4390j, 1.0f, 1.0f, 0);
                TextView textView15 = this.f4389i;
                float f4 = this.c;
                o(textView15, f4, f4, 4);
            } else {
                n(this.f4387g, this.a, 49);
                TextView textView16 = this.f4390j;
                float f5 = this.f4384d;
                o(textView16, f5, f5, 4);
                o(this.f4389i, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f4389i.setEnabled(z);
        this.f4390j.setEnabled(z);
        this.f4387g.setEnabled(z);
        if (z) {
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        } else {
            ViewCompat.setPointerIcon(this, null);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.m) {
            return;
        }
        this.m = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = DrawableCompat.wrap(drawable).mutate();
            this.n = drawable;
            ColorStateList colorStateList = this.f4392l;
            if (colorStateList != null) {
                DrawableCompat.setTintList(drawable, colorStateList);
            }
        }
        this.f4387g.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f4387g.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f4387g.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.f4392l = colorStateList;
        if (this.f4391k == null || (drawable = this.n) == null) {
            return;
        }
        DrawableCompat.setTintList(drawable, colorStateList);
        this.n.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.getDrawable(getContext(), i2));
    }

    public void setItemPosition(int i2) {
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f4385e != i2) {
            this.f4385e = i2;
            MenuItemImpl menuItemImpl = this.f4391k;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.f4386f != z) {
            this.f4386f = z;
            MenuItemImpl menuItemImpl = this.f4391k;
            if (menuItemImpl != null) {
                setChecked(menuItemImpl.isChecked());
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f4390j, i2);
        c(this.f4389i.getTextSize(), this.f4390j.getTextSize());
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        TextViewCompat.setTextAppearance(this.f4389i, i2);
        c(this.f4389i.getTextSize(), this.f4390j.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f4389i.setTextColor(colorStateList);
            this.f4390j.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        this.f4389i.setText(charSequence);
        this.f4390j.setText(charSequence);
        MenuItemImpl menuItemImpl = this.f4391k;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.f4391k;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.f4391k.getTooltipText();
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 21 || i2 > 23) {
            TooltipCompat.setTooltipText(this, charSequence);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ViewCompat.setBackground(this, drawable);
    }
}

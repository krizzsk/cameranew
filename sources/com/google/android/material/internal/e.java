package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Dimension;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
import java.util.ArrayList;
/* compiled from: NavigationMenuPresenter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class e implements MenuPresenter {
    private NavigationMenuView a;
    LinearLayout b;
    private MenuPresenter.Callback c;

    /* renamed from: d  reason: collision with root package name */
    MenuBuilder f4368d;

    /* renamed from: e  reason: collision with root package name */
    private int f4369e;

    /* renamed from: f  reason: collision with root package name */
    c f4370f;

    /* renamed from: g  reason: collision with root package name */
    LayoutInflater f4371g;

    /* renamed from: h  reason: collision with root package name */
    int f4372h;

    /* renamed from: i  reason: collision with root package name */
    boolean f4373i;

    /* renamed from: j  reason: collision with root package name */
    ColorStateList f4374j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f4375k;

    /* renamed from: l  reason: collision with root package name */
    Drawable f4376l;
    int m;
    int n;
    int o;
    boolean p;
    private int r;
    private int s;
    int t;
    boolean q = true;
    private int u = -1;
    final View.OnClickListener v = new a();

    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        @Instrumented
        public void onClick(View view) {
            VdsAgent.onClick(this, view);
            boolean z = true;
            e.this.q(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            e eVar = e.this;
            boolean performItemAction = eVar.f4368d.performItemAction(itemData, eVar, 0);
            if (itemData != null && itemData.isCheckable() && performItemAction) {
                e.this.f4370f.m(itemData);
            } else {
                z = false;
            }
            e.this.q(false);
            if (z) {
                e.this.updateMenuView(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class b extends l {
        public b(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public class c extends RecyclerView.Adapter<l> {
        private final ArrayList<InterfaceC0176e> a = new ArrayList<>();
        private MenuItemImpl b;
        private boolean c;

        c() {
            k();
        }

        private void e(int i2, int i3) {
            while (i2 < i3) {
                ((g) this.a.get(i2)).b = true;
                i2++;
            }
        }

        private void k() {
            if (this.c) {
                return;
            }
            this.c = true;
            this.a.clear();
            this.a.add(new d());
            int i2 = -1;
            int size = e.this.f4368d.getVisibleItems().size();
            boolean z = false;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = e.this.f4368d.getVisibleItems().get(i4);
                if (menuItemImpl.isChecked()) {
                    m(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.setExclusiveCheckable(false);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenu subMenu = menuItemImpl.getSubMenu();
                    if (subMenu.hasVisibleItems()) {
                        if (i4 != 0) {
                            this.a.add(new f(e.this.t, 0));
                        }
                        this.a.add(new g(menuItemImpl));
                        int size2 = this.a.size();
                        int size3 = subMenu.size();
                        boolean z2 = false;
                        for (int i5 = 0; i5 < size3; i5++) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                            if (menuItemImpl2.isVisible()) {
                                if (!z2 && menuItemImpl2.getIcon() != null) {
                                    z2 = true;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.setExclusiveCheckable(false);
                                }
                                if (menuItemImpl.isChecked()) {
                                    m(menuItemImpl);
                                }
                                this.a.add(new g(menuItemImpl2));
                            }
                        }
                        if (z2) {
                            e(size2, this.a.size());
                        }
                    }
                } else {
                    int groupId = menuItemImpl.getGroupId();
                    if (groupId != i2) {
                        i3 = this.a.size();
                        z = menuItemImpl.getIcon() != null;
                        if (i4 != 0) {
                            i3++;
                            ArrayList<InterfaceC0176e> arrayList = this.a;
                            int i6 = e.this.t;
                            arrayList.add(new f(i6, i6));
                        }
                    } else if (!z && menuItemImpl.getIcon() != null) {
                        e(i3, this.a.size());
                        z = true;
                    }
                    g gVar = new g(menuItemImpl);
                    gVar.b = z;
                    this.a.add(gVar);
                    i2 = groupId;
                }
            }
            this.c = false;
        }

        @NonNull
        public Bundle f() {
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.b;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0176e interfaceC0176e = this.a.get(i2);
                if (interfaceC0176e instanceof g) {
                    MenuItemImpl a = ((g) interfaceC0176e).a();
                    View actionView = a != null ? a.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        int g() {
            int i2 = e.this.b.getChildCount() == 0 ? 0 : 1;
            for (int i3 = 0; i3 < e.this.f4370f.getItemCount(); i3++) {
                if (e.this.f4370f.getItemViewType(i3) == 0) {
                    i2++;
                }
            }
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i2) {
            InterfaceC0176e interfaceC0176e = this.a.get(i2);
            if (interfaceC0176e instanceof f) {
                return 2;
            }
            if (interfaceC0176e instanceof d) {
                return 3;
            }
            if (interfaceC0176e instanceof g) {
                return ((g) interfaceC0176e).a().hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: h */
        public void onBindViewHolder(@NonNull l lVar, int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ((TextView) lVar.itemView).setText(((g) this.a.get(i2)).a().getTitle());
                    return;
                } else if (itemViewType != 2) {
                    return;
                } else {
                    f fVar = (f) this.a.get(i2);
                    lVar.itemView.setPadding(0, fVar.b(), 0, fVar.a());
                    return;
                }
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) lVar.itemView;
            navigationMenuItemView.e(e.this.f4375k);
            e eVar = e.this;
            if (eVar.f4373i) {
                navigationMenuItemView.setTextAppearance(eVar.f4372h);
            }
            ColorStateList colorStateList = e.this.f4374j;
            if (colorStateList != null) {
                navigationMenuItemView.setTextColor(colorStateList);
            }
            Drawable drawable = e.this.f4376l;
            ViewCompat.setBackground(navigationMenuItemView, drawable != null ? drawable.getConstantState().newDrawable() : null);
            g gVar = (g) this.a.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(gVar.b);
            navigationMenuItemView.setHorizontalPadding(e.this.m);
            navigationMenuItemView.setIconPadding(e.this.n);
            e eVar2 = e.this;
            if (eVar2.p) {
                navigationMenuItemView.setIconSize(eVar2.o);
            }
            navigationMenuItemView.setMaxLines(e.this.r);
            navigationMenuItemView.initialize(gVar.a(), 0);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @Nullable
        /* renamed from: i */
        public l onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                e eVar = e.this;
                return new i(eVar.f4371g, viewGroup, eVar.v);
            } else if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return new b(e.this.b);
                }
                return new j(e.this.f4371g, viewGroup);
            } else {
                return new k(e.this.f4371g, viewGroup);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j */
        public void onViewRecycled(l lVar) {
            if (lVar instanceof i) {
                ((NavigationMenuItemView) lVar.itemView).c();
            }
        }

        public void l(@NonNull Bundle bundle) {
            MenuItemImpl a;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a2;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.c = true;
                int size = this.a.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    InterfaceC0176e interfaceC0176e = this.a.get(i3);
                    if ((interfaceC0176e instanceof g) && (a2 = ((g) interfaceC0176e).a()) != null && a2.getItemId() == i2) {
                        m(a2);
                        break;
                    }
                    i3++;
                }
                this.c = false;
                k();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.a.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    InterfaceC0176e interfaceC0176e2 = this.a.get(i4);
                    if ((interfaceC0176e2 instanceof g) && (a = ((g) interfaceC0176e2).a()) != null && (actionView = a.getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a.getItemId())) != null) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void m(@NonNull MenuItemImpl menuItemImpl) {
            if (this.b == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.b;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.b = menuItemImpl;
            menuItemImpl.setChecked(true);
        }

        public void n(boolean z) {
            this.c = z;
        }

        public void o() {
            k();
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class d implements InterfaceC0176e {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* renamed from: com.google.android.material.internal.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0176e {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class f implements InterfaceC0176e {
        private final int a;
        private final int b;

        public f(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public int a() {
            return this.b;
        }

        public int b() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class g implements InterfaceC0176e {
        private final MenuItemImpl a;
        boolean b;

        g(MenuItemImpl menuItemImpl) {
            this.a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.a;
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    private class h extends RecyclerViewAccessibilityDelegate {
        h(@NonNull RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(e.this.f4370f.g(), 0, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class i extends l {
        public i(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class j extends l {
        public j(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    public static class k extends l {
        public k(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    /* compiled from: NavigationMenuPresenter.java */
    /* loaded from: classes2.dex */
    private static abstract class l extends RecyclerView.ViewHolder {
        public l(View view) {
            super(view);
        }
    }

    private void r() {
        int i2 = (this.b.getChildCount() == 0 && this.q) ? this.s : 0;
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
    }

    public void b(@NonNull View view) {
        this.b.addView(view);
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public void c(@NonNull WindowInsetsCompat windowInsetsCompat) {
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        if (this.s != systemWindowInsetTop) {
            this.s = systemWindowInsetTop;
            r();
        }
        NavigationMenuView navigationMenuView = this.a;
        navigationMenuView.setPadding(0, navigationMenuView.getPaddingTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom());
        ViewCompat.dispatchApplyWindowInsets(this.b, windowInsetsCompat);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View d(@LayoutRes int i2) {
        View inflate = this.f4371g.inflate(i2, (ViewGroup) this.b, false);
        b(inflate);
        return inflate;
    }

    public void e(boolean z) {
        if (this.q != z) {
            this.q = z;
            r();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void f(@NonNull MenuItemImpl menuItemImpl) {
        this.f4370f.m(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    public void g(int i2) {
        this.f4369e = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public int getId() {
        return this.f4369e;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public MenuView getMenuView(ViewGroup viewGroup) {
        if (this.a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f4371g.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new h(this.a));
            if (this.f4370f == null) {
                this.f4370f = new c();
            }
            int i2 = this.u;
            if (i2 != -1) {
                this.a.setOverScrollMode(i2);
            }
            this.b = (LinearLayout) this.f4371g.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.a, false);
            this.a.setAdapter(this.f4370f);
        }
        return this.a;
    }

    public void h(@Nullable Drawable drawable) {
        this.f4376l = drawable;
        updateMenuView(false);
    }

    public void i(int i2) {
        this.m = i2;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void initForMenu(@NonNull Context context, @NonNull MenuBuilder menuBuilder) {
        this.f4371g = LayoutInflater.from(context);
        this.f4368d = menuBuilder;
        this.t = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public void j(int i2) {
        this.n = i2;
        updateMenuView(false);
    }

    public void k(@Dimension int i2) {
        if (this.o != i2) {
            this.o = i2;
            this.p = true;
            updateMenuView(false);
        }
    }

    public void l(@Nullable ColorStateList colorStateList) {
        this.f4375k = colorStateList;
        updateMenuView(false);
    }

    public void m(int i2) {
        this.r = i2;
        updateMenuView(false);
    }

    public void n(@StyleRes int i2) {
        this.f4372h = i2;
        this.f4373i = true;
        updateMenuView(false);
    }

    public void o(@Nullable ColorStateList colorStateList) {
        this.f4374j = colorStateList;
        updateMenuView(false);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.c;
        if (callback != null) {
            callback.onCloseMenu(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(ListMenuPresenter.VIEWS_TAG);
            if (sparseParcelableArray != null) {
                this.a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f4370f.l(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.b.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    @NonNull
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        if (this.a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray(ListMenuPresenter.VIEWS_TAG, sparseArray);
        }
        c cVar = this.f4370f;
        if (cVar != null) {
            bundle.putBundle("android:menu:adapter", cVar.f());
        }
        if (this.b != null) {
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            this.b.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void p(int i2) {
        this.u = i2;
        NavigationMenuView navigationMenuView = this.a;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(i2);
        }
    }

    public void q(boolean z) {
        c cVar = this.f4370f;
        if (cVar != null) {
            cVar.n(z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.c = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        c cVar = this.f4370f;
        if (cVar != null) {
            cVar.o();
        }
    }
}

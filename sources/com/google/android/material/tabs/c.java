package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
/* compiled from: TabLayoutMediator.java */
/* loaded from: classes2.dex */
public final class c {
    @NonNull
    private final TabLayout a;
    @NonNull
    private final ViewPager2 b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4590d;

    /* renamed from: e  reason: collision with root package name */
    private final b f4591e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f4592f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f4593g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private C0179c f4594h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.d f4595i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f4596j;

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes2.dex */
    private class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i2, int i3) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i2, int i3, int i4) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i2, int i3) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            c.this.b();
        }
    }

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(@NonNull TabLayout.f fVar, int i2);
    }

    /* compiled from: TabLayoutMediator.java */
    /* renamed from: com.google.android.material.tabs.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static class C0179c extends ViewPager2.OnPageChangeCallback {
        @NonNull
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        C0179c(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
            a();
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            this.b = this.c;
            this.c = i2;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i4 = this.c;
                boolean z = false;
                tabLayout.setScrollPosition(i2, f2, i4 != 2 || this.b == 1, (i4 == 2 && this.b == 0) ? true : true);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.y() == i2 || i2 >= tabLayout.A()) {
                return;
            }
            int i3 = this.c;
            tabLayout.N(tabLayout.z(i2), i3 == 0 || (i3 == 2 && this.b == 0));
        }
    }

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes2.dex */
    private static class d implements TabLayout.d {
        private final ViewPager2 a;
        private final boolean b;

        d(ViewPager2 viewPager2, boolean z) {
            this.a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NonNull TabLayout.f fVar) {
            this.a.setCurrentItem(fVar.g(), this.b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f fVar) {
        }
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (!this.f4593g) {
            RecyclerView.Adapter<?> adapter = this.b.getAdapter();
            this.f4592f = adapter;
            if (adapter != null) {
                this.f4593g = true;
                C0179c c0179c = new C0179c(this.a);
                this.f4594h = c0179c;
                this.b.registerOnPageChangeCallback(c0179c);
                d dVar = new d(this.b, this.f4590d);
                this.f4595i = dVar;
                this.a.d(dVar);
                if (this.c) {
                    a aVar = new a();
                    this.f4596j = aVar;
                    this.f4592f.registerAdapterDataObserver(aVar);
                }
                b();
                this.a.setScrollPosition(this.b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    void b() {
        this.a.I();
        RecyclerView.Adapter<?> adapter = this.f4592f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i2 = 0; i2 < itemCount; i2++) {
                TabLayout.f F = this.a.F();
                this.f4591e.a(F, i2);
                this.a.g(F, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.b.getCurrentItem(), this.a.A() - 1);
                if (min != this.a.y()) {
                    TabLayout tabLayout = this.a;
                    tabLayout.M(tabLayout.z(min));
                }
            }
        }
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, @NonNull b bVar) {
        this(tabLayout, viewPager2, z, true, bVar);
    }

    public c(@NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, boolean z, boolean z2, @NonNull b bVar) {
        this.a = tabLayout;
        this.b = viewPager2;
        this.c = z;
        this.f4590d = z2;
        this.f4591e = bVar;
    }
}

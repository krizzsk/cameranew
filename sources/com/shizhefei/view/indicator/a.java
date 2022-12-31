package com.shizhefei.view.indicator;

import android.view.View;
import android.view.ViewGroup;
import com.shizhefei.view.indicator.slidebar.ScrollBar;
import java.util.LinkedHashSet;
import java.util.Set;
/* compiled from: Indicator.java */
/* loaded from: classes3.dex */
public interface a {

    /* compiled from: Indicator.java */
    /* renamed from: com.shizhefei.view.indicator.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0251a {
        void onChange();
    }

    /* compiled from: Indicator.java */
    /* loaded from: classes3.dex */
    public static abstract class b {
        private boolean a;
        private Set<InterfaceC0251a> b = new LinkedHashSet(2);

        public abstract int a();

        public abstract View b(int i2, View view, ViewGroup viewGroup);

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c() {
            return this.a;
        }

        public void d() {
            for (InterfaceC0251a interfaceC0251a : this.b) {
                interfaceC0251a.onChange();
            }
        }

        public void e(InterfaceC0251a interfaceC0251a) {
            this.b.add(interfaceC0251a);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void f(boolean z) {
            this.a = z;
        }

        public void g(InterfaceC0251a interfaceC0251a) {
            this.b.remove(interfaceC0251a);
        }
    }

    /* compiled from: Indicator.java */
    /* loaded from: classes3.dex */
    public interface c {
        void a(View view, int i2, int i3);
    }

    /* compiled from: Indicator.java */
    /* loaded from: classes3.dex */
    public interface d {
        void onTransition(View view, int i2, float f2);
    }

    int a();

    void onPageScrollStateChanged(int i2);

    void onPageScrolled(int i2, float f2, int i3);

    void setAdapter(b bVar);

    void setCurrentItem(int i2, boolean z);

    void setItemClickable(boolean z);

    void setOnItemSelectListener(c cVar);

    void setOnTransitionListener(d dVar);

    void setScrollBar(ScrollBar scrollBar);
}

package us.pinguo.edit2020.manager;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import us.pinguo.edit2020.manager.AutoPlayDetector;
import us.pinguo.edit2020.view.e0;
/* compiled from: AutoPlayDetector.kt */
/* loaded from: classes4.dex */
public final class AutoPlayDetector {
    private final LifecycleOwner a;
    private final RecyclerView b;
    private final ArrayList<e0> c;

    /* renamed from: d  reason: collision with root package name */
    private final long f10528d;

    /* renamed from: e  reason: collision with root package name */
    private e0 f10529e;

    /* renamed from: f  reason: collision with root package name */
    private Pair<Integer, Integer> f10530f;

    /* renamed from: g  reason: collision with root package name */
    private final Runnable f10531g;

    /* renamed from: h  reason: collision with root package name */
    private final a f10532h;

    /* compiled from: AutoPlayDetector.kt */
    /* loaded from: classes4.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            s.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                AutoPlayDetector.this.l();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            e0 e0Var;
            s.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            if (i2 != 0 || i3 != 0) {
                e0 e0Var2 = AutoPlayDetector.this.f10529e;
                boolean z = false;
                if (e0Var2 != null && e0Var2.isPlaying()) {
                    z = true;
                }
                if (z) {
                    AutoPlayDetector autoPlayDetector = AutoPlayDetector.this;
                    if (autoPlayDetector.p(autoPlayDetector.f10529e) || (e0Var = AutoPlayDetector.this.f10529e) == null) {
                        return;
                    }
                    e0Var.b();
                    return;
                }
                return;
            }
            AutoPlayDetector.this.r();
        }
    }

    public AutoPlayDetector(LifecycleOwner owner, RecyclerView recyclerView) {
        s.h(owner, "owner");
        s.h(recyclerView, "recyclerView");
        this.a = owner;
        this.b = recyclerView;
        this.c = new ArrayList<>();
        this.f10528d = 300L;
        this.f10531g = new Runnable() { // from class: us.pinguo.edit2020.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                AutoPlayDetector.m(AutoPlayDetector.this);
            }
        };
        this.f10532h = new a();
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l() {
        e0 e0Var;
        if (this.c.size() <= 0 || this.b.getChildCount() <= 0) {
            return;
        }
        e0 e0Var2 = this.f10529e;
        boolean z = false;
        if ((e0Var2 != null && e0Var2.isPlaying()) && p(this.f10529e)) {
            return;
        }
        e0 e0Var3 = null;
        Iterator<e0> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            e0 next = it.next();
            if (p(next)) {
                e0Var3 = next;
                break;
            }
        }
        if (e0Var3 != null) {
            e0 e0Var4 = this.f10529e;
            if (e0Var4 != null && e0Var4.isPlaying()) {
                z = true;
            }
            if (z && (e0Var = this.f10529e) != null) {
                e0Var.b();
            }
            this.f10529e = e0Var3;
            e0Var3.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AutoPlayDetector this$0) {
        s.h(this$0, "this$0");
        this$0.l();
    }

    private final void n() {
        if (this.f10530f == null) {
            int[] iArr = new int[2];
            this.b.getLocationOnScreen(iArr);
            int i2 = iArr[1];
            Context b = us.pinguo.foundation.e.b();
            s.g(b, "getAppContext()");
            int a2 = i2 + us.pinguo.util.g.a(b, 100.0f);
            Context b2 = us.pinguo.foundation.e.b();
            s.g(b2, "getAppContext()");
            this.f10530f = new Pair<>(Integer.valueOf(a2), Integer.valueOf((this.b.getHeight() + a2) - us.pinguo.util.g.a(b2, 240.0f)));
        }
    }

    private final void o() {
        this.a.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: us.pinguo.edit2020.manager.AutoPlayDetector$init$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                ArrayList arrayList;
                RecyclerView recyclerView;
                Runnable runnable;
                RecyclerView recyclerView2;
                AutoPlayDetector.a aVar;
                LifecycleOwner lifecycleOwner;
                s.h(source, "source");
                s.h(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    AutoPlayDetector.this.f10529e = null;
                    arrayList = AutoPlayDetector.this.c;
                    arrayList.clear();
                    recyclerView = AutoPlayDetector.this.b;
                    runnable = AutoPlayDetector.this.f10531g;
                    recyclerView.removeCallbacks(runnable);
                    recyclerView2 = AutoPlayDetector.this.b;
                    aVar = AutoPlayDetector.this.f10532h;
                    recyclerView2.removeOnScrollListener(aVar);
                    lifecycleOwner = AutoPlayDetector.this.a;
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        this.b.addOnScrollListener(this.f10532h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean p(e0 e0Var) {
        if (e0Var == null) {
            return false;
        }
        ViewGroup a2 = e0Var.a();
        n();
        if (a2.isShown() && a2.isAttachedToWindow()) {
            int[] iArr = new int[2];
            a2.getLocationOnScreen(iArr);
            int height = iArr[1] + (a2.getHeight() / 2);
            Pair<Integer, Integer> pair = this.f10530f;
            s.e(pair);
            if (height >= pair.getFirst().intValue()) {
                Pair<Integer, Integer> pair2 = this.f10530f;
                s.e(pair2);
                return height <= pair2.getSecond().intValue();
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.b.postDelayed(this.f10531g, this.f10528d);
    }

    public final void k(e0 target) {
        s.h(target, "target");
        this.c.add(target);
    }

    public final void s(e0 target) {
        s.h(target, "target");
        this.c.remove(target);
    }
}

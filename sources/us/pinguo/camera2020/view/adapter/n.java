package us.pinguo.camera2020.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: DefaultItemAnimator.kt */
/* loaded from: classes3.dex */
public final class n extends SimpleItemAnimator {

    /* renamed from: l  reason: collision with root package name */
    public static final b f9353l = new b(null);
    private static final boolean m = false;
    private static TimeInterpolator n;
    private final ArrayList<RecyclerView.ViewHolder> a = new ArrayList<>();
    private final ArrayList<RecyclerView.ViewHolder> b = new ArrayList<>();
    private final ArrayList<c> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f9354d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<ArrayList<RecyclerView.ViewHolder>> f9355e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ArrayList<c>> f9356f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ArrayList<a>> f9357g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f9358h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f9359i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f9360j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<RecyclerView.ViewHolder> f9361k = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private RecyclerView.ViewHolder a;
        private RecyclerView.ViewHolder b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f9362d;

        /* renamed from: e  reason: collision with root package name */
        private int f9363e;

        /* renamed from: f  reason: collision with root package name */
        private int f9364f;

        private a(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.a = viewHolder;
            this.b = viewHolder2;
        }

        public final int a() {
            return this.c;
        }

        public final int b() {
            return this.f9362d;
        }

        public final RecyclerView.ViewHolder c() {
            return this.b;
        }

        public final RecyclerView.ViewHolder d() {
            return this.a;
        }

        public final int e() {
            return this.f9363e;
        }

        public final int f() {
            return this.f9364f;
        }

        public final void g(RecyclerView.ViewHolder viewHolder) {
            this.b = viewHolder;
        }

        public final void h(RecyclerView.ViewHolder viewHolder) {
            this.a = viewHolder;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.f9362d + ", toX=" + this.f9363e + ", toY=" + this.f9364f + '}';
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int i2, int i3, int i4, int i5) {
            this(oldHolder, newHolder);
            kotlin.jvm.internal.s.h(oldHolder, "oldHolder");
            kotlin.jvm.internal.s.h(newHolder, "newHolder");
            this.c = i2;
            this.f9362d = i3;
            this.f9363e = i4;
            this.f9364f = i5;
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.o oVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        private RecyclerView.ViewHolder a;
        private int b;
        private int c;

        /* renamed from: d  reason: collision with root package name */
        private int f9365d;

        /* renamed from: e  reason: collision with root package name */
        private int f9366e;

        public c(RecyclerView.ViewHolder holder, int i2, int i3, int i4, int i5) {
            kotlin.jvm.internal.s.h(holder, "holder");
            this.a = holder;
            this.b = i2;
            this.c = i3;
            this.f9365d = i4;
            this.f9366e = i5;
        }

        public final int a() {
            return this.b;
        }

        public final int b() {
            return this.c;
        }

        public final RecyclerView.ViewHolder c() {
            return this.a;
        }

        public final int d() {
            return this.f9365d;
        }

        public final int e() {
            return this.f9366e;
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.ViewHolder b;
        final /* synthetic */ View c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9367d;

        d(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.b = viewHolder;
            this.c = view;
            this.f9367d = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.c.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.f9367d.setListener(null);
            n.this.dispatchAddFinished(this.b);
            n.this.h().remove(this.b);
            n.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            n.this.dispatchAddStarting(this.b);
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ a b;
        final /* synthetic */ ViewPropertyAnimator c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f9368d;

        e(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.b = aVar;
            this.c = viewPropertyAnimator;
            this.f9368d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.c.setListener(null);
            this.f9368d.setAlpha(1.0f);
            this.f9368d.setTranslationX(0.0f);
            this.f9368d.setTranslationY(0.0f);
            n.this.dispatchChangeFinished(this.b.d(), true);
            ArrayList<RecyclerView.ViewHolder> i2 = n.this.i();
            RecyclerView.ViewHolder d2 = this.b.d();
            kotlin.jvm.internal.s.e(d2);
            i2.remove(d2);
            n.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            n.this.dispatchChangeStarting(this.b.d(), true);
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ a b;
        final /* synthetic */ ViewPropertyAnimator c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f9369d;

        f(a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.b = aVar;
            this.c = viewPropertyAnimator;
            this.f9369d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.c.setListener(null);
            this.f9369d.setAlpha(1.0f);
            this.f9369d.setTranslationX(0.0f);
            this.f9369d.setTranslationY(0.0f);
            n.this.dispatchChangeFinished(this.b.c(), false);
            ArrayList<RecyclerView.ViewHolder> i2 = n.this.i();
            RecyclerView.ViewHolder c = this.b.c();
            kotlin.jvm.internal.s.e(c);
            i2.remove(c);
            n.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            n.this.dispatchChangeStarting(this.b.c(), false);
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class g extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.ViewHolder b;
        final /* synthetic */ int c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f9370d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f9371e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f9372f;

        g(RecyclerView.ViewHolder viewHolder, int i2, View view, int i3, ViewPropertyAnimator viewPropertyAnimator) {
            this.b = viewHolder;
            this.c = i2;
            this.f9370d = view;
            this.f9371e = i3;
            this.f9372f = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            if (this.c != 0) {
                this.f9370d.setTranslationX(0.0f);
            }
            if (this.f9371e != 0) {
                this.f9370d.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.f9372f.setListener(null);
            n.this.dispatchMoveFinished(this.b);
            n.this.j().remove(this.b);
            n.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            n.this.dispatchMoveStarting(this.b);
        }
    }

    /* compiled from: DefaultItemAnimator.kt */
    /* loaded from: classes3.dex */
    public static final class h extends AnimatorListenerAdapter {
        final /* synthetic */ RecyclerView.ViewHolder b;
        final /* synthetic */ ViewPropertyAnimator c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f9373d;

        h(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.b = viewHolder;
            this.c = viewPropertyAnimator;
            this.f9373d = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            this.c.setListener(null);
            this.f9373d.setAlpha(1.0f);
            n.this.dispatchRemoveFinished(this.b);
            n.this.k().remove(this.b);
            n.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            kotlin.jvm.internal.s.h(animator, "animator");
            n.this.dispatchRemoveStarting(this.b);
        }
    }

    private final void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        kotlin.jvm.internal.s.g(view, "holder.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.f9360j.add(viewHolder);
        animate.setDuration(getRemoveDuration()).alpha(0.0f).setListener(new h(viewHolder, animate, view)).start();
    }

    private final void b(a aVar) {
        RecyclerView.ViewHolder d2 = aVar.d();
        View view = d2 == null ? null : d2.itemView;
        RecyclerView.ViewHolder c2 = aVar.c();
        View view2 = c2 != null ? c2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            ArrayList<RecyclerView.ViewHolder> arrayList = this.f9361k;
            RecyclerView.ViewHolder d3 = aVar.d();
            kotlin.jvm.internal.s.e(d3);
            arrayList.add(d3);
            duration.translationX(aVar.e() - aVar.a());
            duration.translationY(aVar.f() - aVar.b());
            duration.alpha(0.0f).setListener(new e(aVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            ArrayList<RecyclerView.ViewHolder> arrayList2 = this.f9361k;
            RecyclerView.ViewHolder c3 = aVar.c();
            kotlin.jvm.internal.s.e(c3);
            arrayList2.add(c3);
            animate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new f(aVar, animate, view2)).start();
        }
    }

    private final void endChangeAnimation(List<a> list, RecyclerView.ViewHolder viewHolder) {
        int size = list.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            a aVar = list.get(size);
            if (g(aVar, viewHolder) && aVar.d() == null && aVar.c() == null) {
                list.remove(aVar);
            }
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    private final void f(a aVar) {
        if (aVar.d() != null) {
            g(aVar, aVar.d());
        }
        if (aVar.c() != null) {
            g(aVar, aVar.c());
        }
    }

    private final boolean g(a aVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (aVar.c() == viewHolder) {
            aVar.g(null);
        } else if (aVar.d() != viewHolder) {
            return false;
        } else {
            aVar.h(null);
            z = true;
        }
        kotlin.jvm.internal.s.e(viewHolder);
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ArrayList moves, n this$0) {
        kotlin.jvm.internal.s.h(moves, "$moves");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Iterator it = moves.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            this$0.c(cVar.c(), cVar.a(), cVar.b(), cVar.d(), cVar.e());
        }
        moves.clear();
        this$0.f9356f.remove(moves);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(ArrayList changes, n this$0) {
        kotlin.jvm.internal.s.h(changes, "$changes");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Iterator it = changes.iterator();
        while (it.hasNext()) {
            a change = (a) it.next();
            kotlin.jvm.internal.s.g(change, "change");
            this$0.b(change);
        }
        changes.clear();
        this$0.f9357g.remove(changes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(ArrayList additions, n this$0) {
        kotlin.jvm.internal.s.h(additions, "$additions");
        kotlin.jvm.internal.s.h(this$0, "this$0");
        Iterator it = additions.iterator();
        while (it.hasNext()) {
            RecyclerView.ViewHolder holder = (RecyclerView.ViewHolder) it.next();
            kotlin.jvm.internal.s.g(holder, "holder");
            this$0.a(holder);
        }
        additions.clear();
        this$0.f9355e.remove(additions);
    }

    private final void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (n == null) {
            n = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(n);
        endAnimation(viewHolder);
    }

    public final void a(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        View view = holder.itemView;
        kotlin.jvm.internal.s.g(view, "holder.itemView");
        ViewPropertyAnimator animate = view.animate();
        this.f9358h.add(holder);
        animate.alpha(1.0f).setDuration(getAddDuration()).setListener(new d(holder, view, animate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        resetAnimation(holder);
        holder.itemView.setAlpha(0.0f);
        this.b.add(holder);
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        kotlin.jvm.internal.s.h(oldHolder, "oldHolder");
        if (oldHolder == viewHolder) {
            return animateMove(oldHolder, i2, i3, i4, i5);
        }
        float translationX = oldHolder.itemView.getTranslationX();
        float translationY = oldHolder.itemView.getTranslationY();
        float alpha = oldHolder.itemView.getAlpha();
        resetAnimation(oldHolder);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        oldHolder.itemView.setTranslationX(translationX);
        oldHolder.itemView.setTranslationY(translationY);
        oldHolder.itemView.setAlpha(alpha);
        if (viewHolder != null) {
            resetAnimation(viewHolder);
            viewHolder.itemView.setTranslationX(-i6);
            viewHolder.itemView.setTranslationY(-i7);
            viewHolder.itemView.setAlpha(0.0f);
        }
        ArrayList<a> arrayList = this.f9354d;
        kotlin.jvm.internal.s.e(viewHolder);
        arrayList.add(new a(oldHolder, viewHolder, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder holder, int i2, int i3, int i4, int i5) {
        kotlin.jvm.internal.s.h(holder, "holder");
        View view = holder.itemView;
        kotlin.jvm.internal.s.g(view, "holder.itemView");
        int translationX = i2 + ((int) holder.itemView.getTranslationX());
        int translationY = i3 + ((int) holder.itemView.getTranslationY());
        resetAnimation(holder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(holder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.c.add(new c(holder, translationX, translationY, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        kotlin.jvm.internal.s.h(holder, "holder");
        resetAnimation(holder);
        this.a.add(holder);
        return true;
    }

    public final void c(RecyclerView.ViewHolder holder, int i2, int i3, int i4, int i5) {
        kotlin.jvm.internal.s.h(holder, "holder");
        View view = holder.itemView;
        kotlin.jvm.internal.s.g(view, "holder.itemView");
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f9359i.add(holder);
        animate.setDuration(getMoveDuration()).setListener(new g(holder, i6, view, i7, animate)).start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder viewHolder, List<? extends Object> payloads) {
        kotlin.jvm.internal.s.h(viewHolder, "viewHolder");
        kotlin.jvm.internal.s.h(payloads, "payloads");
        return !payloads.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, payloads);
    }

    public final void d(List<? extends RecyclerView.ViewHolder> viewHolders) {
        kotlin.jvm.internal.s.h(viewHolders, "viewHolders");
        int size = viewHolders.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i2 = size - 1;
            viewHolders.get(size).itemView.animate().cancel();
            if (i2 < 0) {
                return;
            }
            size = i2;
        }
    }

    public final void e() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder item) {
        kotlin.jvm.internal.s.h(item, "item");
        View view = item.itemView;
        kotlin.jvm.internal.s.g(view, "item.itemView");
        view.animate().cancel();
        int size = this.c.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                c cVar = this.c.get(size);
                kotlin.jvm.internal.s.g(cVar, "mPendingMoves[i]");
                if (cVar.c() == item) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(item);
                    this.c.remove(size);
                }
                if (i2 < 0) {
                    break;
                }
                size = i2;
            }
        }
        endChangeAnimation(this.f9354d, item);
        if (this.a.remove(item)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(item);
        }
        if (this.b.remove(item)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(item);
        }
        int size2 = this.f9357g.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i3 = size2 - 1;
                ArrayList<a> arrayList = this.f9357g.get(size2);
                kotlin.jvm.internal.s.g(arrayList, "mChangesList[i]");
                ArrayList<a> arrayList2 = arrayList;
                endChangeAnimation(arrayList2, item);
                if (arrayList2.isEmpty()) {
                    this.f9357g.remove(size2);
                }
                if (i3 < 0) {
                    break;
                }
                size2 = i3;
            }
        }
        int size3 = this.f9356f.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i4 = size3 - 1;
                ArrayList<c> arrayList3 = this.f9356f.get(size3);
                kotlin.jvm.internal.s.g(arrayList3, "mMovesList[i]");
                ArrayList<c> arrayList4 = arrayList3;
                int size4 = arrayList4.size() - 1;
                if (size4 >= 0) {
                    while (true) {
                        int i5 = size4 - 1;
                        c cVar2 = arrayList4.get(size4);
                        kotlin.jvm.internal.s.g(cVar2, "moves[j]");
                        if (cVar2.c() == item) {
                            view.setTranslationY(0.0f);
                            view.setTranslationX(0.0f);
                            dispatchMoveFinished(item);
                            arrayList4.remove(size4);
                            if (arrayList4.isEmpty()) {
                                this.f9356f.remove(size3);
                            }
                        } else if (i5 < 0) {
                            break;
                        } else {
                            size4 = i5;
                        }
                    }
                }
                if (i4 < 0) {
                    break;
                }
                size3 = i4;
            }
        }
        int size5 = this.f9355e.size() - 1;
        if (size5 >= 0) {
            while (true) {
                int i6 = size5 - 1;
                ArrayList<RecyclerView.ViewHolder> arrayList5 = this.f9355e.get(size5);
                kotlin.jvm.internal.s.g(arrayList5, "mAdditionsList[i]");
                ArrayList<RecyclerView.ViewHolder> arrayList6 = arrayList5;
                if (arrayList6.remove(item)) {
                    view.setAlpha(1.0f);
                    dispatchAddFinished(item);
                    if (arrayList6.isEmpty()) {
                        this.f9355e.remove(size5);
                    }
                }
                if (i6 < 0) {
                    break;
                }
                size5 = i6;
            }
        }
        if (this.f9360j.remove(item) && m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mRemoveAnimations list");
        }
        if (this.f9358h.remove(item) && m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mAddAnimations list");
        }
        if (this.f9361k.remove(item) && m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mChangeAnimations list");
        }
        if (this.f9359i.remove(item) && m) {
            throw new IllegalStateException("after animation is cancelled, item should not be in mMoveAnimations list");
        }
        e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.c.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                c cVar = this.c.get(size);
                kotlin.jvm.internal.s.g(cVar, "mPendingMoves[i]");
                c cVar2 = cVar;
                View view = cVar2.c().itemView;
                kotlin.jvm.internal.s.g(view, "item.holder.itemView");
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(cVar2.c());
                this.c.remove(size);
                if (i2 < 0) {
                    break;
                }
                size = i2;
            }
        }
        int size2 = this.a.size() - 1;
        if (size2 >= 0) {
            while (true) {
                int i3 = size2 - 1;
                RecyclerView.ViewHolder viewHolder = this.a.get(size2);
                kotlin.jvm.internal.s.g(viewHolder, "mPendingRemovals[i]");
                dispatchRemoveFinished(viewHolder);
                this.a.remove(size2);
                if (i3 < 0) {
                    break;
                }
                size2 = i3;
            }
        }
        int size3 = this.b.size() - 1;
        if (size3 >= 0) {
            while (true) {
                int i4 = size3 - 1;
                RecyclerView.ViewHolder viewHolder2 = this.b.get(size3);
                kotlin.jvm.internal.s.g(viewHolder2, "mPendingAdditions[i]");
                RecyclerView.ViewHolder viewHolder3 = viewHolder2;
                viewHolder3.itemView.setAlpha(1.0f);
                dispatchAddFinished(viewHolder3);
                this.b.remove(size3);
                if (i4 < 0) {
                    break;
                }
                size3 = i4;
            }
        }
        int size4 = this.f9354d.size() - 1;
        if (size4 >= 0) {
            while (true) {
                int i5 = size4 - 1;
                a aVar = this.f9354d.get(size4);
                kotlin.jvm.internal.s.g(aVar, "mPendingChanges[i]");
                f(aVar);
                if (i5 < 0) {
                    break;
                }
                size4 = i5;
            }
        }
        this.f9354d.clear();
        if (isRunning()) {
            int size5 = this.f9356f.size() - 1;
            if (size5 >= 0) {
                while (true) {
                    int i6 = size5 - 1;
                    ArrayList<c> arrayList = this.f9356f.get(size5);
                    kotlin.jvm.internal.s.g(arrayList, "mMovesList[i]");
                    ArrayList<c> arrayList2 = arrayList;
                    int size6 = arrayList2.size() - 1;
                    if (size6 >= 0) {
                        while (true) {
                            int i7 = size6 - 1;
                            c cVar3 = arrayList2.get(size6);
                            kotlin.jvm.internal.s.g(cVar3, "moves[j]");
                            c cVar4 = cVar3;
                            View view2 = cVar4.c().itemView;
                            kotlin.jvm.internal.s.g(view2, "item.itemView");
                            view2.setTranslationY(0.0f);
                            view2.setTranslationX(0.0f);
                            dispatchMoveFinished(cVar4.c());
                            arrayList2.remove(size6);
                            if (arrayList2.isEmpty()) {
                                this.f9356f.remove(arrayList2);
                            }
                            if (i7 < 0) {
                                break;
                            }
                            size6 = i7;
                        }
                    }
                    if (i6 < 0) {
                        break;
                    }
                    size5 = i6;
                }
            }
            int size7 = this.f9355e.size() - 1;
            if (size7 >= 0) {
                while (true) {
                    int i8 = size7 - 1;
                    ArrayList<RecyclerView.ViewHolder> arrayList3 = this.f9355e.get(size7);
                    kotlin.jvm.internal.s.g(arrayList3, "mAdditionsList[i]");
                    ArrayList<RecyclerView.ViewHolder> arrayList4 = arrayList3;
                    int size8 = arrayList4.size() - 1;
                    if (size8 >= 0) {
                        while (true) {
                            int i9 = size8 - 1;
                            RecyclerView.ViewHolder viewHolder4 = arrayList4.get(size8);
                            kotlin.jvm.internal.s.g(viewHolder4, "additions[j]");
                            RecyclerView.ViewHolder viewHolder5 = viewHolder4;
                            View view3 = viewHolder5.itemView;
                            kotlin.jvm.internal.s.g(view3, "item.itemView");
                            view3.setAlpha(1.0f);
                            dispatchAddFinished(viewHolder5);
                            arrayList4.remove(size8);
                            if (arrayList4.isEmpty()) {
                                this.f9355e.remove(arrayList4);
                            }
                            if (i9 < 0) {
                                break;
                            }
                            size8 = i9;
                        }
                    }
                    if (i8 < 0) {
                        break;
                    }
                    size7 = i8;
                }
            }
            int size9 = this.f9357g.size() - 1;
            if (size9 >= 0) {
                while (true) {
                    int i10 = size9 - 1;
                    ArrayList<a> arrayList5 = this.f9357g.get(size9);
                    kotlin.jvm.internal.s.g(arrayList5, "mChangesList[i]");
                    ArrayList<a> arrayList6 = arrayList5;
                    int size10 = arrayList6.size() - 1;
                    if (size10 >= 0) {
                        while (true) {
                            int i11 = size10 - 1;
                            a aVar2 = arrayList6.get(size10);
                            kotlin.jvm.internal.s.g(aVar2, "changes[j]");
                            f(aVar2);
                            if (arrayList6.isEmpty()) {
                                this.f9357g.remove(arrayList6);
                            }
                            if (i11 < 0) {
                                break;
                            }
                            size10 = i11;
                        }
                    }
                    if (i10 < 0) {
                        break;
                    }
                    size9 = i10;
                }
            }
            d(this.f9360j);
            d(this.f9359i);
            d(this.f9358h);
            d(this.f9361k);
            dispatchAnimationsFinished();
        }
    }

    public final ArrayList<RecyclerView.ViewHolder> h() {
        return this.f9358h;
    }

    public final ArrayList<RecyclerView.ViewHolder> i() {
        return this.f9361k;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.b.isEmpty() && this.f9354d.isEmpty() && this.c.isEmpty() && this.a.isEmpty() && this.f9359i.isEmpty() && this.f9360j.isEmpty() && this.f9358h.isEmpty() && this.f9361k.isEmpty() && this.f9356f.isEmpty() && this.f9355e.isEmpty() && this.f9357g.isEmpty()) ? false : true;
    }

    public final ArrayList<RecyclerView.ViewHolder> j() {
        return this.f9359i;
    }

    public final ArrayList<RecyclerView.ViewHolder> k() {
        return this.f9360j;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.a.isEmpty();
        boolean z2 = !this.c.isEmpty();
        boolean z3 = !this.f9354d.isEmpty();
        boolean z4 = !this.b.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.a.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder holder = it.next();
                kotlin.jvm.internal.s.g(holder, "holder");
                animateRemoveImpl(holder);
            }
            this.a.clear();
            if (z2) {
                final ArrayList<c> arrayList = new ArrayList<>();
                arrayList.addAll(this.c);
                this.f9356f.add(arrayList);
                this.c.clear();
                new Runnable() { // from class: us.pinguo.camera2020.view.adapter.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.o(arrayList, this);
                    }
                }.run();
            }
            if (z3) {
                final ArrayList<a> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f9354d);
                this.f9357g.add(arrayList2);
                this.f9354d.clear();
                Runnable runnable = new Runnable() { // from class: us.pinguo.camera2020.view.adapter.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.p(arrayList2, this);
                    }
                };
                if (z) {
                    RecyclerView.ViewHolder d2 = arrayList2.get(0).d();
                    kotlin.jvm.internal.s.e(d2);
                    ViewCompat.postOnAnimationDelayed(d2.itemView, runnable, getRemoveDuration());
                } else {
                    runnable.run();
                }
            }
            if (z4) {
                final ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.b);
                this.f9355e.add(arrayList3);
                this.b.clear();
                new Runnable() { // from class: us.pinguo.camera2020.view.adapter.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.q(arrayList3, this);
                    }
                }.run();
            }
        }
    }
}

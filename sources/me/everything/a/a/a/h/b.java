package me.everything.a.a.a.h;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* compiled from: RecyclerViewOverScrollDecorAdapter.java */
/* loaded from: classes9.dex */
public class b implements me.everything.a.a.a.h.a {
    protected final RecyclerView a;
    protected final a b;
    protected boolean c = false;

    /* compiled from: RecyclerViewOverScrollDecorAdapter.java */
    /* loaded from: classes9.dex */
    protected interface a {
        boolean a();

        boolean b();
    }

    /* compiled from: RecyclerViewOverScrollDecorAdapter.java */
    /* renamed from: me.everything.a.a.a.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    protected class C0327b implements a {
        protected C0327b() {
        }

        @Override // me.everything.a.a.a.h.b.a
        public boolean a() {
            return !b.this.a.canScrollHorizontally(1);
        }

        @Override // me.everything.a.a.a.h.b.a
        public boolean b() {
            return !b.this.a.canScrollHorizontally(-1);
        }
    }

    /* compiled from: RecyclerViewOverScrollDecorAdapter.java */
    /* loaded from: classes9.dex */
    protected class c implements a {
        protected c() {
        }

        @Override // me.everything.a.a.a.h.b.a
        public boolean a() {
            return !b.this.a.canScrollVertically(1);
        }

        @Override // me.everything.a.a.a.h.b.a
        public boolean b() {
            return !b.this.a.canScrollVertically(-1);
        }
    }

    public b(RecyclerView recyclerView) {
        int orientation;
        this.a = recyclerView;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z = layoutManager instanceof LinearLayoutManager;
        if (!z && !(layoutManager instanceof StaggeredGridLayoutManager)) {
            throw new IllegalArgumentException("Recycler views with custom layout managers are not supported by this adapter out of the box.Try implementing and providing an explicit 'impl' parameter to the other c'tors, or otherwise create a custom adapter subclass of your own.");
        }
        if (z) {
            orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        } else {
            orientation = ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        if (orientation == 0) {
            this.b = new C0327b();
        } else {
            this.b = new c();
        }
    }

    @Override // me.everything.a.a.a.h.a
    public boolean a() {
        return !this.c && this.b.a();
    }

    @Override // me.everything.a.a.a.h.a
    public boolean b() {
        return !this.c && this.b.b();
    }

    @Override // me.everything.a.a.a.h.a
    public View getView() {
        return this.a;
    }
}

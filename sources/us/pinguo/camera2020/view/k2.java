package us.pinguo.camera2020.view;

import java.lang.ref.WeakReference;
/* compiled from: InfiniteRecyclerView.kt */
/* loaded from: classes3.dex */
public final class k2 implements Runnable {
    private final WeakReference<InfiniteRecyclerView> a;

    public k2(InfiniteRecyclerView referent) {
        kotlin.jvm.internal.s.h(referent, "referent");
        this.a = new WeakReference<>(referent);
    }

    @Override // java.lang.Runnable
    public void run() {
        InfiniteRecyclerView infiniteRecyclerView = this.a.get();
        if (infiniteRecyclerView != null && infiniteRecyclerView.d() && infiniteRecyclerView.c()) {
            infiniteRecyclerView.scrollBy(2, 2);
            infiniteRecyclerView.postDelayed(infiniteRecyclerView.b(), 16L);
        }
    }
}

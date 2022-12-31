package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import com.facebook.drawee.components.DeferredReleaser;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeferredReleaserConcurrentImpl.java */
/* loaded from: classes.dex */
public class a extends DeferredReleaser {
    private final Object b = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f2480f = new RunnableC0092a();

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<DeferredReleaser.a> f2478d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<DeferredReleaser.a> f2479e = new ArrayList<>();
    private final Handler c = new Handler(Looper.getMainLooper());

    /* compiled from: DeferredReleaserConcurrentImpl.java */
    /* renamed from: com.facebook.drawee.components.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0092a implements Runnable {
        RunnableC0092a() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            synchronized (a.this.b) {
                ArrayList arrayList = a.this.f2479e;
                a aVar = a.this;
                aVar.f2479e = aVar.f2478d;
                a.this.f2478d = arrayList;
            }
            int size = a.this.f2479e.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((DeferredReleaser.a) a.this.f2479e.get(i2)).release();
            }
            a.this.f2479e.clear();
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void a(DeferredReleaser.a aVar) {
        synchronized (this.b) {
            this.f2478d.remove(aVar);
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    @AnyThread
    public void c(DeferredReleaser.a aVar) {
        if (!DeferredReleaser.b()) {
            aVar.release();
            return;
        }
        synchronized (this.b) {
            if (this.f2478d.contains(aVar)) {
                return;
            }
            this.f2478d.add(aVar);
            boolean z = true;
            if (this.f2478d.size() != 1) {
                z = false;
            }
            if (z) {
                this.c.post(this.f2480f);
            }
        }
    }
}

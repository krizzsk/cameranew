package us.pinguo.foundation.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.s;
/* compiled from: PGViewCompat.kt */
/* loaded from: classes4.dex */
public final class c {

    /* compiled from: PGViewCompat.kt */
    /* loaded from: classes4.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        final /* synthetic */ Runnable a;
        final /* synthetic */ View b;

        a(Runnable runnable, View view) {
            this.a = runnable;
            this.b = view;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.a.run();
            this.b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: PGViewCompat.kt */
    /* loaded from: classes4.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        final /* synthetic */ Runnable a;
        final /* synthetic */ View b;
        final /* synthetic */ boolean c;

        b(Runnable runnable, View view, boolean z) {
            this.a = runnable;
            this.b = view;
            this.c = z;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.a.run();
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            return this.c;
        }
    }

    public static final Bitmap a(View view) {
        s.h(view, "view");
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmap));
        s.g(bitmap, "bitmap");
        return bitmap;
    }

    public static final void b(View view, Runnable runnable) {
        s.h(view, "view");
        s.h(runnable, "runnable");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(runnable, view));
    }

    public static final void c(View view, Runnable runnable, boolean z) {
        s.h(view, "view");
        s.h(runnable, "runnable");
        view.getViewTreeObserver().addOnPreDrawListener(new b(runnable, view, z));
    }
}

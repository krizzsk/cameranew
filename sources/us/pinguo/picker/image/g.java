package us.pinguo.picker.image;

import android.graphics.Bitmap;
import com.pinguo.album.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.foundation.utils.y;
import us.pinguo.librouter.application.BaseApplication;
import us.pinguo.picker.image.gallery.j;
/* compiled from: PickManager.kt */
/* loaded from: classes5.dex */
public final class g {
    public static final g a = new g();
    private static final HashMap<b, a> b = new HashMap<>();
    private static boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f11682d = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PickManager.kt */
    /* loaded from: classes5.dex */
    public static final class a implements Runnable {
        private final b a;
        private final String b;
        private final int c;

        /* renamed from: d  reason: collision with root package name */
        private final l<Bitmap, u> f11683d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f11684e;

        /* compiled from: PickManager.kt */
        /* renamed from: us.pinguo.picker.image.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0429a implements a.c {
            C0429a() {
            }

            @Override // com.pinguo.album.a.c
            public void a(a.InterfaceC0229a listener) {
                s.h(listener, "listener");
            }

            @Override // com.pinguo.album.a.c
            public boolean b(int i2) {
                return false;
            }

            @Override // com.pinguo.album.a.c
            public boolean isCancelled() {
                return a.this.a() || !g.b.containsKey(a.this.b());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(b holder, String path, int i2, l<? super Bitmap, u> callback) {
            s.h(holder, "holder");
            s.h(path, "path");
            s.h(callback, "callback");
            this.a = holder;
            this.b = path;
            this.c = i2;
            this.f11683d = callback;
        }

        public final boolean a() {
            return this.f11684e;
        }

        public final b b() {
            return this.a;
        }

        public final void c(boolean z) {
            this.f11684e = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.b;
            int i2 = this.c;
            Bitmap d2 = new j.a(BaseApplication.e(), str, 2, str).a(new C0429a());
            if (i2 != 0) {
                try {
                    d2 = us.pinguo.util.e.p(d2, i2);
                } catch (Throwable unused) {
                }
            }
            if (d2 == null || !g.b.containsKey(this.a)) {
                return;
            }
            this.f11683d.invoke(d2);
        }
    }

    private g() {
    }

    private final void b() {
        for (Map.Entry<b, a> entry : b.entrySet()) {
            entry.getValue().c(true);
        }
        b.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(b holder, Runnable runnable) {
        s.h(holder, "$holder");
        return (runnable instanceof a) && ((a) runnable).b() == holder;
    }

    public final void c(b holder) {
        s.h(holder, "holder");
        a aVar = b.get(holder);
        if (aVar == null) {
            return;
        }
        aVar.c(true);
    }

    public final void e(final b holder, String path, int i2, l<? super Bitmap, u> callback) {
        s.h(holder, "holder");
        s.h(path, "path");
        s.h(callback, "callback");
        HashMap<b, a> hashMap = b;
        a aVar = hashMap.get(holder);
        if (aVar != null) {
            aVar.c(true);
        }
        PuzzleTask puzzleTask = PuzzleTask.a;
        y.e(puzzleTask.b().getQueue(), new y.a() { // from class: us.pinguo.picker.image.a
            @Override // us.pinguo.foundation.utils.y.a
            public final boolean test(Object obj) {
                boolean f2;
                f2 = g.f(b.this, (Runnable) obj);
                return f2;
            }
        });
        a aVar2 = new a(holder, path, i2, callback);
        hashMap.put(holder, aVar2);
        puzzleTask.b().execute(aVar2);
    }

    public final void g(boolean z) {
        f11682d = z;
        if (z && c) {
            b();
        }
    }

    public final void h(boolean z) {
        c = z;
        if (z && f11682d) {
            b();
        }
    }
}

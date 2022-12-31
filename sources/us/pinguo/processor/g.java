package us.pinguo.processor;

import java.util.concurrent.LinkedBlockingDeque;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: PhotoRenderer.kt */
/* loaded from: classes6.dex */
public final class g extends us.pinguo.processor.a implements Runnable {

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f11761g;

    /* renamed from: h  reason: collision with root package name */
    private final LinkedBlockingDeque<a> f11762h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f11763i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11764j;

    /* compiled from: PhotoRenderer.kt */
    /* loaded from: classes6.dex */
    public static final class a {
        private final String a;
        private final byte[] b;
        private final String c;

        /* renamed from: d  reason: collision with root package name */
        private final d f11765d;

        /* renamed from: e  reason: collision with root package name */
        private final h f11766e;

        public final h a() {
            return this.f11766e;
        }

        public final byte[] b() {
            return this.b;
        }

        public final d c() {
            return this.f11765d;
        }

        public final String d() {
            return this.c;
        }

        public final String e() {
            return this.a;
        }
    }

    public g(byte[] shader) {
        s.h(shader, "shader");
        this.f11761g = shader;
        this.f11762h = new LinkedBlockingDeque<>();
        this.f11763i = new Object();
    }

    private final boolean l(String str, byte[] bArr, String str2, d dVar) {
        boolean i2;
        j e2 = e();
        if (e2 == null) {
            return false;
        }
        if (str != null) {
            i2 = e2.j(0, str);
        } else {
            i2 = bArr != null ? e2.i(0, bArr) : false;
        }
        if (i2 && us.pinguo.processor.a.h(this, dVar, 0, false, 4, null)) {
            boolean d2 = e2.d(str2, 95);
            e2.b(0);
            e2.c();
            return d2;
        }
        return false;
    }

    @Override // java.lang.Runnable
    public void run() {
        a pollFirst;
        b();
        f(this.f11761g);
        while (!this.f11764j) {
            synchronized (this.f11763i) {
                pollFirst = this.f11762h.pollFirst();
                if (pollFirst == null) {
                    try {
                        this.f11763i.wait();
                    } catch (InterruptedException unused) {
                    }
                }
                u uVar = u.a;
            }
            if (this.f11764j) {
                break;
            }
            a aVar = pollFirst;
            if (aVar != null) {
                if (l(aVar.e(), aVar.b(), aVar.d(), aVar.c())) {
                    aVar.a().a(aVar.d());
                } else {
                    aVar.a().a(null);
                }
            }
        }
        d();
        c();
    }
}

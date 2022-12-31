package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import kotlin.u;
import kotlin.z.j;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.i2;
import kotlinx.coroutines.p;
import kotlinx.coroutines.u0;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z0;
/* compiled from: HandlerDispatcher.kt */
/* loaded from: classes3.dex */
public final class HandlerContext extends kotlinx.coroutines.android.a implements u0 {
    private volatile HandlerContext _immediate;
    private final Handler a;
    private final String b;
    private final boolean c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerContext f8694d;

    /* compiled from: Job.kt */
    /* loaded from: classes3.dex */
    public static final class a implements b1 {
        final /* synthetic */ Runnable b;

        public a(Runnable runnable) {
            this.b = runnable;
        }

        @Override // kotlinx.coroutines.b1
        public void dispose() {
            HandlerContext.this.a.removeCallbacks(this.b);
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes3.dex */
    public static final class b implements Runnable {
        final /* synthetic */ p a;
        final /* synthetic */ HandlerContext b;

        public b(p pVar, HandlerContext handlerContext) {
            this.a = pVar;
            this.b = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.B(this.b, u.a);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.a = handler;
        this.b = str;
        this.c = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
            u uVar = u.a;
        }
        this.f8694d = handlerContext;
    }

    private final void R(CoroutineContext coroutineContext, Runnable runnable) {
        y1.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        z0.b().dispatch(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.g2
    /* renamed from: S */
    public HandlerContext z() {
        return this.f8694d;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.a.post(runnable)) {
            return;
        }
        R(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.u0
    public void e(long j2, p<? super u> pVar) {
        long d2;
        b bVar = new b(pVar, this);
        Handler handler = this.a;
        d2 = j.d(j2, 4611686018427387903L);
        if (handler.postDelayed(bVar, d2)) {
            pVar.e(new HandlerContext$scheduleResumeAfterDelay$1(this, bVar));
        } else {
            R(pVar.getContext(), bVar);
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).a == this.a;
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.c && s.c(Looper.myLooper(), this.a.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.android.a, kotlinx.coroutines.u0
    public b1 m(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        long d2;
        Handler handler = this.a;
        d2 = j.d(j2, 4611686018427387903L);
        if (handler.postDelayed(runnable, d2)) {
            return new a(runnable);
        }
        R(coroutineContext, runnable);
        return i2.a;
    }

    @Override // kotlinx.coroutines.g2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String A = A();
        if (A == null) {
            String str = this.b;
            if (str == null) {
                str = this.a.toString();
            }
            return this.c ? s.q(str, ".immediate") : str;
        }
        return A;
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, o oVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}

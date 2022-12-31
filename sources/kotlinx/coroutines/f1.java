package kotlinx.coroutines;

import androidx.core.location.LocationRequestCompat;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class f1 extends CoroutineDispatcher {
    private long a;
    private boolean b;
    private kotlinx.coroutines.internal.a<w0<?>> c;

    private final long A(boolean z) {
        if (z) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    public static /* synthetic */ void T(f1 f1Var, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        f1Var.S(z);
    }

    public static /* synthetic */ void z(f1 f1Var, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i2 & 1) != 0) {
            z = false;
        }
        f1Var.s(z);
    }

    public final void Q(w0<?> w0Var) {
        kotlinx.coroutines.internal.a<w0<?>> aVar = this.c;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a<>();
            this.c = aVar;
        }
        aVar.a(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long R() {
        kotlinx.coroutines.internal.a<w0<?>> aVar = this.c;
        if (aVar == null || aVar.c()) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        return 0L;
    }

    public final void S(boolean z) {
        this.a += A(z);
        if (z) {
            return;
        }
        this.b = true;
    }

    public final boolean U() {
        return this.a >= A(true);
    }

    public final boolean V() {
        kotlinx.coroutines.internal.a<w0<?>> aVar = this.c;
        if (aVar == null) {
            return true;
        }
        return aVar.c();
    }

    public long W() {
        if (X()) {
            return 0L;
        }
        return LocationRequestCompat.PASSIVE_INTERVAL;
    }

    public final boolean X() {
        w0<?> d2;
        kotlinx.coroutines.internal.a<w0<?>> aVar = this.c;
        if (aVar == null || (d2 = aVar.d()) == null) {
            return false;
        }
        d2.run();
        return true;
    }

    public boolean Y() {
        return false;
    }

    public final void s(boolean z) {
        long A = this.a - A(z);
        this.a = A;
        if (A > 0) {
            return;
        }
        if (o0.a()) {
            if (!(this.a == 0)) {
                throw new AssertionError();
            }
        }
        if (this.b) {
            shutdown();
        }
    }

    protected void shutdown() {
    }
}

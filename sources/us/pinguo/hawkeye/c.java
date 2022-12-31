package us.pinguo.hawkeye;

import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.s;
/* compiled from: Metronome.kt */
@RequiresApi(16)
/* loaded from: classes4.dex */
public final class c implements Choreographer.FrameCallback {
    private final Choreographer a;

    public c() {
        Choreographer choreographer = Choreographer.getInstance();
        s.d(choreographer, "Choreographer.getInstance()");
        this.a = choreographer;
    }

    public final void a() {
        this.a.postFrameCallback(this);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        b.f11145f.b(j2);
        this.a.postFrameCallback(this);
    }
}

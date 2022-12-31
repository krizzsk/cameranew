package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RenderTask.java */
/* loaded from: classes3.dex */
public class k extends l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(c cVar) {
        super(cVar);
    }

    @Override // pl.droidsonroids.gif.l
    public void a() {
        c cVar = this.a;
        long renderFrame = cVar.f8981g.renderFrame(cVar.f8980f);
        if (renderFrame >= 0) {
            this.a.c = SystemClock.uptimeMillis() + renderFrame;
            if (this.a.isVisible() && this.a.b) {
                c cVar2 = this.a;
                if (!cVar2.f8986l) {
                    cVar2.a.remove(this);
                    c cVar3 = this.a;
                    cVar3.p = cVar3.a.schedule(this, renderFrame, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.a.f8982h.isEmpty() && this.a.c() == this.a.f8981g.getNumberOfFrames() - 1) {
                c cVar4 = this.a;
                cVar4.m.sendEmptyMessageAtTime(cVar4.d(), this.a.c);
            }
        } else {
            c cVar5 = this.a;
            cVar5.c = Long.MIN_VALUE;
            cVar5.b = false;
        }
        if (!this.a.isVisible() || this.a.m.hasMessages(-1)) {
            return;
        }
        this.a.m.sendEmptyMessageAtTime(-1, 0L);
    }
}

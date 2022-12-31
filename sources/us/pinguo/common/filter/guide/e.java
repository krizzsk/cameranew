package us.pinguo.common.filter.guide;

import android.view.GestureDetector;
import android.view.MotionEvent;
import kotlin.jvm.b.l;
import kotlin.u;
/* compiled from: GuideUtil.kt */
/* loaded from: classes4.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {
    private l<? super MotionEvent, u> a;
    private kotlin.jvm.b.a<u> b;

    public final void a(l<? super MotionEvent, u> lVar) {
        this.a = lVar;
    }

    public final void b(kotlin.jvm.b.a<u> aVar) {
        this.b = aVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        l<? super MotionEvent, u> lVar = this.a;
        if (lVar == null) {
            return;
        }
        lVar.invoke(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        kotlin.jvm.b.a<u> aVar = this.b;
        if (aVar == null) {
            return true;
        }
        aVar.invoke();
        return true;
    }
}

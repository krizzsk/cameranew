package us.pinguo.repository2020;

import androidx.lifecycle.Observer;
import us.pinguo.cameramanger.info.CameraFrame;
/* compiled from: lambda */
/* loaded from: classes6.dex */
public final /* synthetic */ class i implements Observer {
    public static final /* synthetic */ i a = new i();

    private /* synthetic */ i() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        m.f((CameraFrame) obj);
    }
}

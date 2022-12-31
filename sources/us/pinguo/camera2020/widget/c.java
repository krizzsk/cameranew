package us.pinguo.camera2020.widget;

import android.view.MotionEvent;
import android.view.View;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnTouchListener {
    public static final /* synthetic */ c a = new c();

    private /* synthetic */ c() {
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        z = ParameterAdvanceSettingView.z(view, motionEvent);
        return z;
    }
}

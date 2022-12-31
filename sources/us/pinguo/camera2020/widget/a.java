package us.pinguo.camera2020.widget;

import android.view.animation.Interpolator;
/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Interpolator {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return CameraModeSwitchLayout.j(f2);
    }
}

package us.pinguo.camera2020.utils;

import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
/* compiled from: FaceOrientationUtils.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public final int a(boolean z, int i2, int i3) {
        return (!z || i3 == 0 || i3 == 180) ? i2 + i3 : i2 + i3 + BaseBlurEffect.ROTATION_180;
    }
}

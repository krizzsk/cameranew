package us.pinguo.cameramanger;

import android.hardware.Camera;
import android.util.Rational;
import kotlin.jvm.internal.s;
import us.pinguo.cameramanger.info.LensFacing;
/* compiled from: Constants.kt */
/* loaded from: classes4.dex */
public final class d {
    private static final Rational a;
    private static final Rational b;

    static {
        new Rational(2, 1);
        a = new Rational(16, 9);
        b = new Rational(4, 3);
        new Rational(1, 1);
    }

    public static final LensFacing a(Camera.CameraInfo cameraInfo) {
        s.h(cameraInfo, "<this>");
        if (cameraInfo.facing == 1) {
            return LensFacing.FRONT;
        }
        return LensFacing.BACK;
    }

    public static final Rational b() {
        return a;
    }

    public static final Rational c() {
        return b;
    }
}

package us.pinguo.facedetector;

import android.content.Context;
import android.graphics.Bitmap;
/* compiled from: IFaceDetector.kt */
/* loaded from: classes4.dex */
public interface d {
    Config a();

    void b();

    void c(Config config);

    c d(byte[] bArr, int i2, int i3, ImageMode imageMode);

    boolean e(Context context, byte[] bArr);

    c f(Bitmap bitmap);
}

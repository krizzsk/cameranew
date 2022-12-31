package us.pinguo.edit2020.view;

import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.List;
/* compiled from: ICanvasView.kt */
/* loaded from: classes4.dex */
public interface d0 {

    /* compiled from: ICanvasView.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    /* compiled from: ICanvasView.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        public static /* synthetic */ void a(d0 d0Var, int i2, float f2, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animationToCenter");
            }
            if ((i3 & 2) != 0) {
                f2 = 1.0f;
            }
            d0Var.a(i2, f2);
        }
    }

    static {
        a aVar = a.a;
    }

    void a(int i2, float f2);

    Bitmap b();

    Bitmap c();

    void setFaceRectList(List<Rect> list);

    void setImageRestorationBitmap(Bitmap bitmap);

    void setRate(float f2);

    void setSrcBitmap(Bitmap bitmap);
}

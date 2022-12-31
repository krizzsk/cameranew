package us.pinguo.inspire.widget.fresco;

import android.graphics.Paint;
import kotlin.jvm.internal.Lambda;
import us.pinguo.foundation.e;
import us.pinguo.ui.R;
/* compiled from: GaussianBlurDrawable.kt */
/* loaded from: classes9.dex */
final class GaussianBlurDrawable$bgPaint$2 extends Lambda implements kotlin.jvm.b.a<Paint> {
    public static final GaussianBlurDrawable$bgPaint$2 INSTANCE = new GaussianBlurDrawable$bgPaint$2();

    GaussianBlurDrawable$bgPaint$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final Paint invoke() {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(e.b().getResources().getColor(R.color.inspire_loading_color));
        return paint;
    }
}

package us.pinguo.edit2020.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.jvm.internal.Lambda;
import us.pinguo.edit2020.R;
/* compiled from: CheckMarkCircleView.kt */
/* loaded from: classes4.dex */
final class CheckMarkCircleView$checkMarkResource$2 extends Lambda implements kotlin.jvm.b.a<Bitmap> {
    public static final CheckMarkCircleView$checkMarkResource$2 INSTANCE = new CheckMarkCircleView$checkMarkResource$2();

    CheckMarkCircleView$checkMarkResource$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final Bitmap invoke() {
        return BitmapFactory.decodeResource(us.pinguo.foundation.e.b().getResources(), R.drawable.ic_selected_small);
    }
}

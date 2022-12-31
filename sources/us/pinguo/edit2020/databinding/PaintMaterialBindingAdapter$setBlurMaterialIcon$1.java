package us.pinguo.edit2020.databinding;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import us.pinguo.common.widget.WaterFillingView;
import us.pinguo.edit2020.R;
/* compiled from: PaintMaterialBindingAdapter.kt */
/* loaded from: classes4.dex */
final class PaintMaterialBindingAdapter$setBlurMaterialIcon$1 extends Lambda implements kotlin.jvm.b.l<Bitmap, u> {
    final /* synthetic */ Integer $blurProgress;
    final /* synthetic */ Boolean $isSelected;
    final /* synthetic */ WaterFillingView $view;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaintMaterialBindingAdapter$setBlurMaterialIcon$1(WaterFillingView waterFillingView, Integer num, Boolean bool) {
        super(1);
        this.$view = waterFillingView;
        this.$blurProgress = num;
        this.$isSelected = bool;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ u invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return u.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Bitmap bitmap) {
        if (bitmap != null) {
            this.$view.setSrcBitmap(bitmap);
            WaterFillingView waterFillingView = this.$view;
            Integer num = this.$blurProgress;
            waterFillingView.setProgress(num == null ? 0 : num.intValue());
            WaterFillingView waterFillingView2 = this.$view;
            Boolean bool = this.$isSelected;
            waterFillingView2.setSelect(bool != null ? bool.booleanValue() : false);
            return;
        }
        WaterFillingView waterFillingView3 = this.$view;
        waterFillingView3.setSrcBitmap(BitmapFactory.decodeResource(waterFillingView3.getResources(), R.drawable.ic_grey_logo));
    }
}

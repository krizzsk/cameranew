package us.pinguo.edit2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.edit2020.R;
/* compiled from: ImageCompareAdjustView.kt */
/* loaded from: classes4.dex */
public final class ImageCompareAdjustView extends ConstraintLayout {
    public Map<Integer, View> a;
    private kotlin.jvm.b.l<? super Float, kotlin.u> b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageCompareAdjustView(Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageCompareAdjustView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageCompareAdjustView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this.a;
        View view = map.get(Integer.valueOf(i2));
        if (view == null) {
            View findViewById = findViewById(i2);
            if (findViewById == null) {
                return null;
            }
            map.put(Integer.valueOf(i2), findViewById);
            return findViewById;
        }
        return view;
    }

    public final kotlin.jvm.b.l<Float, kotlin.u> g() {
        return this.b;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((ImageCompareSliderView) _$_findCachedViewById(R.id.imageCompareSlider)).setOnCompareSlide(new ImageCompareAdjustView$onFinishInflate$1(this));
    }

    public final void setOnCompareSlide(kotlin.jvm.b.l<? super Float, kotlin.u> lVar) {
        this.b = lVar;
    }

    public /* synthetic */ ImageCompareAdjustView(Context context, AttributeSet attributeSet, int i2, int i3, kotlin.jvm.internal.o oVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}

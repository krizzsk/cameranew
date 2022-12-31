package us.pinguo.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
/* compiled from: RatioWebpAnimImageView.kt */
/* loaded from: classes4.dex */
public class RatioWebpAnimImageView extends SimpleDraweeView {

    /* renamed from: i  reason: collision with root package name */
    private float f9973i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RatioWebpAnimImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
        l(context, attributeSet);
    }

    private final void l(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, us.pinguo.commonui.R.styleable.RatioImageView);
        s.g(obtainStyledAttributes, "context.obtainStyledAttr…styleable.RatioImageView)");
        this.f9973i = obtainStyledAttributes.getFloat(us.pinguo.commonui.R.styleable.RatioImageView_aspectRatio, 0.0f);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.drawee.view.DraweeView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f9973i > 0.0f) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) ((size / this.f9973i) + 0.5f), 1073741824);
            }
        }
        super.onMeasure(i2, i3);
        us.pinguo.common.log.a.k("mRatio = " + this.f9973i + " width = " + getMeasuredWidth() + "height = " + getMeasuredHeight(), new Object[0]);
    }
}

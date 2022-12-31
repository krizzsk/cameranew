package us.pinguo.inspire_proxy.media;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
/* loaded from: classes4.dex */
public class FixedRateTextureView extends BaseVideoTextureView implements us.pinguo.ui.widget.video.e {

    /* renamed from: i  reason: collision with root package name */
    private float f11486i;

    /* renamed from: j  reason: collision with root package name */
    private int f11487j;

    /* renamed from: k  reason: collision with root package name */
    private int f11488k;

    /* renamed from: l  reason: collision with root package name */
    private volatile int f11489l;

    public FixedRateTextureView(Context context) {
        super(context);
        this.f11486i = 1.0f;
    }

    public int d() {
        return this.f11489l;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size;
        int i4;
        if (this.f11486i < 0.0f) {
            int size2 = View.MeasureSpec.getSize(i2);
            if (this.f11488k > 0 && this.f11487j > 0 && size2 > 0 && View.MeasureSpec.getMode(i2) == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec((int) (size2 * (this.f11487j / this.f11488k)), 1073741824);
            }
            super.onMeasure(i2, i3);
            return;
        }
        if (this.f11489l != 90 && this.f11489l != 270) {
            i4 = View.MeasureSpec.getSize(i2);
            size = (int) (i4 / this.f11486i);
        } else {
            size = View.MeasureSpec.getSize(i2);
            i4 = (int) (size * this.f11486i);
        }
        setRotation(this.f11489l);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(size, 1073741824));
    }

    @Override // us.pinguo.ui.widget.video.e
    public void setFixRotation(int i2) {
    }

    public void setRate(float f2) {
        this.f11486i = f2;
    }

    public void setVideoSize(int i2, int i3) {
        this.f11487j = i3;
        this.f11488k = i2;
    }

    public void setRate(float f2, int i2) {
        this.f11486i = f2;
        this.f11489l = i2;
    }

    public FixedRateTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f11486i = 1.0f;
    }

    public FixedRateTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11486i = 1.0f;
    }
}

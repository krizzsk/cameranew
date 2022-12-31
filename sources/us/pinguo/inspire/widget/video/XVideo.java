package us.pinguo.inspire.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
/* loaded from: classes9.dex */
public class XVideo extends BaseVideoTextureView {

    /* renamed from: i  reason: collision with root package name */
    private int f11479i;

    /* renamed from: j  reason: collision with root package name */
    private int f11480j;

    public XVideo(Context context) {
        super(context);
        this.f11479i = -1;
        this.f11480j = -1;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i5 = this.f11479i;
        if (i5 != -1 && (i4 = this.f11480j) != -1) {
            float min = Math.min((size * 1.0f) / i5, (size2 * 1.0f) / i4);
            setMeasuredDimension((int) (this.f11479i * min), (int) (this.f11480j * min));
            return;
        }
        setMeasuredDimension(size, size);
    }

    public void setVideoSize(int i2, int i3) {
        int i4 = this.f11479i;
        int i5 = this.f11480j;
        this.f11479i = i2;
        this.f11480j = i3;
        if (i2 == i4 && i3 == i5) {
            return;
        }
        requestLayout();
    }

    public XVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11479i = -1;
        this.f11480j = -1;
    }

    public XVideo(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11479i = -1;
        this.f11480j = -1;
    }
}

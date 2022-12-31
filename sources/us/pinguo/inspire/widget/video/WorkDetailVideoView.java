package us.pinguo.inspire.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.Key;
import us.pinguo.inspire_proxy.media.i;
import us.pinguo.ui.widget.video.BaseVideoTextureView;
import us.pinguo.ui.widget.video.e;
/* loaded from: classes9.dex */
public class WorkDetailVideoView extends BaseVideoTextureView implements e {

    /* renamed from: i  reason: collision with root package name */
    private int f11475i;

    /* renamed from: j  reason: collision with root package name */
    private int f11476j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f11477k;

    /* renamed from: l  reason: collision with root package name */
    private float f11478l;

    public WorkDetailVideoView(Context context) {
        super(context);
        this.f11475i = -1;
        this.f11476j = -1;
        f();
    }

    private void f() {
        new i(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void h(int i2) {
        us.pinguo.common.log.a.m(Key.ROTATION, toString() + "   " + String.valueOf(i2), new Object[0]);
        float f2 = (float) i2;
        super.setRotation(f2);
        this.f11477k = true;
        this.f11478l = f2;
        requestLayout();
    }

    public void e() {
        super.setRotation(0.0f);
        this.f11477k = false;
        this.f11478l = 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5 = this.f11475i;
        if (i5 != -1 && (i4 = this.f11476j) != -1) {
            if (((((int) this.f11478l) / 90) & 1) == 1) {
                setMeasuredDimension(i4, i5);
                return;
            } else {
                setMeasuredDimension(i5, i4);
                return;
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // us.pinguo.ui.widget.video.e
    public void setFixRotation(final int i2) {
        if (((i2 / 90) & 1) != 1 || this.f11477k) {
            return;
        }
        post(new Runnable() { // from class: us.pinguo.inspire.widget.video.a
            @Override // java.lang.Runnable
            public final void run() {
                WorkDetailVideoView.this.h(i2);
            }
        });
    }

    public void setVideoSize(int i2, int i3) {
        int i4 = this.f11475i;
        int i5 = this.f11476j;
        this.f11475i = i2;
        this.f11476j = i3;
        if (i2 == i4 && i3 == i5) {
            return;
        }
        requestLayout();
    }

    public WorkDetailVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11475i = -1;
        this.f11476j = -1;
        f();
    }

    public WorkDetailVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11475i = -1;
        this.f11476j = -1;
        f();
    }
}

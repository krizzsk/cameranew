package us.pinguo.camera2020.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.Map;
import us.pinguo.camera2020.R;
import us.pinguo.camera2020.view.focusview.PGSeekBar;
import us.pinguo.camera2020.view.focusview.ZoomSeekBar;
/* compiled from: CameraZoomLayout.kt */
/* loaded from: classes3.dex */
public final class CameraZoomLayout extends ConstraintLayout implements PGSeekBar.b, q2 {
    public Map<Integer, View> a;
    private final n2 b;
    private us.pinguo.camera2020.view.focusview.b c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9294d;

    /* renamed from: e  reason: collision with root package name */
    private float f9295e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CameraZoomLayout(Context context) {
        this(context, null);
        kotlin.jvm.internal.s.h(context, "context");
    }

    private final void g(float f2) {
        k(f2);
        show();
        us.pinguo.camera2020.view.focusview.b bVar = this.c;
        if (bVar == null) {
            return;
        }
        bVar.N(f2);
    }

    private final void k(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.f9295e = f2;
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

    @Override // us.pinguo.camera2020.view.q2
    public void a() {
        if (this.f9294d) {
            this.b.removeMessages(1);
            this.b.sendEmptyMessage(1);
        }
    }

    @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
    public void b() {
    }

    @Override // us.pinguo.camera2020.view.q2
    public void c(float f2) {
        g(this.f9295e + f2);
        ((ZoomSeekBar) _$_findCachedViewById(R.id.sbZoomSeekbar)).setCurrentSeekRate(this.f9295e);
    }

    @Override // us.pinguo.camera2020.view.focusview.PGSeekBar.b
    public void d(PGSeekBar seekBar, float f2) {
        kotlin.jvm.internal.s.h(seekBar, "seekBar");
        g(f2);
    }

    @Override // us.pinguo.camera2020.view.q2
    public boolean e() {
        return this.f9294d;
    }

    public void h() {
        if (this.f9294d) {
            this.b.removeMessages(1);
            this.b.sendEmptyMessage(3);
        }
    }

    public final boolean i() {
        return this.f9294d;
    }

    public final void j() {
        k(0.0f);
        ((ZoomSeekBar) _$_findCachedViewById(R.id.sbZoomSeekbar)).w();
        a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        ((ZoomSeekBar) _$_findCachedViewById(R.id.sbZoomSeekbar)).setOnSeekBarChangeListener(this);
    }

    public final void setZoomCallBack(us.pinguo.camera2020.view.focusview.b zoomCallback) {
        kotlin.jvm.internal.s.h(zoomCallback, "zoomCallback");
        this.c = zoomCallback;
    }

    public final void setZoomSupport(boolean z) {
        this.f9294d = z;
    }

    @Override // us.pinguo.camera2020.view.q2
    public void show() {
        if (this.f9294d) {
            this.b.removeMessages(1);
            this.b.sendEmptyMessage(2);
            this.b.sendEmptyMessageDelayed(1, 3000L);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraZoomLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new n2(this);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CameraZoomLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.s.h(context, "context");
        this.a = new LinkedHashMap();
        this.b = new n2(this);
    }
}

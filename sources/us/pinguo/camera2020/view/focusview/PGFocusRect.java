package us.pinguo.camera2020.view.focusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.pinguo.camera360.effect.model.entity.layer.BaseBlurEffect;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.s;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
/* compiled from: PGFocusRect.kt */
/* loaded from: classes3.dex */
public final class PGFocusRect extends PGFocusShape {
    private float A;
    private float B;
    private float C;
    private a D;
    private final int t;
    private RectF u;
    private float v;
    private float w;
    private float x;
    private boolean y;
    private float z;

    /* compiled from: PGFocusRect.kt */
    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void b();

        void c(int i2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PGFocusRect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s.h(context, "context");
        new LinkedHashMap();
        this.t = 6;
        this.x = 1.2f;
        this.z = 90.0f;
        this.A = 270.0f;
        this.C = 180.0f;
    }

    private final void u(Canvas canvas) {
        if (this.D == null) {
            return;
        }
        float f2 = this.B;
        if (f2 > 180.0f) {
            return;
        }
        if (canvas != null) {
            RectF rectF = this.u;
            if (rectF == null) {
                s.z("rectF");
                throw null;
            }
            canvas.drawArc(rectF, this.z, f2, false, i());
        }
        if (canvas != null) {
            RectF rectF2 = this.u;
            if (rectF2 == null) {
                s.z("rectF");
                throw null;
            }
            canvas.drawArc(rectF2, this.A, this.B, false, i());
        }
        this.B += this.t;
        q(j() + 0.1f);
        if (j() >= 4.0f) {
            q(4.0f);
        }
        float f3 = this.x - 0.01f;
        this.x = f3;
        if (f3 <= 1.0f) {
            this.x = 1.0f;
        }
        if (this.B <= 180.0f) {
            invalidate();
            return;
        }
        this.B = 181.0f;
        a aVar = this.D;
        if (aVar != null) {
            aVar.b();
        }
        this.y = true;
        p(0);
        s(System.currentTimeMillis());
        invalidate();
    }

    private final void v(Canvas canvas) {
        if (this.y) {
            if (canvas != null) {
                float f2 = this.x;
                canvas.scale(f2, f2, e(), f());
            }
            if (this.B >= 180.0f && canvas != null) {
                RectF rectF = this.u;
                if (rectF == null) {
                    s.z("rectF");
                    throw null;
                } else {
                    float f3 = this.C;
                    canvas.drawRoundRect(rectF, f3, f3, i());
                }
            }
            if (g() >= 0) {
                invalidate();
            }
        }
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void b() {
        if (this.D == null) {
            return;
        }
        if (this.y || g() == -1) {
            a aVar = this.D;
            if (aVar != null) {
                aVar.c(g());
            }
            long h2 = h();
            int g2 = g();
            if (g2 != 0) {
                if (g2 != 1) {
                    return;
                }
                if (this.C > 0.0f) {
                    this.C = 0.0f;
                }
                a aVar2 = this.D;
                if (aVar2 == null) {
                    return;
                }
                aVar2.a();
                return;
            }
            long j2 = h2 / 150;
            float f2 = (float) j2;
            float f3 = (0.2f * f2) + 0.9f;
            this.x = f3;
            if (f3 >= 1.1d) {
                this.x = 1.1f;
            }
            this.C = 180.0f - ((float) (j2 * ((long) BaseBlurEffect.ROTATION_180)));
            r(4 - f2);
            if (m() <= 3.0f) {
                r(3.0f);
            }
        }
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void c(Canvas canvas) {
        v(canvas);
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void d(Canvas canvas) {
        u(canvas);
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public long h() {
        long currentTimeMillis = System.currentTimeMillis() - n();
        int i2 = (currentTimeMillis > 300L ? 1 : (currentTimeMillis == 300L ? 0 : -1));
        if (i2 <= 0) {
            p(0);
            return currentTimeMillis;
        } else if (i2 > 0 && currentTimeMillis <= 400) {
            long j2 = currentTimeMillis - ((long) IjkMediaCodecInfo.RANK_SECURE);
            p(1);
            return j2;
        } else if (currentTimeMillis > 400) {
            p(-1);
            return currentTimeMillis;
        } else {
            return currentTimeMillis;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        float f2 = 2;
        this.v = (e() * f2) - getPaddingRight();
        this.w = (f() * f2) - getPaddingBottom();
        this.u = new RectF(getPaddingLeft(), getPaddingTop(), this.v, this.w);
    }

    public final void setAnimationStateListener(a stateListener) {
        s.h(stateListener, "stateListener");
        this.D = stateListener;
    }

    @Override // us.pinguo.camera2020.view.focusview.PGFocusShape
    public void t() {
        setIsStop(false);
        p(-1);
        this.B = 0.0f;
        this.C = 180.0f;
        invalidate();
    }
}

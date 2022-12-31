package us.pinguo.edit2020.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import kotlin.collections.h0;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
import us.pinguo.edit2020.R;
import us.pinguo.edit2020.viewmodel.module.BoldType;
/* compiled from: AreaProtectionBoldAdjustView.kt */
/* loaded from: classes4.dex */
public final class AreaProtectionBoldAdjustView extends View {
    private BoldType A;
    private final Paint a;
    private final int b;
    private final float c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f10907d;

    /* renamed from: e  reason: collision with root package name */
    private final float f10908e;

    /* renamed from: f  reason: collision with root package name */
    private final float f10909f;

    /* renamed from: g  reason: collision with root package name */
    private float f10910g;

    /* renamed from: h  reason: collision with root package name */
    private float f10911h;

    /* renamed from: i  reason: collision with root package name */
    private float f10912i;

    /* renamed from: j  reason: collision with root package name */
    private final float f10913j;

    /* renamed from: k  reason: collision with root package name */
    private final float f10914k;

    /* renamed from: l  reason: collision with root package name */
    private final float f10915l;
    private final float m;
    private final float n;
    private float o;
    private final float[] p;
    private final l<Float, Float>[] q;
    private final l<Float, Float>[] r;
    private l<Float, Float>[] s;
    private float t;
    private boolean u;
    private ValueAnimator v;
    private final BoldType[] w;
    private l<? super us.pinguo.edit2020.viewmodel.module.c, u> x;
    private l<? super Integer, u> y;
    private final us.pinguo.edit2020.viewmodel.module.c z;

    /* compiled from: AreaProtectionBoldAdjustView.kt */
    /* loaded from: classes4.dex */
    public static final class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            s.h(animation, "animation");
            float[] fArr = AreaProtectionBoldAdjustView.this.p;
            AreaProtectionBoldAdjustView areaProtectionBoldAdjustView = AreaProtectionBoldAdjustView.this;
            int length = fArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                if (fArr[i2] == areaProtectionBoldAdjustView.t) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return;
            }
            BoldType boldType = AreaProtectionBoldAdjustView.this.h()[i2];
            us.pinguo.edit2020.viewmodel.module.c g2 = AreaProtectionBoldAdjustView.this.g();
            g2.i(true);
            g2.g(boldType.getScaleFactor());
            if (boldType != AreaProtectionBoldAdjustView.this.A) {
                AreaProtectionBoldAdjustView.this.A = boldType;
                g2.f(boldType);
                g2.j(true);
            }
            l<us.pinguo.edit2020.viewmodel.module.c, u> i3 = AreaProtectionBoldAdjustView.this.i();
            if (i3 == null) {
                return;
            }
            i3.invoke(g2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaProtectionBoldAdjustView(Context context) {
        super(context);
        s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.rgb(228, 227, 227);
        Context context2 = getContext();
        s.g(context2, "context");
        float b = us.pinguo.util.g.b(context2, 2.0f);
        this.c = b;
        Context context3 = getContext();
        s.g(context3, "context");
        Context context4 = getContext();
        s.g(context4, "context");
        Context context5 = getContext();
        s.g(context5, "context");
        Context context6 = getContext();
        s.g(context6, "context");
        Context context7 = getContext();
        s.g(context7, "context");
        float[] fArr = {us.pinguo.util.g.b(context3, 3.0f), us.pinguo.util.g.b(context4, 4.0f), us.pinguo.util.g.b(context5, 5.0f), us.pinguo.util.g.b(context6, 6.0f), us.pinguo.util.g.b(context7, 7.0f)};
        this.f10907d = fArr;
        Context context8 = getContext();
        s.g(context8, "context");
        float b2 = us.pinguo.util.g.b(context8, 10.0f);
        this.f10908e = b2;
        Context context9 = getContext();
        s.g(context9, "context");
        float b3 = us.pinguo.util.g.b(context9, 1.0f);
        this.f10909f = b3;
        Context context10 = getContext();
        s.g(context10, "context");
        this.f10910g = us.pinguo.util.g.b(context10, 200.0f) + (b3 * 2.0f);
        this.f10911h = getResources().getDimension(R.dimen.user_operation_height);
        this.f10912i = (((((((((this.f10910g - (b3 * 2.0f)) - b) - (b2 - fArr[0])) - (b2 - fArr[4])) - (fArr[0] * 2.0f)) - (fArr[1] * 2.0f)) - (fArr[2] * 2.0f)) - (fArr[3] * 2.0f)) - (fArr[4] * 2.0f)) / 4.0f;
        Context context11 = getContext();
        s.g(context11, "context");
        this.f10913j = us.pinguo.util.g.b(context11, 32.0f);
        float f2 = (b * 0.5f) + b3 + b2;
        this.f10914k = f2;
        float f3 = this.f10912i;
        float f4 = fArr[0] + f2 + f3 + fArr[1];
        this.f10915l = f4;
        float f5 = fArr[1] + f4 + f3 + fArr[2];
        this.m = f5;
        float f6 = f5 + fArr[2] + f3 + fArr[3];
        this.n = f6;
        float f7 = ((this.f10910g - b3) - (b * 0.5f)) - b2;
        this.o = f7;
        this.p = new float[]{f2, f4, f5, f6, f7};
        this.q = new l[]{AreaProtectionBoldAdjustView$mappingsForPush$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$4.INSTANCE};
        l<Float, Float>[] lVarArr = {AreaProtectionBoldAdjustView$mappingsForAreaProtection$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$4.INSTANCE};
        this.r = lVarArr;
        this.s = lVarArr;
        this.t = f5;
        this.v = new ValueAnimator();
        BoldType[] boldTypeArr = {BoldType.SMALL, BoldType.NORMAL, BoldType.BOLD, BoldType.BOLD2, BoldType.BOLD3};
        this.w = boldTypeArr;
        this.z = new us.pinguo.edit2020.viewmodel.module.c(boldTypeArr[2].getScaleFactor(), boldTypeArr[4].getIndicatorSize(), true, boldTypeArr[2], true);
        this.A = boldTypeArr[2];
        this.v.setDuration(120L);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AreaProtectionBoldAdjustView.a(AreaProtectionBoldAdjustView.this, valueAnimator);
            }
        });
        this.v.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(AreaProtectionBoldAdjustView this$0, ValueAnimator valueAnimator) {
        s.h(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this$0.t = floatValue;
        us.pinguo.edit2020.viewmodel.module.c cVar = this$0.z;
        cVar.j(false);
        cVar.i(false);
        int f2 = this$0.f(floatValue);
        if (f2 != -1) {
            l<Float, Float> lVar = this$0.s[f2];
            Context context = this$0.getContext();
            s.g(context, "context");
            cVar.g(lVar.invoke(Float.valueOf(us.pinguo.util.g.c(context, floatValue))).floatValue());
        }
        l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar2 = this$0.x;
        if (lVar2 != null) {
            lVar2.invoke(cVar);
        }
        this$0.invalidate();
    }

    private final int f(float f2) {
        float[] fArr = this.p;
        boolean z = false;
        if (f2 <= fArr[1] && fArr[0] <= f2) {
            return 0;
        }
        if (f2 <= fArr[2] && fArr[1] <= f2) {
            return 1;
        }
        if (f2 <= fArr[3] && fArr[2] <= f2) {
            return 2;
        }
        float f3 = fArr[3];
        if (f2 <= fArr[4] && f3 <= f2) {
            z = true;
        }
        return z ? 3 : -1;
    }

    public final us.pinguo.edit2020.viewmodel.module.c g() {
        return this.z;
    }

    public final BoldType[] h() {
        return this.w;
    }

    public final l<us.pinguo.edit2020.viewmodel.module.c, u> i() {
        return this.x;
    }

    public final l<Float, Float>[] j() {
        return this.q;
    }

    public final void l() {
        this.A = this.w[2];
        this.t = this.m;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        s.h(canvas, "canvas");
        this.a.reset();
        this.a.setFlags(1);
        float f2 = this.f10911h * 0.5f;
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        this.a.setColor(this.b);
        canvas.drawLine(this.f10914k, f2, this.o, f2, this.a);
        this.a.setStyle(Paint.Style.FILL);
        Iterator<Integer> it = new kotlin.z.d(0, 4).iterator();
        while (it.hasNext()) {
            int nextInt = ((h0) it).nextInt();
            canvas.drawCircle(this.p[nextInt], f2, this.f10907d[nextInt], this.a);
        }
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(-1);
        canvas.drawCircle(this.t, f2, this.f10908e, this.a);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.c);
        this.a.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawCircle(this.t, f2, this.f10908e, this.a);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension((int) this.f10910g, (int) this.f10911h);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        BoldType boldType;
        s.h(event, "event");
        boolean z = false;
        if (isShown()) {
            if (this.v.isRunning()) {
                return true;
            }
            float x = event.getX();
            float f2 = this.f10913j * 0.5f;
            int action = event.getAction();
            if (action == 0) {
                float f3 = this.t;
                if (x <= f3 + f2 && f3 - f2 <= x) {
                    this.u = true;
                    us.pinguo.edit2020.viewmodel.module.c cVar = this.z;
                    cVar.j(false);
                    cVar.i(false);
                    l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar = this.x;
                    if (lVar != null) {
                        lVar.invoke(cVar);
                    }
                }
            } else if (action != 1) {
                if (action == 2 && this.u) {
                    float f4 = this.t;
                    float f5 = this.f10914k;
                    if (f4 > f5 || x > f5) {
                        float f6 = this.o;
                        if (f4 < f6 || x < f6) {
                            if (x < f5) {
                                x = f5;
                            } else if (x > f6) {
                                x = f6;
                            }
                            this.t = x;
                            us.pinguo.edit2020.viewmodel.module.c cVar2 = this.z;
                            cVar2.j(false);
                            cVar2.i(false);
                            int f7 = f(this.t);
                            if (f7 != -1) {
                                l<Float, Float> lVar2 = this.s[f7];
                                Context context = getContext();
                                s.g(context, "context");
                                cVar2.g(lVar2.invoke(Float.valueOf(us.pinguo.util.g.c(context, this.t))).floatValue());
                            }
                            invalidate();
                            l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar3 = this.x;
                            if (lVar3 != null) {
                                lVar3.invoke(cVar2);
                            }
                        }
                    }
                }
                return true;
            } else {
                float f8 = this.f10912i * 0.5f;
                int i2 = 4;
                if (this.u) {
                    this.u = false;
                    float f9 = this.t;
                    if (0.0f <= f9 && f9 <= (this.p[0] + this.f10907d[0]) + f8) {
                        i2 = 0;
                    } else {
                        float[] fArr = this.p;
                        float f10 = fArr[1];
                        float[] fArr2 = this.f10907d;
                        if (f9 <= (fArr[1] + fArr2[1]) + f8 && (f10 - fArr2[1]) - f8 <= f9) {
                            i2 = 1;
                        } else {
                            if (f9 <= (fArr[2] + fArr2[2]) + f8 && (fArr[2] - fArr2[2]) - f8 <= f9) {
                                i2 = 2;
                            } else {
                                if (f9 <= (fArr[3] + fArr2[3]) + f8 && (fArr[3] - fArr2[3]) - f8 <= f9) {
                                    i2 = 3;
                                }
                            }
                        }
                    }
                    this.v.setFloatValues(f9, this.p[i2]);
                    this.v.start();
                    l<? super Integer, u> lVar4 = this.y;
                    if (lVar4 != null) {
                        lVar4.invoke(Integer.valueOf(i2));
                    }
                } else {
                    us.pinguo.edit2020.viewmodel.module.c cVar3 = this.z;
                    if (0.0f <= x && x <= this.f10914k + f2) {
                        BoldType boldType2 = this.w[0];
                        if (this.A != boldType2) {
                            this.A = boldType2;
                            this.t = this.f10914k;
                            invalidate();
                            cVar3.f(boldType2);
                            cVar3.g(boldType2.getScaleFactor());
                            cVar3.j(true);
                            cVar3.i(true);
                            l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar5 = this.x;
                            if (lVar5 != null) {
                                lVar5.invoke(cVar3);
                            }
                            l<? super Integer, u> lVar6 = this.y;
                            if (lVar6 != null) {
                                lVar6.invoke(0);
                            }
                        }
                    } else {
                        float f11 = this.f10915l;
                        if (x <= f11 + f2 && f11 - f2 <= x) {
                            BoldType boldType3 = this.w[1];
                            if (this.A != boldType3) {
                                this.A = boldType3;
                                this.t = f11;
                                invalidate();
                                cVar3.g(boldType3.getScaleFactor());
                                cVar3.f(boldType3);
                                cVar3.j(true);
                                cVar3.i(true);
                                l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar7 = this.x;
                                if (lVar7 != null) {
                                    lVar7.invoke(cVar3);
                                }
                                l<? super Integer, u> lVar8 = this.y;
                                if (lVar8 != null) {
                                    lVar8.invoke(1);
                                }
                            }
                        } else {
                            float f12 = this.m;
                            if (x <= f12 + f2 && f12 - f2 <= x) {
                                BoldType boldType4 = this.w[2];
                                if (this.A != boldType4) {
                                    this.A = boldType4;
                                    this.t = f12;
                                    invalidate();
                                    cVar3.g(boldType4.getScaleFactor());
                                    cVar3.f(boldType4);
                                    cVar3.j(true);
                                    cVar3.i(true);
                                    l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar9 = this.x;
                                    if (lVar9 != null) {
                                        lVar9.invoke(cVar3);
                                    }
                                    l<? super Integer, u> lVar10 = this.y;
                                    if (lVar10 != null) {
                                        lVar10.invoke(2);
                                    }
                                }
                            } else {
                                float f13 = this.n;
                                if (x <= f13 + f2 && f13 - f2 <= x) {
                                    BoldType boldType5 = this.w[3];
                                    if (this.A != boldType5) {
                                        this.A = boldType5;
                                        this.t = f13;
                                        cVar3.g(boldType5.getScaleFactor());
                                        cVar3.f(boldType5);
                                        cVar3.j(true);
                                        cVar3.i(true);
                                        invalidate();
                                        l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar11 = this.x;
                                        if (lVar11 != null) {
                                            lVar11.invoke(cVar3);
                                        }
                                        l<? super Integer, u> lVar12 = this.y;
                                        if (lVar12 != null) {
                                            lVar12.invoke(3);
                                        }
                                    }
                                } else {
                                    float f14 = this.o;
                                    float f15 = f14 - f2;
                                    if (x <= this.f10910g && f15 <= x) {
                                        z = true;
                                    }
                                    if (z && this.A != (boldType = this.w[4])) {
                                        this.A = boldType;
                                        this.t = f14;
                                        cVar3.g(boldType.getScaleFactor());
                                        cVar3.f(boldType);
                                        cVar3.j(true);
                                        cVar3.i(true);
                                        invalidate();
                                        l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar13 = this.x;
                                        if (lVar13 != null) {
                                            lVar13.invoke(cVar3);
                                        }
                                        l<? super Integer, u> lVar14 = this.y;
                                        if (lVar14 != null) {
                                            lVar14.invoke(4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void setCallBack(l<? super us.pinguo.edit2020.viewmodel.module.c, u> lVar) {
        this.x = lVar;
    }

    public final void setCallBackLevel(l<? super Integer, u> lVar) {
        this.y = lVar;
    }

    public final void setCurrentBold(BoldType value) {
        float f2;
        s.h(value, "value");
        if (value == this.A) {
            return;
        }
        this.A = value;
        BoldType[] boldTypeArr = this.w;
        if (value == boldTypeArr[0]) {
            f2 = this.f10914k;
        } else if (value == boldTypeArr[1]) {
            f2 = this.f10915l;
        } else if (value == boldTypeArr[2]) {
            f2 = this.m;
        } else if (value == boldTypeArr[3]) {
            f2 = this.n;
        } else {
            f2 = value == boldTypeArr[4] ? this.o : this.m;
        }
        this.t = f2;
        invalidate();
    }

    public final void setHeight(float f2) {
        Context context = getContext();
        s.g(context, "context");
        this.f10911h = us.pinguo.util.g.b(context, f2);
    }

    public final void setMappingsArr(l<Float, Float>[] lVarArr) {
        s.h(lVarArr, "<set-?>");
        this.s = lVarArr;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaProtectionBoldAdjustView(Context context, AttributeSet attrs) {
        super(context, attrs);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.rgb(228, 227, 227);
        Context context2 = getContext();
        s.g(context2, "context");
        float b = us.pinguo.util.g.b(context2, 2.0f);
        this.c = b;
        Context context3 = getContext();
        s.g(context3, "context");
        Context context4 = getContext();
        s.g(context4, "context");
        Context context5 = getContext();
        s.g(context5, "context");
        Context context6 = getContext();
        s.g(context6, "context");
        Context context7 = getContext();
        s.g(context7, "context");
        float[] fArr = {us.pinguo.util.g.b(context3, 3.0f), us.pinguo.util.g.b(context4, 4.0f), us.pinguo.util.g.b(context5, 5.0f), us.pinguo.util.g.b(context6, 6.0f), us.pinguo.util.g.b(context7, 7.0f)};
        this.f10907d = fArr;
        Context context8 = getContext();
        s.g(context8, "context");
        float b2 = us.pinguo.util.g.b(context8, 10.0f);
        this.f10908e = b2;
        Context context9 = getContext();
        s.g(context9, "context");
        float b3 = us.pinguo.util.g.b(context9, 1.0f);
        this.f10909f = b3;
        Context context10 = getContext();
        s.g(context10, "context");
        this.f10910g = us.pinguo.util.g.b(context10, 200.0f) + (b3 * 2.0f);
        this.f10911h = getResources().getDimension(R.dimen.user_operation_height);
        this.f10912i = (((((((((this.f10910g - (b3 * 2.0f)) - b) - (b2 - fArr[0])) - (b2 - fArr[4])) - (fArr[0] * 2.0f)) - (fArr[1] * 2.0f)) - (fArr[2] * 2.0f)) - (fArr[3] * 2.0f)) - (fArr[4] * 2.0f)) / 4.0f;
        Context context11 = getContext();
        s.g(context11, "context");
        this.f10913j = us.pinguo.util.g.b(context11, 32.0f);
        float f2 = (b * 0.5f) + b3 + b2;
        this.f10914k = f2;
        float f3 = this.f10912i;
        float f4 = fArr[0] + f2 + f3 + fArr[1];
        this.f10915l = f4;
        float f5 = fArr[1] + f4 + f3 + fArr[2];
        this.m = f5;
        float f6 = f5 + fArr[2] + f3 + fArr[3];
        this.n = f6;
        float f7 = ((this.f10910g - b3) - (b * 0.5f)) - b2;
        this.o = f7;
        this.p = new float[]{f2, f4, f5, f6, f7};
        this.q = new l[]{AreaProtectionBoldAdjustView$mappingsForPush$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$4.INSTANCE};
        l<Float, Float>[] lVarArr = {AreaProtectionBoldAdjustView$mappingsForAreaProtection$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$4.INSTANCE};
        this.r = lVarArr;
        this.s = lVarArr;
        this.t = f5;
        this.v = new ValueAnimator();
        BoldType[] boldTypeArr = {BoldType.SMALL, BoldType.NORMAL, BoldType.BOLD, BoldType.BOLD2, BoldType.BOLD3};
        this.w = boldTypeArr;
        this.z = new us.pinguo.edit2020.viewmodel.module.c(boldTypeArr[2].getScaleFactor(), boldTypeArr[4].getIndicatorSize(), true, boldTypeArr[2], true);
        this.A = boldTypeArr[2];
        this.v.setDuration(120L);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AreaProtectionBoldAdjustView.a(AreaProtectionBoldAdjustView.this, valueAnimator);
            }
        });
        this.v.addListener(new a());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AreaProtectionBoldAdjustView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        s.h(context, "context");
        s.h(attrs, "attrs");
        new LinkedHashMap();
        this.a = new Paint(1);
        this.b = Color.rgb(228, 227, 227);
        Context context2 = getContext();
        s.g(context2, "context");
        float b = us.pinguo.util.g.b(context2, 2.0f);
        this.c = b;
        Context context3 = getContext();
        s.g(context3, "context");
        Context context4 = getContext();
        s.g(context4, "context");
        Context context5 = getContext();
        s.g(context5, "context");
        Context context6 = getContext();
        s.g(context6, "context");
        Context context7 = getContext();
        s.g(context7, "context");
        float[] fArr = {us.pinguo.util.g.b(context3, 3.0f), us.pinguo.util.g.b(context4, 4.0f), us.pinguo.util.g.b(context5, 5.0f), us.pinguo.util.g.b(context6, 6.0f), us.pinguo.util.g.b(context7, 7.0f)};
        this.f10907d = fArr;
        Context context8 = getContext();
        s.g(context8, "context");
        float b2 = us.pinguo.util.g.b(context8, 10.0f);
        this.f10908e = b2;
        Context context9 = getContext();
        s.g(context9, "context");
        float b3 = us.pinguo.util.g.b(context9, 1.0f);
        this.f10909f = b3;
        Context context10 = getContext();
        s.g(context10, "context");
        this.f10910g = us.pinguo.util.g.b(context10, 200.0f) + (b3 * 2.0f);
        this.f10911h = getResources().getDimension(R.dimen.user_operation_height);
        this.f10912i = (((((((((this.f10910g - (b3 * 2.0f)) - b) - (b2 - fArr[0])) - (b2 - fArr[4])) - (fArr[0] * 2.0f)) - (fArr[1] * 2.0f)) - (fArr[2] * 2.0f)) - (fArr[3] * 2.0f)) - (fArr[4] * 2.0f)) / 4.0f;
        Context context11 = getContext();
        s.g(context11, "context");
        this.f10913j = us.pinguo.util.g.b(context11, 32.0f);
        float f2 = (b * 0.5f) + b3 + b2;
        this.f10914k = f2;
        float f3 = this.f10912i;
        float f4 = fArr[0] + f2 + f3 + fArr[1];
        this.f10915l = f4;
        float f5 = fArr[1] + f4 + f3 + fArr[2];
        this.m = f5;
        float f6 = f5 + fArr[2] + f3 + fArr[3];
        this.n = f6;
        float f7 = ((this.f10910g - b3) - (b * 0.5f)) - b2;
        this.o = f7;
        this.p = new float[]{f2, f4, f5, f6, f7};
        this.q = new l[]{AreaProtectionBoldAdjustView$mappingsForPush$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForPush$4.INSTANCE};
        l<Float, Float>[] lVarArr = {AreaProtectionBoldAdjustView$mappingsForAreaProtection$1.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$2.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$3.INSTANCE, AreaProtectionBoldAdjustView$mappingsForAreaProtection$4.INSTANCE};
        this.r = lVarArr;
        this.s = lVarArr;
        this.t = f5;
        this.v = new ValueAnimator();
        BoldType[] boldTypeArr = {BoldType.SMALL, BoldType.NORMAL, BoldType.BOLD, BoldType.BOLD2, BoldType.BOLD3};
        this.w = boldTypeArr;
        this.z = new us.pinguo.edit2020.viewmodel.module.c(boldTypeArr[2].getScaleFactor(), boldTypeArr[4].getIndicatorSize(), true, boldTypeArr[2], true);
        this.A = boldTypeArr[2];
        this.v.setDuration(120L);
        this.v.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: us.pinguo.edit2020.widget.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AreaProtectionBoldAdjustView.a(AreaProtectionBoldAdjustView.this, valueAnimator);
            }
        });
        this.v.addListener(new a());
    }
}

package us.pinguo.edit2020.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.tapjoy.TJAdUnitConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import us.pinguo.edit2020.bean.u0;
/* compiled from: FacePointView.kt */
/* loaded from: classes4.dex */
public final class FacePointView extends View {
    private Integer[] a;
    private HashMap<Integer, PointF[]> b;
    private final HashMap<Integer, PointF[]> c;

    /* renamed from: d  reason: collision with root package name */
    private u0 f10653d;

    /* renamed from: e  reason: collision with root package name */
    private int f10654e;

    /* renamed from: f  reason: collision with root package name */
    private int f10655f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f10656g;

    /* renamed from: h  reason: collision with root package name */
    private int f10657h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f10658i;

    /* renamed from: j  reason: collision with root package name */
    private int f10659j;

    /* renamed from: k  reason: collision with root package name */
    private int f10660k;

    /* renamed from: l  reason: collision with root package name */
    private a f10661l;
    private final int m;

    /* compiled from: FacePointView.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i2, PointF pointF, boolean z);

        void b(HashMap<Integer, PointF[]> hashMap);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePointView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        Paint paint = new Paint(1);
        this.f10656g = paint;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10657h = us.pinguo.util.g.a(context2, 1.5f);
        this.f10659j = -1;
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.a(context3, 10.0f);
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.FILL);
    }

    private final PointF a(PointF pointF, PointF pointF2, int i2, int i3, float f2, float f3, float f4, float f5) {
        float f6 = f3 / i3;
        float width = getWidth() - f2;
        float f7 = 2;
        pointF2.set((width / f7) + (pointF.x * f6) + f4, (((getHeight() - f3) / f7) + (pointF.y * f6)) - f5);
        return pointF2;
    }

    private final void g(int i2, PointF pointF, boolean z) {
        float f2 = pointF.x;
        u0 u0Var = this.f10653d;
        float e2 = f2 / (u0Var == null ? 1.0f : u0Var.e());
        float f3 = pointF.y;
        u0 u0Var2 = this.f10653d;
        PointF pointF2 = new PointF(e2, f3 / (u0Var2 != null ? u0Var2.d() : 1.0f));
        a aVar = this.f10661l;
        if (aVar == null) {
            return;
        }
        aVar.a(i2, pointF2, z);
    }

    static /* synthetic */ void h(FacePointView facePointView, int i2, PointF pointF, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        facePointView.g(i2, pointF, z);
    }

    private final PointF k(PointF pointF, u0 u0Var) {
        float d2 = u0Var.d() / this.f10654e;
        float f2 = 2;
        return new PointF(((pointF.x - u0Var.a()) - ((getWidth() - u0Var.e()) / f2)) / d2, ((pointF.y + u0Var.b()) - ((getHeight() - u0Var.d()) / f2)) / d2);
    }

    private final PointF l(PointF pointF, u0 u0Var) {
        float f2 = 2;
        return new PointF((pointF.x - u0Var.a()) - ((getWidth() - u0Var.e()) / f2), (pointF.y + u0Var.b()) - ((getHeight() - u0Var.d()) / f2));
    }

    private final void m(HashMap<Integer, PointF[]> hashMap) {
        if (hashMap == null) {
            return;
        }
        this.b = hashMap;
        u0 u0Var = this.f10653d;
        if (u0Var == null) {
            return;
        }
        j(u0Var);
    }

    public final void b() {
        a aVar = this.f10661l;
        if (aVar == null) {
            return;
        }
        aVar.b(this.b);
    }

    public final HashMap<Integer, PointF[]> c() {
        return this.b;
    }

    public final int d() {
        return this.f10660k;
    }

    public final int e() {
        return this.f10659j;
    }

    public final void f(us.pinguo.facedetector.c cVar) {
        us.pinguo.facedetector.b[] d2;
        kotlin.z.d h2;
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, kotlin.jvm.internal.s.q("=============before updateFaceInfo", (cVar == null || (d2 = cVar.d()) == null) ? null : Integer.valueOf(d2.length)));
        if (cVar == null) {
            return;
        }
        this.f10654e = cVar.e();
        this.f10655f = cVar.f();
        if (!cVar.h()) {
            this.b.clear();
            this.c.clear();
            return;
        }
        h2 = kotlin.z.j.h(0, cVar.c());
        Iterator<Integer> it = h2.iterator();
        while (it.hasNext()) {
            int nextInt = ((kotlin.collections.h0) it).nextInt();
            us.pinguo.facedetector.b bVar = cVar.d()[nextInt];
            Integer[] numArr = this.a;
            if (numArr != null) {
                int length = numArr.length;
                PointF[] pointFArr = new PointF[length];
                for (int i2 = 0; i2 < length; i2++) {
                    Integer[] numArr2 = this.a;
                    if (numArr2 != null) {
                        float l2 = bVar.l(numArr2[i2].intValue());
                        Integer[] numArr3 = this.a;
                        if (numArr3 != null) {
                            pointFArr[i2] = new PointF(l2, bVar.m(numArr3[i2].intValue()));
                        } else {
                            kotlin.jvm.internal.s.z("showPointPositionArr");
                            throw null;
                        }
                    } else {
                        kotlin.jvm.internal.s.z("showPointPositionArr");
                        throw null;
                    }
                }
                c().put(Integer.valueOf(nextInt), pointFArr);
            } else {
                kotlin.jvm.internal.s.z("showPointPositionArr");
                throw null;
            }
        }
        m(this.b);
        a aVar = this.f10661l;
        if (aVar != null) {
            aVar.b(this.b);
        }
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, kotlin.jvm.internal.s.q("=============after updateFaceInfo", Integer.valueOf(cVar.d().length)));
    }

    public final void i(MotionEvent event) {
        PointF pointF;
        int v;
        kotlin.jvm.internal.s.h(event, "event");
        int i2 = 0;
        if ((getVisibility() == 0) && event.getPointerCount() == 1) {
            int action = event.getAction();
            if (action == 0) {
                float x = event.getX();
                float y = event.getY();
                float f2 = 2.14748365E9f;
                PointF[] pointFArr = this.c.get(Integer.valueOf(this.f10660k));
                if (pointFArr == null) {
                    return;
                }
                int length = pointFArr.length;
                int i3 = 0;
                while (i2 < length) {
                    PointF pointF2 = pointFArr[i2];
                    int i4 = i3 + 1;
                    float abs = Math.abs(pointF2.x - x);
                    float abs2 = Math.abs(pointF2.y - y);
                    float sqrt = (float) Math.sqrt((abs * abs) + (abs2 * abs2));
                    if (sqrt < f2 && sqrt < this.m) {
                        setSelectedPoint(pointF2);
                        Integer[] numArr = this.a;
                        if (numArr == null) {
                            kotlin.jvm.internal.s.z("showPointPositionArr");
                            throw null;
                        } else {
                            setSelectedPointIndex(numArr[i3].intValue());
                            f2 = sqrt;
                        }
                    }
                    i2++;
                    i3 = i4;
                }
            } else if (action == 1) {
                this.f10658i = null;
                this.f10659j = -1;
            } else if (action != 2) {
            } else {
                if (!(getVisibility() == 0) || (pointF = this.f10658i) == null) {
                    return;
                }
                us.pinguo.common.log.a.k("TouchPoint:pointx=" + event.getX() + ",pointY=" + event.getY(), new Object[0]);
                pointF.x = event.getX();
                pointF.y = event.getY();
                invalidate();
                u0 u0Var = this.f10653d;
                if (u0Var == null) {
                    return;
                }
                PointF k2 = k(pointF, u0Var);
                PointF l2 = l(pointF, u0Var);
                us.pinguo.common.log.a.k("Face++坐标：x->" + l2.x + ",y->" + l2.y, new Object[0]);
                h(this, e(), l2, false, 4, null);
                PointF[] pointFArr2 = c().get(Integer.valueOf(d()));
                if (pointFArr2 == null) {
                    return;
                }
                Integer[] numArr2 = this.a;
                if (numArr2 == null) {
                    kotlin.jvm.internal.s.z("showPointPositionArr");
                    throw null;
                }
                v = kotlin.collections.n.v(numArr2, Integer.valueOf(e()));
                pointFArr2[v].set(k2.x, k2.y);
            }
        }
    }

    public final void j(u0 unityCanvasStatus) {
        PointF[] pointFArr;
        kotlin.jvm.internal.s.h(unityCanvasStatus, "unityCanvasStatus");
        Set<Integer> keySet = this.b.keySet();
        kotlin.jvm.internal.s.g(keySet, "originFacePoint.keys");
        for (Integer it : keySet) {
            PointF[] pointFArr2 = this.c.get(it);
            int i2 = 0;
            if (pointFArr2 == null) {
                Integer[] numArr = this.a;
                if (numArr == null) {
                    kotlin.jvm.internal.s.z("showPointPositionArr");
                    throw null;
                }
                int length = numArr.length;
                PointF[] pointFArr3 = new PointF[length];
                for (int i3 = 0; i3 < length; i3++) {
                    pointFArr3[i3] = new PointF();
                }
                pointFArr = pointFArr3;
            } else {
                pointFArr = pointFArr2;
            }
            HashMap<Integer, PointF[]> hashMap = this.c;
            kotlin.jvm.internal.s.g(it, "it");
            hashMap.put(it, pointFArr);
            PointF[] pointFArr4 = c().get(it);
            if (pointFArr4 != null) {
                int length2 = pointFArr4.length;
                int i4 = 0;
                while (i4 < length2) {
                    a(pointFArr4[i4], pointFArr[i2], this.f10655f, this.f10654e, unityCanvasStatus.e(), unityCanvasStatus.d(), unityCanvasStatus.a(), unityCanvasStatus.b());
                    i4++;
                    i2++;
                }
            }
        }
        this.f10653d = unityCanvasStatus;
        Log.i(TJAdUnitConstants.String.VIDEO_INFO, "=============onUnityCanvasUpdate");
        invalidate();
    }

    public final void n(HashMap<Integer, PointF[]> hashMap) {
        m(hashMap);
        PointF[] pointFArr = this.c.get(Integer.valueOf(this.f10660k));
        if (pointFArr == null) {
            return;
        }
        int length = pointFArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            PointF pointF = pointFArr[i2];
            int i4 = i3 + 1;
            u0 u0Var = this.f10653d;
            if (u0Var != null) {
                PointF l2 = l(pointF, u0Var);
                Integer[] numArr = this.a;
                if (numArr == null) {
                    kotlin.jvm.internal.s.z("showPointPositionArr");
                    throw null;
                }
                g(numArr[i3].intValue(), l2, true);
            }
            i2++;
            i3 = i4;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        PointF[] pointFArr = this.c.get(Integer.valueOf(this.f10660k));
        if (pointFArr == null) {
            return;
        }
        for (PointF pointF : pointFArr) {
            if (canvas != null) {
                canvas.drawCircle(pointF.x, pointF.y, this.f10657h, this.f10656g);
            }
        }
    }

    public final void setFaceIndex(int i2) {
        this.f10660k = i2;
        invalidate();
    }

    public final void setOnFacePointChangedListener(a aVar) {
        this.f10661l = aVar;
    }

    public final void setOriginFacePoint(HashMap<Integer, PointF[]> hashMap) {
        kotlin.jvm.internal.s.h(hashMap, "<set-?>");
        this.b = hashMap;
    }

    public final void setPointArr(Integer[] PointArr) {
        kotlin.jvm.internal.s.h(PointArr, "PointArr");
        this.a = PointArr;
    }

    public final void setPointRadius(int i2) {
        this.f10657h = i2;
    }

    public final void setSelectedFaceIndex(int i2) {
        this.f10660k = i2;
    }

    public final void setSelectedPoint(PointF pointF) {
        this.f10658i = pointF;
    }

    public final void setSelectedPointIndex(int i2) {
        this.f10659j = i2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        Paint paint = new Paint(1);
        this.f10656g = paint;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10657h = us.pinguo.util.g.a(context2, 1.5f);
        this.f10659j = -1;
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.a(context3, 10.0f);
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.FILL);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FacePointView(Context context, AttributeSet attrs, int i2) {
        super(context, attrs, i2);
        kotlin.jvm.internal.s.h(context, "context");
        kotlin.jvm.internal.s.h(attrs, "attrs");
        new LinkedHashMap();
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        Paint paint = new Paint(1);
        this.f10656g = paint;
        Context context2 = getContext();
        kotlin.jvm.internal.s.g(context2, "context");
        this.f10657h = us.pinguo.util.g.a(context2, 1.5f);
        this.f10659j = -1;
        Context context3 = getContext();
        kotlin.jvm.internal.s.g(context3, "context");
        this.m = us.pinguo.util.g.a(context3, 10.0f);
        paint.setColor(Color.parseColor("#ffffff"));
        paint.setStyle(Paint.Style.FILL);
    }
}

package us.pinguo.camera2020.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
/* compiled from: DrawPointView.kt */
/* loaded from: classes3.dex */
public final class DrawPointView extends View {
    private final Paint a;
    private final ArrayList<a> b;
    private boolean c;

    /* compiled from: DrawPointView.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private final int a;
        private final float[] b;
        private final float[] c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9296d;

        /* renamed from: e  reason: collision with root package name */
        private final int f9297e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9298f;

        public final int a() {
            return this.f9296d;
        }

        public final float[] b() {
            return this.c;
        }

        public final float[] c() {
            return this.b;
        }

        public final int d() {
            return this.f9298f;
        }

        public final int e() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && kotlin.jvm.internal.s.c(this.b, aVar.b) && kotlin.jvm.internal.s.c(this.c, aVar.c) && this.f9296d == aVar.f9296d && this.f9297e == aVar.f9297e && this.f9298f == aVar.f9298f;
            }
            return false;
        }

        public final int f() {
            return this.f9297e;
        }

        public int hashCode() {
            int hashCode = ((this.a * 31) + Arrays.hashCode(this.b)) * 31;
            float[] fArr = this.c;
            return ((((((hashCode + (fArr == null ? 0 : Arrays.hashCode(fArr))) * 31) + this.f9296d) * 31) + this.f9297e) * 31) + this.f9298f;
        }

        public String toString() {
            return "DrawFaceBean(index=" + this.a + ", facePoints=" + Arrays.toString(this.b) + ", exPoints=" + Arrays.toString(this.c) + ", color=" + this.f9296d + ", width=" + this.f9297e + ", height=" + this.f9298f + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawPointView(Context context) {
        super(context);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint();
        this.b = new ArrayList<>();
    }

    private final float a(float f2) {
        return f2 * Resources.getSystem().getDisplayMetrics().density;
    }

    private final void b(Canvas canvas, float[] fArr) {
        int i2 = 0;
        int c = kotlin.internal.c.c(0, fArr.length, 2);
        if (c < 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 2;
            if (i2 != 208 && i2 != 210) {
                if (i2 != 0 && i2 != 104 && i2 != 144) {
                    this.a.setStrokeWidth(a(2.0f));
                } else {
                    this.a.setStrokeWidth(a(4.0f));
                }
                int i4 = i2 + 1;
                if (i4 < fArr.length) {
                    if (canvas != null) {
                        canvas.drawPoint(fArr[i2], fArr[i4], this.a);
                    }
                    if (this.c) {
                        this.a.setTextSize(a(16.0f));
                        if (canvas != null) {
                            canvas.drawText(String.valueOf(i2), fArr[i2], fArr[i4], this.a);
                        }
                    }
                }
            }
            if (i2 == c) {
                return;
            }
            i2 = i3;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        for (a aVar : this.b) {
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setColor(SupportMenu.CATEGORY_MASK);
            this.a.setStrokeWidth(6.0f);
            if (canvas != null) {
                canvas.drawRect(0.0f, 0.0f, aVar.f(), aVar.d(), this.a);
            }
            this.a.setStyle(Paint.Style.FILL);
            this.a.setColor(aVar.a());
            b(canvas, aVar.c());
            float[] b = aVar.b();
            if (b != null) {
                b(canvas, b);
            }
            if (aVar.e() != -1) {
                this.a.setTextSize(a(16.0f));
                if (canvas != null) {
                    canvas.drawText(kotlin.jvm.internal.s.q("Index:", Integer.valueOf(aVar.e())), aVar.c()[86] - a(15.0f), aVar.c()[87] - a(20.0f), this.a);
                }
            }
        }
    }

    public final void setDrawPointIndex(boolean z) {
        this.c = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DrawPointView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.s.h(context, "context");
        new LinkedHashMap();
        this.a = new Paint();
        this.b = new ArrayList<>();
    }
}

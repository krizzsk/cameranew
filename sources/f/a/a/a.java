package f.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ViewRevealManager.java */
/* loaded from: classes3.dex */
public class a {
    private Map<View, b> a = new HashMap();

    /* compiled from: ViewRevealManager.java */
    /* renamed from: f.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0309a extends Property<b, Float> {
        C0309a() {
            super(Float.class, "supportCircularReveal");
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Float get(b bVar) {
            return Float.valueOf(bVar.b());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(b bVar, Float f2) {
            bVar.c(f2.floatValue());
            bVar.d().invalidate();
        }
    }

    /* compiled from: ViewRevealManager.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: h  reason: collision with root package name */
        private static final Paint f8630h;
        final int a;
        final int b;
        boolean c;

        /* renamed from: d  reason: collision with root package name */
        float f8631d;

        /* renamed from: e  reason: collision with root package name */
        View f8632e;

        /* renamed from: f  reason: collision with root package name */
        Path f8633f;

        /* renamed from: g  reason: collision with root package name */
        Region.Op f8634g;

        static {
            Paint paint = new Paint(1);
            f8630h = paint;
            paint.setColor(-16711936);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(2.0f);
        }

        boolean a(Canvas canvas, View view) {
            if (view == this.f8632e && this.c) {
                this.f8633f.reset();
                this.f8633f.addCircle(view.getX() + this.a, view.getY() + this.b, this.f8631d, Path.Direction.CW);
                canvas.clipPath(this.f8633f, this.f8634g);
                if (Build.VERSION.SDK_INT >= 21) {
                    view.invalidateOutline();
                    return true;
                }
                return true;
            }
            return false;
        }

        public float b() {
            return this.f8631d;
        }

        public void c(float f2) {
            this.f8631d = f2;
        }

        public View d() {
            return this.f8632e;
        }
    }

    static {
        new C0309a();
    }

    public boolean a(Canvas canvas, View view) {
        b bVar = this.a.get(view);
        return bVar != null && bVar.a(canvas, view);
    }
}

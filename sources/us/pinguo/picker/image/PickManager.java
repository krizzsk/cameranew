package us.pinguo.picker.image;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import java.util.HashMap;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.s;
import kotlin.u;
/* compiled from: PickManager.kt */
/* loaded from: classes5.dex */
public final class PickManager {
    public static final PickManager a;
    private static final DisplayMetrics b;
    private static final float c;

    /* renamed from: d  reason: collision with root package name */
    private static final kotlin.f f11641d;

    /* renamed from: e  reason: collision with root package name */
    private static final float f11642e;

    /* renamed from: f  reason: collision with root package name */
    private static final float f11643f;

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Point> f11644g;

    static {
        kotlin.f b2;
        PickManager pickManager = new PickManager();
        a = pickManager;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        b = displayMetrics;
        c = displayMetrics.density;
        b2 = kotlin.h.b(PickManager$imageMaxLength$2.INSTANCE);
        f11641d = b2;
        f11642e = Math.min(5.5f, Math.max((pickManager.d() * 0.9f) / displayMetrics.widthPixels, 3.1f));
        f11643f = 0.05f;
        f11644g = new HashMap<>();
    }

    private PickManager() {
    }

    private final int d() {
        return ((Number) f11641d.getValue()).intValue();
    }

    public final float b() {
        return c;
    }

    public final DisplayMetrics c() {
        return b;
    }

    public final Boolean e(int i2, int i3, String path) {
        s.h(path, "path");
        if (i2 == 0 || i3 == 0) {
            Point point = f11644g.get(path);
            if (point == null) {
                return null;
            }
            int i4 = point.x;
            i3 = point.y;
            i2 = i4;
        }
        if (i2 * i3 < 100) {
            return Boolean.FALSE;
        }
        float f2 = i3 / i2;
        if (f2 < f11642e && f2 > f11643f) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public final void f(String path, int i2, l<? super Boolean, u> post) {
        s.h(path, "path");
        s.h(post, "post");
        PuzzleTask.a.a(new PickManager$syncInRange$1(path, i2), new PickManager$syncInRange$2(post));
    }
}

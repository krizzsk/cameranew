package us.pinguo.camera2020.develop;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.s;
import kotlinx.coroutines.l;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.z0;
/* compiled from: StickerTestUtil.kt */
/* loaded from: classes2.dex */
public final class StickerTestUtilKt {
    private static final ArrayList<String> a = new ArrayList<>();
    private static final ArrayList<String> b = new ArrayList<>();
    private static final ArrayList<Boolean> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private static final String f9139d = "/sdcard/Camera360/unity/";

    /* renamed from: e  reason: collision with root package name */
    private static final Paint f9140e = new Paint(1);

    /* renamed from: f  reason: collision with root package name */
    private static float f9141f = 2.0f;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap d(String str) {
        int i2;
        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = new Rect();
        Paint paint = f9140e;
        paint.setTextSize(f9141f * 3);
        paint.getTextBounds(str, 0, str.length(), rect);
        int i3 = 1;
        if (((float) rect.width()) > ((float) rect.height()) * 2.5f) {
            Rect rect2 = new Rect(0, 0, 0, 0);
            paint.getTextBounds(str, 0, 0, rect);
            paint.getTextBounds(str, 0, str.length(), rect2);
            while (rect.width() < rect2.width() && (i2 = i3 + 1) < str.length()) {
                Paint paint2 = f9140e;
                paint2.getTextBounds(str, 0, i3, rect);
                paint2.getTextBounds(str, i3, str.length(), rect2);
                i3 = i2;
            }
            int i4 = i3 - 1;
            f9140e.getTextBounds(str, 0, i4, rect);
            while (rect.width() < 160) {
                Paint paint3 = f9140e;
                paint3.setTextSize(paint3.getTextSize() + f9141f);
                paint3.getTextBounds(str, 0, i4, rect);
            }
            while (rect.width() > 180) {
                Paint paint4 = f9140e;
                paint4.setTextSize(paint4.getTextSize() - f9141f);
                paint4.getTextBounds(str, 0, i4, rect);
            }
            Paint paint5 = f9140e;
            paint5.getTextBounds(str, 0, i4, rect);
            paint5.getTextBounds(str, i4, str.length(), rect2);
            String substring = str.substring(0, i4);
            s.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            canvas.drawText(substring, ((200 - rect.width()) / 2) - rect.left, (100 - rect.height()) - rect.top, paint5);
            String substring2 = str.substring(i4);
            s.g(substring2, "this as java.lang.String).substring(startIndex)");
            canvas.drawText(substring2, ((200 - rect2.width()) / 2) - rect2.left, 100 - rect2.top, paint5);
        } else {
            while (rect.width() < 180 && rect.height() < 60) {
                Paint paint6 = f9140e;
                paint6.setTextSize(paint6.getTextSize() + f9141f);
                paint6.getTextBounds(str, 0, str.length(), rect);
            }
            while (true) {
                if (rect.width() <= 190 && rect.height() <= 90) {
                    break;
                }
                Paint paint7 = f9140e;
                paint7.setTextSize(paint7.getTextSize() - f9141f);
                paint7.getTextBounds(str, 0, str.length(), rect);
            }
            canvas.drawText(str, ((200 - rect.width()) / 2) - rect.left, ((200 - rect.height()) / 2) - rect.top, f9140e);
        }
        s.g(bitmap, "bitmap");
        return bitmap;
    }

    public static final ArrayList<String> e() {
        return a;
    }

    public static final ArrayList<Boolean> f() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<d> g(ArrayList<String> arrayList, ArrayList<String> arrayList2, ArrayList<Boolean> arrayList3) {
        List<d> h2;
        List<d> h3;
        List<d> h4;
        if (arrayList3 == null) {
            h4 = u.h();
            return h4;
        } else if (arrayList == null) {
            h3 = u.h();
            return h3;
        } else if (arrayList2 == null) {
            h2 = u.h();
            return h2;
        } else if (arrayList3.size() == arrayList.size() && arrayList.size() == arrayList2.size()) {
            ArrayList arrayList4 = new ArrayList();
            int i2 = 0;
            int size = arrayList3.size();
            while (i2 < size) {
                int i3 = i2 + 1;
                Boolean bool = arrayList3.get(i2);
                s.g(bool, "checkList[i]");
                if (bool.booleanValue()) {
                    String str = arrayList.get(i2);
                    s.g(str, "nameList[i]");
                    String str2 = arrayList2.get(i2);
                    s.g(str2, "zipList[i]");
                    arrayList4.add(new d(str, str2));
                }
                i2 = i3;
            }
            return arrayList4;
        } else {
            throw new IllegalArgumentException("error size, pls check!");
        }
    }

    public static final String h() {
        return f9139d;
    }

    public static final ArrayList<String> i() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(d dVar) {
        l.d(n0.a(z0.b()), null, null, new StickerTestUtilKt$import$1(dVar, null), 3, null);
    }
}

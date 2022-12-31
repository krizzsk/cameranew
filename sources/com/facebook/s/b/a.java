package com.facebook.s.b;

import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import com.facebook.fresco.ui.common.b;
import java.util.Map;
import javax.annotation.Nullable;
/* compiled from: MiddlewareUtils.java */
/* loaded from: classes.dex */
public class a {
    public static b.a a(Map<String, Object> map, Map<String, Object> map2, @Nullable Map<String, Object> map3, @Nullable Rect rect, @Nullable String str, @Nullable PointF pointF, @Nullable Map<String, Object> map4, @Nullable Object obj, @Nullable Uri uri) {
        b.a aVar = new b.a();
        if (rect != null) {
            rect.width();
            rect.height();
        }
        if (pointF != null) {
            float f2 = pointF.x;
            float f3 = pointF.y;
        }
        aVar.f2635e = obj;
        aVar.c = map3;
        aVar.f2634d = map4;
        aVar.b = map2;
        aVar.a = map;
        return aVar;
    }
}

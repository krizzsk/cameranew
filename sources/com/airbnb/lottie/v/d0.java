package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class d0 implements j0<com.airbnb.lottie.model.content.h> {
    public static final d0 a = new d0();
    private static final JsonReader.a b = JsonReader.a.a("c", "v", ContextChain.TAG_INFRA, "o");

    private d0() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public com.airbnb.lottie.model.content.h a(JsonReader jsonReader, float f2) throws IOException {
        if (jsonReader.R() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
        }
        jsonReader.t();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(b);
            if (T == 0) {
                z = jsonReader.y();
            } else if (T == 1) {
                list = p.f(jsonReader, f2);
            } else if (T == 2) {
                list2 = p.f(jsonReader, f2);
            } else if (T != 3) {
                jsonReader.U();
                jsonReader.V();
            } else {
                list3 = p.f(jsonReader, f2);
            }
        }
        jsonReader.w();
        if (jsonReader.R() == JsonReader.Token.END_ARRAY) {
            jsonReader.v();
        }
        if (list != null && list2 != null && list3 != null) {
            if (list.isEmpty()) {
                return new com.airbnb.lottie.model.content.h(new PointF(), false, Collections.emptyList());
            }
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 1; i2 < size; i2++) {
                PointF pointF2 = list.get(i2);
                int i3 = i2 - 1;
                arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.w.g.a(list.get(i3), list3.get(i3)), com.airbnb.lottie.w.g.a(pointF2, list2.get(i2)), pointF2));
            }
            if (z) {
                PointF pointF3 = list.get(0);
                int i4 = size - 1;
                arrayList.add(new com.airbnb.lottie.model.a(com.airbnb.lottie.w.g.a(list.get(i4), list3.get(i4)), com.airbnb.lottie.w.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new com.airbnb.lottie.model.content.h(pointF, z, arrayList);
        }
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}

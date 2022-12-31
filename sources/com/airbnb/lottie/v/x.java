package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: PathParser.java */
/* loaded from: classes.dex */
public class x implements j0<PointF> {
    public static final x a = new x();

    private x() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        return p.e(jsonReader, f2);
    }
}

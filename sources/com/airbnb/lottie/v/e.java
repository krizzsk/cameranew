package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
public class e {
    private static JsonReader.a a = JsonReader.a.a("nm", ContextChain.TAG_PRODUCT, "s", "hd", "d");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.a a(JsonReader jsonReader, com.airbnb.lottie.e eVar, int i2) throws IOException {
        boolean z = i2 == 3;
        String str = null;
        com.airbnb.lottie.model.h.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.h.f fVar = null;
        boolean z2 = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                mVar = a.b(jsonReader, eVar);
            } else if (T == 2) {
                fVar = d.i(jsonReader, eVar);
            } else if (T == 3) {
                z2 = jsonReader.y();
            } else if (T != 4) {
                jsonReader.U();
                jsonReader.V();
            } else {
                z = jsonReader.A() == 3;
            }
        }
        return new com.airbnb.lottie.model.content.a(str, mVar, fVar, z, z2);
    }
}

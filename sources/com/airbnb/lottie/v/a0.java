package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
public class a0 {
    private static JsonReader.a a = JsonReader.a.a("nm", ContextChain.TAG_PRODUCT, "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.f a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        com.airbnb.lottie.model.h.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.h.f fVar = null;
        com.airbnb.lottie.model.h.b bVar = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                mVar = a.b(jsonReader, eVar);
            } else if (T == 2) {
                fVar = d.i(jsonReader, eVar);
            } else if (T == 3) {
                bVar = d.e(jsonReader, eVar);
            } else if (T != 4) {
                jsonReader.V();
            } else {
                z = jsonReader.y();
            }
        }
        return new com.airbnb.lottie.model.content.f(str, mVar, fVar, bVar, z);
    }
}

package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PolystarShapeParser.java */
/* loaded from: classes.dex */
public class z {
    private static final JsonReader.a a = JsonReader.a.a("nm", "sy", "pt", ContextChain.TAG_PRODUCT, "r", "or", "os", "ir", "is", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PolystarShape a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        PolystarShape.Type type = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.m<PointF, PointF> mVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        com.airbnb.lottie.model.h.b bVar3 = null;
        com.airbnb.lottie.model.h.b bVar4 = null;
        com.airbnb.lottie.model.h.b bVar5 = null;
        com.airbnb.lottie.model.h.b bVar6 = null;
        boolean z = false;
        while (jsonReader.x()) {
            switch (jsonReader.T(a)) {
                case 0:
                    str = jsonReader.O();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.A());
                    break;
                case 2:
                    bVar = d.f(jsonReader, eVar, false);
                    break;
                case 3:
                    mVar = a.b(jsonReader, eVar);
                    break;
                case 4:
                    bVar2 = d.f(jsonReader, eVar, false);
                    break;
                case 5:
                    bVar4 = d.e(jsonReader, eVar);
                    break;
                case 6:
                    bVar6 = d.f(jsonReader, eVar, false);
                    break;
                case 7:
                    bVar3 = d.e(jsonReader, eVar);
                    break;
                case 8:
                    bVar5 = d.f(jsonReader, eVar, false);
                    break;
                case 9:
                    z = jsonReader.y();
                    break;
                default:
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
        }
        return new PolystarShape(str, type, bVar, mVar, bVar2, bVar3, bVar4, bVar5, bVar6, z);
    }
}

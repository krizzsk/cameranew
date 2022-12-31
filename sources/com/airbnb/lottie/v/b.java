package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {
    private static JsonReader.a a = JsonReader.a.a("a");
    private static JsonReader.a b = JsonReader.a.a("fc", "sc", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SW, "t");

    public static com.airbnb.lottie.model.h.k a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        jsonReader.t();
        com.airbnb.lottie.model.h.k kVar = null;
        while (jsonReader.x()) {
            if (jsonReader.T(a) != 0) {
                jsonReader.U();
                jsonReader.V();
            } else {
                kVar = b(jsonReader, eVar);
            }
        }
        jsonReader.w();
        return kVar == null ? new com.airbnb.lottie.model.h.k(null, null, null, null) : kVar;
    }

    private static com.airbnb.lottie.model.h.k b(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        jsonReader.t();
        com.airbnb.lottie.model.h.a aVar = null;
        com.airbnb.lottie.model.h.a aVar2 = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        while (jsonReader.x()) {
            int T = jsonReader.T(b);
            if (T == 0) {
                aVar = d.c(jsonReader, eVar);
            } else if (T == 1) {
                aVar2 = d.c(jsonReader, eVar);
            } else if (T == 2) {
                bVar = d.e(jsonReader, eVar);
            } else if (T != 3) {
                jsonReader.U();
                jsonReader.V();
            } else {
                bVar2 = d.e(jsonReader, eVar);
            }
        }
        jsonReader.w();
        return new com.airbnb.lottie.model.h.k(aVar, aVar2, bVar, bVar2);
    }
}

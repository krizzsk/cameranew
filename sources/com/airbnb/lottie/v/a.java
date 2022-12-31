package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {
    private static JsonReader.a a = JsonReader.a.a("k", "x", "y");

    public static com.airbnb.lottie.model.h.e a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.R() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            while (jsonReader.x()) {
                arrayList.add(w.a(jsonReader, eVar));
            }
            jsonReader.v();
            r.b(arrayList);
        } else {
            arrayList.add(new com.airbnb.lottie.x.a(p.e(jsonReader, com.airbnb.lottie.w.h.e())));
        }
        return new com.airbnb.lottie.model.h.e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.m<PointF, PointF> b(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        jsonReader.t();
        com.airbnb.lottie.model.h.e eVar2 = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        boolean z = false;
        while (jsonReader.R() != JsonReader.Token.END_OBJECT) {
            int T = jsonReader.T(a);
            if (T == 0) {
                eVar2 = a(jsonReader, eVar);
            } else if (T != 1) {
                if (T != 2) {
                    jsonReader.U();
                    jsonReader.V();
                } else if (jsonReader.R() == JsonReader.Token.STRING) {
                    jsonReader.V();
                    z = true;
                } else {
                    bVar2 = d.e(jsonReader, eVar);
                }
            } else if (jsonReader.R() == JsonReader.Token.STRING) {
                jsonReader.V();
                z = true;
            } else {
                bVar = d.e(jsonReader, eVar);
            }
        }
        jsonReader.w();
        if (z) {
            eVar.a("Lottie doesn't support expressions.");
        }
        return eVar2 != null ? eVar2 : new com.airbnb.lottie.model.h.i(bVar, bVar2);
    }
}

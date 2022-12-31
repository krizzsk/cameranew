package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
public class b0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "c", "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.g a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        com.airbnb.lottie.model.h.l lVar = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                bVar = d.f(jsonReader, eVar, false);
            } else if (T == 2) {
                bVar2 = d.f(jsonReader, eVar, false);
            } else if (T == 3) {
                lVar = c.g(jsonReader, eVar);
            } else if (T != 4) {
                jsonReader.V();
            } else {
                z = jsonReader.y();
            }
        }
        return new com.airbnb.lottie.model.content.g(str, bVar, bVar2, lVar, z);
    }
}

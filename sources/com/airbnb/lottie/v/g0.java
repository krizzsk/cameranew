package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
public class g0 {
    static JsonReader.a a = JsonReader.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.k a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        int i2 = 0;
        String str = null;
        com.airbnb.lottie.model.h.h hVar = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                i2 = jsonReader.A();
            } else if (T == 2) {
                hVar = d.k(jsonReader, eVar);
            } else if (T != 3) {
                jsonReader.V();
            } else {
                z = jsonReader.y();
            }
        }
        return new com.airbnb.lottie.model.content.k(str, i2, hVar, z);
    }
}

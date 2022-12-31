package com.airbnb.lottie.v;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
public class i0 {
    private static JsonReader.a a = JsonReader.a.a("s", "e", "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        ShapeTrimPath.Type type = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        com.airbnb.lottie.model.h.b bVar3 = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                bVar = d.f(jsonReader, eVar, false);
            } else if (T == 1) {
                bVar2 = d.f(jsonReader, eVar, false);
            } else if (T == 2) {
                bVar3 = d.f(jsonReader, eVar, false);
            } else if (T == 3) {
                str = jsonReader.O();
            } else if (T == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.A());
            } else if (T != 5) {
                jsonReader.V();
            } else {
                z = jsonReader.y();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z);
    }
}

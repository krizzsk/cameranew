package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
public class f0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.j a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                z = jsonReader.y();
            } else if (T != 2) {
                jsonReader.V();
            } else {
                jsonReader.d();
                while (jsonReader.x()) {
                    com.airbnb.lottie.model.content.b a2 = g.a(jsonReader, eVar);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
                jsonReader.v();
            }
        }
        return new com.airbnb.lottie.model.content.j(str, arrayList, z);
    }
}

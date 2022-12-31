package com.airbnb.lottie.v;

import android.graphics.Path;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
public class e0 {
    private static final JsonReader.a a = JsonReader.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.i a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        String str = null;
        com.airbnb.lottie.model.h.a aVar = null;
        com.airbnb.lottie.model.h.d dVar = null;
        int i2 = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                aVar = d.c(jsonReader, eVar);
            } else if (T == 2) {
                dVar = d.h(jsonReader, eVar);
            } else if (T == 3) {
                z = jsonReader.y();
            } else if (T == 4) {
                i2 = jsonReader.A();
            } else if (T != 5) {
                jsonReader.U();
                jsonReader.V();
            } else {
                z2 = jsonReader.y();
            }
        }
        return new com.airbnb.lottie.model.content.i(str, z, i2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar, z2);
    }
}

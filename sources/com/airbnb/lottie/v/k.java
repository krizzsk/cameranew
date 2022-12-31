package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {
    private static final JsonReader.a a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.b a(JsonReader jsonReader) throws IOException {
        jsonReader.t();
        String str = null;
        String str2 = null;
        String str3 = null;
        float f2 = 0.0f;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                str2 = jsonReader.O();
            } else if (T == 2) {
                str3 = jsonReader.O();
            } else if (T != 3) {
                jsonReader.U();
                jsonReader.V();
            } else {
                f2 = (float) jsonReader.z();
            }
        }
        jsonReader.w();
        return new com.airbnb.lottie.model.b(str, str2, str3, f2);
    }
}

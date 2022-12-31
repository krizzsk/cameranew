package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<com.airbnb.lottie.x.d> {
    public static final c0 a = new c0();

    private c0() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public com.airbnb.lottie.x.d a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.R() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.d();
        }
        float z2 = (float) jsonReader.z();
        float z3 = (float) jsonReader.z();
        while (jsonReader.x()) {
            jsonReader.V();
        }
        if (z) {
            jsonReader.v();
        }
        return new com.airbnb.lottie.x.d((z2 / 100.0f) * f2, (z3 / 100.0f) * f2);
    }
}

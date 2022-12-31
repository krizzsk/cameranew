package com.airbnb.lottie.v;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements j0<Integer> {
    public static final f a = new f();

    private f() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        boolean z = jsonReader.R() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.d();
        }
        double z2 = jsonReader.z();
        double z3 = jsonReader.z();
        double z4 = jsonReader.z();
        double z5 = jsonReader.z();
        if (z) {
            jsonReader.v();
        }
        if (z2 <= 1.0d && z3 <= 1.0d && z4 <= 1.0d) {
            z2 *= 255.0d;
            z3 *= 255.0d;
            z4 *= 255.0d;
            if (z5 <= 1.0d) {
                z5 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) z5, (int) z2, (int) z3, (int) z4));
    }
}

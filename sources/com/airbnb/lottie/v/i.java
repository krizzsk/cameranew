package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: FloatParser.java */
/* loaded from: classes.dex */
public class i implements j0<Float> {
    public static final i a = new i();

    private i() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public Float a(JsonReader jsonReader, float f2) throws IOException {
        return Float.valueOf(p.g(jsonReader) * f2);
    }
}

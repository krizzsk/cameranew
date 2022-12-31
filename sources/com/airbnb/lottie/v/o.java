package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public class o implements j0<Integer> {
    public static final o a = new o();

    private o() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f2) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f2));
    }
}

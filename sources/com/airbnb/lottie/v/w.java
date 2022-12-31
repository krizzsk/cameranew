package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: PathKeyframeParser.java */
/* loaded from: classes.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.t.c.h a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.t.c.h(eVar, q.b(jsonReader, eVar, com.airbnb.lottie.w.h.e(), x.a, jsonReader.R() == JsonReader.Token.BEGIN_OBJECT));
    }
}

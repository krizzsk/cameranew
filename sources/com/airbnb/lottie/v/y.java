package com.airbnb.lottie.v;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y implements j0<PointF> {
    public static final y a = new y();

    private y() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f2) throws IOException {
        JsonReader.Token R = jsonReader.R();
        if (R == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, f2);
        }
        if (R == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, f2);
        }
        if (R == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.z()) * f2, ((float) jsonReader.z()) * f2);
            while (jsonReader.x()) {
                jsonReader.V();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + R);
    }
}

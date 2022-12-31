package com.airbnb.lottie.v;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {
    private static final JsonReader.a a = JsonReader.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonUtils.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.d();
        float z = (float) jsonReader.z();
        float z2 = (float) jsonReader.z();
        while (jsonReader.R() != JsonReader.Token.END_ARRAY) {
            jsonReader.V();
        }
        jsonReader.v();
        return new PointF(z * f2, z2 * f2);
    }

    private static PointF b(JsonReader jsonReader, float f2) throws IOException {
        float z = (float) jsonReader.z();
        float z2 = (float) jsonReader.z();
        while (jsonReader.x()) {
            jsonReader.V();
        }
        return new PointF(z * f2, z2 * f2);
    }

    private static PointF c(JsonReader jsonReader, float f2) throws IOException {
        jsonReader.t();
        float f3 = 0.0f;
        float f4 = 0.0f;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                f3 = g(jsonReader);
            } else if (T != 1) {
                jsonReader.U();
                jsonReader.V();
            } else {
                f4 = g(jsonReader);
            }
        }
        jsonReader.w();
        return new PointF(f3 * f2, f4 * f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.d();
        int z = (int) (jsonReader.z() * 255.0d);
        int z2 = (int) (jsonReader.z() * 255.0d);
        int z3 = (int) (jsonReader.z() * 255.0d);
        while (jsonReader.x()) {
            jsonReader.V();
        }
        jsonReader.v();
        return Color.argb(255, z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(JsonReader jsonReader, float f2) throws IOException {
        int i2 = a.a[jsonReader.R().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return c(jsonReader, f2);
                }
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.R());
            }
            return a(jsonReader, f2);
        }
        return b(jsonReader, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> f(JsonReader jsonReader, float f2) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        while (jsonReader.R() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            arrayList.add(e(jsonReader, f2));
            jsonReader.v();
        }
        jsonReader.v();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token R = jsonReader.R();
        int i2 = a.a[R.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                jsonReader.d();
                float z = (float) jsonReader.z();
                while (jsonReader.x()) {
                    jsonReader.V();
                }
                jsonReader.v();
                return z;
            }
            throw new IllegalArgumentException("Unknown value for token of type " + R);
        }
        return (float) jsonReader.z();
    }
}

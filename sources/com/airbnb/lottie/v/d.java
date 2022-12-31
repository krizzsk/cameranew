package com.airbnb.lottie.v;

import androidx.annotation.Nullable;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.List;
/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class d {
    @Nullable
    private static <T> List<com.airbnb.lottie.x.a<T>> a(JsonReader jsonReader, float f2, com.airbnb.lottie.e eVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, eVar, f2, j0Var);
    }

    @Nullable
    private static <T> List<com.airbnb.lottie.x.a<T>> b(JsonReader jsonReader, com.airbnb.lottie.e eVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, eVar, 1.0f, j0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.a c(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.a(b(jsonReader, eVar, f.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.j d(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.j(b(jsonReader, eVar, h.a));
    }

    public static com.airbnb.lottie.model.h.b e(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return f(jsonReader, eVar, true);
    }

    public static com.airbnb.lottie.model.h.b f(JsonReader jsonReader, com.airbnb.lottie.e eVar, boolean z) throws IOException {
        return new com.airbnb.lottie.model.h.b(a(jsonReader, z ? com.airbnb.lottie.w.h.e() : 1.0f, eVar, i.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.c g(JsonReader jsonReader, com.airbnb.lottie.e eVar, int i2) throws IOException {
        return new com.airbnb.lottie.model.h.c(b(jsonReader, eVar, new l(i2)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.d h(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.d(b(jsonReader, eVar, o.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.f i(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.f(a(jsonReader, com.airbnb.lottie.w.h.e(), eVar, y.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.g j(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.g(b(jsonReader, eVar, c0.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.h.h k(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        return new com.airbnb.lottie.model.h.h(a(jsonReader, com.airbnb.lottie.w.h.e(), eVar, d0.a));
    }
}

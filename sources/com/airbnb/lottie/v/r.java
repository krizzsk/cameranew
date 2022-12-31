package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
class r {
    static JsonReader.a a = JsonReader.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<com.airbnb.lottie.x.a<T>> a(JsonReader jsonReader, com.airbnb.lottie.e eVar, float f2, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.R() == JsonReader.Token.STRING) {
            eVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.t();
        while (jsonReader.x()) {
            if (jsonReader.T(a) != 0) {
                jsonReader.V();
            } else if (jsonReader.R() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.d();
                if (jsonReader.R() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.b(jsonReader, eVar, f2, j0Var, false));
                } else {
                    while (jsonReader.x()) {
                        arrayList.add(q.b(jsonReader, eVar, f2, j0Var, true));
                    }
                }
                jsonReader.v();
            } else {
                arrayList.add(q.b(jsonReader, eVar, f2, j0Var, false));
            }
        }
        jsonReader.w();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends com.airbnb.lottie.x.a<T>> list) {
        int i2;
        T t;
        int size = list.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            com.airbnb.lottie.x.a<T> aVar = list.get(i3);
            i3++;
            com.airbnb.lottie.x.a<T> aVar2 = list.get(i3);
            aVar.f585f = Float.valueOf(aVar2.f584e);
            if (aVar.c == null && (t = aVar2.b) != null) {
                aVar.c = t;
                if (aVar instanceof com.airbnb.lottie.t.c.h) {
                    ((com.airbnb.lottie.t.c.h) aVar).i();
                }
            }
        }
        com.airbnb.lottie.x.a<T> aVar3 = list.get(i2);
        if ((aVar3.b == null || aVar3.c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}

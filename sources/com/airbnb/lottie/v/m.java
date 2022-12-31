package com.airbnb.lottie.v;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
public class m {
    private static final JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", "r", "hd");
    private static final JsonReader.a b = JsonReader.a.a(ContextChain.TAG_PRODUCT, "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.d a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType = null;
        com.airbnb.lottie.model.h.c cVar = null;
        com.airbnb.lottie.model.h.d dVar = null;
        com.airbnb.lottie.model.h.f fVar = null;
        com.airbnb.lottie.model.h.f fVar2 = null;
        boolean z = false;
        while (jsonReader.x()) {
            switch (jsonReader.T(a)) {
                case 0:
                    str = jsonReader.O();
                    break;
                case 1:
                    int i2 = -1;
                    jsonReader.t();
                    while (jsonReader.x()) {
                        int T = jsonReader.T(b);
                        if (T == 0) {
                            i2 = jsonReader.A();
                        } else if (T != 1) {
                            jsonReader.U();
                            jsonReader.V();
                        } else {
                            cVar = d.g(jsonReader, eVar, i2);
                        }
                    }
                    jsonReader.w();
                    break;
                case 2:
                    dVar = d.h(jsonReader, eVar);
                    break;
                case 3:
                    gradientType = jsonReader.A() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, eVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, eVar);
                    break;
                case 6:
                    fillType = jsonReader.A() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z = jsonReader.y();
                    break;
                default:
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.d(str, gradientType, fillType, cVar, dVar, fVar, fVar2, null, null, z);
    }
}

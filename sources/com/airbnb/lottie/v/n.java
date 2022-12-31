package com.airbnb.lottie.v;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class n {
    private static JsonReader.a a = JsonReader.a.a("nm", "g", "o", "t", "s", "e", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, "lc", "lj", "ml", "hd", "d");
    private static final JsonReader.a b = JsonReader.a.a(ContextChain.TAG_PRODUCT, "k");
    private static final JsonReader.a c = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.content.e a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        com.airbnb.lottie.model.h.c cVar;
        ArrayList arrayList = new ArrayList();
        String str = null;
        GradientType gradientType = null;
        com.airbnb.lottie.model.h.c cVar2 = null;
        com.airbnb.lottie.model.h.d dVar = null;
        com.airbnb.lottie.model.h.f fVar = null;
        com.airbnb.lottie.model.h.f fVar2 = null;
        com.airbnb.lottie.model.h.b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        com.airbnb.lottie.model.h.b bVar2 = null;
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
                        if (T != 0) {
                            cVar = cVar2;
                            if (T != 1) {
                                jsonReader.U();
                                jsonReader.V();
                            } else {
                                cVar2 = d.g(jsonReader, eVar, i2);
                            }
                        } else {
                            cVar = cVar2;
                            i2 = jsonReader.A();
                        }
                        cVar2 = cVar;
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
                    bVar = d.e(jsonReader, eVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.A() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.A() - 1];
                    break;
                case 9:
                    f2 = (float) jsonReader.z();
                    break;
                case 10:
                    z = jsonReader.y();
                    break;
                case 11:
                    jsonReader.d();
                    while (jsonReader.x()) {
                        jsonReader.t();
                        String str2 = null;
                        com.airbnb.lottie.model.h.b bVar3 = null;
                        while (jsonReader.x()) {
                            int T2 = jsonReader.T(c);
                            if (T2 != 0) {
                                com.airbnb.lottie.model.h.b bVar4 = bVar2;
                                if (T2 != 1) {
                                    jsonReader.U();
                                    jsonReader.V();
                                } else {
                                    bVar3 = d.e(jsonReader, eVar);
                                }
                                bVar2 = bVar4;
                            } else {
                                str2 = jsonReader.O();
                            }
                        }
                        com.airbnb.lottie.model.h.b bVar5 = bVar2;
                        jsonReader.w();
                        if (str2.equals("o")) {
                            bVar2 = bVar3;
                        } else {
                            if (str2.equals("d") || str2.equals("g")) {
                                eVar.t(true);
                                arrayList.add(bVar3);
                            }
                            bVar2 = bVar5;
                        }
                    }
                    com.airbnb.lottie.model.h.b bVar6 = bVar2;
                    jsonReader.v();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    bVar2 = bVar6;
                    break;
                default:
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
        }
        return new com.airbnb.lottie.model.content.e(str, gradientType, cVar2, dVar, fVar, fVar2, bVar, lineCapType, lineJoinType, f2, arrayList, bVar2, z);
    }
}

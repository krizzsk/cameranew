package com.airbnb.lottie.v;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
public class h0 {
    private static JsonReader.a a = JsonReader.a.a("nm", "c", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, "o", "lc", "lj", "ml", "hd", "d");
    private static final JsonReader.a b = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ShapeStroke a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        char c;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.airbnb.lottie.model.h.b bVar = null;
        com.airbnb.lottie.model.h.a aVar = null;
        com.airbnb.lottie.model.h.d dVar = null;
        com.airbnb.lottie.model.h.b bVar2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        float f2 = 0.0f;
        boolean z = false;
        while (jsonReader.x()) {
            switch (jsonReader.T(a)) {
                case 0:
                    str = jsonReader.O();
                    break;
                case 1:
                    aVar = d.c(jsonReader, eVar);
                    break;
                case 2:
                    bVar2 = d.e(jsonReader, eVar);
                    break;
                case 3:
                    dVar = d.h(jsonReader, eVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.A() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.A() - 1];
                    break;
                case 6:
                    f2 = (float) jsonReader.z();
                    break;
                case 7:
                    z = jsonReader.y();
                    break;
                case 8:
                    jsonReader.d();
                    while (jsonReader.x()) {
                        jsonReader.t();
                        String str2 = null;
                        com.airbnb.lottie.model.h.b bVar3 = null;
                        while (jsonReader.x()) {
                            int T = jsonReader.T(b);
                            if (T == 0) {
                                str2 = jsonReader.O();
                            } else if (T != 1) {
                                jsonReader.U();
                                jsonReader.V();
                            } else {
                                bVar3 = d.e(jsonReader, eVar);
                            }
                        }
                        jsonReader.w();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                                eVar.t(true);
                                arrayList.add(bVar3);
                                break;
                            case 2:
                                bVar = bVar3;
                                break;
                        }
                    }
                    jsonReader.v();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.V();
                    break;
            }
        }
        return new ShapeStroke(str, bVar, arrayList, aVar, dVar, bVar2, lineCapType, lineJoinType, f2, z);
    }
}

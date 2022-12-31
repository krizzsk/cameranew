package com.airbnb.lottie.v;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {
    private static final JsonReader.a a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SW, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SH, "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "op", "tm", "cl", "hd");
    private static final JsonReader.a b = JsonReader.a.a("d", "a");
    private static final JsonReader.a c = JsonReader.a.a("nm");

    public static Layer a(com.airbnb.lottie.e eVar) {
        Rect b2 = eVar.b();
        return new Layer(Collections.emptyList(), eVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new com.airbnb.lottie.model.h.l(), 0, 0, 0, 0.0f, 0.0f, b2.width(), b2.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer b(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.t();
        Float valueOf = Float.valueOf(1.0f);
        Float valueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String str = null;
        com.airbnb.lottie.model.h.l lVar = null;
        com.airbnb.lottie.model.h.j jVar = null;
        com.airbnb.lottie.model.h.k kVar = null;
        com.airbnb.lottie.model.h.b bVar = null;
        long j2 = -1;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f4 = 1.0f;
        float f5 = 0.0f;
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        long j3 = 0;
        String str2 = null;
        String str3 = "UNSET";
        while (jsonReader.x()) {
            switch (jsonReader.T(a)) {
                case 0:
                    str3 = jsonReader.O();
                    break;
                case 1:
                    j3 = jsonReader.A();
                    break;
                case 2:
                    str = jsonReader.O();
                    break;
                case 3:
                    int A = jsonReader.A();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (A >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[A];
                        break;
                    }
                case 4:
                    j2 = jsonReader.A();
                    break;
                case 5:
                    i2 = (int) (jsonReader.A() * com.airbnb.lottie.w.h.e());
                    break;
                case 6:
                    i3 = (int) (jsonReader.A() * com.airbnb.lottie.w.h.e());
                    break;
                case 7:
                    i4 = Color.parseColor(jsonReader.O());
                    break;
                case 8:
                    lVar = c.g(jsonReader, eVar);
                    break;
                case 9:
                    matteType2 = Layer.MatteType.values()[jsonReader.A()];
                    eVar.q(1);
                    break;
                case 10:
                    jsonReader.d();
                    while (jsonReader.x()) {
                        arrayList3.add(u.a(jsonReader, eVar));
                    }
                    eVar.q(arrayList3.size());
                    jsonReader.v();
                    break;
                case 11:
                    jsonReader.d();
                    while (jsonReader.x()) {
                        com.airbnb.lottie.model.content.b a2 = g.a(jsonReader, eVar);
                        if (a2 != null) {
                            arrayList4.add(a2);
                        }
                    }
                    jsonReader.v();
                    break;
                case 12:
                    jsonReader.t();
                    while (jsonReader.x()) {
                        int T = jsonReader.T(b);
                        if (T == 0) {
                            jVar = d.d(jsonReader, eVar);
                        } else if (T != 1) {
                            jsonReader.U();
                            jsonReader.V();
                        } else {
                            jsonReader.d();
                            if (jsonReader.x()) {
                                kVar = b.a(jsonReader, eVar);
                            }
                            while (jsonReader.x()) {
                                jsonReader.V();
                            }
                            jsonReader.v();
                        }
                    }
                    jsonReader.w();
                    break;
                case 13:
                    jsonReader.d();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.x()) {
                        jsonReader.t();
                        while (jsonReader.x()) {
                            if (jsonReader.T(c) != 0) {
                                jsonReader.U();
                                jsonReader.V();
                            } else {
                                arrayList5.add(jsonReader.O());
                            }
                        }
                        jsonReader.w();
                    }
                    jsonReader.v();
                    eVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f4 = (float) jsonReader.z();
                    break;
                case 15:
                    f5 = (float) jsonReader.z();
                    break;
                case 16:
                    i5 = (int) (jsonReader.A() * com.airbnb.lottie.w.h.e());
                    break;
                case 17:
                    i6 = (int) (jsonReader.A() * com.airbnb.lottie.w.h.e());
                    break;
                case 18:
                    f2 = (float) jsonReader.z();
                    break;
                case 19:
                    f3 = (float) jsonReader.z();
                    break;
                case 20:
                    bVar = d.f(jsonReader, eVar, false);
                    break;
                case 21:
                    str2 = jsonReader.O();
                    break;
                case 22:
                    z = jsonReader.y();
                    break;
                default:
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.w();
        float f6 = f2 / f4;
        float f7 = f3 / f4;
        ArrayList arrayList6 = new ArrayList();
        if (f6 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new com.airbnb.lottie.x.a(eVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f6)));
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
        }
        if (f7 <= 0.0f) {
            f7 = eVar.f();
        }
        arrayList2.add(new com.airbnb.lottie.x.a(eVar, valueOf, valueOf, null, f6, Float.valueOf(f7)));
        arrayList2.add(new com.airbnb.lottie.x.a(eVar, valueOf2, valueOf2, null, f7, Float.valueOf(Float.MAX_VALUE)));
        if (str3.endsWith(".ai") || "ai".equals(str2)) {
            eVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, eVar, str3, j3, layerType, j2, str, arrayList, lVar, i2, i3, i4, f4, f5, i5, i6, jVar, kVar, arrayList2, matteType2, bVar, z);
    }
}

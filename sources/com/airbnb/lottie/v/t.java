package com.airbnb.lottie.v;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.facebook.common.callercontext.ContextChain;
import com.tapjoy.TapjoyAuctionFlags;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {
    private static final JsonReader.a a = JsonReader.a.a(PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, IjkMediaPlayer.OnNativeInvokeListener.ARG_IP, "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    static JsonReader.a b = JsonReader.a.a(TapjoyAuctionFlags.AUCTION_ID, "layers", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.H, ContextChain.TAG_PRODUCT, "u");
    private static final JsonReader.a c = JsonReader.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.a f571d = JsonReader.a.a("cm", "tm", "dr");

    public static com.airbnb.lottie.e a(JsonReader jsonReader) throws IOException {
        HashMap hashMap;
        ArrayList arrayList;
        JsonReader jsonReader2 = jsonReader;
        float e2 = com.airbnb.lottie.w.h.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<com.airbnb.lottie.model.c> sparseArrayCompat = new SparseArrayCompat<>();
        com.airbnb.lottie.e eVar = new com.airbnb.lottie.e();
        jsonReader.t();
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        int i3 = 0;
        while (jsonReader.x()) {
            switch (jsonReader2.T(a)) {
                case 0:
                    i2 = jsonReader.A();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i3 = jsonReader.A();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f2 = (float) jsonReader.z();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f3 = ((float) jsonReader.z()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f4 = (float) jsonReader.z();
                    break;
                case 5:
                    String[] split = jsonReader.O().split("\\.");
                    if (!com.airbnb.lottie.w.h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        eVar.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(jsonReader2, eVar, arrayList2, longSparseArray);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(jsonReader2, eVar, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(jsonReader2, eVar, sparseArrayCompat);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(jsonReader2, eVar, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        eVar.r(new Rect(0, 0, (int) (i2 * e2), (int) (i3 * e2)), f2, f3, f4, arrayList2, longSparseArray, hashMap2, hashMap3, sparseArrayCompat, hashMap4, arrayList3);
        return eVar;
    }

    private static void b(JsonReader jsonReader, com.airbnb.lottie.e eVar, Map<String, List<Layer>> map, Map<String, com.airbnb.lottie.h> map2) throws IOException {
        jsonReader.d();
        while (jsonReader.x()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.t();
            String str = null;
            String str2 = null;
            String str3 = null;
            int i2 = 0;
            int i3 = 0;
            while (jsonReader.x()) {
                int T = jsonReader.T(b);
                if (T == 0) {
                    str = jsonReader.O();
                } else if (T == 1) {
                    jsonReader.d();
                    while (jsonReader.x()) {
                        Layer b2 = s.b(jsonReader, eVar);
                        longSparseArray.put(b2.b(), b2);
                        arrayList.add(b2);
                    }
                    jsonReader.v();
                } else if (T == 2) {
                    i2 = jsonReader.A();
                } else if (T == 3) {
                    i3 = jsonReader.A();
                } else if (T == 4) {
                    str2 = jsonReader.O();
                } else if (T != 5) {
                    jsonReader.U();
                    jsonReader.V();
                } else {
                    str3 = jsonReader.O();
                }
            }
            jsonReader.w();
            if (str2 != null) {
                com.airbnb.lottie.h hVar = new com.airbnb.lottie.h(i2, i3, str, str2, str3);
                map2.put(hVar.d(), hVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.v();
    }

    private static void c(JsonReader jsonReader, com.airbnb.lottie.e eVar, SparseArrayCompat<com.airbnb.lottie.model.c> sparseArrayCompat) throws IOException {
        jsonReader.d();
        while (jsonReader.x()) {
            com.airbnb.lottie.model.c a2 = j.a(jsonReader, eVar);
            sparseArrayCompat.put(a2.hashCode(), a2);
        }
        jsonReader.v();
    }

    private static void d(JsonReader jsonReader, Map<String, com.airbnb.lottie.model.b> map) throws IOException {
        jsonReader.t();
        while (jsonReader.x()) {
            if (jsonReader.T(c) != 0) {
                jsonReader.U();
                jsonReader.V();
            } else {
                jsonReader.d();
                while (jsonReader.x()) {
                    com.airbnb.lottie.model.b a2 = k.a(jsonReader);
                    map.put(a2.b(), a2);
                }
                jsonReader.v();
            }
        }
        jsonReader.w();
    }

    private static void e(JsonReader jsonReader, com.airbnb.lottie.e eVar, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.d();
        int i2 = 0;
        while (jsonReader.x()) {
            Layer b2 = s.b(jsonReader, eVar);
            if (b2.d() == Layer.LayerType.IMAGE) {
                i2++;
            }
            list.add(b2);
            longSparseArray.put(b2.b(), b2);
            if (i2 > 4) {
                com.airbnb.lottie.w.d.c("You have " + i2 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.v();
    }

    private static void f(JsonReader jsonReader, com.airbnb.lottie.e eVar, List<com.airbnb.lottie.model.f> list) throws IOException {
        jsonReader.d();
        while (jsonReader.x()) {
            String str = null;
            jsonReader.t();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (jsonReader.x()) {
                int T = jsonReader.T(f571d);
                if (T == 0) {
                    str = jsonReader.O();
                } else if (T == 1) {
                    f2 = (float) jsonReader.z();
                } else if (T != 2) {
                    jsonReader.U();
                    jsonReader.V();
                } else {
                    f3 = (float) jsonReader.z();
                }
            }
            jsonReader.w();
            list.add(new com.airbnb.lottie.model.f(str, f2, f3));
        }
        jsonReader.v();
    }
}

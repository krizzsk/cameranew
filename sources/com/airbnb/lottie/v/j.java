package com.airbnb.lottie.v;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.tapjoy.TJAdUnitConstants;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
import java.util.ArrayList;
import us.pinguo.bigalbum.db.BigAlbumStore;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
public class j {
    private static final JsonReader.a a = JsonReader.a.a("ch", BigAlbumStore.PhotoColumns.SIZE, PercentLayoutHelper.PercentLayoutInfo.BASEMODE.W, TJAdUnitConstants.String.STYLE, "fFamily", "data");
    private static final JsonReader.a b = JsonReader.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.c a(JsonReader jsonReader, com.airbnb.lottie.e eVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.t();
        String str = null;
        String str2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        char c = 0;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                c = jsonReader.O().charAt(0);
            } else if (T == 1) {
                d2 = jsonReader.z();
            } else if (T == 2) {
                d3 = jsonReader.z();
            } else if (T == 3) {
                str = jsonReader.O();
            } else if (T == 4) {
                str2 = jsonReader.O();
            } else if (T != 5) {
                jsonReader.U();
                jsonReader.V();
            } else {
                jsonReader.t();
                while (jsonReader.x()) {
                    if (jsonReader.T(b) != 0) {
                        jsonReader.U();
                        jsonReader.V();
                    } else {
                        jsonReader.d();
                        while (jsonReader.x()) {
                            arrayList.add((com.airbnb.lottie.model.content.j) g.a(jsonReader, eVar));
                        }
                        jsonReader.v();
                    }
                }
                jsonReader.w();
            }
        }
        jsonReader.w();
        return new com.airbnb.lottie.model.c(arrayList, c, d2, d3, str, str2);
    }
}

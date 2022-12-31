package com.airbnb.lottie.v;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class v {
    private static final JsonReader.a a = JsonReader.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z = false;
        while (jsonReader.x()) {
            int T = jsonReader.T(a);
            if (T == 0) {
                str = jsonReader.O();
            } else if (T == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.A());
            } else if (T != 2) {
                jsonReader.U();
                jsonReader.V();
            } else {
                z = jsonReader.y();
            }
        }
        return new MergePaths(str, mergePathsMode, z);
    }
}

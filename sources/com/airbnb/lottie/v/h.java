package com.airbnb.lottie.v;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zhy.android.percent.support.PercentLayoutHelper;
import java.io.IOException;
/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<DocumentData> {
    public static final h a = new h();
    private static final JsonReader.a b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", PercentLayoutHelper.PercentLayoutInfo.BASEMODE.SW, "of");

    private h() {
    }

    @Override // com.airbnb.lottie.v.j0
    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f2) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.t();
        DocumentData.Justification justification2 = justification;
        String str = null;
        String str2 = null;
        float f3 = 0.0f;
        int i2 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i3 = 0;
        int i4 = 0;
        float f6 = 0.0f;
        boolean z = true;
        while (jsonReader.x()) {
            switch (jsonReader.T(b)) {
                case 0:
                    str = jsonReader.O();
                    break;
                case 1:
                    str2 = jsonReader.O();
                    break;
                case 2:
                    f3 = (float) jsonReader.z();
                    break;
                case 3:
                    int A = jsonReader.A();
                    justification2 = DocumentData.Justification.CENTER;
                    if (A <= justification2.ordinal() && A >= 0) {
                        justification2 = DocumentData.Justification.values()[A];
                        break;
                    }
                    break;
                case 4:
                    i2 = jsonReader.A();
                    break;
                case 5:
                    f4 = (float) jsonReader.z();
                    break;
                case 6:
                    f5 = (float) jsonReader.z();
                    break;
                case 7:
                    i3 = p.d(jsonReader);
                    break;
                case 8:
                    i4 = p.d(jsonReader);
                    break;
                case 9:
                    f6 = (float) jsonReader.z();
                    break;
                case 10:
                    z = jsonReader.y();
                    break;
                default:
                    jsonReader.U();
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.w();
        return new DocumentData(str, str2, f3, justification2, i2, f4, f5, i3, i4, f6, z);
    }
}

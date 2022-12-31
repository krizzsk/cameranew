package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.tencent.open.SocialConstants;
import java.io.IOException;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmy {
    private int code;
    private String description;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmy(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        jsonReader.beginObject();
        int i2 = 3;
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals(SocialConstants.PARAM_COMMENT)) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("code")) {
                jsonReader.skipValue();
            } else {
                i2 = jsonReader.nextInt();
            }
        }
        jsonReader.endObject();
        this.code = i2;
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }
}

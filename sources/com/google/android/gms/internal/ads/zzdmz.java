package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdmz {
    public final int height;
    public final int width;
    public final boolean zzhkf;

    public zzdmz(int i2, int i3, boolean z) {
        this.width = i2;
        this.height = i3;
        this.zzhkf = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<zzdmz> zze(JsonReader jsonReader) throws IllegalStateException, IOException, NumberFormatException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if ("width".equals(nextName)) {
                    i2 = jsonReader.nextInt();
                } else if ("height".equals(nextName)) {
                    i3 = jsonReader.nextInt();
                } else if ("is_fluid_height".equals(nextName)) {
                    z = jsonReader.nextBoolean();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            arrayList.add(new zzdmz(i2, i3, z));
        }
        jsonReader.endArray();
        return arrayList;
    }
}

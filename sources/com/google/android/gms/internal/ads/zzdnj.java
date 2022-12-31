package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.common.util.k;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdnj {
    public final zzdnb zzess;
    public final List<zzdmw> zzhkp;
    public final List<zzdni> zzhkq;

    private zzdnj(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException, AssertionError {
        List<zzdmw> emptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzdnb zzdnbVar = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if ("responses".equals(nextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(nextName2)) {
                        emptyList = new ArrayList<>();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            emptyList.add(new zzdmw(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (nextName2.equals("common")) {
                        zzdnbVar = new zzdnb(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (nextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String str = null;
                    Map<String, String> map = null;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        if ("name".equals(nextName3)) {
                            str = jsonReader.nextString();
                        } else if (TJAdUnitConstants.String.VIDEO_INFO.equals(nextName3)) {
                            map = com.google.android.gms.ads.internal.util.zzbh.zzb(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (str != null) {
                        arrayList.add(new zzdni(str, map));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzhkq = arrayList;
        this.zzhkp = emptyList;
        this.zzess = zzdnbVar == null ? new zzdnb(new JsonReader(new StringReader("{}"))) : zzdnbVar;
    }

    public static zzdnj zza(Reader reader) throws zzdna {
        try {
            try {
                return new zzdnj(new JsonReader(reader));
            } finally {
                k.a(reader);
            }
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e2) {
            throw new zzdna("unable to parse ServerResponse", e2);
        }
    }
}

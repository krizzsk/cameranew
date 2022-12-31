package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;
import us.pinguo.inspire.api.QiniuAuthToken;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzcfb {
    private final Executor executor;
    private final zzcer zzghm;

    public zzcfb(Executor executor, zzcer zzcerVar) {
        this.executor = executor;
        this.zzghm = zzcerVar;
    }

    public final zzdzw<List<zzcfg>> zzg(JSONObject jSONObject, String str) {
        zzdzw zzag;
        final String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdzk.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                String optString2 = optJSONObject.optString("type");
                if (TypedValues.Custom.S_STRING.equals(optString2)) {
                    c = 1;
                } else {
                    c = QiniuAuthToken.TYPE_IMAGE.equals(optString2) ? (char) 2 : (char) 0;
                }
                if (c == 1) {
                    zzag = zzdzk.zzag(new zzcfg(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzag = zzdzk.zzb(this.zzghm.zzc(optJSONObject, "image_value"), new zzdvz(optString) { // from class: com.google.android.gms.internal.ads.zzcfd
                        private final String zzdlh;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdlh = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdvz
                        public final Object apply(Object obj) {
                            return new zzcfg(this.zzdlh, (zzaed) obj);
                        }
                    }, this.executor);
                }
                arrayList.add(zzag);
            }
            zzag = zzdzk.zzag(null);
            arrayList.add(zzag);
        }
        return zzdzk.zzb(zzdzk.zzi(arrayList), zzcfe.zzeaj, this.executor);
    }
}

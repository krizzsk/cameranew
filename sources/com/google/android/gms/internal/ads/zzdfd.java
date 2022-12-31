package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads@@19.7.0 */
/* loaded from: classes2.dex */
public final class zzdfd implements zzdfi<zzdfj<Bundle>> {
    private final Context zzaad;
    private final zzdzv zzghl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdfd(zzdzv zzdzvVar, Context context) {
        this.zzghl = zzdzvVar;
        this.zzaad = context;
    }

    public static Bundle zza(Context context, JSONArray jSONArray) {
        int i2;
        Object obj;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i3);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString("sk");
            int optInt = optJSONObject.optInt("type", -1);
            if (optInt == 0) {
                i2 = zzdfh.zzhdh;
            } else if (optInt != 1) {
                i2 = optInt != 2 ? 0 : zzdfh.zzhdj;
            } else {
                i2 = zzdfh.zzhdi;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i2 != 0) {
                String[] split = optString2.split("/");
                if (split.length > 2 || split.length == 0) {
                    obj = null;
                } else {
                    if (split.length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i4 = zzdfe.zzhdg[i2 - 1];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 == 3 && (obj instanceof Boolean)) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdfi
    public final zzdzw<zzdfj<Bundle>> zzasy() {
        return this.zzghl.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfc
            private final zzdfd zzhdf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdf = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdf.zzatp();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdfj zzatp() throws Exception {
        String str = (String) zzwr.zzqr().zzd(zzabp.zzcxu);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Bundle zza = zza(this.zzaad, new JSONArray(str));
            return new zzdfj(zza) { // from class: com.google.android.gms.internal.ads.zzdff
                private final Bundle zzebm;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzebm = zza;
                }

                @Override // com.google.android.gms.internal.ads.zzdfj
                public final void zzr(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", this.zzebm);
                }
            };
        } catch (JSONException e2) {
            zzazk.zzb("JSON parsing error", e2);
            return null;
        }
    }
}

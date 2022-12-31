package com.google.android.gms.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzvg;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.7.0 */
/* loaded from: classes2.dex */
public class AdError {
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int a;
    @NonNull
    private final String b;
    @NonNull
    private final String c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final AdError f3436d;

    public AdError(int i2, @NonNull String str, @NonNull String str2) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.f3436d = null;
    }

    @Nullable
    public AdError getCause() {
        return this.f3436d;
    }

    public int getCode() {
        return this.a;
    }

    @NonNull
    public String getDomain() {
        return this.c;
    }

    @NonNull
    public String getMessage() {
        return this.b;
    }

    public String toString() {
        try {
            return zzdr().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @NonNull
    public final zzvg zzdq() {
        zzvg zzvgVar;
        if (this.f3436d == null) {
            zzvgVar = null;
        } else {
            AdError adError = this.f3436d;
            zzvgVar = new zzvg(adError.a, adError.b, adError.c, null, null);
        }
        return new zzvg(this.a, this.b, this.c, zzvgVar, null);
    }

    public JSONObject zzdr() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Code", this.a);
        jSONObject.put("Message", this.b);
        jSONObject.put("Domain", this.c);
        AdError adError = this.f3436d;
        if (adError == null) {
            jSONObject.put("Cause", "null");
        } else {
            jSONObject.put("Cause", adError.zzdr());
        }
        return jSONObject;
    }

    public AdError(int i2, @NonNull String str, @NonNull String str2, @NonNull AdError adError) {
        this.a = i2;
        this.b = str;
        this.c = str2;
        this.f3436d = adError;
    }
}

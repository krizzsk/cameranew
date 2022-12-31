package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.h;
import com.tapjoy.TapjoyAuctionFlags;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: com.google.android.gms:play-services-base@@17.2.1 */
/* loaded from: classes2.dex */
public class GoogleSignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a();
    private static Clock zaf = h.getInstance();
    private String mId;
    private final int versionCode;
    private String zag;
    private String zah;
    private String zai;
    private Uri zaj;
    private String zak;
    private long zal;
    private String zam;
    private List<Scope> zan;
    private String zao;
    private String zap;
    private Set<Scope> zaq = new HashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j2, String str6, List<Scope> list, String str7, String str8) {
        this.versionCode = i2;
        this.mId = str;
        this.zag = str2;
        this.zah = str3;
        this.zai = str4;
        this.zaj = uri;
        this.zak = str5;
        this.zal = j2;
        this.zam = str6;
        this.zan = list;
        this.zao = str7;
        this.zap = str8;
    }

    @Nullable
    public static GoogleSignInAccount Z(@Nullable String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a0 = a0(jSONObject.optString(TapjoyAuctionFlags.AUCTION_ID), jSONObject.optString("tokenId", null), jSONObject.optString(NotificationCompat.CATEGORY_EMAIL, null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a0.zak = jSONObject.optString("serverAuthCode", null);
        return a0;
    }

    private static GoogleSignInAccount a0(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Uri uri, @Nullable Long l2, @NonNull String str7, @NonNull Set<Scope> set) {
        long longValue = (l2 == null ? Long.valueOf(zaf.currentTimeMillis() / 1000) : l2).longValue();
        q.f(str7);
        q.j(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    @Nullable
    public String Q() {
        return this.zai;
    }

    @Nullable
    public String R() {
        return this.zah;
    }

    @Nullable
    public String S() {
        return this.zap;
    }

    @Nullable
    public String T() {
        return this.zao;
    }

    @Nullable
    public String U() {
        return this.mId;
    }

    @Nullable
    public String V() {
        return this.zag;
    }

    @Nullable
    public Uri W() {
        return this.zaj;
    }

    @NonNull
    public Set<Scope> X() {
        HashSet hashSet = new HashSet(this.zan);
        hashSet.addAll(this.zaq);
        return hashSet;
    }

    @Nullable
    public String Y() {
        return this.zak;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.zam.equals(this.zam) && googleSignInAccount.X().equals(X());
        }
        return false;
    }

    public int hashCode() {
        return ((this.zam.hashCode() + 527) * 31) + X().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.m(parcel, 1, this.versionCode);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 2, U(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 3, V(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 4, R(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 5, Q(), false);
        com.google.android.gms.common.internal.safeparcel.a.t(parcel, 6, W(), i2, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 7, Y(), false);
        com.google.android.gms.common.internal.safeparcel.a.q(parcel, 8, this.zal);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 9, this.zam, false);
        com.google.android.gms.common.internal.safeparcel.a.z(parcel, 10, this.zan, false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 11, T(), false);
        com.google.android.gms.common.internal.safeparcel.a.v(parcel, 12, S(), false);
        com.google.android.gms.common.internal.safeparcel.a.b(parcel, a);
    }

    @Nullable
    public Account y() {
        if (this.zah == null) {
            return null;
        }
        return new Account(this.zah, "com.google");
    }
}

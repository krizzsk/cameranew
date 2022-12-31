package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.internal.x;
import com.facebook.internal.y;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class Profile implements Parcelable {
    private static final String FIRST_NAME_KEY = "first_name";
    private static final String ID_KEY = "id";
    private static final String LAST_NAME_KEY = "last_name";
    private static final String LINK_URI_KEY = "link_uri";
    private static final String MIDDLE_NAME_KEY = "middle_name";
    private static final String NAME_KEY = "name";
    @Nullable
    private final String firstName;
    @Nullable
    private final String id;
    @Nullable
    private final String lastName;
    @Nullable
    private final Uri linkUri;
    @Nullable
    private final String middleName;
    @Nullable
    private final String name;
    private static final String TAG = Profile.class.getSimpleName();
    public static final Parcelable.Creator<Profile> CREATOR = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements x.c {
        a() {
        }

        @Override // com.facebook.internal.x.c
        public void a(JSONObject jSONObject) {
            String optString = jSONObject.optString("id");
            if (optString == null) {
                Log.w(Profile.TAG, "No user ID returned on Me request");
                return;
            }
            String optString2 = jSONObject.optString("link");
            Profile.f(new Profile(optString, jSONObject.optString(Profile.FIRST_NAME_KEY), jSONObject.optString(Profile.MIDDLE_NAME_KEY), jSONObject.optString(Profile.LAST_NAME_KEY), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null));
        }

        @Override // com.facebook.internal.x.c
        public void b(FacebookException facebookException) {
            String str = Profile.TAG;
            Log.e(str, "Got unexpected exception: " + facebookException);
        }
    }

    /* loaded from: classes.dex */
    static class b implements Parcelable.Creator<Profile> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Profile createFromParcel(Parcel parcel) {
            return new Profile(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Profile[] newArray(int i2) {
            return new Profile[i2];
        }
    }

    /* synthetic */ Profile(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static void b() {
        AccessToken j2 = AccessToken.j();
        if (!AccessToken.x()) {
            f(null);
        } else {
            x.z(j2.t(), new a());
        }
    }

    public static Profile c() {
        return k.b().a();
    }

    public static void f(@Nullable Profile profile) {
        k.b().e(profile);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Profile) {
            Profile profile = (Profile) obj;
            String str = this.id;
            if (str != null ? str.equals(profile.id) : profile.id == null) {
                String str2 = this.firstName;
                if (str2 != null ? str2.equals(profile.firstName) : profile.firstName == null) {
                    String str3 = this.middleName;
                    if (str3 != null ? str3.equals(profile.middleName) : profile.middleName == null) {
                        String str4 = this.lastName;
                        if (str4 != null ? str4.equals(profile.lastName) : profile.lastName == null) {
                            String str5 = this.name;
                            if (str5 != null ? str5.equals(profile.name) : profile.name == null) {
                                Uri uri = this.linkUri;
                                Uri uri2 = profile.linkUri;
                                if (uri == null) {
                                    if (uri2 == null) {
                                        return true;
                                    }
                                } else if (uri.equals(uri2)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.id);
            jSONObject.put(FIRST_NAME_KEY, this.firstName);
            jSONObject.put(MIDDLE_NAME_KEY, this.middleName);
            jSONObject.put(LAST_NAME_KEY, this.lastName);
            jSONObject.put("name", this.name);
            Uri uri = this.linkUri;
            if (uri != null) {
                jSONObject.put(LINK_URI_KEY, uri.toString());
                return jSONObject;
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public int hashCode() {
        int hashCode = 527 + this.id.hashCode();
        String str = this.firstName;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.middleName;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.lastName;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.name;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        Uri uri = this.linkUri;
        return uri != null ? (hashCode * 31) + uri.hashCode() : hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeString(this.firstName);
        parcel.writeString(this.middleName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.name);
        Uri uri = this.linkUri;
        parcel.writeString(uri == null ? null : uri.toString());
    }

    public Profile(String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Uri uri) {
        y.m(str, "id");
        this.id = str;
        this.firstName = str2;
        this.middleName = str3;
        this.lastName = str4;
        this.name = str5;
        this.linkUri = uri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Profile(JSONObject jSONObject) {
        this.id = jSONObject.optString("id", null);
        this.firstName = jSONObject.optString(FIRST_NAME_KEY, null);
        this.middleName = jSONObject.optString(MIDDLE_NAME_KEY, null);
        this.lastName = jSONObject.optString(LAST_NAME_KEY, null);
        this.name = jSONObject.optString("name", null);
        String optString = jSONObject.optString(LINK_URI_KEY, null);
        this.linkUri = optString != null ? Uri.parse(optString) : null;
    }

    private Profile(Parcel parcel) {
        this.id = parcel.readString();
        this.firstName = parcel.readString();
        this.middleName = parcel.readString();
        this.lastName = parcel.readString();
        this.name = parcel.readString();
        String readString = parcel.readString();
        this.linkUri = readString == null ? null : Uri.parse(readString);
    }
}

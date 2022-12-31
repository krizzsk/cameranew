package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.x;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;
    static final b a = new b(200, 299, null);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new a();

    /* loaded from: classes.dex */
    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT
    }

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<FacebookRequestError> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            return new FacebookRequestError(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public FacebookRequestError[] newArray(int i2) {
            return new FacebookRequestError[i2];
        }
    }

    /* loaded from: classes.dex */
    private static class b {
        private final int a;
        private final int b;

        /* synthetic */ b(int i2, int i3, a aVar) {
            this(i2, i3);
        }

        boolean a(int i2) {
            return this.a <= i2 && i2 <= this.b;
        }

        private b(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }
    }

    /* synthetic */ FacebookRequestError(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FacebookRequestError a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        int optInt;
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        int i2;
        try {
            if (jSONObject.has("code")) {
                int i3 = jSONObject.getInt("code");
                Object E = x.E(jSONObject, BODY_KEY, "FACEBOOK_NON_JSON_RESULT");
                if (E != null && (E instanceof JSONObject)) {
                    JSONObject jSONObject2 = (JSONObject) E;
                    boolean z2 = false;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) x.E(jSONObject2, "error", null);
                        String optString = jSONObject3.optString("type", null);
                        String optString2 = jSONObject3.optString("message", null);
                        i2 = jSONObject3.optInt("code", -1);
                        int optInt2 = jSONObject3.optInt(ERROR_SUB_CODE_KEY, -1);
                        str3 = jSONObject3.optString(ERROR_USER_MSG_KEY, null);
                        str4 = jSONObject3.optString(ERROR_USER_TITLE_KEY, null);
                        z = jSONObject3.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        str = optString;
                        z2 = true;
                        str2 = optString2;
                        optInt = optInt2;
                    } else {
                        if (!jSONObject2.has(ERROR_CODE_KEY) && !jSONObject2.has(ERROR_MSG_KEY) && !jSONObject2.has(ERROR_REASON_KEY)) {
                            str = null;
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            i2 = -1;
                            optInt = -1;
                            z = false;
                        }
                        String optString3 = jSONObject2.optString(ERROR_REASON_KEY, null);
                        String optString4 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        int optInt3 = jSONObject2.optInt(ERROR_CODE_KEY, -1);
                        optInt = jSONObject2.optInt(ERROR_SUB_CODE_KEY, -1);
                        str = optString3;
                        str2 = optString4;
                        str3 = null;
                        str4 = null;
                        z2 = true;
                        z = false;
                        i2 = optInt3;
                    }
                    if (z2) {
                        return new FacebookRequestError(i3, i2, optInt, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    }
                }
                if (!a.a(i3)) {
                    return new FacebookRequestError(i3, -1, -1, null, null, null, null, false, jSONObject.has(BODY_KEY) ? (JSONObject) x.E(jSONObject, BODY_KEY, "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null);
                }
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    static synchronized FacebookRequestErrorClassification b() {
        synchronized (FacebookRequestError.class) {
            com.facebook.internal.l j2 = FetchedAppSettingsManager.j(f.g());
            if (j2 == null) {
                return FacebookRequestErrorClassification.c();
            }
            return j2.e();
        }
    }

    public int c() {
        return this.errorCode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String f() {
        String str = this.errorMessage;
        return str != null ? str : this.exception.getLocalizedMessage();
    }

    public String g() {
        return this.errorType;
    }

    public FacebookException h() {
        return this.exception;
    }

    public JSONObject j() {
        return this.requestResult;
    }

    public int k() {
        return this.requestStatusCode;
    }

    public int l() {
        return this.subErrorCode;
    }

    public String toString() {
        return "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + f() + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
    }

    private FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        boolean z2;
        Category a2;
        this.requestStatusCode = i2;
        this.errorCode = i3;
        this.subErrorCode = i4;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        if (facebookException != null) {
            this.exception = facebookException;
            z2 = true;
        } else {
            this.exception = new FacebookServiceException(this, str2);
            z2 = false;
        }
        FacebookRequestErrorClassification b2 = b();
        if (z2) {
            a2 = Category.OTHER;
        } else {
            a2 = b2.a(i3, i4, z);
        }
        this.category = a2;
        this.errorRecoveryMessage = b2.e(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc));
    }

    public FacebookRequestError(int i2, String str, String str2) {
        this(-1, i2, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
    }
}

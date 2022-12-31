package com.facebook.appevents;

import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.internal.x;
import java.io.Serializable;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AccessTokenAppIdPair implements Serializable {
    private static final long serialVersionUID = 1;
    private final String accessTokenString;
    private final String applicationId;

    /* loaded from: classes.dex */
    static class SerializationProxyV1 implements Serializable {
        private static final long serialVersionUID = -2488473066578201069L;
        private final String accessTokenString;
        private final String appId;

        private Object readResolve() {
            return new AccessTokenAppIdPair(this.accessTokenString, this.appId);
        }

        private SerializationProxyV1(String str, String str2) {
            this.accessTokenString = str;
            this.appId = str2;
        }
    }

    public AccessTokenAppIdPair(AccessToken accessToken) {
        this(accessToken.t(), com.facebook.f.g());
    }

    private Object writeReplace() {
        return new SerializationProxyV1(this.accessTokenString, this.applicationId);
    }

    public boolean equals(Object obj) {
        if (obj instanceof AccessTokenAppIdPair) {
            AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair) obj;
            return x.b(accessTokenAppIdPair.accessTokenString, this.accessTokenString) && x.b(accessTokenAppIdPair.applicationId, this.applicationId);
        }
        return false;
    }

    public String getAccessTokenString() {
        return this.accessTokenString;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public int hashCode() {
        String str = this.accessTokenString;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.applicationId;
        return hashCode ^ (str2 != null ? str2.hashCode() : 0);
    }

    public AccessTokenAppIdPair(String str, String str2) {
        this.accessTokenString = x.S(str) ? null : str;
        this.applicationId = str2;
    }
}

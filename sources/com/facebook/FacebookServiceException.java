package com.facebook;
/* loaded from: classes.dex */
public class FacebookServiceException extends FacebookException {
    private static final long serialVersionUID = 1;
    private final FacebookRequestError error;

    public FacebookServiceException(FacebookRequestError facebookRequestError, String str) {
        super(str);
        this.error = facebookRequestError;
    }

    public final FacebookRequestError getRequestError() {
        return this.error;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        return "{FacebookServiceException: httpResponseCode: " + this.error.k() + ", facebookErrorCode: " + this.error.c() + ", facebookErrorType: " + this.error.g() + ", message: " + this.error.f() + "}";
    }
}

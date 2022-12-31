package com.facebook;
/* loaded from: classes.dex */
public class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    @Override // com.facebook.FacebookException, java.lang.Throwable
    public final String toString() {
        GraphResponse graphResponse = this.graphResponse;
        FacebookRequestError g2 = graphResponse != null ? graphResponse.g() : null;
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(" ");
        }
        if (g2 != null) {
            sb.append("httpResponseCode: ");
            sb.append(g2.k());
            sb.append(", facebookErrorCode: ");
            sb.append(g2.c());
            sb.append(", facebookErrorType: ");
            sb.append(g2.g());
            sb.append(", message: ");
            sb.append(g2.f());
            sb.append("}");
        }
        return sb.toString();
    }
}

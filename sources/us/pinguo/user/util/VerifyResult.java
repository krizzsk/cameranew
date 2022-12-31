package us.pinguo.user.util;

import us.pinguo.foundation.utils.NoProguard;
/* compiled from: VerifyResponse.kt */
/* loaded from: classes6.dex */
public final class VerifyResult implements NoProguard {
    private String suggestion;

    public VerifyResult(String str) {
        this.suggestion = str;
    }

    public final String getSuggestion() {
        return this.suggestion;
    }

    public final void setSuggestion(String str) {
        this.suggestion = str;
    }
}

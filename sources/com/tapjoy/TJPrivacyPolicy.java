package com.tapjoy;

import com.tapjoy.internal.al;
import com.tapjoy.internal.ge;
/* loaded from: classes3.dex */
public class TJPrivacyPolicy {
    private static final TJPrivacyPolicy a = new TJPrivacyPolicy();

    public static TJPrivacyPolicy getInstance() {
        return a;
    }

    public void setBelowConsentAge(boolean z) {
        ge.a().b(z);
    }

    public void setSubjectToGDPR(boolean z) {
        ge.a().a(z);
    }

    public void setUSPrivacy(String str) {
        ge a2 = ge.a();
        if (al.a(str)) {
            return;
        }
        a2.f7568d = str;
        if (a2.b()) {
            return;
        }
        a2.f7569e = true;
    }

    public void setUserConsent(String str) {
        ge.a().a(str);
    }
}

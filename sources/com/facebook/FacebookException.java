package com.facebook;

import com.facebook.internal.FeatureManager;
import java.util.Random;
/* loaded from: classes.dex */
public class FacebookException extends RuntimeException {
    static final long serialVersionUID = 1;

    /* loaded from: classes.dex */
    class a implements FeatureManager.c {
        final /* synthetic */ String a;

        a(FacebookException facebookException, String str) {
            this.a = str;
        }

        @Override // com.facebook.internal.FeatureManager.c
        public void a(boolean z) {
            if (z) {
                try {
                    com.facebook.internal.instrument.f.b.c(this.a);
                } catch (Exception unused) {
                }
            }
        }
    }

    public FacebookException() {
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getMessage();
    }

    public FacebookException(String str) {
        super(str);
        Random random = new Random();
        if (str == null || !f.z() || random.nextInt(100) <= 50) {
            return;
        }
        FeatureManager.a(FeatureManager.Feature.ErrorReport, new a(this, str));
    }

    public FacebookException(String str, Object... objArr) {
        this(String.format(str, objArr));
    }

    public FacebookException(String str, Throwable th) {
        super(str, th);
    }

    public FacebookException(Throwable th) {
        super(th);
    }
}

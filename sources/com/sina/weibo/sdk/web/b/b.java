package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;
/* loaded from: classes3.dex */
public abstract class b {
    protected WebData aH;
    protected String aI;
    protected Context ae;

    /* loaded from: classes3.dex */
    public interface a {
        void onComplete();

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
    }

    protected abstract void a(Bundle bundle);

    public void a(a aVar) {
    }

    protected abstract void b(Bundle bundle);

    public abstract String getUrl();

    public final void readFromBundle(Bundle bundle) {
        this.aH = (WebData) bundle.getParcelable("web_data");
        this.aI = bundle.getString("_weibo_transaction");
        b(bundle);
    }

    public final void setContext(Context context) {
        this.ae = context;
    }

    public boolean w() {
        return false;
    }

    public final Bundle writeToBundle(Bundle bundle) {
        bundle.putParcelable("web_data", this.aH);
        int type = this.aH.getType();
        if (type == 1) {
            bundle.putInt("web_type", 1);
        } else if (type == 2) {
            bundle.putInt("web_type", 2);
        } else if (type == 3) {
            bundle.putInt("web_type", 3);
        }
        bundle.putString("_weibo_transaction", this.aI);
        a(bundle);
        return bundle;
    }

    public final WebData x() {
        return this.aH;
    }

    public b(AuthInfo authInfo, int i2, String str, String str2) {
        this.aH = new WebData(authInfo, i2, str, str2);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        this.aI = sb.toString();
    }
}

package cn.sharesdk.framework.authorize;

import android.content.Intent;
import com.growingio.android.sdk.autoburry.VdsAgent;
import com.growingio.android.sdk.instrumentation.Instrumented;
/* compiled from: SSOAuthorizeActivity.java */
/* loaded from: classes.dex */
public class d extends a {
    protected SSOListener b;
    private e c;

    public void a(SSOListener sSOListener) {
        this.b = sSOListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.c.a(i2, i3, intent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        e sSOProcessor = this.a.getSSOProcessor(this);
        this.c = sSOProcessor;
        if (sSOProcessor == null) {
            finish();
            AuthorizeListener authorizeListener = this.a.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Failed to start SSO for " + this.a.getPlatform().getName()));
                return;
            }
            return;
        }
        sSOProcessor.a(32973);
        this.c.a();
    }

    @Override // com.mob.tools.FakeActivity
    @Instrumented
    public void onNewIntent(Intent intent) {
        VdsAgent.onNewIntent(this, intent);
        this.c.a(intent);
    }
}

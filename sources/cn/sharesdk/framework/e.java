package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.SSOListener;
/* compiled from: PlatformHelper.java */
/* loaded from: classes.dex */
public abstract class e implements AuthorizeHelper {
    protected Platform a;
    private AuthorizeListener b;
    private SSOListener c;

    public e(Platform platform) {
        this.a = platform;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(SSOListener sSOListener) {
        this.c = sSOListener;
        cn.sharesdk.framework.authorize.d dVar = new cn.sharesdk.framework.authorize.d();
        dVar.a(sSOListener);
        dVar.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AuthorizeListener authorizeListener) {
        this.b = authorizeListener;
        cn.sharesdk.framework.authorize.g gVar = new cn.sharesdk.framework.authorize.g();
        gVar.a(this.b);
        gVar.a(this);
    }

    public int c() {
        return this.a.getPlatformId();
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AuthorizeListener getAuthorizeListener() {
        return this.b;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public Platform getPlatform() {
        return this.a;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public SSOListener getSSOListener() {
        return this.c;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public cn.sharesdk.framework.authorize.e getSSOProcessor(cn.sharesdk.framework.authorize.d dVar) {
        return null;
    }
}

package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.e;
/* loaded from: classes3.dex */
public final class f extends c<Void, Void, String> {
    private com.sina.weibo.sdk.net.c<String> ag;
    private Throwable ah;
    private Oauth2AccessToken ak;
    private String appKey;

    public f(String str, Oauth2AccessToken oauth2AccessToken, com.sina.weibo.sdk.net.c<String> cVar) {
        this.appKey = str;
        this.ak = oauth2AccessToken;
        this.ag = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q */
    public String o() {
        try {
            e.a aVar = new e.a();
            aVar.url = "https://api.weibo.com/oauth2/access_token";
            return new com.sina.weibo.sdk.net.b().a(aVar.b("client_id", this.appKey).b("appKey", this.appKey).b("grant_type", "refresh_token").b("refresh_token", this.ak.getRefreshToken()).i()).j();
        } catch (Throwable th) {
            th.printStackTrace();
            this.ah = th;
            return null;
        }
    }

    @Override // com.sina.weibo.sdk.b.c
    protected final /* synthetic */ void onPostExecute(String str) {
        String str2 = str;
        Throwable th = this.ah;
        if (th != null) {
            com.sina.weibo.sdk.net.c<String> cVar = this.ag;
            if (cVar != null) {
                cVar.onError(th);
                return;
            }
            return;
        }
        com.sina.weibo.sdk.net.c<String> cVar2 = this.ag;
        if (cVar2 != null) {
            cVar2.a(str2);
        }
    }
}

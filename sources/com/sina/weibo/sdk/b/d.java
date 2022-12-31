package com.sina.weibo.sdk.b;

import android.content.Context;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.net.e;
/* loaded from: classes3.dex */
public final class d extends c<Void, Void, String> {
    private Context ae;
    private ChatObject af;
    private com.sina.weibo.sdk.net.c<String> ag;
    private Throwable ah;

    public d(Context context, ChatObject chatObject, com.sina.weibo.sdk.net.c<String> cVar) {
        this.ae = context;
        this.af = chatObject;
        this.ag = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.sina.weibo.sdk.b.c
    /* renamed from: q */
    public String o() {
        AuthInfo a = com.sina.weibo.sdk.a.a();
        try {
            e.a aVar = new e.a();
            aVar.url = "http://i.open.t.sina.com.cn/mobilesdk/sendmessage.php";
            return new com.sina.weibo.sdk.net.b().a(aVar.b("app_key", a.getAppKey()).b("platform", "2").b("android_pack", a.getPackageName()).b("android_sign", a.getHash()).b("display_name", this.af.content).b("image_url", this.af.image_url).b("url", this.af.url).b("summary", this.af.summary).i()).j();
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

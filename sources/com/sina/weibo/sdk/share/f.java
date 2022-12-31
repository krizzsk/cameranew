package com.sina.weibo.sdk.share;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: g  reason: collision with root package name */
    public WeakReference<Activity> f7179g;

    public f(Activity activity) {
        this.f7179g = new WeakReference<>(activity);
    }

    public final void b(WeiboMultiMessage weiboMultiMessage) {
        Activity activity = this.f7179g.get();
        if (activity == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_command_type", 1);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        bundle.putString("_weibo_transaction", sb.toString());
        bundle.putAll(weiboMultiMessage.writeToBundle(bundle));
        Intent intent = new Intent(activity, ShareTransActivity.class);
        intent.putExtra("start_flag", 0);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, 10001);
    }
}

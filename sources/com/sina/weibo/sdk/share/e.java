package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public final class e extends AsyncTask<StoryMessage, Void, c> {
    private WeakReference<Context> H;
    private b I;

    public e(Context context, b bVar) {
        this.H = new WeakReference<>(context);
        this.I = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public c doInBackground(StoryMessage... storyMessageArr) {
        StoryMessage storyMessage;
        Context context = this.H.get();
        if (context == null || (storyMessage = storyMessageArr[0]) == null) {
            return null;
        }
        c cVar = new c();
        try {
            Uri imageUri = storyMessage.getImageUri();
            if (imageUri != null && com.sina.weibo.sdk.c.b.a(context, imageUri)) {
                cVar.G = b(context, imageUri, 1);
                cVar.E = true;
            }
            Uri videoUri = storyMessage.getVideoUri();
            if (videoUri != null && com.sina.weibo.sdk.c.b.b(context, videoUri)) {
                cVar.G = b(context, videoUri, 0);
                cVar.E = true;
            }
        } catch (Throwable th) {
            cVar.E = false;
            cVar.errorMessage = th.getMessage();
        }
        return cVar;
    }

    private static StoryObject b(Context context, Uri uri, int i2) {
        String a = a.a(context, uri, i2);
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        StoryObject storyObject = new StoryObject();
        storyObject.sourcePath = a;
        storyObject.sourceType = i2;
        storyObject.appId = com.sina.weibo.sdk.a.a().getAppKey();
        storyObject.appPackage = context.getPackageName();
        storyObject.callbackAction = "com.sina.weibo.sdk.action.ACTION_SDK_REQ_STORY";
        return storyObject;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(c cVar) {
        c cVar2 = cVar;
        super.onPostExecute(cVar2);
        b bVar = this.I;
        if (bVar != null) {
            bVar.a(cVar2);
        }
    }
}

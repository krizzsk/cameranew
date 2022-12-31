package com.sina.weibo.sdk.share;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.VideoSourceObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class d extends AsyncTask<WeiboMultiMessage, Void, c> {
    private WeakReference<Context> H;
    private b I;

    public d(Context context, b bVar) {
        this.H = new WeakReference<>(context);
        this.I = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public c doInBackground(WeiboMultiMessage... weiboMultiMessageArr) {
        WeiboMultiMessage weiboMultiMessage;
        Uri uri;
        Context context = this.H.get();
        if (context == null || (weiboMultiMessage = weiboMultiMessageArr[0]) == null) {
            return null;
        }
        String str = com.sina.weibo.sdk.c.a.c(context).packageName;
        if (TextUtils.isEmpty(str)) {
            str = "com.sina.weibo";
        }
        c cVar = new c();
        try {
            if (weiboMultiMessage.imageObject != null && weiboMultiMessage.multiImageObject != null) {
                weiboMultiMessage.imageObject = null;
            }
            if (weiboMultiMessage.videoSourceObject != null && (weiboMultiMessage.imageObject != null || weiboMultiMessage.multiImageObject != null)) {
                weiboMultiMessage.imageObject = null;
                weiboMultiMessage.multiImageObject = null;
            }
            if (weiboMultiMessage.multiImageObject != null) {
                ArrayList<Uri> arrayList = new ArrayList<>();
                Iterator<Uri> it = weiboMultiMessage.multiImageObject.getImageList().iterator();
                while (it.hasNext()) {
                    Uri next = it.next();
                    if (next != null && com.sina.weibo.sdk.c.b.a(context, next)) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            arrayList.add(next);
                            context.grantUriPermission(str, next, 1);
                        } else {
                            String a = a.a(context, next, 1);
                            if (!TextUtils.isEmpty(a)) {
                                arrayList.add(Uri.fromFile(new File(a)));
                            } else {
                                throw new IllegalArgumentException("image's path is null");
                            }
                        }
                    }
                }
                weiboMultiMessage.multiImageObject.imageList = arrayList;
            }
            VideoSourceObject videoSourceObject = weiboMultiMessage.videoSourceObject;
            if (videoSourceObject != null && (uri = videoSourceObject.videoPath) != null && com.sina.weibo.sdk.c.b.b(context, uri)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    VideoSourceObject videoSourceObject2 = weiboMultiMessage.videoSourceObject;
                    videoSourceObject2.videoPath = uri;
                    videoSourceObject2.during = com.sina.weibo.sdk.c.b.e(com.sina.weibo.sdk.c.b.d(context, uri));
                    context.grantUriPermission(str, weiboMultiMessage.videoSourceObject.videoPath, 1);
                } else {
                    String a2 = a.a(context, uri, 0);
                    com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare video resource and video'path is" + a2);
                    if (!TextUtils.isEmpty(a2)) {
                        weiboMultiMessage.videoSourceObject.videoPath = Uri.fromFile(new File(a2));
                        weiboMultiMessage.videoSourceObject.during = com.sina.weibo.sdk.c.b.e(a2);
                    } else {
                        throw new IllegalArgumentException("video's path is null");
                    }
                }
            }
            cVar.F = weiboMultiMessage;
            cVar.E = true;
        } catch (Throwable th) {
            cVar.E = false;
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = th.toString();
            }
            cVar.errorMessage = message;
            com.sina.weibo.sdk.c.c.b("WBShareTag", "prepare resource error is :" + message);
        }
        return cVar;
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

    @Override // android.os.AsyncTask
    protected final void onPreExecute() {
        super.onPreExecute();
    }
}

package com.sina.weibo.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.WbShareCallback;
/* loaded from: classes3.dex */
public interface IWBAPI {
    void authorize(WbAuthListener wbAuthListener);

    void authorizeCallback(int i2, int i3, Intent intent);

    void authorizeClient(WbAuthListener wbAuthListener);

    void authorizeWeb(WbAuthListener wbAuthListener);

    void doResultIntent(Intent intent, WbShareCallback wbShareCallback);

    boolean isWBAppInstalled();

    boolean isWBAppSupportMultipleImage();

    void registerApp(Context context, AuthInfo authInfo);

    void setLoggerEnable(boolean z);

    void shareMessage(WeiboMultiMessage weiboMultiMessage, boolean z);

    void shareStory(StoryMessage storyMessage);
}

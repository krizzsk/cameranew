package com.bytedance.sdk.open.douyin.api;

import android.content.Intent;
import com.bytedance.sdk.open.aweme.authorize.model.Authorization;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.share.Share;
import com.bytedance.sdk.open.douyin.ShareToContact;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
/* loaded from: classes.dex */
public interface DouYinOpenApi {
    boolean authorize(Authorization.Request request);

    boolean handleIntent(Intent intent, IApiEventHandler iApiEventHandler);

    boolean isAppInstalled();

    boolean isAppSupportAuthorization();

    boolean isAppSupportShare();

    boolean isAppSupportShareToContacts();

    boolean isAppSupportShareToPublish();

    boolean isShareSupportFileProvider();

    boolean isSupportOpenRecordPage();

    boolean openRecordPage(OpenRecord.Request request);

    boolean share(Share.Request request);

    boolean shareToContacts(ShareToContact.Request request);
}

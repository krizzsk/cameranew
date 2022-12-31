package com.bytedance.sdk.open.douyin.b;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.douyin.ShareToContact;
/* loaded from: classes.dex */
public class b implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i2, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i2 == 5) {
                ShareToContact.Request request = new ShareToContact.Request(bundle);
                if (request.checkArgs()) {
                    iApiEventHandler.onReq(request);
                    return true;
                }
                return false;
            } else if (i2 == 6) {
                ShareToContact.Response response = new ShareToContact.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}

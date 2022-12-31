package com.bytedance.sdk.open.aweme.share;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.aweme.share.Share;
/* loaded from: classes.dex */
public class ShareDataHandler implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i2, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i2 == 3) {
                Share.Request request = new Share.Request(bundle);
                if (request.checkArgs()) {
                    iApiEventHandler.onReq(request);
                    return true;
                }
                return false;
            } else if (i2 == 4) {
                Share.Response response = new Share.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}

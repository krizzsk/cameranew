package com.bytedance.sdk.open.douyin.b;

import android.os.Bundle;
import com.bytedance.sdk.open.aweme.common.handler.IApiEventHandler;
import com.bytedance.sdk.open.aweme.common.handler.IDataHandler;
import com.bytedance.sdk.open.douyin.model.OpenRecord;
/* loaded from: classes.dex */
public class a implements IDataHandler {
    @Override // com.bytedance.sdk.open.aweme.common.handler.IDataHandler
    public boolean handle(int i2, Bundle bundle, IApiEventHandler iApiEventHandler) {
        if (bundle != null && iApiEventHandler != null) {
            if (i2 == 7) {
                OpenRecord.Request request = new OpenRecord.Request(bundle);
                if (request.checkArgs()) {
                    iApiEventHandler.onReq(request);
                    return true;
                }
                return false;
            } else if (i2 == 8) {
                OpenRecord.Response response = new OpenRecord.Response(bundle);
                if (response.checkArgs()) {
                    iApiEventHandler.onResp(response);
                    return true;
                }
            }
        }
        return false;
    }
}

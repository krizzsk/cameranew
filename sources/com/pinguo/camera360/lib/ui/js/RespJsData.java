package com.pinguo.camera360.lib.ui.js;

import us.pinguo.user.User;
/* loaded from: classes3.dex */
public class RespJsData {
    protected String message;
    protected User.Info result;
    protected int status;

    public RespJsData(int i2, String str, User.Info info) {
        this.status = i2;
        this.message = str;
        this.result = info;
    }
}

package com.bytedance.sdk.open.aweme.authorize.model;

import com.google.gson.s.c;
/* loaded from: classes.dex */
public class VerifyObject {
    @c("verify_openid")
    public String verifyOpenId;
    @c("verify_scope")
    public String verifyScope;
    @c("verify_tic")
    public String verifyTic;

    public VerifyObject(String str, String str2, String str3) {
        this.verifyScope = str;
        this.verifyTic = str2;
        this.verifyOpenId = str3;
    }
}

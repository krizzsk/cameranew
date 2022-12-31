package com.bytedance.sdk.open.douyin.model;

import android.os.Bundle;
import com.bytedance.sdk.open.douyin.a.a;
import com.google.gson.e;
import com.google.gson.s.c;
import com.tapjoy.TJAdUnitConstants;
/* loaded from: classes.dex */
public class ContactHtmlObject {
    @c("discription")
    private String mDiscription;
    @c(TJAdUnitConstants.String.HTML)
    private String mHtml;
    @c("title")
    private String mTitle;
    @c("thumburl")
    private String thumbUrl;

    public static ContactHtmlObject unserialize(Bundle bundle) {
        String string = bundle.getString(a.InterfaceC0045a.b, "");
        if (string == null) {
            return null;
        }
        try {
            return (ContactHtmlObject) new e().j(string, ContactHtmlObject.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public String getDiscription() {
        return this.mDiscription;
    }

    public String getHtml() {
        return this.mHtml;
    }

    public String getThumbUrl() {
        return this.thumbUrl;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void serialize(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.putSerializable(a.InterfaceC0045a.b, new e().s(this));
    }

    public void setDiscription(String str) {
        this.mDiscription = str;
    }

    public void setHtml(String str) {
        this.mHtml = str;
    }

    public void setThumbUrl(String str) {
        this.thumbUrl = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }
}

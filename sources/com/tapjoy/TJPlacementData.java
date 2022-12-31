package com.tapjoy;

import com.tapjoy.internal.jq;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class TJPlacementData implements Serializable {
    private String a;
    private String b;
    private String c;

    /* renamed from: d  reason: collision with root package name */
    private String f7236d;

    /* renamed from: e  reason: collision with root package name */
    private String f7237e;

    /* renamed from: f  reason: collision with root package name */
    private String f7238f;

    /* renamed from: g  reason: collision with root package name */
    private int f7239g;

    /* renamed from: h  reason: collision with root package name */
    private String f7240h;

    /* renamed from: i  reason: collision with root package name */
    private String f7241i;

    /* renamed from: j  reason: collision with root package name */
    private int f7242j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7243k;

    /* renamed from: l  reason: collision with root package name */
    private String f7244l;
    private boolean m;
    private String n;
    private String o;
    private boolean p;
    private boolean q;
    private boolean r;

    public TJPlacementData(String str, String str2) {
        this.p = true;
        this.q = false;
        setKey(str);
        updateUrl(str2);
        setPlacementType("app");
    }

    public String getAuctionMediationURL() {
        return this.f7237e;
    }

    public String getBaseURL() {
        return this.c;
    }

    public String getCallbackID() {
        return this.n;
    }

    public String getContentViewId() {
        return this.o;
    }

    public String getHttpResponse() {
        return this.f7238f;
    }

    public int getHttpStatusCode() {
        return this.f7239g;
    }

    public String getKey() {
        return this.a;
    }

    public String getMediationURL() {
        return this.f7236d;
    }

    public String getPlacementName() {
        return this.f7240h;
    }

    public String getPlacementType() {
        return this.f7241i;
    }

    public String getRedirectURL() {
        return this.f7244l;
    }

    public String getUrl() {
        return this.b;
    }

    public int getViewType() {
        return this.f7242j;
    }

    public boolean hasProgressSpinner() {
        return this.f7243k;
    }

    public boolean isBaseActivity() {
        return this.p;
    }

    public boolean isPreloadDisabled() {
        return this.q;
    }

    public boolean isPrerenderingRequested() {
        return this.m;
    }

    public void resetPlacementRequestData() {
        setHttpResponse(null);
        setHttpStatusCode(0);
        setRedirectURL(null);
        setHasProgressSpinner(false);
        setPrerenderingRequested(false);
        setPreloadDisabled(false);
        setContentViewId(null);
        setHandleDismissOnPause(false);
    }

    public void setAuctionMediationURL(String str) {
        this.f7237e = str;
    }

    public void setBaseURL(String str) {
        this.c = str;
    }

    public void setContentViewId(String str) {
        this.o = str;
    }

    public void setHandleDismissOnPause(boolean z) {
        this.r = z;
    }

    public void setHasProgressSpinner(boolean z) {
        this.f7243k = z;
    }

    public void setHttpResponse(String str) {
        this.f7238f = str;
    }

    public void setHttpStatusCode(int i2) {
        this.f7239g = i2;
    }

    public void setKey(String str) {
        this.a = str;
    }

    public void setMediationURL(String str) {
        this.f7236d = str;
    }

    public void setPlacementName(String str) {
        this.f7240h = str;
    }

    public void setPlacementType(String str) {
        this.f7241i = str;
    }

    public void setPreloadDisabled(boolean z) {
        this.q = z;
    }

    public void setPrerenderingRequested(boolean z) {
        this.m = z;
    }

    public void setRedirectURL(String str) {
        this.f7244l = str;
    }

    public void setViewType(int i2) {
        this.f7242j = i2;
    }

    public boolean shouldHandleDismissOnPause() {
        return this.r;
    }

    public void updateUrl(String str) {
        this.b = str;
        if (jq.c(str)) {
            return;
        }
        setBaseURL(str.substring(0, str.indexOf(47, str.indexOf("//") + 3)));
    }

    public TJPlacementData(String str, String str2, String str3) {
        this.p = true;
        this.q = false;
        setBaseURL(str);
        setHttpResponse(str2);
        this.n = str3;
        this.p = false;
        setPlacementType("app");
    }
}

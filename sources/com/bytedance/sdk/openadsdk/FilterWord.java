package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FilterWord {
    private String a;
    private String b;
    private boolean c;

    /* renamed from: d  reason: collision with root package name */
    private List<FilterWord> f1316d;

    public FilterWord(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public void addOption(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.f1316d == null) {
            this.f1316d = new ArrayList();
        }
        this.f1316d.add(filterWord);
    }

    public String getId() {
        return this.a;
    }

    public boolean getIsSelected() {
        return this.c;
    }

    public String getName() {
        return this.b;
    }

    public List<FilterWord> getOptions() {
        return this.f1316d;
    }

    public boolean hasSecondOptions() {
        List<FilterWord> list = this.f1316d;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean isValid() {
        return (TextUtils.isEmpty(this.a) || TextUtils.isEmpty(this.b)) ? false : true;
    }

    public void setId(String str) {
        this.a = str;
    }

    public void setIsSelected(boolean z) {
        this.c = z;
    }

    public void setName(String str) {
        this.b = str;
    }

    public FilterWord() {
    }
}

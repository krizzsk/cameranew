package com.growingio.android.sdk.api;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.growingio.android.sdk.collection.Constants;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.models.PageEvent;
import com.growingio.android.sdk.models.Tag;
import com.growingio.android.sdk.models.ViewAttrs;
import com.growingio.android.sdk.utils.ThreadUtils;
import com.growingio.android.sdk.utils.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class TagStore {
    public static final int ALL_PAGE = 1;
    public static final int CURRENT_PAGE = 0;
    static final String TAG = "GrowingIO.TagStore";
    public static TagStore sInstance = new TagStore();
    private InitSuccess mInitSuccess;
    private final Object mTagsLock = new Object();
    private boolean mTagsReady = false;
    private boolean mLoading = false;
    private List<Tag> mTags = new ArrayList();

    /* loaded from: classes2.dex */
    public interface InitSuccess {
        void initSuccess();
    }

    private TagStore() {
    }

    public static Tag createNewTag(String str, String str2, String str3, String str4, int i2, String str5, String str6, String str7, String str8, ViewAttrs viewAttrs) {
        ViewAttrs viewAttrs2 = new ViewAttrs();
        ViewAttrs viewAttrs3 = new ViewAttrs();
        viewAttrs2.domain = str;
        viewAttrs3.domain = str;
        viewAttrs2.path = str3;
        viewAttrs2.query = str7;
        if (str2.equals("elem")) {
            viewAttrs2.xpath = str4;
            viewAttrs2.index = str6;
            viewAttrs2.content = str5;
            viewAttrs2.href = str8;
            viewAttrs3.xpath = normalizeXPath(str4);
            viewAttrs3.content = str5;
            viewAttrs3.index = str6;
            viewAttrs3.href = str8;
            if (viewAttrs != null) {
                viewAttrs3.domain = viewAttrs.domain;
                viewAttrs3.path = viewAttrs.path;
                viewAttrs3.query = viewAttrs.query;
            } else {
                viewAttrs3.path = str3;
            }
        } else if (str2.equals(PageEvent.TYPE_NAME)) {
            viewAttrs2.content = null;
            viewAttrs3.path = str3;
            viewAttrs3.xpath = null;
            viewAttrs3.content = null;
            viewAttrs3.index = null;
            viewAttrs3.query = str7;
        }
        Tag tag = new Tag();
        tag.eventType = str2;
        tag.platform = Constants.PLATFORM_ANDROID;
        tag.attrs = viewAttrs2;
        tag.filter = viewAttrs3;
        return tag;
    }

    public static TagStore getInstance() {
        return sInstance;
    }

    private static String normalizeXPath(String str) {
        String str2;
        String str3;
        if (GConfig.USE_ID) {
            int indexOf = str.indexOf(Constants.WEB_PART_SEPARATOR);
            if (indexOf != -1) {
                str2 = str.substring(0, indexOf);
                str3 = str.substring(indexOf);
            } else {
                str2 = str;
                str3 = "";
            }
            if (GConfig.CIRCLE_USE_ID) {
                int lastIndexOf = str2.lastIndexOf(35);
                if (lastIndexOf != -1) {
                    String substring = str2.substring(lastIndexOf);
                    return '*' + substring + str3;
                }
                return str;
            }
            String replaceAll = Util.ID_PATTERN_MATCHER.reset(str2).replaceAll("");
            return replaceAll + str3;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTagHttpResponse(List<Tag> list) {
        this.mTags.clear();
        this.mTags.addAll(list);
        this.mTagsReady = true;
        this.mLoading = false;
        InitSuccess initSuccess = this.mInitSuccess;
        if (initSuccess != null) {
            initSuccess.initSuccess();
            this.mInitSuccess = null;
        }
    }

    public void addTag(Tag tag) {
        synchronized (this.mTagsLock) {
            this.mTags.add(tag);
        }
    }

    public Tag getPageTag(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "";
        }
        String str4 = str3;
        for (Tag tag : this.mTags) {
            if (tag.eventType.equals(PageEvent.TYPE_NAME) && Constants.PLATFORM_ANDROID.equalsIgnoreCase(tag.platform) && TextUtils.equals(tag.attrs.domain, str) && TextUtils.equals(tag.attrs.path, str2) && TextUtils.equals(tag.attrs.query, str4)) {
                return tag;
            }
        }
        return createNewTag(str, PageEvent.TYPE_NAME, str2, null, 0, null, null, str4, null, null);
    }

    public List<Tag> getTags() {
        return this.mTags;
    }

    public List<Tag> getWebTags() {
        int indexOf;
        ArrayList arrayList = new ArrayList();
        String str = CoreInitialize.coreAppState().getSPN() + Constants.WEB_PART_SEPARATOR;
        for (Tag tag : this.mTags) {
            if (tag.attrs.domain.startsWith(str)) {
                Tag copyWithoutScreenShot = tag.copyWithoutScreenShot();
                int length = str.length();
                ViewAttrs viewAttrs = copyWithoutScreenShot.attrs;
                viewAttrs.domain = viewAttrs.domain.substring(length);
                if (!TextUtils.isEmpty(copyWithoutScreenShot.filter.domain) && copyWithoutScreenShot.filter.domain.length() >= length) {
                    ViewAttrs viewAttrs2 = copyWithoutScreenShot.filter;
                    viewAttrs2.domain = viewAttrs2.domain.substring(length);
                }
                int indexOf2 = copyWithoutScreenShot.attrs.path.indexOf(Constants.WEB_PART_SEPARATOR);
                if (indexOf2 > 0) {
                    int i2 = indexOf2 + 2;
                    ViewAttrs viewAttrs3 = copyWithoutScreenShot.attrs;
                    viewAttrs3.path = viewAttrs3.path.substring(i2);
                    if (!TextUtils.isEmpty(copyWithoutScreenShot.filter.path) && copyWithoutScreenShot.filter.path.length() > i2) {
                        ViewAttrs viewAttrs4 = copyWithoutScreenShot.filter;
                        viewAttrs4.path = viewAttrs4.path.substring(i2);
                    }
                }
                if (!TextUtils.isEmpty(copyWithoutScreenShot.attrs.xpath) && (indexOf = copyWithoutScreenShot.attrs.xpath.indexOf(Constants.WEB_PART_SEPARATOR) + 2) > 0) {
                    ViewAttrs viewAttrs5 = copyWithoutScreenShot.attrs;
                    viewAttrs5.xpath = viewAttrs5.xpath.substring(indexOf);
                    if (!TextUtils.isEmpty(copyWithoutScreenShot.filter.xpath) && copyWithoutScreenShot.filter.xpath.length() > indexOf) {
                        ViewAttrs viewAttrs6 = copyWithoutScreenShot.filter;
                        viewAttrs6.xpath = viewAttrs6.xpath.substring(indexOf);
                    }
                }
                arrayList.add(copyWithoutScreenShot);
            }
        }
        return arrayList;
    }

    @TargetApi(11)
    public void initial() {
        if (this.mLoading) {
            return;
        }
        this.mLoading = true;
        new TagAPI() { // from class: com.growingio.android.sdk.api.TagStore.1
            @Override // com.growingio.android.sdk.api.TagAPI, com.growingio.android.sdk.base.event.HttpCallBack
            public void afterRequest(Integer num, byte[] bArr, long j2, Map<String, List<String>> map) {
                super.afterRequest(num, bArr, j2, map);
                if (num.intValue() == 200) {
                    ThreadUtils.runOnUiThread(new Runnable() { // from class: com.growingio.android.sdk.api.TagStore.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            TagStore.this.onTagHttpResponse(anonymousClass1.tags);
                        }
                    });
                }
            }
        }.run();
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isTagsReady() {
        return this.mTagsReady;
    }

    public void removeTagById(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (Tag tag : this.mTags) {
            if (TextUtils.equals(str, tag.id)) {
                this.mTags.remove(tag);
                return;
            }
        }
    }

    public void setInitSuccess(InitSuccess initSuccess) {
        this.mInitSuccess = initSuccess;
    }
}

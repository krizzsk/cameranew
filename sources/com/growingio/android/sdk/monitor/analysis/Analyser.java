package com.growingio.android.sdk.monitor.analysis;

import android.text.TextUtils;
import com.growingio.android.sdk.monitor.event.EventBuilder;
import com.tapjoy.TapjoyConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class Analyser {
    public static final String DEFAULT_GROUP_NAME = "unknow_group";
    private int mDeepth;
    private boolean mFindTarget;
    private boolean mFindUnknow;
    private int mGroupId;
    private WeakReference<Analysed> mLastAnalysed;
    private final List<String> mLibraries;
    private final int mMaxDeepth;
    private boolean mNeedRecordAllElements;
    private final String mTargetGroupName;

    /* loaded from: classes2.dex */
    public static class Builder {
        private static List<String> sDefaultLibraries;
        private List<String> mLibraries = new ArrayList();
        private String mTargetGroupName = "";
        private int mMaxDeepth = 10;
        private boolean mUseDefaultLibraries = false;
        private boolean mNeedRecordAllElements = false;

        static {
            ArrayList arrayList = new ArrayList();
            sDefaultLibraries = arrayList;
            arrayList.add(EventBuilder.DEFAULT_PLATFORM);
            sDefaultLibraries.add("sun");
            sDefaultLibraries.add(TapjoyConstants.TJC_DEVICE_PLATFORM_TYPE);
            sDefaultLibraries.add("com.android");
            sDefaultLibraries.add("dalvik");
            sDefaultLibraries.add("okio");
            sDefaultLibraries.add("okhttp");
            sDefaultLibraries.add("com.growingio");
        }

        public Builder addLibraries(String... strArr) {
            this.mLibraries.addAll(Arrays.asList(strArr));
            return this;
        }

        public Builder addLibrary(String str) {
            this.mLibraries.add(str);
            return this;
        }

        public Builder addMaxDeepth(int i2) {
            this.mMaxDeepth = i2;
            return this;
        }

        public Builder addTargetGroupName(String str) {
            this.mTargetGroupName = str;
            return this;
        }

        public Analyser build() {
            if (this.mUseDefaultLibraries) {
                return new Analyser(this.mTargetGroupName, sDefaultLibraries, this.mMaxDeepth, this.mNeedRecordAllElements);
            }
            return new Analyser(this.mTargetGroupName, this.mLibraries, this.mMaxDeepth, this.mNeedRecordAllElements);
        }

        public Builder isNeedRecordAllElements(boolean z) {
            this.mNeedRecordAllElements = z;
            return this;
        }

        public Builder useDefaultLibraries(boolean z) {
            this.mUseDefaultLibraries = z;
            return this;
        }
    }

    private void dfs(Analysed analysed, Throwable th) {
        StackTraceElement[] stackTrace;
        int i2 = this.mDeepth + 1;
        this.mDeepth = i2;
        if (i2 > this.mMaxDeepth) {
            return;
        }
        if (th.getCause() != null) {
            dfs(analysed, th.getCause());
        }
        if (!this.mNeedRecordAllElements && (this.mFindUnknow || this.mFindTarget)) {
            return;
        }
        StackGroup stackGroup = new StackGroup(Integer.valueOf(this.mGroupId), DEFAULT_GROUP_NAME);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            if (!stackTraceElement.getClassName().startsWith(stackGroup.getName())) {
                String findGroup = findGroup(stackTraceElement.getClassName());
                int i3 = this.mGroupId + 1;
                this.mGroupId = i3;
                StackGroup stackGroup2 = new StackGroup(Integer.valueOf(i3), findGroup);
                analysed.addGroup(stackGroup2);
                stackGroup = stackGroup2;
            }
            if (!this.mFindTarget && this.mTargetGroupName.equals(stackGroup.getName())) {
                this.mFindTarget = true;
                analysed.setFirstTargetElement(stackTraceElement);
            }
            if (!this.mFindUnknow && DEFAULT_GROUP_NAME.equals(stackGroup.getName())) {
                this.mFindUnknow = true;
            }
            if (this.mNeedRecordAllElements) {
                stackGroup.addElement(stackTraceElement);
            }
            if (!this.mNeedRecordAllElements && (this.mFindUnknow || this.mFindTarget)) {
                return;
            }
        }
    }

    private String findGroup(String str) {
        if (TextUtils.isEmpty(str)) {
            return DEFAULT_GROUP_NAME;
        }
        for (String str2 : this.mLibraries) {
            if (str.startsWith(str2)) {
                return str2;
            }
        }
        return DEFAULT_GROUP_NAME;
    }

    public Analysed analyze(Throwable th) {
        if (th == null) {
            return Analysed.EMPTY_ANALYSED;
        }
        this.mFindTarget = false;
        this.mFindUnknow = false;
        this.mDeepth = 0;
        this.mGroupId = 0;
        Analysed analysed = new Analysed(th);
        dfs(analysed, th);
        analysed.setIsFindTarget(this.mFindTarget);
        this.mLastAnalysed = new WeakReference<>(analysed);
        return analysed;
    }

    public Analysed getLastAnalysed() {
        Analysed analysed;
        WeakReference<Analysed> weakReference = this.mLastAnalysed;
        return (weakReference == null || (analysed = weakReference.get()) == null) ? Analysed.EMPTY_ANALYSED : analysed;
    }

    private Analyser(String str, List<String> list, int i2, boolean z) {
        this.mFindTarget = false;
        this.mFindUnknow = false;
        this.mDeepth = 0;
        this.mGroupId = 0;
        this.mLibraries = list;
        this.mTargetGroupName = str;
        this.mMaxDeepth = i2;
        this.mLastAnalysed = new WeakReference<>(Analysed.EMPTY_ANALYSED);
        this.mNeedRecordAllElements = z;
    }
}

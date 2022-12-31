package com.pinguo.lib.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import us.pinguo.common.log.a;
import us.pinguo.foundation.d;
/* loaded from: classes3.dex */
public class DebugHelper {
    private static final String TAG = "DebugHelper";
    private static Map<String, DebugHelper> sInstances = new HashMap();
    private int curLineNumber;
    private long curTime;
    private String debugName;
    private long endTime;
    private int lastLineNumber;
    private long lastTime;
    private String mTag;
    private List<TimeTag> mTimes;
    private long startTime;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class TimeTag {
        private String tag;
        private long time;

        TimeTag(String str, long j2) {
            this.tag = str;
            this.time = j2;
        }
    }

    public DebugHelper() {
        this("");
    }

    public static DebugHelper gInstance(String str) {
        if (sInstances.get(str) == null) {
            DebugHelper debugHelper = new DebugHelper(str);
            debugHelper.mTag = str;
            sInstances.put(str, debugHelper);
        }
        return sInstances.get(str);
    }

    private String getLogString() {
        DebugProfile[] profile;
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.mTag + "]" + this.debugName + " Time Debuger [\n");
        for (DebugProfile debugProfile : getProfile()) {
            sb.append("TAG: ");
            sb.append(debugProfile.tag);
            sb.append("\t INC: ");
            sb.append(debugProfile.inc);
            sb.append("\t INCP: ");
            sb.append(debugProfile.incPercent);
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }

    private DebugProfile[] getProfile() {
        DebugProfile[] debugProfileArr = new DebugProfile[this.mTimes.size()];
        List<TimeTag> list = this.mTimes;
        long j2 = list.get(list.size() - 1).time;
        int i2 = 0;
        for (TimeTag timeTag : this.mTimes) {
            long j3 = timeTag.time;
            debugProfileArr[i2] = new DebugProfile(timeTag.tag, j3, j3 / (j2 * 1.0d));
            i2++;
        }
        return debugProfileArr;
    }

    public static boolean hasInstance(String str) {
        return sInstances.get(str) != null;
    }

    private void internalMark(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        this.lastLineNumber = this.curLineNumber;
        this.curLineNumber = stackTraceElement.getLineNumber();
        this.lastTime = this.curTime;
        long currentTimeMillis = System.currentTimeMillis();
        this.curTime = currentTimeMillis;
        this.mTimes.add(new TimeTag(str + " [" + this.lastLineNumber + "-->" + this.curLineNumber + "] ", currentTimeMillis - this.lastTime));
    }

    private void internalStart(String str) {
        StackTraceElement stackTraceElement;
        reset();
        this.curLineNumber = Thread.currentThread().getStackTrace()[4].getLineNumber();
        this.debugName = ("[" + stackTraceElement.getFileName() + "(" + this.curLineNumber + ") " + stackTraceElement.getMethodName() + "] ") + str;
        long currentTimeMillis = System.currentTimeMillis();
        this.startTime = currentTimeMillis;
        this.curTime = currentTimeMillis;
    }

    private void print() {
        a.m(TAG, getLogString(), new Object[0]);
    }

    private void reset() {
        this.startTime = 0L;
        this.endTime = 0L;
        this.lastTime = 0L;
        this.curTime = 0L;
        this.debugName = "";
        this.curLineNumber = 0;
        this.lastLineNumber = 0;
        this.mTimes.clear();
    }

    public void end() {
        if (d.f10987f) {
            long currentTimeMillis = System.currentTimeMillis();
            this.endTime = currentTimeMillis;
            this.mTimes.add(new TimeTag("total", currentTimeMillis - this.startTime));
            print();
            if (sInstances.get(this.mTag) != null) {
                sInstances.remove(this.mTag);
            }
            sInstances.remove(this.mTag);
        }
    }

    public void mark(String str) {
        if (d.f10987f) {
            internalMark(str);
        }
    }

    public void markThenEnd(String str) {
        if (d.f10987f) {
            internalMark(str);
            end();
        }
    }

    public void start(String str) {
        if (d.f10987f) {
            internalStart(str);
        }
    }

    public DebugHelper(String str) {
        this.lastTime = 0L;
        this.curTime = 0L;
        this.startTime = 0L;
        this.endTime = 0L;
        this.mTimes = new LinkedList();
        this.curLineNumber = 0;
        this.lastLineNumber = 0;
        this.mTag = str;
    }

    public void mark() {
        if (d.f10987f) {
            internalMark("");
        }
    }

    public void start() {
        if (d.f10987f) {
            internalStart("");
        }
    }

    public void markThenEnd() {
        if (d.f10987f) {
            internalMark("");
            end();
        }
    }
}

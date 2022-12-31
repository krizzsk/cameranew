package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
@AutoValue
/* loaded from: classes2.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult create(String str, long j2, HeartBeatInfo.HeartBeat heartBeat) {
        return new AutoValue_HeartBeatResult(str, j2, heartBeat);
    }

    public abstract HeartBeatInfo.HeartBeat getHeartBeat();

    public abstract long getMillis();

    public abstract String getSdkName();
}

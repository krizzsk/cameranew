package com.google.firebase.heartbeatinfo;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.g;
import java.util.List;
/* loaded from: classes2.dex */
public interface HeartBeatInfo {

    /* loaded from: classes2.dex */
    public enum HeartBeat {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);
        
        private final int code;

        HeartBeat(int i2) {
            this.code = i2;
        }

        public int getCode() {
            return this.code;
        }
    }

    @NonNull
    g<List<HeartBeatResult>> getAndClearStoredHeartBeatInfo();

    @NonNull
    HeartBeat getHeartBeatCode(@NonNull String str);

    @NonNull
    g<Void> storeHeartBeatInfo(@NonNull String str);
}

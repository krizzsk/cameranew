package us.pinguo.advconfigdata.AdvCacheInterface;

import android.os.Handler;
/* loaded from: classes3.dex */
public class AdvParams {
    private int mCacheCount;
    private long mCacheTime;
    private int mTapCount;
    private Handler mUIHandler = null;
    private String mMobId = null;
    private String mFbId = null;
    private boolean mbMultiTemplate = false;
    private String mGpId = null;

    public AdvParams(int i2, long j2, int i3, String str, String str2, Handler handler, String str3, boolean z) {
        SetCacheCount(i2);
        SetCacheTime(j2);
        SetTapCount(i3);
        SetMobId(str);
        SetFBid(str2);
        SetUIHandler(handler);
        SetMultiTemplate(z);
        SetGpId(str3);
    }

    public int GetCacheCount() {
        return this.mCacheCount;
    }

    public long GetCacheTime() {
        return this.mCacheTime;
    }

    public String GetFBid() {
        return this.mFbId;
    }

    public String GetGpId() {
        return this.mGpId;
    }

    public String GetMobID() {
        return this.mMobId;
    }

    public boolean GetMultiTemplate() {
        return this.mbMultiTemplate;
    }

    public int GetTapCount() {
        return this.mTapCount;
    }

    public Handler GetUIHandler() {
        return this.mUIHandler;
    }

    public void SetCacheCount(int i2) {
        this.mCacheCount = i2;
    }

    public void SetCacheTime(long j2) {
        this.mCacheTime = j2;
    }

    public void SetFBid(String str) {
        this.mFbId = str;
    }

    public void SetGpId(String str) {
        this.mGpId = str;
    }

    public void SetMobId(String str) {
        this.mMobId = str;
    }

    public void SetMultiTemplate(boolean z) {
        this.mbMultiTemplate = z;
    }

    public void SetTapCount(int i2) {
        this.mTapCount = i2;
    }

    public void SetUIHandler(Handler handler) {
        this.mUIHandler = handler;
    }
}

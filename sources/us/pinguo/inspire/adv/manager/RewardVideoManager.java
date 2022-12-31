package us.pinguo.inspire.adv.manager;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import us.pinguo.advsdk.a.b;
import us.pinguo.advsdk.a.l;
import us.pinguo.advsdk.manager.f;
import us.pinguo.advsdk.network.ExpNetWorkUtils;
/* loaded from: classes9.dex */
public class RewardVideoManager implements l {
    private static RewardVideoManager rewardVideoManager;
    private PGRewardVideoLoadListener loadListener;
    private HashMap<String, b> mPreloadData = new HashMap<>();
    private PGRewardVideoSuccessListener playListener;

    /* loaded from: classes9.dex */
    public interface PGRewardVideoLoadListener {
        void onLoadFailed(int i2, String str);

        void onLoadSuccess(b bVar);
    }

    /* loaded from: classes9.dex */
    public interface PGRewardVideoSuccessListener {
        void onPlayRewardVideoFailed(b bVar);

        void onPlayRewardVideoSuccess(b bVar);

        void onRewardVideoClose(b bVar);
    }

    private RewardVideoManager() {
    }

    public static RewardVideoManager getInstance() {
        if (rewardVideoManager == null) {
            synchronized (RewardVideoManager.class) {
                if (rewardVideoManager == null) {
                    rewardVideoManager = new RewardVideoManager();
                }
            }
        }
        return rewardVideoManager;
    }

    public boolean hasAd(String str) {
        return this.mPreloadData.containsKey(str);
    }

    @Override // us.pinguo.advsdk.a.l
    public void onAdDestroy(b bVar) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeClick(b bVar) {
    }

    public void onPGNativeClickFinishLoading(b bVar, View view) {
    }

    public void onPGNativeClickStartLoading(b bVar, View view) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeFailed(int i2, String str) {
        us.pinguo.advsdk.utils.b.a("Manager onPGNativeFailed");
        PGRewardVideoLoadListener pGRewardVideoLoadListener = this.loadListener;
        if (pGRewardVideoLoadListener != null) {
            pGRewardVideoLoadListener.onLoadFailed(i2, str);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGNativeSuccess(b bVar) {
        us.pinguo.advsdk.utils.b.a("Manager onPGNativeSuccess");
        this.mPreloadData.put(bVar.m(), bVar);
        PGRewardVideoLoadListener pGRewardVideoLoadListener = this.loadListener;
        if (pGRewardVideoLoadListener != null) {
            pGRewardVideoLoadListener.onLoadSuccess(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoClose(b bVar) {
        PGRewardVideoSuccessListener pGRewardVideoSuccessListener = this.playListener;
        if (pGRewardVideoSuccessListener != null) {
            pGRewardVideoSuccessListener.onRewardVideoClose(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoFailed(b bVar) {
        PGRewardVideoSuccessListener pGRewardVideoSuccessListener = this.playListener;
        if (pGRewardVideoSuccessListener != null) {
            pGRewardVideoSuccessListener.onPlayRewardVideoFailed(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPGRewardVideoSuccess(b bVar) {
        us.pinguo.advsdk.utils.b.a("Manager onPGRewardVideoSuccess");
        PGRewardVideoSuccessListener pGRewardVideoSuccessListener = this.playListener;
        if (pGRewardVideoSuccessListener != null) {
            pGRewardVideoSuccessListener.onPlayRewardVideoSuccess(bVar);
        }
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadFailed(int i2, String str) {
    }

    @Override // us.pinguo.advsdk.a.l
    public void onPreloadSuccess(b bVar) {
    }

    public void preload(Context context, String str) {
        preload(context, str, null);
    }

    public boolean show(Context context, String str, PGRewardVideoSuccessListener pGRewardVideoSuccessListener) {
        ExpNetWorkUtils.getInstance().d(context, str);
        if (!this.mPreloadData.containsKey(str)) {
            us.pinguo.advsdk.utils.b.a("RewardVideo cache not ready");
            return false;
        }
        this.playListener = pGRewardVideoSuccessListener;
        this.mPreloadData.get(str).r(context, null);
        this.mPreloadData.remove(str);
        return true;
    }

    public void preload(Context context, String str, PGRewardVideoLoadListener pGRewardVideoLoadListener) {
        HashMap hashMap = new HashMap();
        hashMap.put("cache_num", "1");
        hashMap.put("pg_unit_id", str);
        f fVar = new f(context, hashMap);
        fVar.B(this);
        this.loadListener = pGRewardVideoLoadListener;
        if (this.mPreloadData.containsKey(str)) {
            PGRewardVideoLoadListener pGRewardVideoLoadListener2 = this.loadListener;
            if (pGRewardVideoLoadListener2 != null) {
                pGRewardVideoLoadListener2.onLoadSuccess(this.mPreloadData.get(str));
                return;
            }
            return;
        }
        fVar.B(this);
        fVar.r(context, false);
    }
}

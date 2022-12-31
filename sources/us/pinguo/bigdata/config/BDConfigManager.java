package us.pinguo.bigdata.config;

import androidx.annotation.NonNull;
import us.pinguo.bigdata.c.a;
/* loaded from: classes3.dex */
public class BDConfigManager {
    private static final String KEY_CACHE_LOCAL_CONFIG = "key_cache_local_config";
    private static final String KEY_CACHE_SERVER_CONFIG = "key_cache_server_config";
    private static a<BDLocalConfig> mLocalCache;
    private static volatile BDConfigManager mManager;
    private static a<BDServerConfig> mServerCache;
    private BDLocalConfig mBDLocalConfig;
    private BDServerConfig mBDServerConfig;

    private BDConfigManager() {
        mLocalCache = new a<>();
        mServerCache = new a<>();
    }

    @NonNull
    private BDLocalConfig getDefaultLocalConfig() {
        return new BDLocalConfig();
    }

    @NonNull
    private BDServerConfig getDefaultServerConfig() {
        return new BDServerConfig();
    }

    public static BDConfigManager instance() {
        if (mManager == null) {
            synchronized (BDConfigManager.class) {
                if (mManager == null) {
                    mManager = new BDConfigManager();
                }
            }
        }
        return mManager;
    }

    public BDLocalConfig getLocalConfig() {
        BDLocalConfig bDLocalConfig = this.mBDLocalConfig;
        if (bDLocalConfig != null) {
            return bDLocalConfig;
        }
        BDLocalConfig c = mLocalCache.c(KEY_CACHE_LOCAL_CONFIG);
        this.mBDLocalConfig = c;
        if (c == null) {
            BDLocalConfig defaultLocalConfig = getDefaultLocalConfig();
            this.mBDLocalConfig = defaultLocalConfig;
            mLocalCache.f(KEY_CACHE_LOCAL_CONFIG, defaultLocalConfig);
        }
        return this.mBDLocalConfig;
    }

    public BDServerConfig getServerConfig() {
        BDServerConfig bDServerConfig = this.mBDServerConfig;
        if (bDServerConfig != null) {
            return bDServerConfig;
        }
        if (mServerCache == null) {
            mServerCache = new a<>();
        }
        BDServerConfig c = mServerCache.c(KEY_CACHE_SERVER_CONFIG);
        this.mBDServerConfig = c;
        if (c == null) {
            BDServerConfig defaultServerConfig = getDefaultServerConfig();
            this.mBDServerConfig = defaultServerConfig;
            mServerCache.f(KEY_CACHE_SERVER_CONFIG, defaultServerConfig);
        }
        return this.mBDServerConfig;
    }

    public void updateLocalConfig() {
        if (mLocalCache == null) {
            mLocalCache = new a<>();
        }
        mLocalCache.f(KEY_CACHE_LOCAL_CONFIG, this.mBDLocalConfig);
    }

    public void updateServerConfig(BDServerConfig bDServerConfig) {
        if (mServerCache == null) {
            mServerCache = new a<>();
        }
        this.mBDServerConfig = bDServerConfig;
        mServerCache.f(KEY_CACHE_SERVER_CONFIG, bDServerConfig);
    }
}

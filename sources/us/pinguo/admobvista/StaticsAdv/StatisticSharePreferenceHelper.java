package us.pinguo.admobvista.StaticsAdv;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class StatisticSharePreferenceHelper {
    public static final String SP_CLICK_COUNT = "key_click_count";
    public static final String SP_SHOW_COUNT = "key_show_count";
    private static long mClickCount;
    private static Context mContext;
    private static long mShowCount;
    private static ExecutorService mSingleThreadExcutor;
    private static Boolean mIsInit = Boolean.FALSE;
    private static Runnable mClickRunable = new a();
    private static Runnable mShowRunable = new b();

    /* loaded from: classes3.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            us.pinguo.admobvista.f.a.b(StatisticSharePreferenceHelper.mContext, StatisticSharePreferenceHelper.SP_CLICK_COUNT, Long.valueOf(StatisticSharePreferenceHelper.mClickCount));
        }
    }

    /* loaded from: classes3.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            us.pinguo.admobvista.f.a.b(StatisticSharePreferenceHelper.mContext, StatisticSharePreferenceHelper.SP_CLICK_COUNT, Long.valueOf(StatisticSharePreferenceHelper.mShowCount));
        }
    }

    public static long getClickCount() {
        return mClickCount;
    }

    public static long getShowCount() {
        return mShowCount;
    }

    public static void init(Context context) {
        mContext = context;
        mSingleThreadExcutor = Executors.newSingleThreadExecutor();
        mShowCount = ((Long) us.pinguo.admobvista.f.a.a(context, SP_SHOW_COUNT, 0L)).longValue();
        mClickCount = ((Long) us.pinguo.admobvista.f.a.a(context, SP_CLICK_COUNT, 0L)).longValue();
        mIsInit = Boolean.TRUE;
    }

    public static void onAdvClick() {
        if (mIsInit.booleanValue()) {
            mClickCount++;
            mSingleThreadExcutor.execute(mClickRunable);
        }
    }

    public static void onAdvShow() {
        if (mIsInit.booleanValue()) {
            mShowCount++;
            mSingleThreadExcutor.execute(mShowRunable);
        }
    }
}

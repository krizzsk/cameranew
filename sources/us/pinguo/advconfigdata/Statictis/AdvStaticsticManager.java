package us.pinguo.advconfigdata.Statictis;

import us.pinguo.advconfigdata.Interface.AdvStaticsInterfaceNull;
import us.pinguo.advconfigdata.Interface.AdvStaticsticInterface;
/* loaded from: classes3.dex */
public class AdvStaticsticManager {
    private static AdvStaticsticManager mStaticManager;
    private AdvStaticsInterfaceNull mNullListener;
    private AdvStaticsticInterface mStaticsLisenter;

    public static AdvStaticsticManager GetInstance() {
        if (mStaticManager == null) {
            mStaticManager = new AdvStaticsticManager();
        }
        return mStaticManager;
    }

    public AdvStaticsticInterface GetStaticInterface() {
        AdvStaticsticInterface advStaticsticInterface = this.mStaticsLisenter;
        if (advStaticsticInterface == null) {
            if (this.mNullListener == null) {
                this.mNullListener = new AdvStaticsInterfaceNull();
            }
            return this.mNullListener;
        }
        return advStaticsticInterface;
    }

    public void Init(AdvStaticsticInterface advStaticsticInterface) {
        this.mStaticsLisenter = advStaticsticInterface;
    }
}

package us.pinguo.repository2020.entity;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.s;
import us.pinguo.foundation.utils.NoProguard;
/* compiled from: Material.kt */
/* loaded from: classes6.dex */
public class Material implements NoProguard {
    public static final Companion Companion = new Companion(null);
    public static final String HEX_DEFAULT = "CBBBBB";
    public static final String HEX_TRANSPARENT = "00000000";
    public static final String MATERIAL_COLLECT = "collect";
    public static final String MATERIAL_CUSTOMIZATION = "customization";
    public static final String MATERIAL_DUSTBIN = "dustbin";
    public static final int MATERIAL_PACKAGE_NOT_VIP = 0;
    public static final int MATERIAL_PACKAGE_PARTIAL_VIP = 2;
    public static final int MATERIAL_PACKAGE_VIP = 1;
    public static final String MATERIAL_RECENT = "recent";
    public static final String MATERIAL_SELECT_NONE_FLAG = "wu";
    private final String down_url;
    private transient ObservableInt downloadProgress;
    private String icon;
    private transient ObservableField<MaterialInstallState> installState;
    private transient ObservableBoolean isCollected;
    private transient ObservableBoolean isDark;
    private transient ObservableBoolean isSelected;
    private final String name;
    private final Long off_time;
    private final Long onsale_time;
    private final String pid;
    private Integer vip;

    /* compiled from: Material.kt */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(o oVar) {
            this();
        }
    }

    public Material() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public Material(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num) {
        this.pid = str;
        this.icon = str2;
        this.name = str3;
        this.down_url = str4;
        this.onsale_time = l2;
        this.off_time = l3;
        this.vip = num;
        this.installState = new ObservableField<>(MaterialInstallState.STATE_UNDOWNLOAD);
        this.isDark = new ObservableBoolean(true);
        this.isCollected = new ObservableBoolean(false);
        this.downloadProgress = new ObservableInt(0);
    }

    public String getDown_url() {
        return this.down_url;
    }

    public ObservableInt getDownloadProgress() {
        return this.downloadProgress;
    }

    public String getIcon() {
        return this.icon;
    }

    public ObservableField<MaterialInstallState> getInstallState() {
        return this.installState;
    }

    public String getName() {
        return this.name;
    }

    public Long getOff_time() {
        return this.off_time;
    }

    public Long getOnsale_time() {
        return this.onsale_time;
    }

    public String getPid() {
        return this.pid;
    }

    public Integer getVip() {
        return this.vip;
    }

    public final boolean isBuildIn() {
        Long onsale_time = getOnsale_time();
        if ((onsale_time == null ? 0L : onsale_time.longValue()) == 0) {
            Long off_time = getOff_time();
            if ((off_time == null ? 0L : off_time.longValue()) == 0) {
                return true;
            }
        }
        return false;
    }

    public ObservableBoolean isCollected() {
        return this.isCollected;
    }

    public ObservableBoolean isDark() {
        return this.isDark;
    }

    public final boolean isInstalled() {
        ObservableField<MaterialInstallState> installState = getInstallState();
        return (installState == null ? null : installState.get()) == MaterialInstallState.STATE_INSTALLED;
    }

    public final boolean isOnLine() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (getOnsale_time() != null && getOff_time() != null) {
            Long onsale_time = getOnsale_time();
            if ((onsale_time == null ? 0L : onsale_time.longValue()) <= currentTimeMillis) {
                Long off_time = getOff_time();
                if (currentTimeMillis <= (off_time != null ? off_time.longValue() : 0L)) {
                    return true;
                }
            }
        }
        return false;
    }

    public ObservableBoolean isSelected() {
        return this.isSelected;
    }

    public void setCollected(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isCollected = observableBoolean;
    }

    public void setDark(ObservableBoolean observableBoolean) {
        s.h(observableBoolean, "<set-?>");
        this.isDark = observableBoolean;
    }

    public void setDownloadProgress(ObservableInt observableInt) {
        this.downloadProgress = observableInt;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setInstallState(ObservableField<MaterialInstallState> observableField) {
        this.installState = observableField;
    }

    public void setSelected(ObservableBoolean observableBoolean) {
        this.isSelected = observableBoolean;
    }

    public void setVip(Integer num) {
        this.vip = num;
    }

    public /* synthetic */ Material(String str, String str2, String str3, String str4, Long l2, Long l3, Integer num, int i2, o oVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : l2, (i2 & 32) != 0 ? null : l3, (i2 & 64) != 0 ? null : num);
    }
}

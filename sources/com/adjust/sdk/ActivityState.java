package com.adjust.sdk;

import com.coremedia.iso.boxes.UserBox;
import com.tapjoy.TJAdUnitConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ActivityState implements Serializable, Cloneable {
    private static final int ORDER_ID_MAXCOUNT = 10;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 9039439291143138148L;
    private transient ILogger logger = AdjustFactory.getLogger();
    protected String uuid = Util.createUuid();
    protected boolean enabled = true;
    protected boolean isGdprForgotten = false;
    protected boolean isThirdPartySharingDisabled = false;
    protected boolean askingAttribution = false;
    protected int eventCount = 0;
    protected int sessionCount = 0;
    protected int subsessionCount = -1;
    protected long sessionLength = -1;
    protected long timeSpent = -1;
    protected long lastActivity = -1;
    protected long lastInterval = -1;
    protected boolean updatePackages = false;
    protected LinkedList<String> orderIds = null;
    protected String pushToken = null;
    protected String adid = null;
    protected long clickTime = 0;
    protected long installBegin = 0;
    protected String installReferrer = null;
    protected Boolean googlePlayInstant = null;
    protected long clickTimeServer = 0;
    protected long installBeginServer = 0;
    protected String installVersion = null;
    protected long clickTimeHuawei = 0;
    protected long installBeginHuawei = 0;
    protected String installReferrerHuawei = null;

    static {
        Class cls = Boolean.TYPE;
        Class cls2 = Integer.TYPE;
        Class cls3 = Long.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField(UserBox.TYPE, String.class), new ObjectStreamField(TJAdUnitConstants.String.ENABLED, cls), new ObjectStreamField("isGdprForgotten", cls), new ObjectStreamField("isThirdPartySharingDisabled", cls), new ObjectStreamField("askingAttribution", cls), new ObjectStreamField("eventCount", cls2), new ObjectStreamField("sessionCount", cls2), new ObjectStreamField("subsessionCount", cls2), new ObjectStreamField("sessionLength", cls3), new ObjectStreamField("timeSpent", cls3), new ObjectStreamField("lastActivity", cls3), new ObjectStreamField("lastInterval", cls3), new ObjectStreamField("updatePackages", cls), new ObjectStreamField("orderIds", LinkedList.class), new ObjectStreamField("pushToken", String.class), new ObjectStreamField("adid", String.class), new ObjectStreamField("clickTime", cls3), new ObjectStreamField("installBegin", cls3), new ObjectStreamField("installReferrer", String.class), new ObjectStreamField("googlePlayInstant", Boolean.class), new ObjectStreamField("clickTimeServer", cls3), new ObjectStreamField("installBeginServer", cls3), new ObjectStreamField("installVersion", String.class), new ObjectStreamField("clickTimeHuawei", cls3), new ObjectStreamField("installBeginHuawei", cls3), new ObjectStreamField("installReferrerHuawei", String.class)};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField readFields = objectInputStream.readFields();
        this.eventCount = Util.readIntField(readFields, "eventCount", 0);
        this.sessionCount = Util.readIntField(readFields, "sessionCount", 0);
        this.subsessionCount = Util.readIntField(readFields, "subsessionCount", -1);
        this.sessionLength = Util.readLongField(readFields, "sessionLength", -1L);
        this.timeSpent = Util.readLongField(readFields, "timeSpent", -1L);
        this.lastActivity = Util.readLongField(readFields, "lastActivity", -1L);
        this.lastInterval = Util.readLongField(readFields, "lastInterval", -1L);
        this.uuid = Util.readStringField(readFields, UserBox.TYPE, null);
        this.enabled = Util.readBooleanField(readFields, TJAdUnitConstants.String.ENABLED, true);
        this.isGdprForgotten = Util.readBooleanField(readFields, "isGdprForgotten", false);
        this.isThirdPartySharingDisabled = Util.readBooleanField(readFields, "isThirdPartySharingDisabled", false);
        this.askingAttribution = Util.readBooleanField(readFields, "askingAttribution", false);
        this.updatePackages = Util.readBooleanField(readFields, "updatePackages", false);
        this.orderIds = (LinkedList) Util.readObjectField(readFields, "orderIds", null);
        this.pushToken = Util.readStringField(readFields, "pushToken", null);
        this.adid = Util.readStringField(readFields, "adid", null);
        this.clickTime = Util.readLongField(readFields, "clickTime", -1L);
        this.installBegin = Util.readLongField(readFields, "installBegin", -1L);
        this.installReferrer = Util.readStringField(readFields, "installReferrer", null);
        this.googlePlayInstant = (Boolean) Util.readObjectField(readFields, "googlePlayInstant", null);
        this.clickTimeServer = Util.readLongField(readFields, "clickTimeServer", -1L);
        this.installBeginServer = Util.readLongField(readFields, "installBeginServer", -1L);
        this.installVersion = Util.readStringField(readFields, "installVersion", null);
        this.clickTimeHuawei = Util.readLongField(readFields, "clickTimeHuawei", -1L);
        this.installBeginHuawei = Util.readLongField(readFields, "installBeginHuawei", -1L);
        this.installReferrerHuawei = Util.readStringField(readFields, "installReferrerHuawei", null);
        if (this.uuid == null) {
            this.uuid = Util.createUuid();
        }
    }

    private static String stamp(long j2) {
        Calendar.getInstance().setTimeInMillis(j2);
        return Util.formatString("%02d:%02d:%02d", 11, 12, 13);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addOrderId(String str) {
        if (this.orderIds == null) {
            this.orderIds = new LinkedList<>();
        }
        if (this.orderIds.size() >= 10) {
            this.orderIds.removeLast();
        }
        this.orderIds.addFirst(str);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityState activityState = (ActivityState) obj;
            return Util.equalString(this.uuid, activityState.uuid) && Util.equalBoolean(Boolean.valueOf(this.enabled), Boolean.valueOf(activityState.enabled)) && Util.equalBoolean(Boolean.valueOf(this.isGdprForgotten), Boolean.valueOf(activityState.isGdprForgotten)) && Util.equalBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled), Boolean.valueOf(activityState.isThirdPartySharingDisabled)) && Util.equalBoolean(Boolean.valueOf(this.askingAttribution), Boolean.valueOf(activityState.askingAttribution)) && Util.equalInt(Integer.valueOf(this.eventCount), Integer.valueOf(activityState.eventCount)) && Util.equalInt(Integer.valueOf(this.sessionCount), Integer.valueOf(activityState.sessionCount)) && Util.equalInt(Integer.valueOf(this.subsessionCount), Integer.valueOf(activityState.subsessionCount)) && Util.equalLong(Long.valueOf(this.sessionLength), Long.valueOf(activityState.sessionLength)) && Util.equalLong(Long.valueOf(this.timeSpent), Long.valueOf(activityState.timeSpent)) && Util.equalLong(Long.valueOf(this.lastInterval), Long.valueOf(activityState.lastInterval)) && Util.equalBoolean(Boolean.valueOf(this.updatePackages), Boolean.valueOf(activityState.updatePackages)) && Util.equalObject(this.orderIds, activityState.orderIds) && Util.equalString(this.pushToken, activityState.pushToken) && Util.equalString(this.adid, activityState.adid) && Util.equalLong(Long.valueOf(this.clickTime), Long.valueOf(activityState.clickTime)) && Util.equalLong(Long.valueOf(this.installBegin), Long.valueOf(activityState.installBegin)) && Util.equalString(this.installReferrer, activityState.installReferrer) && Util.equalBoolean(this.googlePlayInstant, activityState.googlePlayInstant) && Util.equalLong(Long.valueOf(this.clickTimeServer), Long.valueOf(activityState.clickTimeServer)) && Util.equalLong(Long.valueOf(this.installBeginServer), Long.valueOf(activityState.installBeginServer)) && Util.equalString(this.installVersion, activityState.installVersion) && Util.equalLong(Long.valueOf(this.clickTimeHuawei), Long.valueOf(activityState.clickTimeHuawei)) && Util.equalLong(Long.valueOf(this.installBeginHuawei), Long.valueOf(activityState.installBeginHuawei)) && Util.equalString(this.installReferrerHuawei, activityState.installReferrerHuawei);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean findOrderId(String str) {
        LinkedList<String> linkedList = this.orderIds;
        if (linkedList == null) {
            return false;
        }
        return linkedList.contains(str);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((629 + Util.hashString(this.uuid)) * 37) + Util.hashBoolean(Boolean.valueOf(this.enabled))) * 37) + Util.hashBoolean(Boolean.valueOf(this.isGdprForgotten))) * 37) + Util.hashBoolean(Boolean.valueOf(this.isThirdPartySharingDisabled))) * 37) + Util.hashBoolean(Boolean.valueOf(this.askingAttribution))) * 37) + this.eventCount) * 37) + this.sessionCount) * 37) + this.subsessionCount) * 37) + Util.hashLong(Long.valueOf(this.sessionLength))) * 37) + Util.hashLong(Long.valueOf(this.timeSpent))) * 37) + Util.hashLong(Long.valueOf(this.lastInterval))) * 37) + Util.hashBoolean(Boolean.valueOf(this.updatePackages))) * 37) + Util.hashObject(this.orderIds)) * 37) + Util.hashString(this.pushToken)) * 37) + Util.hashString(this.adid)) * 37) + Util.hashLong(Long.valueOf(this.clickTime))) * 37) + Util.hashLong(Long.valueOf(this.installBegin))) * 37) + Util.hashString(this.installReferrer)) * 37) + Util.hashBoolean(this.googlePlayInstant)) * 37) + Util.hashLong(Long.valueOf(this.clickTimeServer))) * 37) + Util.hashLong(Long.valueOf(this.installBeginServer))) * 37) + Util.hashString(this.installVersion)) * 37) + Util.hashLong(Long.valueOf(this.clickTimeHuawei))) * 37) + Util.hashLong(Long.valueOf(this.installBeginHuawei))) * 37) + Util.hashString(this.installReferrerHuawei);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetSessionAttributes(long j2) {
        this.subsessionCount = 1;
        this.sessionLength = 0L;
        this.timeSpent = 0L;
        this.lastActivity = j2;
        this.lastInterval = -1L;
    }

    public String toString() {
        return Util.formatString("ec:%d sc:%d ssc:%d sl:%.1f ts:%.1f la:%s uuid:%s", Integer.valueOf(this.eventCount), Integer.valueOf(this.sessionCount), Integer.valueOf(this.subsessionCount), Double.valueOf(this.sessionLength / 1000.0d), Double.valueOf(this.timeSpent / 1000.0d), stamp(this.lastActivity), this.uuid);
    }
}

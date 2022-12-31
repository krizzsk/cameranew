package com.growingio.android.sdk.ipc;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.growingio.android.sdk.collection.CoreInitialize;
import com.growingio.android.sdk.collection.GConfig;
import com.growingio.android.sdk.utils.LogUtil;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import us.pinguo.inspire.module.profile.activity.GuestProfileFragment;
/* loaded from: classes2.dex */
public class GrowingIOIPC {
    private static final int MODEL_NORMAL = 0;
    private static final String TAG = "GIO.IPC";
    @VisibleForTesting
    VariableSharer variableSharer;
    @VisibleForTesting
    int sessionIndex = -1;
    int userIdIndex = -1;
    int lastPauseTimeIndex = -1;
    int lastResumeTimeIndex = -1;
    int visitorVarIndex = -1;
    int appVarIndex = -1;
    int isFirstIpcIndex = -1;
    int specialModelIndex = -1;
    int tokensIndex = -1;
    int wsUrlIndex = -1;
    int gioUserIdIndex = -1;

    private int addSelf(int i2) {
        int intByIndex;
        int i3;
        do {
            intByIndex = this.variableSharer.getIntByIndex(i2);
            i3 = intByIndex + 1;
        } while (!this.variableSharer.compareAndSetIntByIndex(i2, intByIndex, i3));
        return i3;
    }

    private JSONObject getJsonObj(int i2) {
        String stringByIndex = this.variableSharer.getStringByIndex(i2);
        if (stringByIndex == null) {
            return null;
        }
        try {
            return new JSONObject(stringByIndex);
        } catch (JSONException e2) {
            LogUtil.d(TAG, "getJsonObj failed: " + i2, e2);
            return null;
        }
    }

    private void initVariableVersion1(Context context) {
        this.sessionIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("sessionId", 10));
        this.userIdIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable(GuestProfileFragment.USER_ID, 1000));
        this.lastPauseTimeIndex = this.variableSharer.addVariableEntity(VariableEntity.createLongVariable("lastPauseTime"));
        this.lastResumeTimeIndex = this.variableSharer.addVariableEntity(VariableEntity.createLongVariable("lastResumeTime"));
        this.visitorVarIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("visitorVar", 1000));
        this.appVarIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("appVar", 1000));
        this.isFirstIpcIndex = this.variableSharer.addVariableEntity(VariableEntity.createIntVariable("firstIpc"));
        this.specialModelIndex = this.variableSharer.addVariableEntity(VariableEntity.createIntVariable("specialModel"));
        this.tokensIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("tokens", 20));
        this.wsUrlIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("wsUrl", 20));
        this.gioUserIdIndex = this.variableSharer.addVariableEntity(VariableEntity.createStringVariable("gioUserId", 20));
        this.variableSharer.completeMetaData(getRunningProcess(context));
        if (this.variableSharer.isFirstInit()) {
            this.variableSharer.putIntByIndex(this.specialModelIndex, 0);
            this.variableSharer.putStringByIndex(this.tokensIndex, null);
            this.variableSharer.putStringByIndex(this.wsUrlIndex, null);
            this.variableSharer.putStringByIndex(this.gioUserIdIndex, null);
            setAppVar(null);
            setVisitorVar(null);
            setLastPauseTime(System.currentTimeMillis());
            if (this.variableSharer.getIntByIndex(this.isFirstIpcIndex) == 0) {
                migrateData(context);
            }
        }
    }

    private void migrateData(Context context) {
        String string = context.getSharedPreferences(GConfig.PREF_FILE_NAME, 0).getString(GConfig.PREF_USER_ID_IN_APP, null);
        if (string != null) {
            this.variableSharer.putStringByIndex(this.userIdIndex, string);
        }
    }

    private void setJsonObj(int i2, @Nullable JSONObject jSONObject) {
        this.variableSharer.putStringByIndex(i2, jSONObject == null ? null : jSONObject.toString());
    }

    public void dumpToLog() {
        LogUtil.e(TAG, "GrowingIOIPC(userId=" + getUserId() + ", specialModel=" + getSpecialModel() + ", sessionId" + getSessionId() + ")");
        this.variableSharer.dumpModCountInfo();
    }

    public List<Integer> getAlivePid() {
        return this.variableSharer.getAlivePid(getRunningProcess(CoreInitialize.coreAppState().getGlobalContext()));
    }

    public JSONObject getAppVar() {
        return getJsonObj(this.appVarIndex);
    }

    public String getGioUserId() {
        return this.variableSharer.getStringByIndex(this.gioUserIdIndex);
    }

    public long getLastPauseTime() {
        return this.variableSharer.getLongByIndex(this.lastPauseTimeIndex);
    }

    public long getLastResumeTime() {
        return this.variableSharer.getLongByIndex(this.lastResumeTimeIndex);
    }

    Set<Integer> getRunningProcess(Context context) {
        HashSet hashSet = new HashSet();
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            int myUid = Process.myUid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (myUid == runningAppProcessInfo.uid) {
                    hashSet.add(Integer.valueOf(runningAppProcessInfo.pid));
                }
            }
        } catch (Throwable th) {
            LogUtil.e(TAG, th.getMessage(), th);
        }
        return hashSet;
    }

    public String getSessionId() {
        return this.variableSharer.getStringByIndex(this.sessionIndex);
    }

    public int getSpecialModel() {
        return this.variableSharer.getIntByIndex(this.specialModelIndex);
    }

    public String getToken() {
        return this.variableSharer.getStringByIndex(this.tokensIndex);
    }

    public String getUserId() {
        return this.variableSharer.getStringByIndex(this.userIdIndex);
    }

    public JSONObject getVisitorVar() {
        return getJsonObj(this.visitorVarIndex);
    }

    public String getWsServerUrl() {
        return this.variableSharer.getStringByIndex(this.wsUrlIndex);
    }

    public void init(Context context, GConfig gConfig) {
        File file = new File(context.getFilesDir(), ".gio.dir");
        if (!file.exists()) {
            file.mkdirs();
        }
        this.variableSharer = new VariableSharer(new File(file, "gio.ipc.1"), true, Process.myPid());
        long currentTimeMillis = System.currentTimeMillis();
        initVariableVersion1(context);
        LogUtil.d(TAG, "variableSharer init time: " + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void setAppVar(@Nullable JSONObject jSONObject) {
        setJsonObj(this.appVarIndex, jSONObject);
    }

    public void setGioUserId(String str) {
        this.variableSharer.putStringByIndex(this.gioUserIdIndex, str);
    }

    public void setLastPauseTime(long j2) {
        this.variableSharer.putLongByIndex(this.lastPauseTimeIndex, j2);
    }

    public void setLastResumeTime(long j2) {
        this.variableSharer.putLongByIndex(this.lastResumeTimeIndex, j2);
    }

    public void setSessionId(String str) {
        this.variableSharer.putStringByIndex(this.sessionIndex, str);
    }

    public void setSpecialModel(int i2) {
        this.variableSharer.putIntByIndex(this.specialModelIndex, i2);
    }

    public void setToken(String str) {
        this.variableSharer.putStringByIndex(this.tokensIndex, str);
    }

    public void setUserId(@Nullable String str) {
        this.variableSharer.putStringByIndex(this.userIdIndex, str);
    }

    public void setVisitorVar(@Nullable JSONObject jSONObject) {
        setJsonObj(this.visitorVarIndex, jSONObject);
    }

    public void setWsServerUrl(String str) {
        this.variableSharer.putStringByIndex(this.wsUrlIndex, str);
    }
}

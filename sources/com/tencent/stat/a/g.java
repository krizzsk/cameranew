package com.tencent.stat.a;

import android.content.Context;
import com.tencent.stat.StatGameUser;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends e {
    private StatGameUser a;

    public g(Context context, int i2, StatGameUser statGameUser) {
        super(context, i2);
        this.a = null;
        this.a = statGameUser.m39clone();
    }

    @Override // com.tencent.stat.a.e
    public f a() {
        return f.MTA_GAME_USER;
    }

    @Override // com.tencent.stat.a.e
    public boolean a(JSONObject jSONObject) {
        StatGameUser statGameUser = this.a;
        if (statGameUser == null) {
            return false;
        }
        com.tencent.stat.common.k.a(jSONObject, "wod", statGameUser.getWorldName());
        com.tencent.stat.common.k.a(jSONObject, "gid", this.a.getAccount());
        com.tencent.stat.common.k.a(jSONObject, "lev", this.a.getLevel());
        return true;
    }
}

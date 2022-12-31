package us.pinguo.interaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.pinguo.camera360.vip.VipManager;
/* compiled from: DestinationMember.java */
/* loaded from: classes4.dex */
public class v extends us.pinguo.foundation.interaction.b {
    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public Intent a(Uri uri, Bundle bundle, Context context) {
        Intent intent = new Intent();
        VipManager vipManager = VipManager.a;
        if (!vipManager.G() && !vipManager.H()) {
            intent.setClassName(context, "com.pinguo.camera360.member.MemberRightsActivity");
        } else {
            intent.setClassName(context, "com.pinguo.camera360.member.SubscriptionMemberActivity");
        }
        intent.putExtra("is_from_notice", true);
        return intent;
    }

    @Override // us.pinguo.foundation.interaction.b, us.pinguo.foundation.interaction.a
    public boolean d(Uri uri) {
        return "app://camera360/member".equals(uri.toString());
    }
}

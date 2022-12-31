package us.pinguo.inspire.base;

import us.pinguo.foundation.constant.MessageType;
import us.pinguo.inspire.Inspire;
import us.pinguo.util.q;
import vStudio.Android.Camera360.R;
/* compiled from: EmptyTipUtils.java */
/* loaded from: classes9.dex */
public class c {
    public static void a(us.pinguo.user.recycler.c cVar, boolean z) {
        if (z) {
            cVar.showEmpty(0, R.drawable.empty_follow_icon, R.string.empty_profile_attention_mine_tip);
        } else {
            cVar.showEmpty(0, R.drawable.empty_follow_icon, R.string.empty_profile_attention_guest_tip);
        }
    }

    public static void b(us.pinguo.user.recycler.c cVar) {
        cVar.showEmpty(cVar.getItemCount() == 0 ? 0 : 1, us.pinguo.user.R.drawable.default_error_icon, R.string.empty_can_not_find_friends);
    }

    public static void c(us.pinguo.user.recycler.c cVar, boolean z) {
        if (z) {
            cVar.showEmpty(0, us.pinguo.user.R.drawable.default_error_icon, R.string.empty_fans_mine_text);
        } else {
            cVar.showEmpty(0, us.pinguo.user.R.drawable.default_error_icon, R.string.empty_fans_guest_text);
        }
    }

    public static void d(us.pinguo.user.recycler.c cVar, boolean z) {
        boolean f2 = q.f(Inspire.a());
        if (z) {
            if (f2) {
                cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.user.R.string.no_more_content);
            } else {
                cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.ui.R.string.network_not_available);
            }
        } else if (f2) {
            cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.user.R.string.no_more_content);
        } else {
            cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.ui.R.string.network_not_available);
        }
    }

    public static void e(us.pinguo.user.recycler.c cVar, boolean z) {
        boolean f2 = q.f(Inspire.a());
        if (z) {
            if (f2) {
                cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.user.R.string.no_more_content);
            } else {
                cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.ui.R.string.network_not_available);
            }
        } else if (f2) {
            cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.user.R.string.no_more_content);
        } else {
            cVar.showEmpty(1, R.drawable.empty_like_icon, us.pinguo.ui.R.string.network_not_available);
        }
    }

    public static void f(us.pinguo.user.recycler.c cVar, MessageType messageType) {
        if (messageType == MessageType.COMMENT) {
            cVar.showEmpty(0, R.drawable.empty_comment_icon, R.string.empty_comment_text);
        } else if (messageType == MessageType.LIKE) {
            cVar.showEmpty(0, R.drawable.empty_like_icon, R.string.empty_like_text);
        } else if (messageType == MessageType.AT) {
            cVar.showEmpty(0, R.drawable.empty_at_icon, R.string.empty_at_text);
        } else if (messageType != MessageType.VOTE && messageType != MessageType.AWARDS) {
            if (messageType == MessageType.FANS) {
                cVar.showEmpty(0, us.pinguo.user.R.drawable.default_error_icon, R.string.empty_fans_mine_text);
            } else if (messageType == MessageType.FLOWER) {
                cVar.showEmpty(0, us.pinguo.user.R.drawable.default_error_icon, -1);
            }
        } else {
            cVar.showEmpty(0, R.drawable.empty_comment_icon, R.string.empty_notice_text);
        }
    }

    public static void g(us.pinguo.user.recycler.c cVar, boolean z) {
        boolean f2 = q.f(Inspire.a());
        if (z) {
            if (f2) {
                cVar.showEmpty(1, us.pinguo.user.R.drawable.empty_default_icon, R.string.empty_mine_work);
            } else {
                cVar.showEmpty(1, us.pinguo.user.R.drawable.empty_default_icon, us.pinguo.ui.R.string.network_not_available);
            }
        } else if (f2) {
            cVar.showEmpty(1, us.pinguo.user.R.drawable.empty_default_icon, R.string.empty_guest_work);
        } else {
            cVar.showEmpty(1, us.pinguo.user.R.drawable.empty_default_icon, us.pinguo.ui.R.string.network_not_available);
        }
    }

    public static void h(us.pinguo.user.recycler.c cVar) {
        cVar.showEmpty(0, us.pinguo.user.R.drawable.default_error_icon, R.string.empty_search_text);
    }
}

package us.pinguo.inspire.module.comment;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import java.util.List;
/* loaded from: classes9.dex */
public class CommentUtils {
    public static PopupMenu showSimpleMenu(Context context, List<String> list, View view, final PopupMenu.OnMenuItemClickListener onMenuItemClickListener) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        for (int i2 = 0; i2 < list.size(); i2++) {
            popupMenu.getMenu().add(0, i2, i2, list.get(i2));
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: us.pinguo.inspire.module.comment.CommentUtils.1
            @Override // androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener
            public boolean onMenuItemClick(MenuItem menuItem) {
                PopupMenu.OnMenuItemClickListener onMenuItemClickListener2 = PopupMenu.OnMenuItemClickListener.this;
                if (onMenuItemClickListener2 != null) {
                    return onMenuItemClickListener2.onMenuItemClick(menuItem);
                }
                return true;
            }
        });
        popupMenu.show();
        return popupMenu;
    }
}

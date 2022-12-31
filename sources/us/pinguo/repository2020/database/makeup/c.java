package us.pinguo.repository2020.database.makeup;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: MaterialItemDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface c {
    @Query("select * from material_item where packageId =:packageId")
    List<MaterialItemTable> a(String str);

    @Query("delete from material_item where packageId in (:materialDetailIds)")
    void b(List<String> list);

    @Insert(onConflict = 1)
    void c(List<MaterialItemTable> list);

    @Query("select * from material_item")
    List<MaterialItemTable> getAll();
}

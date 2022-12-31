package us.pinguo.repository2020.database.makeup;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;
/* compiled from: MaterialDetailDao.kt */
@Dao
/* loaded from: classes6.dex */
public interface a {
    @Insert(onConflict = 1)
    void a(MaterialDetailTable... materialDetailTableArr);

    @Query("select * from material_detail where id =:id")
    MaterialDetailTable b(String str);

    @Query("delete from material_detail where id in (:materialDetailIds)")
    void c(List<String> list);

    @Query("select * from material_detail")
    List<MaterialDetailTable> getAll();
}

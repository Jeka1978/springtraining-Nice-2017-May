package qualifiers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

import static qualifiers.DBType.ORACLE;

/**
 * Created by Evegeny on 19/06/2017.
 */

@NiceRepo(ORACLE)
public class BackupDao implements Dao {
    @Override
    @SneakyThrows
    public void save() {
        System.out.println("saving to Oracle");
        Thread.sleep(50);
    }
}

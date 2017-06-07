package myspring;

import lombok.Data;

/**
 * Created by Evegeny on 07/06/2017.
 */
@Data
public class BenchmarkFlag implements BenchmarkFlagMBean {
    private boolean enabled = true;
}

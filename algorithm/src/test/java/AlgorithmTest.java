import com.universe.AlgorithmApplication;
import com.example.design.strategy.Context;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AlgorithmApplication.class)
public class AlgorithmTest {

    @Autowired
    Context context;

    @Test
    public void test(){
        context.strategyMethod("tang");
    }
}

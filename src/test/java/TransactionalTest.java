import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TransactionalTest {
    public int a = 5;


    @Test
    @Transactional(rollbackForClassName="RuntimeException")
    public void transactionalTest() {
        a++;
        if(true){
            throw new RuntimeException();
        }
    }

    @AfterTest
    public void speak(){
        System.out.println(a);
    }

}

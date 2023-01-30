import com.example.BankService;

public class BankServiceImpl implements BankService {

    boolean payIsCalled = false;
    @Override
    public void pay(String id, double amount) {
        payIsCalled = true;
    }
}



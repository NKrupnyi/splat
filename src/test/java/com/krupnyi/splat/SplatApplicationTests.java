package com.krupnyi.splat;

import com.krupnyi.splat.repositories.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SplatApplicationTests {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void test1() {
        accountRepository.getAmount(5);
    }

    @Test
    public void test2() {
        accountRepository.addAmount(2, 400L);
        accountRepository.addAmount(7, 400L);
        accountRepository.addAmount(3, 400L);
        accountRepository.addAmount(3, 410L);
    }


}

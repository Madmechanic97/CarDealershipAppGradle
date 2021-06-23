package com.sky.carDealershipApplication;

import com.sky.carDealershipApplication.Service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CarTests {

    @Autowired
    private CarService carService;

    @Test
    public void test_ThatACarCanBePersisted()

}

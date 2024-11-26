package com.sushavi.stats;

import com.sushavi.stats.controller.PlayerController;
import com.sushavi.stats.service.PlayerService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = StatsApplication.class)
public class ContractVerifierBaseClass {

    @Autowired
    PlayerController playerController;

    @MockBean
    PlayerService playerService;

    @BeforeEach
    public void setup(){
        RestAssuredMockMvc.standaloneSetup(playerController);
        Mockito.when(playerService.getPlayers())
                .thenReturn(TestDataCreator.getInstance().getMockedPlayer());
    }
}

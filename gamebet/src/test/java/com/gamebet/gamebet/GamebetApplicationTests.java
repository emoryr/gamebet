package com.gamebet.gamebet;

import com.gamebet.gamebet.controller.GameBetController;
import com.gamebet.gamebet.service.GameBetService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameBetController.class)
public class GamebetApplicationTests {

    @MockBean
    private GameBetService gameBetService;

    /**
     * Injected object to do actions on that endpoint.
     */
    @Autowired
    private MockMvc mvc;

    /**
     * Logger class.
     */
    private static final Log logger = LogFactory.getLog(GameBetController.class);

    @Test
    public void testBet() throws Exception {
        logger.info("Perform status not found");
        MvcResult mvcResult = this.mvc.perform(get("/bet"))
                .andExpect(status().isFound()).andReturn();
        logger.info("Perform status ok");
        Assert.assertTrue(mvcResult.getResponse().getContentAsString().contains("You won"));
    }

}

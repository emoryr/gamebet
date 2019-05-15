package com.gamebet.gamebet;

import com.gamebet.gamebet.controller.GameBetController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GameBetController.class)
public class GamebetApplicationTests {

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
        this.mvc.perform(get("/bet"))
                .andExpect(status().isFound());
        logger.info("Perform status ok");
    }

}

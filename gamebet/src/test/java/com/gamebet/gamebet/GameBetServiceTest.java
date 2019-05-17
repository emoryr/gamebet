package com.gamebet.gamebet;

import com.gamebet.gamebet.dto.Player;
import com.gamebet.gamebet.dto.PlayerRepository;
import com.gamebet.gamebet.service.GameBetService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameBetServiceTest {

    @Autowired
    PlayerRepository playerRepository;

    /**
     * Logger class.
     */
    private static final Log logger = LogFactory.getLog(GameBetService.class);

    @Test
    public void testSave() throws Exception {
        logger.info("Perform save");
        Player player = new Player();
        player.setName("Emory Freitas");
        player.setCoins(500);

        playerRepository.save(player);
        Assert.assertNotNull(playerRepository.findById(2L));
    }

    @Test
    public void testLoad() throws Exception {
        Assert.assertNotNull(playerRepository.findById(1L));
    }

    @Before
    public void init() {
        Player player = new Player();
        player.setName("Emory Freitas");
        player.setCoins(500);

        playerRepository.save(player);
    }
}

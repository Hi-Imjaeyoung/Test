import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MahjongGameTest {
    @Test
    void check_My_Hand(){
        MahjongGame game = new MahjongGame();
        System.out.println(game.showMyHands());
    }
}
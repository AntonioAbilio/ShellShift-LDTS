package com.l06g06.shellshift.controller.game;

import com.l06g06.shellshift.Game;
import com.l06g06.shellshift.controller.game.elements.BulletController;
import com.l06g06.shellshift.gui.Gui;
import com.l06g06.shellshift.model.game.elements.Bullet;
import com.l06g06.shellshift.model.game.elements.Chell;
import com.l06g06.shellshift.model.game.elements.Position;
import com.l06g06.shellshift.model.game.elements.enemies.Enemy;
import com.l06g06.shellshift.model.game.elements.enemies.HardMonster;
import com.l06g06.shellshift.model.game.elements.enemies.SoftMonster;
import com.l06g06.shellshift.model.game.elements.enemies.moveStrategies.MoveStrategy;
import com.l06g06.shellshift.model.game.gun.FireStrategy;
import com.l06g06.shellshift.model.game.gun.Gun;
import com.l06g06.shellshift.model.game.gun.NormalFireStrategy;
import com.l06g06.shellshift.model.game.map.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class BulletControllerTest {
        private Map map ;
        private FireStrategy fireStrategy;
        private List<Bullet> bullets;
        private BulletController bulletController;
        private Game game;


        @BeforeEach
        public void setup(){
            this.map = mock(Map.class);
            this.bullets = new ArrayList<>();
            this.fireStrategy = mock(FireStrategy.class);
            this.game = mock(Game.class);
            this.bulletController = new BulletController(map);

            Bullet bullet1 = new Bullet(new Position(1,  0));
            Bullet bullet2 = new Bullet(new Position(5, 5));
            Bullet bullet3 = new Bullet(new Position(2, 9));
            bullet1.setDirection(true); // right
            bullet2.setDirection(false); // left
            bullet3.setDirection(true); // right
            bullet1.setDamageMultiplier(1);
            bullet1.setDamageMultiplier(1);
            bullet1.setDamageMultiplier(1);
            bullets.add(bullet1);
            bullets.add(bullet2);
            bullets.add(bullet3);
            Mockito.when(map.getBullets()).thenReturn(bullets);
        }

        @Test
        public void bulletUpdateTest(){
            bulletController.bulletUpdate();
            Assertions.assertEquals(new Position(4, 0), bullets.get(0).getPosition());
            Assertions.assertEquals(new Position(2, 5), bullets.get(1).getPosition());
            Assertions.assertEquals(new Position(5, 9), bullets.get(2).getPosition());
        }

        @Test
        public void bulletCollisionTest(){
            List<Enemy> enemies = new ArrayList<>();
            MoveStrategy mockedMoveStrategy = mock(MoveStrategy.class);
            Enemy enemy1 = new SoftMonster(new Position(-12,  -13), mockedMoveStrategy);
            Enemy enemy2 = new HardMonster(new Position(16, 5), mockedMoveStrategy);
            Enemy enemy3 = new SoftMonster(new Position(32, 9), mockedMoveStrategy);
            enemies.add(enemy1);
            enemies.add(enemy2);
            enemies.add(enemy3);
            Mockito.when(map.getEnemies()).thenReturn(enemies);

            System.out.println(enemies.get(0).getHP());
            Assertions.assertEquals(3, bullets.size());
            Assertions.assertEquals(3, enemies.size());
            bulletController.bulletCollision();
            Assertions.assertEquals(2, bullets.size());
            Assertions.assertEquals(2, enemies.size());
            System.out.println(enemies.get(0).getHP());

            verify(map, times(1)).addMonsterKilled();
            verify(map, times(1)).setScore(eq(map.getScore() + enemy1.getScore()));
        }

        @Test
        public void fireTest(){
            map = new Map();
            bulletController = new BulletController(map);
            NormalFireStrategy normalFireStrategy = new NormalFireStrategy();
            Gun gun = new Gun(normalFireStrategy, 2);
            map.setGun(gun);
            double reloadTime = gun.getReloadTime();
            long fireTime = (long) (4000 + reloadTime);

            map.setChell(new Chell(new Position(20, 10)));
            bulletController.setReloadStartTime(0);

            Assertions.assertEquals(2, map.getGun().getNumBullets());
            Assertions.assertEquals(0, bulletController.getReloadStartTime());

            List<Gui.PressedKey> actions = Arrays.asList(Gui.PressedKey.FIRE);

            Assertions.assertEquals(0, map.getBullets().size());
            bulletController.step(game, actions, fireTime); // fire() has to be tested through step since it is private
            Assertions.assertEquals(1, map.getBullets().size());
        }

        @Test
        void removeOutOfBoundsBulletsTest(){
            // boundary analysis
            bullets.add(new Bullet(new Position(-400, 5)));
            bullets.add(new Bullet(new Position(-4, 5)));
            bullets.add(new Bullet(new Position(-5, 8)));
            bullets.add(new Bullet(new Position(-6, -6)));
            bullets.add(new Bullet(new Position(189, 100)));
            bullets.add(new Bullet(new Position(190, 100)));
            bullets.add(new Bullet(new Position(191, 100)));
            bullets.add(new Bullet(new Position(200, 10)));

            Assertions.assertEquals(11, map.getBullets().size());
            bulletController.removeOutOfBoundsBullets();
            Assertions.assertEquals(7, map.getBullets().size());
        }
}

